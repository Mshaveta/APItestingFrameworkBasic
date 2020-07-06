package Payloads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import CommonUtil.CommonFuncs;

public class GoogleApiPayload {
	public static String addPlaceJsonPayload() 
	{
		String addPlace_pld = "{\r\n" + 
				"\r\n" + 
				"    \"location\":{\r\n" + 
				"\r\n" + 
				"        \"lat\" : -38.383494,\r\n" + 
				"\r\n" + 
				"        \"lng\" : 33.427362\r\n" + 
				"\r\n" + 
				"    },\r\n" + 
				"\r\n" + 
				"    \"accuracy\":50,\r\n" + 
				"\r\n" + 
				"    \"name\":\"Frontline house\",\r\n" + 
				"\r\n" + 
				"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
				"\r\n" + 
				"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
				"\r\n" + 
				"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
				"\r\n" + 
				"    \"website\" : \"http://google.com\",\r\n" + 
				"\r\n" + 
				"    \"language\" : \"French-IN\"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"";
		return addPlace_pld;
	}
	
	
	public static String addPlaceXMLPayload() throws IOException 
	{
		String addGPlc_xmlPath = System.getProperty("user.dir")
				+"\\src\\main\\java\\Payloads\\add_google_place.xml"; 
		String xmlPldRes  =CommonFuncs.readXmlData(addGPlc_xmlPath);
		return xmlPldRes;
	}
	
	
	
}
