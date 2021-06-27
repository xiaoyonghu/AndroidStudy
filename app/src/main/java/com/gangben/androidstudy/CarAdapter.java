package com.gangben.androidstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CarAdapter extends ArrayAdapter<Car> {

    private int resourceId;

    public CarAdapter(Context context, int resourceId, List<Car> objects) {
        super(context, resourceId, objects);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Car car = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView carView = (ImageView) view.findViewById(R.id.car_image);
        TextView carName = (TextView) view.findViewById(R.id.car_name);
        carView.setImageResource(car.getImageId());
        carName.setText(car.getName());
        return view;
    }
}
