package assignment4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Assignment 4 - Pair Programming Project
 *
 * @author Faiyaz Mirza
 * @author Eric Brown
 * @since 2020-11-05
 * This class contains declared variables & Setter/Getter for class Message with business rules.
 */
public class Message {
	/**
	 * Default constructor that sets all the Strings to {@value #NOT_AVAILABLE}.
	 */
	public Message() {
		this(Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE);
	}
	
	/**
	 * Constructor with all string arguments
	 * @param sender
	 * @param recipient
	 * @param content
	 * @param date
	 * @param time
	 */
	public Message(String sender, String recipient, String content, String date, String time) {
		super();
		setSender(sender);
		setRecipient(recipient);
		setContent(content);
		setDate(date);
		setTime(time);
	}

	public static final String NOT_AVAILABLE = "---";
	
	private String sender;
	private String recipient;
	private String content;
	private String date;
	private String time;
	
	/**
	 * Getter for the sender attribute. If the value has not been set, the returned string will contain {@value #NOT_AVAILABLE}.
	 * @return A String with the sender's name
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * Setter for the sender attribute. The setter will only accepts strings of length 1-40, with alphabetic characters, hyphens, commas, periods, spaces, and apostrophes.
	 * @param sender A string with the sender's name
	 */
	public void setSender(String sender) {
		// Checking if the string is null
		if ( sender == null )
			return;
		
		// Removing leading and trailing whitespace
		sender = sender.trim();
		
		if ( sender.equalsIgnoreCase(NOT_AVAILABLE) ) {
			this.sender = NOT_AVAILABLE;
			return;
		}
		
		// Replacing multiple spaces within the string
		sender = sender.replaceAll("[ ]+", " "); // I am using a basic regular expression
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( sender.length() < 1 || sender.length() > 40 )
			return;
		
		// Check for characters other than alphabetic, hyphens, apostrophes, commas, dots, and spaces
		if ( !sender.matches("[A-Za-z\\'\\-\\ ,\\.]+") )
			return;
		
		this.sender = sender;
	}
	
	/**
	 * Getter for the recipient attribute. If the value has not been set, the returned string will contain {@value #NOT_AVAILABLE}.
	 * @return A String with the recipient's name
	 */
	public String getRecipient() {
		return recipient;
	}
	
	/**
	 * Setter for the recipient attribute. The setter will only accepts strings of length 1-40, with alphabetic characters, hyphens, commas, periods, spaces, and apostrophes.
	 * @param recipient A string with the recipient's name
	 */
	public void setRecipient(String recipient) {
		// Checking if the string is null
		if ( recipient == null )
			return;
		
		// Removing leading and trailing whitespace
		recipient = recipient.trim();
		
		if ( recipient.equalsIgnoreCase(NOT_AVAILABLE) ) {
			this.recipient = NOT_AVAILABLE;
			return;
		}
		
		// Replacing multiple spaces within the string
		recipient = recipient.replaceAll("[ ]+", " "); // I am using a basic regular expression
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( recipient.length() < 1 || recipient.length() > 40 )
			return;
		
		// Check for characters other than alphabetic, hyphens, apostrophes, commas, dots, and spaces
		if ( !recipient.matches("[A-Za-z\\'\\-\\ ,\\.]+") )
			return;
		
		this.recipient = recipient;
	}

	/**
	 * Getter for the content attribute. If the value has not been set, the returned string will contain {@value #NOT_AVAILABLE}.
	 * @return A String with the content of the message
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Setter for the content attribute. The setter only accepts strings of length 1-500.
	 * @param content A string with the content of the message
	 */
	public void setContent(String content) {
		// Checking if the string is null
		if ( content == null )
			return;
		
		// Removing leading and trailing whitespace
		content = content.trim();
		
		if ( content.equalsIgnoreCase(NOT_AVAILABLE) ) {
			this.content = NOT_AVAILABLE;
			return;
		}
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( content.length() < 1 || content.length() > 500 )
			return;
		
		this.content = content;
	}

	/**
	 * Getter for the date attribute in the format 2020-01-01. If the value has not been set, the returned string will contain {@value #NOT_AVAILABLE}.
	 * @return A String with the date the message was sent
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Setter for the date attribute. The setter expects a date in the format 2020-01-30.
	 * @param date A string with the date the message was sent
	 */
	public void setDate(String date) {
		if ( date == null )
			return;
		
		date = date.trim();
		
		if ( date.equalsIgnoreCase(NOT_AVAILABLE) ) {
			this.date = NOT_AVAILABLE;
			return;
		}
		
		if ( !date.matches("\\d{4}-\\d{2}-\\d{2}"))
			return;
		
		LocalDate tempDate = LocalDate.parse(date);
		LocalDate now = LocalDate.now();
		
		if ( tempDate.isAfter(now) )
			return;
		
		this.date = date;
	}

	/**
	 * Getter for the time attribute in the format 12:34. If the value has not been set, the returned string will contain {@value #NOT_AVAILABLE}.
	 * @return A String with the time the message was sent
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * Setter for the time attribute. The setter expects a time in the format 12:34.
	 * @param time A string with the time the message was sent
	 */
	public void setTime(String time) {
		if ( time == null )
			return;
		
		time = time.trim();
		
		if ( time.equalsIgnoreCase(NOT_AVAILABLE) ) {
			this.time = NOT_AVAILABLE;
			return;
		}
		
		if ( !time.matches("\\d{2}:\\d{2}"))
			return;
		
		// Checking if there is a current date set, and if it's today
		if ( !date.equalsIgnoreCase(NOT_AVAILABLE) ) {
			LocalDate currentDate = LocalDate.now();
			LocalDate messageDate = LocalDate.parse(date);
			
			if ( currentDate.isEqual(messageDate) ) {
				LocalTime currentTime = LocalTime.now();
				LocalTime messageTime = LocalTime.parse(time);
				
				LocalDateTime messageDateTime = LocalDateTime.of(messageDate, messageTime);
				LocalDateTime currentDateTime = LocalDateTime.of(currentDate, currentTime);
				
				if ( messageDateTime.isAfter(currentDateTime) )
					return;
			}
		}
		
		this.time = time;
	}
	
	/**
	 * Getter that returns the age of the message in minutes
	 * @return A long value containing the age of the message in minutes
	 */
	public long getAge() {
		if ( date.equalsIgnoreCase(Message.NOT_AVAILABLE) || time.equalsIgnoreCase(Message.NOT_AVAILABLE) )
			return Long.MAX_VALUE;
		
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		LocalDateTime currentDateTime = LocalDateTime.of(today, now);
		LocalDate messageDay = LocalDate.parse(date);
		LocalTime messageTime = LocalTime.parse(time);
		LocalDateTime messageDateTime = LocalDateTime.of(messageDay, messageTime);
		
		Duration messageAge = Duration.between(messageDateTime, currentDateTime);
		long messageAgeInMinutes = messageAge.toMinutes()-1;
		
		return messageAgeInMinutes;
	}
	
	public String toString() {
		String toReturn = "Sender's name: " + sender;
		toReturn += "\nRecipient's name: " + recipient;
		toReturn += "\nContent: " + content;
		toReturn += "\nSent on: " + date + " " + time;// + " (" + getAge() + " minutes old)";
		return toReturn;
	}
}
