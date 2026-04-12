
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        UserManager manager = new UserManager();
        
        while (true){
            System.out.println("1.Register");
            System.out.println("2.Login");
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1){
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
                }
            } else if (choice ==2){
                System.out.print("Username: ");
                String u = input.nextLine();
                
                System.out.print("Password: ");
                String p = input.nextLine();
                
                System.out.print("Phone: ");
                String ph = input.nextLine();
                
                if (manager.login(u, p, ph)){
                    System.out.println("Login successful");
                } else {
                    System.out.println("Invalid credentials");
                }
            }
        }
    }
}
    
                
                
                
                    
                    
            
        
    

    