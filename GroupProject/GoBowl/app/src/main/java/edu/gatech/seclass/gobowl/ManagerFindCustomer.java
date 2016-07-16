package edu.gatech.seclass.gobowl;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.util.CheesyDialog;
import gobowl.seclass.gatech.edu.gobowl.R;

public class ManagerFindCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_find_customer);
    }

    public void buttonFindCustomer(View view) {

        //  Logic for search by name is commented out here, but remains elsewhere...

        // EditText etName = (EditText) findViewById(R.id.etFindName);
        EditText etEmail = (EditText) findViewById(R.id.etFindEmail);

        // String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        if (!BowlingSystem.getInstance().findCustomer("",email)) {
            CheesyDialog cd = new CheesyDialog(this);
            cd.dialog("Not Found", "The customer was not found in the system", null);
            return;
        }

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", "found");
        setResult(Activity.RESULT_OK, resultIntent);
        finish();

    }
}
