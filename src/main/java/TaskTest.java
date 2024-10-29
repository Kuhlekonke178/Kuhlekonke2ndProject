/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
      private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
    }

    @Test
    public void testCheckTaskDescriptionSuccess() {
        assertTrue(task1.checkTaskDescription(), "Task description should be valid.");
        assertTrue(task2.checkTaskDescription(), "Task description should be valid.");
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        Task longTaskDescription = new Task(
            "Long Task",
            "This task description is intentionally made longer than fifty characters to test the description checking method.",
            "Developer",
            5,
            "To Do"
        );

        assertFalse(longTaskDescription.checkTaskDescription(), "Task description should exceed character limit.");
    }

    @Test
    public void testCreateTaskID() {
        // Test if Task ID for task 1 is as expected
        assertEquals("AD:1:LOG", task1.createTaskID(), "The Task ID should be correct for Task 1.");
        
        // You can invoke this multiple times and check subsequent Task IDs
        Task task3 = new Task("Feature A", "Description", "Dev A", 5, "In Progress");
        assertEquals("AD:2:FEA", task3.createTaskID(), "The Task ID should be correct for Task 3.");
    }

    @Test
    public void testPrintTaskDetails() {
        String expectedDetails = "Task ID: " + task1.createTaskID() + 
                                 ", Name: Login Feature" + 
                                 ", Description: Create Login to authenticate users" + 
                                 ", Developer: Robyn Harrison" + 
                                 ", Duration: 8hrs" + 
                                 ", Status: To Do";
                                 
        assertEquals(expectedDetails, task1.printTaskDetails(), "Task details should match expected output.");
    }

    @Test
    public void testReturnTotalHours() {
        // Given 2 tasks
        assertEquals(18, Task.returnTotalHours(), "Total hours should be 18 with 2 tasks.");
        
        // Adding a third task with a different duration
        new Task("New Task", "This is not long.", "Dev B", 5, "To Do");
        assertEquals(23, Task.returnTotalHours(), "Total hours should be 23 after adding third task.");
        
        // Adding tasks with additional data
        new Task("Task 4", "Short desc.", "Dev C", 12, "Done");
        new Task("Task 5", "Another short desc.", "Dev D", 1, "Done");
        assertEquals(36, Task.returnTotalHours(), "Total hours should be correctly updated to 36 after adding all tasks.");
    }
}
/// 

    
}
