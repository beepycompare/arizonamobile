package com.arizonagames.feature.minigames.atm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.atm.R;
/* loaded from: classes3.dex */
public final class ItemAtmSlotChickenBinding implements ViewBinding {
    public final ConstraintLayout billsContainer;
    private final FrameLayout rootView;
    public final ImageView slotBill1;
    public final ImageView slotBody;
    public final FrameLayout tray;

    private ItemAtmSlotChickenBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.billsContainer = constraintLayout;
        this.slotBill1 = imageView;
        this.slotBody = imageView2;
        this.tray = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemAtmSlotChickenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAtmSlotChickenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_atm_slot_chicken, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemAtmSlotChickenBinding bind(View view) {
        int i = R.id.billsContainer;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.slotBill1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.slotBody;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.tray;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new ItemAtmSlotChickenBinding((FrameLayout) view, constraintLayout, imageView, imageView2, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
