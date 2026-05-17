package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class RewardsLayoutItemBinding implements ViewBinding {
    public final ConstraintLayout rewardsLayout;
    private final ConstraintLayout rootView;
    public final CustomCardView shortPrize;
    public final TextView shortPrizeDescription;
    public final ImageView shortPrizeIc;
    public final CustomCardView shortPrizeIcContainer;
    public final LinearLayout shortPrizeTimeContainer;
    public final TextView shortPrizeTimeDescription;
    public final TextView shortPrizeTitle;

    private RewardsLayoutItemBinding(ConstraintLayout rootView, ConstraintLayout rewardsLayout, CustomCardView shortPrize, TextView shortPrizeDescription, ImageView shortPrizeIc, CustomCardView shortPrizeIcContainer, LinearLayout shortPrizeTimeContainer, TextView shortPrizeTimeDescription, TextView shortPrizeTitle) {
        this.rootView = rootView;
        this.rewardsLayout = rewardsLayout;
        this.shortPrize = shortPrize;
        this.shortPrizeDescription = shortPrizeDescription;
        this.shortPrizeIc = shortPrizeIc;
        this.shortPrizeIcContainer = shortPrizeIcContainer;
        this.shortPrizeTimeContainer = shortPrizeTimeContainer;
        this.shortPrizeTimeDescription = shortPrizeTimeDescription;
        this.shortPrizeTitle = shortPrizeTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RewardsLayoutItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RewardsLayoutItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rewards_layout_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RewardsLayoutItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.short_prize;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.short_prize_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.short_prize_ic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.short_prize_ic_container;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.short_prize_time_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.short_prize_time_description;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.short_prize_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new RewardsLayoutItemBinding(constraintLayout, constraintLayout, customCardView, textView, imageView, customCardView2, linearLayout, textView2, textView3);
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
