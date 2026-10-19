package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText;
/* loaded from: classes6.dex */
public final class RegistrationAccountBinding implements ViewBinding {
    public final Guideline centerLine;
    public final RelativeLayout clickerContainer;
    public final Guideline regTopLine;
    public final ConstraintLayout registrationAccount;
    public final ConstraintLayout registrationAccountBackground;
    public final ConstraintLayout registrationAccountContainer;
    public final ConstraintLayout registrationAccountExistContainer;
    public final ConstraintLayout registrationAccountInvite;
    public final AppCompatImageView registrationAccountInviteCheck;
    public final AppCompatImageView registrationAccountInviteIcon;
    public final KeyboardEditText registrationAccountInvitePlaceholder;
    public final TextView registrationAccountIsExist;
    public final TextView registrationAccountIsExistButton;
    public final ConstraintLayout registrationAccountNextButton;
    public final TextView registrationAccountNextButtonText;
    public final ConstraintLayout registrationAccountPassword;
    public final AppCompatImageView registrationAccountPasswordCheck;
    public final AppCompatImageView registrationAccountPasswordIcon;
    public final KeyboardEditText registrationAccountPasswordPlaceholder;
    public final ConstraintLayout registrationAccountPromo;
    public final AppCompatImageView registrationAccountPromoCheck;
    public final AppCompatImageView registrationAccountPromoIcon;
    public final KeyboardEditText registrationAccountPromoPlaceholder;
    public final ConstraintLayout registrationAccountSurname;
    public final AppCompatImageView registrationAccountSurnameCheck;
    public final KeyboardEditText registrationAccountSurnamePlaceholder;
    public final TextView registrationAccountTitle;
    public final ConstraintLayout registrationAccountUsername;
    public final AppCompatImageView registrationAccountUsernameCheck;
    public final KeyboardEditText registrationAccountUsernamePlaceholder;
    private final ConstraintLayout rootView;

    private RegistrationAccountBinding(ConstraintLayout rootView, Guideline centerLine, RelativeLayout clickerContainer, Guideline regTopLine, ConstraintLayout registrationAccount, ConstraintLayout registrationAccountBackground, ConstraintLayout registrationAccountContainer, ConstraintLayout registrationAccountExistContainer, ConstraintLayout registrationAccountInvite, AppCompatImageView registrationAccountInviteCheck, AppCompatImageView registrationAccountInviteIcon, KeyboardEditText registrationAccountInvitePlaceholder, TextView registrationAccountIsExist, TextView registrationAccountIsExistButton, ConstraintLayout registrationAccountNextButton, TextView registrationAccountNextButtonText, ConstraintLayout registrationAccountPassword, AppCompatImageView registrationAccountPasswordCheck, AppCompatImageView registrationAccountPasswordIcon, KeyboardEditText registrationAccountPasswordPlaceholder, ConstraintLayout registrationAccountPromo, AppCompatImageView registrationAccountPromoCheck, AppCompatImageView registrationAccountPromoIcon, KeyboardEditText registrationAccountPromoPlaceholder, ConstraintLayout registrationAccountSurname, AppCompatImageView registrationAccountSurnameCheck, KeyboardEditText registrationAccountSurnamePlaceholder, TextView registrationAccountTitle, ConstraintLayout registrationAccountUsername, AppCompatImageView registrationAccountUsernameCheck, KeyboardEditText registrationAccountUsernamePlaceholder) {
        this.rootView = rootView;
        this.centerLine = centerLine;
        this.clickerContainer = clickerContainer;
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
        this.registrationAccountPromo = registrationAccountPromo;
        this.registrationAccountPromoCheck = registrationAccountPromoCheck;
        this.registrationAccountPromoIcon = registrationAccountPromoIcon;
        this.registrationAccountPromoPlaceholder = registrationAccountPromoPlaceholder;
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
            i = R.id.clicker_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
            if (relativeLayout != null) {
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
                                            KeyboardEditText keyboardEditText = (KeyboardEditText) ViewBindings.findChildViewById(rootView, i);
                                            if (keyboardEditText != null) {
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
                                                                            KeyboardEditText keyboardEditText2 = (KeyboardEditText) ViewBindings.findChildViewById(rootView, i);
                                                                            if (keyboardEditText2 != null) {
                                                                                i = R.id.registration_account_promo;
                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout8 != null) {
                                                                                    i = R.id.registration_account_promo_check;
                                                                                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (appCompatImageView5 != null) {
                                                                                        i = R.id.registration_account_promo_icon;
                                                                                        AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (appCompatImageView6 != null) {
                                                                                            i = R.id.registration_account_promo_placeholder;
                                                                                            KeyboardEditText keyboardEditText3 = (KeyboardEditText) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (keyboardEditText3 != null) {
                                                                                                i = R.id.registration_account_surname;
                                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (constraintLayout9 != null) {
                                                                                                    i = R.id.registration_account_surname_check;
                                                                                                    AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (appCompatImageView7 != null) {
                                                                                                        i = R.id.registration_account_surname_placeholder;
                                                                                                        KeyboardEditText keyboardEditText4 = (KeyboardEditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (keyboardEditText4 != null) {
                                                                                                            i = R.id.registration_account_title;
                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView4 != null) {
                                                                                                                i = R.id.registration_account_username;
                                                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (constraintLayout10 != null) {
                                                                                                                    i = R.id.registration_account_username_check;
                                                                                                                    AppCompatImageView appCompatImageView8 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (appCompatImageView8 != null) {
                                                                                                                        i = R.id.registration_account_username_placeholder;
                                                                                                                        KeyboardEditText keyboardEditText5 = (KeyboardEditText) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (keyboardEditText5 != null) {
                                                                                                                            return new RegistrationAccountBinding(constraintLayout, guideline, relativeLayout, guideline2, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, appCompatImageView, appCompatImageView2, keyboardEditText, textView, textView2, constraintLayout6, textView3, constraintLayout7, appCompatImageView3, appCompatImageView4, keyboardEditText2, constraintLayout8, appCompatImageView5, appCompatImageView6, keyboardEditText3, constraintLayout9, appCompatImageView7, keyboardEditText4, textView4, constraintLayout10, appCompatImageView8, keyboardEditText5);
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
