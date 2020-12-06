package assignment1;

/**
 * 
 * @author Eric Brown
 * @since 2020-09-15
 * @version 1.0
 * 
 * This class contains declared variables and demonstrates Encapsulation and setters with business rules.
 */
public class Message {
	/**
	 * Default constructor that sets all the Strings to {@value #NOT_AVAILABLE}.
	 */
	public Message() {
		sender = Message.NOT_AVAILABLE;
		recip = Message.NOT_AVAILABLE;
		content = Message.NOT_AVAILABLE;
		date = Message.NOT_AVAILABLE;
		time = Message.NOT_AVAILABLE;
		
	}
	
	public static final String NOT_AVAILABLE = "---";
	
	private String sender;
	private String recip;
	private String content;
	private String date;
	private String time;

	/**
	 * A method that returns the name of the Sender
	 * @return A String containing the name of the Sender. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getSender() {
		return sender;
	}
	/**
	 * A method that set the value of the variable 'sender' and checks for business rules.
	 * 
	 * @param sender A string containing no more than 40 alphabetic characters, no consecutive spaces,
	 * and only special character: "-", "'", ",", "."
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setSender(String sender) {
		// Checking if the string is null
		if ( sender == null )
			return;
		
		// Removing leading and trailing whitespace
		sender = sender.trim();
		
		// Replacing multiple spaces within the string
		sender = sender.replaceAll("[ ]+", " ");
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( sender.length() < 1 || sender.length() > 40 )
			return;
		
		// Check for characters other than alphabetic, hyphens, apostrophes, commas, dots, and spaces
		if ( !sender.matches("[A-Za-z\\'\\-\\ ,\\.]+") )
			return;
		
		this.sender = sender;
		
//		Pattern p = Pattern.compile("^[-',.\"a-zA-Z0-9 ]{1,40}$"); // Business rule: Accepted input contains no more than 40 char
//		Matcher m = p.matcher(sender);
//		if (!m.matches()) { // If sender does NOT match the the regex pattern
//			return false; // The sender was NOT set
//			
//		} else if (sender.contains("  ")) { // If the sender contains more than one consecutive space...
//			return false; // The sender was not set
//		}
//		this.sender = sender;
//		return true;
	}
	/**
	 * A method that returns the name of the Recipient.
	 * @return A String containing the name of the Recipient. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getRecip() {
		return recip;
	}
	/**
	 * A method that set the value of the variable 'recip' and checks for business rules.
	 * 
	 * @param recip A string containing no more than 40 alphabetic characters, no consecutive spaces,
	 * and only special character: "-", "'", ",", "."
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false)
	 */
	public void setRecip(String recip) {
		// Checking if the string is null
			if ( recip == null )
				return;
			
			// Removing leading and trailing whitespace
			recip = recip.trim();
			
			// Replacing multiple spaces within the string
			recip = recip.replaceAll("[ ]+", " "); // I am using a basic regular expression
			
			// Checking for the length of the string once all the whitespace has been removed
			if ( recip.length() < 1 || recip.length() > 40 )
				return;
			
			// Check for characters other than alphabetic, hyphens, apostrophes, commas, dots, and spaces
			if ( !recip.matches("[A-Za-z\\'\\-\\ ,\\.]+") )
				return;
			
			this.recip= recip;
				
//		Pattern p = Pattern.compile("^[-',.\"a-zA-Z0-9 ]{1,40}$");
//		Matcher m = p.matcher(recip);
//		if (!m.matches()) {
//			return false;
//			
//		} else if (recip.contains("  ")) {
//			return false;
//		}
//		this.recip = recip;
//		return true;
		
	}
	/**
	 * A method that returns the content of the message.
	 * @return A String containing the content of the message. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getContent() {
		return content;
	}
	/**
	 * A method that set the value of the variable 'content' and checks for business rule:
	 * 	1. String contains no more than 500 characters.
	 * @param content A String containing no more than 500 characters.
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setContent(String content) {
	// Checking if the string is null
		if ( content == null )
			return;
		
		// Removing leading and trailing whitespace
		content = content.trim();
		
		// Checking for the length of the string once all the whitespace has been removed
		if ( content.length() < 1 || content.length() > 500 )
			return;
		
		this.content = content;
//		if (content.length() > 500) {
//		return false;
//	
//		}
//		
//		this.content = content;
//		return true;
			
	}

	/**
	 * A method that returns the date.
	 * @return A String containing the date input by the user. Returns "null" if input is invalid
	 * according to business rules.
	 */public String getDate() {
		return date;
	}
	/**
	 * A method that sets the value of the variable 'date' and checks for business rule.
	 * 
	 * @param date A String following the date format of yyyy-MM-dd
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setDate(String date) {
		if ( date == null )
			return;
		
		date = date.trim();
		
		if ( !date.matches("\\d{4}-\\d{2}-\\d{2}"))
			return;
		
		this.date = date;
	}
//		Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
//		Matcher m = p.matcher(date);
//		if (!m.matches()) {
//			return false;
//		}	
//		this.date = date;
//		return true;
	/**
	 * A method that returns the time.
	 * @return A String containing the time input by the user. Returns "null" if input is invalid
	 * according to business rules.
	 */
	public String getTime() {
		return time;
	}
	/**
	 * A method that sets the value of the variable 'time' and checks for business rule.
	 *
	 * @param time A String following the time format of hh-MM
	 * @return A Boolean value that reports whether the attribute was set (true) or not (false).
	 */
	public void setTime(String time) {
		if ( time == null )
			return;
		
		time = time.trim();
		
		if ( !time.matches("\\d{2}:\\d{2}"))
			return;
		
		this.time = time;
//		Pattern p = Pattern.compile("\\d{2}:\\d{2}");
//		Matcher m = p.matcher(time);
//		if (!m.matches()) {
//			return false;
//		}
//		this.time = time;
//		return true;
	}

}
