package com.azazellj.testapp.bindingadapters;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.view.activity.BaseActivity;
import com.azazellj.testapp.view.activity.DetailedActivity;
import com.squareup.picasso.Picasso;

@SuppressWarnings("unused")
public class BindingAdapters {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("addOnClickListener")
    public static void shortClick(View view, final Picture picture) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picture.setDetailMode(true);

                Intent send = new Intent(view.getContext(), DetailedActivity.class);
                send.putExtra(BaseActivity.KEY_BUNDLE_PICTURE, picture);

                view.getContext().startActivity(send);
            }
        });
    }
}
