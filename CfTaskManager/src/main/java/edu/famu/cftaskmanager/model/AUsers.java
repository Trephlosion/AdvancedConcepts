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
@AllArgsConstructor

public abstract class AUsers {

    @DocumentId
    private @Nullable String userId;
    private String displayName;
    private String email;
    private Timestamp createdAt;



    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) throws ParseException {
        this.createdAt = Timestamp.fromProto(Timestamps.parse(createdAt));
    }
}
