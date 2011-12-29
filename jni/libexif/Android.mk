LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES:= \
	libexif/exif-byte-order.c \
	libexif/exif-content.c \
	libexif/exif-data.c \
	libexif/exif-entry.c \
	libexif/exif-format.c \
	libexif/exif-ifd.c \
	libexif/exif-loader.c \
	libexif/exif-log.c \
	libexif/exif-mem.c \
	libexif/exif-mnote-data.c \
	libexif/exif-tag.c \
	libexif/exif-utils.c \
	libexif/canon/exif-mnote-data-canon.c \
	libexif/canon/mnote-canon-entry.c \
	libexif/canon/mnote-canon-tag.c \
	libexif/fuji/exif-mnote-data-fuji.c \
	libexif/fuji/mnote-fuji-entry.c \
	libexif/fuji/mnote-fuji-tag.c \
	libexif/olympus/exif-mnote-data-olympus.c \
	libexif/olympus/mnote-olympus-entry.c \
	libexif/olympus/mnote-olympus-tag.c \
	libexif/pentax/exif-mnote-data-pentax.c \
	libexif/pentax/mnote-pentax-entry.c \
	libexif/pentax/mnote-pentax-tag.c


LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/libexif \
	$(LOCAL_PATH)/libexif/canon \
	$(LOCAL_PATH)/libexif/fuji \
	$(LOCAL_PATH)/libexif/olympus \
	$(LOCAL_PATH)/libexif/pentax

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC
LOCAL_CFLAGS += -DGETTEXT_PACKAGE=\"libexif-12\"

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

ifneq ($(BUILD_CONF),minimal)
	LOCAL_C_INCLUDES += $(TOP)/libiconv
	LOCAL_CFLAGS += -DHAVE_ICONV
	LOCAL_SHARED_LIBRARIES += libiconv
endif

LOCAL_MODULE:= libexif2

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)
