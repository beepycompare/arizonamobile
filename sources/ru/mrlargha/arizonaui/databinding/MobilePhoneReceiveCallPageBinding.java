package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneReceiveCallPageBinding implements ViewBinding {
    public final AppCompatImageView mpReceiveCallAcceptButton;
    public final TextView mpReceiveCallAcceptButtonText;
    public final ConstraintLayout mpReceiveCallActionAccept;
    public final ConstraintLayout mpReceiveCallActionButtons;
    public final ConstraintLayout mpReceiveCallActionDecline;
    public final AppCompatImageView mpReceiveCallDeclineButton;
    public final TextView mpReceiveCallDeclineButtonText;
    public final ConstraintLayout mpReceiveCallInfo;
    public final ConstraintLayout mpReceiveCallPage;
    public final TextView mpReceiveCallTelephone;
    public final TextView mpReceiveCallTime;
    public final TextView mpReceiveCallTitle;
    public final TextView mpReceiveCallUser;
    private final ConstraintLayout rootView;

    private MobilePhoneReceiveCallPageBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView2, TextView textView2, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.mpReceiveCallAcceptButton = appCompatImageView;
        this.mpReceiveCallAcceptButtonText = textView;
        this.mpReceiveCallActionAccept = constraintLayout2;
        this.mpReceiveCallActionButtons = constraintLayout3;
        this.mpReceiveCallActionDecline = constraintLayout4;
        this.mpReceiveCallDeclineButton = appCompatImageView2;
        this.mpReceiveCallDeclineButtonText = textView2;
        this.mpReceiveCallInfo = constraintLayout5;
        this.mpReceiveCallPage = constraintLayout6;
        this.mpReceiveCallTelephone = textView3;
        this.mpReceiveCallTime = textView4;
        this.mpReceiveCallTitle = textView5;
        this.mpReceiveCallUser = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneReceiveCallPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneReceiveCallPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_receive_call_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneReceiveCallPageBinding bind(View view) {
        int i = R.id.mp_receive_call_accept_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mp_receive_call_accept_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.mp_receive_call_action_accept;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.mp_receive_call_action_buttons;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.mp_receive_call_action_decline;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.mp_receive_call_decline_button;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.mp_receive_call_decline_button_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.mp_receive_call_info;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                        i = R.id.mp_receive_call_telephone;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.mp_receive_call_time;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.mp_receive_call_title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.mp_receive_call_user;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        return new MobilePhoneReceiveCallPageBinding(constraintLayout5, appCompatImageView, textView, constraintLayout, constraintLayout2, constraintLayout3, appCompatImageView2, textView2, constraintLayout4, constraintLayout5, textView3, textView4, textView5, textView6);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
