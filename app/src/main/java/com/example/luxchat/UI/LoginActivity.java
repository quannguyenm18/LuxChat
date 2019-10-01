package com.example.luxchat.UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.luxchat.R;

public class LoginActivity extends AppCompatActivity {
    Button btnsignin;
    View view;

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnsignin = findViewById(R.id.btnsign);
        actionBar = getSupportActionBar();
        view=this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.whiled);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#becff1")));
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
