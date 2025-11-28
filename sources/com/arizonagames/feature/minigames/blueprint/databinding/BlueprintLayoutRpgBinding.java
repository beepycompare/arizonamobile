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
public final class BlueprintLayoutRpgBinding implements ViewBinding {
    public final Guideline guidelineRpgStage1;
    public final Guideline guidelineRpgStage2;
    public final Guideline guidelineRpgStage34;
    public final Guideline guidelineRpgStage4Horizontal;
    public final Guideline guidelineRpgStage4Vertical;
    private final ConstraintLayout rootView;
    public final ImageView rpgImage;
    public final RelativeLayout rpgTouchAreaStage1;
    public final RelativeLayout rpgTouchAreaStage2;
    public final RelativeLayout rpgTouchAreaStage3;
    public final RelativeLayout rpgTouchAreaStage4;

    private BlueprintLayoutRpgBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = constraintLayout;
        this.guidelineRpgStage1 = guideline;
        this.guidelineRpgStage2 = guideline2;
        this.guidelineRpgStage34 = guideline3;
        this.guidelineRpgStage4Horizontal = guideline4;
        this.guidelineRpgStage4Vertical = guideline5;
        this.rpgImage = imageView;
        this.rpgTouchAreaStage1 = relativeLayout;
        this.rpgTouchAreaStage2 = relativeLayout2;
        this.rpgTouchAreaStage3 = relativeLayout3;
        this.rpgTouchAreaStage4 = relativeLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutRpgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintLayoutRpgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_layout_rpg, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutRpgBinding bind(View view) {
        int i = R.id.guideline_rpg_stage1;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.guideline_rpg_stage2;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.guideline_rpg_stage_3_4;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline3 != null) {
                    i = R.id.guideline_rpg_stage4_horizontal;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_rpg_stage4_vertical;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline5 != null) {
                            i = R.id.rpg_image;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.rpg_touch_area_stage_1;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.rpg_touch_area_stage_2;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout2 != null) {
                                        i = R.id.rpg_touch_area_stage_3;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout3 != null) {
                                            i = R.id.rpg_touch_area_stage_4;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout4 != null) {
                                                return new BlueprintLayoutRpgBinding((ConstraintLayout) view, guideline, guideline2, guideline3, guideline4, guideline5, imageView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
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
