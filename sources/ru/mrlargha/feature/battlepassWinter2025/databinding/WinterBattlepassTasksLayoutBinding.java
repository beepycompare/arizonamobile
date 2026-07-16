package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassTasksLayoutBinding implements ViewBinding {
    public final LinearLayout azBattlepassLayoutTasksContainer;
    public final TextView btnBuyPremiumLock;
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
    public final ConstraintLayout taskInfoBlur;
    public final LinearLayout taskInfoContentContainer;
    public final TextView taskInfoDesc;
    public final CustomCardView taskInfoPremiumLockContainer;
    public final ProgressBar taskInfoProgressBar;
    public final TextView taskInfoTitle;
    public final RecyclerView taskItemsRewardsList;
    public final TextView tasksTimeText;

    private WinterBattlepassTasksLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, RelativeLayout relativeLayout, TextView textView2, RelativeLayout relativeLayout2, TextView textView3, RelativeLayout relativeLayout3, TextView textView4, RelativeLayout relativeLayout4, TextView textView5, RelativeLayout relativeLayout5, ImageView imageView, RecyclerView recyclerView, LinearLayout linearLayout3, RelativeLayout relativeLayout6, TextView textView6, LinearLayout linearLayout4, TextView textView7, TextView textView8, LinearLayout linearLayout5, LinearProgressIndicator linearProgressIndicator, TextView textView9, LinearLayout linearLayout6, TextView textView10, LinearLayout linearLayout7, LinearLayout linearLayout8, ConstraintLayout constraintLayout, LinearLayout linearLayout9, TextView textView11, CustomCardView customCardView, ProgressBar progressBar, TextView textView12, RecyclerView recyclerView2, TextView textView13) {
        this.rootView = linearLayout;
        this.azBattlepassLayoutTasksContainer = linearLayout2;
        this.btnBuyPremiumLock = textView;
        this.buttonDailyTasks = relativeLayout;
        this.buttonDailyTasksText = textView2;
        this.buttonLongTasks = relativeLayout2;
        this.buttonLongTasksText = textView3;
        this.buttonPremiumTasks = relativeLayout3;
        this.buttonPremiumTasksText = textView4;
        this.buttonShopTasks = relativeLayout4;
        this.buttonShopTasksText = textView5;
        this.buttonTaskInfoGetReward = relativeLayout5;
        this.buyLevelsBtnSd = imageView;
        this.commonTaskRecycleView = recyclerView;
        this.containerTasksTimer = linearLayout3;
        this.currTaskInfoContainer = relativeLayout6;
        this.itemCount = textView6;
        this.levelContainer = linearLayout4;
        this.levelPassText = textView7;
        this.mainExperienceText = textView8;
        this.progressDoneContainer = linearLayout5;
        this.progressExperience = linearProgressIndicator;
        this.progressInPercentText = textView9;
        this.remainingTime = linearLayout6;
        this.remainingTimeText = textView10;
        this.taskContainerListIsEmpty = linearLayout7;
        this.taskInfo = linearLayout8;
        this.taskInfoBlur = constraintLayout;
        this.taskInfoContentContainer = linearLayout9;
        this.taskInfoDesc = textView11;
        this.taskInfoPremiumLockContainer = customCardView;
        this.taskInfoProgressBar = progressBar;
        this.taskInfoTitle = textView12;
        this.taskItemsRewardsList = recyclerView2;
        this.tasksTimeText = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassTasksLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassTasksLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_tasks_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassTasksLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.btn_buy_premium_lock;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.button_daily_tasks;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.button_daily_tasks_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.button_long_tasks;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.button_long_tasks_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.button_premium_tasks;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout3 != null) {
                                i = R.id.button_premium_tasks_text;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.button_shop_tasks;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout4 != null) {
                                        i = R.id.button_shop_tasks_text;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.button_task_info_get_reward;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout5 != null) {
                                                i = R.id.buy_levels_btn_sd;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.common_task_recycle_view;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                    if (recyclerView != null) {
                                                        i = R.id.container_tasks_timer;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.curr_task_info_container;
                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout6 != null) {
                                                                i = R.id.item_count;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.level_container;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.level_pass_text;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.main_experience_text;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.progress_done_container;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.progress_experience;
                                                                                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearProgressIndicator != null) {
                                                                                        i = R.id.progress_in_percent_text;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.remaining_time;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout5 != null) {
                                                                                                i = R.id.remaining_time_text;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.task_container_list_is_empty;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.task_info;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i = R.id.task_info_blur;
                                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout != null) {
                                                                                                                i = R.id.task_info_content_container;
                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout8 != null) {
                                                                                                                    i = R.id.task_info_desc;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.task_info_premium_lock_container;
                                                                                                                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (customCardView != null) {
                                                                                                                            i = R.id.task_info_progress_bar;
                                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (progressBar != null) {
                                                                                                                                i = R.id.task_info_title;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.task_items_rewards_list;
                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                        i = R.id.tasks_time_text;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            return new WinterBattlepassTasksLayoutBinding(linearLayout, linearLayout, textView, relativeLayout, textView2, relativeLayout2, textView3, relativeLayout3, textView4, relativeLayout4, textView5, relativeLayout5, imageView, recyclerView, linearLayout2, relativeLayout6, textView6, linearLayout3, textView7, textView8, linearLayout4, linearProgressIndicator, textView9, linearLayout5, textView10, linearLayout6, linearLayout7, constraintLayout, linearLayout8, textView11, customCardView, progressBar, textView12, recyclerView2, textView13);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
