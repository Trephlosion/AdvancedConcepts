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

public abstract class ATasks {


    @DocumentId
    private @Nullable String taskId;
    private String title;
    private String description;
    private Timestamp createdAt;
    private @Nullable Timestamp updatedAt;
    private Timestamp dueDate;
    private boolean isCompleted;
    private ArrayList<SubTasks> subTasks;
    private String priority;


    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) throws ParseException {
        this.dueDate = Timestamp.fromProto(Timestamps.parse(dueDate));
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) throws ParseException{
        this.createdAt = Timestamp.fromProto(Timestamps.parse(createdAt));
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) throws ParseException{
        this.updatedAt = Timestamp.fromProto(Timestamps.parse(updatedAt));
    }



}
