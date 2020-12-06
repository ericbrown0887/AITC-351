package assignment1;

public class Email extends Message {
	
	/**
	 * Default constructor that sets all the Strings to {@value #NOT_AVAILABLE}.
	 */
	public Email() {
		senderEmail = Message.NOT_AVAILABLE;
		recipEmail = Message.NOT_AVAILABLE;
	}
	
	public static final String NOT_AVAILALBLE = "---";
	
	private String senderEmail;
	private String recipEmail;
	
	/**
	 * A method that returns the Sender email
	 * @return A String containing the email of the Sender. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getSenderEmail() {
		return senderEmail;
	}
	
	/**
	 * A method that set the value of the variable 'senderEmail' and checks for business rules.
	 * 
	 * @param senderEmail A string with user's sender input; checks if input is null and RegEx checking for acceptable email address input.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSenderEmail(String senderEmail) {
		
		// Checking if the string is null
		if ( senderEmail == null )
			return;
		
		// RegEx check that the input matches a valid email address
		if ( !senderEmail.matches("^(.+)@(.+)$"))
				return;
		
		this.senderEmail = senderEmail;
	}
	
	/**
	 * A method that returns the Recipient email
	 * @return A String containing the email of the Sender. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getRecipEmail() {
		return recipEmail;
	}
	
	/**
	 * A method that set the value of the variable 'recipEmail' and checks for business rules.
	 * 
	 * @param recipEmail A string with user's recipient input; checks if input is null and RegEx checking for acceptable email address input.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setRecipEmail(String recipEmail) {
		
		// Checking if the string is null
		if ( recipEmail == null )
			return;
		
		// RegEx check that the input matches a valid email address
		if ( !recipEmail.matches("^(.+)@(.+)$"))
				return;
		
		this.recipEmail = recipEmail;
	}
	
	

}
