package com.arizonagames.feature.minigames.blueprint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.blueprint.R;
/* loaded from: classes3.dex */
public final class BlueprintLayoutPmBinding implements ViewBinding {
    public final Guideline guidelinePmStage1;
    public final Guideline guidelinePmStage11;
    public final Guideline guidelinePmStage2Horizontal1;
    public final Guideline guidelinePmStage2Horizontal2;
    public final Guideline guidelinePmStage2Vertical1;
    public final Guideline guidelinePmStage2Vertical2;
    public final Guideline guidelinePmStage3Horizontal1;
    public final Guideline guidelinePmStage3Vertical1;
    public final Guideline guidelinePmStage3Vertical2;
    public final ImageView pmImage;
    public final RelativeLayout pmTouchAreaStage1;
    public final RelativeLayout pmTouchAreaStage2;
    public final RelativeLayout pmTouchAreaStage3;
    private final ConstraintLayout rootView;

    private BlueprintLayoutPmBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = constraintLayout;
        this.guidelinePmStage1 = guideline;
        this.guidelinePmStage11 = guideline2;
        this.guidelinePmStage2Horizontal1 = guideline3;
        this.guidelinePmStage2Horizontal2 = guideline4;
        this.guidelinePmStage2Vertical1 = guideline5;
        this.guidelinePmStage2Vertical2 = guideline6;
        this.guidelinePmStage3Horizontal1 = guideline7;
        this.guidelinePmStage3Vertical1 = guideline8;
        this.guidelinePmStage3Vertical2 = guideline9;
        this.pmImage = imageView;
        this.pmTouchAreaStage1 = relativeLayout;
        this.pmTouchAreaStage2 = relativeLayout2;
        this.pmTouchAreaStage3 = relativeLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutPmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintLayoutPmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_layout_pm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutPmBinding bind(View view) {
        int i = R.id.guideline_pm_stage_1;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.guideline_pm_stage_1_1;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.guideline_pm_stage_2_horizontal_1;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline3 != null) {
                    i = R.id.guideline_pm_stage_2_horizontal_2;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_pm_stage_2_vertical_1;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline5 != null) {
                            i = R.id.guideline_pm_stage_2_vertical_2;
                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline6 != null) {
                                i = R.id.guideline_pm_stage_3_horizontal_1;
                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline7 != null) {
                                    i = R.id.guideline_pm_stage_3_vertical_1;
                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline8 != null) {
                                        i = R.id.guideline_pm_stage_3_vertical_2;
                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline9 != null) {
                                            i = R.id.pm_image;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.pm_touch_area_stage_1;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout != null) {
                                                    i = R.id.pm_touch_area_stage_2;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.pm_touch_area_stage_3;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout3 != null) {
                                                            return new BlueprintLayoutPmBinding((ConstraintLayout) view, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, imageView, relativeLayout, relativeLayout2, relativeLayout3);
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
