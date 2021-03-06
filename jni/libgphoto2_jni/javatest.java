import swig.org.gphoto2.*;

public class javatest {

	public static void main(final String[] argv) {
		final String sCameraModel = "USB PTP Class Camera";  // "Canon Powershot A75";

		System.out.println("loading JNI library \"gphoto2_jni\"");
		System.loadLibrary("gphoto2_jni");

		System.out.println(" JNI: Creating context...");
		final _GPContext context = gphoto2.gp_context_new();

		// create and load list of ports - this should list all usb ports of all devices on the system, not just cameras
		System.out.println(" JNI: gphoto2.create_null_p_p__GPPortInfoList()");
		SWIGTYPE_p_p__GPPortInfoList ppInfoList = gphoto2.create_null_p_p__GPPortInfoList();  // create the empty pointer

		System.out.println(" JNI: gphoto2.gp_port_info_list_new()");
		gphoto2.gp_port_info_list_new(ppInfoList);  // create the new (empty) list and get a pointer to it

		System.out.println(" JNI: gphoto2.dereference_p_p__GPPortInfoList()");
		_GPPortInfoList infolist = gphoto2.dereference_p_p__GPPortInfoList(ppInfoList);  // dereference the pointer to get the (empty list) java object

		System.out.println(" JNI: gphoto2.gp_port_info_list_load()");
		int result = gphoto2.gp_port_info_list_load(infolist);  // populate the list object with current data
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		//kos

		final int portCount = gphoto2.gp_port_info_list_count(infolist);
		System.out.println("Ports detected: " + portCount);
		if (portCount <= 0) throw new RuntimeException("no ports detected");

		//build empty camera list
		final SWIGTYPE_p_p__CameraList ppCameraList = gphoto2.create_null_p_p__CameraList();
		gphoto2.gp_list_new(ppCameraList);
		final SWIGTYPE_p__CameraList cameraList = gphoto2.dereference_p_p__CameraList(ppCameraList);

		//build empty avilities list
		final SWIGTYPE_p_p__CameraAbilitiesList ppAbilitiesList = gphoto2.create_null_p_p__CameraAbilitiesList();
		gphoto2.gp_abilities_list_new(ppAbilitiesList);
		final _CameraAbilitiesList abilitiesList = gphoto2.dereference_p_p__CameraAbilitiesList(ppAbilitiesList);
		gphoto2.gp_abilities_list_load(abilitiesList, context);

		//detect cameras & their abilities
		result = gphoto2.gp_abilities_list_detect(abilitiesList, infolist, cameraList, context);
		if (result != 0) throw new RuntimeException("unexpected JNI result from gp_abilities_list_detect '" + result + "'");

		final int cameraCount = gphoto2.gp_list_count(cameraList);
		System.out.println("Detected cameras: " + cameraCount);

		final SWIGTYPE_p_p_char ppName = gphoto2.create_null_p_p__char();
		final SWIGTYPE_p_p_char ppValue = gphoto2.create_null_p_p__char();


		String portStr = null;
		for (int i = 0; i < cameraCount; i++) {
			gphoto2.gp_list_get_name(cameraList, i, ppName);
			gphoto2.gp_list_get_value(cameraList, i, ppValue);

			final String name = gphoto2.dereference_p_p__char(ppName);
			portStr = gphoto2.dereference_p_p__char(ppValue);

			System.out.println("" + (i + 1) + ") " + name + "\t" + portStr);

//			gphoto2.gp_li
		}
		gphoto2.delete_p_p__char(ppName);
		gphoto2.delete_p_p__char(ppValue);

		if (cameraCount <= 0) System.exit(-1);

		assert portStr != null;

		GPPortInfo portinfo = new GPPortInfo();

		//final int k = gphoto2.gp_port_info_list_lookup_name(infolist, portStr);
		final int k = gphoto2.gp_port_info_list_lookup_path(infolist, portStr);
		if (k < 0) throw new RuntimeException("Can't lookup port by name '" + portStr + "', code: " + k);
		result = gphoto2.gp_port_info_list_get_info(infolist, k, portinfo);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		//-kos


		/*
			int k=gphoto2.gp_port_info_list_lookup_path (infolist, "usb:");
			result=gphoto2.gp_port_info_list_get_info (infolist, k, portinfo);
				if (result!=0) throw new RuntimeException("unexpected JNI result '" + result + "'");
				*/

//		if (gphoto2.gp_port_info_list_count(infolist) == 0) throw new RuntimeException("no cameras detected ");

		/*
		// for each port in the list
		for (int nCurPortNum = 0; nCurPortNum < portCount; nCurPortNum++) {
			System.out.println(" JNI: gphoto2.gp_port_info_list_get_info()");
			GPPortInfo portinfotmp = new GPPortInfo();
			gphoto2.gp_port_info_list_get_info(infolist, nCurPortNum, portinfotmp);  // get more info about the current port
			System.out.println("  port " + nCurPortNum + " = '" + portinfotmp.getPath() + "'");

			if ("usb:".equalsIgnoreCase(portinfotmp.getPath())) {
				portinfo = portinfotmp;
			}
			portinfotmp = null;
		}
        */
		// release the info list resources
		gphoto2.gp_port_info_list_free(infolist);
		gphoto2.delete_p_p__GPPortInfoList(ppInfoList);
		infolist = null;
		ppInfoList = null;

		// TODO is this really a camera on this port?

		System.out.println(" JNI: gphoto2.create_null_p_p__Camera()");
		final SWIGTYPE_p_p__Camera ppCamera = gphoto2.create_null_p_p__Camera();

		System.out.println(" JNI: gphoto2.gp_camera_new() - Creating camera...");
		result = gphoto2.gp_camera_new(ppCamera);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		System.out.println(" JNI: gphoto2.dereference_p_p__Camera()");
		final _Camera cam = gphoto2.dereference_p_p__Camera(ppCamera);

		System.out.println(" JNI: gphoto2.create_null_p_p__CameraAbilitiesList()");
		final SWIGTYPE_p_p__CameraAbilitiesList p_al = gphoto2.create_null_p_p__CameraAbilitiesList();

		System.out.println(" JNI: gphoto2.gp_abilities_list_new()");
		result = gphoto2.gp_abilities_list_new(p_al);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		System.out.println(" JNI: gphoto2.dereference_p_p__CameraAbilitiesList()");
		final _CameraAbilitiesList al = gphoto2.dereference_p_p__CameraAbilitiesList(p_al);

		System.out.println(" JNI: gphoto2.gp_abilities_list_load() - Loading Abilities...");
		result = gphoto2.gp_abilities_list_load(al, context);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		System.out.println(" JNI: gphoto2.gp_camera_set_port_info() - Setting PortInfo on Camera...");
		result = gphoto2.gp_camera_set_port_info(cam, portinfo);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		System.out.println(" JNI: gphoto2.gp_abilities_list_get_abilities() - Using Camera Model '" + sCameraModel + "'");
		final CameraAbilities abilities = new CameraAbilities();
		result = gphoto2.gp_abilities_list_get_abilities(al, gphoto2.gp_abilities_list_lookup_model(al, sCameraModel), abilities);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		System.out.println(" JNI: gphoto2.gp_abilities_list_free()");
		result = gphoto2.gp_abilities_list_free(al);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		System.out.println(" JNI: gphoto2.gp_camera_set_abilities()");
		result = gphoto2.gp_camera_set_abilities(cam, abilities);
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");

		for (int i = 0; result != 0 && i < 5; i++) {
			System.out.println(" JNI: gphoto2.gp_camera_init() - Initializing Camera...");
			result = gphoto2.gp_camera_init(cam, context);
			if (result != 0) {
				System.out.println("   << gphoto2.gp_camera_init() returned " + result + "...");
				try {
					System.out.println("  **Sleeping 1000 msec...");
					Thread.sleep(1000);  // pause for a bit
				} catch (InterruptedException e) {
					System.out.println("interrupted: " + e);
					System.exit(-1);
				}
				// -52 = camera not found?  (when run with camera off)
				// -60 = not a camera? (when tried to init usb mouse as camera, got -52 here too)
			}
		}
		if (result == -60 || result == -52) { // looks like it wasn't a camera
			System.out.println("(port '" + portinfo.getPath() + "' was not a camera?)");
		}

		/* TODO change timeout
				SWIGTYPE_p_GPPort p = cam.getPort();
				_GPPort pp = new _GPPort();
				pp.setTimeout(1000*30);
				*/


		// Now, take a picture
		System.out.println(" JNI: gphoto2.gp_camera_capture() - Capturing Image...");
		final CameraFilePath cfpOut = new CameraFilePath();

		result = -1;
		// int nLoops=0;
		for (int i = 0; result != 0 && i < 5; i++) {
			result = gphoto2.gp_camera_capture(cam, CameraCaptureType.GP_CAPTURE_IMAGE, cfpOut, context);
			if (result != 0) System.out.println("unexpected JNI result '" + result + "', retrying...");
		}
		if (result != 0) throw new RuntimeException("unexpected JNI result '" + result + "'");


		// TODO download image from camera
		/*
				 * for each folder
				 *   for each file
				 *     check date
				 *     download latest
				 *     delete all
				 */


		/*
			 * Don't forget to clean up when you don't need the camera any
			 * more. Please use unref instead of destroy - you'll never know
			 * if some part of the program still needs the camera.
			 */
		System.out.println(" JNI: gphoto2.gp_camera_unref() - Releasing Camera...");
		result = gphoto2.gp_camera_exit(cam, context);
		result = gphoto2.gp_camera_unref(cam);

		System.out.println("exiting");
	}
}


/*
 * Local Variables:
 * mode: java
 * End:
 */
