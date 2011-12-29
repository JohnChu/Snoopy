LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := linux.c

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/.. \
	$(LOCAL_PATH)/../../gphoto2 \
	$(TOP)/libusb-compat/libusb

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_CFLAGS += -D_GPHOTO2_INTERNAL_CODE

LOCAL_SHARED_LIBRARIES := libusb-compat libgphoto2_port

LOCAL_MODULE := usbscsi

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)
