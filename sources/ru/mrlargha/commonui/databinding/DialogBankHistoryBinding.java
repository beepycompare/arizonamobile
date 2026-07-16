package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DialogBankHistoryBinding implements ViewBinding {
    public final CustomCardView dialogBankHistoryClose;
    public final TextView dialogBankHistoryEmpty;
    public final FrameLayout dialogBankHistoryLayout;
    public final RecyclerView dialogBankHistoryList;
    public final CustomCardView dialogBankHistoryTabAll;
    public final TextView dialogBankHistoryTabAllText;
    public final CustomCardView dialogBankHistoryTabDeposit;
    public final TextView dialogBankHistoryTabDepositText;
    public final CustomCardView dialogBankHistoryTabTransfer;
    public final TextView dialogBankHistoryTabTransferText;
    public final CustomCardView dialogBankHistoryTabWithdraw;
    public final TextView dialogBankHistoryTabWithdrawText;
    public final LinearLayout dialogBankHistoryTabs;
    public final TextView dialogBankHistoryTitle;
    private final FrameLayout rootView;

    private DialogBankHistoryBinding(FrameLayout rootView, CustomCardView dialogBankHistoryClose, TextView dialogBankHistoryEmpty, FrameLayout dialogBankHistoryLayout, RecyclerView dialogBankHistoryList, CustomCardView dialogBankHistoryTabAll, TextView dialogBankHistoryTabAllText, CustomCardView dialogBankHistoryTabDeposit, TextView dialogBankHistoryTabDepositText, CustomCardView dialogBankHistoryTabTransfer, TextView dialogBankHistoryTabTransferText, CustomCardView dialogBankHistoryTabWithdraw, TextView dialogBankHistoryTabWithdrawText, LinearLayout dialogBankHistoryTabs, TextView dialogBankHistoryTitle) {
        this.rootView = rootView;
        this.dialogBankHistoryClose = dialogBankHistoryClose;
        this.dialogBankHistoryEmpty = dialogBankHistoryEmpty;
        this.dialogBankHistoryLayout = dialogBankHistoryLayout;
        this.dialogBankHistoryList = dialogBankHistoryList;
        this.dialogBankHistoryTabAll = dialogBankHistoryTabAll;
        this.dialogBankHistoryTabAllText = dialogBankHistoryTabAllText;
        this.dialogBankHistoryTabDeposit = dialogBankHistoryTabDeposit;
        this.dialogBankHistoryTabDepositText = dialogBankHistoryTabDepositText;
        this.dialogBankHistoryTabTransfer = dialogBankHistoryTabTransfer;
        this.dialogBankHistoryTabTransferText = dialogBankHistoryTabTransferText;
        this.dialogBankHistoryTabWithdraw = dialogBankHistoryTabWithdraw;
        this.dialogBankHistoryTabWithdrawText = dialogBankHistoryTabWithdrawText;
        this.dialogBankHistoryTabs = dialogBankHistoryTabs;
        this.dialogBankHistoryTitle = dialogBankHistoryTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogBankHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBankHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_bank_history, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBankHistoryBinding bind(View rootView) {
        int i = R.id.dialog_bank_history_close;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.dialog_bank_history_empty;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.dialog_bank_history_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    i = R.id.dialog_bank_history_tab_all;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.dialog_bank_history_tab_all_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.dialog_bank_history_tab_deposit;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView3 != null) {
                                i = R.id.dialog_bank_history_tab_deposit_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.dialog_bank_history_tab_transfer;
                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (customCardView4 != null) {
                                        i = R.id.dialog_bank_history_tab_transfer_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.dialog_bank_history_tab_withdraw;
                                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                            if (customCardView5 != null) {
                                                i = R.id.dialog_bank_history_tab_withdraw_text;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.dialog_bank_history_tabs;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout != null) {
                                                        i = R.id.dialog_bank_history_title;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView6 != null) {
                                                            return new DialogBankHistoryBinding(frameLayout, customCardView, textView, frameLayout, recyclerView, customCardView2, textView2, customCardView3, textView3, customCardView4, textView4, customCardView5, textView5, linearLayout, textView6);
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
