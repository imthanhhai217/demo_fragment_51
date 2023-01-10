package com.jaroid.android51_day7.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jaroid.android51_day7.intefaces.IItemClickListener;
import com.jaroid.android51_day7.adapters.ProductAdapter;
import com.jaroid.android51_day7.models.ProductModel;
import com.jaroid.android51_day7.R;

import java.util.ArrayList;

public class ListProductFragment extends Fragment {

    private static final String TAG = "TESTING FRAGMENT";

    private ProductAdapter mProductAdapter;
    private RecyclerView rvListProduct;
    private IItemClickListener clickListener;

    private ArrayList<ProductModel> mListData;

    public ListProductFragment() {
        // Required empty public constructor
    }

    public static ListProductFragment newInstance() {
        ListProductFragment fragment = new ListProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_list_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initDataFake();
        initView(view);
    }

    public void updateSelectedPosition(int newPosition, int oldPosition) {
        //Check xem có bị click cùng vị trí cũ k
        if (newPosition != oldPosition) {
            //Cập nhật giá trị selected = true cho model tại vị trí vừa được click
            ProductModel newModel = mListData.get(newPosition);
            newModel.setSelected(true);
            mListData.set(newPosition, newModel);
            mProductAdapter.notifyItemChanged(newPosition);

            if (oldPosition != -1) {
                //Cập nhật giá trị selected = false cho model tại vị trí click cũ
                ProductModel oldModel = mListData.get(oldPosition);
                oldModel.setSelected(false);
                mListData.set(oldPosition, oldModel);
                mProductAdapter.notifyItemChanged(oldPosition);
            }
        }
    }

    private void initDataFake() {
//        mListProductName = new ArrayList<>();
//        mListProductName.clear();

//        for (int i = 0; i < 20; i++) {
//            mListProductName.add("Product  name " + i);
//        }

        mListData = new ArrayList<>();
        addNewProduct(0, "Navy KROOKED sweater", "Hand-woven 100% cotton KROOKED rugby jearsey in baby blue/navy retro colour way.", 1750, R.drawable.p1);

        addNewProduct(1, "Grey Civilist crew neck", "100% cotton oversized Civilist crew neck sweater in steel " +
                "grey with orange embroided logo.", 1500, R.drawable.p2);

        addNewProduct(2, "Louis Lopez One Star", "Worn and designed by Louie Lopez, young icon and member of the CONS skate team.", 1200, R.drawable.p3);

        addNewProduct(3, "Cream Death Star hood", "Reverse weave 100% cotton Death Star hoodie with scenic retro vinyl.", 1500, R.drawable.p4);

        addNewProduct(4, "Krooked OG Bird Cuff beanie", "Doubke stitched wool Orange krooked foldover beanie with yellow Bird Cuff logo", 399, R.drawable.p5);

        addNewProduct(5, "North Face 1990 wind breaker", "Composition - 100% Polyester - a very strong synthetic fiber" +
                " that boasts high heat resistance and excellent odor absorption.", 2299, R.drawable.p6);
    }

    private void addNewProduct(int id, String s, String s2, int i, int p) {
        ProductModel productModel = new ProductModel();
        productModel.setId(id);
        productModel.setProductName(s);
        productModel.setProductDetails(s2);
        productModel.setProductPrice(i);
        productModel.setProductImage(p);
        productModel.setSelected(false);
        mListData.add(productModel);
    }

    private void initView(View view) {
        rvListProduct = view.findViewById(R.id.rvListProduct);

        mProductAdapter = new ProductAdapter(mListData);
        mProductAdapter.setCallback(clickListener);
        rvListProduct.setAdapter(mProductAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach: ");
        super.onDetach();
    }

    public void setClickListener(IItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
}