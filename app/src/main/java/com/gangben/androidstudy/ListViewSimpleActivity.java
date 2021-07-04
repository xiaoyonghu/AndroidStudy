package com.gangben.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来测试ListView的响应事件
 */
public class ListViewSimpleActivity extends AppCompatActivity {

    private List<Car> carList = new ArrayList<>();

    /**
     * 构造简单的数据
     *     //private String[] data = {"Pagani","ApolloIE", "Bugatti",  "McLaren", "Ferrari", "AstonMartin",
     *     //"Lamborghini","Rolls-Royce"};
     */

    /**
     * 1、简单的使用 adapter，只要知道构造函数即可
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_simple);
        initCars();//初始化数据

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewSimpleActivity.this,
//                android.R.layout.simple_list_item_1, data);

        CarAdapter carAdapter = new CarAdapter(ListViewSimpleActivity.this, R.layout.car_item, carList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(carAdapter);

        //为每个item设置监听事件
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Car carCur = carList.get(position);
            //此处只是简单的展示一下即可
            Toast.makeText(ListViewSimpleActivity.this, carCur.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private void initCars() {
        //TODO 使用for的高级用法
        for (int i = 0; i < 2; i++) {
            Car pagani = new Car("Pagani", R.drawable.timg);
            carList.add(pagani);

            Car apolloIE = new Car("ApolloIE", R.drawable.timg);
            carList.add(apolloIE);

            Car bugatti = new Car("Bugatti", R.drawable.timg);
            carList.add(bugatti);

            Car mcLaren = new Car("McLaren", R.drawable.timg);
            carList.add(mcLaren);

            Car ferrari = new Car("Ferrari", R.drawable.timg);
            carList.add(ferrari);

            Car astonMartin = new Car("AstonMartin", R.drawable.timg);
            carList.add(astonMartin);

            Car lamborghini = new Car("Lamborghini", R.drawable.timg);
            carList.add(lamborghini);

            Car rollsRoyce = new Car("Rolls-Royce", R.drawable.timg);
            carList.add(rollsRoyce);
        }
    }
}