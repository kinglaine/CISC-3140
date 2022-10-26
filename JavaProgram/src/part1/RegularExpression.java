package part1;
import java.util.*;
public class RegularExpression {
	public static int dateCalculator(String dateOne, String dateTwo) {
		//declare dates variables
		double dateOneMonths;
		double dateOneDays;
		double dateOneYears;
		
		double dateTwoMonths;
		double dateTwoDays;
		double dateTwoYears;
		String format1 = "\\d{2}-\\d{2}"; String format2 = "\\d{2}\\/\\d{2}\\/\\d{4}";
		
		//check input format 
		if(dateOne.matches(format1) && dateTwo.matches(format2)) {
			//get the values for first date
			dateOneMonths = Double.parseDouble(dateOne.substring(0,2));
			dateOneDays = Double.parseDouble(dateOne.substring(3,5));
			dateOneYears = 2023;
			
			//get the values for second date
			dateTwoMonths = Double.parseDouble(dateTwo.substring(0,2));
			dateTwoDays = Double.parseDouble(dateTwo.substring(3,5));
			dateTwoYears = Double.parseDouble(dateTwo.substring(6,10));
				
		}else if(dateOne.matches(format2) && dateTwo.matches(format1)) {
			//get the values for first date
			dateOneMonths = Double.parseDouble(dateOne.substring(0,2));
			dateOneDays = Double.parseDouble(dateOne.substring(3,5));
			dateOneYears = Double.parseDouble(dateOne.substring(6,10));
			
			//get the values for second date
			dateTwoMonths = Double.parseDouble(dateTwo.substring(0,2));
			dateTwoDays = Double.parseDouble(dateTwo.substring(3,5));
			dateTwoYears = 2023;
		} else if(dateOne.matches(format1) && dateTwo.matches(format1)) {
			//get the values for first date
			dateOneMonths = Double.parseDouble(dateOne.substring(0,2));
			dateOneDays = Double.parseDouble(dateOne.substring(3,5));
			dateOneYears = 2023;
			
			//get the values for second date
			dateTwoMonths = Double.parseDouble(dateTwo.substring(0,2));
			dateTwoDays = Double.parseDouble(dateTwo.substring(3,5));
			dateTwoYears = 2023;
		}else {
			//get the values for first date
			dateOneMonths =Double.parseDouble(dateOne.substring(0,2));
			dateOneDays = Double.parseDouble(dateOne.substring(3,5));
			dateOneYears = Double.parseDouble(dateOne.substring(6,10));
			
			//get the values for second date
			dateTwoMonths = Double.parseDouble(dateTwo.substring(0,2));
			dateTwoDays =Double.parseDouble(dateTwo.substring(3,5));
			dateTwoYears = Double.parseDouble(dateTwo.substring(6,10));
			
		}
		//subtract monthsOne from monthTwo to get how many months left then convert to days
		double daysInMonths = (Math.abs(dateTwoMonths - dateOneMonths)/12) * 365;
		double daysInDays = Math.abs(dateTwoDays - dateOneDays);
		double daysInYears  = Math.abs(dateTwoYears - dateOneYears) * 365;
		
		int days = (int)(daysInMonths + daysInDays + daysInYears);
		
		return days;
	}
  	public static String getDateOne(String dates) {
  		String dateOne;
  		String format1 = "\\d{2}-\\d{2}"; String format2 = "\\d{2}\\/\\d{2}\\/\\d{4}";
		//check input format 
		if(dates.matches(format1 + " " + format2)) {
			dateOne = dates.substring(0,6);	
		}else if(dates.matches(format2 + " " + format1)) {
			dateOne = dates.substring(0,10);
		} else if(dates.matches(format1 + " " + format1)) {
			dateOne = dates.substring(0,5);
		}else {
			dateOne = dates.substring(0,10);
		}
		return dateOne;
	}
	public static String getDateTwo(String dates) {
		String dateTwo;
		String format1 = "\\d{2}-\\d{2}"; String format2 = "\\d{2}\\/\\d{2}\\/\\d{4}";
		//check input format 
		if(dates.matches(format1 + " " + format2)) {
			dateTwo = dates.substring(6,16);	
		}else if(dates.matches(format2 + " " + format1)) {
			dateTwo = dates.substring(11,16);
		} else if(dates.matches(format1 + " " + format1)) {
			dateTwo = dates.substring(6,11);
		}else {
			dateTwo = dates.substring(11,21);
		}
		return dateTwo;
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
		System.out.println("Type I to Enter your own dates");
		
		String in = input.next();
			switch(in) {
				case "AQ":
					System.out.println("There are " + dateCalculator(assignmentDueDate, quizDate) + " days between the assignment and the quiz.");
					break;
				case "AF":
					System.out.println("There are " + dateCalculator(assignmentDueDate, finalDate) + " days between the assignment and the final.");
					break;
				case "QF":
					System.out.println("There are " + dateCalculator(finalDate, quizDate) + " days between the quiz and the final.");
					break;
				case "I":
					try {
						while(true) {
							System.out.print("Enter two dates in MM/DD/YYY or MM-DD format seperate by space:");
							String dates = input.next() + " " +  input.next();
							if((getDateOne(dates).matches("\\d{2}-\\d{2}") || getDateOne(dates).matches("\\d{2}\\/\\d{2}\\/\\d{4}"))
							&& getDateTwo(dates).matches("\\d{2}-\\d{2}") || getDateTwo(dates).matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
								System.out.println("There are " + dateCalculator(getDateOne(dates),getDateTwo(dates)) + " days between " + 
										getDateOne(dates) + " and "  + getDateTwo(dates));
							}
							
						}
					}catch(Exception e) {
						System.out.println(" wrong input!");
					}
					
			}
		
		
	}

}
