package com.azazellj.testapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.azazellj.testapp.R;


/**
 * Created by azazellj on 20.03.16.
 */
public class PictureCardView extends View {
    public PictureCardView(Context context) {
        this(context, null);
    }

    public PictureCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PictureCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.picture_item, null);
    }
}