package edu.gatech.seclass.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gobowl.seclass.gatech.edu.gobowl.R;


public class ManagerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_menu);
    }

    public void buttonNew(View view) {
        Intent myIntent = new Intent(ManagerMenu.this, ManagerNewCustomer.class);
        ManagerMenu.this.startActivity(myIntent);
    }
}
