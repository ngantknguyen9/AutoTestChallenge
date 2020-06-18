package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;

import org.hamcrest.core.Is;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.FileReader;

public class TC03_GetData_API {
	@Test
	public void testRespondCode() {
		Response respond = RestAssured.get("https://my-json-server.typicode.com/typicode/demo/posts/1");
		int code = respond.getStatusCode();
		//int code = get("https://my-json-server.typicode.com/typicode/demo/posts/1").getStatusCode();
		System.out.println("Get status code:" +code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testRespondBody() throws IOException, ParseException {
		Response respond = RestAssured.get("https://my-json-server.typicode.com/typicode/demo/posts/1");
		String data = respond.asString();
		System.out.println("Data is:\n" +data);
		System.out.println("Respondtime is:" + respond.getTime());
		get("https://my-json-server.typicode.com/typicode/demo/posts/1").then().assertThat()
		.body("id",Is.is(1)).log().all();
	}
	

}
