package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudArizonaTrainSettingsBinding implements ViewBinding {
    public final ImageView ivDoors;
    public final ImageView ivDoorsState;
    public final ImageView ivHorn;
    public final ImageView ivHornState;
    private final ConstraintLayout rootView;
    public final ConstraintLayout trainSettings;

    private HudArizonaTrainSettingsBinding(ConstraintLayout rootView, ImageView ivDoors, ImageView ivDoorsState, ImageView ivHorn, ImageView ivHornState, ConstraintLayout trainSettings) {
        this.rootView = rootView;
        this.ivDoors = ivDoors;
        this.ivDoorsState = ivDoorsState;
        this.ivHorn = ivHorn;
        this.ivHornState = ivHornState;
        this.trainSettings = trainSettings;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HudArizonaTrainSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudArizonaTrainSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_arizona_train_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudArizonaTrainSettingsBinding bind(View rootView) {
        int i = R.id.ivDoors;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.ivDoorsState;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.ivHorn;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.ivHornState;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        return new HudArizonaTrainSettingsBinding(constraintLayout, imageView, imageView2, imageView3, imageView4, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
