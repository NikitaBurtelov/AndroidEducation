package com.burtelov.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {
    Button btnActOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();

        System.out.println("Run 2 activity");
    }

    public void onClick(View v)
    {
        if (true) {
            System.out.println(1);
        }
    }
}
