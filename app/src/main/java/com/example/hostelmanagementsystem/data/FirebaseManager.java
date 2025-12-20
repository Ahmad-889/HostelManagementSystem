package com.example.hostelmanagementsystem.data;

import com.example.hostelmanagementsystem.callbacks.CountCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseManager {
    private static FirebaseDatabase database;
    private static DatabaseReference rootRef;

    public static void init() {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            rootRef = database.getReference("HMS");
        }
    }

    public static DatabaseReference getRootRef() {
        if (rootRef == null) {
            init(); // safety fallback
        }
        return rootRef;
    }

    public void getAllApplicationsCount(CountCallback callback) {
        getRootRef().child("applications")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        callback.onCount(snapshot.getChildrenCount());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        callback.onCount(0);
                    }
                });
    }

    public void getAllRoomsCount(CountCallback callback) {
        getRootRef().child("rooms")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        callback.onCount(snapshot.getChildrenCount());
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        callback.onCount(0);
                    }
                });
    }
    

}
