package com.example.mehmet.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    private Spinner spinner;
    DatabaseHelper mydb;
    TextView loginbtn;
    EditText  FullName,Email,Password,Phone;
    String record = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_student);
        //typecast

        FullName = (EditText) findViewById(R.id.FullName);
        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Email);
        Phone=(EditText)findViewById(R.id.phone);

        mydb = new DatabaseHelper(this);




    }


    public void SubmitBtn(View view) {


    }


}


