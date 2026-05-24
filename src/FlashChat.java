import java.util.Scanner;

public class FlashChat {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        try (scanner) {
            System.out.println("Welocme to FlashChat.");
            
            boolean running = true;
            
            while (running) {
                displayMenu();
                int choice = getValidChoice(1, 3);
                
                switch (choice) {
                    case 1 -> sendNewMessage();
                    case 2 -> {
                        System.out.println("Thank you for using FlashChat. Goodbye!");
                        running = false;
                    }
                }
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n=== FlashChat Menu ===");
        System.out.println("1. Send Messages");
        System.out.println("2. Show recently sent messages");
        System.out.println("3. Quit");
        System.out.println("Enter your choice: ");
    }
    
    public static int getValidChoice(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
              int choice = scanner.nextInt();
              scanner.nextLine();
              if (choice >= min && choice <= max) {
                  return choice;
              }
            } else {
                scanner.nextLine();
            }
            System.out.println("Invalid input. Please enter a number between " + min + " and" + max + ":");
        }
        
        }    
    private static void sendNewMessage(){
        System.out.print("How many messages would you like to send? ");
        int num = getValidChoice(1, 100);
        
        for (int i = 1; i <= num; i++) {
            System.out.println("\n--- Message " + i + " ---");
            
            String recipient = getValidRecipient();
            String text = getValidMessageText();
            
            Message msg = new Message(recipient, text);
            
            System.out.println(msg.checkRecipientCell());
            if (msg.checkMessage()) {
                System.out.println("Message ID is valid.");
            }
            
            String result = msg.SendMessage();
            System.out.println(result);
        }
    }
    
    private static String getValidRecipient() {
        while (true) {
            System.out.print("Enter recipient phone number (max 10 charcacters):");
            String num = scanner.nextLine().trim();
            if (num.length() <= 10 && num.matches("\\+?\\d+")) {
                return num;
            }
            System.out.println("Invalid: Max 10 characters and must contain only numbers.");
        }
    }
    
    private static String getValidMessageText() {
        while (true) {
            System.out.print("Enter your message(max 250 characters): ");
            String msg = scanner.nextLine();
            if (msg.length() <= 250 && !msg.trim().isEmpty()) {
                return msg;
            }
            System.out.println("Please enter a message of less than 250 characters.");
        }
    }
        
    
    
}
