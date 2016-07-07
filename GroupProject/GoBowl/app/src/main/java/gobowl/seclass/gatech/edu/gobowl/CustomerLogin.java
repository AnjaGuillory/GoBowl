package gobowl.seclass.gatech.edu.gobowl;

import gobowl.seclass.gatech.edu.gobowl.System.BowlingSystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
    }

    private void dialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(CustomerLogin.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


    public void buttonLogin(View view) {
        BowlingSystem bsys = BowlingSystem.getInstance();
        String first = bsys.login();

        if (first.length() == 0) {
            dialog("Error", "Your card did not scan.  Try again");
            return;
        }

        Intent myIntent = new Intent(CustomerLogin.this, CustomerMenu.class);
        CustomerLogin.this.startActivity(myIntent);


    }
}
