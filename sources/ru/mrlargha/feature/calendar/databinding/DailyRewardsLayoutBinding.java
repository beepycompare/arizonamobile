package ru.mrlargha.feature.calendar.databinding;

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
import ru.mrlargha.feature.calendar.R;
/* loaded from: classes3.dex */
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

    private DailyRewardsLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, ImageView imageView2, Guideline guideline, ImageView imageView3, Guideline guideline2, Guideline guideline3, RecyclerView recyclerView, Guideline guideline4, LinearLayout linearLayout, TextView textView2, Guideline guideline5, Guideline guideline6, TextView textView3) {
        this.rootView = constraintLayout;
        this.dailyRewardsLayout = constraintLayout2;
        this.description = textView;
        this.exitButton = imageView;
        this.infoIc = imageView2;
        this.leftLine = guideline;
        this.prizeIc = imageView3;
        this.rcBottomLine = guideline2;
        this.rcTopLine = guideline3;
        this.rewardsRc = recyclerView;
        this.rightLine = guideline4;
        this.tipContainer = linearLayout;
        this.title = textView2;
        this.topLine = guideline5;
        this.topPrizeIcLine = guideline6;
        this.tvTips = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DailyRewardsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DailyRewardsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.daily_rewards_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DailyRewardsLayoutBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.exit_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.info_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.left_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.prize_ic;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.rc_bottom_line;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline2 != null) {
                                i = R.id.rc_top_line;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.rewards_rc;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.right_line;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline4 != null) {
                                            i = R.id.tip_container;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = R.id.title;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.top_line;
                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline5 != null) {
                                                        i = R.id.top_prize_ic_line;
                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline6 != null) {
                                                            i = R.id.tv_tips;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
