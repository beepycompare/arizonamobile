package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class RewardsLayoutBinding implements ViewBinding {
    public final LinearLayout actionButton;
    public final Guideline actionButtonTopLine;
    public final TextView actionButtonTxt;
    public final TextView description;
    public final ImageView exitButton;
    public final RewardsLayoutItemBinding firstItem;
    public final RewardsLayoutItemBinding firstLongItem;
    public final ImageView layoutBg;
    public final Guideline leftLine;
    public final Guideline prizesSecondTopLine;
    public final Guideline prizesTopLine;
    public final ConstraintLayout rewardsLayout;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final Guideline secondColumnPrizesLeftLine;
    public final RewardsLayoutItemBinding secondItem;
    public final RewardsLayoutItemBinding secondLongItem;
    public final TextView title;
    public final ConstraintLayout titleContainer;
    public final Guideline topLine;

    private RewardsLayoutBinding(ConstraintLayout rootView, LinearLayout actionButton, Guideline actionButtonTopLine, TextView actionButtonTxt, TextView description, ImageView exitButton, RewardsLayoutItemBinding firstItem, RewardsLayoutItemBinding firstLongItem, ImageView layoutBg, Guideline leftLine, Guideline prizesSecondTopLine, Guideline prizesTopLine, ConstraintLayout rewardsLayout, Guideline rightLine, Guideline secondColumnPrizesLeftLine, RewardsLayoutItemBinding secondItem, RewardsLayoutItemBinding secondLongItem, TextView title, ConstraintLayout titleContainer, Guideline topLine) {
        this.rootView = rootView;
        this.actionButton = actionButton;
        this.actionButtonTopLine = actionButtonTopLine;
        this.actionButtonTxt = actionButtonTxt;
        this.description = description;
        this.exitButton = exitButton;
        this.firstItem = firstItem;
        this.firstLongItem = firstLongItem;
        this.layoutBg = layoutBg;
        this.leftLine = leftLine;
        this.prizesSecondTopLine = prizesSecondTopLine;
        this.prizesTopLine = prizesTopLine;
        this.rewardsLayout = rewardsLayout;
        this.rightLine = rightLine;
        this.secondColumnPrizesLeftLine = secondColumnPrizesLeftLine;
        this.secondItem = secondItem;
        this.secondLongItem = secondLongItem;
        this.title = title;
        this.titleContainer = titleContainer;
        this.topLine = topLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RewardsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RewardsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rewards_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RewardsLayoutBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.action_button;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.action_button_top_line;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.action_button_txt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.exit_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.first_item))) != null) {
                            RewardsLayoutItemBinding bind = RewardsLayoutItemBinding.bind(findChildViewById);
                            i = R.id.first_long_item;
                            View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById3 != null) {
                                RewardsLayoutItemBinding bind2 = RewardsLayoutItemBinding.bind(findChildViewById3);
                                i = R.id.layout_bg;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView2 != null) {
                                    i = R.id.left_line;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline2 != null) {
                                        i = R.id.prizes_second_top_line;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline3 != null) {
                                            i = R.id.prizes_top_line;
                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline4 != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                i = R.id.right_line;
                                                Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline5 != null) {
                                                    i = R.id.second_column_prizes_left_line;
                                                    Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline6 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.second_item))) != null) {
                                                        RewardsLayoutItemBinding bind3 = RewardsLayoutItemBinding.bind(findChildViewById2);
                                                        i = R.id.second_long_item;
                                                        View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById4 != null) {
                                                            RewardsLayoutItemBinding bind4 = RewardsLayoutItemBinding.bind(findChildViewById4);
                                                            i = R.id.title;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView3 != null) {
                                                                i = R.id.title_container;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout2 != null) {
                                                                    i = R.id.top_line;
                                                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                    if (guideline7 != null) {
                                                                        return new RewardsLayoutBinding(constraintLayout, linearLayout, guideline, textView, textView2, imageView, bind, bind2, imageView2, guideline2, guideline3, guideline4, constraintLayout, guideline5, guideline6, bind3, bind4, textView3, constraintLayout2, guideline7);
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
