package com.jaroid.android51_day7.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaroid.android51_day7.models.ProductModel;
import com.jaroid.android51_day7.R;
import com.jaroid.android51_day7.intefaces.IItemClickListener;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<ProductModel> mListData;
    private Context mContext;
    private IItemClickListener callback;

    public ProductAdapter(ArrayList<ProductModel> listData) {
        this.mListData = listData;
    }

    public void setCallback(IItemClickListener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_product, parent, false);
        mContext = parent.getContext();
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel model = mListData.get(position);

        holder.tvProductName.setText(model.getId() + "");

        //Nếu item đang được select thì đổi nền thành đen chữ trắng
        // Không thì nền trắng chữ đen
        if (model.isSelected()) {
            holder.tvProductName.setTextColor(Color.WHITE);
            holder.llItem.setBackground(mContext.getResources().getDrawable(R.drawable.bg_item_product_selected, null));
        } else {
            holder.tvProductName.setTextColor(Color.BLACK);
            holder.llItem.setBackground(mContext.getResources().getDrawable(R.drawable.bg_item_product, null));
        }
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout llItem;
        TextView tvProductName;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            llItem = itemView.findViewById(R.id.llItem);
            tvProductName = itemView.findViewById(R.id.tvProductName);

            llItem.setOnClickListener(this);
            tvProductName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.llItem || v.getId() == R.id.tvProductName) {
                if (callback != null) {
                    int position = getAdapterPosition();
                    callback.onItemClick(position, mListData.get(position));
                }
            }
        }
    }
}
