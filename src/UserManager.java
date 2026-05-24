import java.util.ArrayList;
import user.User;

public class UserManager {
    
    ArrayList<User> users = new ArrayList<>();
    
     public boolean register(String username, String password, String phone) {
        if (!isValidUsername(username)) {
            System.out.println("Username is not correctly formatted; please ensure that you username contains an underscore and is not more than five characters long.");
            return false;
          }
        if (!isValidPassword(password)) {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character. ");
            return false;
          }
        if (!isValidPhone(phone)) {
            System.out.println("Cell phone number is not correctly formatted. Please ensure it starts with +27 and is 12 characters long.");
            return false;
        }
        
        users.add(new User(username, password, phone));
        System.out.println("Username successsfully captured.");
        System.out.println("Password successfully captured.");
        System.out.println("User has been registered successfully.");
        return true;
    }
     
     public boolean login(String username, String password) {
         for (User user : users) {
             if (user.username.equals(username) && user.password.equals(password)) {
                 return true;
             }
         }
         return false;
     }
     
     private boolean isValidUsername(String username) {
         return username != null && username.contains("_") && username.length() <5;
     }
     
     private boolean isValidPassword(String password) {
         if (password == null || password.length() < 8) return false;
         
         boolean hasUpper = false;
         boolean hasDigit = false;
         boolean hasSpecial = false;
         
         for (char c : password.toCharArray()) {
             if (Character.isUpperCase(c)) hasUpper = true;
             if (Character.isDigit(c)) hasDigit = true;
             if (!Character.isLetterOrDigit(c)) hasSpecial = true;
         }
         return hasUpper && hasDigit && hasSpecial;
     }
     
     private boolean isValidPhone(String phone) {
         if (phone == null) return false;
         return phone.startsWith("+27") && phone.length() == 12 &&
                 phone.substring(3).matches("\\d{9}");
                 
         
     }

    
        
    }
