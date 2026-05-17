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
public final class HudSupplyBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvOutOf;
    public final TextView tvTitle;

    private HudSupplyBinding(FrameLayout rootView, TextView tvOutOf, TextView tvTitle) {
        this.rootView = rootView;
        this.tvOutOf = tvOutOf;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudSupplyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudSupplyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_supply, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudSupplyBinding bind(View rootView) {
        int i = R.id.tv_out_of;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new HudSupplyBinding((FrameLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
