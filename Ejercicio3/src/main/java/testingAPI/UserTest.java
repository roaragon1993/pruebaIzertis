package testingAPI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UserTest {
	final static String CREATE_USER_URL = "https://petstore.swagger.io/v2/user";
	final static String GET_USER_URL = "https://petstore.swagger.io/v2/user";
	final static String USERNAME = "roares";

	public void createUserTest() throws Exception {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(CREATE_USER_URL);

		final String json = "{\"username\":\""+ USERNAME +"\",\"firstName\":\"rocio\",\"lastName\":\"aragon\",\"email\":\"ro@email.com\",\"password\":\"1234\",\"phone\":\"\"}";
		final StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		HttpResponse httpResponse = httpclient.execute(httpPost);
		System.out.println(EntityUtils.toString(httpResponse.getEntity()));
	}

	public void getUserByUsernameTest() throws Exception {
		HttpClient httpclient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(GET_USER_URL + "/" + USERNAME);

		HttpResponse httpResponse = httpclient.execute(httpGet);
		System.out.println(EntityUtils.toString(httpResponse.getEntity()));
	}
}
