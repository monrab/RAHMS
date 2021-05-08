package com.example.rahms.ui.rahms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rahms.R;
import com.example.rahms.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RahmsActivity extends AppCompatActivity {

   /** private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;
    private DatabaseReference mDatabaseUsers;
*/
    private RecyclerView mRecyclerView;
    private TextView mNodeDate;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahms);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mNodeDate = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.image_View);


        String url = "https://9a6d4bd4708c.ngrok.io/saved-photo/photo.jpg";

        Glide.with(this).load(url).into(imageView);
       // Picasso.get().load(url).into(imageView);

        new FirebaseDatabaseHelper().readSensors(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<RAHMS> sensors, List<String> keys) {
                new RecyclerViewConfig().setConfig(mRecyclerView, RahmsActivity.this, sensors, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        // Read from the database
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        String dateString = date.toString();
        System.out.println(dateString);
        mNodeDate.setText(dateString);
/**
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null){
                    Intent loginIntent = new Intent(RahmsActivity.this, LoginActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);
                }
            }
        };


        // listView = findViewById(R.id.listView);
        // ArrayList<String> list = new ArrayList<>();
        // ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item);
        // listView.setAdapter(adapter);

        // DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("RAHMS").child(dateString);
        // DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("RAHMS");
        //database.orderByKey().limitToLast(1).addChildEventListener(new ChildEventListener(){}
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Query lastQuery = databaseReference.child("2021-03-14").orderByKey().limitToLast(1);
        lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("inside dataSnapshot");
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    System.out.println("iterating through children");
                    if (data.child("LDR").exists()) {
                        System.out.println("LDR exists");
                    } else {
                        System.out.println("LDR doesnt exist");
                    }
                }
               //String message = dataSnapshot.child("20:32:33").getValue();
                // System.out.println("The value is: " + message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("there's an error.");
            }
        });*/
    }
}