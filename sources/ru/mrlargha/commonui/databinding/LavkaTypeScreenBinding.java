package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
public final class LavkaTypeScreenBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final ImageButton btnBuy;
    public final ImageButton btnSell;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer3;
    public final ImageView ivBackgroundStatus;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvInventory;
    public final RecyclerView rvShopInventory;
    public final TextView tvBuy;
    public final TextView tvScreenTitle;
    public final TextView tvSell;
    public final ImageView viewLine;

    private LavkaTypeScreenBinding(ConstraintLayout rootView, AppCompatImageView btnBack, ImageButton btnBuy, ImageButton btnSell, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineVer1, Guideline guidelineVer3, ImageView ivBackgroundStatus, ConstraintLayout parentLayout, RecyclerView rvInventory, RecyclerView rvShopInventory, TextView tvBuy, TextView tvScreenTitle, TextView tvSell, ImageView viewLine) {
        this.rootView = rootView;
        this.btnBack = btnBack;
        this.btnBuy = btnBuy;
        this.btnSell = btnSell;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer3 = guidelineVer3;
        this.ivBackgroundStatus = ivBackgroundStatus;
        this.parentLayout = parentLayout;
        this.rvInventory = rvInventory;
        this.rvShopInventory = rvShopInventory;
        this.tvBuy = tvBuy;
        this.tvScreenTitle = tvScreenTitle;
        this.tvSell = tvSell;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LavkaTypeScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LavkaTypeScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.lavka_type_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LavkaTypeScreenBinding bind(View rootView) {
        int i = R.id.btnBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.btnBuy;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, i);
            if (imageButton != null) {
                i = R.id.btnSell;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, i);
                if (imageButton2 != null) {
                    i = R.id.guidelineHor1;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline != null) {
                        i = R.id.guidelineHor2;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline2 != null) {
                            i = R.id.guidelineVer1;
                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline3 != null) {
                                i = R.id.guidelineVer3;
                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline4 != null) {
                                    i = R.id.ivBackgroundStatus;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                        i = R.id.rvInventory;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.rvShopInventory;
                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView2 != null) {
                                                i = R.id.tvBuy;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView != null) {
                                                    i = R.id.tvScreenTitle;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tvSell;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView3 != null) {
                                                            i = R.id.viewLine;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView2 != null) {
                                                                return new LavkaTypeScreenBinding(constraintLayout, appCompatImageView, imageButton, imageButton2, guideline, guideline2, guideline3, guideline4, imageView, constraintLayout, recyclerView, recyclerView2, textView, textView2, textView3, imageView2);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
