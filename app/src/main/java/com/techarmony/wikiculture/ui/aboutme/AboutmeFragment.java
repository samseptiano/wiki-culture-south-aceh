package com.techarmony.wikiculture.ui.aboutme;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;
import com.techarmony.wikiculture.R;

public class AboutmeFragment extends Fragment {

    private AboutmeViewModel aboutmeViewModel;
    ProgressDialog pd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        aboutmeViewModel =
                ViewModelProviders.of(this).get(AboutmeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about_me, container, false);

        final TextView tv_about_author = root.findViewById(R.id.tv_about_author);
        final TextView about_desc = root.findViewById(R.id.about_desc);
        final TextView about_alamat = root.findViewById(R.id.about_alamat);
        final TextView about_email = root.findViewById(R.id.about_email);
        final ImageView about_photo = root.findViewById(R.id.about_photo);
        final TextView about_prodi = root.findViewById(R.id.about_prodi);
        final TextView tv_about_birthdate = root.findViewById(R.id.tv_about_birthdate);
        final TextView tv_about_birthplace = root.findViewById(R.id.tv_about_birthplace);
        final TextView tv_about_gender = root.findViewById(R.id.tv_about_gender);
        final TextView tv_about_judul = root.findViewById(R.id.tv_about_judul);
        final TextView tv_about_religion = root.findViewById(R.id.tv_about_religion);

        pd = new ProgressDialog(getContext());
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();

        aboutmeViewModel.getAuthor().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_about_author.setText(s);
            }
        });
        aboutmeViewModel.getJudul().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_about_judul.setText(s);
            }
        });
        aboutmeViewModel.getAgama().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_about_religion.setText(s);
            }
        });
        aboutmeViewModel.getAlamat().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                about_alamat.setText(s);
            }
        });
        aboutmeViewModel.getBirthdate().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_about_birthdate.setText(s);
            }
        });
        aboutmeViewModel.getBirthplace().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_about_birthplace.setText(s);
            }
        });
        aboutmeViewModel.getDesc().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                about_desc.setText(s);
            }
        });
        aboutmeViewModel.getFoto().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Picasso.with(getContext()).load(s).into(about_photo);
            }
        });
        aboutmeViewModel.getUniv().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                about_prodi.setText(s);
            }
        });
        aboutmeViewModel.getDesc().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                about_desc.setText(s);
            }
        });
        aboutmeViewModel.getEmail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                about_email.setText(s);
            }
        });
        aboutmeViewModel.getGender().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_about_gender.setText(s);
            }
        });

        pd.dismiss();
        return root;
    }
}