/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package swig.org.gphoto2;

public class CameraStorageInformation {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public CameraStorageInformation(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(CameraStorageInformation obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gphoto2JNI.delete_CameraStorageInformation(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFields(CameraStorageInfoFields value) {
    gphoto2JNI.CameraStorageInformation_fields_set(swigCPtr, this, value.swigValue());
  }

  public CameraStorageInfoFields getFields() {
    return CameraStorageInfoFields.swigToEnum(gphoto2JNI.CameraStorageInformation_fields_get(swigCPtr, this));
  }

  public void setBasedir(String value) {
    gphoto2JNI.CameraStorageInformation_basedir_set(swigCPtr, this, value);
  }

  public String getBasedir() {
    return gphoto2JNI.CameraStorageInformation_basedir_get(swigCPtr, this);
  }

  public void setLabel(String value) {
    gphoto2JNI.CameraStorageInformation_label_set(swigCPtr, this, value);
  }

  public String getLabel() {
    return gphoto2JNI.CameraStorageInformation_label_get(swigCPtr, this);
  }

  public void setDescription(String value) {
    gphoto2JNI.CameraStorageInformation_description_set(swigCPtr, this, value);
  }

  public String getDescription() {
    return gphoto2JNI.CameraStorageInformation_description_get(swigCPtr, this);
  }

  public void setType(CameraStorageType value) {
    gphoto2JNI.CameraStorageInformation_type_set(swigCPtr, this, value.swigValue());
  }

  public CameraStorageType getType() {
    return CameraStorageType.swigToEnum(gphoto2JNI.CameraStorageInformation_type_get(swigCPtr, this));
  }

  public void setFstype(CameraStorageFilesystemType value) {
    gphoto2JNI.CameraStorageInformation_fstype_set(swigCPtr, this, value.swigValue());
  }

  public CameraStorageFilesystemType getFstype() {
    return CameraStorageFilesystemType.swigToEnum(gphoto2JNI.CameraStorageInformation_fstype_get(swigCPtr, this));
  }

  public void setAccess(CameraStorageAccessType value) {
    gphoto2JNI.CameraStorageInformation_access_set(swigCPtr, this, value.swigValue());
  }

  public CameraStorageAccessType getAccess() {
    return CameraStorageAccessType.swigToEnum(gphoto2JNI.CameraStorageInformation_access_get(swigCPtr, this));
  }

  public void setCapacitykbytes(long value) {
    gphoto2JNI.CameraStorageInformation_capacitykbytes_set(swigCPtr, this, value);
  }

  public long getCapacitykbytes() {
    return gphoto2JNI.CameraStorageInformation_capacitykbytes_get(swigCPtr, this);
  }

  public void setFreekbytes(long value) {
    gphoto2JNI.CameraStorageInformation_freekbytes_set(swigCPtr, this, value);
  }

  public long getFreekbytes() {
    return gphoto2JNI.CameraStorageInformation_freekbytes_get(swigCPtr, this);
  }

  public void setFreeimages(long value) {
    gphoto2JNI.CameraStorageInformation_freeimages_set(swigCPtr, this, value);
  }

  public long getFreeimages() {
    return gphoto2JNI.CameraStorageInformation_freeimages_get(swigCPtr, this);
  }

  public CameraStorageInformation() {
    this(gphoto2JNI.new_CameraStorageInformation(), true);
  }

}
