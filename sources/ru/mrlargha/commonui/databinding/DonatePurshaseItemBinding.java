package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonatePurshaseItemBinding implements ViewBinding {
    public final LinearLayout btnBuy;
    public final ImageView ivMoneyIc;
    private final FrameLayout rootView;
    public final TextView tvAzCoins;
    public final TextView tvBonus;
    public final TextView tvOldPrice;
    public final TextView tvPrice;

    private DonatePurshaseItemBinding(FrameLayout rootView, LinearLayout btnBuy, ImageView ivMoneyIc, TextView tvAzCoins, TextView tvBonus, TextView tvOldPrice, TextView tvPrice) {
        this.rootView = rootView;
        this.btnBuy = btnBuy;
        this.ivMoneyIc = ivMoneyIc;
        this.tvAzCoins = tvAzCoins;
        this.tvBonus = tvBonus;
        this.tvOldPrice = tvOldPrice;
        this.tvPrice = tvPrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonatePurshaseItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePurshaseItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_purshase_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePurshaseItemBinding bind(View rootView) {
        int i = R.id.btn_buy;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_money_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.tv_az_coins;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_bonus;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tv_old_price;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.tv_price;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                return new DonatePurshaseItemBinding((FrameLayout) rootView, linearLayout, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
