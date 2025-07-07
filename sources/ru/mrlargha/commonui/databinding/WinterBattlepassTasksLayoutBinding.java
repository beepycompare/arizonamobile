package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassTasksLayoutBinding implements ViewBinding {
    public final LinearLayout azBattlepassLayoutTasksContainer;
    public final ImageView btnBuyPremiumLock;
    public final RelativeLayout buttonDailyTasks;
    public final TextView buttonDailyTasksText;
    public final RelativeLayout buttonLongTasks;
    public final TextView buttonLongTasksText;
    public final RelativeLayout buttonPremiumTasks;
    public final TextView buttonPremiumTasksText;
    public final RelativeLayout buttonShopTasks;
    public final TextView buttonShopTasksText;
    public final RelativeLayout buttonTaskInfoGetReward;
    public final ImageView buyLevelsBtnSd;
    public final RecyclerView commonTaskRecycleView;
    public final LinearLayout containerTasksTimer;
    public final RelativeLayout currTaskInfoContainer;
    public final TextView itemCount;
    public final LinearLayout levelContainer;
    public final TextView levelPassText;
    public final TextView mainExperienceText;
    public final LinearLayout progressDoneContainer;
    public final LinearProgressIndicator progressExperience;
    public final TextView progressInPercentText;
    public final LinearLayout remainingTime;
    public final TextView remainingTimeText;
    private final LinearLayout rootView;
    public final LinearLayout taskContainerListIsEmpty;
    public final LinearLayout taskInfo;
    public final FrameLayout taskInfoBlur;
    public final TextView taskInfoDesc;
    public final LinearLayout taskInfoPremiumLockContainer;
    public final ProgressBar taskInfoProgressBar;
    public final TextView taskInfoTitle;
    public final RecyclerView taskItemsRewardsList;
    public final TextView tasksTimeText;

    private WinterBattlepassTasksLayoutBinding(LinearLayout rootView, LinearLayout azBattlepassLayoutTasksContainer, ImageView btnBuyPremiumLock, RelativeLayout buttonDailyTasks, TextView buttonDailyTasksText, RelativeLayout buttonLongTasks, TextView buttonLongTasksText, RelativeLayout buttonPremiumTasks, TextView buttonPremiumTasksText, RelativeLayout buttonShopTasks, TextView buttonShopTasksText, RelativeLayout buttonTaskInfoGetReward, ImageView buyLevelsBtnSd, RecyclerView commonTaskRecycleView, LinearLayout containerTasksTimer, RelativeLayout currTaskInfoContainer, TextView itemCount, LinearLayout levelContainer, TextView levelPassText, TextView mainExperienceText, LinearLayout progressDoneContainer, LinearProgressIndicator progressExperience, TextView progressInPercentText, LinearLayout remainingTime, TextView remainingTimeText, LinearLayout taskContainerListIsEmpty, LinearLayout taskInfo, FrameLayout taskInfoBlur, TextView taskInfoDesc, LinearLayout taskInfoPremiumLockContainer, ProgressBar taskInfoProgressBar, TextView taskInfoTitle, RecyclerView taskItemsRewardsList, TextView tasksTimeText) {
        this.rootView = rootView;
        this.azBattlepassLayoutTasksContainer = azBattlepassLayoutTasksContainer;
        this.btnBuyPremiumLock = btnBuyPremiumLock;
        this.buttonDailyTasks = buttonDailyTasks;
        this.buttonDailyTasksText = buttonDailyTasksText;
        this.buttonLongTasks = buttonLongTasks;
        this.buttonLongTasksText = buttonLongTasksText;
        this.buttonPremiumTasks = buttonPremiumTasks;
        this.buttonPremiumTasksText = buttonPremiumTasksText;
        this.buttonShopTasks = buttonShopTasks;
        this.buttonShopTasksText = buttonShopTasksText;
        this.buttonTaskInfoGetReward = buttonTaskInfoGetReward;
        this.buyLevelsBtnSd = buyLevelsBtnSd;
        this.commonTaskRecycleView = commonTaskRecycleView;
        this.containerTasksTimer = containerTasksTimer;
        this.currTaskInfoContainer = currTaskInfoContainer;
        this.itemCount = itemCount;
        this.levelContainer = levelContainer;
        this.levelPassText = levelPassText;
        this.mainExperienceText = mainExperienceText;
        this.progressDoneContainer = progressDoneContainer;
        this.progressExperience = progressExperience;
        this.progressInPercentText = progressInPercentText;
        this.remainingTime = remainingTime;
        this.remainingTimeText = remainingTimeText;
        this.taskContainerListIsEmpty = taskContainerListIsEmpty;
        this.taskInfo = taskInfo;
        this.taskInfoBlur = taskInfoBlur;
        this.taskInfoDesc = taskInfoDesc;
        this.taskInfoPremiumLockContainer = taskInfoPremiumLockContainer;
        this.taskInfoProgressBar = taskInfoProgressBar;
        this.taskInfoTitle = taskInfoTitle;
        this.taskItemsRewardsList = taskItemsRewardsList;
        this.tasksTimeText = tasksTimeText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassTasksLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassTasksLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_tasks_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassTasksLayoutBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.btn_buy_premium_lock;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.button_daily_tasks;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
            if (relativeLayout != null) {
                i = R.id.button_daily_tasks_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.button_long_tasks;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                    if (relativeLayout2 != null) {
                        i = R.id.button_long_tasks_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.button_premium_tasks;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                            if (relativeLayout3 != null) {
                                i = R.id.button_premium_tasks_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.button_shop_tasks;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (relativeLayout4 != null) {
                                        i = R.id.button_shop_tasks_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.button_task_info_get_reward;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (relativeLayout5 != null) {
                                                i = R.id.buy_levels_btn_sd;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView2 != null) {
                                                    i = R.id.common_task_recycle_view;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                    if (recyclerView != null) {
                                                        i = R.id.container_tasks_timer;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.curr_task_info_container;
                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (relativeLayout6 != null) {
                                                                i = R.id.item_count;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.level_container;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.level_pass_text;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.main_experience_text;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.progress_done_container;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.progress_experience;
                                                                                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (linearProgressIndicator != null) {
                                                                                        i = R.id.progress_in_percent_text;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.remaining_time;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (linearLayout5 != null) {
                                                                                                i = R.id.remaining_time_text;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.task_container_list_is_empty;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.task_info;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i = R.id.task_info_blur;
                                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (frameLayout != null) {
                                                                                                                i = R.id.task_info_desc;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.task_info_premium_lock_container;
                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (linearLayout8 != null) {
                                                                                                                        i = R.id.task_info_progress_bar;
                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (progressBar != null) {
                                                                                                                            i = R.id.task_info_title;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.task_items_rewards_list;
                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                    i = R.id.tasks_time_text;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        return new WinterBattlepassTasksLayoutBinding(linearLayout, linearLayout, imageView, relativeLayout, textView, relativeLayout2, textView2, relativeLayout3, textView3, relativeLayout4, textView4, relativeLayout5, imageView2, recyclerView, linearLayout2, relativeLayout6, textView5, linearLayout3, textView6, textView7, linearLayout4, linearProgressIndicator, textView8, linearLayout5, textView9, linearLayout6, linearLayout7, frameLayout, textView10, linearLayout8, progressBar, textView11, recyclerView2, textView12);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
