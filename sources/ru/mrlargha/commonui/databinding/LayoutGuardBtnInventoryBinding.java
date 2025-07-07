package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutGuardBtnInventoryBinding implements ViewBinding {
    public final TextView btnGuardInventory;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;

    private LayoutGuardBtnInventoryBinding(ConstraintLayout rootView, TextView btnGuardInventory, ConstraintLayout parentLayout) {
        this.rootView = rootView;
        this.btnGuardInventory = btnGuardInventory;
        this.parentLayout = parentLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutGuardBtnInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutGuardBtnInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_guard_btn_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutGuardBtnInventoryBinding bind(View rootView) {
        int i = R.id.btnGuardInventory;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            return new LayoutGuardBtnInventoryBinding(constraintLayout, textView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
