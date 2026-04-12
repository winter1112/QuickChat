
import java.util.ArrayList;
import user.User;

public class UserManager {
    ArrayList<User> users = new ArrayList<>();
    
    public boolean reigister(String username, String password, String phone){
        if (!isValidUsername(username)) return false;
        if (!isValidPassword(password)) return false;
        if (!isValidPhone(phone)) return false;
        
        users.add(new User(username, password, phone));
        return true;
    }
    boolean login(String username, String password, String phone){
        for (User user : users){
            if (user.username.equals(username) && user.password.equals(password)){
                return true;
            }
        }
        return false;
    }
    private boolean isValidUsername(String username) {
        return username.contains("_")&& username.length() <= 5;
        
    }
    private boolean isValidPassword(String password){
        return password.matches("^(?=.*[A-Z])(?=.*[@#$%^&?+=]).{8,}$");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("^(\\+27|0)[5-8][0-9]{8}$");
          
    }

    boolean register(String u, String p, String ph) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
          
}
