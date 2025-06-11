# Java Task Manager

A simple command-line task management system written in Java.

## Features

- Add tasks with descriptions and priority levels
- View all tasks with their status
- Mark tasks as complete
- Delete tasks
- Simple text-based interface

## Requirements

- Java 11 or higher

## How to Run

1. Compile the program:
   ```bash
   javac TaskManager.java
   ```

2. Run the program:
   ```bash
   java TaskManager
   ```

## Usage

The program provides a menu with the following options:
1. Add Task - Create a new task with description and priority
2. View Tasks - Display all tasks with their status
3. Mark Task as Complete - Mark a specific task as complete (updates notifications)
4. Delete Task - Remove a task from the list
5. Exit - Quit the program

## Examples

### Adding a Task
```bash
Menu:
1. Add Task
2. View Tasks
3. Mark Task as Complete
4. Delete Task
5. Exit
Choose an option: 1

Enter task description: Buy groceries
Enter priority (1-5): 3
Task added successfully!
```

### Viewing Tasks
```bash
Menu:
1. Add Task
2. View Tasks
3. Mark Task as Complete
4. Delete Task
5. Exit
Choose an option: 2

Tasks:
1. Buy groceries (Priority: 3) - Pending
```

### Marking a Task as Complete
```bash
Menu:
1. Add Task
2. View Tasks
3. Mark Task as Complete
4. Delete Task
5. Exit
Choose an option: 3

Enter task number to mark as complete: 1
Task marked as complete!

Tasks:
1. Buy groceries (Priority: 3) - Completed
```

### Deleting a Task
```bash
Menu:
1. Add Task
2. View Tasks
3. Mark Task as Complete
4. Delete Task
5. Exit
Choose an option: 4

Enter task number to delete: 1
Task deleted successfully!

Tasks:
No tasks found.
```

### Invalid Input Handling
```bash
Menu:
1. Add Task
2. View Tasks
3. Mark Task as Complete
4. Delete Task
5. Exit
Choose an option: 6
Invalid choice. Please try again.

Choose an option: abc
Invalid input. Please enter a number between 1 and 5.
```

