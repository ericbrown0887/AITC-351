package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment 4 - Pair Programming Project
 *
 * @author Faiyaz Mirza
 * @author Eric Brown
 * @since 2020-11-05
 */

public class Assignment4 {

    /**
     * Main method to setup ArrayList for message items, start Message Management System, and prompt users for message input
     * @param args
     */
    public static void main(String[] args) {
        // This is the array of message size 5
        List<Message> messages = new ArrayList<Message>();
        Scanner userInput = new Scanner(System.in); // Create new scanner input object

        System.out.println("---------- MESSAGE MANAGEMENT ----------  (Assignment 4)");

        // Add enclosing switch from last assignment to give options
        // Move select variable to top
        int userSelection = 0;

        // Do/while loop to keep MMS open and available while the users' input is not 4 (quit)
        do {
            System.out.println("Please pick one of the options below to proceed:"); //Options given to user to select which type of message to be created
            System.out.println("1) Create a message");
            System.out.println("2) Show the information stored"); //The previous information recorded will be shown
            System.out.println("3) Edit the information stored"); //If a message needs to be edited
            System.out.println("4) Quit"); //Finish code
            System.out.println("Enter your selection");

            // try/catch to parse user MMS choice and fail gracefully on invalid input.
            try {
                userSelection = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number. Default choice: 4.");
                userSelection = 4;
            }
            System.out.println("Selection: " + userSelection);

            // Switch for MSS user selection
            switch(userSelection) {
                case 1: // Creating a new item
                    if (messages.size()<5) {
                        Message m = createMessage(userInput);
                        if(m != null) {
                            messages.add(m); // Add new message type to "message" ArrayList
                        }
                    } else {
                        System.out.println("5 Messages already created.");
                        userSelection = 4;
                    }
                    break;
                case 2: //Showing all the information that is stored
                    System.out.println("Information stored");
                    if (messages.size() > 0) {
                        for(Message m : messages) {
                            System.out.println("\n" + m); // for loop, display all messages in "message" ArraryList
                        }
                    } else {
                        System.out.println("No messages...");
                    }
                    break;
                case 3: //Editing the stored information
                    System.out.println("Edit stored information");
                    System.out.println("Information stored");
                    int i = 0;
                    int revisedSelection = 5;
                    if (messages.size() > 0) {
                        for(i=0; i<messages.size(); i++) { // This fucntion will loop through "message" ArrayList and print element with Sender, Date, and Time of message.
                            System.out.println(i);
                            System.out.println(messages.get(i).getSender());
                            System.out.println(messages.get(i).getDate());
                            System.out.println(messages.get(i).getTime());
                            System.out.println("\n");
                        }
                        System.out.println("5");
                        System.out.println("Return");
                        System.out.println("\n");
                        System.out.println("Select a message to amend");

                        // try/catch to parse user MMS choice and fail gracefully on invalid input.
                        try {
                            revisedSelection = Integer.parseInt(userInput.nextLine());
                        } catch (NumberFormatException nfe) {
                            System.out.println("Please enter a number. Default choice: 5.");
                            revisedSelection = 5;
                        }
                    } else {
                        System.out.println("There's no message available.....");
                    }
                    System.out.println("Selection: " + userSelection);

                    // if/else to check user input, compare selection message type, and update selected item from the array.
                    if (revisedSelection <= 4) {
                        try {
                            if (messages.get(revisedSelection) instanceof LongSMS) {
                                amendLongSMSData(messages, revisedSelection, userInput);
                            } else if (messages.get(revisedSelection) instanceof SMS) {
                                amendSMSData(messages, revisedSelection, userInput);
                            } else if (messages.get(revisedSelection) instanceof Email) {
                                amendEmailData(messages, revisedSelection, userInput);
                            } else if (messages.get(revisedSelection) instanceof Chat) {
                                amendChatData(messages, revisedSelection, userInput);
                            } else {
                                amendMessageData(messages, revisedSelection, userInput);
                            }
                        } catch  (ArrayIndexOutOfBoundsException e) { // Catch an invalid input or a selection for an index that doesn't yet exist
                            System.out.println("The index you entered is invalid. Please enter a valid index.");
                        }
                    } else {
                        System.out.println("Wrong input please try again");
                    }
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
            }
        } while (userSelection != 4);
        userInput.close();
    }
    /**
     * Method for retrieving user Message input
     * @param userInput
     * @return
     */
    public static Message createMessage(Scanner userInput) {
        System.out.println("\nTypes of messages:");
        System.out.println("1) Simple message");
        System.out.println("2) Chat message");
        System.out.println("3) Email message");
        System.out.println("4) Text (SMS) message");
        System.out.println("5) Long text message");
        int userSelection = 0;

        System.out.print("What type of message do you want to create: ");
        try {
            userSelection = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter a number. Default choice: 0.");
            userSelection = 0;
        }
        System.out.println("Your input is: " + userSelection);
        Message m = new Message();  // Create message to hold all kinds of message. Then downcast in the case.
        switch(userSelection) {
            case 1: // Simple message
                getMessageData(m, userInput);
                System.out.println("Your input is: ");
                System.out.println(m);
                break;
            case 2: // Chat
                m = new Chat();
                getChatData((Chat) m, userInput);
                System.out.println("Your input is:");
                System.out.println(m);
                break;
            case 3: // Email
                m = new Email();
                getEmailData((Email) m, userInput);
                System.out.println("Your input is:");
                System.out.println(m);
                break;
            case 4: // SMS
                m = new SMS();
                getSMSData((SMS) m, userInput);
                System.out.println("Your input is:");
                System.out.println(m);
                break;
            case 5: // Long SMS
                m = new LongSMS();
                getLongSMSData((LongSMS) m, userInput);
                System.out.println("Your input is:");
                System.out.println(m);
                break;
            default:
                System.out.println("Invalid input");
                m = null;
        }
        return m;
    }

