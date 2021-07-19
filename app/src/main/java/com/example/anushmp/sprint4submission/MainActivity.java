package com.example.anushmp.sprint4submission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private Button login;
    private EditText etusername;
    private EditText etpassword;
    private CheckBox check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.btnlogin);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        title = findViewById(R.id.titlecard);

        check = findViewById(R.id.check);


        SharedPreferences s2 = MainActivity.this.getPreferences(Context.MODE_PRIVATE);

        if(s2.contains("user") && s2.contains("pass")){

            String userHold = s2.getString("user","none");
            String passHold = s2.getString("pass","none");

            etusername.setHint(userHold);
            etpassword.setHint(passHold);


        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = etusername.getText().toString();
                String p = etpassword.getText().toString();

                if(u.contains("@") && u.contains(".") && p.length() > 6){


                    Intent i = new Intent(MainActivity.this, HomeScreenActivity.class);

                    startActivity(i);



                }else{

                    title.setText("invalid email or password. Please try again");}




                if(check.isChecked()){


                    String user = etusername.getText().toString();
                    String pass = etusername.getText().toString();

                    SharedPreferences s = MainActivity.this.getSharedPreferences("default", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = s.edit();

                    editor.putString("user", user);
                    editor.apply();
                    editor.putString("pass", pass);
                    editor.apply();




                }






            }
        });



    }
}