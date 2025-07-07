package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.card.MaterialCardView;
/* loaded from: classes3.dex */
public final class FragmentTipsBinding implements ViewBinding {
    public final ImageView arrowLeft;
    public final ImageView arrowRight;
    public final Barrier barrier3;
    public final ImageView imageView25;
    public final MaterialCardView materialCardView2;
    private final ConstraintLayout rootView;
    public final TextView text;
    public final TextView title;

    private FragmentTipsBinding(ConstraintLayout rootView, ImageView arrowLeft, ImageView arrowRight, Barrier barrier3, ImageView imageView25, MaterialCardView materialCardView2, TextView text, TextView title) {
        this.rootView = rootView;
        this.arrowLeft = arrowLeft;
        this.arrowRight = arrowRight;
        this.barrier3 = barrier3;
        this.imageView25 = imageView25;
        this.materialCardView2 = materialCardView2;
        this.text = text;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTipsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTipsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_tips, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTipsBinding bind(View rootView) {
        int i = R.id.arrow_left;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.arrow_right;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.barrier3;
                Barrier barrier = (Barrier) ViewBindings.findChildViewById(rootView, i);
                if (barrier != null) {
                    i = R.id.imageView25;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.materialCardView2;
                        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
                        if (materialCardView != null) {
                            i = R.id.text;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    return new FragmentTipsBinding((ConstraintLayout) rootView, imageView, imageView2, barrier, imageView3, materialCardView, textView, textView2);
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
