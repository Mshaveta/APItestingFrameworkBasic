package GoogleAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CommonUtil.CommonFuncs;
import Payloads.GoogleApiPayload;
import Resources.AddGoogle_plc_rsc;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddGooglePlace {
	String baseURI;
	String g_apiKey,reqFormat;
	@BeforeSuite
	public void readPropFile() throws Exception {
		Properties propObj = CommonFuncs.readPropData("Config.properties");
		baseURI = propObj.getProperty("baseurl");
		g_apiKey = propObj.getProperty("key");
		reqFormat = propObj.getProperty("reqformat");
		RestAssured.baseURI=baseURI;
	}
	
	@Test 
	public void addGooglePlace() {
		
		Response  response = given().
			header("Content-Type",ContentType.JSON).
			queryParam("key",g_apiKey).
			body(GoogleApiPayload.addPlaceJsonPayload()).
		when().
			post(AddGoogle_plc_rsc.addPlaceRes(reqFormat)).
		then().
			extract().response();
		String respBody = response.getBody().asString();
		
		Assert.assertTrue(respBody!=null);
		Assert.assertEquals(response.statusCode(),200);
		Assert.assertTrue(response.getTime()<2000);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}
	
//	@Test
//	public void addGooglePlaceXMLFormat() throws IOException {
//		 
//		String response = given().
//			header("Content-Type",ContentType.XML).
//			queryParam("key",g_apiKey).
//			body(GoogleApiPayload.addPlaceXMLPayload()).
//		when().
//			post(AddGoogle_plc_rsc.addPlaceRes(reqFormat)).
//		then().
//		extract().response().asString();
//		
//		 
//	}

}
