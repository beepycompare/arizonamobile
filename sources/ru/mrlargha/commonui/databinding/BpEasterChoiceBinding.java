package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BpEasterChoiceBinding implements ViewBinding {
    public final ImageView backButton;
    public final ConstraintLayout bpEventChoice;
    public final LinearLayout container;
    public final ImageView item1;
    public final ImageView item2;
    private final ConstraintLayout rootView;

    private BpEasterChoiceBinding(ConstraintLayout rootView, ImageView backButton, ConstraintLayout bpEventChoice, LinearLayout container, ImageView item1, ImageView item2) {
        this.rootView = rootView;
        this.backButton = backButton;
        this.bpEventChoice = bpEventChoice;
        this.container = container;
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BpEasterChoiceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BpEasterChoiceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bp_easter_choice, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BpEasterChoiceBinding bind(View rootView) {
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.item1;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.item2;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        return new BpEasterChoiceBinding(constraintLayout, imageView, constraintLayout, linearLayout, imageView2, imageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
