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
public final class BlueprintLayoutSnipeBinding implements ViewBinding {
    public final Guideline guidelineSnipeStage1Horizontal;
    public final Guideline guidelineSnipeStage1Vertical;
    public final Guideline guidelineSnipeStage2Horizontal1;
    public final Guideline guidelineSnipeStage2Horizontal2;
    public final Guideline guidelineSnipeStage3Horizontal1;
    public final Guideline guidelineSnipeStage3Horizontal2;
    public final Guideline guidelineSnipeStage3Vertical1;
    public final Guideline guidelineSnipeStage3Vertical2;
    public final RelativeLayout riffleTouchAreaStage2;
    public final ImageView rifleImage;
    private final ConstraintLayout rootView;
    public final RelativeLayout snipeTouchAreaStage2;
    public final RelativeLayout snipeTouchAreaStage3;

    private BlueprintLayoutSnipeBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = constraintLayout;
        this.guidelineSnipeStage1Horizontal = guideline;
        this.guidelineSnipeStage1Vertical = guideline2;
        this.guidelineSnipeStage2Horizontal1 = guideline3;
        this.guidelineSnipeStage2Horizontal2 = guideline4;
        this.guidelineSnipeStage3Horizontal1 = guideline5;
        this.guidelineSnipeStage3Horizontal2 = guideline6;
        this.guidelineSnipeStage3Vertical1 = guideline7;
        this.guidelineSnipeStage3Vertical2 = guideline8;
        this.riffleTouchAreaStage2 = relativeLayout;
        this.rifleImage = imageView;
        this.snipeTouchAreaStage2 = relativeLayout2;
        this.snipeTouchAreaStage3 = relativeLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutSnipeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintLayoutSnipeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_layout_snipe, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutSnipeBinding bind(View view) {
        int i = R.id.guideline_snipe_stage_1_horizontal;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.guideline_snipe_stage_1_vertical;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.guideline_snipe_stage_2_horizontal_1;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline3 != null) {
                    i = R.id.guideline_snipe_stage_2_horizontal_2;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_snipe_stage_3_horizontal_1;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline5 != null) {
                            i = R.id.guideline_snipe_stage_3_horizontal_2;
                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline6 != null) {
                                i = R.id.guideline_snipe_stage_3_vertical_1;
                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline7 != null) {
                                    i = R.id.guideline_snipe_stage_3_vertical_2;
                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline8 != null) {
                                        i = R.id.riffle_touch_area_stage_2;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = R.id.rifle_image;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.snipe_touch_area_stage_2;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.snipe_touch_area_stage_3;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        return new BlueprintLayoutSnipeBinding((ConstraintLayout) view, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, relativeLayout, imageView, relativeLayout2, relativeLayout3);
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
