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

    private BlueprintLayoutSnipeBinding(ConstraintLayout rootView, Guideline guidelineSnipeStage1Horizontal, Guideline guidelineSnipeStage1Vertical, Guideline guidelineSnipeStage2Horizontal1, Guideline guidelineSnipeStage2Horizontal2, Guideline guidelineSnipeStage3Horizontal1, Guideline guidelineSnipeStage3Horizontal2, Guideline guidelineSnipeStage3Vertical1, Guideline guidelineSnipeStage3Vertical2, RelativeLayout riffleTouchAreaStage2, ImageView rifleImage, RelativeLayout snipeTouchAreaStage2, RelativeLayout snipeTouchAreaStage3) {
        this.rootView = rootView;
        this.guidelineSnipeStage1Horizontal = guidelineSnipeStage1Horizontal;
        this.guidelineSnipeStage1Vertical = guidelineSnipeStage1Vertical;
        this.guidelineSnipeStage2Horizontal1 = guidelineSnipeStage2Horizontal1;
        this.guidelineSnipeStage2Horizontal2 = guidelineSnipeStage2Horizontal2;
        this.guidelineSnipeStage3Horizontal1 = guidelineSnipeStage3Horizontal1;
        this.guidelineSnipeStage3Horizontal2 = guidelineSnipeStage3Horizontal2;
        this.guidelineSnipeStage3Vertical1 = guidelineSnipeStage3Vertical1;
        this.guidelineSnipeStage3Vertical2 = guidelineSnipeStage3Vertical2;
        this.riffleTouchAreaStage2 = riffleTouchAreaStage2;
        this.rifleImage = rifleImage;
        this.snipeTouchAreaStage2 = snipeTouchAreaStage2;
        this.snipeTouchAreaStage3 = snipeTouchAreaStage3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutSnipeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintLayoutSnipeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_layout_snipe, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutSnipeBinding bind(View rootView) {
        int i = R.id.guideline_snipe_stage_1_horizontal;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline_snipe_stage_1_vertical;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline_snipe_stage_2_horizontal_1;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.guideline_snipe_stage_2_horizontal_2;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_snipe_stage_3_horizontal_1;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline5 != null) {
                            i = R.id.guideline_snipe_stage_3_horizontal_2;
                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline6 != null) {
                                i = R.id.guideline_snipe_stage_3_vertical_1;
                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline7 != null) {
                                    i = R.id.guideline_snipe_stage_3_vertical_2;
                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline8 != null) {
                                        i = R.id.riffle_touch_area_stage_2;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (relativeLayout != null) {
                                            i = R.id.rifle_image;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView != null) {
                                                i = R.id.snipe_touch_area_stage_2;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.snipe_touch_area_stage_3;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (relativeLayout3 != null) {
                                                        return new BlueprintLayoutSnipeBinding((ConstraintLayout) rootView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, relativeLayout, imageView, relativeLayout2, relativeLayout3);
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
