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
public final class AccountRecoveryMethodBinding implements ViewBinding {
    public final TextView accountRecoveryMailPlaceholder;
    public final ConstraintLayout accountRecoveryMethod;
    public final TextView accountRecoveryMethodBtnTxt;
    public final ConstraintLayout accountRecoveryMethodContainer;
    public final ConstraintLayout accountRecoveryMethodMail;
    public final AppCompatImageView accountRecoveryMethodMailIcon;
    public final ConstraintLayout accountRecoveryMethodNext;
    public final ConstraintLayout accountRecoveryMethodTelegram;
    public final AppCompatImageView accountRecoveryMethodTelegramIcon;
    public final TextView accountRecoveryMethodTitle;
    public final ConstraintLayout accountRecoveryMethodVk;
    public final AppCompatImageView accountRecoveryMethodVkIcon;
    public final TextView accountRecoveryTelegramPlaceholder;
    public final TextView accountRecoveryVkPlaceholder;
    public final ConstraintLayout authBackground;
    private final ConstraintLayout rootView;

    private AccountRecoveryMethodBinding(ConstraintLayout rootView, TextView accountRecoveryMailPlaceholder, ConstraintLayout accountRecoveryMethod, TextView accountRecoveryMethodBtnTxt, ConstraintLayout accountRecoveryMethodContainer, ConstraintLayout accountRecoveryMethodMail, AppCompatImageView accountRecoveryMethodMailIcon, ConstraintLayout accountRecoveryMethodNext, ConstraintLayout accountRecoveryMethodTelegram, AppCompatImageView accountRecoveryMethodTelegramIcon, TextView accountRecoveryMethodTitle, ConstraintLayout accountRecoveryMethodVk, AppCompatImageView accountRecoveryMethodVkIcon, TextView accountRecoveryTelegramPlaceholder, TextView accountRecoveryVkPlaceholder, ConstraintLayout authBackground) {
        this.rootView = rootView;
        this.accountRecoveryMailPlaceholder = accountRecoveryMailPlaceholder;
        this.accountRecoveryMethod = accountRecoveryMethod;
        this.accountRecoveryMethodBtnTxt = accountRecoveryMethodBtnTxt;
        this.accountRecoveryMethodContainer = accountRecoveryMethodContainer;
        this.accountRecoveryMethodMail = accountRecoveryMethodMail;
        this.accountRecoveryMethodMailIcon = accountRecoveryMethodMailIcon;
        this.accountRecoveryMethodNext = accountRecoveryMethodNext;
        this.accountRecoveryMethodTelegram = accountRecoveryMethodTelegram;
        this.accountRecoveryMethodTelegramIcon = accountRecoveryMethodTelegramIcon;
        this.accountRecoveryMethodTitle = accountRecoveryMethodTitle;
        this.accountRecoveryMethodVk = accountRecoveryMethodVk;
        this.accountRecoveryMethodVkIcon = accountRecoveryMethodVkIcon;
        this.accountRecoveryTelegramPlaceholder = accountRecoveryTelegramPlaceholder;
        this.accountRecoveryVkPlaceholder = accountRecoveryVkPlaceholder;
        this.authBackground = authBackground;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AccountRecoveryMethodBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AccountRecoveryMethodBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.account_recovery_method, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AccountRecoveryMethodBinding bind(View rootView) {
        int i = R.id.account_recovery_mail_placeholder;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.account_recovery_method_btn_txt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.account_recovery_method_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.account_recovery_method_mail;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.account_recovery_method_mail_icon;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView != null) {
                            i = R.id.account_recovery_method_next;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout4 != null) {
                                i = R.id.account_recovery_method_telegram;
                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout5 != null) {
                                    i = R.id.account_recovery_method_telegram_icon;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatImageView2 != null) {
                                        i = R.id.account_recovery_method_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.account_recovery_method_vk;
                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout6 != null) {
                                                i = R.id.account_recovery_method_vk_icon;
                                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatImageView3 != null) {
                                                    i = R.id.account_recovery_telegram_placeholder;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView4 != null) {
                                                        i = R.id.account_recovery_vk_placeholder;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView5 != null) {
                                                            i = R.id.auth_background;
                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout7 != null) {
                                                                return new AccountRecoveryMethodBinding(constraintLayout, textView, constraintLayout, textView2, constraintLayout2, constraintLayout3, appCompatImageView, constraintLayout4, constraintLayout5, appCompatImageView2, textView3, constraintLayout6, appCompatImageView3, textView4, textView5, constraintLayout7);
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
