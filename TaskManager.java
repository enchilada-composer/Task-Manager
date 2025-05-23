import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Console console = System.console();

    public static void main(String[] args) {
        // Check if we're running in interactive mode
        if (console == null) {
            System.out.println("Task Manager is running in non-interactive mode. Use the 'tasks' command to interact with it.");
            return;
        }
        
        System.out.println("Welcome to Task Manager!");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            try {
                String input = console.readLine();
                if (input == null || input.isEmpty()) {
                    System.out.println("No input received. Please try again.");
                    continue;
                }
                
                int choice = Integer.parseInt(input.trim());
                
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        markTaskComplete();
                        break;
                    case 4:
                        deleteTask();
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                if (e.getMessage() != null && e.getMessage().contains("User interrupt")) {
                    System.out.println("\nGoodbye!");
                    return;
                }
                if (e instanceof NumberFormatException) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                } else {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        
        System.out.print("Enter priority (1-5): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Task task = new Task(description, priority);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        
        // Also print to console
        System.out.println("\nTasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.printf("%d. %s (Priority: %d) - %s\n", 
                i + 1, task.getDescription(), task.getPriority(), 
                task.isCompleted() ? "Completed" : "Pending");
        }
    }

    private static void markTaskComplete() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        
        System.out.print("Enter task number to mark as complete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task marked as complete!");
            
            // Update notifications with the new status
            updateNotifications();
            
            // Show updated list
            viewTasks();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void updateNotifications() {
        // Just print to console
        System.out.println("\nTasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.printf("%d. %s (Priority: %d) - %s\n", 
                i + 1, task.getDescription(), task.getPriority(), 
                task.isCompleted() ? "Completed" : "Pending");
        }
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}

class Task {
    private String description;
    private int priority;
    private boolean completed;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
