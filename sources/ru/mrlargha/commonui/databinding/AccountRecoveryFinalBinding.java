package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AccountRecoveryFinalBinding implements ViewBinding {
    public final TextView accountRecoveryDescription;
    public final ConstraintLayout accountRecoveryFinal;
    public final ConstraintLayout accountRecoveryFinalExistContainer;
    public final AppCompatImageView accountRecoveryFinalIcon;
    public final ConstraintLayout accountRecoveryFinalInfoContainer;
    public final TextView accountRecoveryFinalIsExist;
    public final ConstraintLayout accountRecoveryFinalLoginButton;
    public final TextView accountRecoveryFinalLoginButtonTxt;
    public final ConstraintLayout accountRecoveryFinalMailContainer;
    public final TextView accountRecoveryFinalPlaceholder;
    public final TextView accountRecoveryFinalReplyButton;
    public final TextView accountRecoveryFinalTitle;
    public final ConstraintLayout authBackground;
    private final ConstraintLayout rootView;

    private AccountRecoveryFinalBinding(ConstraintLayout rootView, TextView accountRecoveryDescription, ConstraintLayout accountRecoveryFinal, ConstraintLayout accountRecoveryFinalExistContainer, AppCompatImageView accountRecoveryFinalIcon, ConstraintLayout accountRecoveryFinalInfoContainer, TextView accountRecoveryFinalIsExist, ConstraintLayout accountRecoveryFinalLoginButton, TextView accountRecoveryFinalLoginButtonTxt, ConstraintLayout accountRecoveryFinalMailContainer, TextView accountRecoveryFinalPlaceholder, TextView accountRecoveryFinalReplyButton, TextView accountRecoveryFinalTitle, ConstraintLayout authBackground) {
        this.rootView = rootView;
        this.accountRecoveryDescription = accountRecoveryDescription;
        this.accountRecoveryFinal = accountRecoveryFinal;
        this.accountRecoveryFinalExistContainer = accountRecoveryFinalExistContainer;
        this.accountRecoveryFinalIcon = accountRecoveryFinalIcon;
        this.accountRecoveryFinalInfoContainer = accountRecoveryFinalInfoContainer;
        this.accountRecoveryFinalIsExist = accountRecoveryFinalIsExist;
        this.accountRecoveryFinalLoginButton = accountRecoveryFinalLoginButton;
        this.accountRecoveryFinalLoginButtonTxt = accountRecoveryFinalLoginButtonTxt;
        this.accountRecoveryFinalMailContainer = accountRecoveryFinalMailContainer;
        this.accountRecoveryFinalPlaceholder = accountRecoveryFinalPlaceholder;
        this.accountRecoveryFinalReplyButton = accountRecoveryFinalReplyButton;
        this.accountRecoveryFinalTitle = accountRecoveryFinalTitle;
        this.authBackground = authBackground;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AccountRecoveryFinalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AccountRecoveryFinalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.account_recovery_final, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AccountRecoveryFinalBinding bind(View rootView) {
        int i = R.id.account_recovery_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.account_recovery_final_exist_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.account_recovery_final_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    i = R.id.account_recovery_final_info_container;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.account_recovery_final_is_exist;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.account_recovery_final_login_button;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout4 != null) {
                                i = R.id.account_recovery_final_login_button_txt;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.account_recovery_final_mail_container;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.account_recovery_final_placeholder;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.account_recovery_final_reply_button;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.account_recovery_final_title;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView6 != null) {
                                                    i = R.id.auth_background;
                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout6 != null) {
                                                        return new AccountRecoveryFinalBinding(constraintLayout, textView, constraintLayout, constraintLayout2, appCompatImageView, constraintLayout3, textView2, constraintLayout4, textView3, constraintLayout5, textView4, textView5, textView6, constraintLayout6);
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
