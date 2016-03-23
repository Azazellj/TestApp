package com.azazellj.testapp.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.azazellj.testapp.R;
import com.azazellj.testapp.entity.Picture;
import com.squareup.picasso.Picasso;


/**
 * Created by azazellj on 20.03.16.
 */
public class PictureCardView extends CardView {
    private ImageView imageView;
    private TextView imageAuthor;
    private TextView imageTitle;

    public PictureCardView(Context context) {
        this(context, null);
    }

    public PictureCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PictureCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.picture_item, this);
        this.imageView = (ImageView) findViewById(R.id.picture_image);
        this.imageAuthor = (TextView) findViewById(R.id.picture_author);
        this.imageTitle = (TextView) findViewById(R.id.picture_title);
    }

    public void updateView(final Picture picture) {
        Picasso.with(getContext()).load(picture.image).into(this.imageView);
        imageAuthor.setText(picture.author);
        imageTitle.setText(picture.title);
    }
}