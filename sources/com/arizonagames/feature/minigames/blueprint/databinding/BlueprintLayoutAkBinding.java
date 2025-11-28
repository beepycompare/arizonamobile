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
public final class BlueprintLayoutAkBinding implements ViewBinding {
    public final ImageView akImage;
    public final RelativeLayout akTouchAreaStage1;
    public final RelativeLayout akTouchAreaStage2;
    public final RelativeLayout akTouchAreaStage3;
    public final RelativeLayout akTouchAreaStage4;
    public final RelativeLayout akTouchAreaStage5;
    public final Guideline guidelineAkStage2Vertical1;
    public final Guideline guidelineAkStage2Vertical2;
    public final Guideline guidelineAkStage3Horizontal2;
    public final Guideline guidelineAkStage4Horizontal1;
    public final Guideline guidelineAkStage4Vertical;
    public final Guideline guidelineSnipeStage1Horizontal;
    public final Guideline guidelineSnipeStage1Vertical;
    public final Guideline guidelineSnipeStage2Horizontal1;
    public final Guideline guidelineSnipeStage2Horizontal2;
    public final Guideline guidelineSnipeStage3Horizontal1;
    private final ConstraintLayout rootView;

    private BlueprintLayoutAkBinding(ConstraintLayout constraintLayout, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10) {
        this.rootView = constraintLayout;
        this.akImage = imageView;
        this.akTouchAreaStage1 = relativeLayout;
        this.akTouchAreaStage2 = relativeLayout2;
        this.akTouchAreaStage3 = relativeLayout3;
        this.akTouchAreaStage4 = relativeLayout4;
        this.akTouchAreaStage5 = relativeLayout5;
        this.guidelineAkStage2Vertical1 = guideline;
        this.guidelineAkStage2Vertical2 = guideline2;
        this.guidelineAkStage3Horizontal2 = guideline3;
        this.guidelineAkStage4Horizontal1 = guideline4;
        this.guidelineAkStage4Vertical = guideline5;
        this.guidelineSnipeStage1Horizontal = guideline6;
        this.guidelineSnipeStage1Vertical = guideline7;
        this.guidelineSnipeStage2Horizontal1 = guideline8;
        this.guidelineSnipeStage2Horizontal2 = guideline9;
        this.guidelineSnipeStage3Horizontal1 = guideline10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutAkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintLayoutAkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_layout_ak, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutAkBinding bind(View view) {
        int i = R.id.ak_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ak_touch_area_stage_1;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.ak_touch_area_stage_2;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.ak_touch_area_stage_3;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout3 != null) {
                        i = R.id.ak_touch_area_stage_4;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout4 != null) {
                            i = R.id.ak_touch_area_stage_5;
                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout5 != null) {
                                i = R.id.guideline_ak_stage_2_vertical_1;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline != null) {
                                    i = R.id.guideline_ak_stage_2_vertical_2;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline2 != null) {
                                        i = R.id.guideline_ak_stage_3_horizontal_2;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline3 != null) {
                                            i = R.id.guideline_ak_stage_4_horizontal_1;
                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline4 != null) {
                                                i = R.id.guideline_ak_stage_4_vertical;
                                                Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline5 != null) {
                                                    i = R.id.guideline_snipe_stage_1_horizontal;
                                                    Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline6 != null) {
                                                        i = R.id.guideline_snipe_stage_1_vertical;
                                                        Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline7 != null) {
                                                            i = R.id.guideline_snipe_stage_2_horizontal_1;
                                                            Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline8 != null) {
                                                                i = R.id.guideline_snipe_stage_2_horizontal_2;
                                                                Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline9 != null) {
                                                                    i = R.id.guideline_snipe_stage_3_horizontal_1;
                                                                    Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline10 != null) {
                                                                        return new BlueprintLayoutAkBinding((ConstraintLayout) view, imageView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10);
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
