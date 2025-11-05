package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemUserCartBinding implements ViewBinding {
    public final Guideline guidelineVer;
    public final ImageView ivRemoveCart;
    private final ConstraintLayout rootView;
    public final TextView tvItemName;
    public final TextView tvItemPrice;

    private ItemUserCartBinding(ConstraintLayout rootView, Guideline guidelineVer, ImageView ivRemoveCart, TextView tvItemName, TextView tvItemPrice) {
        this.rootView = rootView;
        this.guidelineVer = guidelineVer;
        this.ivRemoveCart = ivRemoveCart;
        this.tvItemName = tvItemName;
        this.tvItemPrice = tvItemPrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemUserCartBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemUserCartBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_user_cart, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemUserCartBinding bind(View rootView) {
        int i = R.id.guidelineVer;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.ivRemoveCart;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.tvItemName;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tvItemPrice;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new ItemUserCartBinding((ConstraintLayout) rootView, guideline, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
