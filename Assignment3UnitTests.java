package assignment4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Assignment3UnitTests {
	
	// Tests for the Sender

	@Test
	public void correctSender() {
		String correctInput = "Jane Doe";
		Message m = new Message();
		m.setSender(correctInput);
		assertEquals(m.getSender(), correctInput);
	}
	
	@Test
	public void nullSender() {
		// If the setter is written correctly, m should not save the incorrect input
		String correctInput = "Jane Doe";
		String incorrectInput = null;
		Message m = new Message();
		m.setSender(correctInput);
		m.setSender(incorrectInput);
		assertEquals(m.getSender(), correctInput);
	}
	
	@Test
	public void emptySender() {
		String correctInput = "Jane Doe";
		String incorrectInput = "";
		Message m = new Message();
		m.setSender(correctInput);
		m.setSender(incorrectInput);
		assertEquals(m.getSender(), correctInput);
	}
	
	@Test
	public void longSender() {
		String correctInput = "Jane Doe";
		String incorrectInput = getRandomString(41);
		Message m = new Message();
		m.setSender(correctInput);
		m.setSender(incorrectInput);
		assertEquals(m.getSender(), correctInput);
	}
	
	@Test
	public void incorrectCharacterSender() {
		String correctInput = "Jane Doe";
		String incorrectInput = "What? I don't know";
		Message m = new Message();
		m.setSender(correctInput);
		m.setSender(incorrectInput);
		assertEquals(m.getSender(), correctInput);
	}
	
	// Tests for the Recipient

	@Test
	public void correctRecipient() {
		String correctInput = "Jane Doe";
		Message m = new Message();
		m.setRecipient(correctInput);
		assertEquals(m.getRecipient(), correctInput);
	}
	
	@Test
	public void nullRecipient() {
		// If the setter is written correctly, m should not save the incorrect input
		String correctInput = "Jane Doe";
		String incorrectInput = null;
		Message m = new Message();
		m.setRecipient(correctInput);
		m.setRecipient(incorrectInput);
		assertEquals(m.getRecipient(), correctInput);
	}
	
	@Test
	public void emptyRecipient() {
		String correctInput = "Jane Doe";
		String incorrectInput = "";
		Message m = new Message();
		m.setRecipient(correctInput);
		m.setRecipient(incorrectInput);
		assertEquals(m.getRecipient(), correctInput);
	}
	
	@Test
	public void longRecipient() {
		String correctInput = "Jane Doe";
		String incorrectInput = getRandomString(41);
		Message m = new Message();
		m.setRecipient(correctInput);
		m.setRecipient(incorrectInput);
		assertEquals(m.getRecipient(), correctInput);
	}
	
	@Test
	public void incorrectCharacterRecipient() {
		String correctInput = "Jane Doe";
		String incorrectInput = "What? I don't know";
		Message m = new Message();
		m.setRecipient(correctInput);
		m.setRecipient(incorrectInput);
		assertEquals(m.getRecipient(), correctInput);
	}
	
	// Tests for the Content

	@Test
	public void correctContent() {
		String correctInput = "This is some message";
		Message m = new Message();
		m.setContent(correctInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void nullContent() {
		// If the setter is written correctly, m should not save the incorrect input
		String correctInput = "This is some message";
		String incorrectInput = null;
		Message m = new Message();
		m.setContent(correctInput);
		m.setContent(incorrectInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void emptyContent() {
		String correctInput = "This is some message";
		String incorrectInput = "";
		Message m = new Message();
		m.setContent(correctInput);
		m.setContent(incorrectInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void longContent() {
		String correctInput = "This is some message";
		String incorrectInput = getRandomString(501);
		Message m = new Message();
		m.setContent(correctInput);
		m.setContent(incorrectInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	// Tests for the Date
	
	@Test
	public void correctDate() {
		String correctInput = "2020-01-25";
		Message m = new Message();
		m.setDate(correctInput);
		assertEquals(m.getDate(), correctInput);
	}
	
	@Test
	public void nullDate() {
		String correctInput = "2020-01-25";
		String incorrectInput = null;
		Message m = new Message();
		m.setDate(correctInput);
		m.setDate(incorrectInput);
		assertEquals(m.getDate(), correctInput);
	}
	
	@Test
	public void incorrectDateFormat() {
		String correctInput = "2020-01-25";
		String incorrectInput = "20200125";
		Message m = new Message();
		m.setDate(correctInput);
		m.setDate(incorrectInput);
		assertEquals(m.getDate(), correctInput);
	}
	
	@Test
	public void futureDate() {
		// Getting today's date
		LocalDate today = LocalDate.now();
		String correctInput = today.toString();
		
		// Getting today's date and adding one day
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		String incorrectInput = tomorrow.toString();
		
		Message m = new Message();
		m.setDate(correctInput);
		m.setDate(incorrectInput);
		assertEquals(m.getDate(), correctInput);
	}
	
	// Tests for the Time
	
	@Test
	public void correctTime() {
		String correctInput = "12:34";
		Message m = new Message();
		m.setTime(correctInput);
		assertEquals(m.getTime(), correctInput);
	}
	
	@Test
	public void nullTime() {
		String correctInput = "12:34";
		String incorrectInput = null;
		Message m = new Message();
		m.setTime(correctInput);
		m.setTime(incorrectInput);
		assertEquals(m.getTime(), correctInput);
	}
	
	@Test
	public void incorrectTimeFormat() {
		String correctInput = "12:34";
		String incorrectInput = "1234";
		Message m = new Message();
		m.setTime(correctInput);
		m.setTime(incorrectInput);
		assertEquals(m.getTime(), correctInput);
	}
	
	@Test
	public void futureTime() {
		// Getting current date
		LocalDate today = LocalDate.now();
		
		// Getting current time minus 30 minutes
		LocalTime earlierToday = LocalTime.now().minusMinutes(30);		
		String correctInput = earlierToday.getHour() + ":" + earlierToday.getMinute();
		
		// Getting current time and adding one hour
		LocalTime later = LocalTime.now().plusHours(1);
		String incorrectInput = later.getHour() + ":" + later.getMinute();
		
		Message m = new Message();
		m.setDate(today.toString());
		m.setTime(correctInput);
		m.setTime(incorrectInput.toString());
		assertEquals(m.getTime(), correctInput);
	}
	
	// Test for the age of the message
	
	@Test
	public void messageAge() {
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		LocalDateTime currentDateTime = LocalDateTime.of(today, now);
		LocalDate twoDaysAgo = LocalDate.now().minusDays(2);
		LocalTime someOtherHour = LocalTime.now().minusHours(2).plusMinutes(21);
		LocalDateTime someTimeAgo = LocalDateTime.of(twoDaysAgo, someOtherHour);
		
		String someOtherTime = someOtherHour.getHour() + ":" + someOtherHour.getMinute();
		
		Message m = new Message();
		m.setDate(twoDaysAgo.toString());
		m.setTime(someOtherTime);
		
		Duration expectedAge = Duration.between(someTimeAgo, currentDateTime);
		long expectedAgeInMinutes = expectedAge.toMinutes();
		
		assertEquals(m.getAge(), expectedAgeInMinutes);
	}
	
	// Tests for the Sender's IP address
	
	@Test
	public void correctSenderIPAddress() {
		String correctInput = "100.200.120.201";
		Chat c = new Chat();
		c.setSenderIPAddress(correctInput);
		assertEquals(c.getSenderIPAddress(), correctInput);
	}
	
	@Test
	public void incorrectSenderIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = "300.200.120.201";
		Chat c = new Chat();
		c.setSenderIPAddress(correctInput);
		c.setSenderIPAddress(incorrectInput);
		assertEquals(c.getSenderIPAddress(), correctInput);
	}
	
	@Test
	public void incorrectFormatSenderIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = "100200120201";
		Chat c = new Chat();
		c.setSenderIPAddress(correctInput);
		c.setSenderIPAddress(incorrectInput);
		assertEquals(c.getSenderIPAddress(), correctInput);
	}
	
	@Test
	public void nullSenderIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = null;
		Chat c = new Chat();
		c.setSenderIPAddress(correctInput);
		c.setSenderIPAddress(incorrectInput);
		assertEquals(c.getSenderIPAddress(), correctInput);
	}
	
	@Test
	public void emptySenderIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = "";
		Chat c = new Chat();
		c.setSenderIPAddress(correctInput);
		c.setSenderIPAddress(incorrectInput);
		assertEquals(c.getSenderIPAddress(), correctInput);
	}
	
	// Tests for the Recipient's IP address
	
	@Test
	public void correctRecipientIPAddress() {
		String correctInput = "100.200.120.201";
		Chat c = new Chat();
		c.setRecipientIPAddress(correctInput);
		assertEquals(c.getRecipientIPAddress(), correctInput);
	}
	
	@Test
	public void incorrectRecipientIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = "300.200.120.201";
		Chat c = new Chat();
		c.setRecipientIPAddress(correctInput);
		c.setRecipientIPAddress(incorrectInput);
		assertEquals(c.getRecipientIPAddress(), correctInput);
	}
	
	@Test
	public void incorrectFormatRecipientIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = "100200120201";
		Chat c = new Chat();
		c.setRecipientIPAddress(correctInput);
		c.setRecipientIPAddress(incorrectInput);
		assertEquals(c.getRecipientIPAddress(), correctInput);
	}
	
	@Test
	public void nullRecipientIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = null;
		Chat c = new Chat();
		c.setRecipientIPAddress(correctInput);
		c.setRecipientIPAddress(incorrectInput);
		assertEquals(c.getRecipientIPAddress(), correctInput);
	}
	
	@Test
	public void emptyRecipientIPAddress() {
		String correctInput = "100.200.120.201";
		String incorrectInput = "";
		Chat c = new Chat();
		c.setRecipientIPAddress(correctInput);
		c.setRecipientIPAddress(incorrectInput);
		assertEquals(c.getRecipientIPAddress(), correctInput);
	}
	
	// Tests for the Sender's IP address
	
	@Test
	public void correctSenderEmailAddress() {
		String correctInput = "test@example.com";
		Email e = new Email();
		e.setSenderEmailAddress(correctInput);
		assertEquals(e.getSenderEmailAddress(), correctInput);
	}
	
	@Test
	public void incorrectFormatSenderEmailAddress() {
		String correctInput = "test@example.com";
		String incorrectInput = "test@examplecom";
		Email e = new Email();
		e.setSenderEmailAddress(correctInput);
		e.setSenderEmailAddress(incorrectInput);
		assertEquals(e.getSenderEmailAddress(), correctInput);
	}
	
	@Test
	public void nullSenderEmailAddress() {
		String correctInput = "test@example.com";
		String incorrectInput = null;
		Email e = new Email();
		e.setSenderEmailAddress(correctInput);
		e.setSenderEmailAddress(incorrectInput);
		assertEquals(e.getSenderEmailAddress(), correctInput);
	}
	
	@Test
	public void emptySenderEmailAddress() {
		String correctInput = "test@example.com";
		String incorrectInput = "";
		Email e = new Email();
		e.setSenderEmailAddress(correctInput);
		e.setSenderEmailAddress(incorrectInput);
		assertEquals(e.getSenderEmailAddress(), correctInput);
	}
	
	// Tests for the Recipient's IP address
	
	@Test
	public void correctRecipientEmailAddress() {
		String correctInput = "test@example.com";
		Email e = new Email();
		e.setRecipientEmailAddress(correctInput);
		assertEquals(e.getRecipientEmailAddress(), correctInput);
	}
	
	@Test
	public void incorrectFormatRecipientEmailAddress() {
		String correctInput = "test@example.com";
		String incorrectInput = "test@examplecom";
		Email e = new Email();
		e.setRecipientEmailAddress(correctInput);
		e.setRecipientEmailAddress(incorrectInput);
		assertEquals(e.getRecipientEmailAddress(), correctInput);
	}
	
	@Test
	public void nullRecipientEmailAddress() {
		String correctInput = "test@example.com";
		String incorrectInput = null;
		Email e = new Email();
		e.setRecipientEmailAddress(correctInput);
		e.setRecipientEmailAddress(incorrectInput);
		assertEquals(e.getRecipientEmailAddress(), correctInput);
	}
	
	@Test
	public void emptyRecipientEmailAddress() {
		String correctInput = "test@example.com";
		String incorrectInput = "";
		Email e = new Email();
		e.setRecipientEmailAddress(correctInput);
		e.setRecipientEmailAddress(incorrectInput);
		assertEquals(e.getRecipientEmailAddress(), correctInput);
	}
	
	// Tests for the Sender's phone number
	
	@Test
	public void correctSenderPhoneNumber() {
		String correctInput = "(410) 555-0123";
		SMS txt = new SMS();
		txt.setSenderPhoneNumber(correctInput);
		assertEquals(txt.getSenderPhoneNumber(), correctInput);
	}
	
	@Test
	public void incorrectAreaCodeSenderPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = "(100) 555-0123";
		SMS txt = new SMS();
		txt.setSenderPhoneNumber(correctInput);
		txt.setSenderPhoneNumber(incorrectInput);
		assertEquals(txt.getSenderPhoneNumber(), correctInput);
	}
	
	@Test
	public void incorrectFormatSenderPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = "(410)555-0123";
		SMS txt = new SMS();
		txt.setSenderPhoneNumber(correctInput);
		txt.setSenderPhoneNumber(incorrectInput);
		assertEquals(txt.getSenderPhoneNumber(), correctInput);
	}
	
	@Test
	public void nullSenderPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = null;
		SMS txt = new SMS();
		txt.setSenderPhoneNumber(correctInput);
		txt.setSenderPhoneNumber(incorrectInput);
		assertEquals(txt.getSenderPhoneNumber(), correctInput);
	}
	
	@Test
	public void emptySenderPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = "";
		SMS txt = new SMS();
		txt.setSenderPhoneNumber(correctInput);
		txt.setSenderPhoneNumber(incorrectInput);
		assertEquals(txt.getSenderPhoneNumber(), correctInput);
	}
	
	// Tests for the Recipient's phone number
	
	@Test
	public void correctRecipientPhoneNumber() {
		String correctInput = "(410) 555-0123";
		SMS txt = new SMS();
		txt.setRecipientPhoneNumber(correctInput);
		assertEquals(txt.getRecipientPhoneNumber(), correctInput);
	}
	
	@Test
	public void incorrectAreaCodeRecipientPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = "(100) 555-0123";
		SMS txt = new SMS();
		txt.setRecipientPhoneNumber(correctInput);
		txt.setRecipientPhoneNumber(incorrectInput);
		assertEquals(txt.getRecipientPhoneNumber(), correctInput);
	}
	
	@Test
	public void incorrectFormatRecipientPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = "(410)555-0123";
		SMS txt = new SMS();
		txt.setRecipientPhoneNumber(correctInput);
		txt.setRecipientPhoneNumber(incorrectInput);
		assertEquals(txt.getRecipientPhoneNumber(), correctInput);
	}
	
	@Test
	public void nullRecipientPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = null;
		SMS txt = new SMS();
		txt.setRecipientPhoneNumber(correctInput);
		txt.setRecipientPhoneNumber(incorrectInput);
		assertEquals(txt.getRecipientPhoneNumber(), correctInput);
	}
	
	@Test
	public void emptyRecipientPhoneNumber() {
		String correctInput = "(410) 555-0123";
		String incorrectInput = "";
		SMS txt = new SMS();
		txt.setRecipientPhoneNumber(correctInput);
		txt.setRecipientPhoneNumber(incorrectInput);
		assertEquals(txt.getRecipientPhoneNumber(), correctInput);
	}
	
	// Tests for the Content of a SMS

	@Test
	public void correctSMSContent() {
		String correctInput = "This is some message";
		SMS m = new SMS();
		m.setContent(correctInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void nullSMSContent() {
		// If the setter is written correctly, m should not save the incorrect input
		String correctInput = "This is some message";
		String incorrectInput = null;
		SMS m = new SMS();
		m.setContent(correctInput);
		m.setContent(incorrectInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void emptySMSContent() {
		String correctInput = "This is some message";
		String incorrectInput = "";
		SMS m = new SMS();
		m.setContent(correctInput);
		m.setContent(incorrectInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void longSMSContent() {
		String correctInput = "This is some message";
		String incorrectInput = getRandomString(161);
		SMS m = new SMS();
		m.setContent(correctInput);
		m.setContent(incorrectInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	@Test
	public void correctLongSMSContent() {
		String correctInput = getRandomString(350);
		LongSMS m = new LongSMS();
		m.setContent(correctInput);
		assertEquals(m.getContent(), correctInput);
	}
	
	// This method generates a random string of lower-case characters with length 'len'
	private String getRandomString(int len) {
		String toReturn = "";
		double minValue = 97;
		double maxValue = 122;
		
		for ( int c = 0; c < len; c++ ) {
			toReturn += Character.toString((char)(minValue + ((maxValue-minValue))*Math.random()));
		}
		
		return toReturn;
	}
}
