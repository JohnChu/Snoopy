TOP := $(call my-dir)

ifeq ($(BUILD_CONF),minimal)
	include $(TOP)/libexif/Android.mk
	include $(TOP)/libgphoto2/Android.mk
	include $(TOP)/libltdl/Android.mk
	include $(TOP)/libregex/Android.mk
	include $(TOP)/libusb/Android.mk
	include $(TOP)/libusb-compat/Android.mk
	include $(TOP)/libgphoto2_jni/Android.mk
else
	include $(call all-subdir-makefiles)
endif
