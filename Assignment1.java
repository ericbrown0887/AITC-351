package assignment1;

import java.util.Scanner;

public class Assignment1 {
	
	/**
	 * The main method prompting users for input and then printing output.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		Message m = new Message();
		
		System.out.print("Sender (40 characters max): ");
		m.setSender(userInput.nextLine());
		
		System.out.print("Recipient (40 characters max): ");
		m.setRecip(userInput.nextLine());
		
		System.out.print("Message (500 characters max): ");
		m.setContent(userInput.nextLine());
		
		System.out.print("Date (format: yyyy-MM-dd): ");
		m.setDate(userInput.nextLine());
		
		System.out.print("Time (format: hh:MM): ");
		m.setTime(userInput.nextLine());
		
		userInput.close();
		
		System.out.println("You entered: ");
		System.out.println("Sender: " + m.getSender());
		System.out.println("Recipient: " + m.getRecip());
		System.out.println("Message: " + m.getContent());
		System.out.println("Sent: " + m.getDate() + ", " + m.getTime());
	}

}
