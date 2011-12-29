
LOCAL_PATH:= $(call my-dir)

# LOCAL_ARM_MODE := arm
# 
# LOCAL_CFLAGS += -DHAVE_CONFIG_H
# LOCAL_CFLAGS += -W -Wall
# LOCAL_CFLAGS += -fPIC -DPIC
# 
# 
# ifeq ($(TARGET_BUILD_TYPE),release)
# 	LOCAL_CFLAGS += -O2
# endif
# 
# include $(CLEAR_VARS)
# 
# LOCAL_SRC_FILES:= \
# 	libcharset/lib/localcharset.c \
# 	libcharset/lib/relocatable.c
# 
# LOCAL_C_INCLUDES += $(LOCAL_PATH)/include \
# 					$(LOCAL_PATH)/srclib
# 
# # LOCAL_C_INCLUDES += $(LOCAL_PATH)/android
# 
# LOCAL_MODULE:= libcharset
# LOCAL_PRELINK_MODULE := false
# include $(BUILD_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_CFLAGS += -DHAVE_CONFIG_H
LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC


ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_SRC_FILES:= \
	src/iconv.c \
	lib/iconv.c \
	srclib/progname.c \
	srclib/uniwidth/width.c \
	libcharset/lib/localcharset.c \
	libcharset/lib/relocatable.c

LOCAL_C_INCLUDES += $(LOCAL_PATH)/include \
					$(LOCAL_PATH)/srclib

LOCAL_MODULE:= libiconv
LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)
