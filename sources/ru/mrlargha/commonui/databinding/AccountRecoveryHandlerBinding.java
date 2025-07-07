package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AccountRecoveryHandlerBinding implements ViewBinding {
    public final TextView accountRecoveryDescription;
    public final ConstraintLayout accountRecoveryHandler;
    public final AppCompatImageView accountRecoveryHandlerArrow;
    public final ConstraintLayout accountRecoveryHandlerContainer;
    public final ConstraintLayout accountRecoveryHandlerErrorContainer;
    public final TextView accountRecoveryHandlerErrorDescription;
    public final TextView accountRecoveryHandlerExistButton;
    public final ConstraintLayout accountRecoveryHandlerExistContainer;
    public final ConstraintLayout accountRecoveryHandlerInfoContainer;
    public final ConstraintLayout accountRecoveryHandlerInput;
    public final TextView accountRecoveryHandlerIsExist;
    public final AppCompatImageView accountRecoveryHandlerIsExistIcon;
    public final ConstraintLayout accountRecoveryHandlerMethod;
    public final AppCompatImageView accountRecoveryHandlerMethodIcon;
    public final TextView accountRecoveryHandlerPlaceholder;
    public final ConstraintLayout accountRecoveryHandlerUpdateButton;
    public final TextView accountRecoveryHandlerUpdateButtonTxt;
    public final AppCompatImageView accountRecoveryMethodMailIcon;
    public final TextView accountRecoveryMethodTitle;
    public final EditText accountRecoveryTypePlaceholder;
    public final ConstraintLayout authBackground;
    private final ConstraintLayout rootView;

    private AccountRecoveryHandlerBinding(ConstraintLayout rootView, TextView accountRecoveryDescription, ConstraintLayout accountRecoveryHandler, AppCompatImageView accountRecoveryHandlerArrow, ConstraintLayout accountRecoveryHandlerContainer, ConstraintLayout accountRecoveryHandlerErrorContainer, TextView accountRecoveryHandlerErrorDescription, TextView accountRecoveryHandlerExistButton, ConstraintLayout accountRecoveryHandlerExistContainer, ConstraintLayout accountRecoveryHandlerInfoContainer, ConstraintLayout accountRecoveryHandlerInput, TextView accountRecoveryHandlerIsExist, AppCompatImageView accountRecoveryHandlerIsExistIcon, ConstraintLayout accountRecoveryHandlerMethod, AppCompatImageView accountRecoveryHandlerMethodIcon, TextView accountRecoveryHandlerPlaceholder, ConstraintLayout accountRecoveryHandlerUpdateButton, TextView accountRecoveryHandlerUpdateButtonTxt, AppCompatImageView accountRecoveryMethodMailIcon, TextView accountRecoveryMethodTitle, EditText accountRecoveryTypePlaceholder, ConstraintLayout authBackground) {
        this.rootView = rootView;
        this.accountRecoveryDescription = accountRecoveryDescription;
        this.accountRecoveryHandler = accountRecoveryHandler;
        this.accountRecoveryHandlerArrow = accountRecoveryHandlerArrow;
        this.accountRecoveryHandlerContainer = accountRecoveryHandlerContainer;
        this.accountRecoveryHandlerErrorContainer = accountRecoveryHandlerErrorContainer;
        this.accountRecoveryHandlerErrorDescription = accountRecoveryHandlerErrorDescription;
        this.accountRecoveryHandlerExistButton = accountRecoveryHandlerExistButton;
        this.accountRecoveryHandlerExistContainer = accountRecoveryHandlerExistContainer;
        this.accountRecoveryHandlerInfoContainer = accountRecoveryHandlerInfoContainer;
        this.accountRecoveryHandlerInput = accountRecoveryHandlerInput;
        this.accountRecoveryHandlerIsExist = accountRecoveryHandlerIsExist;
        this.accountRecoveryHandlerIsExistIcon = accountRecoveryHandlerIsExistIcon;
        this.accountRecoveryHandlerMethod = accountRecoveryHandlerMethod;
        this.accountRecoveryHandlerMethodIcon = accountRecoveryHandlerMethodIcon;
        this.accountRecoveryHandlerPlaceholder = accountRecoveryHandlerPlaceholder;
        this.accountRecoveryHandlerUpdateButton = accountRecoveryHandlerUpdateButton;
        this.accountRecoveryHandlerUpdateButtonTxt = accountRecoveryHandlerUpdateButtonTxt;
        this.accountRecoveryMethodMailIcon = accountRecoveryMethodMailIcon;
        this.accountRecoveryMethodTitle = accountRecoveryMethodTitle;
        this.accountRecoveryTypePlaceholder = accountRecoveryTypePlaceholder;
        this.authBackground = authBackground;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AccountRecoveryHandlerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AccountRecoveryHandlerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.account_recovery_handler, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AccountRecoveryHandlerBinding bind(View rootView) {
        int i = R.id.account_recovery_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.account_recovery_handler_arrow;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.account_recovery_handler_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.account_recovery_handler_error_container;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.account_recovery_handler_error_description;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.account_recovery_handler_exist_button;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.account_recovery_handler_exist_container;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout4 != null) {
                                    i = R.id.account_recovery_handler_info_container;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.account_recovery_handler_input;
                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout6 != null) {
                                            i = R.id.account_recovery_handler_is_exist;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                i = R.id.account_recovery_handler_is_exist_icon;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatImageView2 != null) {
                                                    i = R.id.account_recovery_handler_method;
                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout7 != null) {
                                                        i = R.id.account_recovery_handler_method_icon;
                                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatImageView3 != null) {
                                                            i = R.id.account_recovery_handler_placeholder;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView5 != null) {
                                                                i = R.id.account_recovery_handler_update_button;
                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout8 != null) {
                                                                    i = R.id.account_recovery_handler_update_button_txt;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.account_recovery_method_mail_icon;
                                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (appCompatImageView4 != null) {
                                                                            i = R.id.account_recovery_method_title;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.account_recovery_type_placeholder;
                                                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                if (editText != null) {
                                                                                    i = R.id.auth_background;
                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (constraintLayout9 != null) {
                                                                                        return new AccountRecoveryHandlerBinding(constraintLayout, textView, constraintLayout, appCompatImageView, constraintLayout2, constraintLayout3, textView2, textView3, constraintLayout4, constraintLayout5, constraintLayout6, textView4, appCompatImageView2, constraintLayout7, appCompatImageView3, textView5, constraintLayout8, textView6, appCompatImageView4, textView7, editText, constraintLayout9);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
