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
public final class BlueprintPipeTwoBinding implements ViewBinding {
    public final ImageView ivDrawing;
    private final ConstraintLayout rootView;
    public final Guideline stageFiveBottom;
    public final Guideline stageFiveEnd;
    public final Guideline stageFiveStart;
    public final Guideline stageFiveTop;
    public final Guideline stageFourBottom;
    public final Guideline stageFourEnd;
    public final Guideline stageFourStart;
    public final Guideline stageOneBottom;
    public final Guideline stageOneEnd;
    public final Guideline stageOneStart;
    public final Guideline stageOneTop;
    public final Guideline stageThreeEnd;
    public final Guideline stageThreeStart;
    public final Guideline stageThreeTop;
    public final Guideline stageTwoBottom;
    public final Guideline stageTwoEnd;
    public final Guideline stageTwoStart;
    public final Guideline stageTwoTop;
    public final FrameLayout touchFive;
    public final FrameLayout touchFour;
    public final FrameLayout touchOne;
    public final FrameLayout touchThree;
    public final FrameLayout touchTwo;

    private BlueprintPipeTwoBinding(ConstraintLayout constraintLayout, ImageView imageView, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13, Guideline guideline14, Guideline guideline15, Guideline guideline16, Guideline guideline17, Guideline guideline18, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5) {
        this.rootView = constraintLayout;
        this.ivDrawing = imageView;
        this.stageFiveBottom = guideline;
        this.stageFiveEnd = guideline2;
        this.stageFiveStart = guideline3;
        this.stageFiveTop = guideline4;
        this.stageFourBottom = guideline5;
        this.stageFourEnd = guideline6;
        this.stageFourStart = guideline7;
        this.stageOneBottom = guideline8;
        this.stageOneEnd = guideline9;
        this.stageOneStart = guideline10;
        this.stageOneTop = guideline11;
        this.stageThreeEnd = guideline12;
        this.stageThreeStart = guideline13;
        this.stageThreeTop = guideline14;
        this.stageTwoBottom = guideline15;
        this.stageTwoEnd = guideline16;
        this.stageTwoStart = guideline17;
        this.stageTwoTop = guideline18;
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

    public static BlueprintPipeTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintPipeTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_pipe_two, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintPipeTwoBinding bind(View view) {
        int i = R.id.iv_drawing;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.stage_five_bottom;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.stage_five_end;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline2 != null) {
                    i = R.id.stage_five_start;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline3 != null) {
                        i = R.id.stage_five_top;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline4 != null) {
                            i = R.id.stage_four_bottom;
                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline5 != null) {
                                i = R.id.stage_four_end;
                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline6 != null) {
                                    i = R.id.stage_four_start;
                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline7 != null) {
                                        i = R.id.stage_one_bottom;
                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline8 != null) {
                                            i = R.id.stage_one_end;
                                            Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline9 != null) {
                                                i = R.id.stage_one_start;
                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline10 != null) {
                                                    i = R.id.stage_one_top;
                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline11 != null) {
                                                        i = R.id.stage_three_end;
                                                        Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline12 != null) {
                                                            i = R.id.stage_three_start;
                                                            Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline13 != null) {
                                                                i = R.id.stage_three_top;
                                                                Guideline guideline14 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline14 != null) {
                                                                    i = R.id.stage_two_bottom;
                                                                    Guideline guideline15 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline15 != null) {
                                                                        i = R.id.stage_two_end;
                                                                        Guideline guideline16 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline16 != null) {
                                                                            i = R.id.stage_two_start;
                                                                            Guideline guideline17 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline17 != null) {
                                                                                i = R.id.stage_two_top;
                                                                                Guideline guideline18 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                if (guideline18 != null) {
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
                                                                                                        return new BlueprintPipeTwoBinding((ConstraintLayout) view, imageView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, guideline13, guideline14, guideline15, guideline16, guideline17, guideline18, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5);
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
