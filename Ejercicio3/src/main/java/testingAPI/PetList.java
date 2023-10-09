package testingAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PetList {
	List<Pet> petList;

	public PetList (Pet[] petList) {
		this.petList = Arrays.asList(petList);
	}
	
	public HashMap<String, Integer> countPetsByName() {
		HashMap<String, Integer> petMap = new HashMap<String, Integer>();
		for(Pet p : this.petList) {
			if(petMap.containsKey(p.name)) {
				int count = petMap.get(p.name).intValue(); 
				petMap.replace(p.name, count+1);
			} else {
				petMap.put(p.name, 1);
			}
		}
		
		return petMap;
	}
}
