package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudCountdownBinding implements ViewBinding {
    public final LinearLayout countdownContainer;
    public final TextView countdownLabel;
    private final FrameLayout rootView;

    private HudCountdownBinding(FrameLayout rootView, LinearLayout countdownContainer, TextView countdownLabel) {
        this.rootView = rootView;
        this.countdownContainer = countdownContainer;
        this.countdownLabel = countdownLabel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCountdownBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCountdownBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_countdown, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCountdownBinding bind(View rootView) {
        int i = R.id.countdown_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.countdown_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new HudCountdownBinding((FrameLayout) rootView, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
