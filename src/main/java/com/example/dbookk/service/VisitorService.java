package com.example.dbookk.service;

import com.example.dbookk.entity.Visitor;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
public class VisitorService {

    public Visitor[] getVisitors() throws ExecutionException, InterruptedException {
        QuerySnapshot documents = getCollection("tb_visitors","");
        int size = documents.size();
        Visitor[] visitors = new Visitor[size];
        int i = 0;
        for (DocumentSnapshot document : documents.getDocuments()) {
            Visitor visitor = document.toObject(Visitor.class);
            if(visitor != null)
            {
                visitor.setDocumentId(document.getId());
            }
            visitors[i] = visitor;
            i++;
        }
        return visitors;
    }

    public Visitor getVisitorName(String id) throws ExecutionException, InterruptedException {
        QuerySnapshot documents = getCollection("tb_visitors", id);
        int size = documents.size();
        Visitor[] visitors = new Visitor[size];
        int i = 0;
        for (DocumentSnapshot document : documents.getDocuments()) {
            Visitor visitor = document.toObject(Visitor.class);
            if(visitor != null)
            {
                visitor.setDocumentId(document.getId());
            }
            visitors[i] = visitor;
            i++;
        }
        return visitors[0];
    }

    private QuerySnapshot getCollection(String collectionName, String id) throws InterruptedException, ExecutionException {

        if(id != "") {
            Firestore dbFirebase = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = dbFirebase.collection(collectionName).get();
            QuerySnapshot documents = future.get();
            return documents;
        }else {
            Firestore dbFirebase = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = dbFirebase.collection(collectionName).get();
            QuerySnapshot documents = future.get();
            return documents;
        }
    }

}
