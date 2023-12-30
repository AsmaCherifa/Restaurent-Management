package com.jovanovic.stefan.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jovanovic.stefan.restaurant.R;

public class login extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_in);

            final Button btnLogin=(Button) findViewById(R.id.loginBtn);
            final Button signUpBtn=(Button) findViewById(R.id.signUpBtn);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EditText username = (EditText) findViewById(R.id.username);
                    EditText password = (EditText) findViewById(R.id.password);
                    MyDatabaseHelper db = new MyDatabaseHelper(login.this);
                    Boolean check = db.checkUser(username.getText().toString(),password.getText().toString());
                    if (check == true){
                        Intent i= new Intent(login.this,MainActivity.class);
                        i.putExtra("username",username.getText().toString());
                        startActivity(i);
                    }else {
                        Toast.makeText(getBaseContext(),"Verify your username/password", Toast.LENGTH_LONG).show();
                    }

                }
            });
            signUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i= new Intent(login.this,signUp.class);
                    startActivity(i);
                }
            });

        }
    }
