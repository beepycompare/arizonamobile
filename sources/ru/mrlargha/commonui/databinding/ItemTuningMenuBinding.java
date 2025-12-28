package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemTuningMenuBinding implements ViewBinding {
    public final ImageView ivMenuIcon;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView tvMenuName;
    public final ImageView viewLine;

    private ItemTuningMenuBinding(ConstraintLayout rootView, ImageView ivMenuIcon, ConstraintLayout parentLayout, TextView tvMenuName, ImageView viewLine) {
        this.rootView = rootView;
        this.ivMenuIcon = ivMenuIcon;
        this.parentLayout = parentLayout;
        this.tvMenuName = tvMenuName;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTuningMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTuningMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_tuning_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTuningMenuBinding bind(View rootView) {
        int i = R.id.ivMenuIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.tvMenuName;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.viewLine;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    return new ItemTuningMenuBinding(constraintLayout, imageView, constraintLayout, textView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
