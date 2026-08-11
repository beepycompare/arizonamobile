package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankLotteryPageBinding implements ViewBinding {
    public final FrameLayout bankLotteryActiveContent;
    public final LinearLayout bankLotteryBalanceContent;
    public final CustomCardView bankLotteryBottomNavigation;
    public final CustomCardView bankLotteryClaimButton;
    public final TextView bankLotteryClaimButtonText;
    public final CustomCardView bankLotteryClaimCountCard;
    public final TextView bankLotteryClaimCountText;
    public final CustomCardView bankLotteryClaimTimerBadge;
    public final TextView bankLotteryClaimTimerText;
    public final LinearLayout bankLotteryConditionsContent;
    public final LinearLayout bankLotteryContentContainer;
    public final TextView bankLotteryDescription;
    public final BankLotteryFinishedStateBinding bankLotteryFinishedContent;
    public final CustomCardView bankLotteryHeroCard;
    public final CustomCardView bankLotteryRewardsCard;
    public final TextView bankLotteryRewardsEmpty;
    public final RecyclerView bankLotteryRewardsList;
    public final TextView bankLotteryRewardsTitle;
    public final CustomCardView bankLotterySectionHome;
    public final TextView bankLotterySectionHomeText;
    public final CustomCardView bankLotterySectionIndicator;
    public final CustomCardView bankLotterySectionRewards;
    public final TextView bankLotterySectionRewardsText;
    public final CustomCardView bankLotterySectionTasks;
    public final TextView bankLotterySectionTasksText;
    public final CustomCardView bankLotteryStatusBadge;
    public final CustomCardView bankLotteryStatusIndicator;
    public final TextView bankLotteryStatusText;
    public final CustomCardView bankLotteryStreamButton;
    public final ImageView bankLotteryStreamIcon;
    public final TextView bankLotteryStreamText;
    public final CustomCardView bankLotteryTasksContent;
    public final TextView bankLotteryTasksEmpty;
    public final RecyclerView bankLotteryTasksList;
    public final TextView bankLotteryTicketsBalance;
    public final TextView bankLotteryTimer;
    public final LinearLayout bankLotteryTimerContainer;
    public final TextView bankLotteryTitle;
    private final LinearLayout rootView;

    private BankLotteryPageBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, CustomCardView customCardView, CustomCardView customCardView2, TextView textView, CustomCardView customCardView3, TextView textView2, CustomCardView customCardView4, TextView textView3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView4, BankLotteryFinishedStateBinding bankLotteryFinishedStateBinding, CustomCardView customCardView5, CustomCardView customCardView6, TextView textView5, RecyclerView recyclerView, TextView textView6, CustomCardView customCardView7, TextView textView7, CustomCardView customCardView8, CustomCardView customCardView9, TextView textView8, CustomCardView customCardView10, TextView textView9, CustomCardView customCardView11, CustomCardView customCardView12, TextView textView10, CustomCardView customCardView13, ImageView imageView, TextView textView11, CustomCardView customCardView14, TextView textView12, RecyclerView recyclerView2, TextView textView13, TextView textView14, LinearLayout linearLayout5, TextView textView15) {
        this.rootView = linearLayout;
        this.bankLotteryActiveContent = frameLayout;
        this.bankLotteryBalanceContent = linearLayout2;
        this.bankLotteryBottomNavigation = customCardView;
        this.bankLotteryClaimButton = customCardView2;
        this.bankLotteryClaimButtonText = textView;
        this.bankLotteryClaimCountCard = customCardView3;
        this.bankLotteryClaimCountText = textView2;
        this.bankLotteryClaimTimerBadge = customCardView4;
        this.bankLotteryClaimTimerText = textView3;
        this.bankLotteryConditionsContent = linearLayout3;
        this.bankLotteryContentContainer = linearLayout4;
        this.bankLotteryDescription = textView4;
        this.bankLotteryFinishedContent = bankLotteryFinishedStateBinding;
        this.bankLotteryHeroCard = customCardView5;
        this.bankLotteryRewardsCard = customCardView6;
        this.bankLotteryRewardsEmpty = textView5;
        this.bankLotteryRewardsList = recyclerView;
        this.bankLotteryRewardsTitle = textView6;
        this.bankLotterySectionHome = customCardView7;
        this.bankLotterySectionHomeText = textView7;
        this.bankLotterySectionIndicator = customCardView8;
        this.bankLotterySectionRewards = customCardView9;
        this.bankLotterySectionRewardsText = textView8;
        this.bankLotterySectionTasks = customCardView10;
        this.bankLotterySectionTasksText = textView9;
        this.bankLotteryStatusBadge = customCardView11;
        this.bankLotteryStatusIndicator = customCardView12;
        this.bankLotteryStatusText = textView10;
        this.bankLotteryStreamButton = customCardView13;
        this.bankLotteryStreamIcon = imageView;
        this.bankLotteryStreamText = textView11;
        this.bankLotteryTasksContent = customCardView14;
        this.bankLotteryTasksEmpty = textView12;
        this.bankLotteryTasksList = recyclerView2;
        this.bankLotteryTicketsBalance = textView13;
        this.bankLotteryTimer = textView14;
        this.bankLotteryTimerContainer = linearLayout5;
        this.bankLotteryTitle = textView15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BankLotteryPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankLotteryPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_lottery_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankLotteryPageBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bank_lottery_active_content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.bank_lottery_balance_content;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.bank_lottery_bottom_navigation;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.bank_lottery_claim_button;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.bank_lottery_claim_button_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.bank_lottery_claim_count_card;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView3 != null) {
                                i = R.id.bank_lottery_claim_count_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.bank_lottery_claim_timer_badge;
                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView4 != null) {
                                        i = R.id.bank_lottery_claim_timer_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.bank_lottery_conditions_content;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.bank_lottery_content_container;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.bank_lottery_description;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bank_lottery_finished_content))) != null) {
                                                        BankLotteryFinishedStateBinding bind = BankLotteryFinishedStateBinding.bind(findChildViewById);
                                                        i = R.id.bank_lottery_hero_card;
                                                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView5 != null) {
                                                            i = R.id.bank_lottery_rewards_card;
                                                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                            if (customCardView6 != null) {
                                                                i = R.id.bank_lottery_rewards_empty;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.bank_lottery_rewards_list;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.bank_lottery_rewards_title;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.bank_lottery_section_home;
                                                                            CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView7 != null) {
                                                                                i = R.id.bank_lottery_section_home_text;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.bank_lottery_section_indicator;
                                                                                    CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView8 != null) {
                                                                                        i = R.id.bank_lottery_section_rewards;
                                                                                        CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                        if (customCardView9 != null) {
                                                                                            i = R.id.bank_lottery_section_rewards_text;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.bank_lottery_section_tasks;
                                                                                                CustomCardView customCardView10 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                if (customCardView10 != null) {
                                                                                                    i = R.id.bank_lottery_section_tasks_text;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.bank_lottery_status_badge;
                                                                                                        CustomCardView customCardView11 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (customCardView11 != null) {
                                                                                                            i = R.id.bank_lottery_status_indicator;
                                                                                                            CustomCardView customCardView12 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (customCardView12 != null) {
                                                                                                                i = R.id.bank_lottery_status_text;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.bank_lottery_stream_button;
                                                                                                                    CustomCardView customCardView13 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (customCardView13 != null) {
                                                                                                                        i = R.id.bank_lottery_stream_icon;
                                                                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (imageView != null) {
                                                                                                                            i = R.id.bank_lottery_stream_text;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.bank_lottery_tasks_content;
                                                                                                                                CustomCardView customCardView14 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (customCardView14 != null) {
                                                                                                                                    i = R.id.bank_lottery_tasks_empty;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = R.id.bank_lottery_tasks_list;
                                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                            i = R.id.bank_lottery_tickets_balance;
                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i = R.id.bank_lottery_timer;
                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i = R.id.bank_lottery_timer_container;
                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                        i = R.id.bank_lottery_title;
                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                            return new BankLotteryPageBinding((LinearLayout) view, frameLayout, linearLayout, customCardView, customCardView2, textView, customCardView3, textView2, customCardView4, textView3, linearLayout2, linearLayout3, textView4, bind, customCardView5, customCardView6, textView5, recyclerView, textView6, customCardView7, textView7, customCardView8, customCardView9, textView8, customCardView10, textView9, customCardView11, customCardView12, textView10, customCardView13, imageView, textView11, customCardView14, textView12, recyclerView2, textView13, textView14, linearLayout4, textView15);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
