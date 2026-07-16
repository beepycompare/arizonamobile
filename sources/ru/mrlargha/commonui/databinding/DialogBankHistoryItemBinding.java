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
public final class DialogBankHistoryItemBinding implements ViewBinding {
    public final TextView dialogBankHistoryItemAmount;
    public final TextView dialogBankHistoryItemDate;
    public final ImageView dialogBankHistoryItemIcon;
    public final TextView dialogBankHistoryItemId;
    public final TextView dialogBankHistoryItemPercent;
    public final CustomCardView dialogBankHistoryItemRoot;
    public final TextView dialogBankHistoryItemTarget;
    public final TextView dialogBankHistoryItemType;
    private final CustomCardView rootView;

    private DialogBankHistoryItemBinding(CustomCardView rootView, TextView dialogBankHistoryItemAmount, TextView dialogBankHistoryItemDate, ImageView dialogBankHistoryItemIcon, TextView dialogBankHistoryItemId, TextView dialogBankHistoryItemPercent, CustomCardView dialogBankHistoryItemRoot, TextView dialogBankHistoryItemTarget, TextView dialogBankHistoryItemType) {
        this.rootView = rootView;
        this.dialogBankHistoryItemAmount = dialogBankHistoryItemAmount;
        this.dialogBankHistoryItemDate = dialogBankHistoryItemDate;
        this.dialogBankHistoryItemIcon = dialogBankHistoryItemIcon;
        this.dialogBankHistoryItemId = dialogBankHistoryItemId;
        this.dialogBankHistoryItemPercent = dialogBankHistoryItemPercent;
        this.dialogBankHistoryItemRoot = dialogBankHistoryItemRoot;
        this.dialogBankHistoryItemTarget = dialogBankHistoryItemTarget;
        this.dialogBankHistoryItemType = dialogBankHistoryItemType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static DialogBankHistoryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBankHistoryItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_bank_history_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBankHistoryItemBinding bind(View rootView) {
        int i = R.id.dialog_bank_history_item_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.dialog_bank_history_item_date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.dialog_bank_history_item_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.dialog_bank_history_item_id;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.dialog_bank_history_item_percent;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            CustomCardView customCardView = (CustomCardView) rootView;
                            i = R.id.dialog_bank_history_item_target;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.dialog_bank_history_item_type;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    return new DialogBankHistoryItemBinding(customCardView, textView, textView2, imageView, textView3, textView4, customCardView, textView5, textView6);
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
