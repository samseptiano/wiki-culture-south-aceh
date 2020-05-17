package com.techarmony.wikiculture;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.techarmony.wikiculture.ui.homedetail.HomeDetailActivity;
import com.techarmony.wikiculture.ui.kebudayaan.KebudayaanActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<CategoryModel> categoryModelList;
    private Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryName;
        public ImageButton imgCategory;

        public MyViewHolder(View view) {
            super(view);
            categoryName = (TextView) view.findViewById(R.id.categoryName);
            imgCategory = (ImageButton) view.findViewById(R.id.imgBtncategory);

        }
    }


    public CategoryAdapter(List<CategoryModel> categoryModelList, Context ctx) {
        this.categoryModelList = categoryModelList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CategoryModel categoryModel = categoryModelList.get(position);
        holder.categoryName.setText(categoryModel.getCategoryName());
        Picasso.with(ctx).load(categoryModel.getKategori_foto()).into(holder.imgCategory);

        holder.imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicit = new Intent(ctx, KebudayaanActivity.class);
                explicit.putExtra("id",categoryModel.getCategoryID());
                explicit.putExtra("categoryName",categoryModel.getCategoryName());
                ctx.startActivity(explicit);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }
}
