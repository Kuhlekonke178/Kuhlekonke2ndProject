/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
public class Task {

    static void addTasks() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static String returnTotalHours() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private int taskNumber;
    private String taskID; // Changed to String to match the ID format
    private int taskStatus; // Assuming taskStatus is an integer representing status codes

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskStatus, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID(); // Call to createTaskID() to generate the ID
        this.taskStatus = taskStatus; // Assigning the taskStatus correctly
        // Ensure task number is set after task creation
        this.taskNumber = taskNumber;
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3);
    }

    public int getTaskDuration() {
        return taskDuration;
    }

   

    public String printTaskDetails() {
        return String.format("Task Name: %s, ID: %s, Description: %s, Developer: %s, Duration: %d hrs, Status: %s",
                taskName, taskID, taskDescription, developerDetails, taskDuration, taskStatus);
    }
    
    
    
    
    // Get full task details
    public String getFullTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }
    
}

    

