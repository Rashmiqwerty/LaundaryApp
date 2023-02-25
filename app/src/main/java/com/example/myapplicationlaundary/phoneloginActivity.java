package com.example.myapplicationlaundary;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class phoneloginActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    FirebaseAuth mAuth;
    String phoneno;
    String  mVerificationId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonelogin);

        editText=findViewById(R.id.phoneno);
        button=findViewById(R.id.get_otp);
        mAuth=FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText.getText().toString())){
                    Toast.makeText(phoneloginActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                }
                else if(editText.getText().toString().trim().length()!=10){
                    Toast.makeText(phoneloginActivity.this, "Enter Correct No", Toast.LENGTH_SHORT).show();
                }
                else{
                    genrateotp();
                }
            }
        });
    }



    private void genrateotp() {

//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber(phoneno)       // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)                 // Activity (for callback binding)
//                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);




        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+editText.getText().toString())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                // mVerificationId=s;
                                Intent intent=new Intent(getApplicationContext(), VerifyOTP.class);
                                intent.putExtra("phoneno",s);
                                startActivity(intent);
                                Toast.makeText(phoneloginActivity.this, "otp send", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                Log.d(TAG, "onVerificationCompleted:" + editText);

                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }


                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }).build();
        PhoneAuthProvider.verifyPhoneNumber(options);

}

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            sendmain();
                            // FirebaseUser user = task.getResult().getUser();
                        } else {
                            Toast.makeText(getApplicationContext(), "Verification Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null){
            sendmain();
        }
    }
    private void sendmain() {
        startActivity(new Intent(getApplicationContext(),VerifyOTP.class));
        finish();
    }
}