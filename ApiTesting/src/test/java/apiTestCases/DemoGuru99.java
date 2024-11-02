package apiTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoGuru99 {
	
        @Test(enabled=true, groups= {"SmokeTest"})
        public static void getResponseBody(){
        	
        	RequestSpecification request = RestAssured.given();
        	request.baseUri("http://demo.guru99.com/");
        	request.basePath("V4/sinkministatement.php");
        	request.queryParam("CUSTOMER_ID","68195");
        	request.queryParam("PASSWORD","1234!");
        	request.queryParam("Account_No","1");
        	
        	Response response = request.when().get();
        	
        	System.out.println("---> Status Code: " + response.getStatusCode());
        	System.out.println("---> Response Body is: \n" +response.getBody().asString());
			Assert.assertEquals(response.getStatusCode(), 200);	  
		 }
}