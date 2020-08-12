package com.example.uasakb10117224if7.ui.daftar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.uasakb10117224if7.R;
import com.example.uasakb10117224if7.model.db.DbOpenHelper;
import com.google.android.material.button.MaterialButton;


//    Tanggal Pengerjaan : 11-08-2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

public class DaftarDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_daftar_detail);

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            final EditText nama   = findViewById(R.id.nama_wisata);
            EditText alamat  = findViewById(R.id.alamat_wisata);
            EditText website   = findViewById(R.id.website_wisata);
            ImageButton btn_lokasi = findViewById(R.id.lokasi_wisata);
            ImageView gambar_lokasi = findViewById(R.id.img_foto);

            final String nama_wisata = bundle.getString("nama");

            Log.d("TAG", "------->>> "+nama_wisata);
            if(nama_wisata.equals("Alun-Alun Kota Bandung")){
                gambar_lokasi.setImageResource(R.drawable.alun_alun_kota_bandung);
            }else if (nama_wisata.equals("Forest Walk Babakan Siliwangi")){
                gambar_lokasi.setImageResource(R.drawable.forest_walk_babakan_siliwangi);
            }else if (nama_wisata.equals("Taman Sejarah Bandung")){
                gambar_lokasi.setImageResource(R.drawable.taman_sejarah_bandung);
            }else if (nama_wisata.equals("Dago Dreampark")){
                gambar_lokasi.setImageResource(R.drawable.dago_dreampark);
            }else if (nama_wisata.equals("Bandung City Hall Park")){
                gambar_lokasi.setImageResource(R.drawable.bandung_city_hall_park);
            }else if (nama_wisata.equals("Bandung Zoological Garden")){
                gambar_lokasi.setImageResource(R.drawable.bandung_zoological_garden);
            }else if (nama_wisata.equals("Rabbit Town")){
                gambar_lokasi.setImageResource(R.drawable.rabbit_town);
            }else if (nama_wisata.equals("Taman Hutan Raya Ir. H. Djuanda")){
                gambar_lokasi.setImageResource(R.drawable.taman_hutan_raya_ir_h_djuanda);
            }else if (nama_wisata.equals("Trans Studio Bandung")){
                gambar_lokasi.setImageResource(R.drawable.trans_studio_bandung);
            }else if (nama_wisata.equals("Vanda Park")){
                gambar_lokasi.setImageResource(R.drawable.vanda_park);
            }

            nama.setText(nama_wisata);
            alamat.setText(bundle.getString("alamat"));
            website.setText(bundle.getString("website"));

            ///Ketika button lokasi di klik
            btn_lokasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ii = new Intent(DaftarDetailActivity.this, MapsActivity.class);
                    ii.putExtra("nama_wisata", nama_wisata);
                    startActivity(ii);
                }
            });
        }
    }
}
