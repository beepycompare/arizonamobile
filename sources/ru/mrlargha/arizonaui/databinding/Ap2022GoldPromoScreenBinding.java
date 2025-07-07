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
public final class Ap2022GoldPromoScreenBinding implements ViewBinding {
    public final Guideline centerGuide;
    public final AppCompatImageView closeButton;
    public final AppCompatImageView imageView10;
    public final AppCompatImageView imageView2;
    public final AppCompatImageView imageView3;
    public final Guideline line1;
    public final Guideline line2;
    public final TextView passPrice;
    public final ConstraintLayout promoGoldLayout;
    public final AppCompatImageView purchaseButton;
    private final ConstraintLayout rootView;

    private Ap2022GoldPromoScreenBinding(ConstraintLayout constraintLayout, Guideline guideline, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, Guideline guideline2, Guideline guideline3, TextView textView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView5) {
        this.rootView = constraintLayout;
        this.centerGuide = guideline;
        this.closeButton = appCompatImageView;
        this.imageView10 = appCompatImageView2;
        this.imageView2 = appCompatImageView3;
        this.imageView3 = appCompatImageView4;
        this.line1 = guideline2;
        this.line2 = guideline3;
        this.passPrice = textView;
        this.promoGoldLayout = constraintLayout2;
        this.purchaseButton = appCompatImageView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Ap2022GoldPromoScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static Ap2022GoldPromoScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ap_2022_gold_promo_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Ap2022GoldPromoScreenBinding bind(View view) {
        int i = R.id.center_guide;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.close_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.imageView10;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.imageView2;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView3 != null) {
                        i = R.id.imageView3;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView4 != null) {
                            i = R.id.line_1;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline2 != null) {
                                i = R.id.line_2;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.pass_price;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = R.id.purchase_button;
                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView5 != null) {
                                            return new Ap2022GoldPromoScreenBinding(constraintLayout, guideline, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, guideline2, guideline3, textView, constraintLayout, appCompatImageView5);
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
