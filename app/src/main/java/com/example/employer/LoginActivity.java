package com.example.employer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employer.Model.EmployeesDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText _UserName;
    EditText _BusinessCode;
    EditText _Password;
    Button _submit;
    TextView Invalid_text;
    FirebaseAuth fauth;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _UserName=findViewById(R.id.UserName);
        _BusinessCode=findViewById(R.id.BusinessCode);
        _Password=findViewById(R.id.Password);
        _submit=findViewById(R.id.Login);
        Invalid_text=findViewById(R.id.dataView);

        db=FirebaseFirestore.getInstance();
        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username=_UserName.getText().toString();
                String BusinessCode=_BusinessCode.getText().toString();
                String password=_Password.getText().toString();
                checkData(Username,BusinessCode,password);
                /*if(Invalid_text.getText().toString().equals("1"))
                    _submit.setOnClickListener(this);
                else
                    _submit.setOnClickListener(null);*/
            }
        });
       if(Invalid_text.getText().toString().equals("1"))
           _submit.setOnClickListener(this);

    }


 // to add data to database
    public void addData(String UserName,String BusinessCode,String Password){

        EmployeesDetails employee=new EmployeesDetails(UserName,BusinessCode,Password,"","","","");
        db.collection("employeesData")
                .add(employee)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Failed"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


    }

    //to retrive data from database...

    public void checkData(final String UserName, final String BusinessCode, final String Password){

        db.collection("employeesData")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String result="";
                            for(DocumentSnapshot document:task.getResult()){
                                EmployeesDetails emp=document.toObject(EmployeesDetails.class);
                                if(UserName.equals(emp.getUserName()) && BusinessCode.equals(emp.getBusinessCode()) && Password.equals(emp.getPassword())){
                                    Invalid_text.setVisibility(View.INVISIBLE);
                                    result="1";
                                    break;
                                }
                                else{
                                    Invalid_text.setVisibility(View.VISIBLE);
                                    result= "Invalid Details";
                                }
                            }
                            Invalid_text.setText(result);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this.getApplicationContext(), HomeActivity.class);
        this.startActivity(intent);
    }
}