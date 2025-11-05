package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaQuestScreenBinding implements ViewBinding {
    public final TextView emptyQuestTitle;
    public final AppCompatImageView rodinaExitButton;
    public final TextView rodinaExitTitle;
    public final ConstraintLayout rodinaLicensePlatesBackgroundHeader;
    public final RecyclerView rodinaQuestAwards;
    public final ConstraintLayout rodinaQuestAwardsButton;
    public final TextView rodinaQuestAwardsButtonText;
    public final ConstraintLayout rodinaQuestAwardsCancelButton;
    public final TextView rodinaQuestAwardsCancelButtonText;
    public final ConstraintLayout rodinaQuestAwardsContainer;
    public final AppCompatImageView rodinaQuestAwardsIcon;
    public final TextView rodinaQuestAwardsTittle;
    public final TextView rodinaQuestContractDescription;
    public final ConstraintLayout rodinaQuestInfoContainer;
    public final TextView rodinaQuestInfoDescription;
    public final TextView rodinaQuestInfoTitle;
    public final ProgressBar rodinaQuestProgress;
    public final ConstraintLayout rodinaQuestScreen;
    public final ConstraintLayout rodinaQuestStatContainer;
    public final AppCompatImageView rodinaQuestStatGlow;
    public final TextView rodinaQuestStatText;
    public final TextView rodinaQuestTitle;
    public final RecyclerView rodinaQuests;
    private final ConstraintLayout rootView;
    public final TextView textAwardAz;
    public final TextView textProgress;

    private RodinaQuestScreenBinding(ConstraintLayout rootView, TextView emptyQuestTitle, AppCompatImageView rodinaExitButton, TextView rodinaExitTitle, ConstraintLayout rodinaLicensePlatesBackgroundHeader, RecyclerView rodinaQuestAwards, ConstraintLayout rodinaQuestAwardsButton, TextView rodinaQuestAwardsButtonText, ConstraintLayout rodinaQuestAwardsCancelButton, TextView rodinaQuestAwardsCancelButtonText, ConstraintLayout rodinaQuestAwardsContainer, AppCompatImageView rodinaQuestAwardsIcon, TextView rodinaQuestAwardsTittle, TextView rodinaQuestContractDescription, ConstraintLayout rodinaQuestInfoContainer, TextView rodinaQuestInfoDescription, TextView rodinaQuestInfoTitle, ProgressBar rodinaQuestProgress, ConstraintLayout rodinaQuestScreen, ConstraintLayout rodinaQuestStatContainer, AppCompatImageView rodinaQuestStatGlow, TextView rodinaQuestStatText, TextView rodinaQuestTitle, RecyclerView rodinaQuests, TextView textAwardAz, TextView textProgress) {
        this.rootView = rootView;
        this.emptyQuestTitle = emptyQuestTitle;
        this.rodinaExitButton = rodinaExitButton;
        this.rodinaExitTitle = rodinaExitTitle;
        this.rodinaLicensePlatesBackgroundHeader = rodinaLicensePlatesBackgroundHeader;
        this.rodinaQuestAwards = rodinaQuestAwards;
        this.rodinaQuestAwardsButton = rodinaQuestAwardsButton;
        this.rodinaQuestAwardsButtonText = rodinaQuestAwardsButtonText;
        this.rodinaQuestAwardsCancelButton = rodinaQuestAwardsCancelButton;
        this.rodinaQuestAwardsCancelButtonText = rodinaQuestAwardsCancelButtonText;
        this.rodinaQuestAwardsContainer = rodinaQuestAwardsContainer;
        this.rodinaQuestAwardsIcon = rodinaQuestAwardsIcon;
        this.rodinaQuestAwardsTittle = rodinaQuestAwardsTittle;
        this.rodinaQuestContractDescription = rodinaQuestContractDescription;
        this.rodinaQuestInfoContainer = rodinaQuestInfoContainer;
        this.rodinaQuestInfoDescription = rodinaQuestInfoDescription;
        this.rodinaQuestInfoTitle = rodinaQuestInfoTitle;
        this.rodinaQuestProgress = rodinaQuestProgress;
        this.rodinaQuestScreen = rodinaQuestScreen;
        this.rodinaQuestStatContainer = rodinaQuestStatContainer;
        this.rodinaQuestStatGlow = rodinaQuestStatGlow;
        this.rodinaQuestStatText = rodinaQuestStatText;
        this.rodinaQuestTitle = rodinaQuestTitle;
        this.rodinaQuests = rodinaQuests;
        this.textAwardAz = textAwardAz;
        this.textProgress = textProgress;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RodinaQuestScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaQuestScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_quest_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaQuestScreenBinding bind(View rootView) {
        int i = R.id.empty_quest_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.rodina_exit_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.rodina_exit_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.rodina_license_plates_background_header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout != null) {
                        i = R.id.rodina_quest_awards;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.rodina_quest_awards_button;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout2 != null) {
                                i = R.id.rodina_quest_awards_button_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.rodina_quest_awards_cancel_button;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.rodina_quest_awards_cancel_button_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.rodina_quest_awards_container;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.rodina_quest_awards_icon;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatImageView2 != null) {
                                                    i = R.id.rodina_quest_awards_tittle;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.rodina_quest_contract_description;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView6 != null) {
                                                            i = R.id.rodina_quest_info_container;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.rodina_quest_info_description;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.rodina_quest_info_title;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.rodina_quest_progress;
                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                        if (progressBar != null) {
                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) rootView;
                                                                            i = R.id.rodina_quest_stat_container;
                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (constraintLayout7 != null) {
                                                                                i = R.id.rodina_quest_stat_glow;
                                                                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (appCompatImageView3 != null) {
                                                                                    i = R.id.rodina_quest_stat_text;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.rodina_quest_title;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.rodina_quests;
                                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (recyclerView2 != null) {
                                                                                                i = R.id.text_award_az;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.textProgress;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView12 != null) {
                                                                                                        return new RodinaQuestScreenBinding(constraintLayout6, textView, appCompatImageView, textView2, constraintLayout, recyclerView, constraintLayout2, textView3, constraintLayout3, textView4, constraintLayout4, appCompatImageView2, textView5, textView6, constraintLayout5, textView7, textView8, progressBar, constraintLayout6, constraintLayout7, appCompatImageView3, textView9, textView10, recyclerView2, textView11, textView12);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
