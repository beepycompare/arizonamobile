package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateReplenishmentDialogBinding implements ViewBinding {
    public final LinearLayout bonusContainer;
    public final CardView boostContainer;
    public final ImageView btnClose;
    public final CardView btnUpp;
    public final CardView dialogContainer;
    public final EditText etReplenishmentSum;
    public final ImageView ivAzCoin;
    public final ImageView ivAzCoinIc;
    public final ImageView ivMoney;
    public final ImageView ivMoneyIc;
    public final LinearLayout receiveContainer;
    private final FrameLayout rootView;
    public final RecyclerView rvReplenishment;
    public final CardView timeContainer;
    public final FrameLayout titleContainer;
    public final TextView tvAzCoins;
    public final TextView tvBonus;
    public final TextView tvBoost;
    public final TextView tvBtnTitle;
    public final TextView tvExchangeRate;
    public final TextView tvMoney;
    public final TextView tvReceive;
    public final TextView tvReplenishment;
    public final TextView tvTime;
    public final TextView tvTitle;
    public final TextView tvYouReceive;

    private DonateReplenishmentDialogBinding(FrameLayout rootView, LinearLayout bonusContainer, CardView boostContainer, ImageView btnClose, CardView btnUpp, CardView dialogContainer, EditText etReplenishmentSum, ImageView ivAzCoin, ImageView ivAzCoinIc, ImageView ivMoney, ImageView ivMoneyIc, LinearLayout receiveContainer, RecyclerView rvReplenishment, CardView timeContainer, FrameLayout titleContainer, TextView tvAzCoins, TextView tvBonus, TextView tvBoost, TextView tvBtnTitle, TextView tvExchangeRate, TextView tvMoney, TextView tvReceive, TextView tvReplenishment, TextView tvTime, TextView tvTitle, TextView tvYouReceive) {
        this.rootView = rootView;
        this.bonusContainer = bonusContainer;
        this.boostContainer = boostContainer;
        this.btnClose = btnClose;
        this.btnUpp = btnUpp;
        this.dialogContainer = dialogContainer;
        this.etReplenishmentSum = etReplenishmentSum;
        this.ivAzCoin = ivAzCoin;
        this.ivAzCoinIc = ivAzCoinIc;
        this.ivMoney = ivMoney;
        this.ivMoneyIc = ivMoneyIc;
        this.receiveContainer = receiveContainer;
        this.rvReplenishment = rvReplenishment;
        this.timeContainer = timeContainer;
        this.titleContainer = titleContainer;
        this.tvAzCoins = tvAzCoins;
        this.tvBonus = tvBonus;
        this.tvBoost = tvBoost;
        this.tvBtnTitle = tvBtnTitle;
        this.tvExchangeRate = tvExchangeRate;
        this.tvMoney = tvMoney;
        this.tvReceive = tvReceive;
        this.tvReplenishment = tvReplenishment;
        this.tvTime = tvTime;
        this.tvTitle = tvTitle;
        this.tvYouReceive = tvYouReceive;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateReplenishmentDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateReplenishmentDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_replenishment_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateReplenishmentDialogBinding bind(View rootView) {
        int i = R.id.bonus_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.boost_container;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
            if (cardView != null) {
                i = R.id.btn_close;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.btn_upp;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
                    if (cardView2 != null) {
                        i = R.id.dialog_container;
                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, i);
                        if (cardView3 != null) {
                            i = R.id.et_replenishment_sum;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                            if (editText != null) {
                                i = R.id.iv_az_coin;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView2 != null) {
                                    i = R.id.iv_az_coin_ic;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView3 != null) {
                                        i = R.id.iv_money;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView4 != null) {
                                            i = R.id.iv_money_ic;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView5 != null) {
                                                i = R.id.receive_container;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout2 != null) {
                                                    i = R.id.rv_replenishment;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                    if (recyclerView != null) {
                                                        i = R.id.time_container;
                                                        CardView cardView4 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                        if (cardView4 != null) {
                                                            i = R.id.title_container;
                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (frameLayout != null) {
                                                                i = R.id.tv_az_coins;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView != null) {
                                                                    i = R.id.tv_bonus;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_boost;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_btn_title;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_exchange_rate;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_money;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.tv_receive;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.tv_replenishment;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.tv_time;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.tv_title;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.tv_you_receive;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView11 != null) {
                                                                                                            return new DonateReplenishmentDialogBinding((FrameLayout) rootView, linearLayout, cardView, imageView, cardView2, cardView3, editText, imageView2, imageView3, imageView4, imageView5, linearLayout2, recyclerView, cardView4, frameLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
