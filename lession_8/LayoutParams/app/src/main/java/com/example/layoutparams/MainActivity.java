package com.example.layoutparams;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llMain;
    RadioGroup rgGravity, rgColor;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    llMain = findViewById(R.id.llMain);
    llMain.setBackgroundColor(0xAAC1FFFF);

    rgGravity = findViewById(R.id.rgGravity);
    rgColor = findViewById(R.id.rgColor);

    etName = findViewById(R.id.etName);

    btnCreate = findViewById(R.id.btnCreate);
    btnCreate.setOnClickListener(this);

    btnClear = findViewById(R.id.btnClear);
    btnClear.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCreate) {
            // Создание LayoutParams c шириной и высотой по содержимому
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                    wrapContent, wrapContent);
            int btnColor = Color.BLUE;
            // переменная для хранения значения выравнивания
            // по умолчанию пусть будет LEFT
            int btnGravity = Gravity.LEFT;
            // определяем, какой RadioButton "чекнут" и
            // соответственно заполняем btnGravity

            switch (rgGravity.getCheckedRadioButtonId()) {
                case R.id.rbLeft:
                    btnGravity = Gravity.LEFT;
                    break;
                case R.id.rbCenter:
                    btnGravity = Gravity.CENTER_HORIZONTAL;
                    break;
                case R.id.rbRight:
                     btnGravity = Gravity.RIGHT;
                     break;
                }
            switch (rgColor.getCheckedRadioButtonId()){
                case R.id.rbRed:
                    btnColor = Color.RED;
                    break;
                case R.id.rbBlack:
                    btnColor = Color.BLACK;
                    break;
                case R.id.rbBlue:
                    btnColor = Color.BLUE;
                    break;
            }
                // переносим полученное значение выравнивания в LayoutParams
             lParams.gravity = btnGravity;
             // создаем Button, пишем текст и добавляем в LinearLayout
             Button btnNew = new Button(this);
             btnNew.setBackgroundColor(btnColor);
             btnNew.setText(etName.getText().toString());
             btnNew.setTextColor(Color.WHITE);
             llMain.addView(btnNew, lParams);
        }
        else if (v.getId() == R.id.btnClear)
        {
            llMain.removeAllViews();
            Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
        }
    }
}
