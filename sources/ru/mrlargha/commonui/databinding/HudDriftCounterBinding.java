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
public final class HudDriftCounterBinding implements ViewBinding {
    public final LinearLayout countdownContainer;
    public final TextView countdownLabel;
    public final TextView elapsedTime;
    public final TextView multiplier;
    private final FrameLayout rootView;
    public final LinearLayout scoreContainer;
    public final TextView scoreValue;
    public final TextView speedStatus;

    private HudDriftCounterBinding(FrameLayout rootView, LinearLayout countdownContainer, TextView countdownLabel, TextView elapsedTime, TextView multiplier, LinearLayout scoreContainer, TextView scoreValue, TextView speedStatus) {
        this.rootView = rootView;
        this.countdownContainer = countdownContainer;
        this.countdownLabel = countdownLabel;
        this.elapsedTime = elapsedTime;
        this.multiplier = multiplier;
        this.scoreContainer = scoreContainer;
        this.scoreValue = scoreValue;
        this.speedStatus = speedStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudDriftCounterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudDriftCounterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_drift_counter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudDriftCounterBinding bind(View rootView) {
        int i = R.id.countdown_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.countdown_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.elapsed_time;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.multiplier;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.score_container;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.score_value;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.speed_status;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView5 != null) {
                                    return new HudDriftCounterBinding((FrameLayout) rootView, linearLayout, textView, textView2, textView3, linearLayout2, textView4, textView5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
