package com.example.employer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employer.Model.EmployeesBank;
import com.example.employer.Model.EmployeesDetails;
import com.example.employer.Model.Payroll;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class TestActivity extends AppCompatActivity {

    TextView retrieve_data;
    Button retrieve_btn;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        retrieve_data=findViewById(R.id.dataView);
        retrieve_btn=findViewById(R.id.RetriveBtn);
        db=FirebaseFirestore.getInstance();

        retrieve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployeeDetails("EMP001","BC10001","Emp@8080","EMP","EMP","514-000-9999","Montreal");
                addEmployeePay("EMP001","2020-11-20","500");
                addEmployeePay("EMP001","2020-10-20","400");
                addEmployeePay("EMP001","2020-09-20","600");
                addEmployeePay("EMP001","2020-08-20","900");
                addEmployeePay("EMP001","2020-07-20","1000");
                addEmployeeBanks("EMP001","640","15.00");
            }
        });
    }
    // test Data
    public void addEmployeeDetails(String UserName,String BusinessCode,String Password,String FirstName,String LastName,String Phone,String Address){

        EmployeesDetails employee=new EmployeesDetails(UserName,BusinessCode,Password,FirstName,LastName,Phone,Address);
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

    public void addEmployeePay(String UserName,String Date,String net_pay){

        Payroll employeePayRoll=new Payroll(Date,net_pay,UserName);
        db.collection("employeesPay")
                .add(employeePayRoll)
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

    public void addEmployeeBanks(String UserName,String Vacation,String SickHrs){

        EmployeesBank employeeBank=new EmployeesBank(Vacation,SickHrs,UserName);
        db.collection("employeeBanks")
                .add(employeeBank)
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

    public void getData(){

        db.collection("employeesData")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String result="";
                            for(DocumentSnapshot document:task.getResult()){
                                EmployeesDetails emp=document.toObject(EmployeesDetails.class);
                                result+=
                                        "UserName :"+emp.getUserName()+
                                                "\n BusinessCode :"+emp.getBusinessCode()+"\n";
                            }
                            retrieve_data.setText(result);
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