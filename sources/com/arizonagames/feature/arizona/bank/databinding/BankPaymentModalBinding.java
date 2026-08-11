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
public final class BankPaymentModalBinding implements ViewBinding {
    public final FrameLayout bankPaymentModal;
    public final TextView bankPaymentModalAmountAccent;
    public final TextView bankPaymentModalAmountMain;
    public final TextView bankPaymentModalAmountSecondary;
    public final TextView bankPaymentModalBankAccount;
    public final CustomCardView bankPaymentModalCash;
    public final ImageView bankPaymentModalClose;
    public final TextView bankPaymentModalId;
    public final CustomCardView bankPaymentModalMethodSwitch;
    public final TextView bankPaymentModalName;
    public final CustomCardView bankPaymentModalPay;
    public final CustomCardView bankPaymentModalPreview;
    public final TextView bankPaymentModalPreviewAmount;
    public final TextView bankPaymentModalPreviewTitle;
    public final TextView bankPaymentModalTitle;
    private final FrameLayout rootView;

    private BankPaymentModalBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, CustomCardView customCardView, ImageView imageView, TextView textView5, CustomCardView customCardView2, TextView textView6, CustomCardView customCardView3, CustomCardView customCardView4, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = frameLayout;
        this.bankPaymentModal = frameLayout2;
        this.bankPaymentModalAmountAccent = textView;
        this.bankPaymentModalAmountMain = textView2;
        this.bankPaymentModalAmountSecondary = textView3;
        this.bankPaymentModalBankAccount = textView4;
        this.bankPaymentModalCash = customCardView;
        this.bankPaymentModalClose = imageView;
        this.bankPaymentModalId = textView5;
        this.bankPaymentModalMethodSwitch = customCardView2;
        this.bankPaymentModalName = textView6;
        this.bankPaymentModalPay = customCardView3;
        this.bankPaymentModalPreview = customCardView4;
        this.bankPaymentModalPreviewAmount = textView7;
        this.bankPaymentModalPreviewTitle = textView8;
        this.bankPaymentModalTitle = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankPaymentModalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankPaymentModalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_payment_modal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankPaymentModalBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.bank_payment_modal_amount_accent;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_payment_modal_amount_main;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.bank_payment_modal_amount_secondary;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.bank_payment_modal_bank_account;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.bank_payment_modal_cash;
                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView != null) {
                            i = R.id.bank_payment_modal_close;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.bank_payment_modal_id;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.bank_payment_modal_method_switch;
                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView2 != null) {
                                        i = R.id.bank_payment_modal_name;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.bank_payment_modal_pay;
                                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView3 != null) {
                                                i = R.id.bank_payment_modal_preview;
                                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView4 != null) {
                                                    i = R.id.bank_payment_modal_preview_amount;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.bank_payment_modal_preview_title;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.bank_payment_modal_title;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                return new BankPaymentModalBinding(frameLayout, frameLayout, textView, textView2, textView3, textView4, customCardView, imageView, textView5, customCardView2, textView6, customCardView3, customCardView4, textView7, textView8, textView9);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
