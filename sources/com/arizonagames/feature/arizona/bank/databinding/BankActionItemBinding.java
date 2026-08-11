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
public final class BankActionItemBinding implements ViewBinding {
    public final ImageView actionIcon;
    public final CustomCardView actionRoot;
    public final TextView actionSubtitle;
    public final TextView actionTitle;
    private final CustomCardView rootView;

    private BankActionItemBinding(CustomCardView customCardView, ImageView imageView, CustomCardView customCardView2, TextView textView, TextView textView2) {
        this.rootView = customCardView;
        this.actionIcon = imageView;
        this.actionRoot = customCardView2;
        this.actionSubtitle = textView;
        this.actionTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankActionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankActionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_action_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankActionItemBinding bind(View view) {
        int i = R.id.action_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            CustomCardView customCardView = (CustomCardView) view;
            i = R.id.action_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.action_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new BankActionItemBinding(customCardView, imageView, customCardView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
