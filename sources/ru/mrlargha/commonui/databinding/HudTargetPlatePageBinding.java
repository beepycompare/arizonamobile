package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudTargetPlatePageBinding implements ViewBinding {
    public final HudTargetPlateBinding accessory;
    private final FrameLayout rootView;
    public final HudTargetPlateTransportBinding transport;

    private HudTargetPlatePageBinding(FrameLayout rootView, HudTargetPlateBinding accessory, HudTargetPlateTransportBinding transport) {
        this.rootView = rootView;
        this.accessory = accessory;
        this.transport = transport;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTargetPlatePageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTargetPlatePageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_target_plate_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTargetPlatePageBinding bind(View rootView) {
        int i = R.id.accessory;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            HudTargetPlateBinding bind = HudTargetPlateBinding.bind(findChildViewById);
            int i2 = R.id.transport;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i2);
            if (findChildViewById2 != null) {
                return new HudTargetPlatePageBinding((FrameLayout) rootView, bind, HudTargetPlateTransportBinding.bind(findChildViewById2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
