package com.iam_sid.machinetest;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DBHandler db;
    TextView name,email,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=(TextView)findViewById(R.id.etName);
        email=(TextView)findViewById(R.id.etEmail);
        number=(TextView)findViewById(R.id.etPhoneNo);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itemFirst:
                Intent i=new Intent(Main2Activity.this,Profile_View.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
