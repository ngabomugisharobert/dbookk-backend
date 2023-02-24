package com.example.dbookk.service;

import com.example.dbookk.entity.Guard;
import com.example.dbookk.entity.Visitor;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class GuardService {


    public Guard[] getGuards() throws ExecutionException, InterruptedException {


        Firestore dbFirebase = FirestoreClient.getFirestore();


        ApiFuture<QuerySnapshot> future = dbFirebase.collection("tb_guards").get();
        QuerySnapshot documents = future.get();
        int size = documents.size();
        Guard[] guards = new Guard[size];
//        System.out.println("size: " + size);
        int i = 0;
        for (DocumentSnapshot document : documents.getDocuments()) {
            Guard guard = document.toObject(Guard.class);
            if(guard != null)
            {
                guard.setDocumentId(document.getId());
            }
            guards[i] = guard;
            i++;
        }
        return guards;
    }


}
