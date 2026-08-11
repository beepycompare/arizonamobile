package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankTaxPayAllItemBinding implements ViewBinding {
    public final CustomCardView bankTaxPayAllItem;
    public final TextView bankTaxPayAllText;
    private final CustomCardView rootView;

    private BankTaxPayAllItemBinding(CustomCardView customCardView, CustomCardView customCardView2, TextView textView) {
        this.rootView = customCardView;
        this.bankTaxPayAllItem = customCardView2;
        this.bankTaxPayAllText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankTaxPayAllItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankTaxPayAllItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_tax_pay_all_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankTaxPayAllItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.bank_tax_pay_all_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new BankTaxPayAllItemBinding(customCardView, customCardView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
