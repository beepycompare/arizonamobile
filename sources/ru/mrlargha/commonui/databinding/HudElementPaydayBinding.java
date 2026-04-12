package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudElementPaydayBinding implements ViewBinding {
    public final HudElementPaydayBadgeBinding badgeHouseMultiplier;
    public final HudElementPaydayBadgeBinding badgePaydayMultiplier;
    public final TextView btnClose;
    public final HudElementPaydayItemBinding cardAdditional;
    public final HudElementPaydayItemBinding cardAz;
    public final HudElementPaydayItemBinding cardDeposit;
    public final HudElementPaydayItemBinding cardFraction;
    public final HudElementPaydayItemBinding cardLaws;
    public final HudElementPaydayItemBinding cardLevel;
    public final CustomCardView close;
    public final CustomCardView incomeCard;
    public final LinearLayout layoutCardsRow1;
    public final LinearLayout layoutCardsRow2;
    public final LinearLayout layoutCardsRow3;
    public final LinearLayout layoutOnlineInfo;
    public final LinearLayout layoutTopBadges;
    public final LinearLayout main;
    public final FrameLayout promo;
    private final FrameLayout rootView;
    public final TextView tvHourLabel;
    public final TextView tvHourTime;
    public final TextView tvMainIncome;
    public final TextView tvOnlineLabel;
    public final TextView tvTitle;
    public final TextView tvTodayLabel;
    public final TextView tvTodayTime;
    public final HudElementPaydayWarningBinding warningCard;

    private HudElementPaydayBinding(FrameLayout rootView, HudElementPaydayBadgeBinding badgeHouseMultiplier, HudElementPaydayBadgeBinding badgePaydayMultiplier, TextView btnClose, HudElementPaydayItemBinding cardAdditional, HudElementPaydayItemBinding cardAz, HudElementPaydayItemBinding cardDeposit, HudElementPaydayItemBinding cardFraction, HudElementPaydayItemBinding cardLaws, HudElementPaydayItemBinding cardLevel, CustomCardView close, CustomCardView incomeCard, LinearLayout layoutCardsRow1, LinearLayout layoutCardsRow2, LinearLayout layoutCardsRow3, LinearLayout layoutOnlineInfo, LinearLayout layoutTopBadges, LinearLayout main, FrameLayout promo, TextView tvHourLabel, TextView tvHourTime, TextView tvMainIncome, TextView tvOnlineLabel, TextView tvTitle, TextView tvTodayLabel, TextView tvTodayTime, HudElementPaydayWarningBinding warningCard) {
        this.rootView = rootView;
        this.badgeHouseMultiplier = badgeHouseMultiplier;
        this.badgePaydayMultiplier = badgePaydayMultiplier;
        this.btnClose = btnClose;
        this.cardAdditional = cardAdditional;
        this.cardAz = cardAz;
        this.cardDeposit = cardDeposit;
        this.cardFraction = cardFraction;
        this.cardLaws = cardLaws;
        this.cardLevel = cardLevel;
        this.close = close;
        this.incomeCard = incomeCard;
        this.layoutCardsRow1 = layoutCardsRow1;
        this.layoutCardsRow2 = layoutCardsRow2;
        this.layoutCardsRow3 = layoutCardsRow3;
        this.layoutOnlineInfo = layoutOnlineInfo;
        this.layoutTopBadges = layoutTopBadges;
        this.main = main;
        this.promo = promo;
        this.tvHourLabel = tvHourLabel;
        this.tvHourTime = tvHourTime;
        this.tvMainIncome = tvMainIncome;
        this.tvOnlineLabel = tvOnlineLabel;
        this.tvTitle = tvTitle;
        this.tvTodayLabel = tvTodayLabel;
        this.tvTodayTime = tvTodayTime;
        this.warningCard = warningCard;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementPaydayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementPaydayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_payday, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementPaydayBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.badgeHouseMultiplier;
        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById3 != null) {
            HudElementPaydayBadgeBinding bind = HudElementPaydayBadgeBinding.bind(findChildViewById3);
            i = R.id.badgePaydayMultiplier;
            View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById4 != null) {
                HudElementPaydayBadgeBinding bind2 = HudElementPaydayBadgeBinding.bind(findChildViewById4);
                i = R.id.btnClose;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.cardAdditional))) != null) {
                    HudElementPaydayItemBinding bind3 = HudElementPaydayItemBinding.bind(findChildViewById);
                    i = R.id.cardAz;
                    View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById5 != null) {
                        HudElementPaydayItemBinding bind4 = HudElementPaydayItemBinding.bind(findChildViewById5);
                        i = R.id.cardDeposit;
                        View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById6 != null) {
                            HudElementPaydayItemBinding bind5 = HudElementPaydayItemBinding.bind(findChildViewById6);
                            i = R.id.cardFraction;
                            View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById7 != null) {
                                HudElementPaydayItemBinding bind6 = HudElementPaydayItemBinding.bind(findChildViewById7);
                                i = R.id.cardLaws;
                                View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById8 != null) {
                                    HudElementPaydayItemBinding bind7 = HudElementPaydayItemBinding.bind(findChildViewById8);
                                    i = R.id.cardLevel;
                                    View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById9 != null) {
                                        HudElementPaydayItemBinding bind8 = HudElementPaydayItemBinding.bind(findChildViewById9);
                                        i = R.id.close;
                                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                        if (customCardView != null) {
                                            i = R.id.incomeCard;
                                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                            if (customCardView2 != null) {
                                                i = R.id.layoutCardsRow1;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout != null) {
                                                    i = R.id.layoutCardsRow2;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.layoutCardsRow3;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.layoutOnlineInfo;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.layoutTopBadges;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.main;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout6 != null) {
                                                                        FrameLayout frameLayout = (FrameLayout) rootView;
                                                                        i = R.id.tvHourLabel;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.tvHourTime;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tvMainIncome;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tvOnlineLabel;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tvTitle;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.tvTodayLabel;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.tvTodayTime;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView8 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.warningCard))) != null) {
                                                                                                    return new HudElementPaydayBinding(frameLayout, bind, bind2, textView, bind3, bind4, bind5, bind6, bind7, bind8, customCardView, customCardView2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, frameLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8, HudElementPaydayWarningBinding.bind(findChildViewById2));
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
