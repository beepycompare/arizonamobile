package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class CarsCarItemBinding implements ViewBinding {
    public final ImageView carIc;
    public final ConstraintLayout carInfoContainer;
    public final TextView carName;
    public final Guideline carNameTopLine;
    public final TextView carStatus;
    public final ImageView carStatusIc;
    public final Guideline carStatusLeftLine;
    public final ConstraintLayout carsCarItem;
    public final RecyclerView mainPageCarParamsRc;
    private final ConstraintLayout rootView;
    public final ConstraintLayout spawnButton;
    public final ImageView spawnIc;
    public final TextView spawnTitle;
    public final ConstraintLayout statusContainer;

    private CarsCarItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, Guideline guideline, TextView textView2, ImageView imageView2, Guideline guideline2, ConstraintLayout constraintLayout3, RecyclerView recyclerView, ConstraintLayout constraintLayout4, ImageView imageView3, TextView textView3, ConstraintLayout constraintLayout5) {
        this.rootView = constraintLayout;
        this.carIc = imageView;
        this.carInfoContainer = constraintLayout2;
        this.carName = textView;
        this.carNameTopLine = guideline;
        this.carStatus = textView2;
        this.carStatusIc = imageView2;
        this.carStatusLeftLine = guideline2;
        this.carsCarItem = constraintLayout3;
        this.mainPageCarParamsRc = recyclerView;
        this.spawnButton = constraintLayout4;
        this.spawnIc = imageView3;
        this.spawnTitle = textView3;
        this.statusContainer = constraintLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CarsCarItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CarsCarItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cars_car_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CarsCarItemBinding bind(View view) {
        int i = R.id.car_ic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.car_info_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.car_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.car_name_top_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.car_status;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.car_status_ic;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.car_status_left_line;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                    i = R.id.main_page_car_params_rc;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.spawn_button;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout3 != null) {
                                            i = R.id.spawn_ic;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.spawn_title;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.status_container;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout4 != null) {
                                                        return new CarsCarItemBinding(constraintLayout2, imageView, constraintLayout, textView, guideline, textView2, imageView2, guideline2, constraintLayout2, recyclerView, constraintLayout3, imageView3, textView3, constraintLayout4);
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
