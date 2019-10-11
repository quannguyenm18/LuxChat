package com.example.luxchat.UI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luxchat.R;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SigUpActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtpass;
    private EditText edtRepass;
    private EditText edtemail;
    private Button btnsingup;

    FirebaseAuth auth;
   DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_up);
        anhxa();

        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_username = edtUser.getText().toString();
                String txt_password= edtpass.getText().toString();
                String  txt_email= edtemail.getText().toString();

                if (TextUtils.isEmpty(txt_username)|| TextUtils.isEmpty(txt_password) ||TextUtils.isEmpty(txt_email) ){
                    Toast.makeText(SigUpActivity.this,"vui lòng nhập đủ",Toast.LENGTH_SHORT).show();



                }else {

                    sigup(txt_username,txt_password,txt_email);
                }

            }
        });

    }
    public void anhxa(){
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtpass = (EditText) findViewById(R.id.edtpass);
        edtRepass = (EditText) findViewById(R.id.edtRepass);
        edtemail = (EditText) findViewById(R.id.edtemail);
        btnsingup = (Button) findViewById(R.id.btnsingup);

       auth = FirebaseAuth.getInstance();

    }

    public void sigup(final String username, String password, String email){

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    FirebaseUser firebaseUser= auth.getCurrentUser();

                    assert firebaseUser != null;
                    String userID =firebaseUser.getUid();


                    databaseReference= FirebaseDatabase.getInstance().getReference("Users").child(userID);

                    HashMap<String ,String> hashMap= new HashMap<>();
                    hashMap.put("id",userID);
                    hashMap.put("Username",username);
                    hashMap.put("imgURL","default");

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Intent intent= new Intent(SigUpActivity.this,LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });

                }else {

                    Toast.makeText(SigUpActivity.this,"Vui Lòng Nhập Lại Thông Tin",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }


}
