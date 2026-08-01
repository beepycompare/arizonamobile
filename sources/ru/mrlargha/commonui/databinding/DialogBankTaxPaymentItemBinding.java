package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DialogBankTaxPaymentItemBinding implements ViewBinding {
    public final CustomCardView bankTaxPaymentItem;
    public final TextView bankTaxPaymentItemAmount;
    public final ImageView bankTaxPaymentItemCheck;
    public final TextView bankTaxPaymentItemId;
    public final CustomCardView bankTaxPaymentItemMarker;
    public final TextView bankTaxPaymentItemName;
    private final CustomCardView rootView;

    private DialogBankTaxPaymentItemBinding(CustomCardView rootView, CustomCardView bankTaxPaymentItem, TextView bankTaxPaymentItemAmount, ImageView bankTaxPaymentItemCheck, TextView bankTaxPaymentItemId, CustomCardView bankTaxPaymentItemMarker, TextView bankTaxPaymentItemName) {
        this.rootView = rootView;
        this.bankTaxPaymentItem = bankTaxPaymentItem;
        this.bankTaxPaymentItemAmount = bankTaxPaymentItemAmount;
        this.bankTaxPaymentItemCheck = bankTaxPaymentItemCheck;
        this.bankTaxPaymentItemId = bankTaxPaymentItemId;
        this.bankTaxPaymentItemMarker = bankTaxPaymentItemMarker;
        this.bankTaxPaymentItemName = bankTaxPaymentItemName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static DialogBankTaxPaymentItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBankTaxPaymentItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_bank_tax_payment_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBankTaxPaymentItemBinding bind(View rootView) {
        CustomCardView customCardView = (CustomCardView) rootView;
        int i = R.id.bank_tax_payment_item_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.bank_tax_payment_item_check;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.bank_tax_payment_item_id;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.bank_tax_payment_item_marker;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.bank_tax_payment_item_name;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new DialogBankTaxPaymentItemBinding(customCardView, customCardView, textView, imageView, textView2, customCardView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
