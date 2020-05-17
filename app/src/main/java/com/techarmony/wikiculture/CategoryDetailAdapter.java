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

import java.util.List;

public class CategoryDetailAdapter extends RecyclerView.Adapter<CategoryDetailAdapter.MyViewHolder> {

    private List<CategoryDetailModel> categoryDetailModelList;
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


    public CategoryDetailAdapter(List<CategoryDetailModel> categoryDetailModelList, Context ctx) {
        this.categoryDetailModelList = categoryDetailModelList;
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
        final CategoryDetailModel categoryDetailModel = categoryDetailModelList.get(position);
        holder.categoryName.setText(categoryDetailModel.getKebudayaan_nama());
        Picasso.with(ctx).load(categoryDetailModel.getKebudayaan_foto()).into(holder.imgCategory);

        holder.imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicit = new Intent(ctx, HomeDetailActivity.class);
                explicit.putExtra("kebudayaan_id",categoryDetailModel.getKebudayaan_id());
                explicit.putExtra("kebudayaan_kategori",categoryDetailModel.getKebudayaan_kategori());
                explicit.putExtra("kebudayaan_nama",categoryDetailModel.getKebudayaan_nama());
                explicit.putExtra("kebudayaan_foto",categoryDetailModel.getKebudayaan_foto());
                explicit.putExtra("kebudayaan_desk",categoryDetailModel.getKebudayaan_desk());
                explicit.putExtra("kebudayaan_status",categoryDetailModel.getKebudayaan_status());
                explicit.putExtra("kebudayaan_waktu",categoryDetailModel.getKebudayaan_waktu());
                explicit.putExtra("kebudayaan_input",categoryDetailModel.getKebudayaan_input());
                explicit.putExtra("kategori_nama",categoryDetailModel.getKategori_nama());
                explicit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                ctx.startActivity(explicit);


            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryDetailModelList.size();
    }
}
