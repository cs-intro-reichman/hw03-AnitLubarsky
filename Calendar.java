/** 
	 * Prints the calendars of the chosen year. also prints sunday on the first day of every week.
	 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	public static void main(String args[]) {
		int PickYear = Integer.parseInt(args[0]);
		// Advances the date and the day-of-the-week from 1/1/1900 till the chosen year.
		//Then prints the calender of the chosen year.
	    //int debugDaysCounter = 0;	   
	 	while (year < PickYear) {					
	 		advanceuntilPickYear();
			year++;
		}
		if ( year == PickYear){
			advance();
		}
	 		// debugDaysCounter++;	 		
	 		//   if (debugDaysCounter == n) { 
	 		//   	break;
	 		// }	 	
	}
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advanceuntilPickYear() {		
			for ( int m = 1; m <= 12; m++){							
				dayOfMonth = nDaysInMonth(m, year);
				dayOfWeek = (dayOfMonth + dayOfWeek - 28) % 7;				
			}
	 } 
	 private static void advance() {		
			for ( int m = 1; m <= 12; m++){
				dayOfMonth = nDaysInMonth(m, year);
				;
				for (int d = 1; d <= dayOfMonth; d++ ){
					if (dayOfWeek == 1){
						System.out.printf("%d/%d/%d Sunday \n", d, m, year );					
					} else {
						System.out.printf("%d/%d/%d \n" , d, m, year );
					}					
					dayOfWeek = (dayOfWeek + 1) % 7;
				}				
			}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    if ( (year % 400 == 0 ) || (( year % 4 == 0 ) && ( year % 100 != 0 ))){
			return true;			 
	   } else {
		   return false;
	   }		
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
			case 1: return 31;	 		
			case 2:
			if (isLeapYear(year) == true) {
					return 29;
			} else {
				return 28;
			}					
			case 3: return 31;				
			case 4: return 30;				
			case 5: return 31;				
			case 6: return 30;				
			case 7: return 31;				
			case 8: return 31;				
			case 9: return 30;				
			case 10: return 31;				
			case 11: return 30;				
			case 12: return 31;
			default: break;				
		}	
		return -1;		
	}
}