package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.github.javafaker.*;
import api.endpoints.userEndpoints;
import api.payload.User;

public class userTests {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		
	}
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response response = userEndpoints.createUser(userPayload);
		response.then()
					.log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUser() {
		Response response = userEndpoints.readUser(this.userPayload.getUsername());
			response.then()
		//		.statusCode(200) can use any validation for status code
				.log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		Response response = userEndpoints.updateUser(userPayload,this.userPayload.getUsername());
		response.then()
				.log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		String fName = this.userPayload.getFirstName();
		String lName = this.userPayload.getLastName();
		
		//Verifying update
		Response responseUpdates = userEndpoints.readUser(this.userPayload.getUsername());
		responseUpdates.then()
			.log().all();
		Assert.assertEquals(responseUpdates.getStatusCode(), 200);
		Assert.assertEquals(responseUpdates.jsonPath().getString("firstName"), fName);
		Assert.assertEquals(responseUpdates.jsonPath().getString("lastName"), lName);
			
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response response = userEndpoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
