package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudTrainJobBinding implements ViewBinding {
    public final FrameLayout hudTrainJob;
    public final TextView income;
    public final LinearLayout legacyTrainData;
    private final FrameLayout rootView;
    public final TextView speedLimit;
    public final CustomCardView speedLimitCard;
    public final HudTrainCallPanelBinding trainCallPanel;
    public final TextView trainCurrentTime;
    public final HudTrainDispatcherPanelBinding trainDispatcherPanel;
    public final CustomCardView trainDoorCloseAction;
    public final ImageView trainDoorLockedIcon;
    public final CustomCardView trainDoorOpenAction;
    public final ImageView trainDoorUnlockedIcon;
    public final FrameLayout trainDriverContainer;
    public final HudTrainFullControlPanelBinding trainFullControlPanel;
    public final TextView trainMaxTime;
    public final TextView trainPassengerCount;
    public final LinearLayout trainPassengers;
    public final HudTrainRouteBinding trainRoute;
    public final FrameLayout trainSettings;
    public final HudTrainStopPanelBinding trainStopPanel;
    public final TextView warningsCount;

    private HudTrainJobBinding(FrameLayout rootView, FrameLayout hudTrainJob, TextView income, LinearLayout legacyTrainData, TextView speedLimit, CustomCardView speedLimitCard, HudTrainCallPanelBinding trainCallPanel, TextView trainCurrentTime, HudTrainDispatcherPanelBinding trainDispatcherPanel, CustomCardView trainDoorCloseAction, ImageView trainDoorLockedIcon, CustomCardView trainDoorOpenAction, ImageView trainDoorUnlockedIcon, FrameLayout trainDriverContainer, HudTrainFullControlPanelBinding trainFullControlPanel, TextView trainMaxTime, TextView trainPassengerCount, LinearLayout trainPassengers, HudTrainRouteBinding trainRoute, FrameLayout trainSettings, HudTrainStopPanelBinding trainStopPanel, TextView warningsCount) {
        this.rootView = rootView;
        this.hudTrainJob = hudTrainJob;
        this.income = income;
        this.legacyTrainData = legacyTrainData;
        this.speedLimit = speedLimit;
        this.speedLimitCard = speedLimitCard;
        this.trainCallPanel = trainCallPanel;
        this.trainCurrentTime = trainCurrentTime;
        this.trainDispatcherPanel = trainDispatcherPanel;
        this.trainDoorCloseAction = trainDoorCloseAction;
        this.trainDoorLockedIcon = trainDoorLockedIcon;
        this.trainDoorOpenAction = trainDoorOpenAction;
        this.trainDoorUnlockedIcon = trainDoorUnlockedIcon;
        this.trainDriverContainer = trainDriverContainer;
        this.trainFullControlPanel = trainFullControlPanel;
        this.trainMaxTime = trainMaxTime;
        this.trainPassengerCount = trainPassengerCount;
        this.trainPassengers = trainPassengers;
        this.trainRoute = trainRoute;
        this.trainSettings = trainSettings;
        this.trainStopPanel = trainStopPanel;
        this.warningsCount = warningsCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTrainJobBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTrainJobBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_train_job, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTrainJobBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.income;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.legacy_train_data;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.speed_limit;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.speed_limit_card;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.train_call_panel))) != null) {
                        HudTrainCallPanelBinding bind = HudTrainCallPanelBinding.bind(findChildViewById);
                        i = R.id.train_current_time;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.train_dispatcher_panel))) != null) {
                            HudTrainDispatcherPanelBinding bind2 = HudTrainDispatcherPanelBinding.bind(findChildViewById2);
                            i = R.id.train_door_close_action;
                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView2 != null) {
                                i = R.id.train_door_locked_icon;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.train_door_open_action;
                                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (customCardView3 != null) {
                                        i = R.id.train_door_unlocked_icon;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView2 != null) {
                                            i = R.id.train_driver_container;
                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (frameLayout2 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.train_full_control_panel))) != null) {
                                                HudTrainFullControlPanelBinding bind3 = HudTrainFullControlPanelBinding.bind(findChildViewById3);
                                                i = R.id.train_max_time;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.train_passenger_count;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.train_passengers;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout2 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.train_route))) != null) {
                                                            HudTrainRouteBinding bind4 = HudTrainRouteBinding.bind(findChildViewById4);
                                                            i = R.id.trainSettings;
                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (frameLayout3 != null && (findChildViewById5 = ViewBindings.findChildViewById(rootView, (i = R.id.train_stop_panel))) != null) {
                                                                HudTrainStopPanelBinding bind5 = HudTrainStopPanelBinding.bind(findChildViewById5);
                                                                i = R.id.warnings_count;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView6 != null) {
                                                                    return new HudTrainJobBinding(frameLayout, frameLayout, textView, linearLayout, textView2, customCardView, bind, textView3, bind2, customCardView2, imageView, customCardView3, imageView2, frameLayout2, bind3, textView4, textView5, linearLayout2, bind4, frameLayout3, bind5, textView6);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
