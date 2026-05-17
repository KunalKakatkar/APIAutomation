//contains only urls
package api.endpoints;

public class Routes {
	
	//Swagger URLS         - https://petstore.swagger.io/#/
	//Create user(Post)    - https://petstore.swagger.io/v2/user
	//Get user (Get)       - https://petstore.swagger.io/v2/user/{username}
	//update user (put)    - https://petstore.swagger.io/v2/user/{username}
	//Delete user (delete) - https://petstore.swagger.io/v2/user/{username}

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url   = base_url+"/user";
	public static String get_url    = base_url+"/user/{username}";
	public static String put_url    = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module
	
	
	//Pet module
	
	
}
