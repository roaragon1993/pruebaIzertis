package testingAPI;

public class Main {

	public static void main(String[] args) throws Exception {
		UserTest userTest = new UserTest();
		userTest.createUserTest();
		userTest.getUserByUsernameTest();
		
		PetTest petTest = new PetTest();
		petTest.getSoldPetsTest();
		petTest.countPetsByNameTest();
	}
}
