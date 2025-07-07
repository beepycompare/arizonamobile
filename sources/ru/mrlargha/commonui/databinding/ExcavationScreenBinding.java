package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ExcavationScreenBinding implements ViewBinding {
    public final ConstraintLayout rodinaExcavation;
    public final TextView rodinaExcavationDescription;
    public final ConstraintLayout rodinaExcavationHeader;
    public final ConstraintLayout rodinaExcavationInfo;
    public final TextView rodinaExcavationInfoDescription;
    public final AppCompatImageView rodinaExcavationInfoIcon;
    public final ProgressBar rodinaExcavationProgress;
    public final AppCompatImageView rodinaExcavationProgressButton;
    public final ConstraintLayout rodinaExcavationProgressContainer;
    public final ConstraintLayout rodinaExcavationProgressDoneButton;
    public final TextView rodinaExcavationProgressDoneText;
    public final TextView rodinaHeaderTitle;
    private final ConstraintLayout rootView;

    private ExcavationScreenBinding(ConstraintLayout rootView, ConstraintLayout rodinaExcavation, TextView rodinaExcavationDescription, ConstraintLayout rodinaExcavationHeader, ConstraintLayout rodinaExcavationInfo, TextView rodinaExcavationInfoDescription, AppCompatImageView rodinaExcavationInfoIcon, ProgressBar rodinaExcavationProgress, AppCompatImageView rodinaExcavationProgressButton, ConstraintLayout rodinaExcavationProgressContainer, ConstraintLayout rodinaExcavationProgressDoneButton, TextView rodinaExcavationProgressDoneText, TextView rodinaHeaderTitle) {
        this.rootView = rootView;
        this.rodinaExcavation = rodinaExcavation;
        this.rodinaExcavationDescription = rodinaExcavationDescription;
        this.rodinaExcavationHeader = rodinaExcavationHeader;
        this.rodinaExcavationInfo = rodinaExcavationInfo;
        this.rodinaExcavationInfoDescription = rodinaExcavationInfoDescription;
        this.rodinaExcavationInfoIcon = rodinaExcavationInfoIcon;
        this.rodinaExcavationProgress = rodinaExcavationProgress;
        this.rodinaExcavationProgressButton = rodinaExcavationProgressButton;
        this.rodinaExcavationProgressContainer = rodinaExcavationProgressContainer;
        this.rodinaExcavationProgressDoneButton = rodinaExcavationProgressDoneButton;
        this.rodinaExcavationProgressDoneText = rodinaExcavationProgressDoneText;
        this.rodinaHeaderTitle = rodinaHeaderTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ExcavationScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExcavationScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.excavation_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ExcavationScreenBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.rodina_excavation_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.rodina_excavation_header;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.rodina_excavation_info;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout3 != null) {
                    i = R.id.rodina_excavation_info_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.rodina_excavation_info_icon;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView != null) {
                            i = R.id.rodina_excavation_progress;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                            if (progressBar != null) {
                                i = R.id.rodina_excavation_progress_button;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatImageView2 != null) {
                                    i = R.id.rodina_excavation_progress_container;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.rodina_excavation_progress_done_button;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout5 != null) {
                                            i = R.id.rodina_excavation_progress_done_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.rodina_header_title;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    return new ExcavationScreenBinding(constraintLayout, constraintLayout, textView, constraintLayout2, constraintLayout3, textView2, appCompatImageView, progressBar, appCompatImageView2, constraintLayout4, constraintLayout5, textView3, textView4);
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
