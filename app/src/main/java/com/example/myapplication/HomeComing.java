package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout btnBack;
    LinearLayout btnModal,btnClose;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_1);
        btnBack = findViewById(R.id.btnBack);
        btnModal = findViewById(R.id.btnModal);
        btnClose = findViewById(R.id.btnClose);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogtest = new Dialog(MainActivity2.this);
                dialogtest.setContentView(R.layout.dialogtest);
                dialogtest.getWindow().setDimAmount(0.50f);
                dialogtest.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialogtest.setCanceledOnTouchOutside(true);
                Window win = dialogtest.getWindow();
                win.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                dialogtest.show();
                //close
                LinearLayout btnClose = dialogtest.findViewById(R.id.btnClose);
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogtest.dismiss();
                    }
                });

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
            }
        });
    }
}
