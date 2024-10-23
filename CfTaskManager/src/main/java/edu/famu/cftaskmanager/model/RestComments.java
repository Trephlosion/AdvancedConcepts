package edu.famu.cftaskmanager.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;

@Data
@NoArgsConstructor
public class RestComments extends AComments{

    private DocumentReference userId;

    public RestComments(@Nullable String commentId, String text, Timestamp createdAt, DocumentReference userId) {
        super(commentId, text, createdAt);
        this.userId = userId;
    }
}
