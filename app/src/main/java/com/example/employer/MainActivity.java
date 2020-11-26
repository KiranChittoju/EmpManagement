package com.example.employer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        Button submitBtn;
        Button RetriveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn=findViewById(R.id.submit);
        RetriveBtn=findViewById(R.id.retrive);

        submitBtn.setOnClickListener(this);
        RetriveBtn.setOnClickListener(this);

       // RetriveBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit:
                Intent intent=new Intent(this.getApplicationContext(), LoginActivity.class);
                this.startActivity(intent);
                break;
            case R.id.retrive:
                intent=new Intent(this.getApplicationContext(),TestActivity.class);
                this.startActivity(intent);
                break;

        }
    }
}