package part1;
import java.util.*;
public class RegularExpression {
	public static int dateCalculator(String dateOne, String dateTwo) {
		//declare dates variables
		int dateOneMonths;
		int dateOneDays;
		int dateOneYears;
		
		int dateTwoMonths;
		int dateTwoDays;
		int dateTwoYears;
		
		//check input format 
		if(dateOne.matches("\\d{2}-\\d{2}") && dateTwo.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
			//get the values for first date
			dateOneMonths = Integer.parseInt(dateOne.substring(0,2));
			dateOneDays = Integer.parseInt(dateOne.substring(3,5));
			dateOneYears = 2023;
			
			//get the values for second date
			dateTwoMonths = Integer.parseInt(dateTwo.substring(0,2));
			dateTwoDays = Integer.parseInt(dateTwo.substring(3,5));
			dateTwoYears = Integer.parseInt(dateTwo.substring(6,10));
				
		}else if(dateOne.matches("\\d{2}\\/\\d{2}\\/\\d{4}") && dateTwo.matches("\\d{2}-\\d{2}")) {
			//get the values for first date
			dateOneMonths = Integer.parseInt(dateOne.substring(0,2));
			dateOneDays = Integer.parseInt(dateOne.substring(3,5));
			dateOneYears = Integer.parseInt(dateOne.substring(6,10));
			
			//get the values for second date
			dateTwoMonths = Integer.parseInt(dateTwo.substring(0,2));
			dateTwoDays = Integer.parseInt(dateTwo.substring(3,5));
			dateTwoYears = 2023;
		} else if(dateOne.matches("\\d{2}-\\d{2}") && dateTwo.matches("\\d{2}-\\d{2}")) {
			//get the values for first date
			dateOneMonths = Integer.parseInt(dateOne.substring(0,2));
			dateOneDays = Integer.parseInt(dateOne.substring(3,5));
			dateOneYears = 2023;
			
			//get the values for second date
			dateTwoMonths = Integer.parseInt(dateTwo.substring(0,2));
			dateTwoDays = Integer.parseInt(dateTwo.substring(3,5));
			dateTwoYears = 2023;
		}else {
			//get the values for first date
			dateOneMonths = Integer.parseInt(dateOne.substring(0,2));
			dateOneDays = Integer.parseInt(dateOne.substring(3,5));
			dateOneYears = Integer.parseInt(dateOne.substring(6,10));
			
			//get the values for second date
			dateTwoMonths = Integer.parseInt(dateTwo.substring(0,2));
			dateTwoDays = Integer.parseInt(dateTwo.substring(3,5));
			dateTwoYears = Integer.parseInt(dateTwo.substring(6,10));
			
		}
		//subtract monthsOne from monthTwo to get how many months left then convert to days
		int daysInMonths = (Math.abs(dateTwoMonths - dateOneMonths)/12) * 365;
		int daysInDays = Math.abs(dateTwoDays - dateOneDays);
		int daysInYears  = Math.abs(dateTwoYears - dateOneYears) * 365;
		
		int days = daysInMonths + daysInDays + daysInYears;
		
		return days;
	}
	public static void main(String[] args) {
		// allow user to select between available saved dates
		final String assignmentDueDate = "04/05/2022";
		final String quizDate  = "08/20/2022";
		final String finalDate = "07/15/2022";
		
		//declare scanner
		Scanner input = new Scanner(System.in);
		//find days between saved dates
		System.out.println("Type AQ then Enter to get days between assignment and quiz date");
		System.out.println("Type AF then Enter to get days between assignment and final date");
		System.out.println("Type QF then Enter to get days between quiz  and final");
		System.out.println("Type anything to Enter your own dates");
		
			switch(input.next()) {
				case "AQ":
					System.out.println("There are " + dateCalculator(assignmentDueDate, quizDate) + " days between the assignment and the quiz.");
					break;
				case "AF":
					System.out.println("There are " + dateCalculator(assignmentDueDate, finalDate) + " days between the assignment and the final.");
					break;
				case "QF":
					System.out.println("There are " + dateCalculator(finalDate, quizDate) + " days between the quiz and the final.");
					break;
				default:
					while(true) {
						System.out.print("Enter first date in MM/DD/YYY or MM-DD format: ");
						String dateOne = input.next();
						if(!dateOne.matches("\\d{2}-\\d{2}") && !dateOne.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
							System.out.println("Wrong input!");
						}
						System.out.print("Enter second date in MM/DD/YYY or MM-DD format: ");
						String dateTwo = input.next();
						if(!dateTwo.matches("\\d{2}-\\d{2}") && !dateTwo.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
							System.out.println("Wrong input!");
						}else {
							System.out.println("There are " + dateCalculator(dateOne,dateTwo) + " days bewteen " + dateOne + " and " + dateTwo + "\n");
						}
						
					}
			}
	}

}
