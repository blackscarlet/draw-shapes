package kim.test.june2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculations {

	public int userInput(String prompt){
		String inputLine = null;
		System.out.println(prompt);
		
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length()==0) return 0;
			
		}		catch (IOException e){ System.out.println("IO Exception" + e);
		}
		return Integer.parseInt(inputLine);		
	}
	
	public double calculateAreaInSft(int num1, int num2){
			double dim1 = num1*3.2808;
			double dim2 = num2*3.2808;
			double area = dim1*dim2;
			return area;
	}
}
