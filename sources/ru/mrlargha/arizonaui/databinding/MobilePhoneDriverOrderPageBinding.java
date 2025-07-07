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
public final class MobilePhoneDriverOrderPageBinding implements ViewBinding {
    public final ConstraintLayout driverAcceptButton;
    public final TextView driverAcceptButtonText;
    public final ConstraintLayout driverCurrentOrder;
    public final TextView driverCurrentOrderClientName;
    public final TextView driverCurrentOrderRate;
    public final AppCompatImageView driverCurrentOrderStar;
    public final ConstraintLayout driverDeclineButton;
    public final TextView driverDeclineButtonText;
    public final TextView driverDistnace;
    public final AppCompatImageView driverImage;
    public final ConstraintLayout driverInfoContainer;
    public final TextView driverName;
    public final TextView driverRate;
    public final AppCompatImageView driverStar;
    public final TextView driverYourOrder;
    public final ConstraintLayout mpDriverHeader;
    public final AppCompatImageView mpDriverHeaderBack;
    public final TextView mpDriverHeaderTitle;
    public final ConstraintLayout mpDriverOrderPage;
    private final ConstraintLayout rootView;

    private MobilePhoneDriverOrderPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout4, TextView textView4, TextView textView5, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout5, TextView textView6, TextView textView7, AppCompatImageView appCompatImageView3, TextView textView8, ConstraintLayout constraintLayout6, AppCompatImageView appCompatImageView4, TextView textView9, ConstraintLayout constraintLayout7) {
        this.rootView = constraintLayout;
        this.driverAcceptButton = constraintLayout2;
        this.driverAcceptButtonText = textView;
        this.driverCurrentOrder = constraintLayout3;
        this.driverCurrentOrderClientName = textView2;
        this.driverCurrentOrderRate = textView3;
        this.driverCurrentOrderStar = appCompatImageView;
        this.driverDeclineButton = constraintLayout4;
        this.driverDeclineButtonText = textView4;
        this.driverDistnace = textView5;
        this.driverImage = appCompatImageView2;
        this.driverInfoContainer = constraintLayout5;
        this.driverName = textView6;
        this.driverRate = textView7;
        this.driverStar = appCompatImageView3;
        this.driverYourOrder = textView8;
        this.mpDriverHeader = constraintLayout6;
        this.mpDriverHeaderBack = appCompatImageView4;
        this.mpDriverHeaderTitle = textView9;
        this.mpDriverOrderPage = constraintLayout7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneDriverOrderPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneDriverOrderPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_driver_order_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneDriverOrderPageBinding bind(View view) {
        int i = R.id.driver_accept_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.driver_accept_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.driver_current_order;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.driver_current_order_client_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.driver_current_order_rate;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.driver_current_order_star;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView != null) {
                                i = R.id.driver_decline_button;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.driver_decline_button_text;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.driver_distnace;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.driver_image;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatImageView2 != null) {
                                                i = R.id.driver_info_container;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.driver_name;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.driver_rate;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.driver_star;
                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                            if (appCompatImageView3 != null) {
                                                                i = R.id.driver_your_order;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.mp_driver_header;
                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout5 != null) {
                                                                        i = R.id.mp_driver_header_back;
                                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (appCompatImageView4 != null) {
                                                                            i = R.id.mp_driver_header_title;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) view;
                                                                                return new MobilePhoneDriverOrderPageBinding(constraintLayout6, constraintLayout, textView, constraintLayout2, textView2, textView3, appCompatImageView, constraintLayout3, textView4, textView5, appCompatImageView2, constraintLayout4, textView6, textView7, appCompatImageView3, textView8, constraintLayout5, appCompatImageView4, textView9, constraintLayout6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
