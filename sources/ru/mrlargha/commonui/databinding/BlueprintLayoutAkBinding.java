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

    private BlueprintLayoutAkBinding(ConstraintLayout rootView, ImageView akImage, RelativeLayout akTouchAreaStage1, RelativeLayout akTouchAreaStage2, RelativeLayout akTouchAreaStage3, RelativeLayout akTouchAreaStage4, RelativeLayout akTouchAreaStage5, Guideline guidelineAkStage2Vertical1, Guideline guidelineAkStage2Vertical2, Guideline guidelineAkStage3Horizontal2, Guideline guidelineAkStage4Horizontal1, Guideline guidelineAkStage4Vertical, Guideline guidelineSnipeStage1Horizontal, Guideline guidelineSnipeStage1Vertical, Guideline guidelineSnipeStage2Horizontal1, Guideline guidelineSnipeStage2Horizontal2, Guideline guidelineSnipeStage3Horizontal1) {
        this.rootView = rootView;
        this.akImage = akImage;
        this.akTouchAreaStage1 = akTouchAreaStage1;
        this.akTouchAreaStage2 = akTouchAreaStage2;
        this.akTouchAreaStage3 = akTouchAreaStage3;
        this.akTouchAreaStage4 = akTouchAreaStage4;
        this.akTouchAreaStage5 = akTouchAreaStage5;
        this.guidelineAkStage2Vertical1 = guidelineAkStage2Vertical1;
        this.guidelineAkStage2Vertical2 = guidelineAkStage2Vertical2;
        this.guidelineAkStage3Horizontal2 = guidelineAkStage3Horizontal2;
        this.guidelineAkStage4Horizontal1 = guidelineAkStage4Horizontal1;
        this.guidelineAkStage4Vertical = guidelineAkStage4Vertical;
        this.guidelineSnipeStage1Horizontal = guidelineSnipeStage1Horizontal;
        this.guidelineSnipeStage1Vertical = guidelineSnipeStage1Vertical;
        this.guidelineSnipeStage2Horizontal1 = guidelineSnipeStage2Horizontal1;
        this.guidelineSnipeStage2Horizontal2 = guidelineSnipeStage2Horizontal2;
        this.guidelineSnipeStage3Horizontal1 = guidelineSnipeStage3Horizontal1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutAkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintLayoutAkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_layout_ak, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutAkBinding bind(View rootView) {
        int i = R.id.ak_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.ak_touch_area_stage_1;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
            if (relativeLayout != null) {
                i = R.id.ak_touch_area_stage_2;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                if (relativeLayout2 != null) {
                    i = R.id.ak_touch_area_stage_3;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                    if (relativeLayout3 != null) {
                        i = R.id.ak_touch_area_stage_4;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                        if (relativeLayout4 != null) {
                            i = R.id.ak_touch_area_stage_5;
                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                            if (relativeLayout5 != null) {
                                i = R.id.guideline_ak_stage_2_vertical_1;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline != null) {
                                    i = R.id.guideline_ak_stage_2_vertical_2;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline2 != null) {
                                        i = R.id.guideline_ak_stage_3_horizontal_2;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline3 != null) {
                                            i = R.id.guideline_ak_stage_4_horizontal_1;
                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline4 != null) {
                                                i = R.id.guideline_ak_stage_4_vertical;
                                                Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline5 != null) {
                                                    i = R.id.guideline_snipe_stage_1_horizontal;
                                                    Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline6 != null) {
                                                        i = R.id.guideline_snipe_stage_1_vertical;
                                                        Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                        if (guideline7 != null) {
                                                            i = R.id.guideline_snipe_stage_2_horizontal_1;
                                                            Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline8 != null) {
                                                                i = R.id.guideline_snipe_stage_2_horizontal_2;
                                                                Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline9 != null) {
                                                                    i = R.id.guideline_snipe_stage_3_horizontal_1;
                                                                    Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline10 != null) {
                                                                        return new BlueprintLayoutAkBinding((ConstraintLayout) rootView, imageView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
