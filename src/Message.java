 
import java.util.ArrayList;

public final class Message {
    
    private final long messageID;
    private final String recipientCell;
    private final String messageText;
    private String messageHash;
    
    private static final ArrayList<Message> allMessages = new ArrayList<>();
    
    public Message(String recipientCell, String messageText) {
        this.messageID = generateMessageID();
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createmessageHash();
       }
    
    private long generateMessageID() {
        return 1000000000L + (long)(Math.random() * 900000000);
    }
    
    public boolean checkMessage() {
        String idStr = String.valueOf(messageID);
        return idStr.length() <= 10;
    }
    
    public String checkRecipientCell() {
        if (recipientCell == null || recipientCell.length() > 10){
            return "Error: Recipient cell number must be no more than 10 characters.";
        }
        if (!recipientCell.matches("\\+?\\d+")) {
            return "Error: Recipient cell number must start with a valid code (numbers only).";
        }
        return "Recipient cell number is valid.";
    }
    
    public String SendMessage() {
        if (checkMessage() && recipientCell != null && !recipientCell.isEmpty()) {
            return "Message sent successfully to " + recipientCell + " with ID: " + messageID;
        } else {
            return "Failed to send message. Please check the details.";
        }
    }
    
    public String createmessageHash() {
        String idStr = String.valueOf(messageID);
        String firstTwo = idStr.substring(0,2);
        String lastTwo = idStr.substring(idStr.length() - 2);
        
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0]: "";
        String lastWord = words.length > 0 ? words[words.length- 1] : "";
        
        this.messageHash = firstTwo + lastTwo + firstWord + lastWord;
        return this.messageHash;
        
    }
    
    public String SentMessage(int totalMessagesSent){
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1. Send and Store");
        System.out.println("2. Stroe only (without sending)");
        System.out.println("3. Disregard message");
        System.out.print("Enter choice: ");
        
        int choice = FlashChat.getValidChoice(1, 3);
        
        switch (choice) {
            case 1 -> {
                storeMessage();
                totalMessagesSent++;
                return "Message sent and stored successfully.";
            }
            case 2 -> {
                storeMessage();
                return "Message stored (not sent).";
            }
            case 3 -> {
                return "Message disregarded.";
            }
            default -> {
                return "Invalid choice.";
            }
        }
    }
    private void storeMessage() {
        allMessages.add(this);
    }
    
    public static String printMessages() {
        if (allMessages.isEmpty()) {
            return "No messages sent yet.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== All sent Messages ===\n");
        for (Message msg : allMessages) {
            sb.append(msg.toString()).append("\n\n");
        }
        return sb.toString();
    }
    
    
     static {
        
        
        System.out.println("[Message stored in system}");
    }
    
    @Override
    public String toString() {
        return "Mesasage ID   : " + messageID + "\n" +
                "Recipient    : " + recipientCell + "\n" +
                "Message      : " + messageText + "\n" +
                "Message Hash : " + messageHash;
    }
    
}
