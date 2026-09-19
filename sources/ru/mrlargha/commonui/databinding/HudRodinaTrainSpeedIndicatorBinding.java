package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.hud.presentation.view.RodinaTrainSpeedGaugeView;
/* loaded from: classes6.dex */
public final class HudRodinaTrainSpeedIndicatorBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView trainCurrentSpeedValue;
    public final RodinaTrainSpeedGaugeView trainSpeedGauge;

    private HudRodinaTrainSpeedIndicatorBinding(FrameLayout rootView, TextView trainCurrentSpeedValue, RodinaTrainSpeedGaugeView trainSpeedGauge) {
        this.rootView = rootView;
        this.trainCurrentSpeedValue = trainCurrentSpeedValue;
        this.trainSpeedGauge = trainSpeedGauge;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudRodinaTrainSpeedIndicatorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudRodinaTrainSpeedIndicatorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_rodina_train_speed_indicator, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudRodinaTrainSpeedIndicatorBinding bind(View rootView) {
        int i = R.id.train_current_speed_value;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.train_speed_gauge;
            RodinaTrainSpeedGaugeView rodinaTrainSpeedGaugeView = (RodinaTrainSpeedGaugeView) ViewBindings.findChildViewById(rootView, i);
            if (rodinaTrainSpeedGaugeView != null) {
                return new HudRodinaTrainSpeedIndicatorBinding((FrameLayout) rootView, textView, rodinaTrainSpeedGaugeView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
