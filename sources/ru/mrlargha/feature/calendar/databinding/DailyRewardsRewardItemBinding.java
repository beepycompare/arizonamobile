package ru.mrlargha.feature.calendar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.calendar.R;
/* loaded from: classes6.dex */
public final class DailyRewardsRewardItemBinding implements ViewBinding {
    public final ConstraintLayout dayContainer;
    public final TextView dayTitle;
    public final ConstraintLayout doneContainer;
    public final ConstraintLayout getButton;
    public final TextView getButtonText;
    public final ConstraintLayout mainContainer;
    public final TextView rewardCount;
    public final ConstraintLayout rewardCountContainer;
    public final TextView rewardDescription;
    public final ImageView rewardIc;
    public final ConstraintLayout rewardItem;
    public final TextView rewardName;
    private final ConstraintLayout rootView;
    public final ProgressBar timePgb;

    private DailyRewardsRewardItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView2, ConstraintLayout constraintLayout5, TextView textView3, ConstraintLayout constraintLayout6, TextView textView4, ImageView imageView, ConstraintLayout constraintLayout7, TextView textView5, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.dayContainer = constraintLayout2;
        this.dayTitle = textView;
        this.doneContainer = constraintLayout3;
        this.getButton = constraintLayout4;
        this.getButtonText = textView2;
        this.mainContainer = constraintLayout5;
        this.rewardCount = textView3;
        this.rewardCountContainer = constraintLayout6;
        this.rewardDescription = textView4;
        this.rewardIc = imageView;
        this.rewardItem = constraintLayout7;
        this.rewardName = textView5;
        this.timePgb = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DailyRewardsRewardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DailyRewardsRewardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.daily_rewards_reward_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DailyRewardsRewardItemBinding bind(View view) {
        int i = R.id.day_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.day_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.done_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.get_button;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout3 != null) {
                        i = R.id.get_button_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.main_container;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout4 != null) {
                                i = R.id.reward_count;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.reward_count_container;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.reward_description;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.reward_ic;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) view;
                                                i = R.id.reward_name;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.time_pgb;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                    if (progressBar != null) {
                                                        return new DailyRewardsRewardItemBinding(constraintLayout6, constraintLayout, textView, constraintLayout2, constraintLayout3, textView2, constraintLayout4, textView3, constraintLayout5, textView4, imageView, constraintLayout6, textView5, progressBar);
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
