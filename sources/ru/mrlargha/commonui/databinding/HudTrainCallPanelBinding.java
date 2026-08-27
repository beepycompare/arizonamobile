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
public final class HudTrainCallPanelBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final CustomCardView trainAcceptCallAction;
    public final FrameLayout trainCallPanel;
    public final CustomCardView trainHangUpAction;
    public final CustomCardView trainIncomingCall;
    public final TextView trainIncomingCallTitle;
    public final CustomCardView trainOutgoingCall;
    public final TextView trainOutgoingCallTime;
    public final TextView trainOutgoingCallTitle;
    public final CustomCardView trainRejectCallAction;

    private HudTrainCallPanelBinding(FrameLayout rootView, CustomCardView trainAcceptCallAction, FrameLayout trainCallPanel, CustomCardView trainHangUpAction, CustomCardView trainIncomingCall, TextView trainIncomingCallTitle, CustomCardView trainOutgoingCall, TextView trainOutgoingCallTime, TextView trainOutgoingCallTitle, CustomCardView trainRejectCallAction) {
        this.rootView = rootView;
        this.trainAcceptCallAction = trainAcceptCallAction;
        this.trainCallPanel = trainCallPanel;
        this.trainHangUpAction = trainHangUpAction;
        this.trainIncomingCall = trainIncomingCall;
        this.trainIncomingCallTitle = trainIncomingCallTitle;
        this.trainOutgoingCall = trainOutgoingCall;
        this.trainOutgoingCallTime = trainOutgoingCallTime;
        this.trainOutgoingCallTitle = trainOutgoingCallTitle;
        this.trainRejectCallAction = trainRejectCallAction;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTrainCallPanelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTrainCallPanelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_train_call_panel, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTrainCallPanelBinding bind(View rootView) {
        int i = R.id.train_accept_call_action;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            FrameLayout frameLayout = (FrameLayout) rootView;
            i = R.id.train_hang_up_action;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView2 != null) {
                i = R.id.train_incoming_call;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView3 != null) {
                    i = R.id.train_incoming_call_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.train_outgoing_call;
                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView4 != null) {
                            i = R.id.train_outgoing_call_time;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.train_outgoing_call_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.train_reject_call_action;
                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (customCardView5 != null) {
                                        return new HudTrainCallPanelBinding(frameLayout, customCardView, frameLayout, customCardView2, customCardView3, textView, customCardView4, textView2, textView3, customCardView5);
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
