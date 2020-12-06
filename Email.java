package assignment4;

/**
 * 
 * @author Faiyaz Mirza
 * @author Eric Brown
 * @since 2020-11-05
 * This class contains declared variables & Setter/Getter for class Email with business rules.
 */
public class Email extends Message {
	
	/**
	 * Default constructor Email() that sets all Strings to default values.
	 */
	public Email() {
		this(Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE,
				Message.NOT_AVAILABLE, Email.DEFAULT_EMAIL_ADDRESS, Email.DEFAULT_EMAIL_ADDRESS);
	}
	
	public Email(String sender, String recipient, String content, String date, String time, String senderEmailAddress,
			String recipientEmailAddress) {
		super(sender, recipient, content, date, time);
		setSenderEmailAddress(senderEmailAddress);
		setRecipientEmailAddress(recipientEmailAddress);
	}

	/**
	 * Constant to represent unknown value for null or invalid inputs.
	 */
	public static final String DEFAULT_EMAIL_ADDRESS = "nobody@nowhere.not";
	
	private String senderEmailAddress;
	private String recipientEmailAddress;
	
	/**
	 * Getter for the sender email attribute. If the value has not been set, the returned string will contain {@value #DEFAULT_EMAIL_ADDRESS}.
	 * @return A String with the sender email address.
	 */
	public String getSenderEmailAddress() {
		return senderEmailAddress;
	}
	
	/**
	 * Setter for the sender email attribute. Check for null input, remove trailing whitespace, and validate proper email format using regex.
	 * @param senderEmailAddress A String with sender's email input
	 * @return a Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSenderEmailAddress(String senderEmailAddress) {
		if ( senderEmailAddress == null || senderEmailAddress.trim().length() == 0 ) // Check if String is null, trim whitespace
			return;
		
		if ( senderEmailAddress.trim().equalsIgnoreCase(DEFAULT_EMAIL_ADDRESS) ) {
			this.senderEmailAddress = DEFAULT_EMAIL_ADDRESS;
			return;
		}
		
		// Source: https://emailregex.com/
		String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		
		if ( !senderEmailAddress.matches(emailRegex) ) // Validate email address
			return;
		
		this.senderEmailAddress = senderEmailAddress;
	}
	
	/**
	 * Getter for the recipient email attribute. If the value has not been set, the returned string will contain {@value #DEFAULT_EMAIL_ADDRESS}.
	 * @return A String with the recipient email address.
	 */
	public String getRecipientEmailAddress() {
		return recipientEmailAddress;
	}
	
	/**
	 * Setter for the recipient email attribute. Check for null input, remove trailing whitespace, and validate proper email format using regex.
	 * @param recipientEmailAddress A String with recipient email input
	 * @return a Boolean value that reports whether the attribute was set (true) or not (false)
	 */ 
	public void setRecipientEmailAddress(String recipientEmailAddress) {
		if ( recipientEmailAddress == null || recipientEmailAddress.trim().length() == 0 ) // Check if String is null, trim whitespace
			return;
		
		if ( recipientEmailAddress.trim().equalsIgnoreCase(DEFAULT_EMAIL_ADDRESS) ) {
			this.recipientEmailAddress = DEFAULT_EMAIL_ADDRESS;
			return;
		}
		
		// Source: https://emailregex.com/
		String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		
		if ( !recipientEmailAddress.matches(emailRegex) ) // Validate email address
			return;
		
		this.recipientEmailAddress = recipientEmailAddress;
	}
	
	/**
	 * Method to return all user input as string
	 */
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSender's email address: " + senderEmailAddress;
		toReturn += "\nRecipient's email address: " + recipientEmailAddress;
		return toReturn;
	}
}
