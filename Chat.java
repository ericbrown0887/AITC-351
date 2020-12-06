package assignment1;

public class Chat extends Message {

	public Chat() {
		senderIP = Message.NOT_AVAILABLE;
		recipIP = Message.NOT_AVAILABLE;
		
	}
	
	public static final String NOT_AVAILABLE = "Invalid Input";
	
	public String senderIP;
	public String recipIP;
	
	public String getSenderIP() {
		return senderIP;
	}
	public void setSenderIP(String senderIP) {
		if ( senderIP == null )
			return;
		
		if ( !senderIP.matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$") )
			return;
		
		this.senderIP = senderIP;
	}
	public String getRecipIP() {
		return recipIP;
	}
	public void setRecipIP(String recipIP) {
		if ( recipIP == null )
			return;
		
		if ( !recipIP.matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$") )
			return;
		
		this.recipIP = recipIP;
	}


}
