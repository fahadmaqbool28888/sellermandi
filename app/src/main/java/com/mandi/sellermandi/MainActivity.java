package com.mandi.sellermandi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mandi.sellermandi.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity
{
    String prefrence;
    boolean checked=false;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createattrib();

      /*  if(prefrence.contentEquals("urdu"))
        {
            btn.setText("ترجیح مقرر کریں");
        }
        else
        {
            btn.setText("set prefrence");
        }
*/

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(checked)
                {
                    Intent intent=  new Intent(MainActivity.this,LoginActivity.class);
                    intent.putExtra("prefrence",prefrence);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"برائے کرم اپنی زبان منتخب کریں",Toast.LENGTH_LONG).show();
                }





            }
        });




    }
    void createattrib()
    {
        btn=findViewById(R.id.savepref);
        btn.setText("ترجیح مقرر کریں");
    }

    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId())
        {
            case R.id.radio_english:
                if (checked)
                    // Pirates are the best




                    Toast.makeText(MainActivity.this,"English language is selected",Toast.LENGTH_LONG).show();
              /*  Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("langpref","english");*/
                btn.setText("set prefrence");

                prefrence="english";
                break;
            case R.id.radio_urdu:
                if (checked)
                    // Ninjas rule
                    btn.setText("ترجیح مقرر کریں");
                    Toast.makeText(MainActivity.this,"اردو زبان منتخب کی گئی ہے",Toast.LENGTH_LONG).show();
              /*  Intent intent1=new Intent(MainActivity.this, LoginActivity.class);
                intent1.putExtra("langpref","urdu");*/
                prefrence="urdu";

                break;
        }
    }
}