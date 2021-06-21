package com.gangben.androidstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);//加载自定义布局

        Button button1 = (Button) findViewById(R.id.button_1); //学习一下编写lambda表达式
        button1.setOnClickListener(v -> {
            //Toast.makeText(FirstActivity.this, "点击完成", Toast.LENGTH_LONG).show();

            //显式intent
            //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

            //隐式intent 靠action 1 和category n 来匹配
            //Intent intent = new Intent("com.gangben.androidstudy.ACTION_START");
            //intent.addCategory("com.gangben.androidstudy.MY_CATEGORY");

            Intent intent = new Intent(Intent.ACTION_VIEW);

            //书中有写到android中的协议形式
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
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