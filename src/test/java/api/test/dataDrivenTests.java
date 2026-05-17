package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class dataDrivenTests {
	
	//Create multiple users and delete then
	
	@Test(priority=1,dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostuser(String userID, String userName, String fName, String lName, String useremail, String password, String phone){
		
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response response = userEndpoints.createUser(userPayload);
		response.then();
			//	.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider="UserName", dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userID) {
		
		Response response = userEndpoints.deleteUser(userID);
		response.then();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
		
	

}
