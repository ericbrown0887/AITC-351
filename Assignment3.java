package assignment3;

import java.util.Scanner;

/**
 * Parent class that includes main for Assignment 3
 * 
 * @author Eric Brown
 * @since 2020-09-25
 */

public class Assignment3 {
	/**
	 * The main method prompting users for input and then printing output.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create scanner input
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Assignment 3");
		
		System.out.println("1. Default Message\n2. Chat message\n3. Email message\n4. Text (SMS) message\n5. Long text message");
		
		// Get user input for message choice
		System.out.print("Select the type of message you would like to create: \n");
		int userChoice = Integer.parseInt(userInput.nextLine());
		System.out.println("You entered: " + userChoice);
		
		// switch/case giving user choice of message to create
		switch(userChoice) {
		case 1: // Simple message
			Message m = new Message();
			getMessageInfo(m, userInput);
			System.out.println("You entered:");
			// Single catch block if date format throws a DateTimeParseExecption or NullPointerException
			try {
				System.out.println(m);
			} catch (Exception e) {
				System.out.println("Invalid input. Please try your message again.");
			}
			break;
		case 2: // Chat
			Chat c = new Chat();
			getChatInfo(c, userInput);
			System.out.println("You entered:");
			System.out.println(c);
			break;
		case 3: // Email
			Email e = new Email();
			getEmailInfo(e, userInput);
			System.out.println("You entered:");
			System.out.println(e);
			break;
		case 4: // SMS
			SMS s = new SMS();
			getSMSInfo(s, userInput);
			System.out.println("You entered:");
			System.out.println(s);
			break;
		case 5: // Long SMS
			LongSMS l = new LongSMS();
			getLongSMSInfo(l, userInput);
			System.out.println("You entered:");
			System.out.println(l);
			break;
		default:
			System.out.println("Invalid input");
		}
		
		userInput.close();
	}
	
	/**
	 * Method for retrieving user's LongSMS input
	 * @param longSMS
	 * @param userInput
	 */
	public static void getLongSMSInfo(LongSMS longSMS, Scanner userInput) {
		getSMSInfo(longSMS, userInput);
	}
	
	/**
	 * Method for retrieving user's SMS input
	 * @param sms
	 * @param userInput
	 */
	public static void getSMSInfo(SMS sms, Scanner userInput) {
		getMessageInfo(sms, userInput);
		
		System.out.print("Enter the sender's phone number ( (XXX) YYY-ZZZZ ): ");
		sms.setSenderPhone(userInput.nextLine());
		
		System.out.print("Enter the recipient's phone number ( (XXX) YYY-ZZZZ ): ");
		sms.setRecipPhone(userInput.nextLine());
	}
	/**
	 * Method for retrieving user's Email input
	 * @param email
	 * @param userInput
	 */
	public static void getEmailInfo(Email email, Scanner userInput) {
		getMessageInfo(email, userInput);
		
		System.out.print("Enter the sender's email address (sender@domain.com): ");
		email.setSenderEmail(userInput.nextLine());
		
		System.out.print("Enter the recipient's email address (recipient@domain.com): ");
		email.setRecipEmail(userInput.nextLine());
	}
	/**
	 * Method for retrieving user's Chat input
	 * @param chat
	 * @param userInput
	 */
	public static void getChatInfo(Chat chat, Scanner userInput) {
		getMessageInfo(chat, userInput);
		
		System.out.print("Enter the sender's IP address (aaa.bbb.ccc.ddd): ");
		chat.setSenderIP(userInput.nextLine());
		
		System.out.print("Enter the recipient's IP address (aaa.bbb.ccc.ddd): ");
		chat.setRecipIP(userInput.nextLine());
	}

	/**
	 * Method for retrieving user's Message input
	 * @param message
	 * @param userInput
	 */
	public static void getMessageInfo(Message message, Scanner userInput) {
		System.out.print("Sender (40 characters max): ");
		message.setSender(userInput.nextLine());
		
		System.out.print("Recipient (40 characters max): ");
		message.setRecip(userInput.nextLine());
		
		System.out.print("Content (500 characters max): ");
		message.setContent(userInput.nextLine());
		
		System.out.print("Date (format: 2020-02-02): ");
		// Single try/catch block if date format throws a DateTimeParseException
		try{
			message.setDate(userInput.nextLine());
		} catch (java.time.format.DateTimeParseException exception) {
			System.out.println("Format of date should be yyyy-MM-dd and a valid date.");
		}
		
		System.out.print("Time (format: 12:34): ");
		// Multiple try/catch block if time format throws a DateTimeParseExecption or NullPointerException
		try {
			message.setTime(userInput.nextLine());
		} catch (java.time.format.DateTimeParseException exception) {
			System.out.println("Invalid Input: Format of tie should be hh:MM and a valid time in a 24-hour time format.");
		} catch (java.lang.NullPointerException npe) {
			System.out.println("Invalid Input: An empty value was entered in date and/or time.");
		}	
			
//		System.out.println("Message Age: ");
//		// Multiple try/catch block if date/time format throws a DateTimeParseExecption or NullPointerException
//		try {
//			message.getAge();
//		} catch (java.lang.NullPointerException exception) {
//			System.out.println("An invalid date or time was entered.");
//		} catch (java.time.format.DateTimeParseException e) {
//			System.out.println("An invalid date or time was entered.");
//		}
	}
}