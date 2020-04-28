package com.example.button_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonOk;
    private Button buttonCancel;
    private TextView headTv;
    private LinearLayout llBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOk = findViewById(R.id.btnOk);
        buttonCancel = findViewById(R.id.btnCancel);
        headTv = findViewById(R.id.tvOut);
        llBottom = findViewById(R.id.linearLayout1);

        buttonOk.setOnClickListener(onClickListener);
        buttonCancel.setOnClickListener(onClickListener);
        headTv.setOnClickListener(onClickListener);
        llBottom.setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnOk:
                    headTv.setText("Нажата кнопка ОК");
                    llBottom.setBackgroundColor(0xAAC1FFFF);
                    break;
                case R.id.btnCancel:
                    headTv.setText("Нажата кнопка Cansel");
                    break;
                case R.id.tvOut:
                    headTv.setText("Нажал на TextView");
                    break;
            }
        }
    };
}
