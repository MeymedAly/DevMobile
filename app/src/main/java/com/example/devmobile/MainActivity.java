package com.example.devmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements MonInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LoginFragment loginFragment = new LoginFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.fragmentContainerView,loginFragment).commit();
//        ft.addToBackStack(null);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,loginFragment).commit();


        WelcomeFragment welcomeFragment = new WelcomeFragment();
        FragmentManager frm = getSupportFragmentManager();
        FragmentTransaction frt = frm.beginTransaction();
        frt.replace(R.id.fragmentContainerView2,welcomeFragment,"Tag_Welcome").commit();
        frt.addToBackStack(null);
        //getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView2,welcomeFragment,"Tag_Welcome").commit();

    }

    @Override
    public void setResultat(String s,String w) {

        Fragment fragment = getSupportFragmentManager().findFragmentByTag("Tag_Welcome");
        WelcomeFragment welcomeFragment = (WelcomeFragment) fragment;
        welcomeFragment.setResultat(s,w);
    }
}