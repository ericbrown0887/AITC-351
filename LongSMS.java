package assignment2;

import java.util.ArrayList;


public class LongSMS extends SMS {
	
	/**
	 * Static polymorphism with default constructor that sets String to default value.
	 */
	public LongSMS() { 
		this(LongSMS.DEFAULT_LONG_SMS);
	}
	
	/**
	 * Constructor with string argument
	 * @param multiPartContent
	 */
	public LongSMS(String multiPartContent) {
		setMultiPartContent(multiPartContent);
	}
	/**
	 * Constant to represent unknown values for null or invalid input
	 */
	private static final String DEFAULT_LONG_SMS = "---";

	
	private String multiPartContent;

	/**
	 * A method that returns the Multi-part LongSMS content 
	 * @return A String containing the multi-part content of LongSMS message. Returns "---" if input is invalid
	 * according to business rules.
	 */
	public String getMultiPartContent() {
		return multiPartContent;
	}

	/**
	 * A polymorphic method that set the value of the variable 'multiPartContent' and splits the message into 160 characters, then stores into an array.
	 * 
	 * @param multiPartContent A string with user's LongSMS message input; checks if input is null, removes leading and trailing whitespace,
	 * stores string into an array of strings with each string containing no more than 160 characters.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setMultiPartContent(String content) {
		
		// Checking if the string is null
		if ( multiPartContent == null )
			return;
		
		// Removing leading and trailing whitespace
		multiPartContent = multiPartContent.trim();
		
		// Store multiPartContent into an array and split string every 160 characters
		ArrayList<String> strings = new ArrayList<String>();
		int index = 0;
		while (index < multiPartContent.length()) {
		    strings.add(multiPartContent.substring(index, Math.min(index + 160,multiPartContent.length())));
		    index += 160;
		}   
		this.multiPartContent = content;
	}  
	
}