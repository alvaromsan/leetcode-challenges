import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> taskList = new ArrayList<>(
                List.of(
                        List.of(1, 101, 10),
                        List.of(2, 102, 20),
                        List.of(3, 103, 15)
                )
        );
        TaskManager taskManager = new TaskManager(taskList); // Initializes with three tasks for Users 1, 2, and 3.
        taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager.edit(102, 8); // Updates priority of task 102 to 8.
        int result1 = taskManager.execTop(); // return 3. Executes task 103 for User 3.

        System.out.println("Should return 3: " + result1);

        taskManager.rmv(101); // Removes task 101 from the system.
        taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        int result2 = taskManager.execTop(); // return 5. Executes task 105 for User 5.

        System.out.println("Should return 5: " + result2);
    }
}