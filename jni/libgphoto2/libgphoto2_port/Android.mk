LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
	libgphoto2_port/gphoto2-port-info-list.c \
	libgphoto2_port/gphoto2-port-log.c \
	libgphoto2_port/gphoto2-port-portability.c \
	libgphoto2_port/gphoto2-port-result.c \
	libgphoto2_port/gphoto2-port-version.c \
	libgphoto2_port/gphoto2-port.c

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/../gphoto2 \
	$(TOP)/libltdl \
	$(TOP)/libregex

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

# todo: correct path
# LOCAL_CPPFLAGS += -DIOLIBS=/system/lib
LOCAL_CFLAGS += \
	-DIOLIBS=\"/data/data/$(PACKAGE_NAME)/lib\" \
	-D_GPHOTO2_INTERNAL_CODE

LOCAL_SHARED_LIBRARIES := libltdl libregex

LOCAL_MODULE := libgphoto2_port

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)

LP := $(LOCAL_PATH)
include $(LP)/usb/Android.mk
include $(LP)/ptpip/Android.mk
ifneq ($(BUILD_CONF),minimal)
	include $(LP)/usbdiskdirect/Android.mk
	# include $(LP)/usbscsi/Android.mk no scsi on android
	include $(LP)/disk/Android.mk
	# include $(LP)/serial/Android.mk  no tcdrain in android's termios
endif
