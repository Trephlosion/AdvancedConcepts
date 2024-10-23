package edu.famu.cftaskmanager.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;

@Data
@NoArgsConstructor
public class Comments extends AComments{
    private Users userId;

    public Comments(@Nullable String commentId, String text, Timestamp createdAt, Users userId) {
        super(commentId, text, createdAt);
        this.userId = userId;
    }
}
