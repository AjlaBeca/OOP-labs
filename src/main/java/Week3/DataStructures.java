package Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Status{
    TO_DO, IN_PROGRESS, COMPLETED, CANCELLED;
}
public class TaskItem {
    private int taskId;
    private String textDescription;
    private Status taskStatus;
    public TaskItem(int a, String b, Status c){
        taskId=a;
        textDescription=b;
        taskStatus=c;
    }

    public int getTaskId() {
        return taskId;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public String getTextDescription() {
        return textDescription;
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

    // TODO create a method to get all objects

    // TODO create a method getByStatus that will accept a Status parameter and filter the tasks with the provided status

    // TODO create a method to find tasks whose id parameter greater than or equal to 2

    // TODO create a method that will, by using the forEach stream method, print to the console the description of each task
}

