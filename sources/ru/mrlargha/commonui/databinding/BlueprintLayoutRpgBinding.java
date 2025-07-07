package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
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

    private BlueprintLayoutRpgBinding(ConstraintLayout rootView, Guideline guidelineRpgStage1, Guideline guidelineRpgStage2, Guideline guidelineRpgStage34, Guideline guidelineRpgStage4Horizontal, Guideline guidelineRpgStage4Vertical, ImageView rpgImage, RelativeLayout rpgTouchAreaStage1, RelativeLayout rpgTouchAreaStage2, RelativeLayout rpgTouchAreaStage3, RelativeLayout rpgTouchAreaStage4) {
        this.rootView = rootView;
        this.guidelineRpgStage1 = guidelineRpgStage1;
        this.guidelineRpgStage2 = guidelineRpgStage2;
        this.guidelineRpgStage34 = guidelineRpgStage34;
        this.guidelineRpgStage4Horizontal = guidelineRpgStage4Horizontal;
        this.guidelineRpgStage4Vertical = guidelineRpgStage4Vertical;
        this.rpgImage = rpgImage;
        this.rpgTouchAreaStage1 = rpgTouchAreaStage1;
        this.rpgTouchAreaStage2 = rpgTouchAreaStage2;
        this.rpgTouchAreaStage3 = rpgTouchAreaStage3;
        this.rpgTouchAreaStage4 = rpgTouchAreaStage4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutRpgBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintLayoutRpgBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_layout_rpg, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutRpgBinding bind(View rootView) {
        int i = R.id.guideline_rpg_stage1;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline_rpg_stage2;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline_rpg_stage_3_4;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.guideline_rpg_stage4_horizontal;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_rpg_stage4_vertical;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline5 != null) {
                            i = R.id.rpg_image;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.rpg_touch_area_stage_1;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                if (relativeLayout != null) {
                                    i = R.id.rpg_touch_area_stage_2;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (relativeLayout2 != null) {
                                        i = R.id.rpg_touch_area_stage_3;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (relativeLayout3 != null) {
                                            i = R.id.rpg_touch_area_stage_4;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (relativeLayout4 != null) {
                                                return new BlueprintLayoutRpgBinding((ConstraintLayout) rootView, guideline, guideline2, guideline3, guideline4, guideline5, imageView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4);
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
