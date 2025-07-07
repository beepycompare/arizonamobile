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
public final class DonateDefaultItemBinding implements ViewBinding {
    public final LinearLayout btnBuy;
    public final ImageView ivMoneyIc;
    private final FrameLayout rootView;
    public final TextView tvName;
    public final TextView tvOldPrice;
    public final TextView tvPrice;

    private DonateDefaultItemBinding(FrameLayout rootView, LinearLayout btnBuy, ImageView ivMoneyIc, TextView tvName, TextView tvOldPrice, TextView tvPrice) {
        this.rootView = rootView;
        this.btnBuy = btnBuy;
        this.ivMoneyIc = ivMoneyIc;
        this.tvName = tvName;
        this.tvOldPrice = tvOldPrice;
        this.tvPrice = tvPrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateDefaultItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateDefaultItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_default_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateDefaultItemBinding bind(View rootView) {
        int i = R.id.btn_buy;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_money_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.tv_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_old_price;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tv_price;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new DonateDefaultItemBinding((FrameLayout) rootView, linearLayout, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
