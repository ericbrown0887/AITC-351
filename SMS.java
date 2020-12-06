package assignment2;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SMS extends Message {
	/**
	 * Static polymorphism with default constructor that sets all the Strings to default values.
	 */
	public SMS() { 
		
		this (SMS.DEFAULT_SENDER_PHONE, SMS.DEFAULT_RECIP_PHONE, SMS.DEFAULT_SMS_CONTENT);
		
		// Loading the area codes from the JSON file
		try {
			JSONArray statesArray = (JSONArray) (new JSONParser()).parse(new FileReader("src/areaCode.json"));
			validAreaCodes = new String[statesArray.size()];
			for ( int i = 0; i < statesArray.size(); i++ ) {
				JSONObject state = (JSONObject)statesArray.get(i);
				validAreaCodes[i] = state.get("area_code").toString();
			}
		} catch (Exception e) {
			System.out.println("There were problems loading the JSON file");
			// Just in case there are issues with the JSON file
			validAreaCodes = new String[] {"410", "301", "443"};
		}
	}
	
	/**
	 * Constructor with all string arguments
	 * @param senderPhone
	 * @param recipPhone
	 * @param smsContent
	 */
	public SMS(String senderPhone, String recipPhone, String smsContent) {
		setSenderPhone(senderPhone);
		setRecipPhone(recipPhone);
		setSmsContent(smsContent);
		}
	/**
	 * Constants to represent unknown values for null or invalid inputs
	 */
	private static final String DEFAULT_SENDER_PHONE = "---";
	private static final String DEFAULT_RECIP_PHONE = "---";
	private static final String DEFAULT_SMS_CONTENT = "---";
	
	private String senderPhone;
	private String recipPhone;
	private String smsContent;
	
	private String[] validAreaCodes;
	
	/**
	 * A method that returns the sender phone number
	 * @return A String containing the phone number of the sender. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getSenderPhone() {
		return senderPhone;
	}
	
	/**
	 * A method that set the value of the variable 'senderPhone' and checks for business rules.
	 * 
	 * @param senderPhone A string with user's sender phone number input; checks if input is null, uses method isValidPhoneNumber to check
	 * if user's phone number input is valid.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSenderPhone(String senderPhone) {
		
		// Checking if the string is null
		if ( senderPhone == null || senderPhone.trim().length() == 0 )
			return;
		
		// Check if user input is a valid phone number
		if ( !isValidPhoneNumber(senderPhone) )
			return;
		
		this.senderPhone = senderPhone;
	}
	
	/**
	 * A method that returns the recipient phone number
	 * @return A String containing the phone number of the sender. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getRecipPhone() {
		return recipPhone;
	}
	
	/**
	 * A method that set the value of the variable 'senderPhone' and checks for business rules.
	 * 
	 * @param recipPhone A string with user's sender phone number input; checks if input is null, uses method isValidPhoneNumber to check
	 * if user's phone number input is valid.
	 * 
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setRecipPhone(String recipPhone) {
		
		// Checking if the string is null
		if ( recipPhone == null || recipPhone.trim().length() == 0 )
			return;
		
		if ( !isValidPhoneNumber(recipPhone) )
			return;
		
		this.recipPhone = recipPhone;

	}
	
	/**
	 * A method that takes user input for sender and recipient phone number and uses regex to check for valid
	 * phone number, removes all digits but area code, and checks the input area code against the valid area code array.
	 * @param phoneNumber
	 * @return
	 */
	private boolean isValidPhoneNumber(String phoneNumber) {
		
		// Regex check that the input matches (XXX) YYY-ZZZZ
		if ( !phoneNumber.matches("\\(\\d{3}\\) \\d{3}\\-\\d{4}") )
			return false;
		
		// Remove all digits but area code
		String areaCode = phoneNumber.substring(1, 4);
		
		// Check if the area code is present in the list that was loaded from the JSON file
		for ( int i = 0; i < validAreaCodes.length; i++ ) {
			if ( validAreaCodes[i].equalsIgnoreCase(areaCode) )
				return true;
		}
		
		return false;
	}
	
	/**
	 * A method that returns the sender SMS message
	 * @return A String containing the SMS message content. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getSmsContent() {
		return smsContent;
	}
	
	/**
	 * A method that set the value of the variable 'smsContent' and checks for business rules.
	 * 
	 * @param smsContent A string with user's SMS message input; checks if input is null, trims leading and trailing whitespace, checks the string's length is
	 * between 1 and 160 characters.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSmsContent(String smsContent) {
		
		// Checking if the string is null
		if ( smsContent == null )
			return;
		
		// Removing leading and trailing whitespace
		smsContent = smsContent.trim();
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( smsContent.length() < 1 || smsContent.length() > 160 )
			return;
		
		this.smsContent = smsContent;
	}
	
	/**
	 * Method to return all user input as string
	 */
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSender's phone number: " + senderPhone;
		toReturn += "\nRecipient's phone number: " + recipPhone;
		return toReturn;
	}

}
