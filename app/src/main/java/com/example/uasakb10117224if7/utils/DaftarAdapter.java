package com.example.uasakb10117224if7.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.uasakb10117224if7.R;
import com.example.uasakb10117224if7.model.DaftarModel;

import java.util.ArrayList;

//    Tanggal Pengerjaan : 09-08-2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

public class DaftarAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<DaftarModel> recordList;

    public DaftarAdapter(Context context, int layout, ArrayList<DaftarModel> recordList){
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView tvNama;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.tvNama = row.findViewById(R.id.tv_nama);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
        DaftarModel daftarModel = recordList.get(position);
        holder.tvNama.setText(daftarModel.getNama());
        return row;
    }
}
