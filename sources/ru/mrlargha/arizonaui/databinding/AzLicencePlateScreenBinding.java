package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class AzLicencePlateScreenBinding implements ViewBinding {
    public final TextView adviceDescription;
    public final AppCompatImageView adviceIc;
    public final TextView adviceTitle;
    public final AppCompatImageView backButton;
    public final Guideline bottomLine;
    public final AzByPlateScreenBinding byPlateScreen;
    public final ConstraintLayout choosePlateContainer;
    public final AzChooseRegionScreenBinding chooseRegionScreen;
    public final TextView cisPriceText;
    public final AzKzPlateScreenBinding kzPlateScreen;
    public final Guideline leftLine;
    public final ConstraintLayout licensePlates;
    public final AppCompatImageView logo;
    public final ConstraintLayout mainPlatesScreen;
    public final Guideline mainTopLine;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final AzRusPlateScreenBinding rusPlateScreen;
    public final ConstraintLayout sngPlateMainButton;
    public final TextView title;
    public final TextView titleDescription;
    public final Guideline topLine;
    public final AzUaPlateScreenBinding uaPlateScreen;
    public final ConstraintLayout usaPlateMainButton;
    public final AzAmericanPlateNumberScreenBinding usaPlatesScreen;
    public final TextView usaPriceText;

    private AzLicencePlateScreenBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, AppCompatImageView appCompatImageView2, Guideline guideline, AzByPlateScreenBinding azByPlateScreenBinding, ConstraintLayout constraintLayout2, AzChooseRegionScreenBinding azChooseRegionScreenBinding, TextView textView3, AzKzPlateScreenBinding azKzPlateScreenBinding, Guideline guideline2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout4, Guideline guideline3, Guideline guideline4, AzRusPlateScreenBinding azRusPlateScreenBinding, ConstraintLayout constraintLayout5, TextView textView4, TextView textView5, Guideline guideline5, AzUaPlateScreenBinding azUaPlateScreenBinding, ConstraintLayout constraintLayout6, AzAmericanPlateNumberScreenBinding azAmericanPlateNumberScreenBinding, TextView textView6) {
        this.rootView = constraintLayout;
        this.adviceDescription = textView;
        this.adviceIc = appCompatImageView;
        this.adviceTitle = textView2;
        this.backButton = appCompatImageView2;
        this.bottomLine = guideline;
        this.byPlateScreen = azByPlateScreenBinding;
        this.choosePlateContainer = constraintLayout2;
        this.chooseRegionScreen = azChooseRegionScreenBinding;
        this.cisPriceText = textView3;
        this.kzPlateScreen = azKzPlateScreenBinding;
        this.leftLine = guideline2;
        this.licensePlates = constraintLayout3;
        this.logo = appCompatImageView3;
        this.mainPlatesScreen = constraintLayout4;
        this.mainTopLine = guideline3;
        this.rightLine = guideline4;
        this.rusPlateScreen = azRusPlateScreenBinding;
        this.sngPlateMainButton = constraintLayout5;
        this.title = textView4;
        this.titleDescription = textView5;
        this.topLine = guideline5;
        this.uaPlateScreen = azUaPlateScreenBinding;
        this.usaPlateMainButton = constraintLayout6;
        this.usaPlatesScreen = azAmericanPlateNumberScreenBinding;
        this.usaPriceText = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzLicencePlateScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AzLicencePlateScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.az_licence_plate_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzLicencePlateScreenBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        View findChildViewById6;
        int i = R.id.advice_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.advice_ic;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.advice_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.back_button;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.bottom_line;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.by_plate_screen))) != null) {
                            AzByPlateScreenBinding bind = AzByPlateScreenBinding.bind(findChildViewById);
                            i = R.id.choose_plate_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.choose_region_screen))) != null) {
                                AzChooseRegionScreenBinding bind2 = AzChooseRegionScreenBinding.bind(findChildViewById2);
                                i = R.id.cis_price_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.kz_plate_screen))) != null) {
                                    AzKzPlateScreenBinding bind3 = AzKzPlateScreenBinding.bind(findChildViewById3);
                                    i = R.id.left_line;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline2 != null) {
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                        i = R.id.logo;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView3 != null) {
                                            i = R.id.main_plates_screen;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.main_top_line;
                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline3 != null) {
                                                    i = R.id.right_line;
                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline4 != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.rus_plate_screen))) != null) {
                                                        AzRusPlateScreenBinding bind4 = AzRusPlateScreenBinding.bind(findChildViewById4);
                                                        i = R.id.sng_plate_main_button;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.title;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.title_description;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.top_line;
                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline5 != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.ua_plate_screen))) != null) {
                                                                        AzUaPlateScreenBinding bind5 = AzUaPlateScreenBinding.bind(findChildViewById5);
                                                                        i = R.id.usa_plate_main_button;
                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout5 != null && (findChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.usa_plates_screen))) != null) {
                                                                            AzAmericanPlateNumberScreenBinding bind6 = AzAmericanPlateNumberScreenBinding.bind(findChildViewById6);
                                                                            i = R.id.usa_price_text;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                return new AzLicencePlateScreenBinding(constraintLayout2, textView, appCompatImageView, textView2, appCompatImageView2, guideline, bind, constraintLayout, bind2, textView3, bind3, guideline2, constraintLayout2, appCompatImageView3, constraintLayout3, guideline3, guideline4, bind4, constraintLayout4, textView4, textView5, guideline5, bind5, constraintLayout5, bind6, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
