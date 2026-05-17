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
public final class HudElementPaydayWarningBinding implements ViewBinding {
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final TextView text;

    private HudElementPaydayWarningBinding(FrameLayout rootView, FrameLayout root, TextView text) {
        this.rootView = rootView;
        this.root = root;
        this.text = text;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementPaydayWarningBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementPaydayWarningBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_payday_warning, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementPaydayWarningBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new HudElementPaydayWarningBinding(frameLayout, frameLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
