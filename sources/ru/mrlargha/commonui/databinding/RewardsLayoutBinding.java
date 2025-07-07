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
/* loaded from: classes5.dex */
public final class RewardsLayoutBinding implements ViewBinding {
    public final LinearLayout actionButton;
    public final Guideline actionButtonTopLine;
    public final TextView actionButtonTxt;
    public final TextView description;
    public final ImageView exitButton;
    public final ConstraintLayout firstLongPrize;
    public final TextView firstLongPrizeDescription;
    public final ImageView firstLongPrizeIc;
    public final ConstraintLayout firstLongPrizeIcContainer;
    public final LinearLayout firstLongPrizeTimeContainer;
    public final TextView firstLongPrizeTimeDescription;
    public final TextView firstLongPrizeTitle;
    public final ConstraintLayout firstShortPrize;
    public final TextView firstShortPrizeDescription;
    public final ImageView firstShortPrizeIc;
    public final ConstraintLayout firstShortPrizeIcContainer;
    public final LinearLayout firstShortPrizeTimeContainer;
    public final TextView firstShortPrizeTimeDescription;
    public final TextView firstShortPrizeTitle;
    public final ImageView layoutBg;
    public final Guideline leftLine;
    public final Guideline prizesSecondTopLine;
    public final Guideline prizesTopLine;
    public final ConstraintLayout rewardsLayout;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final Guideline secondColumnPrizesLeftLine;
    public final ConstraintLayout secondLongPrize;
    public final TextView secondLongPrizeDescription;
    public final ImageView secondLongPrizeIc;
    public final ConstraintLayout secondLongPrizeIcContainer;
    public final LinearLayout secondLongPrizeTimeContainer;
    public final TextView secondLongPrizeTimeDescription;
    public final TextView secondLongPrizeTitle;
    public final ConstraintLayout secondShortPrize;
    public final TextView secondShortPrizeDescription;
    public final ImageView secondShortPrizeIc;
    public final ConstraintLayout secondShortPrizeIcContainer;
    public final LinearLayout secondShortPrizeTimeContainer;
    public final TextView secondShortPrizeTimeDescription;
    public final TextView secondShortPrizeTitle;
    public final TextView title;
    public final ConstraintLayout titleContainer;
    public final Guideline topLine;

