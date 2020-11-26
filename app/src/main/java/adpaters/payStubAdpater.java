package adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.employer.Model.Payroll;
import com.example.employer.R;

import java.util.ArrayList;

public class payStubAdpater extends BaseAdapter {

    ArrayList<Payroll> payroll;
    public payStubAdpater(ArrayList<Payroll> payroll) {
        this.payroll=payroll;

    }
    @Override
    public int getCount() {
        return payroll.size();
    }

    @Override
    public Payroll getItem(int position) {
        return payroll.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.paystub_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) convertView.getTag();
        }

        Payroll payroll=getItem(position);
        viewHolder.Net_pay.setText("$"+payroll.getPay_amount()+".00");
        viewHolder.Pay_date.setText("Payroll of "+payroll.getPay_date());
        return convertView;

    }

    class ViewHolder{

        TextView Net_pay;
        TextView Pay_date;
        public  ViewHolder(View view)
        {
            Net_pay=view.findViewById(R.id.Pay_amount);
            Pay_date=view.findViewById(R.id.pay_date);

        }
    }
}

