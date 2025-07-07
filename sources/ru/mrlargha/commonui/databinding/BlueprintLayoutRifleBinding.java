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

    private BlueprintLayoutRifleBinding(ConstraintLayout rootView, Guideline guidelineSnipeStage1HorizontalBottom, Guideline guidelineSnipeStage1HorizontalTop, Guideline guidelineSnipeStage1VerticalEnd, Guideline guidelineSnipeStage1VerticalStart, Guideline guidelineSnipeStage2HorizontalBottom, Guideline guidelineSnipeStage2HorizontalTop, Guideline guidelineSnipeStage2VerticalStart, Guideline guidelineSnipeStage3VerticalBottom, Guideline guidelineSnipeStage3VerticalEnd, Guideline guidelineSnipeStage3VerticalStart, Guideline guidelineSnipeStage4HorizontalBottom, RelativeLayout riffleTouchAreaStage1, RelativeLayout riffleTouchAreaStage2, RelativeLayout riffleTouchAreaStage3, RelativeLayout riffleTouchAreaStage4, ImageView rifleImage) {
        this.rootView = rootView;
        this.guidelineSnipeStage1HorizontalBottom = guidelineSnipeStage1HorizontalBottom;
        this.guidelineSnipeStage1HorizontalTop = guidelineSnipeStage1HorizontalTop;
        this.guidelineSnipeStage1VerticalEnd = guidelineSnipeStage1VerticalEnd;
        this.guidelineSnipeStage1VerticalStart = guidelineSnipeStage1VerticalStart;
        this.guidelineSnipeStage2HorizontalBottom = guidelineSnipeStage2HorizontalBottom;
        this.guidelineSnipeStage2HorizontalTop = guidelineSnipeStage2HorizontalTop;
        this.guidelineSnipeStage2VerticalStart = guidelineSnipeStage2VerticalStart;
        this.guidelineSnipeStage3VerticalBottom = guidelineSnipeStage3VerticalBottom;
        this.guidelineSnipeStage3VerticalEnd = guidelineSnipeStage3VerticalEnd;
        this.guidelineSnipeStage3VerticalStart = guidelineSnipeStage3VerticalStart;
        this.guidelineSnipeStage4HorizontalBottom = guidelineSnipeStage4HorizontalBottom;
        this.riffleTouchAreaStage1 = riffleTouchAreaStage1;
        this.riffleTouchAreaStage2 = riffleTouchAreaStage2;
        this.riffleTouchAreaStage3 = riffleTouchAreaStage3;
        this.riffleTouchAreaStage4 = riffleTouchAreaStage4;
        this.rifleImage = rifleImage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutRifleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintLayoutRifleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_layout_rifle, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutRifleBinding bind(View rootView) {
        int i = R.id.guideline_snipe_stage_1_horizontal_bottom;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline_snipe_stage_1_horizontal_top;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline_snipe_stage_1_vertical_end;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.guideline_snipe_stage_1_vertical_start;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_snipe_stage_2_horizontal_bottom;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline5 != null) {
                            i = R.id.guideline_snipe_stage_2_horizontal_top;
                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline6 != null) {
                                i = R.id.guideline_snipe_stage_2_vertical_start;
                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline7 != null) {
                                    i = R.id.guideline_snipe_stage_3_vertical_bottom;
                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline8 != null) {
                                        i = R.id.guideline_snipe_stage_3_vertical_end;
                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline9 != null) {
                                            i = R.id.guideline_snipe_stage_3_vertical_start;
                                            Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline10 != null) {
                                                i = R.id.guideline_snipe_stage_4_horizontal_bottom;
                                                Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline11 != null) {
                                                    i = R.id.riffle_touch_area_stage_1;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.riffle_touch_area_stage_2;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (relativeLayout2 != null) {
                                                            i = R.id.riffle_touch_area_stage_3;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.riffle_touch_area_stage_4;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.rifle_image;
                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (imageView != null) {
                                                                        return new BlueprintLayoutRifleBinding((ConstraintLayout) rootView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, imageView);
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
