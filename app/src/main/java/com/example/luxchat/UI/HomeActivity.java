package com.example.luxchat.UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.luxchat.Adapter.TabLayoutAdaprer;
import com.example.luxchat.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    ActionBar actionBar;
    FirebaseAuth auth;
    private int[] tabIcons = {
            R.drawable.icons8_facebook_messenger_48,
            R.drawable.icons8_user_group_48,
            R.drawable.icons8_about_48
    };
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        auth = FirebaseAuth.getInstance();
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#becff1")));
    }

    private void initView() {
        viewPager =findViewById(R.id.vp);
        viewPager.setAdapter(new TabLayoutAdaprer(getSupportFragmentManager()));
       TabLayout tabLayout = (TabLayout) findViewById(R.id.tl);
       tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }


     private void hometosigin(){

         Intent it = new Intent(HomeActivity.this,LoginActivity.class);
         startActivity(it);
     }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if( item.getItemId() == R.id.main_logout_option){
            auth.signOut();
            hometosigin();

        }if(item.getItemId() == R.id.main_user_option){
            Intent it = new Intent(HomeActivity.this,UserActivity.class);
            startActivity(it);


        }

        return true;
    }


}

