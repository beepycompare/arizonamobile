package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudTrainDispatcherPanelBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final CustomCardView trainDispatcherCallAction;
    public final TextView trainDispatcherLocomotivesCount;
    public final FrameLayout trainDispatcherPanel;
    public final TextView trainDispatcherStationsCount;

    private HudTrainDispatcherPanelBinding(FrameLayout rootView, CustomCardView trainDispatcherCallAction, TextView trainDispatcherLocomotivesCount, FrameLayout trainDispatcherPanel, TextView trainDispatcherStationsCount) {
        this.rootView = rootView;
        this.trainDispatcherCallAction = trainDispatcherCallAction;
        this.trainDispatcherLocomotivesCount = trainDispatcherLocomotivesCount;
        this.trainDispatcherPanel = trainDispatcherPanel;
        this.trainDispatcherStationsCount = trainDispatcherStationsCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTrainDispatcherPanelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTrainDispatcherPanelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_train_dispatcher_panel, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTrainDispatcherPanelBinding bind(View rootView) {
        int i = R.id.train_dispatcher_call_action;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.train_dispatcher_locomotives_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.train_dispatcher_stations_count;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new HudTrainDispatcherPanelBinding(frameLayout, customCardView, textView, frameLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
