package com.imamabdulazis.loading;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private TextView textView;
    private float dari;
    private float sampai;

    public ProgressAnimation(Context context, ProgressBar progressBar, TextView textView, float dari, float sampai) {
        this.context = context;
        this.progressBar = progressBar;
        this.textView = textView;
        this.dari = dari;
        this.sampai = sampai;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = dari + (sampai - dari) + interpolatedTime;
        progressBar.setProgress((int) value);
        textView.setText((int) value + "%");

        if (value == sampai) {
            context.startActivity(new Intent(context, HomeActivity.class));
        }
    }
}
