package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
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

    private DailyRewardsRewardItemBinding(ConstraintLayout rootView, ConstraintLayout dayContainer, TextView dayTitle, ConstraintLayout doneContainer, ConstraintLayout getButton, TextView getButtonText, ConstraintLayout mainContainer, TextView rewardCount, ConstraintLayout rewardCountContainer, TextView rewardDescription, ImageView rewardIc, ConstraintLayout rewardItem, TextView rewardName, ProgressBar timePgb) {
        this.rootView = rootView;
        this.dayContainer = dayContainer;
        this.dayTitle = dayTitle;
        this.doneContainer = doneContainer;
        this.getButton = getButton;
        this.getButtonText = getButtonText;
        this.mainContainer = mainContainer;
        this.rewardCount = rewardCount;
        this.rewardCountContainer = rewardCountContainer;
        this.rewardDescription = rewardDescription;
        this.rewardIc = rewardIc;
        this.rewardItem = rewardItem;
        this.rewardName = rewardName;
        this.timePgb = timePgb;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DailyRewardsRewardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DailyRewardsRewardItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.daily_rewards_reward_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DailyRewardsRewardItemBinding bind(View rootView) {
        int i = R.id.day_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.day_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.done_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.get_button;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.get_button_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.main_container;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout4 != null) {
                                i = R.id.reward_count;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.reward_count_container;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.reward_description;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.reward_ic;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView != null) {
                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) rootView;
                                                i = R.id.reward_name;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.time_pgb;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
