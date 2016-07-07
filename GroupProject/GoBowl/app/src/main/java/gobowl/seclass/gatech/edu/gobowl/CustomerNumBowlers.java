package gobowl.seclass.gatech.edu.gobowl;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomerNumBowlers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_num_bowlers);
    }


    public void buttonGetOthers(View view) {

        Intent myIntent;

        myIntent = new Intent(this, CustomerLaneDisplay.class);
        myIntent.putExtra("lane","S01");
        startActivity(myIntent);

/*
        myIntent = new Intent(this, CustomerLogin.class);
        myIntent.putExtra("title","Scan Card to Log in");
        startActivityForResult(myIntent, 0);
*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String why = data.getStringExtra("why");
            if (why != null && why.equals("login")) {
                Intent myIntent = new Intent(this, CustomerMenu.class);
                this.startActivity(myIntent);

            }
        }
    }

}
