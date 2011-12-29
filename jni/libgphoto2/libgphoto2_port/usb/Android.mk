LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
	libusb.c \
	check-mtp-device.c

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

LOCAL_MODULE := usb

LOCAL_PRELINK_MODULE := false
# failed attempt to fool NDK into naming it 'usb' instead of 'libusb'
# shared-library-path = $(TARGET_OUT)/$1.so
include $(BUILD_SHARED_LIBRARY)
# shared-library-path = $(TARGET_OUT)/lib$1.so
