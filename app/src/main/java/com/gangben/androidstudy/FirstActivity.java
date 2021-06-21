package com.gangben.androidstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"点击了添加按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"点击了删除按钮",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}