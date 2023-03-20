package com.example.newbabysisterapp.Activies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newbabysisterapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailText;
    EditText passText;
    private Activity view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        emailText=(EditText) view.findViewById(R.id.editTextTextEmailAddress2);
        passText=(EditText) view.findViewById(R.id.editTextTextPassword);
    }

    public void funcReg(View view) {
//        Intent intent=new Intent(this,signIn.class);
//        startActivity(intent);


        String email = emailText.getText().toString();
        String password = passText.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "login ok", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "login fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

        public void funcSignIn(View view) {
//            Intent intent=new Intent(this,homePage.class);
//            startActivity(intent);

            String email=emailText.getText().toString();
            String password=passText.getText().toString();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this,"login ok",Toast.LENGTH_LONG).show();

                            } else {

                                Toast.makeText(MainActivity.this,"login fail",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }


    }





