import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Task {
    private String name;
    private LocalDateTime dueDate;
    private Priority priority;

    public Task(String name, LocalDateTime dueDate, Priority priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }



    public String toString() {
        return "Task: " + name + " | Due Date: " + dueDate + " | Priority: " + priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getName() {
        return name;
    }
}

enum Priority {
    HIGH, MEDIUM, LOW
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }


    public void notifyUser(Task task) {
        System.out.println("Reminder: Task '" + task.getName() + "' is due soon!");
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();


        Task task1 = new Task("Complete project", LocalDateTime.of(2024, 1, 15, 12, 0), Priority.HIGH);
        Task task2 = new Task("Buy groceries", LocalDateTime.of(2024, 1, 10, 18, 0), Priority.MEDIUM);
        Task task3 = new Task("Read book", LocalDateTime.of(2024, 1, 20, 10, 30), Priority.LOW);


        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);


        List<Task> allTasks = taskManager.getAllTasks();
        for (Task task : allTasks) {
            System.out.println(task);
        }


        LocalDateTime now = LocalDateTime.now();
        for (Task task : allTasks) {
            if (task.getDueDate().isBefore(now.plusDays(1))) {
                taskManager.notifyUser(task);
            }
        }
    }
}
