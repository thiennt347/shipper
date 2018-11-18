package com.sellproducts.thiennt.shipper.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sellproducts.thiennt.shipper.R;

import info.hoang8f.widget.FButton;

public class OrderViewHolder extends RecyclerView.ViewHolder {

    public TextView txtOrderId, txtOrderStatus, txtOrderPhone, txtOrderAddres, order_date;
    public FButton btnShipping;


    public OrderViewHolder(View itemView) {
        super(itemView);

        txtOrderAddres = itemView.findViewById(R.id.order_addres);
        txtOrderId = itemView.findViewById(R.id.order_id);
        txtOrderStatus = itemView.findViewById(R.id.order_status);
        txtOrderPhone = itemView.findViewById(R.id.order_phone);
        order_date = itemView.findViewById(R.id.order_date);

        btnShipping = (FButton) itemView.findViewById(R.id.btnShipping);

    }
}