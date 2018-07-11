package com.iam_sid.machinetest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        setData();
    }

    private void setData() {
        Cursor res= db.getAlldata();

        if(res.getCount()==0)
        {

            return;
        }

        StringBuffer buffer= new StringBuffer();
        while (res.moveToNext())
        {
            name.append("NAME :"+res.getString(1)+"\n");
            email.append("EMAIL "+res.getString(2)+"\n");
            number.append("EMAIL "+res.getString(3)+"\n");
        }
    }
}

