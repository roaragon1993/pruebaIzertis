package testingAPI;

import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class PetTest {

	final static String GET_SOLD_PETS_URL = "https://petstore.swagger.io/v2/pet/findByStatus?status=sold";
	
	public void getSoldPetsTest() throws Exception {
		HttpClient httpclient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(GET_SOLD_PETS_URL);

		HttpResponse httpResponse = httpclient.execute(httpGet);
		String response = EntityUtils.toString(httpResponse.getEntity());
		
		Gson gson = new Gson();
        Pet[] pets = gson.fromJson(response,
        		Pet[].class);
        
        JsonArray jsonArray = gson.toJsonTree(pets).getAsJsonArray();
        System.out.println(jsonArray.toString());
        
	}
	
	public void countPetsByNameTest() throws Exception {
		HttpClient httpclient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(GET_SOLD_PETS_URL);

		HttpResponse httpResponse = httpclient.execute(httpGet);
		String response = EntityUtils.toString(httpResponse.getEntity());
		
		Gson gson = new Gson();
        Pet[] pets = gson.fromJson(response,
        		Pet[].class);
        
        PetList petList = new PetList(pets);
        HashMap<String, Integer> petMap = petList.countPetsByName();
        
        System.out.println(gson.toJson(petMap));
	}
	
	
}
