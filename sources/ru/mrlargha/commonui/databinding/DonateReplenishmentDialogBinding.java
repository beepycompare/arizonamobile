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
    public final CardView dialogContainer;
    public final EditText etReplenishmentSum;
    public final ImageView ivAzCoinIc;
    public final ImageView ivMoney;
    public final ImageView ivMoneyIc;
    public final LinearLayout receiveContainer;
    private final FrameLayout rootView;
    public final RecyclerView rvReplenishment;
    public final TextView tvAzCoins;
    public final TextView tvBonus;
    public final TextView tvExchangeRate;
    public final TextView tvMoney;
    public final TextView tvReceive;
    public final TextView tvReplenishment;
    public final TextView tvTitle;
    public final TextView tvYouReceive;

    private DonateReplenishmentDialogBinding(FrameLayout rootView, CardView dialogContainer, EditText etReplenishmentSum, ImageView ivAzCoinIc, ImageView ivMoney, ImageView ivMoneyIc, LinearLayout receiveContainer, RecyclerView rvReplenishment, TextView tvAzCoins, TextView tvBonus, TextView tvExchangeRate, TextView tvMoney, TextView tvReceive, TextView tvReplenishment, TextView tvTitle, TextView tvYouReceive) {
        this.rootView = rootView;
        this.dialogContainer = dialogContainer;
        this.etReplenishmentSum = etReplenishmentSum;
        this.ivAzCoinIc = ivAzCoinIc;
        this.ivMoney = ivMoney;
        this.ivMoneyIc = ivMoneyIc;
        this.receiveContainer = receiveContainer;
        this.rvReplenishment = rvReplenishment;
        this.tvAzCoins = tvAzCoins;
        this.tvBonus = tvBonus;
        this.tvExchangeRate = tvExchangeRate;
        this.tvMoney = tvMoney;
        this.tvReceive = tvReceive;
        this.tvReplenishment = tvReplenishment;
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
        int i = R.id.dialog_container;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            i = R.id.et_replenishment_sum;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
            if (editText != null) {
                i = R.id.iv_az_coin_ic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.iv_money;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.iv_money_ic;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            i = R.id.receive_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.rv_replenishment;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.tv_az_coins;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.tv_bonus;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_exchange_rate;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_money;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_receive;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_replenishment;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_title;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_you_receive;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView8 != null) {
                                                                    return new DonateReplenishmentDialogBinding((FrameLayout) rootView, cardView, editText, imageView, imageView2, imageView3, linearLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
