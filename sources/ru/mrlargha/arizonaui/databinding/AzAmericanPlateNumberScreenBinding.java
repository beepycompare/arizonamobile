package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class AzAmericanPlateNumberScreenBinding implements ViewBinding {
    public final TextView adviceDescription;
    public final AppCompatImageView adviceIc;
    public final TextView adviceTitle;
    public final ConstraintLayout americanPlate;
    public final Guideline bottomLine;
    public final ConstraintLayout chooseNumber;
    public final ConstraintLayout completeButton;
    public final Guideline leftLine;
    public final ConstraintLayout logoContainer;
    public final ImageView logoIc;
    public final TextView logoIcTitle;
    public final ConstraintLayout plate;
    public final TextView plateNumber;
    public final ConstraintLayout previousButton;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final AppCompatImageView swipeLeftButton;
    public final AppCompatImageView swipeRightButton;
    public final Guideline topLine;

    private AzAmericanPlateNumberScreenBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, ConstraintLayout constraintLayout2, Guideline guideline, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, Guideline guideline2, ConstraintLayout constraintLayout5, ImageView imageView, TextView textView3, ConstraintLayout constraintLayout6, TextView textView4, ConstraintLayout constraintLayout7, Guideline guideline3, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.adviceDescription = textView;
        this.adviceIc = appCompatImageView;
        this.adviceTitle = textView2;
        this.americanPlate = constraintLayout2;
        this.bottomLine = guideline;
        this.chooseNumber = constraintLayout3;
        this.completeButton = constraintLayout4;
        this.leftLine = guideline2;
        this.logoContainer = constraintLayout5;
        this.logoIc = imageView;
        this.logoIcTitle = textView3;
        this.plate = constraintLayout6;
        this.plateNumber = textView4;
        this.previousButton = constraintLayout7;
        this.rightLine = guideline3;
        this.swipeLeftButton = appCompatImageView2;
        this.swipeRightButton = appCompatImageView3;
        this.topLine = guideline4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzAmericanPlateNumberScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AzAmericanPlateNumberScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.az_american_plate_number_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzAmericanPlateNumberScreenBinding bind(View view) {
        int i = R.id.advice_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.advice_ic;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.advice_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.bottom_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.choose_number;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.complete_button;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.left_line;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    i = R.id.logo_container;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.logo_ic;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.logo_ic_title;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.plate;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.plate_number;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.previous_button;
                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout6 != null) {
                                                            i = R.id.right_line;
                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline3 != null) {
                                                                i = R.id.swipe_left_button;
                                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                if (appCompatImageView2 != null) {
                                                                    i = R.id.swipe_right_button;
                                                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (appCompatImageView3 != null) {
                                                                        i = R.id.top_line;
                                                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline4 != null) {
                                                                            return new AzAmericanPlateNumberScreenBinding(constraintLayout, textView, appCompatImageView, textView2, constraintLayout, guideline, constraintLayout2, constraintLayout3, guideline2, constraintLayout4, imageView, textView3, constraintLayout5, textView4, constraintLayout6, guideline3, appCompatImageView2, appCompatImageView3, guideline4);
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
