package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class PassGradeViewBinding implements ViewBinding {
    public final TextView awardPrice;
    public final Button claimBottom;
    public final Button claimTop;
    public final TextView gradeNum;
    public final Guideline guideline10;
    public final Guideline guideline12;
    public final Guideline guideline7;
    public final Guideline guideline8;
    public final Guideline guideline9;
    public final AppCompatImageView imageView5;
    public final AppCompatImageView premiumAwardImage;
    public final TextView premiumAwardTitle;
    public final View progressBar;
    public final Space progressSpace;
    public final AppCompatImageView receiveArrow;
    private final ConstraintLayout rootView;
    public final AppCompatImageView standardAwardImage;
    public final TextView standardAwardTitle;

    private PassGradeViewBinding(ConstraintLayout constraintLayout, TextView textView, Button button, Button button2, TextView textView2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView3, View view, Space space, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, TextView textView4) {
        this.rootView = constraintLayout;
        this.awardPrice = textView;
        this.claimBottom = button;
        this.claimTop = button2;
        this.gradeNum = textView2;
        this.guideline10 = guideline;
        this.guideline12 = guideline2;
        this.guideline7 = guideline3;
        this.guideline8 = guideline4;
        this.guideline9 = guideline5;
        this.imageView5 = appCompatImageView;
        this.premiumAwardImage = appCompatImageView2;
        this.premiumAwardTitle = textView3;
        this.progressBar = view;
        this.progressSpace = space;
        this.receiveArrow = appCompatImageView3;
        this.standardAwardImage = appCompatImageView4;
        this.standardAwardTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PassGradeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PassGradeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pass_grade_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PassGradeViewBinding bind(View view) {
        View findChildViewById;
        int i = R.id.award_price;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.claimBottom;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.claimTop;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = R.id.grade_num;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.guideline10;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null) {
                            i = R.id.guideline12;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline2 != null) {
                                i = R.id.guideline7;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.guideline8;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline4 != null) {
                                        i = R.id.guideline9;
                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline5 != null) {
                                            i = R.id.imageView5;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatImageView != null) {
                                                i = R.id.premium_award_image;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                if (appCompatImageView2 != null) {
                                                    i = R.id.premium_award_title;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.progress_bar))) != null) {
                                                        i = R.id.progress_space;
                                                        Space space = (Space) ViewBindings.findChildViewById(view, i);
                                                        if (space != null) {
                                                            i = R.id.receive_arrow;
                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                            if (appCompatImageView3 != null) {
                                                                i = R.id.standard_award_image;
                                                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                if (appCompatImageView4 != null) {
                                                                    i = R.id.standard_award_title;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        return new PassGradeViewBinding((ConstraintLayout) view, textView, button, button2, textView2, guideline, guideline2, guideline3, guideline4, guideline5, appCompatImageView, appCompatImageView2, textView3, findChildViewById, space, appCompatImageView3, appCompatImageView4, textView4);
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
