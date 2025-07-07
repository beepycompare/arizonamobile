package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final ImageView homeButton;
    public final ImageView imageView4;
    public final ImageView imageView5;
    public final ConstraintLayout mainLayout;
    public final ImageView playButton;
    private final ConstraintLayout rootView;
    public final ImageView settingsButton;

    private ActivityMainBinding(ConstraintLayout rootView, ImageView homeButton, ImageView imageView4, ImageView imageView5, ConstraintLayout mainLayout, ImageView playButton, ImageView settingsButton) {
        this.rootView = rootView;
        this.homeButton = homeButton;
        this.imageView4 = imageView4;
        this.imageView5 = imageView5;
        this.mainLayout = mainLayout;
        this.playButton = playButton;
        this.settingsButton = settingsButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View rootView) {
        int i = R.id.home_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.imageView4;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.imageView5;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.play_button;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        i = R.id.settings_button;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView5 != null) {
                            return new ActivityMainBinding(constraintLayout, imageView, imageView2, imageView3, constraintLayout, imageView4, imageView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
