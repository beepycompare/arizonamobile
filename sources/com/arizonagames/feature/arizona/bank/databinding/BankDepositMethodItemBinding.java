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
public final class BankDepositMethodItemBinding implements ViewBinding {
    public final TextView depositMethodBadge;
    public final ImageView depositMethodIcon;
    public final CustomCardView depositMethodRoot;
    public final TextView depositMethodTitle;
    private final CustomCardView rootView;

    private BankDepositMethodItemBinding(CustomCardView customCardView, TextView textView, ImageView imageView, CustomCardView customCardView2, TextView textView2) {
        this.rootView = customCardView;
        this.depositMethodBadge = textView;
        this.depositMethodIcon = imageView;
        this.depositMethodRoot = customCardView2;
        this.depositMethodTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankDepositMethodItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankDepositMethodItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_deposit_method_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankDepositMethodItemBinding bind(View view) {
        int i = R.id.deposit_method_badge;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.deposit_method_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                CustomCardView customCardView = (CustomCardView) view;
                i = R.id.deposit_method_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new BankDepositMethodItemBinding(customCardView, textView, imageView, customCardView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
