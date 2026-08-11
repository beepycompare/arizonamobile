package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankTransferModalBinding implements ViewBinding {
    public final CustomCardView bankTransferBack;
    public final ImageView bankTransferClose;
    public final FrameLayout bankTransferModal;
    public final CustomCardView bankTransferSubmit;
    private final FrameLayout rootView;

    private BankTransferModalBinding(FrameLayout frameLayout, CustomCardView customCardView, ImageView imageView, FrameLayout frameLayout2, CustomCardView customCardView2) {
        this.rootView = frameLayout;
        this.bankTransferBack = customCardView;
        this.bankTransferClose = imageView;
        this.bankTransferModal = frameLayout2;
        this.bankTransferSubmit = customCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankTransferModalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankTransferModalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_transfer_modal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankTransferModalBinding bind(View view) {
        int i = R.id.bank_transfer_back;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.bank_transfer_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i = R.id.bank_transfer_submit;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    return new BankTransferModalBinding(frameLayout, customCardView, imageView, frameLayout, customCardView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
