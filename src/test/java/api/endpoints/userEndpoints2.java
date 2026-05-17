package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import api.payload.User;



//Created to perform CURD operations on users module and get end urls from properties file

public class userEndpoints2 {
	
	static Properties prop;
	
	static {
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/routes.properties");
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	public static Response createUser(User payload){
	//	System.out.println(prop.getProperty("post_url"));
		
	Response response = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(prop.getProperty("post_url"));
	
	return response;	
	}
	
	
	public static Response readUser(String username){
		
		Response response = 
			given()
				.pathParam("username", username)
			.when()
				.get(prop.getProperty("get_url"));
		
		return response;	
		}
	
	public static Response updateUser(User payload, String username){
		
		Response response = 
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
			.when()
				.put(prop.getProperty("put_url"));
		
		return response;	
		}
	
	public static Response deleteUser(String username){
		
		Response response = 
			given()
				.pathParam("username", username)
			.when()
				.delete(prop.getProperty("delete_url"));
		
		return response;	
		}
	
	}

