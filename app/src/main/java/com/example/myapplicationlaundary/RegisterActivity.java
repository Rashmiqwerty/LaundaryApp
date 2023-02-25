package com.example.myapplicationlaundary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

EditText inputEmail,inputPassword,inputConformPassword;
Button btnRegister;
String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

ProgressDialog progressDialog;
TextView AlreadyhaveAccount;

FirebaseAuth mAuth;
FirebaseUser muser;
    DatabaseReference reference;

    FirebaseDatabase rootnode;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inputEmail=findViewById(R.id.inputemail);
        inputPassword=findViewById(R.id.inputpassword);
        btnRegister=findViewById(R.id.btnLogin);
        AlreadyhaveAccount=findViewById(R.id.Alreadyhaveanaccount);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        muser=mAuth.getCurrentUser();
        FirebaseAuth mAuth;
        mAuth=FirebaseAuth.getInstance();



        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode =FirebaseDatabase.getInstance();
                reference = FirebaseDatabase.getInstance().getReference().child("users");

                String email =inputEmail.getText().toString().trim();
                String password =inputPassword.getText().toString().trim();


                Profile model = new Profile(email,password);
                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError("Password must be required");
                    return;
                }
                if (password.length() < 6) {
                    inputPassword.setError("Password length must be >= 6");
                    return;
                }



//                HashMap<String, Object> map = new HashMap<>();
//                map.put("name",name);
//                map.put("email",email);
//                map.put("password",password);
//                map.put("phone",phone);


                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String key = reference.push().getKey();
                            reference.child(key).setValue(model);
                            Toast.makeText(RegisterActivity.this, "User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error!.." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
AlreadyhaveAccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }
});

        }



}