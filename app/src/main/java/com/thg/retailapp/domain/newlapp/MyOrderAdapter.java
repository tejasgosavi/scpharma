package com.thg.retailapp.domain.newlapp;

import android.content.res.ColorStateList;
import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {
    private List<MyOrderItemModel> myOrderItemModelList;

    public MyOrderAdapter(List<MyOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_order_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder viewHolder, int position) {
        int resource =myOrderItemModelList.get(position).getProductImage();
        String title = myOrderItemModelList.get(position).getProductTitle();
        String deliveredDate = myOrderItemModelList.get(position).getDeliveryStatus();
        viewHolder.setData(resource,title,deliveredDate);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private ImageView orderIndicator;
        private TextView productTitle;
        private TextView deliverrystatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            orderIndicator = itemView.findViewById(R.id.ORder_indicator);
            deliverrystatus = itemView.findViewById(R.id.order_delivery_date);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void setData(int resouce, String title, String deliveredDate){
            productImage.setImageResource(resouce);
            productTitle.setText(title);
            if (deliveredDate.equals("Cancelled")){
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimary)));
            }else {
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimaryDark)));
            }
            deliverrystatus.setText(deliveredDate);
        }
    }
}
