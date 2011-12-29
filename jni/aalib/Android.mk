LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := \
	src/aaattrs.c \
	src/aacurkbd.c \
	src/aacurmou.c \
	src/aacurrfnt.c \
	src/aacurses.c \
	src/aaedit.c \
	src/aafastre.c \
	src/aaflush.c \
	src/aafont.c \
	src/aafonts.c \
	src/aagpm.c \
	src/aahelp.c \
	src/aaimage.c \
	src/aaimgheight.c \
	src/aaimgwidth.c \
	src/aain.c \
	src/aakbdreg.c \
	src/aalib.c \
	src/aalinux.c \
	src/aalinuxkbd.c \
	src/aamem.c \
	src/aamktabl.c \
	src/aammheight.c \
	src/aammwidth.c \
	src/aamoureg.c \
	src/aaout.c \
	src/aaparse.c \
	src/aaprintf.c \
	src/aaputpixel.c \
	src/aarec.c \
	src/aarecfunc.c \
	src/aaregist.c \
	src/aarender.c \
	src/aasave.c \
	src/aascrheight.c \
	src/aascrwidth.c \
	src/aaslang.c \
	src/aaslnkbd.c \
	src/aastdin.c \
	src/aastdout.c \
	src/aatext.c \
	src/aavyhen.c \
	src/aax.c \
	src/aaxkbd.c \
	src/aaxmouse.c \
	src/font14.c \
	src/font16.c \
	src/font8.c \
	src/font9.c \
	src/fontcour.c \
	src/fontgl.c \
	src/fontline.c \
	src/fontx13b.c \
	src/fontx13.c \
	src/fontx16.c

LOCAL_C_INCLUDES += $(LOCAL_PATH)/src

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

#LOCAL_SHARED_LIBRARIES := libltdl libgphoto2_port

LOCAL_MODULE := aalib

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)

####### aafire

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := src/aafire.c

LOCAL_C_INCLUDES += $(LOCAL_PATH)/src

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_SHARED_LIBRARIES := aalib

LOCAL_MODULE := aafire

LOCAL_PRELINK_MODULE := false
include $(BUILD_EXECUTABLE)

####### aainfo

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := src/aainfo.c

LOCAL_C_INCLUDES += $(LOCAL_PATH)/src

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_SHARED_LIBRARIES := aalib

LOCAL_MODULE := aainfo

LOCAL_PRELINK_MODULE := false
include $(BUILD_EXECUTABLE)

####### aasavefont

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := src/aasavefont.c

LOCAL_C_INCLUDES += $(LOCAL_PATH)/src

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_SHARED_LIBRARIES := aalib

LOCAL_MODULE := aasavefont

LOCAL_PRELINK_MODULE := false
include $(BUILD_EXECUTABLE)

####### aatest

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES := src/aatest.c

LOCAL_C_INCLUDES += $(LOCAL_PATH)/src

LOCAL_CFLAGS += -W -Wall
LOCAL_CFLAGS += -fPIC -DPIC

ifeq ($(TARGET_BUILD_TYPE),release)
	LOCAL_CFLAGS += -O2
endif

LOCAL_SHARED_LIBRARIES := aalib

LOCAL_MODULE := aatest

LOCAL_PRELINK_MODULE := false
include $(BUILD_EXECUTABLE)
