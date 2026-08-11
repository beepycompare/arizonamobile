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
public final class BankPaymentConfirmationModalBinding implements ViewBinding {
    public final TextView bankPaymentConfirmationAmount1;
    public final TextView bankPaymentConfirmationAmount2;
    public final TextView bankPaymentConfirmationAmount3;
    public final CustomCardView bankPaymentConfirmationBack;
    public final TextView bankPaymentConfirmationBankAccount;
    public final CustomCardView bankPaymentConfirmationCash;
    public final ImageView bankPaymentConfirmationClose;
    public final CustomCardView bankPaymentConfirmationConfirm;
    public final CustomCardView bankPaymentConfirmationMethodSwitch;
    public final FrameLayout bankPaymentConfirmationModal;
    public final TextView bankPaymentConfirmationSubtitle;
    public final TextView bankPaymentConfirmationTitle;
    private final FrameLayout rootView;

    private BankPaymentConfirmationModalBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, CustomCardView customCardView, TextView textView4, CustomCardView customCardView2, ImageView imageView, CustomCardView customCardView3, CustomCardView customCardView4, FrameLayout frameLayout2, TextView textView5, TextView textView6) {
        this.rootView = frameLayout;
        this.bankPaymentConfirmationAmount1 = textView;
        this.bankPaymentConfirmationAmount2 = textView2;
        this.bankPaymentConfirmationAmount3 = textView3;
        this.bankPaymentConfirmationBack = customCardView;
        this.bankPaymentConfirmationBankAccount = textView4;
        this.bankPaymentConfirmationCash = customCardView2;
        this.bankPaymentConfirmationClose = imageView;
        this.bankPaymentConfirmationConfirm = customCardView3;
        this.bankPaymentConfirmationMethodSwitch = customCardView4;
        this.bankPaymentConfirmationModal = frameLayout2;
        this.bankPaymentConfirmationSubtitle = textView5;
        this.bankPaymentConfirmationTitle = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankPaymentConfirmationModalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankPaymentConfirmationModalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_payment_confirmation_modal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankPaymentConfirmationModalBinding bind(View view) {
        int i = R.id.bank_payment_confirmation_amount_1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_payment_confirmation_amount_2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.bank_payment_confirmation_amount_3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.bank_payment_confirmation_back;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView != null) {
                        i = R.id.bank_payment_confirmation_bank_account;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.bank_payment_confirmation_cash;
                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView2 != null) {
                                i = R.id.bank_payment_confirmation_close;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.bank_payment_confirmation_confirm;
                                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView3 != null) {
                                        i = R.id.bank_payment_confirmation_method_switch;
                                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                        if (customCardView4 != null) {
                                            FrameLayout frameLayout = (FrameLayout) view;
                                            i = R.id.bank_payment_confirmation_subtitle;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.bank_payment_confirmation_title;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    return new BankPaymentConfirmationModalBinding(frameLayout, textView, textView2, textView3, customCardView, textView4, customCardView2, imageView, customCardView3, customCardView4, frameLayout, textView5, textView6);
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
