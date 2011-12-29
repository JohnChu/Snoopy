/*
 * Copyright (c) 2010 Konstantin Sobolev. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY KONSTANTIN SOBOLEV ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL KONSTANTIN SOBOLEV OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.kos.agphoto2.api;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/**
 * Dynamic proxy around <code>Closeable</code> instances that (a) checks that there are no method calls
 * after close was invoked and (b) closes a resource from <code>finalize</code> and logs a warning about
 * unclosed resource.
 *
 * @author <a href="mailto:konstantin.sobolev@gmail.com" title="">Konstantin Sobolev</a>
 */
public final class CloseableWrapper {
	private CloseableWrapper() {}

	static <T extends Closeable, I extends T> T wrap(final Class<T> ifaceCls, final I impl) {
		//noinspection unchecked
		return (T) Proxy.newProxyInstance(impl.getClass().getClassLoader(),
				new Class[]{ifaceCls}, new CloseableProxy(impl));
//		return impl;
	}

	public static <T> T withCloseable(final Callable<T> code, final Closeable... cs) {
		try {
			return code.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			for (final Closeable c : cs) {
				try {
					c.close();
				} catch (Exception e) {
					System.err.println("Error closing " + c + ": " + e);
					e.printStackTrace();
				}
			}
		}
	}

	private static class CloseableProxy implements InvocationHandler {
		private final WeakHashMap<Object, Boolean> closed = new WeakHashMap<Object, Boolean>();
		final Object impl;
		final Class<?>[] interfaces;

		private CloseableProxy(final Object impl) {
			this.impl = impl;
			interfaces = impl.getClass().getInterfaces();
		}

		public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
			final Class<?> declaringClass = method.getDeclaringClass();

//			Log.i("CloseableWrapper.Proxy", "method " + method.getName() + " from: " + declaringClass);

			if (declaringClass.equals(Object.class))
				return forward(method, args);

			boolean declaredByIface = false;
			for (final Class<?> iface : interfaces) {
				if (declaringClass.equals(iface)) {
					declaredByIface = true;
					break;
				}
			}
			if (!declaredByIface)
				return forward(method, args);

			final boolean isCloseMethod = args.length == 0 && "close".equals(method.getName());
			final boolean alreadyClosed;
			synchronized (closed) {
				alreadyClosed = unbox(closed.get(impl));
			}

			if (isCloseMethod) {
				try {
					if (!alreadyClosed)
						return forward(method, args);
				} finally {
					synchronized (closed) {
						closed.put(impl, Boolean.TRUE);
					}
				}
			}

			final boolean isFinalizeMethod = args.length == 0 && "finalize".equals(method.getName());
			if (isFinalizeMethod) {
				if (!alreadyClosed) {
					final Class<?> cls = impl.getClass();
					Log.w("CloseableWrapper", "Closing an instance for you: " + impl + ", cls: " + cls.getName());
					final Method close = cls.getMethod("close");
					close.invoke(impl);
					synchronized (closed) {
						closed.put(impl, Boolean.TRUE);
					}
				}
				return forward(method, args);
			}

			if (alreadyClosed) {
				throw new RuntimeException("Attempt to call " + method.getName() + " on an already closed instance " +
				                           impl + " (" + impl.getClass().getName() + ")");
			}

			return forward(method, args);
		}

		private Object forward(final Method method, final Object[] args) throws Throwable {
			try {
				return method.invoke(impl, args);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		}


		private boolean unbox(final Boolean b) {
			return b != null && b;
		}
	}
}
