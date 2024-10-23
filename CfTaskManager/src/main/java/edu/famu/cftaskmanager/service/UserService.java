package edu.famu.cftaskmanager.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import edu.famu.cftaskmanager.model.RestUsers;
import edu.famu.cftaskmanager.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {


    private final Firestore firestore;


    private static final String USERS_COLLECTION = "Users";
    private static final String TASK_COLLECTION = "Task";


    public UserService() {
        this.firestore = FirestoreClient.getFirestore();
    }

    private Users documentToUser(DocumentSnapshot document) throws ParseException {
        Users user = null;

        if (document.exists()) {
            user = new Users();
            user.setUserId(document.getId());
            user.setDisplayName(document.getString("displayName"));
            user.setEmail(document.getString("email"));
            user.setCreatedAt(document.getTimestamp("createdAt").toString());
            user.setTasks(null);

        }
        return user;
    }

    public List<Users> getAllUsers() throws ExecutionException, InterruptedException {
        CollectionReference usersCollection = firestore.collection(USERS_COLLECTION);
        ApiFuture<QuerySnapshot> querySnapshot = usersCollection.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        List<Users> users = documents.isEmpty() ? null : new ArrayList<>();

        documents.forEach(document -> {
            Users user = null;
            try {
                user = (documentToUser(document));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            users.add(user);
        });
        return users;
    }

    public Users getUserById(String userId) throws ParseException, ExecutionException, InterruptedException {
        DocumentReference usersRef = firestore.collection(USERS_COLLECTION).document(userId);
        DocumentSnapshot userSnap = usersRef.get().get();
        return documentToUser(userSnap);
    }


    public Users getUserByEmail(String email) throws ParseException, ExecutionException, InterruptedException {
        Query query = firestore.collection(USERS_COLLECTION).whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> future = query.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Users> users = documents.isEmpty() ? null : new ArrayList<>();

        documents.forEach(document -> {
            Users user = null;

            if (document.exists()) {
                try {
                    user = documentToUser(document);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                users.add(user);
            }
        });
        return users.get(0);
    }

    public String createUser(RestUsers user) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentReference> writeResult = firestore.collection(USERS_COLLECTION).add(user);
        DocumentReference rs = writeResult.get();
        return rs.getId();
    }



}
