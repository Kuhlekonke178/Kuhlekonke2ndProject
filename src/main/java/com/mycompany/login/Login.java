/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.Scanner;
import java.util.regex.Pattern;
        
/**
 *
 * @author RC_Student_lab
 */
public class Login {

    
        
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
                
                }
               
    
     private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+_[a-zA-Z0-9]{1,4}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\[\\]{}|;':\",.<>?]).{8,}$");

    public boolean checkUserName(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean checkPasswordComplexity(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        this.username = username;
        this.password = password; // Store hashed password in real applications
        this.firstName = firstName;
        this.lastName = lastName;
        return "User successfully registered!";
    }
public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(boolean loginSuccessful) {
        return loginSuccessful ? "Welcome " + firstName + ", " + lastName + " it is great to see you again." : "Username or password incorrect, please try again.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
        // Registration
        System.out.println("Register User");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);
        
        // Login
        System.out.println("\nLogin User");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccessful = login.loginUser(loginUsername, loginPassword);
        String loginStatus = login.returnLoginStatus(loginSuccessful);
        System.out.println(loginStatus);

        scanner.close();
    }
    
}
