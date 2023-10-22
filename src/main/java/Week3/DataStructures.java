package Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

enum Status{
    TO_DO, IN_PROGRESS, COMPLETED, CANCELLED
}
class TaskItem {
    private int taskId;
    private String taskDescription;
    private Status taskStatus;
    public TaskItem(int a, String b, Status c){
        taskId=a;
        taskDescription=b;
        taskStatus=c;
    }

    public int getTaskId() {
        return taskId;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1,"Push lab code to the github", Status.TO_DO),
                new TaskItem(2,"Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3,"Go over tasks from lab2", Status.COMPLETED));
    }

    public List<TaskItem> getAllTasks() {
        return tasks;
    }

    //filters the tasks with the provided status
    public List<TaskItem> getByStatus(Status status)
    {
        List<TaskItem> filteredTasks = new ArrayList<>();
        for(TaskItem task : tasks){
            if(task.getTaskStatus()==status){
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    //finds tasks whose id parameter is greater than or equal to 2
    public List<TaskItem> getTasks2 (){
        List<TaskItem> filteredTasks2 = new ArrayList<>();
        for (TaskItem task : tasks){
            if(task.getTaskId()>=2){
                filteredTasks2.add(task);
            }
        }
        return filteredTasks2;
    }

    public void printDescription(){
        tasks.forEach(task -> System.out.println(task.getTaskDescription()));
    }

    public static void main(String[] args) {
        DataStructures taskManager = new DataStructures();


        System.out.println("Tasks in progress:");
        taskManager.getByStatus(Status.IN_PROGRESS).forEach(task -> System.out.println(task.getTaskDescription()));
        System.out.println();

        System.out.println("Tasks with ID >= 2:");
        taskManager.getTasks2().forEach(task -> System.out.println(task.getTaskDescription()));
        System.out.println();

        System.out.println("Task Descriptions:");
        taskManager.printDescription();
    }

    public class DbConnect {
        private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/root";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";


        private Connection connection = null;


        public DbConnect() {
            try {
                connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

