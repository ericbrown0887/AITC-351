package assignment3;

public class Chat extends Message {

	/**
	 * Static polymorphism with default constructor that sets all the Strings to default values.
	 */
	public Chat() {
		this(Chat.DEFAULT_SENDER_IP, Chat.DEFAULT_RECIP_IP);
	}
	
	public Chat(String senderIP, String recipIP) {
		setSenderIP(senderIP);
		setRecipIP(recipIP);
	}
	/**
	 * Constants to represent unknown values for null or invalid inputs
	 */
	private static final String DEFAULT_SENDER_IP = "---";
	private static final String DEFAULT_RECIP_IP = "---";
	
	private String senderIP;
	private String recipIP;
	
	/**
	 * A method that returns the Sender IP
	 * @return A String containing the IP of the Sender. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getSenderIP() {
		return senderIP;
	}
	
	/**
	 * A method that set the value of the variable 'senderIP' and checks for business rules.
	 * 
	 * @param senderIP A string with user's sender input; checks if input is null and RegEx checking for acceptable IP address input.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSenderIP(String senderIP) {
		
		// Checking if the string is null
		if ( senderIP == null )
			return;
		
		// RegEx check that the input matches a valid IP address
		if ( !senderIP.matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$") )
			return;
		
		this.senderIP = senderIP;
	}
	
	/**
	 * A method that returns the Recipient IP
	 * @return A String containing the IP of the recipient. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getRecipIP() {
		return recipIP;
	}
	
	/**
	 * A method that set the value of the variable 'recipIP' and checks for business rules.
	 * 
	 * @param recipIP A string with user's sender input; checks if input is null and RegEx checking for acceptable IP address input.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setRecipIP(String recipIP) {
		
		// Checking if the string is null
		if ( recipIP == null )
			return;
		
		// RegEx check that the input matches a valid IP address
		if ( !recipIP.matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$") )
			return;
		
		this.recipIP = recipIP;
	}
	
	/**
	 * Method to return all user input as string
	 */
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSender's IP address: " + senderIP;
		toReturn += "\nRecipient's IP address: " + recipIP;
		return toReturn;
	}

}
