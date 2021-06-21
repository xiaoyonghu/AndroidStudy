package com.gangben.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //使用第二种监听方式
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);

//        Intent intent = getIntent();
//        //是什么类型就用什么类型，这里是String类型
//        String msg = intent.getStringExtra("data");
//        Log.d("SecondActivity",msg);

        editText = (EditText) findViewById(R.id.edi_1);

    }

    /***
     * 第二种实现点击 监控的方法
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_2:
                //业务逻辑
                String inputText = editText.getText().toString();
                Toast.makeText(SecondActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}