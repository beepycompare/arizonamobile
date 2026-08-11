package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankCurrencyPageBinding implements ViewBinding {
    public final CustomCardView bankCurrencyBalanceBar;
    public final TextView bankCurrencyBalanceDollars;
    public final RecyclerView bankCurrencyList;
    private final FrameLayout rootView;

    private BankCurrencyPageBinding(FrameLayout frameLayout, CustomCardView customCardView, TextView textView, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.bankCurrencyBalanceBar = customCardView;
        this.bankCurrencyBalanceDollars = textView;
        this.bankCurrencyList = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankCurrencyPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankCurrencyPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_currency_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankCurrencyPageBinding bind(View view) {
        int i = R.id.bank_currency_balance_bar;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.bank_currency_balance_dollars;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.bank_currency_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    return new BankCurrencyPageBinding((FrameLayout) view, customCardView, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
