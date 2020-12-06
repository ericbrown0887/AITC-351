package assignment4;

/**
 * 
 * @author Faiyaz Mirza
 * @author Eric Brown
 * @since 2020-11-05
 * This class contains declared variables & Setter/Getter for class LongSMS with business rules.
 */
public class LongSMS extends SMS {
	public LongSMS() {
		this(Message.NOT_AVAILABLE, Message.NOT_AVAILABLE, LongSMS.EMPTY_MESSAGE, Message.NOT_AVAILABLE,
				Message.NOT_AVAILABLE, SMS.DEFAULT_PHONE_NUMBER, SMS.DEFAULT_PHONE_NUMBER);
	}
	
	public LongSMS(String sender, String recipient, String content, String date, String time, String senderPhoneNumber,
			String recipientPhoneNumber) {
		super(sender, recipient, content, date, time, senderPhoneNumber, recipientPhoneNumber);
		// Keep in mind that the SMS class calls setContent(content). Since we are overriding the behavior of that
		// function from the SMS class in the LongSMS class, we will get the local behavior instead.
	}

	/**
	 * Default constructor that sets String to default value: '---'.
	 */
	public static final String EMPTY_MESSAGE = "---";
	
	/**
	 * Method to create multipartContent array.
	 */
	private String[] multipartContent;
	
	/**
	 * Method that set the value of the variable 'multiPartContent' and splits the message into 160 characters.
	 * 
	 * @param content A String with user's message content input; checks if input is null, removes leading and trailing whitespace,
	 * stores string into an array multipartContent with each string containing no more than 160 characters.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setContent(String content) {
		if ( content == null ) // check if string is null
			return;
		
		content = content.trim(); // trim whitespace
		
		if ( content.equalsIgnoreCase(LongSMS.EMPTY_MESSAGE) ) {
			this.setContent(LongSMS.EMPTY_MESSAGE);
			this.multipartContent = (new String[] {LongSMS.EMPTY_MESSAGE});
			return;
		}
		
		this.multipartContent = (content.split("(?<=\\G.{160})")); // Splits LongSMS content into 160 character groupings.
	}
	
	/**
	 * Getter that stores content in multipartContent array.
	 */
	public String getContent() {
		String toReturn = "";
		
		// for loop to store content into multipartContent array.
		for ( int i = 0; i < multipartContent.length; i++ ) {
			toReturn += multipartContent[i];
		}
		
		return toReturn;
	}
	
	/**
	 * Method to return all user LongSMS content input as string.
	 */
	public String toString() {
		String toReturn = super.toString();
		for ( int i = 0; i < multipartContent.length; i++ ) {
			toReturn += "\nMultipart Content, Part " + i + ": " + multipartContent[i];
		}
		return toReturn;
	}
}
