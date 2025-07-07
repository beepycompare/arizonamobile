package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneBinding implements ViewBinding {
    public final ConstraintLayout mpActionBackButton;
    public final AppCompatImageView mpActionBackButtonImage;
    public final ConstraintLayout mpActionButtons;
    public final ConstraintLayout mpActionCloseButton;
    public final AppCompatImageView mpActionCloseButtonImage;
    public final ConstraintLayout phone;
    public final ConstraintLayout phoneBackground;
    public final ConstraintLayout phoneCarplayContainer;
    public final ImageView phoneCarplayIcon;
    public final TextView phoneCarplayType;
    public final ConstraintLayout phoneCase;
    public final ConstraintLayout phoneCaseContainer;
    public final ConstraintLayout phoneContainer;
    public final ConstraintLayout phoneNetworkContainer;
    public final AppCompatImageView phoneNetworkImg;
    public final TextView phoneNetworkName;
    public final ConstraintLayout phoneTopBarContainer;
    public final TextView phoneTopBarTime;
    private final ConstraintLayout rootView;

    private MobilePhoneBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ImageView imageView, TextView textView, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, AppCompatImageView appCompatImageView3, TextView textView2, ConstraintLayout constraintLayout12, TextView textView3) {
        this.rootView = constraintLayout;
        this.mpActionBackButton = constraintLayout2;
        this.mpActionBackButtonImage = appCompatImageView;
        this.mpActionButtons = constraintLayout3;
        this.mpActionCloseButton = constraintLayout4;
        this.mpActionCloseButtonImage = appCompatImageView2;
        this.phone = constraintLayout5;
        this.phoneBackground = constraintLayout6;
        this.phoneCarplayContainer = constraintLayout7;
        this.phoneCarplayIcon = imageView;
        this.phoneCarplayType = textView;
        this.phoneCase = constraintLayout8;
        this.phoneCaseContainer = constraintLayout9;
        this.phoneContainer = constraintLayout10;
        this.phoneNetworkContainer = constraintLayout11;
        this.phoneNetworkImg = appCompatImageView3;
        this.phoneNetworkName = textView2;
        this.phoneTopBarContainer = constraintLayout12;
        this.phoneTopBarTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneBinding bind(View view) {
        int i = R.id.mp_action_back_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mp_action_back_button_image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.mp_action_buttons;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.mp_action_close_button;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout3 != null) {
                        i = R.id.mp_action_close_button_image;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView2 != null) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                            i = R.id.phone_background;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout5 != null) {
                                i = R.id.phone_carplay_container;
                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout6 != null) {
                                    i = R.id.phone_carplay_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.phone_carplay_type;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.phone_case;
                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout7 != null) {
                                                i = R.id.phone_case_container;
                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout8 != null) {
                                                    i = R.id.phone_container;
                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout9 != null) {
                                                        i = R.id.phone_network_container;
                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout10 != null) {
                                                            i = R.id.phone_network_img;
                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                            if (appCompatImageView3 != null) {
                                                                i = R.id.phone_network_name;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.phone_top_bar_container;
                                                                    ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout11 != null) {
                                                                        i = R.id.phone_top_bar_time;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            return new MobilePhoneBinding(constraintLayout4, constraintLayout, appCompatImageView, constraintLayout2, constraintLayout3, appCompatImageView2, constraintLayout4, constraintLayout5, constraintLayout6, imageView, textView, constraintLayout7, constraintLayout8, constraintLayout9, constraintLayout10, appCompatImageView3, textView2, constraintLayout11, textView3);
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
