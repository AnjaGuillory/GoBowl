package gobowl.seclass.gatech.edu.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomerLaneDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_lane_display);


        Intent intent = getIntent();
        String title = intent.getStringExtra("lane");
        TextView tv = (TextView)  findViewById(R.id.tvLaneNumber);
        if (title != null && title.length() != 0) {
            tv.setText(title);
        } else {
            tv.setText("??");
        }

    }

    public void buttonLaneDone(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Removes other Activities from stack
        startActivity(intent);
    }
}
