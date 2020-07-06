package TwitterAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import CommonUtil.CommonFuncs;
import Resources.TwitterResource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class AddTweet {
//https://api.twitter.com/1.1/statuses/update.json?status=hello
	String consumerkey,consumersecret,accesstoken,tokensecret,twitter_baseuri,twitter_status,targetTwId;
	@BeforeSuite
	public void setUp() throws IOException {
		
		Properties propObj = CommonFuncs.readPropData("Config.properties");
		
		consumerkey = propObj.getProperty("consumerkey");
		consumersecret = propObj.getProperty("consumersecret");
		accesstoken = propObj.getProperty("accesstoken");
		tokensecret = propObj.getProperty("tokensecret");
		twitter_baseuri=propObj.getProperty("twitter_baseuri");
		twitter_status=propObj.getProperty("tweetstatus")+"_"+
					   CommonFuncs.getRandomStr(2);
		RestAssured.baseURI=twitter_baseuri;
	}
	@Test 
	public void addTweet() {
		 
		String str = given().
			queryParam("status",twitter_status).
			auth().oauth(consumerkey, 
						 consumersecret, 
						 accesstoken, 
						 tokensecret).
		when().
			post(TwitterResource.addTweetRsc()).
		then().
			extract().response().asString();
		
		System.out.println(str);
	}
	
	//https://api.twitter.com/1.1/statuses/home_timeline.json
	@Test
	public void getTweet() {
		String response = given().
				queryParam("status",twitter_status).
				auth().oauth(consumerkey, 
							 consumersecret, 
							 accesstoken, 
							 tokensecret).
			when().
				get(TwitterResource.getTweetRsc()).
			then().
				assertThat().statusCode(200).and().header("content-type", "application/json;charset=utf-8").
				extract().response().asString();
		
		//System.out.println("Response"+response);
		
		JsonPath jpath = new JsonPath(response);
		int Objcount = jpath.get("array.size");
		String expId = "1270565348723396609";
		
		for(int i=0;i<Objcount;i++) {
			String twId = jpath.get("["+i+"].id_str").toString();
			 
			if(twId.equals(expId)) { 
				targetTwId=twId;
				break; 
			}
		}
		 
		
		//String twId = jpath.get("[3].id").toString();
		//System.out.println(twId);
			
	}
	
	@Test(dependsOnMethods="getTweet")
	public void delTweet() {
		System.out.println(targetTwId);
	}

}
