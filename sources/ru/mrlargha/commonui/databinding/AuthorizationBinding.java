package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AuthorizationBinding implements ViewBinding {
    public final ConstraintLayout auth;
    public final ConstraintLayout authAccountExistContainer;
    public final TextView authAccountIsExist;
    public final TextView authAccountRegistrationButton;
    public final ConstraintLayout authBackground;
    public final TextView authForgotPassword;
    public final ConstraintLayout authHeaderContainer;
    public final ConstraintLayout authHelpContainer;
    public final ConstraintLayout authInputsContainer;
    public final ConstraintLayout authLoginButton;
    public final TextView authLoginText;
    public final TextView authOnlineCount;
    public final ConstraintLayout authPasswordContainer;
    public final EditText authPasswordEdit;
    public final AppCompatImageView authPasswordError;
    public final AppCompatImageView authPasswordIcon;
    public final ConstraintLayout authRememberCheckbox;
    public final AppCompatImageView authRememberCheckboxMark;
    public final TextView authRememberText;
    public final ConstraintLayout authServerInfoContainer;
    public final AppCompatImageView authServerLogotype;
    public final TextView authServerName;
    public final AppCompatImageView authServerTooltip;
    public final ConstraintLayout authSurnameContainer;
    public final EditText authSurnameEdit;
    public final AppCompatImageView authSurnameError;
    public final TextView authTitle;
    public final ConstraintLayout authUsernameContainer;
    public final EditText authUsernameEdit;
    public final AppCompatImageView authUsernameError;
    public final Guideline centerLine;
    public final Guideline headerGuidelineH;
    public final ProgressBar loaderBar;
    public final ConstraintLayout loaderContainer;
    public final TextView loaderTitle;
    private final ConstraintLayout rootView;

    private AuthorizationBinding(ConstraintLayout rootView, ConstraintLayout auth, ConstraintLayout authAccountExistContainer, TextView authAccountIsExist, TextView authAccountRegistrationButton, ConstraintLayout authBackground, TextView authForgotPassword, ConstraintLayout authHeaderContainer, ConstraintLayout authHelpContainer, ConstraintLayout authInputsContainer, ConstraintLayout authLoginButton, TextView authLoginText, TextView authOnlineCount, ConstraintLayout authPasswordContainer, EditText authPasswordEdit, AppCompatImageView authPasswordError, AppCompatImageView authPasswordIcon, ConstraintLayout authRememberCheckbox, AppCompatImageView authRememberCheckboxMark, TextView authRememberText, ConstraintLayout authServerInfoContainer, AppCompatImageView authServerLogotype, TextView authServerName, AppCompatImageView authServerTooltip, ConstraintLayout authSurnameContainer, EditText authSurnameEdit, AppCompatImageView authSurnameError, TextView authTitle, ConstraintLayout authUsernameContainer, EditText authUsernameEdit, AppCompatImageView authUsernameError, Guideline centerLine, Guideline headerGuidelineH, ProgressBar loaderBar, ConstraintLayout loaderContainer, TextView loaderTitle) {
        this.rootView = rootView;
        this.auth = auth;
        this.authAccountExistContainer = authAccountExistContainer;
        this.authAccountIsExist = authAccountIsExist;
        this.authAccountRegistrationButton = authAccountRegistrationButton;
        this.authBackground = authBackground;
        this.authForgotPassword = authForgotPassword;
        this.authHeaderContainer = authHeaderContainer;
        this.authHelpContainer = authHelpContainer;
        this.authInputsContainer = authInputsContainer;
        this.authLoginButton = authLoginButton;
        this.authLoginText = authLoginText;
        this.authOnlineCount = authOnlineCount;
        this.authPasswordContainer = authPasswordContainer;
        this.authPasswordEdit = authPasswordEdit;
        this.authPasswordError = authPasswordError;
        this.authPasswordIcon = authPasswordIcon;
        this.authRememberCheckbox = authRememberCheckbox;
        this.authRememberCheckboxMark = authRememberCheckboxMark;
        this.authRememberText = authRememberText;
        this.authServerInfoContainer = authServerInfoContainer;
        this.authServerLogotype = authServerLogotype;
        this.authServerName = authServerName;
        this.authServerTooltip = authServerTooltip;
        this.authSurnameContainer = authSurnameContainer;
        this.authSurnameEdit = authSurnameEdit;
        this.authSurnameError = authSurnameError;
        this.authTitle = authTitle;
        this.authUsernameContainer = authUsernameContainer;
        this.authUsernameEdit = authUsernameEdit;
        this.authUsernameError = authUsernameError;
        this.centerLine = centerLine;
        this.headerGuidelineH = headerGuidelineH;
        this.loaderBar = loaderBar;
        this.loaderContainer = loaderContainer;
        this.loaderTitle = loaderTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthorizationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AuthorizationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.authorization, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthorizationBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.auth_account_exist_container;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout2 != null) {
            i = R.id.auth_account_is_exist;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.auth_account_registration_button;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.auth_background;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.auth_forgot_password;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.auth_header_container;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout4 != null) {
                                i = R.id.auth_help_container;
                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout5 != null) {
                                    i = R.id.auth_inputs_container;
                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout6 != null) {
                                        i = R.id.auth_login_button;
                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout7 != null) {
                                            i = R.id.auth_login_text;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                i = R.id.auth_online_count;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.auth_password_container;
                                                    ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout8 != null) {
                                                        i = R.id.auth_password_edit;
                                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                        if (editText != null) {
                                                            i = R.id.auth_password_error;
                                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (appCompatImageView != null) {
                                                                i = R.id.auth_password_icon;
                                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (appCompatImageView2 != null) {
                                                                    i = R.id.auth_remember_checkbox;
                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (constraintLayout9 != null) {
                                                                        i = R.id.auth_remember_checkbox_mark;
                                                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (appCompatImageView3 != null) {
                                                                            i = R.id.auth_remember_text;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.auth_server_info_container;
                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout10 != null) {
                                                                                    i = R.id.auth_server_logotype;
                                                                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (appCompatImageView4 != null) {
                                                                                        i = R.id.auth_server_name;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.auth_server_tooltip;
                                                                                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (appCompatImageView5 != null) {
                                                                                                i = R.id.auth_surname_container;
                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (constraintLayout11 != null) {
                                                                                                    i = R.id.auth_surname_edit;
                                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (editText2 != null) {
                                                                                                        i = R.id.auth_surname_error;
                                                                                                        AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (appCompatImageView6 != null) {
                                                                                                            i = R.id.auth_title;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.auth_username_container;
                                                                                                                ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (constraintLayout12 != null) {
                                                                                                                    i = R.id.auth_username_edit;
                                                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (editText3 != null) {
                                                                                                                        i = R.id.auth_username_error;
                                                                                                                        AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (appCompatImageView7 != null) {
                                                                                                                            i = R.id.center_line;
                                                                                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (guideline != null) {
                                                                                                                                i = R.id.header_guideline_h;
                                                                                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (guideline2 != null) {
                                                                                                                                    i = R.id.loader_bar;
                                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (progressBar != null) {
                                                                                                                                        i = R.id.loader_container;
                                                                                                                                        ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (constraintLayout13 != null) {
                                                                                                                                            i = R.id.loader_title;
                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (textView9 != null) {
                                                                                                                                                return new AuthorizationBinding(constraintLayout, constraintLayout, constraintLayout2, textView, textView2, constraintLayout3, textView3, constraintLayout4, constraintLayout5, constraintLayout6, constraintLayout7, textView4, textView5, constraintLayout8, editText, appCompatImageView, appCompatImageView2, constraintLayout9, appCompatImageView3, textView6, constraintLayout10, appCompatImageView4, textView7, appCompatImageView5, constraintLayout11, editText2, appCompatImageView6, textView8, constraintLayout12, editText3, appCompatImageView7, guideline, guideline2, progressBar, constraintLayout13, textView9);
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
