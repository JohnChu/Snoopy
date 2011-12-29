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

package com.kos.agphoto2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.kos.agphoto2.api.*;
import swig.org.gphoto2.CameraAbilities;
import swig.org.gphoto2.GPPortInfo;

import java.util.concurrent.Callable;

/**
 * Just something to start with.. detect a camera and print some info.
 *
 * @author <a href="mailto:konstantin.sobolev@gmail.com" title="">Konstantin Sobolev</a>
 */
public class DetectCameraActivity extends Activity {
	static {
		LibrariesHelper.loadNativeLibraries();
	}

	private Context c;
	private ProgressDialog pd;
	private Handler h;

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detect_camera);
//		getPanel().setMovementMethod(new ScrollingMovementMethod());
		h = new Handler() {
			@Override
			public void handleMessage(final Message msg) {
				if (msg.obj instanceof String) {
					final String s = (String) (msg.obj);
					getPanel().setText(s);
					getPanel().scrollTo(0, 0);
				}
				pd.dismiss();
			}
		};

		c = ContextImpl.createNew();

		findViewById(R.id.list_ports).setOnClickListener(new View.OnClickListener() {
			public void onClick(final View v) {
				listPorts();
			}
		});

		findViewById(R.id.list_cameras).setOnClickListener(new View.OnClickListener() {
			public void onClick(final View v) {
				listCameras();
			}
		});

		findViewById(R.id.detect).setOnClickListener(new View.OnClickListener() {
			public void onClick(final View v) {
				detectCamera();
			}
		});
	}

	private void listPorts() {
		final PortInfoList pl = PortInfoListImpl.createNew();
		final Callable<String> code = new Callable<String>() {
			public String call() throws Exception {
				pl.load();
				final int size = pl.size();
				final StringBuilder sb = new StringBuilder(size + " ports supported\n");
				for (int i = 0; i < size; i++) {
					final GPPortInfo portInfo = pl.getPortInfo(i);
					sb.append(portInfo.getName()).append("  ").append(portInfo.getPath()).append('\n');
				}
				return sb.toString();
			}
		};
		runAsyncWithCloseablesAndShowResult("Detecting Ports", "Detecting supported ports", code, pl);
	}

	private void listCameras() {
		final CameraAbilitiesList cal = CameraAbilitiesListImpl.createNew();
		final Callable<String> code = new Callable<String>() {
			public String call() throws Exception {
				cal.load(c);
				final int size = cal.size();
				final StringBuilder sb = new StringBuilder(size + " cameras supported\n");
				for (int i = 0; i < size; i++) {
					final CameraAbilities cameraAbilities = cal.getCameraAbilities(i);
					sb.append(cameraAbilities.getModel()).append('\n');
				}
				return sb.toString();
			}
		};
		runAsyncWithCloseablesAndShowResult("Listing Cameras", "Listing supported camera types", code, cal);
	}

	private void detectCamera() {
		final PortInfoList pl = PortInfoListImpl.createNew();
		final CameraAbilitiesList cal = CameraAbilitiesListImpl.createNew();
		final CameraList cl = CameraListImpl.createNew();
		final Callable<String> code = new Callable<String>() {
			public String call() throws Exception {
				pl.load();
				cal.load(c);
				cl.detect(cal, pl, c);
				final int size = cl.size();
				final StringBuilder sb = new StringBuilder("Detected " + size + " camera(s)\n");
				for (int i = 0; i < size; i++) {
					final String n = cl.getCameraName(i);
					final String portPath = cl.getCameraPortPath(i);
					sb.append(portPath).append("  ").append(n).append('\n');
				}
				return sb.toString();
			}
		};
		runAsyncWithCloseablesAndShowResult("Detecting Camera", "Detecting connected camera", code, cl, cal, pl);
	}

	private TextView getPanel() {
		return (TextView) findViewById(R.id.detect_text);
	}

	private void runAsyncWithCloseablesAndShowResult(final String title, final String msg, final Callable<String> code, final Closeable... cls) {
		pd = ProgressDialog.show(this, title, msg, true, false);
		new Thread(new Runnable() {
			public void run() {
				final String res = CloseableWrapper.withCloseable(code, cls);
				final Message message = new Message();
				message.obj = res;
				h.sendMessage(message);
			}
		}).start();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		c.close();
	}
}
