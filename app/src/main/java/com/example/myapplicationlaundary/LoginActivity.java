package com.example.myapplicationlaundary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    TextView createNewAccount;
    EditText inputEmail, inputpassword;
    ImageView btnGoogle, btnFacebook,btnPhone;
    CallbackManager mcallbackManager;
    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    ProgressDialog progressDialog;
    Button btnLogin;

    FirebaseAuth mAuth;
    FirebaseUser muser;
    GoogleSignInClient signInClient;
    private static final String TAG = "Googlelogin";
    private static final int RC_SIGN_IN = 234;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createNewAccount = findViewById(R.id.createnewAccount);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        inputEmail = findViewById(R.id.inputemail);
        inputpassword = findViewById(R.id.inputpassword);
        btnGoogle = findViewById(R.id.btngoogle);
        btnLogin=findViewById(R.id.btnLogin);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnPhone=findViewById(R.id.btnphone);
        mAuth=FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =inputEmail.getText().toString().trim();
                String password =inputpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    inputpassword.setError("Password must be required");
                    return;
                }
                if (password.length() < 6) {
                    inputpassword.setError("Password length must be >= 6");
                    return;
                }


                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login sucessfully" +
                                    "", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, Dashboard.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error!.." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        mcallbackManager = CallbackManager.Factory.create();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        signInClient = GoogleSignIn.getClient(LoginActivity.this, gso);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
       btnFacebook.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this,Arrays.asList("email","public_profile"));
               LoginManager.getInstance().registerCallback(mcallbackManager, new FacebookCallback<LoginResult>() {
                   @Override
                   public void onSuccess(LoginResult loginResult) {
                       Log.d("djvbdfjbv", "facebook:onSuccess:" + loginResult);
                       handleFacebookAccessToken(loginResult.getAccessToken());
                   }

                   @Override
                   public void onCancel() {
                       Log.d("djvbdfjbv", "facebook:onCancel");

                   }

                   @Override
                   public void onError(@NonNull FacebookException e) {
                       Log.d("djvbdfjbv", "facebook:onError",e);

                   }
               });
           }
       });
       btnPhone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              startActivity( new Intent(LoginActivity.this,phoneloginActivity.class));
              finish();
           }
       });


        }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("smdbcdbsc", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("smdbcdbsc", "signInWithCredential:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this, Dashboard.class));
                            finish();
                            Toast.makeText(LoginActivity.this, "Sigin with facebook is sucessfull", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("smdbcdbsc", "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Sigin with facebook is Faield", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = signInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (mAuth.getCurrentUser() != null) {
//            startActivity(new Intent(this, Dashboard.class));
//            finish();
//        }
//    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mcallbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthGoogleAccount(account);
            } catch (ApiException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void updateui() {
        Intent intent=new Intent(LoginActivity.this,Dashboard.class);
        startActivity(intent);
        finish();
    }
    private void firebaseAuthGoogleAccount(GoogleSignInAccount account) {
        Log.d(TAG,"firebaseAuthGoogleAccount"+account.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(getApplicationContext(), "sign in sucessfully", Toast.LENGTH_SHORT).show();
//                            FirebaseUser user = mAuth.getCurrentUser();
                            updateui();

                        } else {
                            Toast.makeText(getApplicationContext(), "sign in faield", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, Dashboard.class));
            finish();
        }
    }

}

