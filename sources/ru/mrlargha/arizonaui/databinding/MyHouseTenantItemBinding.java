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
public final class MyHouseTenantItemBinding implements ViewBinding {
    public final ConstraintLayout daysInRentContainer;
    public final TextView daysInRentContainerTitle;
    public final TextView daysInRentContainerValue;
    public final Guideline daysInRentLeftLine;
    public final ImageView kickTenantButton;
    public final ConstraintLayout myHouseTenantItem;
    public final ConstraintLayout nameContainer;
    public final TextView nameContainerTitle;
    public final TextView nameContainerValue;
    public final ConstraintLayout priceContainer;
    public final TextView priceContainerTitle;
    public final TextView priceContainerValue;
    public final Guideline priceLeftLine;
    private final ConstraintLayout rootView;
    public final ConstraintLayout statusContainer;
    public final TextView statusContainerTitle;
    public final TextView statusContainerValue;
    public final Guideline statusLeftLine;

    private MyHouseTenantItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, Guideline guideline, ImageView imageView, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView3, TextView textView4, ConstraintLayout constraintLayout5, TextView textView5, TextView textView6, Guideline guideline2, ConstraintLayout constraintLayout6, TextView textView7, TextView textView8, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.daysInRentContainer = constraintLayout2;
        this.daysInRentContainerTitle = textView;
        this.daysInRentContainerValue = textView2;
        this.daysInRentLeftLine = guideline;
        this.kickTenantButton = imageView;
        this.myHouseTenantItem = constraintLayout3;
        this.nameContainer = constraintLayout4;
        this.nameContainerTitle = textView3;
        this.nameContainerValue = textView4;
        this.priceContainer = constraintLayout5;
        this.priceContainerTitle = textView5;
        this.priceContainerValue = textView6;
        this.priceLeftLine = guideline2;
        this.statusContainer = constraintLayout6;
        this.statusContainerTitle = textView7;
        this.statusContainerValue = textView8;
        this.statusLeftLine = guideline3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyHouseTenantItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyHouseTenantItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_house_tenant_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyHouseTenantItemBinding bind(View view) {
        int i = R.id.days_in_rent_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.days_in_rent_container_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.days_in_rent_container_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.days_in_rent_left_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.kick_tenant_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = R.id.name_container;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.name_container_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.name_container_value;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.price_container;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout4 != null) {
                                            i = R.id.price_container_title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.price_container_value;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.price_left_line;
                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline2 != null) {
                                                        i = R.id.status_container;
                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout5 != null) {
                                                            i = R.id.status_container_title;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.status_container_value;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.status_left_line;
                                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline3 != null) {
                                                                        return new MyHouseTenantItemBinding(constraintLayout2, constraintLayout, textView, textView2, guideline, imageView, constraintLayout2, constraintLayout3, textView3, textView4, constraintLayout4, textView5, textView6, guideline2, constraintLayout5, textView7, textView8, guideline3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
