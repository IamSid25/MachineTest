package com.iam_sid.machinetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHandler db;
    EditText name,email,phone;
    Button btnSubmit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.etName);
        email=(EditText)findViewById(R.id.etEmail);
        phone=(EditText)findViewById(R.id.etPhoneNo);
        btnSubmit=(Button)findViewById(R.id.bSubmit);

        db= new DBHandler(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users=new Users();
                users.setName(name.getText().toString());
                users.setEmail(email.getText().toString());
                users.setNumber(phone.getText().toString());
                boolean result=db.insert_users(users);
                Log.i("result : ",String.valueOf(result));

                if(result==true)
                {
                    Toast.makeText(MainActivity.this,"data is inserted", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(MainActivity.this,"data is not inserted", Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}
