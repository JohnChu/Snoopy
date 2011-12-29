/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package swig.org.gphoto2;

public class CameraAbilities {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public CameraAbilities(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(CameraAbilities obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gphoto2JNI.delete_CameraAbilities(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setModel(String value) {
    gphoto2JNI.CameraAbilities_model_set(swigCPtr, this, value);
  }

  public String getModel() {
    return gphoto2JNI.CameraAbilities_model_get(swigCPtr, this);
  }

  public void setStatus(CameraDriverStatus value) {
    gphoto2JNI.CameraAbilities_status_set(swigCPtr, this, value.swigValue());
  }

  public CameraDriverStatus getStatus() {
    return CameraDriverStatus.swigToEnum(gphoto2JNI.CameraAbilities_status_get(swigCPtr, this));
  }

  public void setPort(GPPortType value) {
    gphoto2JNI.CameraAbilities_port_set(swigCPtr, this, value.swigValue());
  }

  public GPPortType getPort() {
    return GPPortType.swigToEnum(gphoto2JNI.CameraAbilities_port_get(swigCPtr, this));
  }

  public void setSpeed(SWIGTYPE_p_int value) {
    gphoto2JNI.CameraAbilities_speed_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getSpeed() {
    long cPtr = gphoto2JNI.CameraAbilities_speed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setOperations(CameraOperation value) {
    gphoto2JNI.CameraAbilities_operations_set(swigCPtr, this, value.swigValue());
  }

  public CameraOperation getOperations() {
    return CameraOperation.swigToEnum(gphoto2JNI.CameraAbilities_operations_get(swigCPtr, this));
  }

  public void setFile_operations(CameraFileOperation value) {
    gphoto2JNI.CameraAbilities_file_operations_set(swigCPtr, this, value.swigValue());
  }

  public CameraFileOperation getFile_operations() {
    return CameraFileOperation.swigToEnum(gphoto2JNI.CameraAbilities_file_operations_get(swigCPtr, this));
  }

  public void setFolder_operations(CameraFolderOperation value) {
    gphoto2JNI.CameraAbilities_folder_operations_set(swigCPtr, this, value.swigValue());
  }

  public CameraFolderOperation getFolder_operations() {
    return CameraFolderOperation.swigToEnum(gphoto2JNI.CameraAbilities_folder_operations_get(swigCPtr, this));
  }

  public void setUsb_vendor(int value) {
    gphoto2JNI.CameraAbilities_usb_vendor_set(swigCPtr, this, value);
  }

  public int getUsb_vendor() {
    return gphoto2JNI.CameraAbilities_usb_vendor_get(swigCPtr, this);
  }

  public void setUsb_product(int value) {
    gphoto2JNI.CameraAbilities_usb_product_set(swigCPtr, this, value);
  }

  public int getUsb_product() {
    return gphoto2JNI.CameraAbilities_usb_product_get(swigCPtr, this);
  }

  public void setUsb_class(int value) {
    gphoto2JNI.CameraAbilities_usb_class_set(swigCPtr, this, value);
  }

  public int getUsb_class() {
    return gphoto2JNI.CameraAbilities_usb_class_get(swigCPtr, this);
  }

  public void setUsb_subclass(int value) {
    gphoto2JNI.CameraAbilities_usb_subclass_set(swigCPtr, this, value);
  }

  public int getUsb_subclass() {
    return gphoto2JNI.CameraAbilities_usb_subclass_get(swigCPtr, this);
  }

  public void setUsb_protocol(int value) {
    gphoto2JNI.CameraAbilities_usb_protocol_set(swigCPtr, this, value);
  }

  public int getUsb_protocol() {
    return gphoto2JNI.CameraAbilities_usb_protocol_get(swigCPtr, this);
  }

  public void setLibrary(String value) {
    gphoto2JNI.CameraAbilities_library_set(swigCPtr, this, value);
  }

  public String getLibrary() {
    return gphoto2JNI.CameraAbilities_library_get(swigCPtr, this);
  }

  public void setId(String value) {
    gphoto2JNI.CameraAbilities_id_set(swigCPtr, this, value);
  }

  public String getId() {
    return gphoto2JNI.CameraAbilities_id_get(swigCPtr, this);
  }

  public void setDevice_type(GphotoDeviceType value) {
    gphoto2JNI.CameraAbilities_device_type_set(swigCPtr, this, value.swigValue());
  }

  public GphotoDeviceType getDevice_type() {
    return GphotoDeviceType.swigToEnum(gphoto2JNI.CameraAbilities_device_type_get(swigCPtr, this));
  }

  public void setReserved2(int value) {
    gphoto2JNI.CameraAbilities_reserved2_set(swigCPtr, this, value);
  }

  public int getReserved2() {
    return gphoto2JNI.CameraAbilities_reserved2_get(swigCPtr, this);
  }

  public void setReserved3(int value) {
    gphoto2JNI.CameraAbilities_reserved3_set(swigCPtr, this, value);
  }

  public int getReserved3() {
    return gphoto2JNI.CameraAbilities_reserved3_get(swigCPtr, this);
  }

  public void setReserved4(int value) {
    gphoto2JNI.CameraAbilities_reserved4_set(swigCPtr, this, value);
  }

  public int getReserved4() {
    return gphoto2JNI.CameraAbilities_reserved4_get(swigCPtr, this);
  }

  public void setReserved5(int value) {
    gphoto2JNI.CameraAbilities_reserved5_set(swigCPtr, this, value);
  }

  public int getReserved5() {
    return gphoto2JNI.CameraAbilities_reserved5_get(swigCPtr, this);
  }

  public void setReserved6(int value) {
    gphoto2JNI.CameraAbilities_reserved6_set(swigCPtr, this, value);
  }

  public int getReserved6() {
    return gphoto2JNI.CameraAbilities_reserved6_get(swigCPtr, this);
  }

  public void setReserved7(int value) {
    gphoto2JNI.CameraAbilities_reserved7_set(swigCPtr, this, value);
  }

  public int getReserved7() {
    return gphoto2JNI.CameraAbilities_reserved7_get(swigCPtr, this);
  }

  public void setReserved8(int value) {
    gphoto2JNI.CameraAbilities_reserved8_set(swigCPtr, this, value);
  }

  public int getReserved8() {
    return gphoto2JNI.CameraAbilities_reserved8_get(swigCPtr, this);
  }

  public CameraAbilities() {
    this(gphoto2JNI.new_CameraAbilities(), true);
  }

}