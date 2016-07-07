package gobowl.seclass.gatech.edu.gobowl;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

import gobowl.seclass.gatech.edu.gobowl.models.Persistence;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File bowlfile = this.getDatabasePath("bowler");
        Persistence.getInstance().initDB(bowlfile);
    }


    public void buttonManager(View view) {
        Intent myIntent = new Intent(MainActivity.this, ManagerMenu.class);
        MainActivity.this.startActivity(myIntent);

    }

    public void buttonCustomer(View view) {
        Intent myIntent = new Intent(this, CustomerLogin.class);
        myIntent.putExtra("title","Scan Card to Log in");
        myIntent.putExtra("action", "login");
        startActivityForResult(myIntent, 0);
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
