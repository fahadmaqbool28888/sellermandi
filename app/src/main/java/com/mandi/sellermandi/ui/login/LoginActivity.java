package com.mandi.sellermandi.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mandi.sellermandi.Function;
import com.mandi.sellermandi.MainActivity;
import com.mandi.sellermandi.R;
import com.mandi.sellermandi.ui.login.LoginViewModel;
import com.mandi.sellermandi.ui.login.LoginViewModelFactory;

public class LoginActivity extends AppCompatActivity
{
    EditText usernameEditText,passwordEditText;
    Button lgnbtn;
    String uname,upass="admin";

    String username,userpassword;
    String langflag;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createattrib();
      //  String langflag;
        usernameEditText = findViewById(R.id.username);
        passwordEditText=findViewById(R.id.password);
       lgnbtn.setEnabled(true);
        Bundle bundle = getIntent().getExtras();
       langflag = bundle.getString("prefrence");



        if(langflag.contentEquals("english"))
        {
            //set english prefrence
            usernameEditText.setText("Enter  email address /phone number");
            passwordEditText.setText("Enter Password");
            lgnbtn.setText("Sign In");
            lgnbtn.setTextColor(Color.WHITE);
        }
        else
        {
            //پاس ورڈ درج کریں
            usernameEditText.setText("ای میل ایڈریس / فون نمبر درج کریں");
            passwordEditText.setText("پاس ورڈ درج کریں");
            lgnbtn.setText("آگے بڑھو");
            lgnbtn.setTextColor(Color.WHITE);
            //set urdu prefrence
        }

        getuserdetail();



        lgnbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clickfuntion();
            }
        });







    }
    void createattrib()
    {
       lgnbtn=findViewById(R.id.login);
    }

    void getuserdetail()
    {
        username=usernameEditText.getText().toString();
        userpassword=usernameEditText.getText().toString();
    }

    void clickfuntion()
    {

        getuserdetail();
        if(username==null && userpassword==null)
        {
            Toast.makeText(LoginActivity.this,"Please Enter Login Detail",Toast.LENGTH_LONG).show();
        }
        else
        {
            if(usernameEditText.getText().equals("admin") && passwordEditText.getText().equals("admin"))
            {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
            else if(username.contentEquals("admin")&&userpassword.contentEquals("admin"))
            {
                startActivity(new Intent(LoginActivity.this, Function.class));
            }
            else
            {
                Toast.makeText(LoginActivity.this,"Invalidate User Name and password",Toast.LENGTH_LONG).show();
            }


        }
    }


}