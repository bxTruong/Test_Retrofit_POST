package com.example.test_retrofit_post.adapter.spinner;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.test_retrofit_post.R;
import com.example.test_retrofit_post.model.Address;

import java.util.List;

public class AddressAdapter implements SpinnerAdapter {
    private List<Address> addressList;
    private Context context;

    public AddressAdapter(List<Address> addressList, Context context) {
        this.addressList = addressList;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.drop_row, parent, false);
        TextView tvSpinner1 = convertView.findViewById(R.id.tvSpinner1);
        tvSpinner1.setText(addressList.get(position).getStreet()+" "+addressList.get(position).getCity());
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.selectedview_row, parent, false);
        TextView tvSpinner1 = convertView.findViewById(R.id.tvSpinner1);
        tvSpinner1.setText(addressList.get(position).getStreet()+" "+addressList.get(position).getCity());
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    //Chuyển về số hàng spinner hiển thị
    @Override
    public int getCount() {
        return addressList.size();
    }

    @Override
    public Object getItem(int position) {
        return addressList.get(position);
    }


    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
