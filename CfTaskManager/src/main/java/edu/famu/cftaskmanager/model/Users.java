package edu.famu.cftaskmanager.model;


import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;

import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.ArrayList;

@Data
@NoArgsConstructor

public class Users extends AUsers {
    @DocumentId

    private @Nullable ArrayList<Tasks> tasks;

    public Users(@Nullable String userId, String displayName, String email, Timestamp createdAt, @Nullable ArrayList<Tasks> tasks) {
        super(userId, displayName, email, createdAt);
        this.tasks = tasks;
    }
}
