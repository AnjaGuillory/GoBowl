package gobowl.seclass.gatech.edu.gobowl.util;

import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by charles on 7/7/16.
 */
public class CheesyDialog {
    /*
        Just a way to not have to replicate dialog code all over the place....
     */

    private android.content.Context parent;

    public CheesyDialog(android.content.Context myparent) {
        parent = myparent;
    }

    public void dialog(String title, String message, final CheesyCallback callback) {
        AlertDialog alertDialog = new AlertDialog.Builder(parent).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (callback != null) {
                            callback.allDone(parent);
                        }
                    }
                });
        alertDialog.show();

    }
}