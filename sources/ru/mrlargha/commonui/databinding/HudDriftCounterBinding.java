package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudDriftCounterBinding implements ViewBinding {
    public final TextView driftMoneyTimer;
    public final TextView money;
    public final TextView moneyMultiplier;
    public final TextView pointMultiplier;
    public final TextView points;
    private final LinearLayout rootView;
    public final LinearLayout scoreContainer;
    public final LinearLayout speedContainer;
    public final TextView speedSpeedStatus;
    public final TextView speedStatus;

    private HudDriftCounterBinding(LinearLayout rootView, TextView driftMoneyTimer, TextView money, TextView moneyMultiplier, TextView pointMultiplier, TextView points, LinearLayout scoreContainer, LinearLayout speedContainer, TextView speedSpeedStatus, TextView speedStatus) {
        this.rootView = rootView;
        this.driftMoneyTimer = driftMoneyTimer;
        this.money = money;
        this.moneyMultiplier = moneyMultiplier;
        this.pointMultiplier = pointMultiplier;
        this.points = points;
        this.scoreContainer = scoreContainer;
        this.speedContainer = speedContainer;
        this.speedSpeedStatus = speedSpeedStatus;
        this.speedStatus = speedStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
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
        int i = R.id.drift_money_timer;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.money;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.money_multiplier;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.point_multiplier;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.points;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.score_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.speed_container;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    i = R.id.speed_speed_status;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView6 != null) {
                                        i = R.id.speed_status;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView7 != null) {
                                            return new HudDriftCounterBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, linearLayout, linearLayout2, textView6, textView7);
                                        }
                                    }
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
