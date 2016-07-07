package edu.gatech.seclass.gobowl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.seclass.gobowl.test.R;
import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.util.CheesyCallback;
import edu.gatech.seclass.gobowl.util.CheesyDialog;

/*
    Activity for creating a new customer ... just grabs the three input fields
    when the user is ready and sends them along...

 */
public class ManagerNewCustomer extends AppCompatActivity {

    private EditText etFirst;
    private EditText etLast;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_new_customer);

        etFirst = (EditText) findViewById(R.id.etFirst);
        etLast = (EditText) findViewById(R.id.etLast);
        etEmail = (EditText) findViewById(R.id.etEmail);
    }

    public void buttonAdd(View view) {
        String first = etFirst.getText().toString();
        String last = etLast.getText().toString();
        String email = etEmail.getText().toString();

        BowlingSystem bsys = BowlingSystem.getInstance();

        bsys.addCustomer(first, last, email);

        CheesyDialog cd = new CheesyDialog(ManagerNewCustomer.this);

        cd.dialog("New Customer", "Customer " + first + " created!",
                new CheesyCallback() {
                    @Override
                    public void allDone(android.content.Context parent) {
                        finish();
                    }
                });


    }
}
