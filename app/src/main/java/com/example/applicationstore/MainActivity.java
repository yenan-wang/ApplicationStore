package com.example.applicationstore;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(R.id.tab_fragment, new HomeFragment());
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_game:
                    replaceFragment(R.id.tab_fragment, new GameFragment());
                    //mTextMessage.setText(R.string.title_game);
                    return true;
                case R.id.navigation_soft:
                    replaceFragment(R.id.tab_fragment, new SoftFragment());
                    //mTextMessage.setText(R.string.title_soft);
                    return true;
                case R.id.navigation_rank:
                    replaceFragment(R.id.tab_fragment, new RankFragment());
                    //mTextMessage.setText(R.string.title_rank);
                    return true;
                case R.id.navigation_my:
                    replaceFragment(R.id.tab_fragment, new MyFragment());
                    //mTextMessage.setText(R.string.title_my);
                    return true;

            }
            return false;
        }
    };

    private void replaceFragment(int fragmentName, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(fragmentName, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        replaceFragment(R.id.tab_fragment, new HomeFragment());
    }

}
