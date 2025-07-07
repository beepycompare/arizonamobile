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

    private BlueprintPipeOneBinding(ConstraintLayout rootView, ImageView ivDrawing, Guideline stageFiveStart, Guideline stageFourEnd, Guideline stageOneBottom, Guideline stageOneEnd, Guideline stageOneStart, Guideline stageOneTop, Guideline stageThreeBottom, Guideline stageThreeEnd, Guideline stageThreeTop, Guideline stageTwoBottom, Guideline stageTwoStart, FrameLayout touchFive, FrameLayout touchFour, FrameLayout touchOne, FrameLayout touchThree, FrameLayout touchTwo) {
        this.rootView = rootView;
        this.ivDrawing = ivDrawing;
        this.stageFiveStart = stageFiveStart;
        this.stageFourEnd = stageFourEnd;
        this.stageOneBottom = stageOneBottom;
        this.stageOneEnd = stageOneEnd;
        this.stageOneStart = stageOneStart;
        this.stageOneTop = stageOneTop;
        this.stageThreeBottom = stageThreeBottom;
        this.stageThreeEnd = stageThreeEnd;
        this.stageThreeTop = stageThreeTop;
        this.stageTwoBottom = stageTwoBottom;
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

    public static BlueprintPipeOneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintPipeOneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_pipe_one, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintPipeOneBinding bind(View rootView) {
        int i = R.id.iv_drawing;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.stage_five_start;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.stage_four_end;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.stage_one_bottom;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline3 != null) {
                        i = R.id.stage_one_end;
                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline4 != null) {
                            i = R.id.stage_one_start;
                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline5 != null) {
                                i = R.id.stage_one_top;
                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline6 != null) {
                                    i = R.id.stage_three_bottom;
                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline7 != null) {
                                        i = R.id.stage_three_end;
                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline8 != null) {
                                            i = R.id.stage_three_top;
                                            Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline9 != null) {
                                                i = R.id.stage_two_bottom;
                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline10 != null) {
                                                    i = R.id.stage_two_start;
                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline11 != null) {
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
                                                                            return new BlueprintPipeOneBinding((ConstraintLayout) rootView, imageView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5);
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
