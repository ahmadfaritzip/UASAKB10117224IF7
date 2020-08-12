package com.example.uasakb10117224if7.ui.daftar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.uasakb10117224if7.R;
import com.example.uasakb10117224if7.model.DaftarModel;
import com.example.uasakb10117224if7.model.db.DbOpenHelper;
import com.example.uasakb10117224if7.utils.DaftarAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

//    Tanggal Pengerjaan : 12-08-2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

public class DaftarFragment extends Fragment {
    DbOpenHelper myDb;

    ListView mListView;
    DaftarAdapter daftarAdapter = null;
    ArrayList<DaftarModel> mList;
    String wisata_gambar;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_daftar, container, false);
        mListView = root.findViewById(R.id.listView);

        mList = new ArrayList<>();
        daftarAdapter = new DaftarAdapter(getActivity(), R.layout.card_item_daftar, mList);
        mListView.setAdapter(daftarAdapter);

        myDb = new DbOpenHelper(getActivity());
        updateRecordList();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = myDb.getAllData();
                ArrayList<Integer> arrNim = new ArrayList<Integer>();
                while (cursor.moveToNext()){ arrNim.add(cursor.getInt(0)); }
                Log.d("====>", "onClick: "+position);
                showDialogUpdate(getActivity(), arrNim.get(position).toString());
            }
        });
        return root;
    }

    public String LoadJsonFromAssets(){
        String json = null;
        try {
            InputStream in = this.getActivity().getAssets().open("wisata.json");
            int size = in.available();
            byte[] bbufer = new byte[size];
            in.read(bbufer);
            in.close();
            json = new String(bbufer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }


    private void showDialogUpdate(Activity activity, final String valId){
        String idWisata = "";
        String namaWisata = "";
        String websiteWisata = "";
        String alamatWisata = "";

        Cursor data = myDb.getData(valId);
        while (data.moveToNext()) {
            idWisata = data.getString(0);
            namaWisata = data.getString(1);
            websiteWisata = data.getString(2);
            alamatWisata = data.getString(3);
        }

        Intent intent = new Intent(activity, DaftarDetailActivity.class);
        intent.putExtra("id", idWisata);
        intent.putExtra("nama", namaWisata);
        intent.putExtra("website", websiteWisata);
        intent.putExtra("alamat", alamatWisata);
        intent.putExtra("gambar", wisata_gambar);
        startActivity(intent);

    }

    public void updateRecordList(){
        try {
            String valNama = "";
            JSONObject obj = new JSONObject(LoadJsonFromAssets());
            JSONArray jarray = obj.getJSONArray("wisata");
            mList.clear();
            ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
            for(int i = 0; i < jarray.length(); i++){
                JSONObject o = jarray.getJSONObject(i);
                String wisata_id = o.getString("id");
                String wisata_nama = o.getString("nama");
                String wisata_website = o.getString("website");
                String wisata_alamat = o.getString("alamat");
                wisata_gambar = o.getString("gambar_url");
                Cursor data = myDb.getData(wisata_id);
                while (data.moveToNext()) { valNama = data.getString(1); }
                if (wisata_nama != valNama) {
                    myDb.insertData(wisata_nama, wisata_website, wisata_alamat);
                }
                mList.add(new DaftarModel(wisata_nama, wisata_website, wisata_alamat));
            }
            Log.d("TAG", "onCreateView: "+arrayList);
            daftarAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
