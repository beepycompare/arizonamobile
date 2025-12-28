package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemTuningCharacteristicBinding implements ViewBinding {
    public final Button btnCartTypes;
    public final View clickedBg;
    public final ImageView ivItemIcon;
    public final ConstraintLayout mainView;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvItemDiscount;
    public final AppCompatTextView tvItemName;
    public final AppCompatTextView tvItemPrice;
    public final AppCompatTextView tvItemType;

    private ItemTuningCharacteristicBinding(ConstraintLayout rootView, Button btnCartTypes, View clickedBg, ImageView ivItemIcon, ConstraintLayout mainView, ConstraintLayout parentLayout, AppCompatTextView tvItemDiscount, AppCompatTextView tvItemName, AppCompatTextView tvItemPrice, AppCompatTextView tvItemType) {
        this.rootView = rootView;
        this.btnCartTypes = btnCartTypes;
        this.clickedBg = clickedBg;
        this.ivItemIcon = ivItemIcon;
        this.mainView = mainView;
        this.parentLayout = parentLayout;
        this.tvItemDiscount = tvItemDiscount;
        this.tvItemName = tvItemName;
        this.tvItemPrice = tvItemPrice;
        this.tvItemType = tvItemType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTuningCharacteristicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTuningCharacteristicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_tuning_characteristic, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTuningCharacteristicBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btnCartTypes;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.clickedBg))) != null) {
            i = R.id.ivItemIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.mainView;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                    i = R.id.tvItemDiscount;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatTextView != null) {
                        i = R.id.tvItemName;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatTextView2 != null) {
                            i = R.id.tvItemPrice;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatTextView3 != null) {
                                i = R.id.tvItemType;
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatTextView4 != null) {
                                    return new ItemTuningCharacteristicBinding(constraintLayout2, button, findChildViewById, imageView, constraintLayout, constraintLayout2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
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
