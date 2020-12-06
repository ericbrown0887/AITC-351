package assignment2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * Assignment 4 - Pair Programming Project
 *
 * @author Faiyaz Mirza
 * @author Eric Brown
 * @since 2020-11-05
 * This class contains declared variables and demonstrates Encapsulation and Setters with business rules for class Message
 */
public class Message {

	/**
	 * Static polymorphism with default constructor that sets all the Strings to default values.
	 */
	public Message() {
		this(Message.DEFAULT_SENDER, Message.DEFAULT_RECIP, Message.DEFAULT_CONTENT, Message.DEFAULT_DATE, Message.DEFAULT_TIME);
	}
	/**
	 * Constructor with all string arguments
	 * @param sender
	 * @param recip
	 * @param content
	 * @param date
	 * @param time
	 */
	public Message(String sender, String recip, String content, String date, String time) {
		setSender(sender);
		setRecip(recip);
		setContent(content);
		setDate(date);
		setTime(time);
	}
	/**
	 * Constants to represent unknown values for null or invalid inputs
	 */
	private static final String DEFAULT_SENDER = "---";
	private static final String DEFAULT_RECIP = "---";
	private static final String DEFAULT_CONTENT = "---";
	private static final String DEFAULT_DATE = "---";
	private static final String DEFAULT_TIME = "---";
	public static final String NOT_AVAILABLE = "---";
	
	
	private String sender;
	private String recip;
	private String content;
	private String date;
	private String time;

