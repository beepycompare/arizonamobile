package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class IngamemenuBinding implements ViewBinding {
    public final AppCompatImageView closeImage;
    public final RelativeLayout elementAnimations;
    public final RelativeLayout elementAwards;
    public final RelativeLayout elementDonate;
    public final RelativeLayout elementEmploymentHistory;
    public final RelativeLayout elementHelp;
    public final RelativeLayout elementNavigator;
    public final RelativeLayout elementPersonStatistic;
    public final TextView elementPersonStatisticTitle;
    public final RelativeLayout elementQuests;
    public final TextView elementQuestsText;
    public final RelativeLayout elementSettings;
    public final RelativeLayout elementSkills;
    public final Guideline guidelineAwardsVertical;
    public final Guideline guidelineHelpVertical;
    public final Guideline guidelinePersonHorizontal;
    public final Guideline guidelinePersonHorizontalMargin;
    public final Guideline guidelinePersonVertical;
    public final Guideline guidelinePersonVerticalMargin;
    public final Guideline guidelineQuestsVertical;
    public final Guideline guidelineQuestsVerticalMargin;
    public final Guideline guidelineSkillHorizontal;
    public final Guideline guidelineSkillHorizontalMargin;
    public final Guideline guidelineSkillsVertical;
    public final Guideline guidelineSkillsVerticalMargin;
    public final LinearLayout levelContainer;
    public final ProgressBar levelProgress;
    public final TextView levelText;
    public final ConstraintLayout menuLayout;
    public final TextView nickname;
    public final View personSpacer;
    public final LinearLayout personStatisticContainer;
    public final ProgressBar personStatisticLoader;
    private final ConstraintLayout rootView;

    private IngamemenuBinding(ConstraintLayout rootView, AppCompatImageView closeImage, RelativeLayout elementAnimations, RelativeLayout elementAwards, RelativeLayout elementDonate, RelativeLayout elementEmploymentHistory, RelativeLayout elementHelp, RelativeLayout elementNavigator, RelativeLayout elementPersonStatistic, TextView elementPersonStatisticTitle, RelativeLayout elementQuests, TextView elementQuestsText, RelativeLayout elementSettings, RelativeLayout elementSkills, Guideline guidelineAwardsVertical, Guideline guidelineHelpVertical, Guideline guidelinePersonHorizontal, Guideline guidelinePersonHorizontalMargin, Guideline guidelinePersonVertical, Guideline guidelinePersonVerticalMargin, Guideline guidelineQuestsVertical, Guideline guidelineQuestsVerticalMargin, Guideline guidelineSkillHorizontal, Guideline guidelineSkillHorizontalMargin, Guideline guidelineSkillsVertical, Guideline guidelineSkillsVerticalMargin, LinearLayout levelContainer, ProgressBar levelProgress, TextView levelText, ConstraintLayout menuLayout, TextView nickname, View personSpacer, LinearLayout personStatisticContainer, ProgressBar personStatisticLoader) {
        this.rootView = rootView;
        this.closeImage = closeImage;
        this.elementAnimations = elementAnimations;
        this.elementAwards = elementAwards;
        this.elementDonate = elementDonate;
        this.elementEmploymentHistory = elementEmploymentHistory;
        this.elementHelp = elementHelp;
        this.elementNavigator = elementNavigator;
        this.elementPersonStatistic = elementPersonStatistic;
        this.elementPersonStatisticTitle = elementPersonStatisticTitle;
        this.elementQuests = elementQuests;
        this.elementQuestsText = elementQuestsText;
        this.elementSettings = elementSettings;
        this.elementSkills = elementSkills;
        this.guidelineAwardsVertical = guidelineAwardsVertical;
        this.guidelineHelpVertical = guidelineHelpVertical;
        this.guidelinePersonHorizontal = guidelinePersonHorizontal;
        this.guidelinePersonHorizontalMargin = guidelinePersonHorizontalMargin;
        this.guidelinePersonVertical = guidelinePersonVertical;
        this.guidelinePersonVerticalMargin = guidelinePersonVerticalMargin;
        this.guidelineQuestsVertical = guidelineQuestsVertical;
        this.guidelineQuestsVerticalMargin = guidelineQuestsVerticalMargin;
        this.guidelineSkillHorizontal = guidelineSkillHorizontal;
        this.guidelineSkillHorizontalMargin = guidelineSkillHorizontalMargin;
        this.guidelineSkillsVertical = guidelineSkillsVertical;
        this.guidelineSkillsVerticalMargin = guidelineSkillsVerticalMargin;
        this.levelContainer = levelContainer;
        this.levelProgress = levelProgress;
        this.levelText = levelText;
        this.menuLayout = menuLayout;
        this.nickname = nickname;
        this.personSpacer = personSpacer;
        this.personStatisticContainer = personStatisticContainer;
        this.personStatisticLoader = personStatisticLoader;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IngamemenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IngamemenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.ingamemenu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static IngamemenuBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.closeImage;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.element_animations;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
            if (relativeLayout != null) {
                i = R.id.element_awards;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                if (relativeLayout2 != null) {
                    i = R.id.element_donate;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                    if (relativeLayout3 != null) {
                        i = R.id.element_employment_history;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                        if (relativeLayout4 != null) {
                            i = R.id.element_help;
                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                            if (relativeLayout5 != null) {
                                i = R.id.element_navigator;
                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                if (relativeLayout6 != null) {
                                    i = R.id.element_person_statistic;
                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (relativeLayout7 != null) {
                                        i = R.id.element_person_statistic_title;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.element_quests;
                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (relativeLayout8 != null) {
                                                i = R.id.element_quests_text;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView2 != null) {
                                                    i = R.id.element_settings;
                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (relativeLayout9 != null) {
                                                        i = R.id.element_skills;
                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (relativeLayout10 != null) {
                                                            i = R.id.guideline_awards_vertical;
                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                            if (guideline != null) {
                                                                i = R.id.guideline_help_vertical;
                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline2 != null) {
                                                                    i = R.id.guideline_person_horizontal;
                                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline3 != null) {
                                                                        i = R.id.guideline_person_horizontal_margin;
                                                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                        if (guideline4 != null) {
                                                                            i = R.id.guideline_person_vertical;
                                                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                            if (guideline5 != null) {
                                                                                i = R.id.guideline_person_vertical_margin;
                                                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                if (guideline6 != null) {
                                                                                    i = R.id.guideline_quests_vertical;
                                                                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (guideline7 != null) {
                                                                                        i = R.id.guideline_quests_vertical_margin;
                                                                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (guideline8 != null) {
                                                                                            i = R.id.guideline_skill_horizontal;
                                                                                            Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (guideline9 != null) {
                                                                                                i = R.id.guideline_skill_horizontal_margin;
                                                                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (guideline10 != null) {
                                                                                                    i = R.id.guideline_skills_vertical;
                                                                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (guideline11 != null) {
                                                                                                        i = R.id.guideline_skills_vertical_margin;
                                                                                                        Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (guideline12 != null) {
                                                                                                            i = R.id.level_container;
                                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (linearLayout != null) {
                                                                                                                i = R.id.level_progress;
                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (progressBar != null) {
                                                                                                                    i = R.id.level_text;
                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (textView3 != null) {
                                                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                                                                        i = R.id.nickname;
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.person_spacer))) != null) {
                                                                                                                            i = R.id.person_statistic_container;
                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                i = R.id.person_statistic_loader;
                                                                                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (progressBar2 != null) {
                                                                                                                                    return new IngamemenuBinding(constraintLayout, appCompatImageView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, textView, relativeLayout8, textView2, relativeLayout9, relativeLayout10, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, linearLayout, progressBar, textView3, constraintLayout, textView4, findChildViewById, linearLayout2, progressBar2);
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
