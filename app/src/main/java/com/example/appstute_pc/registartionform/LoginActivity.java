package com.example.appstute_pc.registartionform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin,btnCancel;
    EditText txtUsername,txtPassword;
    TextView user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        loginSuccess();
        sighUp();

    }

    private void sighUp() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent=new Intent(getApplicationContext(),RegistrationForm.class);
                startActivity(signUpIntent);
            }
        });
    }

    private void loginSuccess() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginDetails.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        txtUsername= (EditText) findViewById(R.id.txtUsername);
        user= (TextView) findViewById(R.id.user);
        txtPassword= (EditText) findViewById(R.id.txtPassword);
        pass= (TextView) findViewById(R.id.pass);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnCancel= (Button) findViewById(R.id.btnSighUp);
    }
}
