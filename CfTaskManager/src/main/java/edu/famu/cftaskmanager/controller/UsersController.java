package edu.famu.cftaskmanager.controller;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.cftaskmanager.model.RestUsers;
import edu.famu.cftaskmanager.model.Users;
import edu.famu.cftaskmanager.service.UserService;
import edu.famu.cftaskmanager.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

//http://localhost:8080/api/user


@RequestMapping("/api/user")
@RestController
public class UsersController {


    private final UserService service;


    public UsersController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<String>> createUser(@RequestBody HashMap<String, Object> user) {
        try {
            RestUsers users = new RestUsers();
            users.setUserId((String) user.get("userId"));
            users.setEmail((String) user.get("email"));
            users.setDisplayName((String) user.get("displayName"));
            users.setCreatedAt((String) user.get("createdAt"));
            ArrayList<String> list = (ArrayList<String>) user.get("tasks");

            ArrayList<DocumentReference> taskRef = new ArrayList<>();
            if (!list.isEmpty()) {
                for (String task : list) {
                    Firestore db = FirestoreClient.getFirestore();
                    taskRef.add(db.collection("tasks").document(task));
                }
            }
            users.setTasks(taskRef);
            String id = service.createUser(users);


            return ResponseEntity.status(201).body(new ApiResponse<>(true, "User created successfully", id, null));

        } catch (ParseException e) {
            return ResponseEntity.status(401).body(new ApiResponse<>(false, "Invalid date format", null, e));
        } catch (ExecutionException e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Internal Server Error", null, e));
        } catch (InterruptedException e) {
            return ResponseEntity.status(503).body(new ApiResponse<>(false, "Unable to reach firebase", null, e));
        }

    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<Users>> getUserByID(@PathVariable(name = "userId") String userId) {
        try {
            Users user = service.getUserById(userId);

            if (user != null) {
                return ResponseEntity.ok(new ApiResponse<>(true, "User found", user, null));
            } else {
                return ResponseEntity.status(204).body(new ApiResponse<>(true, "User not found", null, null));
            }


        } catch (ParseException | ExecutionException e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Internal Server Error", null, e));
        } catch (InterruptedException e) {
            return ResponseEntity.status(503).body(new ApiResponse<>(false, "Unable to reach firebase", null, e));
        }
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Users>>> getAllUsers() {
        try {
            List<Users> users = service.getAllUsers();
            if (users != null) {
                return ResponseEntity.ok(new ApiResponse<>(true, "Users found", users, null));
            } else {
                return ResponseEntity.status(204).body(new ApiResponse<>(true, "No users found", null, null));
            }


        } catch (ExecutionException e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false, "Internal Server Error", null, e));
        } catch (InterruptedException e) {
            return ResponseEntity.status(503).body(new ApiResponse<>(false, "Unable to reach firebase", null, e));
        }
    }
