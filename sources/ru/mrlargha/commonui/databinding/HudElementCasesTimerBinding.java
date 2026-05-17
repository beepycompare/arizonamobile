package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudElementCasesTimerBinding implements ViewBinding {
    public final FrameLayout casesTimer;
    public final ImageView image;
    public final CustomCardView main;
    private final FrameLayout rootView;
    public final TextView timer;
    public final TextView topText;

    private HudElementCasesTimerBinding(FrameLayout rootView, FrameLayout casesTimer, ImageView image, CustomCardView main, TextView timer, TextView topText) {
        this.rootView = rootView;
        this.casesTimer = casesTimer;
        this.image = image;
        this.main = main;
        this.timer = timer;
        this.topText = topText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementCasesTimerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementCasesTimerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_cases_timer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementCasesTimerBinding bind(View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.main;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.timer;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.top_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new HudElementCasesTimerBinding(frameLayout, frameLayout, imageView, customCardView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
