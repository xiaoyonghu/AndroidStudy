package com.gangben.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class SQLiteStudy extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_study);

        dbHelper = new MyDatabaseHelper(this, "BookStore.dp", null, 2);

        /**
         * 各种按钮
         */
        Button createTable = (Button) findViewById(R.id.create_database);
        Button addData = (Button) findViewById(R.id.add_data);
        Button updateData = (Button) findViewById(R.id.update_data);
        Button deleteData = (Button) findViewById(R.id.del_data);
        Button queryData = (Button) findViewById(R.id.query_data);

        /**
         * 创建数据库
         */
        createTable.setOnClickListener(v -> {
            dbHelper.getWritableDatabase();
        });

        /**
         * 1、新增
         */
        addData.setOnClickListener(v -> {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", "Ein Hund namens Money");
            values.put("author", "BodoSchafer");
            values.put("price", "98.21");
            values.put("pages", "202");
            db.insert("Book", null, values);
            values.clear();

            values.put("name", "My Struggle");
            values.put("author", "Unknown");
            values.put("price", "998.21");
            values.put("pages", "202");
            db.insert("Book", null, values);

            Toast.makeText(SQLiteStudy.this, " Create Success", Toast.LENGTH_SHORT).show();
        });

        /**
         * 2、修改
         */
        updateData.setOnClickListener(v -> {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price", "108.92");
            db.update("Book", values, "name = ?", new String[]{"Ein Hund namens Money"});
            Toast.makeText(SQLiteStudy.this, " Update Success", Toast.LENGTH_SHORT).show();
        });

        /**
         * 3、删除
         */
        deleteData.setOnClickListener(v -> {
            db = dbHelper.getWritableDatabase();
            db.delete("Book", "pages > ?", new String[]{"500"});
            Toast.makeText(SQLiteStudy.this, " Delete Success", Toast.LENGTH_SHORT).show();
        });

        /**
         * 4、查询
         */
        queryData.setOnClickListener(v -> {
            db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("Book", null, null, null, null, null, null);
            Toast.makeText(SQLiteStudy.this, "查询书籍信息", Toast.LENGTH_SHORT).show();
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                    Double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    Log.d("SQLiteStudy", "Book name is " + name);
                    Log.d("SQLiteStudy", "Book author is " + author);
                    Log.d("SQLiteStudy", "Book pages is " + pages);
                    Log.d("SQLiteStudy", "Book price is " + price);
                } while (cursor.moveToNext());
            }
            //怎么感觉全部都是自己分装，LJ
            cursor.close();
        });

    }
}