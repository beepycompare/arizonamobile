package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyHouseUpgradeItemBinding implements ViewBinding {
    public final ImageView buyButton;
    public final Guideline daysInRentLeftLine;
    public final ImageView infoButton;
    public final ConstraintLayout myHouseUpgradeItem;
    public final ConstraintLayout nameContainer;
    public final TextView nameContainerTitle;
    public final TextView nameContainerValue;
    public final ConstraintLayout priceContainer;
    public final TextView priceContainerTitle;
    public final TextView priceContainerValue;
    public final Guideline priceLeftLine;
    private final ConstraintLayout rootView;
    public final Guideline statusLeftLine;

    private MyHouseUpgradeItemBinding(ConstraintLayout constraintLayout, ImageView imageView, Guideline guideline, ImageView imageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, ConstraintLayout constraintLayout4, TextView textView3, TextView textView4, Guideline guideline2, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.buyButton = imageView;
        this.daysInRentLeftLine = guideline;
        this.infoButton = imageView2;
        this.myHouseUpgradeItem = constraintLayout2;
        this.nameContainer = constraintLayout3;
        this.nameContainerTitle = textView;
        this.nameContainerValue = textView2;
        this.priceContainer = constraintLayout4;
        this.priceContainerTitle = textView3;
        this.priceContainerValue = textView4;
        this.priceLeftLine = guideline2;
        this.statusLeftLine = guideline3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyHouseUpgradeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyHouseUpgradeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_house_upgrade_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyHouseUpgradeItemBinding bind(View view) {
        int i = R.id.buy_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.days_in_rent_left_line;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.info_button;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.name_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.name_container_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.name_container_value;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.price_container;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.price_container_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.price_container_value;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.price_left_line;
                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline2 != null) {
                                                i = R.id.status_left_line;
                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline3 != null) {
                                                    return new MyHouseUpgradeItemBinding(constraintLayout, imageView, guideline, imageView2, constraintLayout, constraintLayout2, textView, textView2, constraintLayout3, textView3, textView4, guideline2, guideline3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
