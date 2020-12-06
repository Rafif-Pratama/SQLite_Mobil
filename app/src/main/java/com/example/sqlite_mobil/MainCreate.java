package com.example.sqlite_mobil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private Database_Mobil db;
    private EditText Emerk, Ejenis, Etahun;
    private String Smerk, Sjenis, Stahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new Database_Mobil(this);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Etahun = (EditText) findViewById(R.id.create_tahun);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Stahun = String.valueOf(Etahun.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merk mobil",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis mobil",
                            Toast.LENGTH_SHORT).show();
                }  else if (Stahun.equals("")){
                    Etahun.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tahun pembuatan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Emerk.setText("");
                    Ejenis.setText("");
                    Etahun.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMobil(new Mobil(null, Smerk, Sjenis, Stahun));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}