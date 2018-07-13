package com.iam_sid.machinetest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Profile_View extends AppCompatActivity {

    TextView name,email,number;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__view);

        name=(TextView)findViewById(R.id.etName);
        email=(TextView)findViewById(R.id.etEmail);
        number=(TextView)findViewById(R.id.etPhoneNo);

        Cursor res= db.getAlldata();

        if(res.getCount()==0)
        {
            Toast.makeText(this,"Data Not Found",Toast.LENGTH_SHORT).show();
            return;
        }

//        StringBuffer buffer= new StringBuffer();
        while (res.moveToNext())
        {
            name.setText("NAME :"+res.getString(0)+"\n");
            email.setText("EMAIL "+res.getString(1)+"\n");
            number.setText("PHONE NO "+res.getString(2)+"\n");
        }
    }
}

