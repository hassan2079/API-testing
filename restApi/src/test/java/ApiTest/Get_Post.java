package ApiTest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Post{
	@Test
	public void Get() {
		
		
		Response response=RestAssured.get("http://localhost:3000/posts/29");
		int code= response.getStatusCode();
		System.out.println("response code is"+ code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void printresponsetime() {
		
		Response response=RestAssured.get("http://localhost:3000/posts/29");
		String data= response.asString();
		System.out.println("Data is" +data);
		
		System.out.println("Response time" +response.getTime());
	
	
	
	}
	@Test
	public void Post()
	{
		
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json= new JSONObject();
		json.put("id", (int)(Math.random()*50+1));
		json.put("title", "Automation");
		json.put("author", "Hassan");

		
		request.body(json.toString());
		Response response = request.post("http://localhost:3000/posts");
		
		int code= response.getStatusCode();
		
		System.out.println("response code" + code);
		
		Assert.assertEquals(code, 201);
		
		}
	@Test
	public void Put()
	{
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json= new JSONObject();
		json.put("id", "10");
		json.put("title", "Mahmoodtester");
		json.put("author", "Test55");

		
		request.body(json.toString());
		Response response = request.put("http://localhost:3000/posts/10");
		
		int code= response.getStatusCode();
		
		System.out.println("response code" + code);
		
		Assert.assertEquals(code, 200);
	}
	
	/*@Test
	public void deletetest() {
	
		Response response= RestAssured.delete("http://localhost:3000/posts/4.2484245502926505");
		int code= response.getStatusCode();
	Assert.assertEquals(code,200);*/
	
	
	
	
	}