    /**
     * Method for retrieving user's LongSMS input
     * @param longSMS
     * @param userInput
     */
    public static void getLongSMSData(LongSMS longSMS, Scanner userInput) {
        getSMSData(longSMS, userInput);
    }

    /**
     * Method for retrieving user's SMS message input
     * @param sms
     * @param userInput
     */
    public static void getSMSData(SMS sms, Scanner userInput) {
        getMessageData(sms, userInput);

        System.out.print("Enter the sender's phone number ( (XXX) YYY-ZZZZ ): ");
        sms.setSenderPhoneNumber(userInput.nextLine());

        System.out.print("Enter the recipient's phone number ( (XXX) YYY-ZZZZ ): ");
        sms.setRecipientPhoneNumber(userInput.nextLine());
    }
    /**
     * Method for retrieving user's Email message input
     * @param email
     * @param userInput
     */
    public static void getEmailData(Email email, Scanner userInput) {
        getMessageData(email, userInput);

        System.out.print("Enter the sender's email address (sender@domain.com): ");
        email.setSenderEmailAddress(userInput.nextLine());

        System.out.print("Enter the recipient's email address (recipient@domain.com): ");
        email.setRecipientEmailAddress(userInput.nextLine());
    }
    /**
     * Method for retrieving user's Chat message input
     * @param chat
     * @param userInput
     */
    public static void getChatData(Chat chat, Scanner userInput) {
        getMessageData(chat, userInput);

        System.out.print("Enter the sender's IP address (aaa.bbb.ccc.ddd): ");
        chat.setSenderIPAddress(userInput.nextLine());

        System.out.print("Enter the recipient's IP address (aaa.bbb.ccc.ddd): ");
        chat.setRecipientIPAddress(userInput.nextLine());
    }
    /**
     * Method to retrieve user's main message input
     * @param message
     * @param userInput
     */
    public static void getMessageData(Message message, Scanner userInput) {
        System.out.print("\nSender (40 characters max): ");
        message.setSender(userInput.nextLine());

        System.out.print("Recipient (40 characters max): ");
        message.setRecipient(userInput.nextLine());

        System.out.print("Content (500 characters max): ");
        message.setContent(userInput.nextLine());

        System.out.print("Date (format: 2020-02-02): ");
        message.setDate(userInput.nextLine());

        System.out.print("Time (format: 12:34): ");
        message.setTime(userInput.nextLine());
    }

    /**
     * Method to amend a LongSMS message type
     * @param messages
     * @param index
     * @param userInput
     */

    public static void amendLongSMSData(List<Message> messages, int index, Scanner userInput) {
        amendSMSData(messages, index, userInput);
    }

