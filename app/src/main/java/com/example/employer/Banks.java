package com.example.employer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employer.Model.EmployeesBank;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Banks extends AppCompatActivity  {

    TextView VacationPay;
    TextView SickHrs;
    FirebaseFirestore db;
    String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks);
        user_id="EMP001";
        VacationPay=findViewById(R.id.vacationPay);
        SickHrs=findViewById(R.id.sickHrs);

        db=FirebaseFirestore.getInstance();
        getdata(user_id);
    }

    public void getdata(String User_id){

        db.collection("employeeBanks")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String vacation="";
                            String sickness="";
                            for(DocumentSnapshot document:task.getResult()){
                                EmployeesBank emp_bank=document.toObject(EmployeesBank.class);
                                if(user_id.equals(emp_bank.getUser_id())){
                                    vacation=emp_bank.getVacation();
                                    sickness=emp_bank.getSickness_hrs(); }
                            }
                            VacationPay.setText(vacation+".00");
                            SickHrs.setText(sickness);
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
}