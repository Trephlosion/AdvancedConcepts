package edu.famu.cftaskmanager.util;

import com.google.cloud.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record SubTasks(String taskId, String title, boolean isCompleted, Timestamp dueDate) {


}
