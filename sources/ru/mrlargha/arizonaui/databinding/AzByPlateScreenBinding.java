package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class AzByPlateScreenBinding implements ViewBinding {
    public final ConstraintLayout adviceContainer;
    public final TextView adviceDescription;
    public final AppCompatImageView adviceIc;
    public final TextView adviceTitle;
    public final ConstraintLayout chooseNumber;
    public final ConstraintLayout completeButton;
    public final EditText enterRegion;
    public final Guideline flagRightLine;
    public final ConstraintLayout logoContainer;
    public final ImageView logoIc;
    public final TextView logoIcTitle;
    public final ConstraintLayout plate;
    public final TextView plateNumber;
    public final ConstraintLayout previousButton;
    public final Guideline regionLeftLine;
    public final Guideline regionRightLine;
    private final ConstraintLayout rootView;

    private AzByPlateScreenBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, EditText editText, Guideline guideline, ConstraintLayout constraintLayout5, ImageView imageView, TextView textView3, ConstraintLayout constraintLayout6, TextView textView4, ConstraintLayout constraintLayout7, Guideline guideline2, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.adviceContainer = constraintLayout2;
        this.adviceDescription = textView;
        this.adviceIc = appCompatImageView;
        this.adviceTitle = textView2;
        this.chooseNumber = constraintLayout3;
        this.completeButton = constraintLayout4;
        this.enterRegion = editText;
        this.flagRightLine = guideline;
        this.logoContainer = constraintLayout5;
        this.logoIc = imageView;
        this.logoIcTitle = textView3;
        this.plate = constraintLayout6;
        this.plateNumber = textView4;
        this.previousButton = constraintLayout7;
        this.regionLeftLine = guideline2;
        this.regionRightLine = guideline3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzByPlateScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AzByPlateScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.az_by_plate_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzByPlateScreenBinding bind(View view) {
        int i = R.id.advice_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.advice_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.advice_ic;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.advice_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.choose_number;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.complete_button;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.enter_region;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.flag_right_line;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline != null) {
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
                                                                i = R.id.region_left_line;
                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline2 != null) {
                                                                    i = R.id.region_right_line;
                                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline3 != null) {
                                                                        return new AzByPlateScreenBinding((ConstraintLayout) view, constraintLayout, textView, appCompatImageView, textView2, constraintLayout2, constraintLayout3, editText, guideline, constraintLayout4, imageView, textView3, constraintLayout5, textView4, constraintLayout6, guideline2, guideline3);
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
