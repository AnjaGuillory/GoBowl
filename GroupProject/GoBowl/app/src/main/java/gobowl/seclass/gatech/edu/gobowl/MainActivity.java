package gobowl.seclass.gatech.edu.gobowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

import gobowl.seclass.gatech.edu.gobowl.System.Persistence;

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
        Intent myIntent = new Intent(MainActivity.this, CustomerLogin.class);
        MainActivity.this.startActivity(myIntent);

    }
}
