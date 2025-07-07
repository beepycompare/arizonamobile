package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RegistrationAccountBinding implements ViewBinding {
    public final Guideline centerLine;
    public final Guideline regTopLine;
    public final ConstraintLayout registrationAccount;
    public final ConstraintLayout registrationAccountBackground;
    public final ConstraintLayout registrationAccountContainer;
    public final ConstraintLayout registrationAccountExistContainer;
    public final ConstraintLayout registrationAccountInvite;
    public final AppCompatImageView registrationAccountInviteCheck;
    public final AppCompatImageView registrationAccountInviteIcon;
    public final EditText registrationAccountInvitePlaceholder;
    public final TextView registrationAccountIsExist;
    public final TextView registrationAccountIsExistButton;
    public final ConstraintLayout registrationAccountNextButton;
    public final TextView registrationAccountNextButtonText;
    public final ConstraintLayout registrationAccountPassword;
    public final AppCompatImageView registrationAccountPasswordCheck;
    public final AppCompatImageView registrationAccountPasswordIcon;
    public final EditText registrationAccountPasswordPlaceholder;
    public final ConstraintLayout registrationAccountSurname;
    public final AppCompatImageView registrationAccountSurnameCheck;
    public final EditText registrationAccountSurnamePlaceholder;
    public final TextView registrationAccountTitle;
    public final ConstraintLayout registrationAccountUsername;
    public final AppCompatImageView registrationAccountUsernameCheck;
    public final EditText registrationAccountUsernamePlaceholder;
    private final ConstraintLayout rootView;

    private RegistrationAccountBinding(ConstraintLayout rootView, Guideline centerLine, Guideline regTopLine, ConstraintLayout registrationAccount, ConstraintLayout registrationAccountBackground, ConstraintLayout registrationAccountContainer, ConstraintLayout registrationAccountExistContainer, ConstraintLayout registrationAccountInvite, AppCompatImageView registrationAccountInviteCheck, AppCompatImageView registrationAccountInviteIcon, EditText registrationAccountInvitePlaceholder, TextView registrationAccountIsExist, TextView registrationAccountIsExistButton, ConstraintLayout registrationAccountNextButton, TextView registrationAccountNextButtonText, ConstraintLayout registrationAccountPassword, AppCompatImageView registrationAccountPasswordCheck, AppCompatImageView registrationAccountPasswordIcon, EditText registrationAccountPasswordPlaceholder, ConstraintLayout registrationAccountSurname, AppCompatImageView registrationAccountSurnameCheck, EditText registrationAccountSurnamePlaceholder, TextView registrationAccountTitle, ConstraintLayout registrationAccountUsername, AppCompatImageView registrationAccountUsernameCheck, EditText registrationAccountUsernamePlaceholder) {
        this.rootView = rootView;
        this.centerLine = centerLine;
        this.regTopLine = regTopLine;
        this.registrationAccount = registrationAccount;
        this.registrationAccountBackground = registrationAccountBackground;
        this.registrationAccountContainer = registrationAccountContainer;
        this.registrationAccountExistContainer = registrationAccountExistContainer;
        this.registrationAccountInvite = registrationAccountInvite;
        this.registrationAccountInviteCheck = registrationAccountInviteCheck;
        this.registrationAccountInviteIcon = registrationAccountInviteIcon;
        this.registrationAccountInvitePlaceholder = registrationAccountInvitePlaceholder;
        this.registrationAccountIsExist = registrationAccountIsExist;
        this.registrationAccountIsExistButton = registrationAccountIsExistButton;
        this.registrationAccountNextButton = registrationAccountNextButton;
        this.registrationAccountNextButtonText = registrationAccountNextButtonText;
        this.registrationAccountPassword = registrationAccountPassword;
        this.registrationAccountPasswordCheck = registrationAccountPasswordCheck;
        this.registrationAccountPasswordIcon = registrationAccountPasswordIcon;
        this.registrationAccountPasswordPlaceholder = registrationAccountPasswordPlaceholder;
        this.registrationAccountSurname = registrationAccountSurname;
        this.registrationAccountSurnameCheck = registrationAccountSurnameCheck;
        this.registrationAccountSurnamePlaceholder = registrationAccountSurnamePlaceholder;
        this.registrationAccountTitle = registrationAccountTitle;
        this.registrationAccountUsername = registrationAccountUsername;
        this.registrationAccountUsernameCheck = registrationAccountUsernameCheck;
        this.registrationAccountUsernamePlaceholder = registrationAccountUsernamePlaceholder;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationAccountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationAccountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_account, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationAccountBinding bind(View rootView) {
        int i = R.id.center_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.reg_top_line;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.registration_account_background;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.registration_account_container;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout3 != null) {
                        i = R.id.registration_account_exist_container;
                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout4 != null) {
                            i = R.id.registration_account_invite;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout5 != null) {
                                i = R.id.registration_account_invite_check;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatImageView != null) {
                                    i = R.id.registration_account_invite_icon;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatImageView2 != null) {
                                        i = R.id.registration_account_invite_placeholder;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                        if (editText != null) {
                                            i = R.id.registration_account_is_exist;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView != null) {
                                                i = R.id.registration_account_is_exist_button;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView2 != null) {
                                                    i = R.id.registration_account_next_button;
                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout6 != null) {
                                                        i = R.id.registration_account_next_button_text;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView3 != null) {
                                                            i = R.id.registration_account_password;
                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout7 != null) {
                                                                i = R.id.registration_account_password_check;
                                                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (appCompatImageView3 != null) {
                                                                    i = R.id.registration_account_password_icon;
                                                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (appCompatImageView4 != null) {
                                                                        i = R.id.registration_account_password_placeholder;
                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                        if (editText2 != null) {
                                                                            i = R.id.registration_account_surname;
                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (constraintLayout8 != null) {
                                                                                i = R.id.registration_account_surname_check;
                                                                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (appCompatImageView5 != null) {
                                                                                    i = R.id.registration_account_surname_placeholder;
                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (editText3 != null) {
                                                                                        i = R.id.registration_account_title;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.registration_account_username;
                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (constraintLayout9 != null) {
                                                                                                i = R.id.registration_account_username_check;
                                                                                                AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (appCompatImageView6 != null) {
                                                                                                    i = R.id.registration_account_username_placeholder;
                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (editText4 != null) {
                                                                                                        return new RegistrationAccountBinding(constraintLayout, guideline, guideline2, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, appCompatImageView, appCompatImageView2, editText, textView, textView2, constraintLayout6, textView3, constraintLayout7, appCompatImageView3, appCompatImageView4, editText2, constraintLayout8, appCompatImageView5, editText3, textView4, constraintLayout9, appCompatImageView6, editText4);
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
