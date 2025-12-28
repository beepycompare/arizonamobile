package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class FlashGrenadeBinding implements ViewBinding {
    public final ConstraintLayout flashGrenade;
    private final ConstraintLayout rootView;

    private FlashGrenadeBinding(ConstraintLayout rootView, ConstraintLayout flashGrenade) {
        this.rootView = rootView;
        this.flashGrenade = flashGrenade;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FlashGrenadeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FlashGrenadeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.flash_grenade, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FlashGrenadeBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        return new FlashGrenadeBinding(constraintLayout, constraintLayout);
    }
}
