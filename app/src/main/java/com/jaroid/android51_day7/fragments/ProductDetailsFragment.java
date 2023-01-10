package com.jaroid.android51_day7.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jaroid.android51_day7.models.ProductModel;
import com.jaroid.android51_day7.R;

public class ProductDetailsFragment extends Fragment {

    ProductModel productModel;

    ImageView imgProductImage;
    TextView tvProductName, tvProductDetails, tvProductPrice;
    LinearLayout llCart;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProductDetailsFragment newInstance(ProductModel productModel) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("PRODUCT_MODEL", productModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            productModel = (ProductModel) getArguments().getSerializable("PRODUCT_MODEL");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

    }

    private void initView(View view) {
        imgProductImage = view.findViewById(R.id.imgProductImage);
        tvProductName = view.findViewById(R.id.tvProductName);
        tvProductPrice = view.findViewById(R.id.tvProductPrice);
        tvProductDetails = view.findViewById(R.id.tvProductDetails);
        llCart = view.findViewById(R.id.llCart);

        if (productModel != null) {
            imgProductImage.setImageDrawable(getActivity().getResources().getDrawable(productModel.getProductImage()));
            tvProductName.setText(productModel.getProductName());
            tvProductDetails.setText(productModel.getProductDetails());
            tvProductPrice.setText(productModel.getProductPrice() + " $");
        } else {
            Toast.makeText(getContext(), "Không có thông tin sản phẩm !", Toast.LENGTH_SHORT).show();
        }
    }
}