package edu.gatech.seclass.gobowl;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.util.CheesyDialog;
import gobowl.seclass.gatech.edu.gobowl.R;


public class ManagerMenu extends AppCompatActivity {

    private int whatNext = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_menu);
    }

    public void buttonNew(View view) {
        Intent myIntent = new Intent(ManagerMenu.this, ManagerNewCustomer.class);
        myIntent.putExtra("task", "new");
        ManagerMenu.this.startActivity(myIntent);
    }

    public void buttonReprintCard(View view) {
        whatNext = 1;
        Intent myIntent = new Intent(this, ManagerFindCustomer.class);
        startActivityForResult(myIntent, 0);
    }

    public void buttonEditCustomer(View view) {
        whatNext = 2;
        Intent myIntent = new Intent(this, ManagerFindCustomer.class);
        startActivityForResult(myIntent, 0);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String why = data.getStringExtra("result");
            if (why != null && why.equals("found")) {

                if (whatNext == 1) {
                    BowlingSystem.getInstance().reprintCard();
                    CheesyDialog cd = new CheesyDialog(this);

                    cd.dialog("Printed", "The card is reprinted!",null);
                    return;
                }
                Intent myIntent = new Intent(ManagerMenu.this, ManagerNewCustomer.class);
                myIntent.putExtra("task", "edit");
                ManagerMenu.this.startActivity(myIntent);
            }
        }
    }

}
