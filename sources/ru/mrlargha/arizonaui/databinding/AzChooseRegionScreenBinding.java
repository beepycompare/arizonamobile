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
public final class AzChooseRegionScreenBinding implements ViewBinding {
    public final Guideline bottomLine;
    public final AppCompatImageView chooseByNumbers;
    public final AppCompatImageView chooseKzNumbers;
    public final AppCompatImageView chooseRusNumbers;
    public final AppCompatImageView chooseUaNumbers;
    public final ConstraintLayout completeButton;
    public final Guideline leftLine;
    public final ConstraintLayout logoContainer;
    public final ImageView logoIc;
    public final TextView logoIcTitle;
    public final ConstraintLayout previousButton;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final ConstraintLayout selectRegion;
    public final Guideline topLine;

    private AzChooseRegionScreenBinding(ConstraintLayout constraintLayout, Guideline guideline, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout2, Guideline guideline2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView, ConstraintLayout constraintLayout4, Guideline guideline3, ConstraintLayout constraintLayout5, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.bottomLine = guideline;
        this.chooseByNumbers = appCompatImageView;
        this.chooseKzNumbers = appCompatImageView2;
        this.chooseRusNumbers = appCompatImageView3;
        this.chooseUaNumbers = appCompatImageView4;
        this.completeButton = constraintLayout2;
        this.leftLine = guideline2;
        this.logoContainer = constraintLayout3;
        this.logoIc = imageView;
        this.logoIcTitle = textView;
        this.previousButton = constraintLayout4;
        this.rightLine = guideline3;
        this.selectRegion = constraintLayout5;
        this.topLine = guideline4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzChooseRegionScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AzChooseRegionScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.az_choose_region_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzChooseRegionScreenBinding bind(View view) {
        int i = R.id.bottom_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.choose_by_numbers;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.choose_kz_numbers;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.choose_rus_numbers;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView3 != null) {
                        i = R.id.choose_ua_numbers;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView4 != null) {
                            i = R.id.complete_button;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.left_line;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    i = R.id.logo_container;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.logo_ic;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.logo_ic_title;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.previous_button;
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout3 != null) {
                                                    i = R.id.right_line;
                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline3 != null) {
                                                        i = R.id.select_region;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.top_line;
                                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline4 != null) {
                                                                return new AzChooseRegionScreenBinding((ConstraintLayout) view, guideline, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, constraintLayout, guideline2, constraintLayout2, imageView, textView, constraintLayout3, guideline3, constraintLayout4, guideline4);
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
