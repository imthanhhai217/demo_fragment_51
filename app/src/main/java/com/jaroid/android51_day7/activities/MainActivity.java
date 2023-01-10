package com.jaroid.android51_day7.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.jaroid.android51_day7.R;
import com.jaroid.android51_day7.fragments.ListProductFragment;
import com.jaroid.android51_day7.fragments.ProductDetailsFragment;
import com.jaroid.android51_day7.intefaces.IItemClickListener;
import com.jaroid.android51_day7.models.ProductModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TESTING MAIN";
    private ListProductFragment listProductFragment;
    private int oldPosition = -1;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        //Vẽ list product fragment trên View container
        listProductFragment = ListProductFragment.newInstance();
        listProductFragment.setClickListener(clickListener);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, listProductFragment)
                .commit();
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }

    private void removeFragment() {
//        getSupportFragmentManager().beginTransaction().remove(listProductFragment).commit();
        getSupportFragmentManager().popBackStack();
        Log.d(TAG, "pop back stack: " + getSupportFragmentManager().getFragments().size());
    }

    private IItemClickListener clickListener = new IItemClickListener() {
        @Override
        public void onItemClick(int position, ProductModel model) {
            Log.d(TAG, "onItemClick: " + position);
            //Yêu cầu fragment cập nhật lại view
            listProductFragment.updateSelectedPosition(position, oldPosition);

            addNewProductDetailFragment(model);
            oldPosition = position;
        }
    };

    private void addNewProductDetailFragment(ProductModel model) {
        ProductDetailsFragment productDetailsFragment = ProductDetailsFragment.newInstance(model);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerDetail, productDetailsFragment)
                .addToBackStack("DETAILS")
                .commit();

        Log.d(TAG, "addNewProductDetailFragment: " + getSupportFragmentManager().getFragments().size());
    }
}