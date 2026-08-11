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
public final class BankTabItemBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final CustomCardView tabCard;
    public final TextView tabHotBadge;
    public final ImageView tabLock;
    public final TextView tabText;

    private BankTabItemBinding(FrameLayout frameLayout, CustomCardView customCardView, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = frameLayout;
        this.tabCard = customCardView;
        this.tabHotBadge = textView;
        this.tabLock = imageView;
        this.tabText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankTabItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_tab_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankTabItemBinding bind(View view) {
        int i = R.id.tab_card;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.tab_hot_badge;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tab_lock;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.tab_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new BankTabItemBinding((FrameLayout) view, customCardView, textView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
