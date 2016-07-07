package gobowl.seclass.gatech.edu.gobowl;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import gobowl.seclass.gatech.edu.gobowl.System.Bowler;
import gobowl.seclass.gatech.edu.gobowl.System.BowlingSystem;
import gobowl.seclass.gatech.edu.gobowl.util.CheesyCallback;
import gobowl.seclass.gatech.edu.gobowl.util.CheesyDialog;

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
                    public void allDone() {
                        finish();
                    }
                });


    }
}
