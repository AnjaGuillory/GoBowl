package edu.gatech.seclass.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.util.CheesyDialog;
import gobowl.seclass.gatech.edu.gobowl.R;

public class CheckOut extends AppCompatActivity {

    TextView tvLane;
    TextView tvFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        tvLane = (TextView) findViewById(R.id.tvCOlane);
        tvFee = (TextView) findViewById(R.id.tvCOfee);

        BowlingSystem bsys = BowlingSystem.getInstance();

        tvLane.setText(String.format("%02d", bsys.getLane()));
        tvFee.setText(String.format("$ %.2f", bsys.getFees()));
    }

    public void buttonStartPaying(View view) {
        EditText etCards = (EditText) findViewById(R.id.etCards);

        int numCards = Integer.parseInt(etCards.getText().toString());

        if (!BowlingSystem.getInstance().setNumCreditCards(numCards)) {
            CheesyDialog d = new CheesyDialog(this);
            d.dialog("Error", "Invalid number of cards.  Must in range 1 to number of bowlers.", null);
            return;
        }

        Intent myIntent = new Intent(this, ScanCreditCard.class);
        this.startActivity(myIntent);

    }
}
