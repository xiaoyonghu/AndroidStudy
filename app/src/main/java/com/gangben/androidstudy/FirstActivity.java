package com.gangben.androidstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

public class FirstActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);//加载自定义布局

        Button button1 = (Button) findViewById(R.id.button_1); //学习一下编写lambda表达式
        imageView = (ImageView)findViewById(R.id.image_view_1);
        button1.setOnClickListener(v -> {
            //Toast.makeText(FirstActivity.this, "点击完成", Toast.LENGTH_LONG).show();

            //显式intent
            //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

            //隐式intent 依据action 1 和category n 来匹配
            //Intent intent = new Intent("com.gangben.androidstudy.ACTION_START");
            //intent.addCategory("com.gangben.androidstudy.MY_CATEGORY");

            //书中有写到android中的协议形式，打开电话拨号界面
            //intent.setData(Uri.parse("tel:10086"));

            //使用intent传递数据
            //String data = "you see see you";
            Intent intent = new Intent(FirstActivity.this, ListViewSimpleActivity.class);
            //intent.putExtra("data", data);
            startActivity(intent);

            //更改图片
            //imageView.setImageResource(R.drawable.landscape);

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "点击了添加按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "点击了删除按钮", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}