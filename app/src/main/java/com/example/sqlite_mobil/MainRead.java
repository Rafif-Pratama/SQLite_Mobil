package com.example.sqlite_mobil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private Database_Mobil db;
    private List<Mobil> ListMobil = new ArrayList<Mobil>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new Database_Mobil(this);
        adapter_off = new CustomListAdapter(this, ListMobil );
        mListView = (ListView) findViewById(R.id.list_mobil);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMobil.clear();
        List<Mobil> contacts = db.ReadMobil();
        for (Mobil cn : contacts) {
            Mobil judulModel = new Mobil();
            judulModel.set_id(cn.get_id());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_tahun(cn.get_tahun());
            ListMobil.add(judulModel);
            if ((ListMobil.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Mobil obj_itemDetails = (Mobil) o;
        String Sid = obj_itemDetails.get_id();
        String Smerk = obj_itemDetails.get_merk();
        String Sjenis = obj_itemDetails.get_jenis();
        String Stahun = obj_itemDetails.get_tahun();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Itahun", Stahun);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMobil.clear();
        mListView.setAdapter(adapter_off);
        List<Mobil> contacts = db.ReadMobil();
        for (Mobil cn : contacts) {
            Mobil judulModel = new Mobil();
            judulModel.set_id(cn.get_id());
            judulModel.set_merk(cn.get_merk());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_tahun(cn.get_tahun());
            ListMobil.add(judulModel);
            if ((ListMobil.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}