    private RewardsLayoutBinding(ConstraintLayout rootView, LinearLayout actionButton, Guideline actionButtonTopLine, TextView actionButtonTxt, TextView description, ImageView exitButton, ConstraintLayout firstLongPrize, TextView firstLongPrizeDescription, ImageView firstLongPrizeIc, ConstraintLayout firstLongPrizeIcContainer, LinearLayout firstLongPrizeTimeContainer, TextView firstLongPrizeTimeDescription, TextView firstLongPrizeTitle, ConstraintLayout firstShortPrize, TextView firstShortPrizeDescription, ImageView firstShortPrizeIc, ConstraintLayout firstShortPrizeIcContainer, LinearLayout firstShortPrizeTimeContainer, TextView firstShortPrizeTimeDescription, TextView firstShortPrizeTitle, ImageView layoutBg, Guideline leftLine, Guideline prizesSecondTopLine, Guideline prizesTopLine, ConstraintLayout rewardsLayout, Guideline rightLine, Guideline secondColumnPrizesLeftLine, ConstraintLayout secondLongPrize, TextView secondLongPrizeDescription, ImageView secondLongPrizeIc, ConstraintLayout secondLongPrizeIcContainer, LinearLayout secondLongPrizeTimeContainer, TextView secondLongPrizeTimeDescription, TextView secondLongPrizeTitle, ConstraintLayout secondShortPrize, TextView secondShortPrizeDescription, ImageView secondShortPrizeIc, ConstraintLayout secondShortPrizeIcContainer, LinearLayout secondShortPrizeTimeContainer, TextView secondShortPrizeTimeDescription, TextView secondShortPrizeTitle, TextView title, ConstraintLayout titleContainer, Guideline topLine) {
        this.rootView = rootView;
        this.actionButton = actionButton;
        this.actionButtonTopLine = actionButtonTopLine;
        this.actionButtonTxt = actionButtonTxt;
        this.description = description;
        this.exitButton = exitButton;
        this.firstLongPrize = firstLongPrize;
        this.firstLongPrizeDescription = firstLongPrizeDescription;
        this.firstLongPrizeIc = firstLongPrizeIc;
        this.firstLongPrizeIcContainer = firstLongPrizeIcContainer;
        this.firstLongPrizeTimeContainer = firstLongPrizeTimeContainer;
        this.firstLongPrizeTimeDescription = firstLongPrizeTimeDescription;
        this.firstLongPrizeTitle = firstLongPrizeTitle;
        this.firstShortPrize = firstShortPrize;
        this.firstShortPrizeDescription = firstShortPrizeDescription;
        this.firstShortPrizeIc = firstShortPrizeIc;
        this.firstShortPrizeIcContainer = firstShortPrizeIcContainer;
        this.firstShortPrizeTimeContainer = firstShortPrizeTimeContainer;
        this.firstShortPrizeTimeDescription = firstShortPrizeTimeDescription;
        this.firstShortPrizeTitle = firstShortPrizeTitle;
        this.layoutBg = layoutBg;
        this.leftLine = leftLine;
        this.prizesSecondTopLine = prizesSecondTopLine;
        this.prizesTopLine = prizesTopLine;
        this.rewardsLayout = rewardsLayout;
        this.rightLine = rightLine;
        this.secondColumnPrizesLeftLine = secondColumnPrizesLeftLine;
        this.secondLongPrize = secondLongPrize;
        this.secondLongPrizeDescription = secondLongPrizeDescription;
        this.secondLongPrizeIc = secondLongPrizeIc;
        this.secondLongPrizeIcContainer = secondLongPrizeIcContainer;
        this.secondLongPrizeTimeContainer = secondLongPrizeTimeContainer;
        this.secondLongPrizeTimeDescription = secondLongPrizeTimeDescription;
        this.secondLongPrizeTitle = secondLongPrizeTitle;
        this.secondShortPrize = secondShortPrize;
        this.secondShortPrizeDescription = secondShortPrizeDescription;
        this.secondShortPrizeIc = secondShortPrizeIc;
        this.secondShortPrizeIcContainer = secondShortPrizeIcContainer;
        this.secondShortPrizeTimeContainer = secondShortPrizeTimeContainer;
        this.secondShortPrizeTimeDescription = secondShortPrizeTimeDescription;
        this.secondShortPrizeTitle = secondShortPrizeTitle;
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
                        if (imageView != null) {
                            i = R.id.first_long_prize;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout != null) {
                                i = R.id.first_long_prize_description;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.first_long_prize_ic;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView2 != null) {
                                        i = R.id.first_long_prize_ic_container;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout2 != null) {
                                            i = R.id.first_long_prize_time_container;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.first_long_prize_time_description;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.first_long_prize_title;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.first_short_prize;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (constraintLayout3 != null) {
                                                            i = R.id.first_short_prize_description;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.first_short_prize_ic;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.first_short_prize_ic_container;
                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (constraintLayout4 != null) {
                                                                        i = R.id.first_short_prize_time_container;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.first_short_prize_time_description;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.first_short_prize_title;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.layout_bg;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (imageView4 != null) {
                                                                                        i = R.id.left_line;
                                                                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (guideline2 != null) {
                                                                                            i = R.id.prizes_second_top_line;
                                                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (guideline3 != null) {
                                                                                                i = R.id.prizes_top_line;
                                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (guideline4 != null) {
                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) rootView;
                                                                                                    i = R.id.right_line;
                                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (guideline5 != null) {
                                                                                                        i = R.id.second_column_prizes_left_line;
                                                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (guideline6 != null) {
                                                                                                            i = R.id.second_long_prize;
                                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (constraintLayout6 != null) {
                                                                                                                i = R.id.second_long_prize_description;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.second_long_prize_ic;
                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (imageView5 != null) {
                                                                                                                        i = R.id.second_long_prize_ic_container;
                                                                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (constraintLayout7 != null) {
                                                                                                                            i = R.id.second_long_prize_time_container;
                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                i = R.id.second_long_prize_time_description;
                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    i = R.id.second_long_prize_title;
                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i = R.id.second_short_prize;
                                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                                            i = R.id.second_short_prize_description;
                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (textView12 != null) {
                                                                                                                                                i = R.id.second_short_prize_ic;
                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                    i = R.id.second_short_prize_ic_container;
                                                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (constraintLayout9 != null) {
                                                                                                                                                        i = R.id.second_short_prize_time_container;
                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                            i = R.id.second_short_prize_time_description;
                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                i = R.id.second_short_prize_title;
                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                    i = R.id.title;
                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                        i = R.id.title_container;
                                                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                                                            i = R.id.top_line;
                                                                                                                                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (guideline7 != null) {
                                                                                                                                                                                return new RewardsLayoutBinding(constraintLayout5, linearLayout, guideline, textView, textView2, imageView, constraintLayout, textView3, imageView2, constraintLayout2, linearLayout2, textView4, textView5, constraintLayout3, textView6, imageView3, constraintLayout4, linearLayout3, textView7, textView8, imageView4, guideline2, guideline3, guideline4, constraintLayout5, guideline5, guideline6, constraintLayout6, textView9, imageView5, constraintLayout7, linearLayout4, textView10, textView11, constraintLayout8, textView12, imageView6, constraintLayout9, linearLayout5, textView13, textView14, textView15, constraintLayout10, guideline7);
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
