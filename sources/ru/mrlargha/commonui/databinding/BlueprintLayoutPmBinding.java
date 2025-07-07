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

    private BlueprintLayoutPmBinding(ConstraintLayout rootView, Guideline guidelinePmStage1, Guideline guidelinePmStage11, Guideline guidelinePmStage2Horizontal1, Guideline guidelinePmStage2Horizontal2, Guideline guidelinePmStage2Vertical1, Guideline guidelinePmStage2Vertical2, Guideline guidelinePmStage3Horizontal1, Guideline guidelinePmStage3Vertical1, Guideline guidelinePmStage3Vertical2, ImageView pmImage, RelativeLayout pmTouchAreaStage1, RelativeLayout pmTouchAreaStage2, RelativeLayout pmTouchAreaStage3) {
        this.rootView = rootView;
        this.guidelinePmStage1 = guidelinePmStage1;
        this.guidelinePmStage11 = guidelinePmStage11;
        this.guidelinePmStage2Horizontal1 = guidelinePmStage2Horizontal1;
        this.guidelinePmStage2Horizontal2 = guidelinePmStage2Horizontal2;
        this.guidelinePmStage2Vertical1 = guidelinePmStage2Vertical1;
        this.guidelinePmStage2Vertical2 = guidelinePmStage2Vertical2;
        this.guidelinePmStage3Horizontal1 = guidelinePmStage3Horizontal1;
        this.guidelinePmStage3Vertical1 = guidelinePmStage3Vertical1;
        this.guidelinePmStage3Vertical2 = guidelinePmStage3Vertical2;
        this.pmImage = pmImage;
        this.pmTouchAreaStage1 = pmTouchAreaStage1;
        this.pmTouchAreaStage2 = pmTouchAreaStage2;
        this.pmTouchAreaStage3 = pmTouchAreaStage3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintLayoutPmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintLayoutPmBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_layout_pm, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintLayoutPmBinding bind(View rootView) {
        int i = R.id.guideline_pm_stage_1;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline_pm_stage_1_1;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline_pm_stage_2_horizontal_1;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.guideline_pm_stage_2_horizontal_2;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline4 != null) {
                        i = R.id.guideline_pm_stage_2_vertical_1;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline5 != null) {
                            i = R.id.guideline_pm_stage_2_vertical_2;
                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline6 != null) {
                                i = R.id.guideline_pm_stage_3_horizontal_1;
                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline7 != null) {
                                    i = R.id.guideline_pm_stage_3_vertical_1;
                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline8 != null) {
                                        i = R.id.guideline_pm_stage_3_vertical_2;
                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline9 != null) {
                                            i = R.id.pm_image;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView != null) {
                                                i = R.id.pm_touch_area_stage_1;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (relativeLayout != null) {
                                                    i = R.id.pm_touch_area_stage_2;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.pm_touch_area_stage_3;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (relativeLayout3 != null) {
                                                            return new BlueprintLayoutPmBinding((ConstraintLayout) rootView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, imageView, relativeLayout, relativeLayout2, relativeLayout3);
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
