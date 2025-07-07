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
public final class BootomArzNavBarBinding implements ViewBinding {
    public final ImageView homeButton;
    public final ImageView imageView4;
    public final ImageView playButton;
    private final ConstraintLayout rootView;
    public final ImageView settingsButton;

    private BootomArzNavBarBinding(ConstraintLayout rootView, ImageView homeButton, ImageView imageView4, ImageView playButton, ImageView settingsButton) {
        this.rootView = rootView;
        this.homeButton = homeButton;
        this.imageView4 = imageView4;
        this.playButton = playButton;
        this.settingsButton = settingsButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BootomArzNavBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BootomArzNavBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bootom_arz_nav_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BootomArzNavBarBinding bind(View rootView) {
        int i = R.id.home_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.imageView4;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.play_button;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.settings_button;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        return new BootomArzNavBarBinding((ConstraintLayout) rootView, imageView, imageView2, imageView3, imageView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
