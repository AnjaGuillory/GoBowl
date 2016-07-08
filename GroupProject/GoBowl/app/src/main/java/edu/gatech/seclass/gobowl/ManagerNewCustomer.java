package edu.gatech.seclass.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.util.CheesyCallback;
import edu.gatech.seclass.gobowl.util.CheesyDialog;
import gobowl.seclass.gatech.edu.gobowl.R;

/*
    Activity for creating a new customer ... just grabs the three input fields
    when the user is ready and sends them along...

 */
public class ManagerNewCustomer extends AppCompatActivity {

    private EditText etFirst;
    private EditText etLast;
    private EditText etEmail;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_new_customer);
        Intent myIntent = getIntent();

        etFirst = (EditText) findViewById(R.id.etFirst);
        etLast = (EditText) findViewById(R.id.etLast);
        etEmail = (EditText) findViewById(R.id.etEmail);

        Button btnCreate = (Button) findViewById(R.id.btnCreate);


        if (myIntent.getStringExtra("task").equals("new")) {
            mode = 1;
            btnCreate.setText("Create Bowler!");
            return;
        }

        mode = 2;
        BowlingSystem bsys = BowlingSystem.getInstance();

        etFirst.setText(bsys.getCustomerFirst());
        etLast.setText(bsys.getCustomerLast());
        etEmail.setText(bsys.getCustomerEmail());

        btnCreate.setText("Update Bowler!");
    }

    public void buttonAdd(View view) {
        String first = etFirst.getText().toString();
        String last = etLast.getText().toString();
        String email = etEmail.getText().toString();

        BowlingSystem bsys = BowlingSystem.getInstance();

        if (mode == 1) {

            bsys.addCustomer(first, last, email);

            CheesyDialog cd = new CheesyDialog(ManagerNewCustomer.this);

            cd.dialog("New Customer", "Customer " + first + " created!",
                    new CheesyCallback() {
                        @Override
                        public void allDone(android.content.Context parent) {
                            finish();
                        }
                    });
            return;
        }

        bsys.updateCustomer(first, last, email);

        CheesyDialog cd = new CheesyDialog(ManagerNewCustomer.this);

        cd.dialog("Customer", "Customer " + first + " updated!",
                new CheesyCallback() {
                    @Override
                    public void allDone(android.content.Context parent) {
                        finish();
                    }
                });

    }
}
