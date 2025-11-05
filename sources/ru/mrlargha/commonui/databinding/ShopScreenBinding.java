package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ShopScreenBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvShopInventory;
    public final TextView tvScreenTitle;
    public final ImageView viewLine;

    private ShopScreenBinding(ConstraintLayout rootView, AppCompatImageView btnBack, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer3, ConstraintLayout parentLayout, RecyclerView rvShopInventory, TextView tvScreenTitle, ImageView viewLine) {
        this.rootView = rootView;
        this.btnBack = btnBack;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.parentLayout = parentLayout;
        this.rvShopInventory = rvShopInventory;
        this.tvScreenTitle = tvScreenTitle;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ShopScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.shop_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopScreenBinding bind(View rootView) {
        int i = R.id.btnBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.guidelineHor1;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.guidelineHor2;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.guidelineVer1;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline3 != null) {
                        i = R.id.guidelineVer2;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline4 != null) {
                            i = R.id.guidelineVer3;
                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline5 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.rvShopInventory;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.tvScreenTitle;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.viewLine;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView != null) {
                                            return new ShopScreenBinding(constraintLayout, appCompatImageView, guideline, guideline2, guideline3, guideline4, guideline5, constraintLayout, recyclerView, textView, imageView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
