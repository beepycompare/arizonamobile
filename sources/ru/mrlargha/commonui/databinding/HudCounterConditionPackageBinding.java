package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudCounterConditionPackageBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvSecond;

    private HudCounterConditionPackageBinding(FrameLayout rootView, TextView tvSecond) {
        this.rootView = rootView;
        this.tvSecond = tvSecond;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCounterConditionPackageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterConditionPackageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter_condition_package, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterConditionPackageBinding bind(View rootView) {
        int i = R.id.tv_second;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new HudCounterConditionPackageBinding((FrameLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
