/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package swig.org.gphoto2;

public final class CameraStorageFilesystemType {
  public final static CameraStorageFilesystemType GP_STORAGEINFO_FST_UNDEFINED = new CameraStorageFilesystemType("GP_STORAGEINFO_FST_UNDEFINED", 0);
  public final static CameraStorageFilesystemType GP_STORAGEINFO_FST_GENERICFLAT = new CameraStorageFilesystemType("GP_STORAGEINFO_FST_GENERICFLAT", 1);
  public final static CameraStorageFilesystemType GP_STORAGEINFO_FST_GENERICHIERARCHICAL = new CameraStorageFilesystemType("GP_STORAGEINFO_FST_GENERICHIERARCHICAL", 2);
  public final static CameraStorageFilesystemType GP_STORAGEINFO_FST_DCF = new CameraStorageFilesystemType("GP_STORAGEINFO_FST_DCF", 3);

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static CameraStorageFilesystemType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + CameraStorageFilesystemType.class + " with value " + swigValue);
  }

  private CameraStorageFilesystemType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private CameraStorageFilesystemType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private CameraStorageFilesystemType(String swigName, CameraStorageFilesystemType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static CameraStorageFilesystemType[] swigValues = { GP_STORAGEINFO_FST_UNDEFINED, GP_STORAGEINFO_FST_GENERICFLAT, GP_STORAGEINFO_FST_GENERICHIERARCHICAL, GP_STORAGEINFO_FST_DCF };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

