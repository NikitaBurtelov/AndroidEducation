package com.example.layoutparams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sbWeight, sbColor;
    Button btn1, btn2;
    Color bgColor;

    LinearLayout screen;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    screen = findViewById(R.id.headLl);

    sbColor = findViewById(R.id.sbColor);
    sbColor.setOnSeekBarChangeListener(this);

    sbWeight = findViewById(R.id.sbWeight);
    sbWeight.setOnSeekBarChangeListener(this);

    btn1 = findViewById(R.id.btn1);
    btn2 = findViewById(R.id.btn2);

    lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
    lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {

        int idSeekBar = seekBar.getId();

        if (idSeekBar == R.id.sbWeight) {
            int leftValue = progress;
            int rightValue = seekBar.getMax() - progress;

            System.out.println(leftValue);

            lParams1.weight = leftValue;
            lParams2.weight = rightValue;

            btn1.setText(String.valueOf(leftValue));
            btn2.setText(String.valueOf(rightValue));
        }
        else if (idSeekBar == R.id.sbColor)
        {
            int leftColor = sbColor.getProgress();
            System.out.println(leftColor);
            //int RightColor = seekBar.getMax() - progress;
            if (leftColor != 0)
                screen.setBackgroundColor(0xffffffff - leftColor * 0x100);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
