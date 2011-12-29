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

import swig.org.gphoto2.gphoto2Constants;

/**
 * GPhoto2 error codes
 *
 * @author <a href="mailto:konstantin.sobolev@gmail.com" title="">Konstantin Sobolev</a>
 */
public enum ErrorCode {
	GP_OK(gphoto2Constants.GP_OK),
	GP_ERROR(gphoto2Constants.GP_ERROR),
	GP_ERROR_BAD_PARAMETERS(gphoto2Constants.GP_ERROR_BAD_PARAMETERS),
	GP_ERROR_NO_MEMORY(gphoto2Constants.GP_ERROR_NO_MEMORY),
	GP_ERROR_LIBRARY(gphoto2Constants.GP_ERROR_LIBRARY),
	GP_ERROR_UNKNOWN_PORT(gphoto2Constants.GP_ERROR_UNKNOWN_PORT),
	GP_ERROR_NOT_SUPPORTED(gphoto2Constants.GP_ERROR_NOT_SUPPORTED),
	GP_ERROR_IO(gphoto2Constants.GP_ERROR_IO),
	GP_ERROR_FIXED_LIMIT_EXCEEDED(gphoto2Constants.GP_ERROR_FIXED_LIMIT_EXCEEDED),
	GP_ERROR_TIMEOUT(gphoto2Constants.GP_ERROR_TIMEOUT),
	GP_ERROR_IO_SUPPORTED_SERIAL(gphoto2Constants.GP_ERROR_IO_SUPPORTED_SERIAL),
	GP_ERROR_IO_SUPPORTED_USB(gphoto2Constants.GP_ERROR_IO_SUPPORTED_USB),
	GP_ERROR_IO_INIT(gphoto2Constants.GP_ERROR_IO_INIT),
	GP_ERROR_IO_READ(gphoto2Constants.GP_ERROR_IO_READ),
	GP_ERROR_IO_WRITE(gphoto2Constants.GP_ERROR_IO_WRITE),
	GP_ERROR_IO_UPDATE(gphoto2Constants.GP_ERROR_IO_UPDATE),
	GP_ERROR_IO_SERIAL_SPEED(gphoto2Constants.GP_ERROR_IO_SERIAL_SPEED),
	GP_ERROR_IO_USB_CLEAR_HALT(gphoto2Constants.GP_ERROR_IO_USB_CLEAR_HALT),
	GP_ERROR_IO_USB_FIND(gphoto2Constants.GP_ERROR_IO_USB_FIND),
	GP_ERROR_IO_USB_CLAIM(gphoto2Constants.GP_ERROR_IO_USB_CLAIM),
	GP_ERROR_IO_LOCK(gphoto2Constants.GP_ERROR_IO_LOCK),
	GP_ERROR_HAL(gphoto2Constants.GP_ERROR_HAL),
	GP_ERROR_CORRUPTED_DATA(gphoto2Constants.GP_ERROR_CORRUPTED_DATA),
	GP_ERROR_FILE_EXISTS(gphoto2Constants.GP_ERROR_FILE_EXISTS),
	GP_ERROR_MODEL_NOT_FOUND(gphoto2Constants.GP_ERROR_MODEL_NOT_FOUND),
	GP_ERROR_DIRECTORY_NOT_FOUND(gphoto2Constants.GP_ERROR_DIRECTORY_NOT_FOUND),
	GP_ERROR_FILE_NOT_FOUND(gphoto2Constants.GP_ERROR_FILE_NOT_FOUND),
	GP_ERROR_DIRECTORY_EXISTS(gphoto2Constants.GP_ERROR_DIRECTORY_EXISTS),
	GP_ERROR_CAMERA_BUSY(gphoto2Constants.GP_ERROR_CAMERA_BUSY),
	GP_ERROR_PATH_NOT_ABSOLUTE(gphoto2Constants.GP_ERROR_PATH_NOT_ABSOLUTE),
	GP_ERROR_CANCEL(gphoto2Constants.GP_ERROR_CANCEL),
	GP_ERROR_CAMERA_ERROR(gphoto2Constants.GP_ERROR_CAMERA_ERROR),
	GP_ERROR_OS_FAILURE(gphoto2Constants.GP_ERROR_OS_FAILURE),
	GP_ERROR_NO_SPACE(gphoto2Constants.GP_ERROR_NO_SPACE);

	private final int code;

	ErrorCode(final int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static ErrorCode findByCode(final int code) {
		final ErrorCode[] errorCodes = ErrorCode.values();
		for (final ErrorCode errorCode : errorCodes) {
			if (errorCode.code == code)
				return errorCode;
		}
		return null;
	}
}
