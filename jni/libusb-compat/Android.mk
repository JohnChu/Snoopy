
LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES:= \
	libusb/core.c \


LOCAL_C_INCLUDES += $(LOCAL_PATH)/android \
	$(LOCAL_PATH)/libusb \
	$(LOCAL_PATH)/../libusb/libusb

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC


LOCAL_SHARED_LIBRARIES := libusb2


ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_MODULE:= libusb-compat

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)
