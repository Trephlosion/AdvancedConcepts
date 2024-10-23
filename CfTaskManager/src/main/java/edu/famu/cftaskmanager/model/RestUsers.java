package edu.famu.cftaskmanager.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.util.ArrayList;
@Data
@NoArgsConstructor

public class RestUsers extends AUsers{

    private @Nullable ArrayList<DocumentReference> tasks;

    public RestUsers(@Nullable String userId, String displayName, String email, Timestamp createdAt, @Nullable ArrayList<DocumentReference> tasks) {
        super(userId, displayName, email, createdAt);
        this.tasks = tasks;
    }

}
