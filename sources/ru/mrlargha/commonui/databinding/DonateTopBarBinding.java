package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateTopBarBinding implements ViewBinding {
    public final CardView boostContainer;
    public final ImageView btnAddAzCoins;
    public final ImageView btnAddMoney;
    public final ImageView btnClose;
    public final LinearLayout btnEvent;
    public final ImageView ivAzIc;
    public final ImageView ivEvent;
    public final ImageView ivMoneyIc;
    private final FrameLayout rootView;
    public final TextView tvAzCoin;
    public final TextView tvBoostPayment;
    public final TextView tvEvent;
    public final TextView tvMoneyCount;
    public final TextView tvTitle;

    private DonateTopBarBinding(FrameLayout rootView, CardView boostContainer, ImageView btnAddAzCoins, ImageView btnAddMoney, ImageView btnClose, LinearLayout btnEvent, ImageView ivAzIc, ImageView ivEvent, ImageView ivMoneyIc, TextView tvAzCoin, TextView tvBoostPayment, TextView tvEvent, TextView tvMoneyCount, TextView tvTitle) {
        this.rootView = rootView;
        this.boostContainer = boostContainer;
        this.btnAddAzCoins = btnAddAzCoins;
        this.btnAddMoney = btnAddMoney;
        this.btnClose = btnClose;
        this.btnEvent = btnEvent;
        this.ivAzIc = ivAzIc;
        this.ivEvent = ivEvent;
        this.ivMoneyIc = ivMoneyIc;
        this.tvAzCoin = tvAzCoin;
        this.tvBoostPayment = tvBoostPayment;
        this.tvEvent = tvEvent;
        this.tvMoneyCount = tvMoneyCount;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateTopBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateTopBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_top_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateTopBarBinding bind(View rootView) {
        int i = R.id.boost_container;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            i = R.id.btn_add_az_coins;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.btn_add_money;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.btn_close;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.btn_event;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.iv_az_ic;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView4 != null) {
                                i = R.id.iv_event;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView5 != null) {
                                    i = R.id.iv_money_ic;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView6 != null) {
                                        i = R.id.tv_az_coin;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.tv_boost_payment;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_event;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_money_count;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_title;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView5 != null) {
                                                            return new DonateTopBarBinding((FrameLayout) rootView, cardView, imageView, imageView2, imageView3, linearLayout, imageView4, imageView5, imageView6, textView, textView2, textView3, textView4, textView5);
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
