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

import swig.org.gphoto2.GPPortInfo;
import swig.org.gphoto2.SWIGTYPE_p_p__GPPortInfoList;
import swig.org.gphoto2._GPPortInfoList;
import swig.org.gphoto2.gphoto2;

/**
 * Port info list implementation.
 *
 * @author <a href="mailto:konstantin.sobolev@gmail.com" title="">Konstantin Sobolev</a>
 */
public class PortInfoListImpl implements PortInfoList {
	private final SWIGTYPE_p_p__GPPortInfoList pp;
	private final _GPPortInfoList pil;

	private PortInfoListImpl() {
		pp = gphoto2.create_null_p_p__GPPortInfoList();
		GPhoto2Exception.checkCode(gphoto2.gp_port_info_list_new(pp));
		pil = gphoto2.dereference_p_p__GPPortInfoList(pp);
	}

	public static PortInfoList createNew() {
		return CloseableWrapper.wrap(PortInfoList.class, new PortInfoListImpl());
	}

	public void load() {
		GPhoto2Exception.checkCode(gphoto2.gp_port_info_list_load(pil));
	}

	public int size() {
		return gphoto2.gp_port_info_list_count(pil);
	}

	public GPPortInfo getPortInfo(final int index) {
		final GPPortInfo res = new GPPortInfo();
		GPhoto2Exception.checkCode(gphoto2.gp_port_info_list_get_info(pil, index, res));
		return res;
	}

	public _GPPortInfoList get_GPPortInfoList() {
		return pil;
	}

	public void close() {
		gphoto2.gp_port_info_list_free(pil);
		gphoto2.delete_p_p__GPPortInfoList(pp);
	}
}
