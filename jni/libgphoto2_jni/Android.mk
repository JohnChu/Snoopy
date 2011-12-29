LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := gphoto2_wrap.c

LOCAL_C_INCLUDES += \
	$(TOP)/libgphoto2 \
	$(TOP)/libgphoto2/libgphoto2_port

LOCAL_SHARED_LIBRARIES := \
	libgphoto2 \
	libgphoto2_port

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC -fno-strict-aliasing

LOCAL_CFLAGS += -D_GPHOTO2_INTERNAL_CODE

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_MODULE := libgphoto2_jni

LP1 := $(LOCAL_PATH)

include $(BUILD_SHARED_LIBRARY)

$(cleantarget)::
	@echo "	Removing generated files"
	$(hide) rm -f $(LP1)/gphoto2_wrap.c
	$(hide) rm -rf $(TOP)/../src/swig
