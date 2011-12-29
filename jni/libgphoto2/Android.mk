LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
	libgphoto2/ahd_bayer.c \
	libgphoto2/bayer.c \
	libgphoto2/exif.c \
	libgphoto2/gamma.c \
	libgphoto2/gphoto2-abilities-list.c \
	libgphoto2/gphoto2-camera.c \
	libgphoto2/gphoto2-context.c \
	libgphoto2/gphoto2-file.c \
	libgphoto2/gphoto2-filesys.c \
	libgphoto2/gphoto2-list.c \
	libgphoto2/gphoto2-result.c \
	libgphoto2/gphoto2-setting.c \
	libgphoto2/gphoto2-version.c \
	libgphoto2/gphoto2-widget.c \
	libgphoto2/jpeg.c \

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/libgphoto2_port \
	$(TOP)/libltdl \
	$(TOP)/libexif

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

# todo: correct path
# LOCAL_CPPFLAGS += -DIOLIBS=/system/lib
LOCAL_CFLAGS += \
	-DIOLIBS=\"/data/data/$(PACKAGE_NAME)/lib\" \
	-DCAMLIBS=\"/data/data/$(PACKAGE_NAME)/lib\" \
	-D_GPHOTO2_INTERNAL_CODE \
	-DHAVE_LIBEXIF \
	-DHAVE_LIBEXIF_IFD

LOCAL_SHARED_LIBRARIES := libltdl libexif2 libgphoto2_port

LOCAL_MODULE := libgphoto2

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)

LP0 := $(LOCAL_PATH)
#include $(call all-subdir-makefiles)
include $(LP0)/libgphoto2_port/Android.mk

include $(LP0)/camlibs/canon/Android.mk
include $(LP0)/camlibs/casio/Android.mk
include $(LP0)/camlibs/fuji/Android.mk
include $(LP0)/camlibs/kodak/dc120/Android.mk
include $(LP0)/camlibs/kodak/dc210/Android.mk
include $(LP0)/camlibs/kodak/dc240/Android.mk
include $(LP0)/camlibs/kodak/dc3200/Android.mk
include $(LP0)/camlibs/kodak/ez200/Android.mk
include $(LP0)/camlibs/konica/Android.mk
include $(LP0)/camlibs/ptp2/Android.mk
