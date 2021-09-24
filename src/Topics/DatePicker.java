package Topics;


import java.io.IOException;
import java.util.Calendar;

public class DatePicker {

	private String departureDate = null;
	private String returnDate = null;

	public String getDepartureDate() {
		return departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	// Picks up current system for Departure DAte and +7 days for Return date
	// Returns in format tue 13 Apr 2019
	public static DatePicker getDates() throws NumberFormatException, IOException {
		DatePicker date = new DatePicker();
		Calendar cal = Calendar.getInstance();

		String[] rawDate = cal.getTime().toString().split(" ");
		date.departureDate = rawDate[0] + " " + rawDate[1] + " " + rawDate[2] + " " + rawDate[5];
		cal.add(Calendar.DATE, Integer.parseInt("7"));
		rawDate = cal.getTime().toString().split(" ");
		date.returnDate = rawDate[0] + " " + rawDate[1] + " " + rawDate[2] + " " + rawDate[5];
		return date;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		DatePicker date = DatePicker.getDates();
		
		System.out.println(date.getDepartureDate());
		System.out.println(date.returnDate);
		
	}
}