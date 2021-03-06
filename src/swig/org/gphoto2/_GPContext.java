/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package swig.org.gphoto2;

public class _GPContext {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public _GPContext(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(_GPContext obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gphoto2JNI.delete__GPContext(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIdle_func(SWIGTYPE_p_f_p_struct__GPContext_p_void__void value) {
    gphoto2JNI._GPContext_idle_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_p_void__void getIdle_func() {
    long cPtr = gphoto2JNI._GPContext_idle_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_p_void__void(cPtr, false);
  }

  public void setIdle_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_idle_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getIdle_func_data() {
    long cPtr = gphoto2JNI._GPContext_idle_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setProgress_start_func(SWIGTYPE_p_f_p_struct__GPContext_float_p_q_const__char_va_list_p_void__unsigned_int value) {
    gphoto2JNI._GPContext_progress_start_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_float_p_q_const__char_va_list_p_void__unsigned_int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_float_p_q_const__char_va_list_p_void__unsigned_int getProgress_start_func() {
    long cPtr = gphoto2JNI._GPContext_progress_start_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_float_p_q_const__char_va_list_p_void__unsigned_int(cPtr, false);
  }

  public void setProgress_update_func(SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_float_p_void__void value) {
    gphoto2JNI._GPContext_progress_update_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_float_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_float_p_void__void getProgress_update_func() {
    long cPtr = gphoto2JNI._GPContext_progress_update_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_float_p_void__void(cPtr, false);
  }

  public void setProgress_stop_func(SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_p_void__void value) {
    gphoto2JNI._GPContext_progress_stop_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_p_void__void getProgress_stop_func() {
    long cPtr = gphoto2JNI._GPContext_progress_stop_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_unsigned_int_p_void__void(cPtr, false);
  }

  public void setProgress_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_progress_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getProgress_func_data() {
    long cPtr = gphoto2JNI._GPContext_progress_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setError_func(SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void value) {
    gphoto2JNI._GPContext_error_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void getError_func() {
    long cPtr = gphoto2JNI._GPContext_error_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void(cPtr, false);
  }

  public void setError_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_error_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getError_func_data() {
    long cPtr = gphoto2JNI._GPContext_error_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setQuestion_func(SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void___GPContextFeedback value) {
    gphoto2JNI._GPContext_question_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void___GPContextFeedback.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void___GPContextFeedback getQuestion_func() {
    long cPtr = gphoto2JNI._GPContext_question_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void___GPContextFeedback(cPtr, false);
  }

  public void setQuestion_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_question_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getQuestion_func_data() {
    long cPtr = gphoto2JNI._GPContext_question_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setCancel_func(SWIGTYPE_p_f_p_struct__GPContext_p_void___GPContextFeedback value) {
    gphoto2JNI._GPContext_cancel_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_p_void___GPContextFeedback.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_p_void___GPContextFeedback getCancel_func() {
    long cPtr = gphoto2JNI._GPContext_cancel_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_p_void___GPContextFeedback(cPtr, false);
  }

  public void setCancel_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_cancel_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getCancel_func_data() {
    long cPtr = gphoto2JNI._GPContext_cancel_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setStatus_func(SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void value) {
    gphoto2JNI._GPContext_status_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void getStatus_func() {
    long cPtr = gphoto2JNI._GPContext_status_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void(cPtr, false);
  }

  public void setStatus_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_status_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getStatus_func_data() {
    long cPtr = gphoto2JNI._GPContext_status_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setMessage_func(SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void value) {
    gphoto2JNI._GPContext_message_func_set(swigCPtr, this, SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void getMessage_func() {
    long cPtr = gphoto2JNI._GPContext_message_func_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_struct__GPContext_p_q_const__char_va_list_p_void__void(cPtr, false);
  }

  public void setMessage_func_data(SWIGTYPE_p_void value) {
    gphoto2JNI._GPContext_message_func_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getMessage_func_data() {
    long cPtr = gphoto2JNI._GPContext_message_func_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setRef_count(long value) {
    gphoto2JNI._GPContext_ref_count_set(swigCPtr, this, value);
  }

  public long getRef_count() {
    return gphoto2JNI._GPContext_ref_count_get(swigCPtr, this);
  }

  public _GPContext() {
    this(gphoto2JNI.new__GPContext(), true);
  }

}
