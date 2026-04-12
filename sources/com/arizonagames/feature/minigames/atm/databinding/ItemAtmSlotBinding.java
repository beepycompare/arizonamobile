package com.arizonagames.feature.minigames.atm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.atm.R;
/* loaded from: classes3.dex */
public final class ItemAtmSlotBinding implements ViewBinding {
    public final FrameLayout billsContainer;
    private final FrameLayout rootView;
    public final ImageView slotBill1;
    public final ImageView slotBody;
    public final FrameLayout tray;

    private ItemAtmSlotBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.billsContainer = frameLayout2;
        this.slotBill1 = imageView;
        this.slotBody = imageView2;
        this.tray = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemAtmSlotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAtmSlotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_atm_slot, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemAtmSlotBinding bind(View view) {
        int i = R.id.billsContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.slotBill1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.slotBody;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.tray;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        return new ItemAtmSlotBinding((FrameLayout) view, frameLayout, imageView, imageView2, frameLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
