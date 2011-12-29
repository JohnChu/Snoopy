#!/bin/bash
if [ -z "$NDK_ROOT" ]; then
	NDK_ROOT=/home/kos/work/android/android-ndk-r4b
fi

PACKAGE_NAME=$( cat AndroidManifest.xml | grep package | sed -e 's/ *package=\"\(.*\)\"/\1/' )

if [[ $1 != "clean" ]]; then
	# generate libgphoto2 java bindings
	type -P swig &>/dev/null || { echo "swig not found. Install it from www.swig.org" >&2; exit 1; }
	mkdir -p src/swig/org/gphoto2

	if ( [[ ! -e jni/libgphoto2_jni/gphoto2_wrap.c ]] || \
		 [[ jni/libgphoto2_jni/gphoto2_wrap.c -ot jni/libgphoto2_jni/gphoto2.i ]] ); then
		swig -Ijni/libgphoto2 -Ijni/libgphoto2/libgphoto2_port -java -package swig.org.gphoto2 -outdir src/swig/org/gphoto2 jni/libgphoto2_jni/gphoto2.i || exit -1
		sed -i -i 's/TRUE = (0==0)/TRUE = 1/' src/swig/org/gphoto2/gphoto2Constants.java || exit -1
		sed -i -i 's/FALSE = (1==0)/FALSE = 0/' src/swig/org/gphoto2/gphoto2Constants.java || exit -1
	fi
fi

PACKAGE_NAME=$PACKAGE_NAME $NDK_ROOT/ndk-build $@ || exit -1
if [[ $1 == "clean" ]]; then
	ant clean
fi
if [ -z "$@" ]; then ant debug; fi
