package com.example.uasakb10117224if7.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.uasakb10117224if7.ui.infoApp.InfoAppFragment;
import com.example.uasakb10117224if7.ui.profil.ProfilFragment;

//    Tanggal Pengerjaan : 09-08-2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

public class MainActivityAdapter extends FragmentStatePagerAdapter {

    private int jumlahTab = 2;

    public MainActivityAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProfilFragment profilFragment = new ProfilFragment();
                return profilFragment;
            case 1:
                InfoAppFragment infoAppFragment = new InfoAppFragment();
                return infoAppFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return jumlahTab;
    }
}
