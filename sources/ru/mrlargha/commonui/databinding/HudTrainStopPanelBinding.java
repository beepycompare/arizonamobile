package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudTrainStopPanelBinding implements ViewBinding {
    private final CustomCardView rootView;
    public final TextView trainStopName;
    public final CustomCardView trainStopPanel;
    public final TextView trainStopTime;

    private HudTrainStopPanelBinding(CustomCardView rootView, TextView trainStopName, CustomCardView trainStopPanel, TextView trainStopTime) {
        this.rootView = rootView;
        this.trainStopName = trainStopName;
        this.trainStopPanel = trainStopPanel;
        this.trainStopTime = trainStopTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static HudTrainStopPanelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTrainStopPanelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_train_stop_panel, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTrainStopPanelBinding bind(View rootView) {
        int i = R.id.train_stop_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            CustomCardView customCardView = (CustomCardView) rootView;
            int i2 = R.id.train_stop_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i2);
            if (textView2 != null) {
                return new HudTrainStopPanelBinding(customCardView, textView, customCardView, textView2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
