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
public final class LayoutGuardBtnMenuBinding implements ViewBinding {
    public final TextView btnGuardMenu;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;

    private LayoutGuardBtnMenuBinding(ConstraintLayout rootView, TextView btnGuardMenu, ConstraintLayout parentLayout) {
        this.rootView = rootView;
        this.btnGuardMenu = btnGuardMenu;
        this.parentLayout = parentLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutGuardBtnMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutGuardBtnMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_guard_btn_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutGuardBtnMenuBinding bind(View rootView) {
        int i = R.id.btnGuardMenu;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            return new LayoutGuardBtnMenuBinding(constraintLayout, textView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
