package com.example.sqlite_mobil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private Database_Mobil db;
    private String Sid, Smerk, Sjenis, Stahun;
    private EditText Emerk, Ejenis, Etahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new Database_Mobil(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smerk = i.getStringExtra("Imerk");
        Sjenis = i.getStringExtra("Ijenis");
        Stahun = i.getStringExtra("Itahun");
        Emerk = (EditText) findViewById(R.id.updel_merk);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Etahun = (EditText) findViewById(R.id.updel_tahun);
        Emerk.setText(Smerk);
        Ejenis.setText(Sjenis);
        Etahun.setText(Stahun);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Stahun = String.valueOf(Etahun.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merk mobil",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis mobil",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stahun.equals("")) {
                    Etahun.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tahun mobil",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdateMobil(new Mobil(Sid, Smerk, Sjenis, Stahun));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMobil(new Mobil(Sid, Smerk, Sjenis, Stahun));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
