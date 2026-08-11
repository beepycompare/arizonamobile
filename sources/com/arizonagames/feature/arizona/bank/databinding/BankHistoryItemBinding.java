package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankHistoryItemBinding implements ViewBinding {
    public final TextView historyAmount;
    public final ImageView historyIcon;
    public final CustomCardView historyRoot;
    public final TextView historySubtitle;
    public final TextView historyTitle;
    private final CustomCardView rootView;

    private BankHistoryItemBinding(CustomCardView customCardView, TextView textView, ImageView imageView, CustomCardView customCardView2, TextView textView2, TextView textView3) {
        this.rootView = customCardView;
        this.historyAmount = textView;
        this.historyIcon = imageView;
        this.historyRoot = customCardView2;
        this.historySubtitle = textView2;
        this.historyTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankHistoryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankHistoryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_history_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankHistoryItemBinding bind(View view) {
        int i = R.id.history_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.history_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                CustomCardView customCardView = (CustomCardView) view;
                i = R.id.history_subtitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.history_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new BankHistoryItemBinding(customCardView, textView, imageView, customCardView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
