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
public final class BlueprintLayoutRifleBinding implements ViewBinding {
    public final Guideline guidelineSnipeStage1HorizontalBottom;
    public final Guideline guidelineSnipeStage1HorizontalTop;
    public final Guideline guidelineSnipeStage1VerticalEnd;
    public final Guideline guidelineSnipeStage1VerticalStart;
    public final Guideline guidelineSnipeStage2HorizontalBottom;
    public final Guideline guidelineSnipeStage2HorizontalTop;
    public final Guideline guidelineSnipeStage2VerticalStart;
    public final Guideline guidelineSnipeStage3VerticalBottom;
    public final Guideline guidelineSnipeStage3VerticalEnd;
    public final Guideline guidelineSnipeStage3VerticalStart;
    public final Guideline guidelineSnipeStage4HorizontalBottom;
    public final RelativeLayout riffleTouchAreaStage1;
    public final RelativeLayout riffleTouchAreaStage2;
    public final RelativeLayout riffleTouchAreaStage3;
    public final RelativeLayout riffleTouchAreaStage4;
    public final ImageView rifleImage;
    private final ConstraintLayout rootView;

    private BlueprintLayoutRifleBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ImageView imageView) {
        this.rootView = constraintLayout;
        this.guidelineSnipeStage1HorizontalBottom = guideline;
        this.guidelineSnipeStage1HorizontalTop = guideline2;
        this.guidelineSnipeStage1VerticalEnd = guideline3;
        this.guidelineSnipeStage1VerticalStart = guideline4;
        this.guidelineSnipeStage2HorizontalBottom = guideline5;
        this.guidelineSnipeStage2HorizontalTop = guideline6;
        this.guidelineSnipeStage2VerticalStart = guideline7;
        this.guidelineSnipeStage3VerticalBottom = guideline8;
        this.guidelineSnipeStage3VerticalEnd = guideline9;
        this.guidelineSnipeStage3VerticalStart = guideline10;
        this.guidelineSnipeStage4HorizontalBottom = guideline11;
        this.riffleTouchAreaStage1 = relativeLayout;
        this.riffleTouchAreaStage2 = relativeLayout2;
        this.riffleTouchAreaStage3 = relativeLayout3;
        this.riffleTouchAreaStage4 = relativeLayout4;
        this.rifleImage = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutRifleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintLayoutRifleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_layout_rifle, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutRifleBinding bind(View view) {
        int i = R.id.guideline_snipe_stage_1_horizontal_bottom;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.guideline_snipe_stage_1_horizontal_top;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.guideline_snipe_stage_1_vertical_end;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline3 != null) {
                    i = R.id.guideline_snipe_stage_1_vertical_start;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_snipe_stage_2_horizontal_bottom;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline5 != null) {
                            i = R.id.guideline_snipe_stage_2_horizontal_top;
                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline6 != null) {
                                i = R.id.guideline_snipe_stage_2_vertical_start;
                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline7 != null) {
                                    i = R.id.guideline_snipe_stage_3_vertical_bottom;
                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline8 != null) {
                                        i = R.id.guideline_snipe_stage_3_vertical_end;
                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline9 != null) {
                                            i = R.id.guideline_snipe_stage_3_vertical_start;
                                            Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline10 != null) {
                                                i = R.id.guideline_snipe_stage_4_horizontal_bottom;
                                                Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline11 != null) {
                                                    i = R.id.riffle_touch_area_stage_1;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.riffle_touch_area_stage_2;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout2 != null) {
                                                            i = R.id.riffle_touch_area_stage_3;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.riffle_touch_area_stage_4;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.rifle_image;
                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView != null) {
                                                                        return new BlueprintLayoutRifleBinding((ConstraintLayout) view, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, imageView);
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
