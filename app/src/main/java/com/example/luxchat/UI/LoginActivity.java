package com.example.luxchat.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.luxchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button btnsignin;
    ActionBar actionBar;
    private TextInputEditText edtemail;
    private TextInputEditText edtpass;
    FirebaseAuth auth;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnsignin = findViewById(R.id.btnsign);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#becff1")));
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        edtemail = (TextInputEditText) findViewById(R.id.edtemail);
        edtpass = (TextInputEditText) findViewById(R.id.edtpass);
        auth = FirebaseAuth.getInstance();

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email= edtemail.getText().toString();
                String txt_password= edtpass.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(LoginActivity.this,"Vui Lòng Nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();

                }else {
                    auth.signInWithEmailAndPassword(txt_email,txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();

                            }else {

                                Toast.makeText(LoginActivity.this,"Bạn đã Nhập sai thông tin tài khoản",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }
            }
        });

    }



    public void SigUp(View view) {
        Intent it= new Intent(LoginActivity.this,SigUpActivity.class);
        startActivity(it);

    }

    public void ResetPass(View view) {
        Intent it= new Intent(LoginActivity.this,ResetPassActivity.class);
        startActivity(it);

    }
}
