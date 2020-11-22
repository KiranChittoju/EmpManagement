package com.example.employer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton PayrollBtn,BanksBtn,MsgBtn,InfoBtn,EmrgBtn,DocBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PayrollBtn=findViewById(R.id.PayrollBtn);
        BanksBtn=findViewById(R.id.BanksBtn);
        MsgBtn=findViewById(R.id.MessagesBtn);
        InfoBtn=findViewById(R.id.InfoBtn);
        EmrgBtn=findViewById(R.id.EmergBtn);
        DocBtn=findViewById(R.id.DocumentBtn);

        PayrollBtn.setOnClickListener(this);
        BanksBtn.setOnClickListener(this);
        MsgBtn.setOnClickListener(this);
        InfoBtn.setOnClickListener(this);
        EmrgBtn.setOnClickListener(this);
        DocBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BanksBtn:
                Intent intent=new Intent(this.getApplicationContext(), Banks.class);
                this.startActivity(intent);
                break;
            case R.id.PayrollBtn:
                intent=new Intent(this.getApplicationContext(),PaystubsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.DocumentBtn:
                intent=new Intent(this.getApplicationContext(),PaystubsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.EmergBtn:
                intent=new Intent(this.getApplicationContext(),PaystubsActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}