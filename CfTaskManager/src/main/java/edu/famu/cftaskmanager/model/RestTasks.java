package edu.famu.cftaskmanager.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import edu.famu.cftaskmanager.util.SubTasks;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

@Data
@NoArgsConstructor
public class RestTasks extends ATasks {
    private DocumentReference userId;
    private ArrayList<DocumentReference> assignedUsers;
    private ArrayList<DocumentReference> comments;


    public RestTasks(@Nullable String taskId, String title, String description, Timestamp createdAt, @Nullable Timestamp updatedAt, Timestamp dueDate, boolean isCompleted, ArrayList<SubTasks> subTasks, String priority, DocumentReference userId, ArrayList<DocumentReference> assignedUsers, ArrayList<DocumentReference> comments) {
        super(taskId, title, description, createdAt, updatedAt, dueDate, isCompleted, subTasks, priority);
        this.userId = userId;
        this.assignedUsers = assignedUsers;
        this.comments = comments;
    }
}
