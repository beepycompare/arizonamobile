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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankHouseTaxPaymentModalBinding implements ViewBinding {
    public final TextView bankHouseTaxPaymentBankAccount;
    public final CustomCardView bankHouseTaxPaymentCash;
    public final ImageView bankHouseTaxPaymentClose;
    public final CustomCardView bankHouseTaxPaymentMethodSwitch;
    public final FrameLayout bankHouseTaxPaymentModal;
    public final CustomCardView bankHouseTaxPaymentPay;
    private final FrameLayout rootView;

    private BankHouseTaxPaymentModalBinding(FrameLayout frameLayout, TextView textView, CustomCardView customCardView, ImageView imageView, CustomCardView customCardView2, FrameLayout frameLayout2, CustomCardView customCardView3) {
        this.rootView = frameLayout;
        this.bankHouseTaxPaymentBankAccount = textView;
        this.bankHouseTaxPaymentCash = customCardView;
        this.bankHouseTaxPaymentClose = imageView;
        this.bankHouseTaxPaymentMethodSwitch = customCardView2;
        this.bankHouseTaxPaymentModal = frameLayout2;
        this.bankHouseTaxPaymentPay = customCardView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankHouseTaxPaymentModalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankHouseTaxPaymentModalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_house_tax_payment_modal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankHouseTaxPaymentModalBinding bind(View view) {
        int i = R.id.bank_house_tax_payment_bank_account;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_house_tax_payment_cash;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.bank_house_tax_payment_close;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.bank_house_tax_payment_method_switch;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        i = R.id.bank_house_tax_payment_pay;
                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView3 != null) {
                            return new BankHouseTaxPaymentModalBinding(frameLayout, textView, customCardView, imageView, customCardView2, frameLayout, customCardView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
