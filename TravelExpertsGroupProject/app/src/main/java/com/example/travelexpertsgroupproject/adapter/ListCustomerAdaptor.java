package com.example.travelexpertsgroupproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.travelexpertsgroupproject.R;
import com.example.travelexpertsgroupproject.model.Customer;

public class ListCustomerAdaptor extends BaseAdapter {
    private Context mContext;
    private Customer mCustomer;

    public ListCustomerAdaptor(Context mContext, Customer mCustomerList) {
        this.mContext = mContext;
        this.mCustomer = mCustomerList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mCustomer.getCustomerId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.activity_customer_info, null);
        TextView tvFistName = v.findViewById(R.id.tvFirstName);
        TextView tvLastName = v.findViewById(R.id.tvLastName);
        tvFistName.setText(mCustomer.getCustFirstName());
        tvLastName.setText(mCustomer.getCustLastName());

        return v;
    }
}
