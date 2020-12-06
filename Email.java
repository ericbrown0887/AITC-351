package assignment2;

public class Email extends Message {
	/**
	 * Static polymorphism with default constructor that sets all the Strings to default values.
	 */
	public Email() {
		this(Email.DEFAULT_SENDER_EMAIL, Email.DEFAULT_RECIP_EMAIL);
	
	}
	
	/**
	 * Constructor with all string arguemnts
	 * @param senderEmail
	 * @param recipEmail
	 */
	public Email(String senderEmail, String recipEmail)  {
		setSenderEmail(senderEmail);
		setRecipEmail(recipEmail);
	}
	/**
	 * Constants to represent unknown values for null or invalid inputs
	 */
	private static final String DEFAULT_SENDER_EMAIL = "---";
	private static final String DEFAULT_RECIP_EMAIL = "---";

	public String senderEmail;
	public String recipEmail;
	
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
	
	/**
	 * Method to return all user input as string
	 */
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSender's email address: " + senderEmail;
		toReturn += "\nRecipient's email address: " + recipEmail;
		return toReturn;
	}
	

}
