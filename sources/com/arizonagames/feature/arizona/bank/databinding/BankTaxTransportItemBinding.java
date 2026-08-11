package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankTaxTransportItemBinding implements ViewBinding {
    public final ImageView bankTaxImage;
    public final FrameLayout bankTaxTransportContent;
    public final CustomCardView bankTaxTransportDisabledOverlay;
    public final FrameLayout bankTaxTransportItem;
    public final CustomCardView bankTaxTransportLock;
    public final TextView bankTaxTransportPrice;
    public final TextView bankTaxTransportTitle;
    private final FrameLayout rootView;

    private BankTaxTransportItemBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, CustomCardView customCardView, FrameLayout frameLayout3, CustomCardView customCardView2, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.bankTaxImage = imageView;
        this.bankTaxTransportContent = frameLayout2;
        this.bankTaxTransportDisabledOverlay = customCardView;
        this.bankTaxTransportItem = frameLayout3;
        this.bankTaxTransportLock = customCardView2;
        this.bankTaxTransportPrice = textView;
        this.bankTaxTransportTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankTaxTransportItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankTaxTransportItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_tax_transport_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankTaxTransportItemBinding bind(View view) {
        int i = R.id.bank_tax_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bank_tax_transport_content;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.bank_tax_transport_disabled_overlay;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view;
                    i = R.id.bank_tax_transport_lock;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.bank_tax_transport_price;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.bank_tax_transport_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new BankTaxTransportItemBinding(frameLayout2, imageView, frameLayout, customCardView, frameLayout2, customCardView2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