    /**
     * Method to amend an SMS message type
     * @param messages
     * @param index
     * @param userInput
     */
    public static void amendSMSData(List<Message> messages, int index, Scanner userInput) {
        amendMessageData( messages, index, userInput);

        String currentSenderPhoneNumber = ((SMS) messages.get(index)).getSenderPhoneNumber();
        System.out.print("Enter the sender's phone number ( "+ currentSenderPhoneNumber + "): ");
        String newSenderPhoneNumber =  userInput.nextLine();
        if (!newSenderPhoneNumber.isEmpty()) {
            ((SMS) messages.get(index)).setSenderPhoneNumber(newSenderPhoneNumber);
        }
        String currentRecipientPhoneNumber = ((SMS) messages.get(index)).getRecipientPhoneNumber();
        System.out.print("Enter the recipient's phone number ( " + currentRecipientPhoneNumber + "): ");
        String newRecipientPhoneNumber = userInput.nextLine();
        if (!newRecipientPhoneNumber.isEmpty()) {
            ((SMS) messages.get(index)).setRecipientPhoneNumber(newRecipientPhoneNumber);
        }
    }

    /**
     * Method to amend an Email message type
     * @param messages
     * @param index
     * @param userInput
     */
    public static void amendEmailData(List<Message> messages, int index, Scanner userInput) {
        amendMessageData(messages,index, userInput);

        String currentSenderEmail = ((Email) messages.get(index)).getSenderEmailAddress();
        System.out.print("Enter the sender's email address (" + currentSenderEmail + "): ");
        String newSenderEmail = userInput.nextLine();
        if (!newSenderEmail.isEmpty()) {
            ((Email) messages.get(index)).setSenderEmailAddress(newSenderEmail);
        }

        String currentRecipientEmail = ((Email) messages.get(index)).getRecipientEmailAddress();
        System.out.print("Enter the recipient's email address (" + currentRecipientEmail + "): ");
        String newRecipientEmail = userInput.nextLine();
        if (!newRecipientEmail.isEmpty()) {
            ((Email) messages.get(index)).setRecipientEmailAddress(newRecipientEmail);
        }
    }
    /**
     * Method to amend a Chat message type
     * @param messages
     * @param index
     * @param userInput
     */
    public static void amendChatData(List<Message> messages, int index, Scanner userInput) {
        amendMessageData(messages, index, userInput);

        String currentSenderIP = ((Chat) messages.get(index)).getSenderIPAddress();
        System.out.print("Enter the sender's IP address (" + currentSenderIP + "): ");
        String newSenderIP = userInput.nextLine();
        if (!newSenderIP.isEmpty()) {
            ((Chat) messages.get(index)).setSenderIPAddress(newSenderIP);
        }
        String currentRecipientIP = ((Chat) messages.get(index)).getRecipientIPAddress();
        System.out.print("Enter the recipient's IP address (" + currentRecipientIP + "): ");
        String newRecipientIP = userInput.nextLine();
        if (!newRecipientIP.isEmpty()) {
            ((Chat) messages.get(index)).setRecipientIPAddress(newRecipientIP);
        }
    }
    /**
     * Method to amend the main Message Info
     * @param messages
     * @param index
     * @param userInput
     */
    public static void amendMessageData(List<Message> messages, int index, Scanner userInput) {
        System.out.println("Please enter your new information. Hit return to keep value.");

        String currentSender = messages.get(index).getSender();
        String currentRecipient = messages.get(index).getRecipient();
        String currentContent = messages.get(index).getContent();
        String currentDate = messages.get(index).getDate();
        String currentTime = messages.get(index).getTime();

        System.out.print("Sender (40 characters max) [" + currentSender + "]: ");
        String newSender = userInput.nextLine();
        if (!newSender.isEmpty()) {
            messages.get(index).setSender(newSender);
        }

        System.out.print("Recipient (40 characters max) [" + currentRecipient + "]: ");
        String newRecipient = userInput.nextLine();
        if (!newRecipient.isEmpty()) {
            messages.get(index).setRecipient(newRecipient);
        }

        System.out.print("Content (500 characters max) [" + currentContent + "]: ");
        String newContent = userInput.nextLine();
        if (!newContent.isEmpty()) {
            messages.get(index).setContent(newContent);
        }

        System.out.print("Date (format: 2020-02-02) [" + currentDate + "]: ");
        String newDate = userInput.nextLine();
        if (!newDate.isEmpty()) {
            messages.get(index).setDate(newDate);
        }

        System.out.print("Time (format: 12:34) [" + currentTime + "]: ");
        String newTime = userInput.nextLine();
        if (!newTime.isEmpty()) {
            messages.get(index).setTime(newTime);
        }
    }

}
