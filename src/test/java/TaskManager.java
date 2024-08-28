import java.util.List;
import java.util.Optional;

public class TaskManager {
    List<Task> tasks;

    public TaskManager(List list){
        this.tasks=list;
    }
    //添加、删除、更新任务
    public void addTask(String description) {
        int id = tasks.size() + 1;
        Task newTask = new Task(id, description, TaskStatus.ToDo);
        tasks.add(newTask);
        System.out.println("Task added successfully(" + id + ") ");
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void updateTask(int id, String newDescription) {
        Optional<Task> taskOptional = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
        if(taskOptional.isPresent()){
            Task task=taskOptional.get();
            task.setDescription(newDescription);
            System.out.println("Task("+id+")updated successfully");
        }else
            System.out.println("Task not found(ID "+id+")");

    }

    //    将任务标记为已完成或进行中
    public void updateTaskStatus(int id,TaskStatus status){
        Optional<Task> taskOptional = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
        Task task = taskOptional.get();
        task.setStatus(status);
        System.out.println("The task has been marked as "+status);
    }
    public void MarkTaskDone(int id) {
        updateTaskStatus(id, TaskStatus.Done);
    }

    public void MarkTaskInProgress(int id) {
        updateTaskStatus(id, TaskStatus.in_Progress);
    }

    //    根据不同的任务状态列出相应的任务
    public void listTasksByStatus(TaskStatus status) {
        tasks.stream().filter(task -> task.getStatus()==status)
                .forEach(System.out::println);
    }

    //    列出所有的任务
    public void listALLTasks() {
        tasks.stream().forEach(System.out::println);
    }
}
