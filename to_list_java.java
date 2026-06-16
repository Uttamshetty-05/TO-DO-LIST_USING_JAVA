
   import java.util.*;

class Task {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
}

public class to_list_java {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== TO-DO LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: markCompleted(); break;
                case 4: deleteTask(); break;
                case 5: 
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task: ");
        String desc = sc.nextLine();
        tasks.add(new Task(desc));
        System.out.println("Task added!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }

        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String status = t.isCompleted ? "✔" : "✘";
            System.out.println(i + ". [" + status + "] " + t.description);
        }
    }

    static void markCompleted() {
        viewTasks();
        System.out.print("Enter task number: ");
        int index = sc.nextInt();

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isCompleted = true;
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number: ");
        int index = sc.nextInt();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted!");
        } else {
            System.out.println("Invalid index!");
        }
    }
}
