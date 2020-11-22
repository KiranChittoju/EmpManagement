package com.example.employer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.employer.Model.EmployeesDetails;
import com.example.employer.Model.Payroll;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import adpaters.payStubAdpater;

public class PaystubsActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Payroll> PayRoll;
    FirebaseFirestore db;
    String user_id="EMP001";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paystubs);
        listView=findViewById(R.id.PayListView);
        db=FirebaseFirestore.getInstance();
        getData(user_id);
        if(PayRoll.size()==0)
            PayRoll.add(new Payroll("2020-11-20","500","EMP001"));
        payStubAdpater adpater=new payStubAdpater(PayRoll);
        listView.setAdapter(adpater);
    }

    public void getData(final String User_id){
        final ArrayList<Payroll> pay_list= new ArrayList<Payroll>();
        db.collection("/employeesPay")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            Payroll _pay;

                            for(DocumentSnapshot document:task.getResult()){
                                Payroll emp_pay=document.toObject(Payroll.class);
                                if(User_id.equals(emp_pay.getUser_id())){
                                    pay_list.add(new Payroll(emp_pay.getPay_date(),emp_pay.getPay_amount(),emp_pay.getUser_id()));
                                }
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        PayRoll =pay_list;
    }
}