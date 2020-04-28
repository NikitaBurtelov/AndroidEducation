package com.example.button_text;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView helloTv;
    private Button buttonTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView) findViewById(R.id.hello_tv);
        buttonTv = (Button) findViewById(R.id.button_hi);

        helloTv.setOnClickListener(onClickListener);
        buttonTv.setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.button_hi:
                    helloTv.setText("C/C++ сосат!");
                    break;

                case R.id.hello_tv:
                    helloTv.setText("Java топ");
                    break;
            }

        }
    };

}
