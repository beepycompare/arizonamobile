package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
/* loaded from: classes6.dex */
public final class HudCounterEscapeBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final ArizonaGradientTextView tvFirst;
    public final TextView tvTitle;

    private HudCounterEscapeBinding(FrameLayout rootView, ArizonaGradientTextView tvFirst, TextView tvTitle) {
        this.rootView = rootView;
        this.tvFirst = tvFirst;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCounterEscapeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterEscapeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter_escape, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterEscapeBinding bind(View rootView) {
        int i = R.id.tv_first;
        ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(rootView, i);
        if (arizonaGradientTextView != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new HudCounterEscapeBinding((FrameLayout) rootView, arizonaGradientTextView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
