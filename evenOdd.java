package assignmentTwo;

import acm.program.ConsoleProgram;

public class evenOdd extends ConsoleProgram{
	
	public void run() {
		
		int number = readInt("Enter a number");
		
		//println(checkEven(number));
		println(convertToEuro(number));
	}
	
	private String checkEven( int number ) {	
	
		if (number % 2 == 0) {
			return "number is even";
		} else {
			return "number is odd";
		}
	}
	
	private String convertToEuro(int moneyInCents) {
		
		int euros = moneyInCents / 100;
		
		int cents = (100 + moneyInCents) % 100;
		
		return euros + " euros" + ", " + cents + " cents";
		
	}
}
