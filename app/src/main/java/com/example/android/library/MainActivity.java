package com.example.android.library;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.library.ui.chat.ChatFragment;
import com.example.android.library.ui.chat.SendFragment;
import com.example.android.library.ui.news.NewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsFragment youFragment = new NewsFragment();
        final android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()          // получаем экземпляр FragmentTransaction
                .replace(R.id.content, youFragment)
                .addToBackStack("myStack")
                .commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                switch (item.getItemId()) {
                    case R.id.navigation_home: {
                        Log.e("menu", "home");
                        NewsFragment youFragment = new NewsFragment();

                        fragmentManager.beginTransaction()          // получаем экземпляр FragmentTransaction
                                .replace(R.id.content, youFragment)
                                .addToBackStack("myStack")
                                .commit();
                        // TODO: 25.10.2017 replase frame on news fragment
                        return true;
                    }
                    case R.id.navigation_chat: {
                        SendFragment sendFragment = new SendFragment();

                        fragmentManager.beginTransaction()
                                .replace(R.id.content, sendFragment)
                                .addToBackStack("myStack")
                                .commit();
                        Log.e("menu", "dashboard");
                        // TODO: 25.10.2017 replase frame on message fragment
                        return true;
                    }
                    case R.id.navigation_search: {
                        Log.e("menu", "notifications");
                        // TODO: 25.10.2017 replase frame on search
                        return true;
                    }
                }
                return false;


            }
        });
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:{
                Log.e("menu", "1");
                // TODO: 25.10.2017 replase frame on setting fragment
                break;
            }
            case R.id.menu_reference:{
                Log.e("menu", "2");
                // TODO: 25.10.2017 replase frame on reference fragment
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
