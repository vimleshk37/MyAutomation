package apiTestCases;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresUsersAPI {
	@Test (enabled=true, dependsOnMethods = "verifyUserNameReqres")
	public static void addUserReqres() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/users/");
		request.contentType(ContentType.JSON);
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "Kamlesh");
		requestBody.put("job", "QALead");
		
		request.body(requestBody.toString());

		Response response = request.post();

		JsonPath responseParams = new JsonPath(response.getBody().asString());
		String name = responseParams.getString("name");

		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("Updated Name is " + name);
		System.out.println("Response is " + response.getBody().asString());
		
		Assert.assertEquals(name, "Kamlesh");

	}
	@Test(enabled=true, dependsOnMethods = "addUserReqres")
	public static void updateUserReqres() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/users/2");
		request.contentType(ContentType.JSON);
		
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", "Kamlesh");
		requestparams.put("job", "DeOps Engg");
		
		request.body(requestparams.toString());
		
		Response response = request.put();
		//Response response = request.patch();
		
		JsonPath responsebody = new JsonPath(response.getBody().asString());
		
		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("Response is " + response.getBody().asString());
		System.out.println("Updated Name is " + responsebody.get("name"));
		Assert.assertEquals(responsebody.get("name"), "Kamlesh", "User Update is not Successfully ");
	}
	
	@Test(enabled=true, dependsOnMethods = "updateUserReqres")
	public static void deleteUserReqres() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/users/2");
		
		Response response = request.delete();
		System.out.println("Status Code is " + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 204);
	}

	@Test(enabled = true, groups= {"SmokeTest"})
	public static void verifyUserNameReqres() {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://reqres.in/");
		request.basePath("api/users/");
		request.contentType(ContentType.JSON);
		Response response = request.get();

		System.out.println("Status Code is " + response.getStatusCode());
		System.out.println("Reponce body is " + response.getBody().asString());

		JsonPath responseParams = new JsonPath(response.getBody().asString());

		List<String> first_names = responseParams.getList("data.first_name");
		List<String> last_names = responseParams.getList("data.last_name");
		System.out.println(first_names.size() + " Users First Name are: ");
		for (String first_name : first_names)
			System.out.println(first_name);

		System.out.println(last_names.size() + " Users Last Name are: ");
		for (String last_name : last_names)
			System.out.println(last_name);

		Assert.assertTrue(first_names.contains("George"));
	}
}