	/**
	 * A method that returns the name of the Sender
	 * @return A String containing the name of the Sender. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getSender() {
		return sender;
	}
	/**
	 * A method that set the value of the variable 'sender' and checks for business rules.
	 * 
	 * @param sender A string containing no more than 40 alphabetic characters, no consecutive spaces,
	 * and only special character: "-", "'", ",", "."
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSender(String sender) {
		// Checking if the string is null
		if ( sender == null )
			return;
		
		// Removing leading and trailing whitespace
		sender = sender.trim();
		
		// Replacing multiple spaces within the string
		sender = sender.replaceAll("[ ]+", " ");
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( sender.length() < 1 || sender.length() > 40 )
			return;
		
		// Check for characters other than alphabetic, hyphens, apostrophes, commas, dots, and spaces
		if ( !sender.matches("[A-Za-z\\'\\-\\ ,\\.]+") )
			return;
		
		this.sender = sender;
		
	}
	/**
	 * A method that returns the name of the Recipient.
	 * @return A String containing the name of the Recipient. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getRecip() {
		return recip;
	}
	/**
	 * A method that set the value of the variable 'recip' and checks for business rules.
	 * 
	 * @param recip A string containing no more than 40 alphabetic characters, no consecutive spaces,
	 * and only special character: "-", "'", ",", "."
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setRecip(String recip) {
		// Checking if the string is null
			if ( recip == null )
				return;
			
			// Removing leading and trailing whitespace
			recip = recip.trim();
			
			// Replacing multiple spaces within the string
			recip = recip.replaceAll("[ ]+", " "); // I am using a basic regular expression
			
			// Checking for the length of the string once all the whitespace has been removed
			if ( recip.length() < 1 || recip.length() > 40 )
				return;
			
			// Check for characters other than alphabetic, hyphens, apostrophes, commas, dots, and spaces
			if ( !recip.matches("[A-Za-z\\'\\-\\ ,\\.]+") )
				return;
			
			this.recip= recip;
	}
	
	/**
	 * A method that returns the content of the message.
	 * @return A String containing the content of the message. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * A method that set the value of the variable 'content' and checks for business rule:
	 * 	1. String contains no more than 500 characters.
	 * @param content A String containing no more than 500 characters.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setContent(String content) {
	// Checking if the string is null
		if ( content == null )
			return;
		
		// Removing leading and trailing whitespace
		content = content.trim();
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( content.length() < 1 || content.length() > 500 )
			return;
		
		this.content = content;
	}

	/**
	 * A method that returns the date.
	 * @return A String containing the date input by the user. Returns "null" if input is invalid
	 * according to business rules.
	 */public String getDate() {
		return date;
	}
	/**
	 * A method that sets the value of the variable 'date' and checks for business rule.
	 * 
	 * @param date A String following the date format of yyyy-MM-dd
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setDate(String date) throws DateTimeParseException {
		
		// Check if string is null
		if ( date == null )
			return;
	
		// Remove leading and trailing whitespace
		date = date.trim();
		
		// Regex check if date matches pattern yyyy-MM-dd
		if ( !date.matches("\\d{4}-\\d{2}-\\d{2}"))
			return;
		
		// Create variable newDate to parse user date input to LocalDate format
		// create variable localDate to store current local date
		LocalDate newDate = LocalDate.parse(date);
		LocalDate localDate = LocalDate.now();
		
		// Boolean isAfter to check if user date input is after current local date
		if ( newDate.isAfter(localDate) )
			return;
		
		this.date = date;
	}

	/**
	 * A method that returns the time.
	 * @return A String containing the time input by the user. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getTime() {
		return time;
	}
	/**
	 * A method that sets the value of the variable 'time' and checks for business rule.
	 *
	 * @param time A String following the time format of hh-MM
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setTime(String time)  throws DateTimeParseException, NullPointerException {
		// Check if input is null
		if ( time == null )
			return;
		
		// Trim leading and trailing whitespace
		time = time.trim();
		
		// Regex validation if time input matches hh:mm
		if ( !time.matches("\\d{2}:\\d{2}"))
			return;
		
		if (!date.equalsIgnoreCase(NOT_AVAILABLE) ) {
			// Like above store user date input, store current local date
			LocalDate newDate = LocalDate.parse(date);
			LocalDate localDate = LocalDate.now();
			
			if (localDate.isEqual(newDate) ) {
				// Similar to storing date, instead store user time input and local time
				LocalTime newTime = LocalTime.parse(time);
				LocalTime localTime = LocalTime.now();
				
				LocalDateTime messageDateTime = LocalDateTime.of(newDate, newTime);
				LocalDateTime currentDateTime = LocalDateTime.of(localDate, localTime);
				
				if ( messageDateTime.isAfter(currentDateTime) )
					return;
				
			}
		}
			
		this.time = time;
	}
	/**
	 * A method that calculates the age of the message based on the users date/time input vs the local date/time in minutes.
	 * @param age A long value that is calculated by comparing the user's datetime input vs the local date/time input in minutes
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public long getAge() {
		if ( date.equalsIgnoreCase(Message.NOT_AVAILABLE) || time.equalsIgnoreCase(Message.NOT_AVAILABLE) )
			return Long.MAX_VALUE;
		// Like above store user date input, store current local date
		LocalDate newDate = LocalDate.parse(date);
		LocalDate localDate = LocalDate.now();
		
		// Similar to storing date, instead store user time input and local time
		LocalTime newTime = LocalTime.parse(time);
		LocalTime localTime = LocalTime.now();
		
		// Store message datetime in variable messageDateTime, store current datetime in variable currentDateTime
		LocalDateTime messageDateTime = LocalDateTime.of(newDate, newTime);
		LocalDateTime currentDateTime = LocalDateTime.of(localDate, localTime);
		
		// Use object Duration to calculate the elapsed time between user input datetime and current datetime, calculate to minutes
		Duration messageAge = Duration.between(messageDateTime, currentDateTime);
		long messageAgeInMinutes = messageAge.toMinutes();
		return messageAgeInMinutes;
	}
	
	/**
	 * Method to return all user input as a string
	 */
	public String toString() {
		String toReturn = "Sender's name: " + sender;
		toReturn += "\nRecipient's name: " + recip;
		toReturn += "\nContent: " + content;
		toReturn += "\nSent on: " + date + " " + time + " (" + getAge() + " minutes old)";
		return toReturn;
	}

}
