package com.example.losst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvColor, tvSize, tvTest;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = findViewById(R.id.tvColor);
        tvSize = findViewById(R.id.tvSize);
        tvTest = findViewById(R.id.tvHead);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);

        tvColor.setOnCreateContextMenuListener(this);
        tvSize.setOnCreateContextMenuListener(this);
        tvTest.setOnCreateContextMenuListener(this);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.tvColor:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.tvSize:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                tvTest.setTextColor(Color.RED);
                break;
            case MENU_COLOR_GREEN:
                tvTest.setTextColor(Color.GREEN);
                break;
            case MENU_COLOR_BLUE:
                tvTest.setTextColor(Color.BLUE);
                break;
        // пункты меню для tvSize
            case MENU_SIZE_22:
                tvTest.setTextSize(22);
                break;
            case MENU_SIZE_26:
                tvTest.setTextSize(26);
                break;
            case MENU_SIZE_30:
                tvTest.setTextSize(30);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
