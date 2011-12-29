LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
	config.c \
	library.c \
	ptp.c \
	ptpip.c \
	usb.c

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/../.. \
	$(LOCAL_PATH)/../../libgphoto2 \
	$(LOCAL_PATH)/../../libgphoto2_port \
	$(TOP)/libexif


LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_CFLAGS += -D_GPHOTO2_INTERNAL_CODE

LOCAL_SHARED_LIBRARIES := libexif2 libgphoto2 libgphoto2_port

ifneq ($(BUILD_CONF),minimal)
	LOCAL_C_INCLUDES += $(TOP)/libiconv/include
	LOCAL_SHARED_LIBRARIES += libiconv
	LOCAL_CFLAGS += -DHAVE_ICONV
endif

LOCAL_MODULE := ptp2

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)
