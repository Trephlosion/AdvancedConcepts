package edu.famu.cftaskmanager.model;


import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.Timestamp;

import java.util.ArrayList;

public class Users {
    @DocumentId
    private String userId;
    private String displayName;
    private String email;
    private ArrayList<Tasks> tasks;
    private Timestamp createdAt;
}
