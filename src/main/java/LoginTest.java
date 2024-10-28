/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logintest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

 /**
 * @author RC_Student_lab
 */
public class LoginTest {
    private Login login;

     @BeforeEach
    public void setUp() {
        login = new Login();
        // Setting input data for testing purposes
        login.setUsername("kyl_1");
        login.setPassword("Password1!");
        login.setFirstName("Kylie");
        login.setLastName("Minogue");
    }

    @Test
    public void testUser LoginWithJOptionPane() {
        // Create a JDialog to ensure JOptionPane appears on top
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        // Prompting user for username and password using JOptionPane
        String username = JOptionPane.showInputDialog(dialog, "Enter your username:");
        String password = JOptionPane.showInputDialog(dialog, "Enter your password:");

        // Attempting to login with the provided username and password
        boolean loginResult = login.loginUser (username, password);

        // Displaying the result of the login attempt
        String loginMessage = login.returnLoginStatus(loginResult);
        JOptionPane.showMessageDialog(dialog, loginMessage);

        // Assertions for testing purposes
        assertTrue(loginResult, "Login should be successful with correct credentials.");

        // Dispose the dialog to allow the application to exit properly
        dialog.dispose();
    }

    @Test
    public void testUser RegistrationWithJOptionPane() {
        // Create a JDialog to ensure JOptionPane appears on top
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        // Prompting user for registration details
        String username = JOptionPane.showInputDialog(dialog, "Enter a username:");
        String password = JOptionPane.showInputDialog(dialog, "Enter a password:");
        String firstName = JOptionPane.showInputDialog(dialog, "Enter your first name:");
        String lastName = JOptionPane.showInputDialog(dialog, "Enter your last name:");

        // Setting the user details
        login.setUsername(username);
        login.setPassword(password);
        login.setFirstName(firstName);
        login.setLastName(lastName);

        // Registering the user
        String registrationMessage = login.registerUser ();
        JOptionPane.showMessageDialog(dialog, registrationMessage);

        // Assertions for testing purposes
        assertEquals("User  has been registered successfully.", registrationMessage);

        // Dispose the dialog to allow the application to exit properly
        dialog.dispose();
    }
}