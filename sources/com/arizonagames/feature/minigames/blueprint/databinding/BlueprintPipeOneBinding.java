package com.arizonagames.feature.minigames.blueprint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.blueprint.R;
/* loaded from: classes3.dex */
public final class BlueprintPipeOneBinding implements ViewBinding {
    public final ImageView ivDrawing;
    private final ConstraintLayout rootView;
    public final Guideline stageFiveStart;
    public final Guideline stageFourEnd;
    public final Guideline stageOneBottom;
    public final Guideline stageOneEnd;
    public final Guideline stageOneStart;
    public final Guideline stageOneTop;
    public final Guideline stageThreeBottom;
    public final Guideline stageThreeEnd;
    public final Guideline stageThreeTop;
    public final Guideline stageTwoBottom;
    public final Guideline stageTwoStart;
    public final FrameLayout touchFive;
    public final FrameLayout touchFour;
    public final FrameLayout touchOne;
    public final FrameLayout touchThree;
    public final FrameLayout touchTwo;

    private BlueprintPipeOneBinding(ConstraintLayout constraintLayout, ImageView imageView, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5) {
        this.rootView = constraintLayout;
        this.ivDrawing = imageView;
        this.stageFiveStart = guideline;
        this.stageFourEnd = guideline2;
        this.stageOneBottom = guideline3;
        this.stageOneEnd = guideline4;
        this.stageOneStart = guideline5;
        this.stageOneTop = guideline6;
        this.stageThreeBottom = guideline7;
        this.stageThreeEnd = guideline8;
        this.stageThreeTop = guideline9;
        this.stageTwoBottom = guideline10;
        this.stageTwoStart = guideline11;
        this.touchFive = frameLayout;
        this.touchFour = frameLayout2;
        this.touchOne = frameLayout3;
        this.touchThree = frameLayout4;
        this.touchTwo = frameLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintPipeOneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintPipeOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_pipe_one, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintPipeOneBinding bind(View view) {
        int i = R.id.iv_drawing;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.stage_five_start;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.stage_four_end;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline2 != null) {
                    i = R.id.stage_one_bottom;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline3 != null) {
                        i = R.id.stage_one_end;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline4 != null) {
                            i = R.id.stage_one_start;
                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline5 != null) {
                                i = R.id.stage_one_top;
                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline6 != null) {
                                    i = R.id.stage_three_bottom;
                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline7 != null) {
                                        i = R.id.stage_three_end;
                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline8 != null) {
                                            i = R.id.stage_three_top;
                                            Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline9 != null) {
                                                i = R.id.stage_two_bottom;
                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline10 != null) {
                                                    i = R.id.stage_two_start;
                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline11 != null) {
                                                        i = R.id.touch_five;
                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                        if (frameLayout != null) {
                                                            i = R.id.touch_four;
                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                            if (frameLayout2 != null) {
                                                                i = R.id.touch_one;
                                                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                if (frameLayout3 != null) {
                                                                    i = R.id.touch_three;
                                                                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (frameLayout4 != null) {
                                                                        i = R.id.touch_two;
                                                                        FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (frameLayout5 != null) {
                                                                            return new BlueprintPipeOneBinding((ConstraintLayout) view, imageView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
