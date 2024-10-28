/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Login login = new Login();
        
        // Registration
        // Prompt the user to enter their details
        JOptionPane.showMessageDialog(null, "Register User");
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");

        String registrationMessage = login.registerUser (username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);
        
        // Login
        boolean loggedIn = false;
        while (!loggedIn) {
            String loginUsername = JOptionPane.showInputDialog("Enter username:");
            String loginPassword = JOptionPane.showInputDialog("Enter password:");
            loggedIn = login.loginUser (loginUsername, loginPassword); // Implement authentication logic
            String loginStatus = login.returnLoginStatus(loggedIn);
            JOptionPane.showMessageDialog(null, loginStatus);

            if (!loggedIn) {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            }
        }

        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

        // Get number of tasks
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks:"));
        Task[] tasks = new Task[numTasks];

        // Main loop
        int taskCount = 0;
        while (true) {
            // Display menu
            String menu = "Choose an option:\n" +
                    "1. Add Task\n" +
                    "2. Show Report\n" +
                    "3. Quit";
            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        
            switch (choice) {
                case 1:
                    if (taskCount < numTasks) {
                        // Create a new Task object
                        tasks[taskCount] = createTask(); // Implement createTask method to create a Task
                        taskCount++;
                    } else {
                        JOptionPane.showMessageDialog(null, "You have reached the maximum number of tasks.");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon!"); // Implement task report logic
                    break;
                case 3:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
            }
        }
    }

    // Placeholder for createTask method
    private static Task createTask() {
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
        return new Task(taskName, duration); // Assuming Task has a constructor that takes name and duration
    }
}

// Placeholder for Login class
class Login {
    public String registerUser (String username, String password, String firstName, String lastName) {
        // Registration logic here
        return "User  registered successfully.";
    }

    public boolean loginUser (String username, String password) {
        // Authentication logic here
        return true; // Placeholder for successful login
    }

    public String returnLoginStatus(boolean loggedIn) {
        return loggedIn ? "Login successful!" : "Login failed!";
    }
}

// Placeholder for Task class
class Task {
    private String name;
    private int duration;

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    // Additional methods can be added here as needed
}