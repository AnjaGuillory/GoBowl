package gobowl.seclass.gatech.edu.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gobowl.seclass.gatech.edu.gobowl.controller.BowlingSystem;
import gobowl.seclass.gatech.edu.gobowl.util.CheesyDialog;

public class CustomerMenu extends AppCompatActivity {
    private BowlingSystem bsys = BowlingSystem.getInstance();

    private TextView tvGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);

        tvGreeting = (TextView) findViewById(R.id.tvGreeting);

        tvGreeting.setText("Welcome, " + bsys.getFirstName() + "!");
    }


    public void buttonRequestLane(View view) {
        Intent myIntent = new Intent(this, CustomerNumBowlers.class);
        this.startActivity(myIntent);
    }

    public void buttonCheckout(View view) {
        if (!BowlingSystem.getInstance().checkOut()) {
            CheesyDialog cd = new CheesyDialog(this);
            cd.dialog("Error", "You are not bowling and cannot check out", null);
            return;
        }

        Intent myIntent = new Intent(this, CheckOut.class);
        this.startActivity(myIntent);
    }

}
