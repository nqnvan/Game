package com.example.yourbrain.DifferentColor.Object;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.yourbrain.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterColor extends ArrayAdapter {

    Context context;
    ArrayList<Color> arrColor;

    public AdapterColor(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrColor = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_color,null);

        }
        if(arrColor.size()!=0) {
            Color c = arrColor.get(position);
            ImgCustom imgCustom = convertView.findViewById(R.id.imgcolor);
            imgCustom.setColorFilter(android.graphics.Color.parseColor(c.maMau));
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return arrColor.size();
    }

    public void upDate(ArrayList<Color> array) {
        this.arrColor.clear();
        this.arrColor.addAll(array);
        notifyDataSetChanged();
    }
}
