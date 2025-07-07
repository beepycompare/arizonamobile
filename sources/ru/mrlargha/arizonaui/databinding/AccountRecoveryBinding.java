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
public final class AccountRecoveryBinding implements ViewBinding {
    public final ConstraintLayout accountRecovery;
    public final AppCompatImageView accountRecoveryArrow;
    public final ConstraintLayout accountRecoveryButton;
    public final TextView accountRecoveryButtonText;
    public final TextView accountRecoveryDescription;
    public final TextView accountRecoveryExistButton;
    public final ConstraintLayout accountRecoveryExistContainer;
    public final AppCompatImageView accountRecoveryIcon;
    public final ConstraintLayout accountRecoveryInfoContainer;
    public final TextView accountRecoveryIsExist;
    public final TextView accountRecoveryPlaceholder;
    public final ConstraintLayout accountRecoverySelectorContainer;
    public final TextView accountRecoveryTitle;
    public final ConstraintLayout authBackground;
    private final ConstraintLayout rootView;

    private AccountRecoveryBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout5, TextView textView4, TextView textView5, ConstraintLayout constraintLayout6, TextView textView6, ConstraintLayout constraintLayout7) {
        this.rootView = constraintLayout;
        this.accountRecovery = constraintLayout2;
        this.accountRecoveryArrow = appCompatImageView;
        this.accountRecoveryButton = constraintLayout3;
        this.accountRecoveryButtonText = textView;
        this.accountRecoveryDescription = textView2;
        this.accountRecoveryExistButton = textView3;
        this.accountRecoveryExistContainer = constraintLayout4;
        this.accountRecoveryIcon = appCompatImageView2;
        this.accountRecoveryInfoContainer = constraintLayout5;
        this.accountRecoveryIsExist = textView4;
        this.accountRecoveryPlaceholder = textView5;
        this.accountRecoverySelectorContainer = constraintLayout6;
        this.accountRecoveryTitle = textView6;
        this.authBackground = constraintLayout7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AccountRecoveryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AccountRecoveryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.account_recovery, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AccountRecoveryBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.account_recovery_arrow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.account_recovery_button;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.account_recovery_button_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.account_recovery_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.account_recovery_exist_button;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.account_recovery_exist_container;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.account_recovery_icon;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView2 != null) {
                                    i = R.id.account_recovery_info_container;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.account_recovery_is_exist;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.account_recovery_placeholder;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.account_recovery_selector_container;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.account_recovery_title;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.auth_background;
                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout6 != null) {
                                                            return new AccountRecoveryBinding(constraintLayout, constraintLayout, appCompatImageView, constraintLayout2, textView, textView2, textView3, constraintLayout3, appCompatImageView2, constraintLayout4, textView4, textView5, constraintLayout5, textView6, constraintLayout6);
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
