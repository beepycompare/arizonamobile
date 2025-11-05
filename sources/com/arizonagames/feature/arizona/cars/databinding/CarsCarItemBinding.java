package com.arizonagames.feature.arizona.cars.databinding;

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
import com.arizonagames.feature.arizona.cars.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class CarsCarItemBinding implements ViewBinding {
    public final ImageView carFavIc;
    public final ImageView carIc;
    public final ConstraintLayout carInfoContainer;
    public final TextView carName;
    public final Guideline carNameTopLine;
    public final TextView carStatus;
    public final ImageView carStatusIc;
    public final Guideline carStatusLeftLine;
    public final ConstraintLayout carsCarItem;
    public final RecyclerView mainPageCarParamsRc;
    public final TextView qualityText;
    public final CustomCardView rarityCard;
    public final CustomCardView ratingCard;
    public final TextView ratingText;
    private final ConstraintLayout rootView;
    public final ConstraintLayout spawnButton;
    public final ImageView spawnIc;
    public final TextView spawnTitle;
    public final ConstraintLayout statusContainer;

    private CarsCarItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView, Guideline guideline, TextView textView2, ImageView imageView3, Guideline guideline2, ConstraintLayout constraintLayout3, RecyclerView recyclerView, TextView textView3, CustomCardView customCardView, CustomCardView customCardView2, TextView textView4, ConstraintLayout constraintLayout4, ImageView imageView4, TextView textView5, ConstraintLayout constraintLayout5) {
        this.rootView = constraintLayout;
        this.carFavIc = imageView;
        this.carIc = imageView2;
        this.carInfoContainer = constraintLayout2;
        this.carName = textView;
        this.carNameTopLine = guideline;
        this.carStatus = textView2;
        this.carStatusIc = imageView3;
        this.carStatusLeftLine = guideline2;
        this.carsCarItem = constraintLayout3;
        this.mainPageCarParamsRc = recyclerView;
        this.qualityText = textView3;
        this.rarityCard = customCardView;
        this.ratingCard = customCardView2;
        this.ratingText = textView4;
        this.spawnButton = constraintLayout4;
        this.spawnIc = imageView4;
        this.spawnTitle = textView5;
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
        int i = R.id.car_fav_ic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.car_ic;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
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
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.car_status_left_line;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline2 != null) {
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                        i = R.id.main_page_car_params_rc;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R.id.quality_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.rarity_card;
                                                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView != null) {
                                                    i = R.id.rating_card;
                                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView2 != null) {
                                                        i = R.id.rating_text;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.spawn_button;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.spawn_ic;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView4 != null) {
                                                                    i = R.id.spawn_title;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.status_container;
                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout4 != null) {
                                                                            return new CarsCarItemBinding(constraintLayout2, imageView, imageView2, constraintLayout, textView, guideline, textView2, imageView3, guideline2, constraintLayout2, recyclerView, textView3, customCardView, customCardView2, textView4, constraintLayout3, imageView4, textView5, constraintLayout4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
