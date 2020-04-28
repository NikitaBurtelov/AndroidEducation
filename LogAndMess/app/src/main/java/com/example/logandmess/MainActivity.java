package com.example.logandmess;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public Button buttonOk;
    public Button buttonCancel;
    private TextView headTv;
    private LinearLayout llBottom;
    private CheckBox chb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOk = findViewById(R.id.btnOk);
        buttonCancel = findViewById(R.id.btnCancel);
        headTv = findViewById(R.id.tvOut);
        llBottom = findViewById(R.id.linearLayout1);
        chb = findViewById(R.id.chbExtMenu);

        buttonOk.setOnClickListener(onClickListener);
        buttonCancel.setOnClickListener(onClickListener);
        headTv.setOnClickListener(onClickListener);
        llBottom.setOnClickListener(onClickListener);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        /*
        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
    */
        //get.GroupId - 0, 1
        //get.getItemId 1....6
        //get.Order - 3 столбец сортировка при отображении
        //getTitle - "...."

        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 4, "exit");

        return super.onCreateOptionsMenu(menu);
    }


    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.setGroupVisible(1, chb.isChecked());

        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        Toast toast = Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        StringBuilder sb = new StringBuilder();

        sb.append("Item menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        headTv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }
    
    public void showToast()
    {
        Toast toast = Toast.makeText(getApplicationContext(), "GGGGGGG", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void showToastImage()
    {
        Toast toastImage = Toast.makeText(getApplicationContext(), "Библан", Toast.LENGTH_LONG);
        toastImage.setGravity(Gravity.CENTER, 0 ,0);

        LinearLayout toastContainer = (LinearLayout) toastImage.getView();

        ImageView bibaImageView = new ImageView(getApplicationContext());
        bibaImageView.setImageResource(R.drawable.vovkaget);
        toastContainer.addView(bibaImageView, 0);

        toastImage.show();
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnOk:
                    //headTv.setText("Нажата кнопка ОК");
                    llBottom.setBackgroundColor(0xAAC1FFFF);
                    showToastImage();
                    break;
                case R.id.btnCancel:
                    headTv.setText(R.string.testViewValue1);
                    break;
                case R.id.tvOut:
                    //headTv.setText("Нажал на TextView");
                    break;
            }
        }
    };

}
