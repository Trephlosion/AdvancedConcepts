package edu.famu.cftaskmanager.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import edu.famu.cftaskmanager.util.SubTasks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tasks extends ATasks{
    @DocumentId

    private Users userId;
    private ArrayList<Users> assignedUsers;
    private ArrayList<Comments> comments;

    public Tasks(@Nullable String taskId, String title, String description, Timestamp createdAt, @Nullable Timestamp updatedAt, Timestamp dueDate, boolean isCompleted, ArrayList<SubTasks> subTasks, String priority, Users userId, ArrayList<Users> assignedUsers, ArrayList<Comments> comments) {
        super(taskId, title, description, createdAt, updatedAt, dueDate, isCompleted, subTasks, priority);
        this.userId = userId;
        this.assignedUsers = assignedUsers;
        this.comments = comments;
    }
}

