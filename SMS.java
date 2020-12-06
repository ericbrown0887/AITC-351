package assignment4;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 
 * @author Faiyaz Mirza
 * @author Eric Brown
 * @since 2020-11-05
 * This class contains declared variables & Setter/Getter for class SMS with business rules.
 */
public class SMS extends Message {
	
	/**
	 * Default constructor SMS() that sets all Strings to default values.
	 */
	public SMS() {
		this(Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE,
				Message.NOT_AVAILABLE, SMS.DEFAULT_PHONE_NUMBER, SMS.DEFAULT_PHONE_NUMBER);
	}
	
	public SMS(String sender, String recipient, String content, String date,
			String time, String senderPhoneNumber, String recipientPhoneNumber) {
		super(sender, recipient, content, date, time);
		
		loadJSONFile();
		
		setSenderPhoneNumber(senderPhoneNumber);
		setRecipientPhoneNumber(recipientPhoneNumber);
	}

	/**
	 * Method to load Area Code JSON
	 */
	private void loadJSONFile() {
		// Loading the area codes from the JSON file
		try {
			JSONArray statesArray = (JSONArray) (new JSONParser()).parse(new FileReader("src/us_area_codes.json"));
			validAreaCodes = new String[statesArray.size()];
			for ( int i = 0; i < statesArray.size(); i++ ) {
				JSONObject state = (JSONObject)statesArray.get(i);
				validAreaCodes[i] = state.get("area_code").toString();
			}
		// Exeception Handling for JSON load errors
		} catch(IOException ioe) {
			System.out.println("There were problems loading the file.");
			setDefaultAreaCodes();
		} catch (Exception e) {
			System.out.println("There were problems loading the JSON file");
			// This exception catches anything that was not included in the first catch.
			setDefaultAreaCodes();
		}
	}
	
	/**
	 * method for setting default area codes 
	 */
	private void setDefaultAreaCodes() {
		validAreaCodes = new String[] {"410", "301", "443"};
	}
	
	/**
	 * Constant to represent unknown value for null or invalid inputs.
	 */
	public static final String DEFAULT_PHONE_NUMBER = "000-555-0123";
	
	private String senderPhoneNumber;
	private String recipientPhoneNumber;
	
	private String[] validAreaCodes;
	
	/**
	 * Getter for the sender phone attribute. If the value has not been set, the returned string will contain {@value #DEFAULT_PHONE_NUMBER}.
	 * @return A String with the recipient phone number.
	 */
	public String getSenderPhoneNumber() {
		return senderPhoneNumber;
	}
	
	/**
	 * Setter for the sender phone number attribute. Check for null input, remove trailing whitespace, and validate proper phone number format.
	 * @param senderPhoneNumber A String with sender phone number input
	 * @return a Boolean value that reports whether the attribute was set (true) or not (false)
	 */ 
	public void setSenderPhoneNumber(String senderPhoneNumber) {
		if ( senderPhoneNumber == null || senderPhoneNumber.trim().length() == 0 ) // Check if String is null, trim whitespace
			return;
		
		if ( senderPhoneNumber.trim().equalsIgnoreCase(SMS.DEFAULT_PHONE_NUMBER) ) {
			this.senderPhoneNumber = SMS.DEFAULT_PHONE_NUMBER;
			return;
		}
		
		if ( !isValidPhoneNumber(senderPhoneNumber) ) // Validate phone number input
			return;
		
		this.senderPhoneNumber = senderPhoneNumber;
	}
	
	/**
	 * Getter for the recipient phone attribute. If the value has not been set, the returned string will contain {@value #DEFAULT_PHONE_NUMBER}.
	 * @return A String with the recipient phone number.
	 */
	public String getRecipientPhoneNumber() {
		return recipientPhoneNumber;
	}
	
	/**
	 * Setter for the recipient phone number attribute. Check for null input, remove trailing whitespace, and validate proper phone number format.
	 * @param recipientPhoneNumber A String with recipient phone number input
	 * @return a Boolean value that reports whether the attribute was set (true) or not (false)
	 */ 
	public void setRecipientPhoneNumber(String recipientPhoneNumber) {
		if ( recipientPhoneNumber == null || recipientPhoneNumber.trim().length() == 0 ) // Check if String is null, trim whitespace
			return;
		
		if ( recipientPhoneNumber.trim().equalsIgnoreCase(SMS.DEFAULT_PHONE_NUMBER) ) {
			this.recipientPhoneNumber = SMS.DEFAULT_PHONE_NUMBER;
			return;
		}
		
		if ( !isValidPhoneNumber(recipientPhoneNumber) ) // Validate phone number input
			return;
		
		this.recipientPhoneNumber = recipientPhoneNumber;
	}
	
	/**
	 * A method to check if the phone number fits a particular format using RegEx and a for loop to check for valid area code.
	 * @param phoneNumber
	 * @return
	 */
	private boolean isValidPhoneNumber(String phoneNumber) {
		if ( !phoneNumber.matches("\\(\\d{3}\\) \\d{3}\\-\\d{4}") ) // Regex check that the input matches a valid IP address format.
			return false;
		
		String areaCode = phoneNumber.substring(1, 4);
		
		// We check if the area code is present in the list that we loaded from the JSON file
		for ( int i = 0; i < validAreaCodes.length; i++ ) {
			if ( validAreaCodes[i].equalsIgnoreCase(areaCode) )
				return true;
		}
		
		return false;
	}
	
	public static String getDefaultPhoneNumber() {
		return DEFAULT_PHONE_NUMBER;
	}
	
	public void setContent(String content) {
		if ( content == null ) // Checking if the string is null
			return;
		
		if ( content.length() < 1 || content.length() > 160 ) // Checking for the length of the string in within valid range
			return;
		
		super.setContent(content);
	}
	
	/**
	 * Method to return all user input as string.
	 */
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSender's phone number: " + senderPhoneNumber;
		toReturn += "\nRecipient's phone number: " + recipientPhoneNumber;
		return toReturn;
	}
}
