package com.azazellj.testapp.bindingadapters;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.azazellj.testapp.entity.ItemColor;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.utils.DialogUtils;
import com.azazellj.testapp.view.activity.DetailedActivity;
import com.squareup.picasso.Picasso;

import java.util.Random;

@SuppressWarnings("unused")
public class BindingAdapters {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("addOnLongClickListener")
    public static void longClick(View view, ItemColor color) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                view.setBackgroundColor(color);

                DialogUtils.showTimeDialog(view.getContext().getApplicationContext(), "SSSS");


                return true;
            }
        });
    }

    @BindingAdapter("addOnClickListener")
    public static void shortClick(View view, final Picture picture) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), DetailedActivity.class));
            }
        });
    }
}
