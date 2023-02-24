package com.example.dbookk.service;

import com.example.dbookk.entity.Guard;
import com.example.dbookk.entity.Movement;
import com.example.dbookk.entity.Visitor;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MovementService {

    public Movement[] getMovements() throws ExecutionException, InterruptedException {
        QuerySnapshot movementDocuments = getCollection("tb_movements");
        QuerySnapshot visitorDocuments = getCollection("tb_visitors");
        QuerySnapshot guardDocuments = getCollection("tb_guards");

        int mov_size = movementDocuments.size();
        int vis_size = visitorDocuments.size();
        int guard_size = guardDocuments.size();

        Movement[] movements = new Movement[mov_size];
        Visitor[] visitors = new Visitor[vis_size];
        Guard[] guards = new Guard[guard_size];

        int i=0;
        for (DocumentSnapshot document : movementDocuments.getDocuments())
        {
            Movement movement = document.toObject(Movement.class);
            if(movement != null)
            {
                movement.setDocumentId(document.getId());
            }
            movements[i] = movement;
            i++;
        }

        i=0;
        for (DocumentSnapshot document : visitorDocuments.getDocuments())
        {
            Visitor visitor = document.toObject(Visitor.class);
            if(visitor != null)
            {
                visitor.setDocumentId(document.getId());
            }
            visitors[i] = visitor;
            i++;
        }

        i=0;
        for(DocumentSnapshot document : guardDocuments.getDocuments())
        {
            Guard guard = document.toObject(Guard.class);
            if(guard != null)
            {
                guard.setDocumentId(document.getId());
            }
            guards[i] = guard;
            i++;
        }

//        new movementList with visitor name
        Movement[] movementsWithName = new Movement[mov_size];
        for (int j = 0; j < mov_size; j++) {
            for (int k = 0; k < vis_size; k++) {
                if(movements[j].getVisitor_id().equals(visitors[k].getVis_id()))
                {
                    movements[j].setVis_name(visitors[k].getVis_first_name() + " " + visitors[k].getVis_last_name());
                    movementsWithName[j] = movements[j];
                }
            }
        }

//        new movementList with guard name
        for (int j = 0; j < mov_size; j++) {
            for (int k = 0; k < guard_size; k++) {
                if(movements[j].getGuard_id() == guards[k].getGua_id())
                {
                    movements[j].setGuard_name(guards[k].getGua_first_name() + " " + guards[k].getGua_last_name());
                    movementsWithName[j] = movements[j];
                }
            }
        }
        return movementsWithName;
    }

    private QuerySnapshot getCollection(String collectionName) throws InterruptedException, ExecutionException {

            Firestore dbFirebase = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = dbFirebase.collection(collectionName).get();
            QuerySnapshot documents = future.get();
            return documents;
    }
}
