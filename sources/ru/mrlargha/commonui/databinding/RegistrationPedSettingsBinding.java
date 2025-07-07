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
public final class RegistrationPedSettingsBinding implements ViewBinding {
    public final ConstraintLayout registrationPedClothesContainer;
    public final AppCompatImageView registrationPedClothesLeftButton;
    public final TextView registrationPedClothesName;
    public final AppCompatImageView registrationPedClothesRightButton;
    public final ConstraintLayout registrationPedGenderContainer;
    public final ConstraintLayout registrationPedMenContainer;
    public final TextView registrationPedMenText;
    public final ConstraintLayout registrationPedSettings;
    public final ConstraintLayout registrationPedSettingsBackground;
    public final ConstraintLayout registrationPedSettingsContainer;
    public final TextView registrationPedSettingsTitle;
    public final AppCompatImageView registrationPedShadowSettingsPed;
    public final ConstraintLayout registrationPedSkinBlackContainer;
    public final AppCompatImageView registrationPedSkinBlackImage;
    public final ConstraintLayout registrationPedSkinContainer;
    public final ConstraintLayout registrationPedSkinWhiteContainer;
    public final AppCompatImageView registrationPedSkinWhiteImage;
    public final ConstraintLayout registrationPedStartGameButton;
    public final TextView registrationPedStartGameButtonText;
    public final ConstraintLayout registrationPedWomenContainer;
    public final TextView registrationPedWomenText;
    private final ConstraintLayout rootView;

    private RegistrationPedSettingsBinding(ConstraintLayout rootView, ConstraintLayout registrationPedClothesContainer, AppCompatImageView registrationPedClothesLeftButton, TextView registrationPedClothesName, AppCompatImageView registrationPedClothesRightButton, ConstraintLayout registrationPedGenderContainer, ConstraintLayout registrationPedMenContainer, TextView registrationPedMenText, ConstraintLayout registrationPedSettings, ConstraintLayout registrationPedSettingsBackground, ConstraintLayout registrationPedSettingsContainer, TextView registrationPedSettingsTitle, AppCompatImageView registrationPedShadowSettingsPed, ConstraintLayout registrationPedSkinBlackContainer, AppCompatImageView registrationPedSkinBlackImage, ConstraintLayout registrationPedSkinContainer, ConstraintLayout registrationPedSkinWhiteContainer, AppCompatImageView registrationPedSkinWhiteImage, ConstraintLayout registrationPedStartGameButton, TextView registrationPedStartGameButtonText, ConstraintLayout registrationPedWomenContainer, TextView registrationPedWomenText) {
        this.rootView = rootView;
        this.registrationPedClothesContainer = registrationPedClothesContainer;
        this.registrationPedClothesLeftButton = registrationPedClothesLeftButton;
        this.registrationPedClothesName = registrationPedClothesName;
        this.registrationPedClothesRightButton = registrationPedClothesRightButton;
        this.registrationPedGenderContainer = registrationPedGenderContainer;
        this.registrationPedMenContainer = registrationPedMenContainer;
        this.registrationPedMenText = registrationPedMenText;
        this.registrationPedSettings = registrationPedSettings;
        this.registrationPedSettingsBackground = registrationPedSettingsBackground;
        this.registrationPedSettingsContainer = registrationPedSettingsContainer;
        this.registrationPedSettingsTitle = registrationPedSettingsTitle;
        this.registrationPedShadowSettingsPed = registrationPedShadowSettingsPed;
        this.registrationPedSkinBlackContainer = registrationPedSkinBlackContainer;
        this.registrationPedSkinBlackImage = registrationPedSkinBlackImage;
        this.registrationPedSkinContainer = registrationPedSkinContainer;
        this.registrationPedSkinWhiteContainer = registrationPedSkinWhiteContainer;
        this.registrationPedSkinWhiteImage = registrationPedSkinWhiteImage;
        this.registrationPedStartGameButton = registrationPedStartGameButton;
        this.registrationPedStartGameButtonText = registrationPedStartGameButtonText;
        this.registrationPedWomenContainer = registrationPedWomenContainer;
        this.registrationPedWomenText = registrationPedWomenText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationPedSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationPedSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.registration_ped_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RegistrationPedSettingsBinding bind(View rootView) {
        int i = R.id.registration_ped_clothes_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.registration_ped_clothes_left_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.registration_ped_clothes_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.registration_ped_clothes_right_button;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.registration_ped_gender_container;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.registration_ped_men_container;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout3 != null) {
                                i = R.id.registration_ped_men_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) rootView;
                                    i = R.id.registration_ped_settings_background;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.registration_ped_settings_container;
                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout6 != null) {
                                            i = R.id.registration_ped_settings_title;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.registration_ped_shadow_settings_ped;
                                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatImageView3 != null) {
                                                    i = R.id.registration_ped_skin_black_container;
                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout7 != null) {
                                                        i = R.id.registration_ped_skin_black_image;
                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatImageView4 != null) {
                                                            i = R.id.registration_ped_skin_container;
                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout8 != null) {
                                                                i = R.id.registration_ped_skin_white_container;
                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout9 != null) {
                                                                    i = R.id.registration_ped_skin_white_image;
                                                                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (appCompatImageView5 != null) {
                                                                        i = R.id.registration_ped_start_game_button;
                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (constraintLayout10 != null) {
                                                                            i = R.id.registration_ped_start_game_button_text;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.registration_ped_women_container;
                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout11 != null) {
                                                                                    i = R.id.registration_ped_women_text;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView5 != null) {
                                                                                        return new RegistrationPedSettingsBinding(constraintLayout4, constraintLayout, appCompatImageView, textView, appCompatImageView2, constraintLayout2, constraintLayout3, textView2, constraintLayout4, constraintLayout5, constraintLayout6, textView3, appCompatImageView3, constraintLayout7, appCompatImageView4, constraintLayout8, constraintLayout9, appCompatImageView5, constraintLayout10, textView4, constraintLayout11, textView5);
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
