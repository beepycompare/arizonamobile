package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudProposalScreenBinding implements ViewBinding {
    public final AppCompatImageView proposalAcceptBtn;
    public final AppCompatImageView proposalDeclineBtn;
    public final TextView proposalId;
    public final ConstraintLayout proposalInfoContainer;
    public final Guideline proposalLeftVLine;
    public final TextView proposalNickname;
    public final ProgressBar proposalProgress;
    public final Guideline proposalRightVLine;
    public final TextView proposalTitle;
    public final AppCompatImageView rodinaProposalBg;
    public final ConstraintLayout rodinaProposalContainer;
    public final ConstraintLayout rodinaProposalScreen;
    private final ConstraintLayout rootView;

    private HudProposalScreenBinding(ConstraintLayout rootView, AppCompatImageView proposalAcceptBtn, AppCompatImageView proposalDeclineBtn, TextView proposalId, ConstraintLayout proposalInfoContainer, Guideline proposalLeftVLine, TextView proposalNickname, ProgressBar proposalProgress, Guideline proposalRightVLine, TextView proposalTitle, AppCompatImageView rodinaProposalBg, ConstraintLayout rodinaProposalContainer, ConstraintLayout rodinaProposalScreen) {
        this.rootView = rootView;
        this.proposalAcceptBtn = proposalAcceptBtn;
        this.proposalDeclineBtn = proposalDeclineBtn;
        this.proposalId = proposalId;
        this.proposalInfoContainer = proposalInfoContainer;
        this.proposalLeftVLine = proposalLeftVLine;
        this.proposalNickname = proposalNickname;
        this.proposalProgress = proposalProgress;
        this.proposalRightVLine = proposalRightVLine;
        this.proposalTitle = proposalTitle;
        this.rodinaProposalBg = rodinaProposalBg;
        this.rodinaProposalContainer = rodinaProposalContainer;
        this.rodinaProposalScreen = rodinaProposalScreen;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HudProposalScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudProposalScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_proposal_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudProposalScreenBinding bind(View rootView) {
        int i = R.id.proposal_accept_btn;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.proposal_decline_btn;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView2 != null) {
                i = R.id.proposal_id;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.proposal_info_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout != null) {
                        i = R.id.proposal_left_v_line;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline != null) {
                            i = R.id.proposal_nickname;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.proposal_progress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                if (progressBar != null) {
                                    i = R.id.proposal_right_v_line;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline2 != null) {
                                        i = R.id.proposal_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.rodina_proposal_bg;
                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (appCompatImageView3 != null) {
                                                i = R.id.rodina_proposal_container;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (constraintLayout2 != null) {
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                                    return new HudProposalScreenBinding(constraintLayout3, appCompatImageView, appCompatImageView2, textView, constraintLayout, guideline, textView2, progressBar, guideline2, textView3, appCompatImageView3, constraintLayout2, constraintLayout3);
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
