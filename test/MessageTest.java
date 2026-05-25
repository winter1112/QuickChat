

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 public class MessageTest {
     
     @Test
     void testCheckMessageID() {
         Message msg = new Message("0123456789", "Hello world");
         assertTrue(msg.checkMessage(), "Message ID should be valid (10 digits or less)");
     }
     
     @Test
     void testValidRecipientCell() {
         Message msg = new Message("0123456789", "Test message");
         String result = msg.checkRecipientCell();
         assertTrue(result.contains("valid"), "Valid phone number should pass validation" );
     }
     
     @Test
     void testInvalidRecipientCell() {
         Message msg = new Message("123", "Test");
         String result = msg.checkRecipientCell();
         assertTrue(result.contains("Error"), "Short number should return error");
     }
     
     @Test
     void testCreateMessageHash() {
         Message msg = new Message("0123456789", "Hello World Test");
         String hash = msg.createmessageHash(); 
         
         assertNotNull(hash);
         assertFalse(hash.isEmpty(), "Hash should not be Empty");
         assertTrue(hash.length() >= 4);
     }
     
     @Test
     void testToStringContainsAllInfo() {
         String output = toString();
         assertTrue(output.contains("Message ID"));
         assertTrue(output.contains("Recipient"));
         assertTrue(output.contains("Message Hash"));
        
     }
 }
    
   