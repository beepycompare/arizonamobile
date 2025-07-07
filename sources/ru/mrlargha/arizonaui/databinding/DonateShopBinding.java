package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DonateShopBinding implements ViewBinding {
    public final TextView categoryChosenTitle;
    public final RecyclerView categoryRcView;
    public final AppCompatImageView closeDonate;
    public final Button donatePay;
    public final RelativeLayout donateShop;
    public final LinearLayout filters;
    public final RecyclerView rcView;
    private final RelativeLayout rootView;
    public final TextView title;
    public final AppCompatImageView tvAzCoin;
    public final TextView tvBalance;
    public final TextView tvBalanceTittle;
    public final LinearLayout wrapper;

    private DonateShopBinding(RelativeLayout relativeLayout, TextView textView, RecyclerView recyclerView, AppCompatImageView appCompatImageView, Button button, RelativeLayout relativeLayout2, LinearLayout linearLayout, RecyclerView recyclerView2, TextView textView2, AppCompatImageView appCompatImageView2, TextView textView3, TextView textView4, LinearLayout linearLayout2) {
        this.rootView = relativeLayout;
        this.categoryChosenTitle = textView;
        this.categoryRcView = recyclerView;
        this.closeDonate = appCompatImageView;
        this.donatePay = button;
        this.donateShop = relativeLayout2;
        this.filters = linearLayout;
        this.rcView = recyclerView2;
        this.title = textView2;
        this.tvAzCoin = appCompatImageView2;
        this.tvBalance = textView3;
        this.tvBalanceTittle = textView4;
        this.wrapper = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DonateShopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DonateShopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.donate_shop, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateShopBinding bind(View view) {
        int i = R.id.category_chosen_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.categoryRcView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.closeDonate;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.donate_pay;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i = R.id.filters;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.rcView;
                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView2 != null) {
                                i = R.id.title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_az_coin;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatImageView2 != null) {
                                        i = R.id.tv_balance;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_balance_tittle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.wrapper;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout2 != null) {
                                                    return new DonateShopBinding(relativeLayout, textView, recyclerView, appCompatImageView, button, relativeLayout, linearLayout, recyclerView2, textView2, appCompatImageView2, textView3, textView4, linearLayout2);
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
