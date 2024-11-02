package apiTestCases;

import java.util.Base64;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReadXLSDdata;

public class RL3PLApi extends BaseTest{
	
	@Test(dataProvider = "allusers", dataProviderClass = ReadXLSDdata.class)
	public static void Rl3PlCreateProductAPI(String SKU) {		
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://rl-apim-qa.azure-api.net/v1/");
		request.basePath("api/Product");
		
		request.header("Content-Type", "application/json");
		request.header("api-key", "4ba9d9f88fe04b0ca2463ad9ba1c37c5");
		request.header("Authorization",authorization);
	
		JSONObject requestparams = new JSONObject();
		requestparams.put("productName", "LG g21 mobile");
		requestparams.put("category", "Phone");
		requestparams.put("itemType", "Product");
		requestparams.put("sku", SKU);
		requestparams.put("upc", "UP-C-123");
		requestparams.put("brand", "ACME");
		requestparams.put("imageUrl", "https://www.lg.com/in/images/mobile-phones/md06155757/01_Thumb_350-V3.jpg");
		requestparams.put("color", "Black");
		requestparams.put("size", "Large");
		requestparams.put("isActive", true);
		requestparams.put("isBer", false);
		requestparams.put("isReturnable", true);
		requestparams.put("isRepairable", true);
		
		request.body(requestparams.toString());
		
		Response response = request.when().post();
		
		JsonPath responseparam =  new JsonPath(response.getBody().asString());
		
		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("Response is " + response.getBody().asString());
		try {
		Assert.assertEquals(responseparam.getString("sku"), SKU);
		System.out.println("SKU is Created");
		}catch (AssertionError e) {
			System.out.println("SKU is not Created Some issue is there");
			throw new AssertionError();
		}
	}
	
	public static String Rl3PlTokenAPI() {
		String credentials = "a0d110d5-0212-4fb6-b54d-0053136c374c" + ":" + "DwY8Q~2YzS8pMwlQX8.XoHKWMv1nQfewVmjRxc6J";//(Username:Password)
		String authorization = "Basic " +Base64.getEncoder().encodeToString(credentials.getBytes());
		System.out.println("Vimlesh Kumar " +authorization);
		
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://login.microsoftonline.com/");
		request.basePath("b79ea6d9-b2f3-41ca-bdd2-b79f3ce4abd1/oauth2/v2.0/token");
		
		request.header("Content-Type","multipart/form-data; boundary=<calculated when request is sent>");
		request.header("Authorization",authorization);

		request.multiPart("grant_type", "client_credentials");
		request.multiPart("scope", "api://a9dd58b2-5c41-4439-931f-31107617a1be/.default");
		
		Response response = request.when().post();
		
		JsonPath responseparam =  new JsonPath(response.getBody().asString());
		
		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("access token is " + responseparam.getString("access_token"));
		
		return responseparam.getString("access_token");
	}

}
