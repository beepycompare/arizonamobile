package com.arizonagames.feature.arizona.cars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.cars.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class CarsSecondScreenCarParamItemBinding implements ViewBinding {
    public final CustomCardView bg;
    public final ConstraintLayout carsFirstScreenCarParamItem;
    public final ImageView itemIc;
    public final TextView itemValue;
    public final CustomCardView qualityButton;
    private final ConstraintLayout rootView;

    private CarsSecondScreenCarParamItemBinding(ConstraintLayout constraintLayout, CustomCardView customCardView, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, CustomCardView customCardView2) {
        this.rootView = constraintLayout;
        this.bg = customCardView;
        this.carsFirstScreenCarParamItem = constraintLayout2;
        this.itemIc = imageView;
        this.itemValue = textView;
        this.qualityButton = customCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CarsSecondScreenCarParamItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CarsSecondScreenCarParamItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cars_second_screen_car_param_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CarsSecondScreenCarParamItemBinding bind(View view) {
        int i = R.id.bg;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.item_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.item_value;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.quality_button;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        return new CarsSecondScreenCarParamItemBinding(constraintLayout, customCardView, constraintLayout, imageView, textView, customCardView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
