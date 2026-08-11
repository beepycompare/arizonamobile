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
public final class BankServiceItemBinding implements ViewBinding {
    private final CustomCardView rootView;
    public final ImageView serviceIcon;
    public final CustomCardView serviceRoot;
    public final TextView serviceSubtitle;
    public final TextView serviceTitle;

    private BankServiceItemBinding(CustomCardView customCardView, ImageView imageView, CustomCardView customCardView2, TextView textView, TextView textView2) {
        this.rootView = customCardView;
        this.serviceIcon = imageView;
        this.serviceRoot = customCardView2;
        this.serviceSubtitle = textView;
        this.serviceTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankServiceItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankServiceItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_service_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankServiceItemBinding bind(View view) {
        int i = R.id.service_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            CustomCardView customCardView = (CustomCardView) view;
            i = R.id.service_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.service_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new BankServiceItemBinding(customCardView, imageView, customCardView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
