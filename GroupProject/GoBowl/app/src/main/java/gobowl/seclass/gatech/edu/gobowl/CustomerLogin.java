package gobowl.seclass.gatech.edu.gobowl;

import gobowl.seclass.gatech.edu.gobowl.controller.BowlingSystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        TextView tv = (TextView)  findViewById(R.id.tvTitle);
        if (title != null && title.length() != 0) {
            tv.setText(title);
        } else {
            tv.setText("");
        }
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
        Intent intent = getIntent();
        String action = intent.getStringExtra("action");

        if (action.equals("login")) {

            BowlingSystem bsys = BowlingSystem.getInstance();
            String first = bsys.login();

            if (first.length() == 0) {
                dialog("Error", "Your card did not scan.  Try again");
                return;
            }
            Intent resultIntent = new Intent();
            resultIntent.putExtra("why", "login");
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
            return;
        }

        if (action.equals("next")) {
            BowlingSystem bsys = BowlingSystem.getInstance();
            int status = bsys.nextBowler();

            if (status == -1) {
                dialog("Error", "Your card did not scan.  Try again");
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("why", "next");
            resultIntent.putExtra("status", Integer.toString(status));
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }

    }
}
