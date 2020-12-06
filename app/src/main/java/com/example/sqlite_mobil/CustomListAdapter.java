package com.example.sqlite_mobil;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Mobil> movieItems;

    public CustomListAdapter(Activity activity, List<Mobil> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView merk = (TextView) convertView.findViewById(R.id.text_merk);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
        TextView tahun = (TextView) convertView.findViewById(R.id.text_tahun);
        Mobil m = movieItems.get(position);
        merk.setText("Merk    : "+ m.get_merk());
        jenis.setText("Type    : "+ m.get_jenis());
        tahun.setText("Tahun   : "+ m.get_tahun());
        return convertView;
    }

}