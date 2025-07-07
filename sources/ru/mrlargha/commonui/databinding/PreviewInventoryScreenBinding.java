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
public final class PreviewInventoryScreenBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer3;
    public final AppCompatImageView ivCharacterImage;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvUserImprovements;
    public final RecyclerView rvUserInventory;
    public final RecyclerView rvUserUpgrades;
    public final TextView tvScreenTitle;
    public final ImageView viewLine;

    private PreviewInventoryScreenBinding(ConstraintLayout rootView, AppCompatImageView btnBack, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineVer2, Guideline guidelineVer3, AppCompatImageView ivCharacterImage, ConstraintLayout parentLayout, RecyclerView rvUserImprovements, RecyclerView rvUserInventory, RecyclerView rvUserUpgrades, TextView tvScreenTitle, ImageView viewLine) {
        this.rootView = rootView;
        this.btnBack = btnBack;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer3 = guidelineVer3;
        this.ivCharacterImage = ivCharacterImage;
        this.parentLayout = parentLayout;
        this.rvUserImprovements = rvUserImprovements;
        this.rvUserInventory = rvUserInventory;
        this.rvUserUpgrades = rvUserUpgrades;
        this.tvScreenTitle = tvScreenTitle;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PreviewInventoryScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PreviewInventoryScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.preview_inventory_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static PreviewInventoryScreenBinding bind(View rootView) {
        int i = R.id.btnBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.guidelineHor1;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.guidelineHor2;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.guidelineVer2;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline3 != null) {
                        i = R.id.guidelineVer3;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline4 != null) {
                            i = R.id.ivCharacterImage;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageView2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.rvUserImprovements;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.rvUserInventory;
                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView2 != null) {
                                        i = R.id.rvUserUpgrades;
                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView3 != null) {
                                            i = R.id.tvScreenTitle;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView != null) {
                                                i = R.id.viewLine;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView != null) {
                                                    return new PreviewInventoryScreenBinding(constraintLayout, appCompatImageView, guideline, guideline2, guideline3, guideline4, appCompatImageView2, constraintLayout, recyclerView, recyclerView2, recyclerView3, textView, imageView);
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
