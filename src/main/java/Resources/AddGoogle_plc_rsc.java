package Resources;

public class AddGoogle_plc_rsc {
	public static String addPlaceRes(String reqFormat) {
		String addGPlcRsc  = "/maps/api/place/add/"+reqFormat;
		return addGPlcRsc;
	}
}
