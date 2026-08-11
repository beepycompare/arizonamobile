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
public final class BankCardItemBinding implements ViewBinding {
    public final TextView cardAmount;
    public final ImageView cardLogo;
    public final TextView cardNumber;
    public final CustomCardView cardRoot;
    public final TextView cardTitle;
    private final CustomCardView rootView;

    private BankCardItemBinding(CustomCardView customCardView, TextView textView, ImageView imageView, TextView textView2, CustomCardView customCardView2, TextView textView3) {
        this.rootView = customCardView;
        this.cardAmount = textView;
        this.cardLogo = imageView;
        this.cardNumber = textView2;
        this.cardRoot = customCardView2;
        this.cardTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_card_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankCardItemBinding bind(View view) {
        int i = R.id.card_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.card_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.card_number;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    CustomCardView customCardView = (CustomCardView) view;
                    i = R.id.card_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new BankCardItemBinding(customCardView, textView, imageView, textView2, customCardView, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
