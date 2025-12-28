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
public final class ItemInfoCostBinding implements ViewBinding {
    public final Guideline guidelineVer;
    public final ImageView ivValueIcon;
    public final TextView nameTextView;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView valueTextView;

    private ItemInfoCostBinding(ConstraintLayout rootView, Guideline guidelineVer, ImageView ivValueIcon, TextView nameTextView, ConstraintLayout parentLayout, TextView valueTextView) {
        this.rootView = rootView;
        this.guidelineVer = guidelineVer;
        this.ivValueIcon = ivValueIcon;
        this.nameTextView = nameTextView;
        this.parentLayout = parentLayout;
        this.valueTextView = valueTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemInfoCostBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemInfoCostBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_info_cost, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemInfoCostBinding bind(View rootView) {
        int i = R.id.guidelineVer;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.ivValueIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.nameTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.valueTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new ItemInfoCostBinding(constraintLayout, guideline, imageView, textView, constraintLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
