package com.example.rahms.ui.rahms;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceRahms;
    private List<RAHMS> sensors = new ArrayList<>();

    // Read from the database
    long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);
    String dateString = date.toString();
    //System.out.println(dateString);

    public FirebaseDatabaseHelper() {

        mDatabase = FirebaseDatabase.getInstance();
        mReferenceRahms = mDatabase.getReference("RAHMS").child(dateString);
    }

    public void readSensors(final DataStatus dataStatus) {
        mReferenceRahms.orderByChild(dateString).limitToLast(5).addValueEventListener(new ValueEventListener() { // 288 entries every 5 mins reading
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sensors.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    RAHMS rahms = keyNode.getValue(RAHMS.class);
                    sensors.add(rahms);
                }
                dataStatus.DataIsLoaded(sensors, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public interface DataStatus {
        void DataIsLoaded(List<RAHMS> sensors, List<String> keys);

        void DataIsInserted();

        void DataIsUpdated();

        void DataIsDeleted();
    }
}
