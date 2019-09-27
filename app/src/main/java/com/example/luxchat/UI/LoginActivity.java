package com.example.luxchat.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.luxchat.R;

public class LoginActivity extends AppCompatActivity {
    Button btnsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnsignin = findViewById(R.id.btnsign);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
