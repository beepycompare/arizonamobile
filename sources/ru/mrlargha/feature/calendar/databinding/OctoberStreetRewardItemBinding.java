package ru.mrlargha.feature.calendar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.calendar.R;
/* loaded from: classes6.dex */
public final class OctoberStreetRewardItemBinding implements ViewBinding {
    public final ImageView clockIcon;
    public final ImageView completedIcon;
    public final CustomCardView dayContainer;
    public final TextView dayTitle;
    public final ImageView genericChest;
    public final CustomCardView mainContainer;
    public final LinearLayout missedLabel;
    public final LinearLayout octoberRewardItem;
    public final LinearLayout progressContainer;
    public final CustomCardView progressFill;
    public final TextView remainingLabel;
    public final TextView remainingTime;
    public final CustomCardView restoreButton;
    public final ImageView restoreCoin;
    public final TextView restorePrice;
    public final TextView rewardCount;
    public final CustomCardView rewardCountContainer;
    public final ImageView rewardIcon;
    public final TextView rewardName;
    private final LinearLayout rootView;
    public final ImageView warningIcon;

    private OctoberStreetRewardItemBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, CustomCardView customCardView, TextView textView, ImageView imageView3, CustomCardView customCardView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, CustomCardView customCardView3, TextView textView2, TextView textView3, CustomCardView customCardView4, ImageView imageView4, TextView textView4, TextView textView5, CustomCardView customCardView5, ImageView imageView5, TextView textView6, ImageView imageView6) {
        this.rootView = linearLayout;
        this.clockIcon = imageView;
        this.completedIcon = imageView2;
        this.dayContainer = customCardView;
        this.dayTitle = textView;
        this.genericChest = imageView3;
        this.mainContainer = customCardView2;
        this.missedLabel = linearLayout2;
        this.octoberRewardItem = linearLayout3;
        this.progressContainer = linearLayout4;
        this.progressFill = customCardView3;
        this.remainingLabel = textView2;
        this.remainingTime = textView3;
        this.restoreButton = customCardView4;
        this.restoreCoin = imageView4;
        this.restorePrice = textView4;
        this.rewardCount = textView5;
        this.rewardCountContainer = customCardView5;
        this.rewardIcon = imageView5;
        this.rewardName = textView6;
        this.warningIcon = imageView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OctoberStreetRewardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OctoberStreetRewardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.october_street_reward_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OctoberStreetRewardItemBinding bind(View view) {
        int i = R.id.clock_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.completed_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.day_container;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.day_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.generic_chest;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.main_container;
                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView2 != null) {
                                i = R.id.missed_label;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view;
                                    i = R.id.progress_container;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.progress_fill;
                                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                        if (customCardView3 != null) {
                                            i = R.id.remaining_label;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.remaining_time;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.restore_button;
                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView4 != null) {
                                                        i = R.id.restore_coin;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView4 != null) {
                                                            i = R.id.restore_price;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.reward_count;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.reward_count_container;
                                                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView5 != null) {
                                                                        i = R.id.reward_icon;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.reward_name;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.warning_icon;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView6 != null) {
                                                                                    return new OctoberStreetRewardItemBinding(linearLayout2, imageView, imageView2, customCardView, textView, imageView3, customCardView2, linearLayout, linearLayout2, linearLayout3, customCardView3, textView2, textView3, customCardView4, imageView4, textView4, textView5, customCardView5, imageView5, textView6, imageView6);
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
