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
public final class ItemTuningSubmenuBinding implements ViewBinding {
    public final View backView;
    public final ImageView ivSubMenuIcon;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView tvMenuName;

    private ItemTuningSubmenuBinding(ConstraintLayout rootView, View backView, ImageView ivSubMenuIcon, ConstraintLayout parentLayout, TextView tvMenuName) {
        this.rootView = rootView;
        this.backView = backView;
        this.ivSubMenuIcon = ivSubMenuIcon;
        this.parentLayout = parentLayout;
        this.tvMenuName = tvMenuName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTuningSubmenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTuningSubmenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_tuning_submenu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTuningSubmenuBinding bind(View rootView) {
        int i = R.id.backView;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            i = R.id.ivSubMenuIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.tvMenuName;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new ItemTuningSubmenuBinding(constraintLayout, findChildViewById, imageView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
