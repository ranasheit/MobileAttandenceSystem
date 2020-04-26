package com.example.mehmet.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class student extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String>arrayList;
    private ArrayAdapter adapter;
    private Button addItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);


        listView=(ListView)findViewById(R.id.listviewid);
        addItem=(Button)findViewById(R.id.add_item);


    }
}
