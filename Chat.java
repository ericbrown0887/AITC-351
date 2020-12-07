package assignment4;

/**
 * 
 * @author Faiyaz Mirza
 * @author Eric Brown
 * * @since 2020-11-05
 * This class contains declared variables & Setter/Getter for class Chat with business rules.
 */
public class Chat extends Message {
	
	/**
	 * Default constructor Chat() that sets all Strings to default values.
	 */
	public Chat() {
		this(Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, Message.NOT_AVAILABLE,
				Message.NOT_AVAILABLE, Chat.DEFAULT_IP_ADDRESS, Chat.DEFAULT_IP_ADDRESS);
	}
	
	public Chat(String sender, String recipient, String content, String date, String time, String senderIPAddress, String recipientIPAddress) {
		super(sender, recipient, content, date, time);
		setSenderIPAddress(senderIPAddress);
		setRecipientIPAddress(recipientIPAddress);
	}
	
	/**
	 * Constant to represent unknown value for null or invalid inputs.
	 */
	public static final String DEFAULT_IP_ADDRESS = "127.0.0.1";
	
	private String senderIPAddress;
	private String recipientIPAddress;
	
	/**
	 * Getter for the sender IP attribute. If the value has not been set, the returned string will contain {@value #DEFAULT_IP_ADDRESS}.
	 * @return A String with the sender IP.
	 */
	public String getSenderIPAddress() {
		return senderIPAddress;
	}
	
	/**
	 * Setter for the sender IP attribute.
	 * @param senderIPAddress A String with sender IP input
	 * @return a Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSenderIPAddress(String senderIPAddress) {
		if ( senderIPAddress == null || senderIPAddress.trim().length() == 0 ) // Check if String is null, trim whitespace
			return;
		
		if ( senderIPAddress.trim().equalsIgnoreCase(DEFAULT_IP_ADDRESS) ) {
			this.senderIPAddress = DEFAULT_IP_ADDRESS;
			return;
		}
		
		if ( !isValidIPAddress(senderIPAddress) ) // Validate IP address
			return;
		
		this.senderIPAddress = senderIPAddress;
	}
	
	/**
	 * Getter for the recipient IP attribute. If the value has not been set, the returned string will contain {@value #DEFAULT_IP_ADDRESS}.
	 * @return A String with the recipient IP.
	 */
	public String getRecipientIPAddress() {
		return recipientIPAddress;
	}
	
	/**
	 * Setter for the recipient IP attribute.
	 * @param recipientIPAddress A String with recipient IP input.
	 * @return a Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setRecipientIPAddress(String recipientIPAddress) {
		if ( recipientIPAddress == null || recipientIPAddress.trim().length() == 0 ) // Check if String is null, trim whitespace
			return;
		
		if ( recipientIPAddress.trim().equalsIgnoreCase(DEFAULT_IP_ADDRESS) ) {
			this.recipientIPAddress = DEFAULT_IP_ADDRESS;
			return;
		}
		
		if ( !isValidIPAddress(recipientIPAddress) ) // Validate IP address
			return;
			
		this.recipientIPAddress = recipientIPAddress;
	}
	
	/**
	 * A method to check if the IP address fits a particular format using RegEx and a for loop to check each octect is between 0 - 255.
	 * @param ipAddress
	 * @return
	 */
	private boolean isValidIPAddress(String ipAddress) {
		if ( !ipAddress.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$") ) // Regex check that the input matches a valid IP address format.
			return false;
		
		String[] addressParts = ipAddress.split("\\."); // Split each IP address into separate parts for octet range check.
		
		// for loop to validate each octect is within a range of 1 - 255.
		for ( String element : addressParts ) {
			int num = Integer.parseInt(element);
			if ( num < -1 || num > 255 )
				return false;
		}
		
		return true;
	}
	
	/**
	 * Method to return all user input as a string.
	 */
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSender's IP address: " + senderIPAddress;
		toReturn += "\nRecipient's IP address: " + recipientIPAddress;
		return toReturn;
	}
}
