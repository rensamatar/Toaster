package com.tarconcept.toaster_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tarconcept.toaster.Duration;
import com.tarconcept.toaster.Toaster;
import tarconcept.com.toaster_sample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    private void initComponent() {
        Button btnInfo = (Button) findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.showInfo(MainActivity.this, "Info message here", Duration.LENGTH_LONG);
            }
        });
        Button btnWarning = (Button) findViewById(R.id.btn_warning);
        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.showWarning(MainActivity.this, "Warning message here", Duration.LENGTH_LONG);
            }
        });
        Button btnError = (Button) findViewById(R.id.btn_error);
        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.showError(MainActivity.this, "Error message here", Duration.LENGTH_LONG);
            }
        });
        Button btnSuccess = (Button) findViewById(R.id.btn_success);
        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.showSuccess(MainActivity.this, "Success message here", Duration.LENGTH_LONG);
            }
        });
    }

}
