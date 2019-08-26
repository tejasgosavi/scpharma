package com.thg.retailapp.domain.newlapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class cartAdapter extends RecyclerView.Adapter{

    private List<CartItemModel> cartItemModelList;

    public cartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()){
            case 0:
                    return CartItemModel.CART_ITEM;
            case 1:
                    return CartItemModel.TOTAL_AMOUNT;
            default:
                    return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case CartItemModel.CART_ITEM:
                    View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                    return new CartItemViewholder(cartItemView);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                return new CartTotalAmountViewholder(cartTotalView);

            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (cartItemModelList.get(position).getType()){
            case CartItemModel.CART_ITEM:
                int resource = cartItemModelList.get(position).getProductImage();
                String title = cartItemModelList.get(position).getProductTitle();
                String productPrice = cartItemModelList.get(position).getProductPrice();
                String cuttedPrice = cartItemModelList.get(position).getProductPrice();
                ((CartItemViewholder)viewHolder).setItemDetails(resource,title,productPrice,cuttedPrice);
                break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalItems = cartItemModelList.get(position).getTotalItems();
                String totalItemPrice = cartItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice = cartItemModelList.get(position).getDeliveryPrice();
                String totalAmount = cartItemModelList.get(position).getTotalAmount();
                String savedAmount = cartItemModelList.get(position).getSavedAmount();
                ((CartTotalAmountViewholder)viewHolder).setTotalAmount(totalItems,totalItemPrice,totalAmount,deliveryPrice,savedAmount);
                break;
             default:
                 return;
        }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }
    class CartItemViewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView productQuantity;
        private TextView productMargin;
        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            productMargin = itemView.findViewById(R.id.product_margin);
        }
        private void setItemDetails(int resource,String title,String ProductPriceText,String cuttedPriceText){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            productPrice.setText(ProductPriceText);
            cuttedPrice.setText(cuttedPriceText);
        }
    }
    class CartTotalAmountViewholder extends RecyclerView.ViewHolder{

        private TextView totalItems;
        private TextView totalItemPrice;
        private TextView totalAmount;
        private TextView deliveryPrice;
        private TextView savedAmount;

        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);
            totalItems = itemView.findViewById(R.id.total_items);
            totalItemPrice = itemView.findViewById(R.id.total_items_price);
            totalAmount = itemView.findViewById(R.id.total_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            savedAmount = itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalAmount(String totalItemsText,String totalItemPriceText,String totalAmountText,String deliveryPriceText,String savedAmountText){
            totalItems.setText(totalItemsText);
            totalItemPrice.setText(totalItemPriceText);
            totalAmount.setText(totalAmountText);
            deliveryPrice.setText(deliveryPriceText);
            savedAmount.setText(savedAmountText);
        }
    }
}
