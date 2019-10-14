package com.example.luxchat.UI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luxchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassActivity extends AppCompatActivity {

    private EditText edtEmailReset;
    FirebaseAuth firebaseAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        edtEmailReset = (EditText) findViewById(R.id.edtEmailReset);
        firebaseAuth=FirebaseAuth.getInstance();

    }

    public void resetPass(View view) {
        String email= edtEmailReset.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.equals("")){
            edtEmailReset.setError("Vui Lòng Nhập Email của Bạn");
        }else if(email.matches(emailPattern)){
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(ResetPassActivity.this,"Vui Lòng Kiểm Tra Email Của Bạn",Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(ResetPassActivity.this,LoginActivity.class);
                        startActivity(it);



                    }else {
                        String error= task.getException().getMessage();
                        Toast.makeText(ResetPassActivity.this,error,Toast.LENGTH_SHORT).show();


                    }
                }
            });


        }else{
            edtEmailReset.setError("Email sai định dạng");}


    }
}
