package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.metaldetector.LocatorView;
/* loaded from: classes5.dex */
public final class MetaldetectorScreenBinding implements ViewBinding {
    public final MaterialButton digButton;
    public final Guideline guideline2;
    public final ImageView imageView37;
    public final AppCompatImageView imageView9;
    public final LocatorView locatorView;
    public final ConstraintLayout rodinaMetaldetectorRoot;
    private final ConstraintLayout rootView;
    public final TextView textView11;

    private MetaldetectorScreenBinding(ConstraintLayout rootView, MaterialButton digButton, Guideline guideline2, ImageView imageView37, AppCompatImageView imageView9, LocatorView locatorView, ConstraintLayout rodinaMetaldetectorRoot, TextView textView11) {
        this.rootView = rootView;
        this.digButton = digButton;
        this.guideline2 = guideline2;
        this.imageView37 = imageView37;
        this.imageView9 = imageView9;
        this.locatorView = locatorView;
        this.rodinaMetaldetectorRoot = rodinaMetaldetectorRoot;
        this.textView11 = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MetaldetectorScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MetaldetectorScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.metaldetector_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static MetaldetectorScreenBinding bind(View rootView) {
        int i = R.id.dig_button;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.guideline2;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.imageView37;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.imageView9;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.locatorView;
                        LocatorView locatorView = (LocatorView) ViewBindings.findChildViewById(rootView, i);
                        if (locatorView != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                            i = R.id.textView11;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                return new MetaldetectorScreenBinding(constraintLayout, materialButton, guideline, imageView, appCompatImageView, locatorView, constraintLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
