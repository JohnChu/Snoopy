/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package swig.org.gphoto2;

public final class CameraFileStatus {
  public final static CameraFileStatus GP_FILE_STATUS_NOT_DOWNLOADED = new CameraFileStatus("GP_FILE_STATUS_NOT_DOWNLOADED");
  public final static CameraFileStatus GP_FILE_STATUS_DOWNLOADED = new CameraFileStatus("GP_FILE_STATUS_DOWNLOADED");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static CameraFileStatus swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + CameraFileStatus.class + " with value " + swigValue);
  }

  private CameraFileStatus(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private CameraFileStatus(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private CameraFileStatus(String swigName, CameraFileStatus swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static CameraFileStatus[] swigValues = { GP_FILE_STATUS_NOT_DOWNLOADED, GP_FILE_STATUS_DOWNLOADED };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
