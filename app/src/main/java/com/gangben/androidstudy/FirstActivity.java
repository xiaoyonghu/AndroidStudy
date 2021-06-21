package com.gangben.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);//加载自定义布局

        Button button1 = (Button) findViewById(R.id.button_1); //读学习一下编写lambda表达式
        button1.setOnClickListener(v -> {
            Toast.makeText(FirstActivity.this, "点击完成", Toast.LENGTH_LONG).show();
        });
    }
}