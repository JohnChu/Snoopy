LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES:= \
	findme.c \
	popt.c \
	poptconfig.c \
	popthelp.c \
	poptparse.c


LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/android


LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC
LOCAL_CFLAGS += -DHAVE_CONFIG_H

LOCAL_PRELINK_MODULE := false 

LOCAL_MODULE := libpopt

include $(BUILD_SHARED_LIBRARY)
