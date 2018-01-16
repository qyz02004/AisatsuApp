package jp.techacademy.fukushi.kouchi.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView1);
    }


    @Override
    public void onClick(View view) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        // 設定した時刻に応じてTextViewに表示されるあいさつを変化
                        if ( hourOfDay >= 2 && hourOfDay <= 9 ) {           // 2:00 ~ 9:59
                            mTextView.setText("おはよう");
                        } else if ( hourOfDay >= 10 && hourOfDay <= 17 ) {  // 10:00 ~ 17:59
                            mTextView.setText("こんにちは");
                        } else {                                            // 18:00 ~ 1:59
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
