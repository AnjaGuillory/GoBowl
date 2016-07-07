package gobowl.seclass.gatech.edu.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gobowl.seclass.gatech.edu.gobowl.controller.BowlingSystem;
import gobowl.seclass.gatech.edu.gobowl.util.CheesyCallback;
import gobowl.seclass.gatech.edu.gobowl.util.CheesyDialog;

public class ScanCreditCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_credit_card);
    }

    public void buttonNextCard(View view) {
        int resp = BowlingSystem.getInstance().makePayment();
        CheesyDialog cd = new CheesyDialog(this);

        switch (resp) {
            case -1:
                cd.dialog("Error", "The card was not read.  Please swipe again", null);
                break;
            case -2:
                cd.dialog("Error", "The card was not accepted.  Please try anogther", null);
                break;
            case 0:
                cd.dialog("Payment Accepted", "Thank you. Please retrieve the next card to pay with.", null);
                break;
            case 1:
                cd.dialog("Payment Accepted", "Thank you. You are all paid!",
                        new CheesyCallback() {
                            @Override
                            public void allDone(android.content.Context parent) {
                                Intent intent = new Intent(parent, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Removes other Activities from stack
                                startActivity(intent);
                            }
                        }
                );

                break;

        }
    }
}
