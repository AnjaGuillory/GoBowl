package edu.gatech.seclass.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.test.R;
import edu.gatech.seclass.gobowl.controller.BowlingSystem;

public class CustomerLaneDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_lane_display);

        int lane = BowlingSystem.getInstance().startBowling();

        Intent intent = getIntent();
        TextView tv = (TextView)  findViewById(R.id.tvLaneNumber);
        tv.setText(String.format("%02d", lane));

    }

    public void buttonLaneDone(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Removes other Activities from stack
        startActivity(intent);
    }
}
