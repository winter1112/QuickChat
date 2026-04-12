/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class UserManagerTest {
    
    public UserManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of reigister method, of class UserManager.
     */
    @Test
    public void testReigister() {
        System.out.println("reigister");
        String username = "";
        String password = "";
        String phone = "";
        UserManager instance = new UserManager();
        boolean expResult = false;
        boolean result = instance.reigister(username, password, phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UserManager.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        String phone = "";
        UserManager instance = new UserManager();
        boolean expResult = false;
        boolean result = instance.login(username, password, phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class UserManager.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String u = "";
        String p = "";
        String ph = "";
        UserManager instance = new UserManager();
        boolean expResult = false;
        boolean result = instance.register(u, p, ph);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
