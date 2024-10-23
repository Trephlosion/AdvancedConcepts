package edu.famu.cftaskmanager.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.Timestamp;

import java.util.ArrayList;

public class Tasks {
    @DocumentId
    private String taskId;
//    private String userId;
    private String title;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp dueDate;
    private boolean isCompleted;
//    private ArrayList<Users.userID> assignedUsers;
//    private ArrayList<subTasks> subTasks;

}

