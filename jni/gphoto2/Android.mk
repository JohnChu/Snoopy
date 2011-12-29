LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
	gphoto2/actions.c \
	gphoto2/foreach.c \
	gphoto2/gp-params.c \
	gphoto2/gphoto2-cmd-capture.c \
	gphoto2/main.c \
	gphoto2/range.c \
	gphoto2/shell.c \
	gphoto2/spawnve.c \
	gphoto2/version.c

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/gphoto2 \
	$(TOP)/libgphoto2 \
	$(TOP)/libgphoto2/libgphoto2_port \
	$(TOP)/libexif \
	$(TOP)/aalib/src \
	$(TOP)/libpopt \
	$(TOP)/libjpeg

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

# don't know why it doesn't read it from config.h...
LOCAL_CFLAGS += -DHAVE_LIBEXIF_LOG -DHAVE_POPT -DHAVE_AA -DHAVE_JPEG
LOCAL_CFLAGS += -DSTDIN_FILENO=\"0\"
LOCAL_CFLAGS += -DSTDOUT_FILENO=\"1\"
LOCAL_CFLAGS += -D_GPHOTO2_INTERNAL_CODE

LOCAL_SHARED_LIBRARIES := \
	libgphoto2 \
	libgphoto2_port \
	libexif2 \
	aalib \
	libpopt \
	libltdl \
	libregex \
	libjpeg2

# can't name it gphoto2 because NDK thinks it clashes with libgphoto2
LOCAL_MODULE := gphoto

LOCAL_PRELINK_MODULE := false
include $(BUILD_EXECUTABLE)
