package com.example.appstute_pc.registartionform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appstute_pc.registartionform.db.DBPojo;

public class RegistrationForm extends AppCompatActivity {
    EditText name,username,password;
    Button register;
    String empName,empUsername,empPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        init();

        dataStore();
    }

    private void setListener() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplication(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    private void saveData() {
        DBPojo pojo=new DBPojo();
        pojo.setName(empName);
        pojo.setUsername(empUsername);
        pojo.setPassword(empPassword);
        setListener();

    }

    private void init() {
        name= (EditText) findViewById(R.id.txtName);
        username= (EditText) findViewById(R.id.txtUsername);
        password= (EditText) findViewById(R.id.txtPassword);
        register= (Button) findViewById(R.id.btnRegister);

    }

    public void dataStore() {
        empName=name.getText().toString();
        empUsername=username.getText().toString();
        empPassword=password.getText().toString();
        saveData();

    }
}
