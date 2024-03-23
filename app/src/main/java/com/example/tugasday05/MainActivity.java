package com.example.tugasday05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText etNama, etKode, etJumlah;
    private RadioButton rbDiamond, rbGold, rbBiasa;
    private Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        etKode = findViewById(R.id.etKode);
        etJumlah = findViewById(R.id.etJumlah);
        btnProses = findViewById(R.id.btnProses);
        rbDiamond = findViewById(R.id.rbDiamond);
        rbGold = findViewById(R.id.rbGold);
        rbBiasa = findViewById(R.id.rbBiasa);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hpPoco = "Poco M3";
                String hpOppo = "Oppo A17";
                String laptopLenovo = "Lenovo V14 Gen 3";
                String nama = etNama.getText().toString();
                String kode = etKode.getText().toString();
                int jumlah = Integer.parseInt(etJumlah.getText().toString());
                double hargaBarang = 0;
                String namaBarang = "";
                switch (kode) {
                    case "PCO":
                        hargaBarang = 2730551;
                        namaBarang = hpPoco;
                        break;
                    case "O17":
                        hargaBarang = 2500999;
                        namaBarang = hpOppo;
                        break;
                    case "LV3":
                        hargaBarang = 6666666;
                        namaBarang = laptopLenovo;
                        break;

                }
                double totalHarga = hargaBarang * jumlah;
                double member = 0;
                if (rbDiamond.isChecked()) {
                    member = 0.10 * totalHarga;
                } else if (rbGold.isChecked()) {
                    member = 0.05 * totalHarga;
                } else if (rbBiasa.isChecked()) {
                    member = 0.02 * totalHarga;
                }


                double diskonHarga = 0;
                if (totalHarga > 10000000) {
                    diskonHarga = 100000;
                    totalHarga -= diskonHarga;
                }
                double totalDiskon = member ;
                double totalHargaSetelahDiskon = totalHarga - totalDiskon;

                Intent intent = new Intent(MainActivity.this, Nota.class);
                intent.putExtra("Nama", nama);
                intent.putExtra("Kode Barang", kode);
                intent.putExtra("Nama Barang", namaBarang);
                intent.putExtra("Jumlah Barang", jumlah);
                intent.putExtra("Harga Barang", hargaBarang);
                intent.putExtra("Total Harga", totalHarga);
                intent.putExtra("Diskon Harga", diskonHarga);
                intent.putExtra("Diskon Member", member);
                intent.putExtra("Jumlah Bayar", totalHargaSetelahDiskon);

                startActivity(intent);
            }
        });

    }
}
