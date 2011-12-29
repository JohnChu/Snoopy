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

import swig.org.gphoto2.CameraAbilities;
import swig.org.gphoto2.SWIGTYPE_p_p__CameraAbilitiesList;
import swig.org.gphoto2._CameraAbilitiesList;
import swig.org.gphoto2.gphoto2;

/**
 * Camera abilities list implementation.
 *
 * @author <a href="mailto:konstantin.sobolev@gmail.com" title="">Konstantin Sobolev</a>
 */
public class CameraAbilitiesListImpl implements CameraAbilitiesList {
	private final SWIGTYPE_p_p__CameraAbilitiesList pp;
	private final _CameraAbilitiesList cal;

	private CameraAbilitiesListImpl() {
		pp = gphoto2.create_null_p_p__CameraAbilitiesList();
		GPhoto2Exception.checkCode(gphoto2.gp_abilities_list_new(pp));
		cal = gphoto2.dereference_p_p__CameraAbilitiesList(pp);
	}

	public static CameraAbilitiesList createNew() {
		return CloseableWrapper.wrap(CameraAbilitiesList.class, new CameraAbilitiesListImpl());
	}

	public void load(final Context ctx) {
		GPhoto2Exception.checkCode(gphoto2.gp_abilities_list_load(cal, ctx.getGPContext()));
	}

	public int size() {
		return gphoto2.gp_abilities_list_count(cal);
	}

	public CameraAbilities getCameraAbilities(final int idx) {
		final CameraAbilities res = new CameraAbilities();
		GPhoto2Exception.checkCode(gphoto2.gp_abilities_list_get_abilities(cal, idx, res));
		return res;
	}

	public _CameraAbilitiesList get_CameraAbilitiesList() {
		return cal;
	}

	public void close() {
		gphoto2.gp_abilities_list_free(cal);
		gphoto2.delete_p_p__CameraAbilitiesList(pp);
	}
}
