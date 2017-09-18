package com.jesperqvarfordt.taskhero.presentation.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.jesperqvarfordt.taskhero.R;

public class AnimatedToggleStar extends RelativeLayout {

    private LottieAnimationView star;
    private boolean filled = false;
    private boolean clickable = true;

    public AnimatedToggleStar(Context context) {
        super(context);
        init();
    }

    public AnimatedToggleStar(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleAttributes(attrs);
        init();
    }

    public AnimatedToggleStar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleAttributes(attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_animated_toggle_star, this);
        star = findViewById(R.id.animated_star);
        star.setProgress(filled ? 1.0f : 0.0f);

        if (clickable) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggle();
                }
            });
        }
    }

    private void handleAttributes(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.AnimatedToggleStar);

        if (array != null) {
            filled = array.getBoolean(R.styleable.AnimatedToggleStar_fill, false);
            clickable = array.getBoolean(R.styleable.AnimatedToggleStar_clickable, true);
            array.recycle();
        }
    }

    public void toggle() {
        if (star.isAnimating()) {
            return;
        }
        if (filled) {
            star.reverseAnimation();
            filled = false;
        } else {
            star.playAnimation();
            filled = true;
        }
    }

    public boolean isFilled() {
        return filled;
    }

    public void fill() {
        if (filled) {
            return;
        }
        toggle();
    }

    public void unfill() {
        if (!filled) {
            return;
        }
        toggle();
    }

}
