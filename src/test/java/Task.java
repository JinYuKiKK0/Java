import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private TaskStatus status;


    public Task(int id, String description, TaskStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }


    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updateAt=LocalDateTime.now();
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }


    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status){
        this.status=status;
        this.updateAt=LocalDateTime.now();
    }


    public String toString() {
        return "Task{id = " + id
                + ", description = " + description
                + ", createAt = " + createAt
                + ", updateAt = " + updateAt
                + ", status = " + status
                + "}";
    }



}
