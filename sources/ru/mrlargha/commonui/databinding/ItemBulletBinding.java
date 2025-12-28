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
public final class ItemBulletBinding implements ViewBinding {
    public final ImageView ivItemIcon;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final View selectedView;
    public final TextView tvItemName;

    private ItemBulletBinding(ConstraintLayout rootView, ImageView ivItemIcon, ConstraintLayout parentLayout, View selectedView, TextView tvItemName) {
        this.rootView = rootView;
        this.ivItemIcon = ivItemIcon;
        this.parentLayout = parentLayout;
        this.selectedView = selectedView;
        this.tvItemName = tvItemName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBulletBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemBulletBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_bullet, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemBulletBinding bind(View rootView) {
        int i = R.id.ivItemIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.selectedView;
            View findChildViewById = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById != null) {
                i = R.id.tvItemName;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new ItemBulletBinding(constraintLayout, imageView, constraintLayout, findChildViewById, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
