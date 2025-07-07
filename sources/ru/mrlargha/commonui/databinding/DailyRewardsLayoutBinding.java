package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DailyRewardsLayoutBinding implements ViewBinding {
    public final ConstraintLayout dailyRewardsLayout;
    public final TextView description;
    public final ImageView exitButton;
    public final ImageView infoIc;
    public final Guideline leftLine;
    public final ImageView prizeIc;
    public final Guideline rcBottomLine;
    public final Guideline rcTopLine;
    public final RecyclerView rewardsRc;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final LinearLayout tipContainer;
    public final TextView title;
    public final Guideline topLine;
    public final Guideline topPrizeIcLine;
    public final TextView tvTips;

    private DailyRewardsLayoutBinding(ConstraintLayout rootView, ConstraintLayout dailyRewardsLayout, TextView description, ImageView exitButton, ImageView infoIc, Guideline leftLine, ImageView prizeIc, Guideline rcBottomLine, Guideline rcTopLine, RecyclerView rewardsRc, Guideline rightLine, LinearLayout tipContainer, TextView title, Guideline topLine, Guideline topPrizeIcLine, TextView tvTips) {
        this.rootView = rootView;
        this.dailyRewardsLayout = dailyRewardsLayout;
        this.description = description;
        this.exitButton = exitButton;
        this.infoIc = infoIc;
        this.leftLine = leftLine;
        this.prizeIc = prizeIc;
        this.rcBottomLine = rcBottomLine;
        this.rcTopLine = rcTopLine;
        this.rewardsRc = rewardsRc;
        this.rightLine = rightLine;
        this.tipContainer = tipContainer;
        this.title = title;
        this.topLine = topLine;
        this.topPrizeIcLine = topPrizeIcLine;
        this.tvTips = tvTips;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DailyRewardsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DailyRewardsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.daily_rewards_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DailyRewardsLayoutBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.exit_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.info_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.left_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline != null) {
                        i = R.id.prize_ic;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            i = R.id.rc_bottom_line;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline2 != null) {
                                i = R.id.rc_top_line;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline3 != null) {
                                    i = R.id.rewards_rc;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView != null) {
                                        i = R.id.right_line;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline4 != null) {
                                            i = R.id.tip_container;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout != null) {
                                                i = R.id.title;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView2 != null) {
                                                    i = R.id.top_line;
                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline5 != null) {
                                                        i = R.id.top_prize_ic_line;
                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                        if (guideline6 != null) {
                                                            i = R.id.tv_tips;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView3 != null) {
                                                                return new DailyRewardsLayoutBinding(constraintLayout, constraintLayout, textView, imageView, imageView2, guideline, imageView3, guideline2, guideline3, recyclerView, guideline4, linearLayout, textView2, guideline5, guideline6, textView3);
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
