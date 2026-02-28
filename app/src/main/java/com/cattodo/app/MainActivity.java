package com.cattodo.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Optional: Set up the button listener programmatically if needed,
        // but since we used android:onClick="goToHome" in XML, we just need the method.
        Button goButton = (Button) findViewById(R.id.go_button);
        // The goToHome method will be called when the button is clicked.
    }

    /**
     * Called when the user clicks the Go button.
     * This method is linked via android:onClick="goToHome" in activity_main.xml.
     */
    public void goToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        // Optional: finish() the activity if we don't want the user to return to the welcome screen
        // finish();
    }
}
