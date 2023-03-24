package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText names,phones,address;
    Button submit_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        names = findViewById(R.id.names);
        phones = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        submit_area = findViewById(R.id.submit_area);

        submit_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chk=db.insertData(names.getText().toString(),phones.getText().toString(),address.getText().toString());
                if (chk==true)
                {
                    Toast.makeText(getApplicationContext(), "Submit Successfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Failure",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}