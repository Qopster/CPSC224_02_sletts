//test here

public class InClassAssignment{

	public static void main(String args[])
	{
		int choice = 10;
		int distance = 0;
		while(choice != 0){
			System.out.println("Please enter a distance in meters");
			
		}
	}
	public static int showKilometers(int num){
		return num*0.001;
	}
	public static int showInches(int num){
		return num*39.37;
	}
	public static int showFeet(int num){
		return num*3.281;
	}
	public static void showMenu(int num){
		System.out.println("1. Convert to Kilometers.");
		System.out.println("2. Convert to Inches.");
		System.out.println("3. Convert to Feet.");
		System.out.println("4. Quit the Program.");
		System.out.println();
		System.out.println("Enter your choice: ");
	}
}	
