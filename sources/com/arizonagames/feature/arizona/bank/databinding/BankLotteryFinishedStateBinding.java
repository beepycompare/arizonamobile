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
public final class BankLotteryFinishedStateBinding implements ViewBinding {
    public final TextView bankLotteryFinishedDescription;
    public final TextView bankLotteryFinishedTitle;
    private final CustomCardView rootView;

    private BankLotteryFinishedStateBinding(CustomCardView customCardView, TextView textView, TextView textView2) {
        this.rootView = customCardView;
        this.bankLotteryFinishedDescription = textView;
        this.bankLotteryFinishedTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankLotteryFinishedStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankLotteryFinishedStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_lottery_finished_state, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankLotteryFinishedStateBinding bind(View view) {
        int i = R.id.bank_lottery_finished_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_lottery_finished_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new BankLotteryFinishedStateBinding((CustomCardView) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
