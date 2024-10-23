package edu.famu.cftaskmanager.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.text.ParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AComments {
    @DocumentId
    private @Nullable String commentId;
    private String text;
    private Timestamp createdAt;



    public void setCreatedAt(String createdAt) throws ParseException {
        this.createdAt = Timestamp.fromProto(Timestamps.parse(createdAt));
    }

}
