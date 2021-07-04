package com.gangben.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SharedPreference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        Button saveData = (Button) findViewById(R.id.save_pref_data);

        Button readData = (Button) findViewById(R.id.read_pref_data);

        readData.setOnClickListener(v -> {
            Toast.makeText(SharedPreference.this, "读取 share_pref 被点击了", Toast.LENGTH_SHORT).show();
            SharedPreferences sp = getSharedPreferences("data_sha_pref", MODE_PRIVATE);
            String name = sp.getString("name", "你说傻子吧");
            int age = sp.getInt("age", 0);
            Boolean married = sp.getBoolean("married", false);
            Log.d("SharedPreference", "name is " + name);
            Log.d("SharedPreference", "age is " + age);
            Log.d("SharedPreference", "married is " + married);
        });

        saveData.setOnClickListener(v -> {
            Toast.makeText(SharedPreference.this, "存储 share_pref 被点击了", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = getSharedPreferences("data_sha_pref", MODE_PRIVATE).edit();
            editor.putString("name", "Jack");
            editor.putInt("age", 22);
            editor.putBoolean("married", false);
            editor.apply();
        });
    }
}