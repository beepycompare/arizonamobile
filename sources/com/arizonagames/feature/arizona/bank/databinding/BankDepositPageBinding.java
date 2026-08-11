package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.views.BankIncomeChartView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankDepositPageBinding implements ViewBinding {
    public final TextView bankDepositBalance;
    public final FrameLayout bankDepositChartContainer;
    public final CustomCardView bankDepositChartPointCard;
    public final TextView bankDepositChartPointDate;
    public final TextView bankDepositChartPointValue;
    public final TextView bankDepositConditionsText;
    public final TextView bankDepositDescription;
    public final CustomCardView bankDepositHistoryButton;
    public final TextView bankDepositHistoryText;
    public final TextView bankDepositIncomeValue;
    public final CustomCardView bankDepositLevelButton;
    public final ImageView bankDepositLevelInfo;
    public final TextView bankDepositLevelValue;
    public final TextView bankDepositPaydayIncome;
    public final BankIncomeChartView bankDepositProfitChart;
    public final CustomCardView bankDepositProfitabilityCard;
    public final CustomCardView bankDepositRangeDayTab;
    public final TextView bankDepositRangeDayText;
    public final CustomCardView bankDepositRangeMonthTab;
    public final TextView bankDepositRangeMonthText;
    public final CustomCardView bankDepositRangeWeekTab;
    public final TextView bankDepositRangeWeekText;
    public final CustomCardView bankDepositSummaryCard;
    public final CustomCardView bankDepositTopUpButton;
    public final TextView bankDepositTopUpText;
    public final CustomCardView bankDepositUpgradeButton;
    public final TextView bankDepositUpgradeText;
    public final TextView bankDepositWithdrawBadge;
    public final CustomCardView bankDepositWithdrawButton;
    public final TextView bankDepositWithdrawText;
    private final NestedScrollView rootView;

    private BankDepositPageBinding(NestedScrollView nestedScrollView, TextView textView, FrameLayout frameLayout, CustomCardView customCardView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CustomCardView customCardView2, TextView textView6, TextView textView7, CustomCardView customCardView3, ImageView imageView, TextView textView8, TextView textView9, BankIncomeChartView bankIncomeChartView, CustomCardView customCardView4, CustomCardView customCardView5, TextView textView10, CustomCardView customCardView6, TextView textView11, CustomCardView customCardView7, TextView textView12, CustomCardView customCardView8, CustomCardView customCardView9, TextView textView13, CustomCardView customCardView10, TextView textView14, TextView textView15, CustomCardView customCardView11, TextView textView16) {
        this.rootView = nestedScrollView;
        this.bankDepositBalance = textView;
        this.bankDepositChartContainer = frameLayout;
        this.bankDepositChartPointCard = customCardView;
        this.bankDepositChartPointDate = textView2;
        this.bankDepositChartPointValue = textView3;
        this.bankDepositConditionsText = textView4;
        this.bankDepositDescription = textView5;
        this.bankDepositHistoryButton = customCardView2;
        this.bankDepositHistoryText = textView6;
        this.bankDepositIncomeValue = textView7;
        this.bankDepositLevelButton = customCardView3;
        this.bankDepositLevelInfo = imageView;
        this.bankDepositLevelValue = textView8;
        this.bankDepositPaydayIncome = textView9;
        this.bankDepositProfitChart = bankIncomeChartView;
        this.bankDepositProfitabilityCard = customCardView4;
        this.bankDepositRangeDayTab = customCardView5;
        this.bankDepositRangeDayText = textView10;
        this.bankDepositRangeMonthTab = customCardView6;
        this.bankDepositRangeMonthText = textView11;
        this.bankDepositRangeWeekTab = customCardView7;
        this.bankDepositRangeWeekText = textView12;
        this.bankDepositSummaryCard = customCardView8;
        this.bankDepositTopUpButton = customCardView9;
        this.bankDepositTopUpText = textView13;
        this.bankDepositUpgradeButton = customCardView10;
        this.bankDepositUpgradeText = textView14;
        this.bankDepositWithdrawBadge = textView15;
        this.bankDepositWithdrawButton = customCardView11;
        this.bankDepositWithdrawText = textView16;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static BankDepositPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankDepositPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_deposit_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankDepositPageBinding bind(View view) {
        int i = R.id.bank_deposit_balance;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_deposit_chart_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.bank_deposit_chart_point_card;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.bank_deposit_chart_point_date;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.bank_deposit_chart_point_value;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.bank_deposit_conditions_text;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.bank_deposit_description;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.bank_deposit_history_button;
                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView2 != null) {
                                        i = R.id.bank_deposit_history_text;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.bank_deposit_income_value;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.bank_deposit_level_button;
                                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView3 != null) {
                                                    i = R.id.bank_deposit_level_info;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = R.id.bank_deposit_level_value;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.bank_deposit_payday_income;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = R.id.bank_deposit_profit_chart;
                                                                BankIncomeChartView bankIncomeChartView = (BankIncomeChartView) ViewBindings.findChildViewById(view, i);
                                                                if (bankIncomeChartView != null) {
                                                                    i = R.id.bank_deposit_profitability_card;
                                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView4 != null) {
                                                                        i = R.id.bank_deposit_range_day_tab;
                                                                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                        if (customCardView5 != null) {
                                                                            i = R.id.bank_deposit_range_day_text;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.bank_deposit_range_month_tab;
                                                                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                if (customCardView6 != null) {
                                                                                    i = R.id.bank_deposit_range_month_text;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.bank_deposit_range_week_tab;
                                                                                        CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                        if (customCardView7 != null) {
                                                                                            i = R.id.bank_deposit_range_week_text;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.bank_deposit_summary_card;
                                                                                                CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                if (customCardView8 != null) {
                                                                                                    i = R.id.bank_deposit_top_up_button;
                                                                                                    CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (customCardView9 != null) {
                                                                                                        i = R.id.bank_deposit_top_up_text;
                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView13 != null) {
                                                                                                            i = R.id.bank_deposit_upgrade_button;
                                                                                                            CustomCardView customCardView10 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (customCardView10 != null) {
                                                                                                                i = R.id.bank_deposit_upgrade_text;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = R.id.bank_deposit_withdraw_badge;
                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = R.id.bank_deposit_withdraw_button;
                                                                                                                        CustomCardView customCardView11 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (customCardView11 != null) {
                                                                                                                            i = R.id.bank_deposit_withdraw_text;
                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView16 != null) {
                                                                                                                                return new BankDepositPageBinding((NestedScrollView) view, textView, frameLayout, customCardView, textView2, textView3, textView4, textView5, customCardView2, textView6, textView7, customCardView3, imageView, textView8, textView9, bankIncomeChartView, customCardView4, customCardView5, textView10, customCardView6, textView11, customCardView7, textView12, customCardView8, customCardView9, textView13, customCardView10, textView14, textView15, customCardView11, textView16);
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
