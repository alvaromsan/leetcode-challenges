import java.util.*;

public class TaskManager {

    static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private Comparator<Task> comp = (a, b) -> {
        if (b.priority != a.priority) return b.priority - a.priority; // higher priority first
        return b.taskId - a.taskId; // higher taskId first if same priority
    };

    Map<Integer, Task> taskMap = new HashMap<>();
    TreeSet<Task> taskTree = new TreeSet<>(comp);


    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task_i: tasks) {
            Task taskObject = new Task(task_i.get(0), task_i.get(1), task_i.get(2));
            taskMap.put(taskObject.taskId, taskObject);
            taskTree.add(taskObject);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task taskObject = new Task(userId, taskId, priority);
        taskMap.put(taskId, taskObject);
        taskTree.add(taskObject);
    }

    public void edit(int taskId, int newPriority) {
        Task taskObject = taskMap.get(taskId);
        taskTree.remove(taskObject);

        taskObject.priority = newPriority;
        taskMap.put(taskId, taskObject);
        taskTree.add(taskObject);
    }

    public void rmv(int taskId) {
        Task taskObject = taskMap.get(taskId);
        taskMap.remove(taskId);
        taskTree.remove(taskObject);
    }

    public int execTop() {
        if(taskTree.isEmpty()) {
            return -1;
        }
        else {
            Task taskObject = taskTree.first();
            taskTree.remove(taskObject);
            taskMap.remove(taskObject.taskId);
            return taskObject.userId;
        }
    }
}
