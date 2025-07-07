package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class GameMenuBinding implements ViewBinding {
    public final RelativeLayout elementAnimations;
    public final RelativeLayout elementAwards;
    public final RelativeLayout elementDonate;
    public final RelativeLayout elementEmploymentHistory;
    public final RelativeLayout elementHelp;
    public final RelativeLayout elementNavigator;
    public final RelativeLayout elementPersonStatistic;
    public final TextView elementPersonStatisticTitle;
    public final RelativeLayout elementQuests;
    public final RelativeLayout elementSettings;
    public final RelativeLayout elementSkills;
    public final LinearLayout levelContainer;
    public final ProgressBar levelProgress;
    public final TextView levelText;
    public final ConstraintLayout menuLayout;
    public final TextView nickname;
    private final ConstraintLayout rootView;
    public final ScrollView scrollContainer;

    private GameMenuBinding(ConstraintLayout rootView, RelativeLayout elementAnimations, RelativeLayout elementAwards, RelativeLayout elementDonate, RelativeLayout elementEmploymentHistory, RelativeLayout elementHelp, RelativeLayout elementNavigator, RelativeLayout elementPersonStatistic, TextView elementPersonStatisticTitle, RelativeLayout elementQuests, RelativeLayout elementSettings, RelativeLayout elementSkills, LinearLayout levelContainer, ProgressBar levelProgress, TextView levelText, ConstraintLayout menuLayout, TextView nickname, ScrollView scrollContainer) {
        this.rootView = rootView;
        this.elementAnimations = elementAnimations;
        this.elementAwards = elementAwards;
        this.elementDonate = elementDonate;
        this.elementEmploymentHistory = elementEmploymentHistory;
        this.elementHelp = elementHelp;
        this.elementNavigator = elementNavigator;
        this.elementPersonStatistic = elementPersonStatistic;
        this.elementPersonStatisticTitle = elementPersonStatisticTitle;
        this.elementQuests = elementQuests;
        this.elementSettings = elementSettings;
        this.elementSkills = elementSkills;
        this.levelContainer = levelContainer;
        this.levelProgress = levelProgress;
        this.levelText = levelText;
        this.menuLayout = menuLayout;
        this.nickname = nickname;
        this.scrollContainer = scrollContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GameMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static GameMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.game_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static GameMenuBinding bind(View rootView) {
        int i = R.id.element_animations;
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
                                            i = R.id.element_settings;
                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (relativeLayout9 != null) {
                                                i = R.id.element_skills;
                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (relativeLayout10 != null) {
                                                    i = R.id.level_container;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout != null) {
                                                        i = R.id.level_progress;
                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                        if (progressBar != null) {
                                                            i = R.id.level_text;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView2 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                i = R.id.nickname;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.scroll_container;
                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (scrollView != null) {
                                                                        return new GameMenuBinding(constraintLayout, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, textView, relativeLayout8, relativeLayout9, relativeLayout10, linearLayout, progressBar, textView2, constraintLayout, textView3, scrollView);
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
