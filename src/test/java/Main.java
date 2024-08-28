import java.util.ArrayList;

public class Main {
     private static final TaskManager taskManager=new TaskManager(new ArrayList<>());
    public static void main(String[] args) {
//        若用户没有提供命令行参数则退出main方法，停止运行
        if(args.length==0){
            printUsage();
            return;
        }
        String command=args[0].toLowerCase();
        switch (command){
            case "add":
                if(args.length<2){
                    System.out.println("Error : Task description is required");
                }else{
                    String description=args[1];
                    taskManager.addTask(description);
                }
                break;
            case  "update":
                if(args.length<3){
                    System.out.println("Error : Task ID and description are required");
                }else{
                    try {
                        int id = Integer.parseInt(args[1]);
                        String newDescription=args[2];
                        taskManager.updateTask(id,newDescription);
                    } catch (NumberFormatException e) {
                        System.out.println("Error : Invalid Task ID.It should be a number");
                    }
                }
                break;
            case "delete":
                if(args.length<2){
                    System.out.println("Error : Task ID is required");
                }else{
                    try {
                        int id = Integer.parseInt(args[1]);
                        taskManager.deleteTask(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error : Invalid Task ID.It should be a number");
                    }
                }
                break;
            case "mark-in-progress":
                if(args.length<2){
                    System.out.println("Error : Task ID is required");
                }else{
                    try {
                        int id = Integer.parseInt(args[1]);
                        taskManager.MarkTaskInProgress(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error : Invalid Task ID.It should be a number");
                    }
                }
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Error: Task ID is required.");
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        taskManager.MarkTaskDone(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid Task ID. It should be a number.");
                    }
                }
                break;

            case "list":
                if (args.length == 1) {
                    taskManager.listALLTasks();
                } else if (args.length == 2) {
                    String status = args[1].toLowerCase();
                    switch (status) {
                        case "done":
                        case "todo":
                        case "in-progress":
                            taskManager.listTasksByStatus(TaskStatus.valueOf(status.toUpperCase()));
                            break;
                        default:
                            System.out.println("Error: Invalid status. Use 'done', 'todo', or 'in-progress'.");
                    }
                } else {
                    System.out.println("Error: Too many arguments for 'list' command.");
                }
                break;

            default:
                System.out.println("Error: Unknown command.");
                printUsage();
        }

    }
    public static void printUsage(){
        System.out.println("Usage:");
        System.out.println("  add <description>                - Add a new task");
        System.out.println("  update <id> <new description>    - Update an existing task");
        System.out.println("  delete <id>                      - Delete a task");
        System.out.println("  mark-in-progress <id>            - Mark a task as in progress");
        System.out.println("  mark-done <id>                   - Mark a task as done");
        System.out.println("  listAll                             - List all tasks");
        System.out.println("  list <status>                    - List tasks by status (todo, in-progress, done)");
    }
}
