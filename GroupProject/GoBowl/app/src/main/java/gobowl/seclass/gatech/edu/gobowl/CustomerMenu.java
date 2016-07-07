package gobowl.seclass.gatech.edu.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import gobowl.seclass.gatech.edu.gobowl.controller.BowlingSystem;

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

}
