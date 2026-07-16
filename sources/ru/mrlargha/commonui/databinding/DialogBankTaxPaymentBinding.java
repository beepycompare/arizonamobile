package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DialogBankTaxPaymentBinding implements ViewBinding {
    public final TextView bankBusinessPaymentBalance;
    public final CustomCardView bankBusinessPaymentBankAccount;
    public final TextView bankBusinessPaymentBankAccountText;
    public final CustomCardView bankBusinessPaymentCash;
    public final TextView bankBusinessPaymentCashText;
    public final ImageView bankBusinessPaymentClose;
    public final TextView bankBusinessPaymentEmpty;
    public final TextView bankBusinessPaymentInfo;
    public final LinearLayout bankBusinessPaymentInfoContainer;
    public final RecyclerView bankBusinessPaymentList;
    public final CustomCardView bankBusinessPaymentMethodSwitch;
    public final TextView bankBusinessPaymentModalTitle;
    public final CustomCardView bankBusinessPaymentPay;
    public final TextView bankBusinessPaymentPayText;
    public final CustomCardView bankBusinessPaymentPreview;
    public final TextView bankBusinessPaymentPreviewAmount;
    public final TextView bankBusinessPaymentPreviewBadge;
    public final TextView bankBusinessPaymentPreviewTitle;
    public final FrameLayout dialogBankTaxPaymentLayout;
    private final FrameLayout rootView;

    private DialogBankTaxPaymentBinding(FrameLayout rootView, TextView bankBusinessPaymentBalance, CustomCardView bankBusinessPaymentBankAccount, TextView bankBusinessPaymentBankAccountText, CustomCardView bankBusinessPaymentCash, TextView bankBusinessPaymentCashText, ImageView bankBusinessPaymentClose, TextView bankBusinessPaymentEmpty, TextView bankBusinessPaymentInfo, LinearLayout bankBusinessPaymentInfoContainer, RecyclerView bankBusinessPaymentList, CustomCardView bankBusinessPaymentMethodSwitch, TextView bankBusinessPaymentModalTitle, CustomCardView bankBusinessPaymentPay, TextView bankBusinessPaymentPayText, CustomCardView bankBusinessPaymentPreview, TextView bankBusinessPaymentPreviewAmount, TextView bankBusinessPaymentPreviewBadge, TextView bankBusinessPaymentPreviewTitle, FrameLayout dialogBankTaxPaymentLayout) {
        this.rootView = rootView;
        this.bankBusinessPaymentBalance = bankBusinessPaymentBalance;
        this.bankBusinessPaymentBankAccount = bankBusinessPaymentBankAccount;
        this.bankBusinessPaymentBankAccountText = bankBusinessPaymentBankAccountText;
        this.bankBusinessPaymentCash = bankBusinessPaymentCash;
        this.bankBusinessPaymentCashText = bankBusinessPaymentCashText;
        this.bankBusinessPaymentClose = bankBusinessPaymentClose;
        this.bankBusinessPaymentEmpty = bankBusinessPaymentEmpty;
        this.bankBusinessPaymentInfo = bankBusinessPaymentInfo;
        this.bankBusinessPaymentInfoContainer = bankBusinessPaymentInfoContainer;
        this.bankBusinessPaymentList = bankBusinessPaymentList;
        this.bankBusinessPaymentMethodSwitch = bankBusinessPaymentMethodSwitch;
        this.bankBusinessPaymentModalTitle = bankBusinessPaymentModalTitle;
        this.bankBusinessPaymentPay = bankBusinessPaymentPay;
        this.bankBusinessPaymentPayText = bankBusinessPaymentPayText;
        this.bankBusinessPaymentPreview = bankBusinessPaymentPreview;
        this.bankBusinessPaymentPreviewAmount = bankBusinessPaymentPreviewAmount;
        this.bankBusinessPaymentPreviewBadge = bankBusinessPaymentPreviewBadge;
        this.bankBusinessPaymentPreviewTitle = bankBusinessPaymentPreviewTitle;
        this.dialogBankTaxPaymentLayout = dialogBankTaxPaymentLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogBankTaxPaymentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBankTaxPaymentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_bank_tax_payment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBankTaxPaymentBinding bind(View rootView) {
        int i = R.id.bank_business_payment_balance;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.bank_business_payment_bank_account;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.bank_business_payment_bank_account_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.bank_business_payment_cash;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.bank_business_payment_cash_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.bank_business_payment_close;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.bank_business_payment_empty;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.bank_business_payment_info;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.bank_business_payment_info_container;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout != null) {
                                            i = R.id.bank_business_payment_list;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView != null) {
                                                i = R.id.bank_business_payment_method_switch;
                                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                if (customCardView3 != null) {
                                                    i = R.id.bank_business_payment_modal_title;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView6 != null) {
                                                        i = R.id.bank_business_payment_pay;
                                                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                        if (customCardView4 != null) {
                                                            i = R.id.bank_business_payment_pay_text;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView7 != null) {
                                                                i = R.id.bank_business_payment_preview;
                                                                CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                if (customCardView5 != null) {
                                                                    i = R.id.bank_business_payment_preview_amount;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.bank_business_payment_preview_badge;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.bank_business_payment_preview_title;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView10 != null) {
                                                                                FrameLayout frameLayout = (FrameLayout) rootView;
                                                                                return new DialogBankTaxPaymentBinding(frameLayout, textView, customCardView, textView2, customCardView2, textView3, imageView, textView4, textView5, linearLayout, recyclerView, customCardView3, textView6, customCardView4, textView7, customCardView5, textView8, textView9, textView10, frameLayout);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
