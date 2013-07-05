package kim.test.june2013;

public class CalculatorTestAreaOfAptInSft {

	/**
	 * The program calculates the area of an apartment in Sft using the dimension in meters for each room
	 */
	public static void main(String[] args) {
	
		Calculations CalculateArea = new Calculations();
		int dim1, dim2;
		double areaResult, finalResult=0;
		int numOfRooms, rooms;
		// get number of rooms from user
		numOfRooms = CalculateArea.userInput("Enter number of rooms: ");
		rooms = numOfRooms;
		
		// Repeat each calculation for each room
		while(rooms>0){
		// get dimensions from user 
		dim1 = CalculateArea.userInput("Enter dimension 1 in meters: ");
		dim2 = CalculateArea.userInput("Enter dimension 2 in meters: ");
		
		areaResult = CalculateArea.calculateAreaInSft(dim1, dim2);
		System.out.println("Area in SquareFt: " + areaResult);
		
		finalResult += areaResult;
		rooms--;
		}
		System.out.println("Area of Apartment in Sft: " + finalResult);
	
	}

}
