package gobowl.seclass.gatech.edu.gobowl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import gobowl.seclass.gatech.edu.gobowl.System.BowlingSystem;

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
}
