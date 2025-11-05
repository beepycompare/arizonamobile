package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BlueprintPipeFiveBinding implements ViewBinding {
    public final ImageView ivDrawing;
    private final ConstraintLayout rootView;
    public final Guideline stageFiveStart;
    public final Guideline stageFiveTop;
    public final Guideline stageFourEnd;
    public final Guideline stageFourStart;
    public final Guideline stageOneBottom;
    public final Guideline stageOneEnd;
    public final Guideline stageOneStart;
    public final Guideline stageOneTop;
    public final Guideline stageThreeBottom;
    public final Guideline stageThreeStart;
    public final Guideline stageTwoBottom;
    public final Guideline stageTwoEnd;
    public final Guideline stageTwoStart;
    public final FrameLayout touchFive;
    public final FrameLayout touchFour;
    public final FrameLayout touchOne;
    public final FrameLayout touchThree;
    public final FrameLayout touchTwo;

    private BlueprintPipeFiveBinding(ConstraintLayout rootView, ImageView ivDrawing, Guideline stageFiveStart, Guideline stageFiveTop, Guideline stageFourEnd, Guideline stageFourStart, Guideline stageOneBottom, Guideline stageOneEnd, Guideline stageOneStart, Guideline stageOneTop, Guideline stageThreeBottom, Guideline stageThreeStart, Guideline stageTwoBottom, Guideline stageTwoEnd, Guideline stageTwoStart, FrameLayout touchFive, FrameLayout touchFour, FrameLayout touchOne, FrameLayout touchThree, FrameLayout touchTwo) {
        this.rootView = rootView;
        this.ivDrawing = ivDrawing;
        this.stageFiveStart = stageFiveStart;
        this.stageFiveTop = stageFiveTop;
        this.stageFourEnd = stageFourEnd;
        this.stageFourStart = stageFourStart;
        this.stageOneBottom = stageOneBottom;
        this.stageOneEnd = stageOneEnd;
        this.stageOneStart = stageOneStart;
        this.stageOneTop = stageOneTop;
        this.stageThreeBottom = stageThreeBottom;
        this.stageThreeStart = stageThreeStart;
        this.stageTwoBottom = stageTwoBottom;
        this.stageTwoEnd = stageTwoEnd;
        this.stageTwoStart = stageTwoStart;
        this.touchFive = touchFive;
        this.touchFour = touchFour;
        this.touchOne = touchOne;
        this.touchThree = touchThree;
        this.touchTwo = touchTwo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintPipeFiveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintPipeFiveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_pipe_five, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintPipeFiveBinding bind(View rootView) {
        int i = R.id.iv_drawing;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.stage_five_start;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.stage_five_top;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.stage_four_end;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline3 != null) {
                        i = R.id.stage_four_start;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline4 != null) {
                            i = R.id.stage_one_bottom;
                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline5 != null) {
                                i = R.id.stage_one_end;
                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline6 != null) {
                                    i = R.id.stage_one_start;
                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline7 != null) {
                                        i = R.id.stage_one_top;
                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline8 != null) {
                                            i = R.id.stage_three_bottom;
                                            Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline9 != null) {
                                                i = R.id.stage_three_start;
                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline10 != null) {
                                                    i = R.id.stage_two_bottom;
                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline11 != null) {
                                                        i = R.id.stage_two_end;
                                                        Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                        if (guideline12 != null) {
                                                            i = R.id.stage_two_start;
                                                            Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline13 != null) {
                                                                i = R.id.touch_five;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (frameLayout != null) {
                                                                    i = R.id.touch_four;
                                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (frameLayout2 != null) {
                                                                        i = R.id.touch_one;
                                                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (frameLayout3 != null) {
                                                                            i = R.id.touch_three;
                                                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (frameLayout4 != null) {
                                                                                i = R.id.touch_two;
                                                                                FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (frameLayout5 != null) {
                                                                                    return new BlueprintPipeFiveBinding((ConstraintLayout) rootView, imageView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, guideline13, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
