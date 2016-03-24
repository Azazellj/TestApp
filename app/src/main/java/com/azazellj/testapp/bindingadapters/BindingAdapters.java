package com.azazellj.testapp.bindingadapters;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.azazellj.testapp.R;
import com.azazellj.testapp.entity.Picture;
import com.azazellj.testapp.utils.Constants;
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

                View titleView = view.findViewById(R.id.picture_title);
                View imageView = view.findViewById(R.id.picture_image);

                Pair<View, String> pairTitle = Pair.create(titleView, Constants.KEY_TITLE);
                Pair<View, String> pairImage = Pair.create(imageView, Constants.KEY_IMAGE);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((AppCompatActivity) view.getContext(), pairTitle, pairImage);
                ActivityCompat.startActivity((AppCompatActivity) view.getContext(), send, options.toBundle());
            }
        });
    }
}
