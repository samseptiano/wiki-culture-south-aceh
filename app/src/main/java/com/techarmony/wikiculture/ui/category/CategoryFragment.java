package com.techarmony.wikiculture.ui.category;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techarmony.wikiculture.CategoryAdapter;
import com.techarmony.wikiculture.CategoryModel;
import com.techarmony.wikiculture.R;

import java.util.List;

public class CategoryFragment extends Fragment {

    private CategoryViewModel categoryViewModel;
    private CategoryAdapter mAdapter;
    ProgressDialog pd;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel =
                ViewModelProviders.of(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        final RecyclerView rvCategory = root.findViewById(R.id.rvCategory);

        categoryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        pd = new ProgressDialog(getContext());
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();
        categoryViewModel.showCategory(getContext()).observe(this, new Observer<List<CategoryModel>>() {
            @Override
            public void onChanged(List<CategoryModel> categoryModelList) {
                mAdapter = new CategoryAdapter(categoryModelList,getContext());
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                rvCategory.setLayoutManager(mLayoutManager);
                rvCategory.setItemAnimator(new DefaultItemAnimator());
                rvCategory.setAdapter(mAdapter);
                pd.dismiss();
            }
        });
        return root;
    }
}