package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.imageview.ShapeableImageView;
/* loaded from: classes3.dex */
public final class ActivitySplashBinding implements ViewBinding {
    public final Guideline endLine;
    public final ShapeableImageView icon;
    public final Guideline iconTopLine;
    public final ImageView imageView22;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final Guideline startLine;
    public final ConstraintLayout testGLES;
    public final TextView textView13;
    public final TextView textView14;

    private ActivitySplashBinding(ConstraintLayout rootView, Guideline endLine, ShapeableImageView icon, Guideline iconTopLine, ImageView imageView22, ProgressBar progressBar, Guideline startLine, ConstraintLayout testGLES, TextView textView13, TextView textView14) {
        this.rootView = rootView;
        this.endLine = endLine;
        this.icon = icon;
        this.iconTopLine = iconTopLine;
        this.imageView22 = imageView22;
        this.progressBar = progressBar;
        this.startLine = startLine;
        this.testGLES = testGLES;
        this.textView13 = textView13;
        this.textView14 = textView14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_splash, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySplashBinding bind(View rootView) {
        int i = R.id.end_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.icon;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
            if (shapeableImageView != null) {
                i = R.id.icon_top_line;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.imageView22;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView != null) {
                        i = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                        if (progressBar != null) {
                            i = R.id.start_line;
                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline3 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.textView13;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.textView14;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        return new ActivitySplashBinding(constraintLayout, guideline, shapeableImageView, guideline2, imageView, progressBar, guideline3, constraintLayout, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
