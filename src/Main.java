
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            UserManager manager = new UserManager();
            
            OUTER:
            while (true) {
                System.out.println("1.Register");
                System.out.println("2.Login");
                System.out.println("3. Exit");
                System.out.println("Choose an option: ");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1 ->                     {
                        System.out.print("Username: ");
                        String u = input.nextLine();
                        System.out.print("Password: ");
                        String p = input.nextLine();
                        System.out.print("Phone: ");
                        String ph = input.nextLine();
                        if (manager.register(u, p, ph)){
                            System.out.println("Registration successful");
                        } else{
                            System.out.println("Registration failed");
                        }                          }
                    case 2 ->                     {
                        System.out.print("Username: ");
                        String u = input.nextLine();
                        System.out.print("Password: ");
                        String p = input.nextLine();
                        if (manager.login(u, p)) {
                            System.out.println("Welcome user, it is great to see you again.");
                        } else {
                            System.out.println("Username or password incoorect please try again.");
                        }                          }
                    case 3 -> {
                        System.out.println("Thank you for using the system. Goodbye!");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        }
    }

    
    
    }

    
                
                
                
                    
                    
            
        
    

    