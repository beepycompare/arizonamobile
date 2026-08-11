package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.views.BankCurrencyChartView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankCurrencyItemBinding implements ViewBinding {
    public final TextView bankCurrencyAvailable;
    public final CustomCardView bankCurrencyAvailableCard;
    public final CustomCardView bankCurrencyBuyButton;
    public final TextView bankCurrencyBuyPercent;
    public final CustomCardView bankCurrencyCard;
    public final BankCurrencyChartView bankCurrencyChart;
    public final FrameLayout bankCurrencyChartContainer;
    public final CustomCardView bankCurrencyChartPointCard;
    public final TextView bankCurrencyChartPointDate;
    public final TextView bankCurrencyChartPointValue;
    public final CustomCardView bankCurrencyDayTab;
    public final TextView bankCurrencyDayText;
    public final ImageView bankCurrencyIcon;
    public final CustomCardView bankCurrencyMonthTab;
    public final TextView bankCurrencyMonthText;
    public final TextView bankCurrencyOwnBalance;
    public final CustomCardView bankCurrencyOwnBalanceCard;
    public final TextView bankCurrencyPercent;
    public final TextView bankCurrencyPrice;
    public final CustomCardView bankCurrencyPriceBadge;
    public final CustomCardView bankCurrencySellButton;
    public final TextView bankCurrencySellPercent;
    public final TextView bankCurrencyTitle;
    public final ImageView bankCurrencyTrendArrow;
    public final CustomCardView bankCurrencyWeekTab;
    public final TextView bankCurrencyWeekText;
    public final ImageView info;
    private final CustomCardView rootView;

    private BankCurrencyItemBinding(CustomCardView customCardView, TextView textView, CustomCardView customCardView2, CustomCardView customCardView3, TextView textView2, CustomCardView customCardView4, BankCurrencyChartView bankCurrencyChartView, FrameLayout frameLayout, CustomCardView customCardView5, TextView textView3, TextView textView4, CustomCardView customCardView6, TextView textView5, ImageView imageView, CustomCardView customCardView7, TextView textView6, TextView textView7, CustomCardView customCardView8, TextView textView8, TextView textView9, CustomCardView customCardView9, CustomCardView customCardView10, TextView textView10, TextView textView11, ImageView imageView2, CustomCardView customCardView11, TextView textView12, ImageView imageView3) {
        this.rootView = customCardView;
        this.bankCurrencyAvailable = textView;
        this.bankCurrencyAvailableCard = customCardView2;
        this.bankCurrencyBuyButton = customCardView3;
        this.bankCurrencyBuyPercent = textView2;
        this.bankCurrencyCard = customCardView4;
        this.bankCurrencyChart = bankCurrencyChartView;
        this.bankCurrencyChartContainer = frameLayout;
        this.bankCurrencyChartPointCard = customCardView5;
        this.bankCurrencyChartPointDate = textView3;
        this.bankCurrencyChartPointValue = textView4;
        this.bankCurrencyDayTab = customCardView6;
        this.bankCurrencyDayText = textView5;
        this.bankCurrencyIcon = imageView;
        this.bankCurrencyMonthTab = customCardView7;
        this.bankCurrencyMonthText = textView6;
        this.bankCurrencyOwnBalance = textView7;
        this.bankCurrencyOwnBalanceCard = customCardView8;
        this.bankCurrencyPercent = textView8;
        this.bankCurrencyPrice = textView9;
        this.bankCurrencyPriceBadge = customCardView9;
        this.bankCurrencySellButton = customCardView10;
        this.bankCurrencySellPercent = textView10;
        this.bankCurrencyTitle = textView11;
        this.bankCurrencyTrendArrow = imageView2;
        this.bankCurrencyWeekTab = customCardView11;
        this.bankCurrencyWeekText = textView12;
        this.info = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankCurrencyItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankCurrencyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_currency_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankCurrencyItemBinding bind(View view) {
        int i = R.id.bank_currency_available;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_currency_available_card;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.bank_currency_buy_button;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.bank_currency_buy_percent;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        CustomCardView customCardView3 = (CustomCardView) view;
                        i = R.id.bank_currency_chart;
                        BankCurrencyChartView bankCurrencyChartView = (BankCurrencyChartView) ViewBindings.findChildViewById(view, i);
                        if (bankCurrencyChartView != null) {
                            i = R.id.bank_currency_chart_container;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.bank_currency_chart_point_card;
                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView4 != null) {
                                    i = R.id.bank_currency_chart_point_date;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.bank_currency_chart_point_value;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.bank_currency_day_tab;
                                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView5 != null) {
                                                i = R.id.bank_currency_day_text;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.bank_currency_icon;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = R.id.bank_currency_month_tab;
                                                        CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView6 != null) {
                                                            i = R.id.bank_currency_month_text;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.bank_currency_own_balance;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.bank_currency_own_balance_card;
                                                                    CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView7 != null) {
                                                                        i = R.id.bank_currency_percent;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.bank_currency_price;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.bank_currency_price_badge;
                                                                                CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                if (customCardView8 != null) {
                                                                                    i = R.id.bank_currency_sell_button;
                                                                                    CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView9 != null) {
                                                                                        i = R.id.bank_currency_sell_percent;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.bank_currency_title;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.bank_currency_trend_arrow;
                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView2 != null) {
                                                                                                    i = R.id.bank_currency_week_tab;
                                                                                                    CustomCardView customCardView10 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (customCardView10 != null) {
                                                                                                        i = R.id.bank_currency_week_text;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.info;
                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView3 != null) {
                                                                                                                return new BankCurrencyItemBinding(customCardView3, textView, customCardView, customCardView2, textView2, customCardView3, bankCurrencyChartView, frameLayout, customCardView4, textView3, textView4, customCardView5, textView5, imageView, customCardView6, textView6, textView7, customCardView7, textView8, textView9, customCardView8, customCardView9, textView10, textView11, imageView2, customCardView10, textView12, imageView3);
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
