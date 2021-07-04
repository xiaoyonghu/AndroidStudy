package com.gangben.androidstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;

public class FirstActivity extends AppCompatActivity {

    private ImageView imageView;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);//加载自定义布局

        Button button1 = (Button) findViewById(R.id.button_1); //学习一下编写lambda表达式
        imageView = (ImageView) findViewById(R.id.image_view_1);
        editText = (EditText) findViewById(R.id.edit_text_local);

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
            Intent intent = new Intent(FirstActivity.this, SharedPreference.class);
            //intent.putExtra("data", data);
            startActivity(intent);

            //更改图片
            //imageView.setImageResource(R.drawable.landscape);

        });

        /**
         * 从本地加载内容
         */
        String inputText = load();
        if (!TextUtils.isEmpty(inputText)) {
            editText.setText(inputText);
            editText.setSelection(inputText.length());
            Toast.makeText(this, "Read Success", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = editText.getText().toString();
        saveToLocal(inputText);
    }

    public void saveToLocal(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        //StringBuffer 和StringBuilder的区别
        StringBuilder sb = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine())!= null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_item:
//                Toast.makeText(this, "点击了添加按钮", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.remove_item:
//                Toast.makeText(this, "点击了删除按钮", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//        }
//        return true;
//    }
//}