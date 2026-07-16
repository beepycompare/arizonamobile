package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassPinkTasksLayoutBinding implements ViewBinding {
    public final CustomCardView rodinaTasksBuyPremiumLockButton;
    public final LinearLayout rodinaTasksCategories;
    public final CustomCardView rodinaTasksClaimButton;
    public final FrameLayout rodinaTasksCurrentTaskContainer;
    public final CustomCardView rodinaTasksDailyButton;
    public final TextView rodinaTasksDailyText;
    public final LinearLayout rodinaTasksEmptyState;
    public final TextView rodinaTasksInfoCount;
    public final TextView rodinaTasksInfoDescription;
    public final LinearLayout rodinaTasksInfoDoneContainer;
    public final TextView rodinaTasksInfoPercent;
    public final ProgressBar rodinaTasksInfoProgress;
    public final TextView rodinaTasksInfoTitle;
    public final RecyclerView rodinaTasksList;
    public final LinearLayout rodinaTasksPageRoot;
    public final CustomCardView rodinaTasksPremiumButton;
    public final CustomCardView rodinaTasksPremiumLockContainer;
    public final TextView rodinaTasksPremiumText;
    public final CustomCardView rodinaTasksRemainingTimeContainer;
    public final TextView rodinaTasksRemainingTimeText;
    public final CustomCardView rodinaTasksResetContainer;
    public final TextView rodinaTasksResetTimeText;
    public final RecyclerView rodinaTasksRewardsList;
    public final LinearLayout rodinaTasksRightPanel;
    private final LinearLayout rootView;
    public final WinterBattlepassPinkLevelSummaryBinding tasksLevelSummary;

    private WinterBattlepassPinkTasksLayoutBinding(LinearLayout linearLayout, CustomCardView customCardView, LinearLayout linearLayout2, CustomCardView customCardView2, FrameLayout frameLayout, CustomCardView customCardView3, TextView textView, LinearLayout linearLayout3, TextView textView2, TextView textView3, LinearLayout linearLayout4, TextView textView4, ProgressBar progressBar, TextView textView5, RecyclerView recyclerView, LinearLayout linearLayout5, CustomCardView customCardView4, CustomCardView customCardView5, TextView textView6, CustomCardView customCardView6, TextView textView7, CustomCardView customCardView7, TextView textView8, RecyclerView recyclerView2, LinearLayout linearLayout6, WinterBattlepassPinkLevelSummaryBinding winterBattlepassPinkLevelSummaryBinding) {
        this.rootView = linearLayout;
        this.rodinaTasksBuyPremiumLockButton = customCardView;
        this.rodinaTasksCategories = linearLayout2;
        this.rodinaTasksClaimButton = customCardView2;
        this.rodinaTasksCurrentTaskContainer = frameLayout;
        this.rodinaTasksDailyButton = customCardView3;
        this.rodinaTasksDailyText = textView;
        this.rodinaTasksEmptyState = linearLayout3;
        this.rodinaTasksInfoCount = textView2;
        this.rodinaTasksInfoDescription = textView3;
        this.rodinaTasksInfoDoneContainer = linearLayout4;
        this.rodinaTasksInfoPercent = textView4;
        this.rodinaTasksInfoProgress = progressBar;
        this.rodinaTasksInfoTitle = textView5;
        this.rodinaTasksList = recyclerView;
        this.rodinaTasksPageRoot = linearLayout5;
        this.rodinaTasksPremiumButton = customCardView4;
        this.rodinaTasksPremiumLockContainer = customCardView5;
        this.rodinaTasksPremiumText = textView6;
        this.rodinaTasksRemainingTimeContainer = customCardView6;
        this.rodinaTasksRemainingTimeText = textView7;
        this.rodinaTasksResetContainer = customCardView7;
        this.rodinaTasksResetTimeText = textView8;
        this.rodinaTasksRewardsList = recyclerView2;
        this.rodinaTasksRightPanel = linearLayout6;
        this.tasksLevelSummary = winterBattlepassPinkLevelSummaryBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassPinkTasksLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassPinkTasksLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_pink_tasks_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassPinkTasksLayoutBinding bind(View view) {
        View findChildViewById;
        int i = R.id.rodina_tasks_buy_premium_lock_button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.rodina_tasks_categories;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.rodina_tasks_claim_button;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.rodina_tasks_current_task_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.rodina_tasks_daily_button;
                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView3 != null) {
                            i = R.id.rodina_tasks_daily_text;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.rodina_tasks_empty_state;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.rodina_tasks_info_count;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.rodina_tasks_info_description;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.rodina_tasks_info_done_container;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.rodina_tasks_info_percent;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.rodina_tasks_info_progress;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                    if (progressBar != null) {
                                                        i = R.id.rodina_tasks_info_title;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.rodina_tasks_list;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView != null) {
                                                                LinearLayout linearLayout4 = (LinearLayout) view;
                                                                i = R.id.rodina_tasks_premium_button;
                                                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                if (customCardView4 != null) {
                                                                    i = R.id.rodina_tasks_premium_lock_container;
                                                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView5 != null) {
                                                                        i = R.id.rodina_tasks_premium_text;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.rodina_tasks_remaining_time_container;
                                                                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView6 != null) {
                                                                                i = R.id.rodina_tasks_remaining_time_text;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.rodina_tasks_reset_container;
                                                                                    CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView7 != null) {
                                                                                        i = R.id.rodina_tasks_reset_time_text;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.rodina_tasks_rewards_list;
                                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                            if (recyclerView2 != null) {
                                                                                                i = R.id.rodina_tasks_right_panel;
                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout5 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.tasks_level_summary))) != null) {
                                                                                                    return new WinterBattlepassPinkTasksLayoutBinding(linearLayout4, customCardView, linearLayout, customCardView2, frameLayout, customCardView3, textView, linearLayout2, textView2, textView3, linearLayout3, textView4, progressBar, textView5, recyclerView, linearLayout4, customCardView4, customCardView5, textView6, customCardView6, textView7, customCardView7, textView8, recyclerView2, linearLayout5, WinterBattlepassPinkLevelSummaryBinding.bind(findChildViewById));
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
