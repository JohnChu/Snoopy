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

import swig.org.gphoto2.SWIGTYPE_p__CameraList;
import swig.org.gphoto2.SWIGTYPE_p_p__CameraList;
import swig.org.gphoto2.SWIGTYPE_p_p_char;
import swig.org.gphoto2.gphoto2;

/**
 * Camera list implementation.
 *
 * @author <a href="mailto:konstantin.sobolev@gmail.com" title="">Konstantin Sobolev</a>
 */
public class CameraListImpl implements CameraList {
	private final SWIGTYPE_p_p__CameraList pp;
	private final SWIGTYPE_p__CameraList pClist;

	private CameraListImpl() {
		pp = gphoto2.create_null_p_p__CameraList();
		GPhoto2Exception.checkCode(gphoto2.gp_list_new(pp));
		pClist = gphoto2.dereference_p_p__CameraList(pp);
	}

	public static CameraList createNew() {
		return CloseableWrapper.wrap(CameraList.class, new CameraListImpl());
	}

	public int size() {
		return gphoto2.gp_list_count(pClist);
	}

	public void detect(final CameraAbilitiesList abilitiesList, final PortInfoList portInfoList, final Context context) {
		GPhoto2Exception.checkCode(
				gphoto2.gp_abilities_list_detect(
						abilitiesList.get_CameraAbilitiesList(),
						portInfoList.get_GPPortInfoList(),
						pClist, context.getGPContext()
				)
		);
	}

	public String getCameraName(final int idx) {
		final SWIGTYPE_p_p_char ppchar = gphoto2.create_null_p_p__char();
		GPhoto2Exception.checkCode(gphoto2.gp_list_get_name(pClist, idx, ppchar));
		final String res = gphoto2.dereference_p_p__char(ppchar);
		gphoto2.delete_p_p__char(ppchar);
		return res;
	}

	public String getCameraPortPath(final int idx) {
		final SWIGTYPE_p_p_char ppchar = gphoto2.create_null_p_p__char();
		GPhoto2Exception.checkCode(gphoto2.gp_list_get_value(pClist, idx, ppchar));
		final String res = gphoto2.dereference_p_p__char(ppchar);
		gphoto2.delete_p_p__char(ppchar);
		return res;
	}

	public void close() {
		gphoto2.gp_list_free(pClist);
		gphoto2.delete_p_p__CameraList(pp);
	}
}
