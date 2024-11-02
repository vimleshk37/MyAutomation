package apiTestCases;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresRegisterAPI {
	
	@Test(enabled=true, groups= {"SmokeTest"})
	public static void RegisterUserReqres() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/register");
		request.contentType(ContentType.JSON);
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("email", "michael.lawson@reqres.in");
		requestparams.put("password", "asdf");
		
		request.body(requestparams.toString());
		
		Response response = request.when().post();
		
		JsonPath responseparams = new JsonPath(response.getBody().asString()); 
		
		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("Token ID is " + responseparams.get("token"));
		System.out.println("Response is " + response.getBody().asString());
		
		Assert.assertTrue(response.getBody().asString().contains("token"));
		//Assert.assertFalse(responseparams.get("error").equals("Missing password"));
		
	}
	@Test(dependsOnMethods = "RegisterUserReqres")
	public static void LoginUserReqres() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/login");
		request.contentType(ContentType.JSON);
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("email", "michael.lawson@reqres.in");
		requestparams.put("password", "asdf");
		
		request.body(requestparams.toString());
		
		Response response = request.when().post();
		
		JsonPath responseparams = new JsonPath(response.getBody().asString()); 
		
		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("Token ID is " + responseparams.get("token"));
		System.out.println("Response is " + response.getBody().asString());
		
		Assert.assertTrue(response.getBody().asString().contains("token"));
		//Assert.assertFalse(responseparams.get("error").equals("Missing password"));
			
	}
	@Test
	public static void delayResponseReqres() throws Exception {
        	RequestSpecification request = RestAssured.given();
        	request.baseUri("https://reqres.in/");
        	request.basePath("api/users?delay=3");
        	request.queryParam("delay","3");
        	
        	Response response = request.when().get();
  
        	long respTime = response.getTimeIn(TimeUnit.SECONDS);
        	
        	System.out.println("Response time is " + respTime);
        	Assert.assertTrue(respTime<=2, "Response time is more then 2 Sec");
	}
}
