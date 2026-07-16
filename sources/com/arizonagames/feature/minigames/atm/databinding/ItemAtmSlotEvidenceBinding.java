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
public final class ItemAtmSlotEvidenceBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final ImageView slotBill1;
    public final ImageView slotBody;
    public final FrameLayout slotSelectedOverlay;
    public final FrameLayout tray;

    private ItemAtmSlotEvidenceBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.slotBill1 = imageView;
        this.slotBody = imageView2;
        this.slotSelectedOverlay = frameLayout2;
        this.tray = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemAtmSlotEvidenceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAtmSlotEvidenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_atm_slot_evidence, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemAtmSlotEvidenceBinding bind(View view) {
        int i = R.id.slotBill1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.slotBody;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.slotSelectedOverlay;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.tray;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        return new ItemAtmSlotEvidenceBinding((FrameLayout) view, imageView, imageView2, frameLayout, frameLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
