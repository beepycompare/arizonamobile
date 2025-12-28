package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes5.dex */
public final class HudElementImposterGameBinding implements ViewBinding {
    public final LinearLayout hudButtonsContainer;
    public final TextView hudImposterGameImposterValue;
    public final AppCompatImageView hudImposterGameImposters;
    public final CustomCardView hudImposterGameItem1;
    public final ImageView hudImposterGameItem1Image;
    public final ImageView hudImposterGameItem1Used;
    public final CustomCardView hudImposterGameItem2;
    public final ImageView hudImposterGameItem2Image;
    public final ImageView hudImposterGameItem2Used;
    public final AppCompatImageView hudImposterGamePersonIcon;
    public final TextView hudImposterGamePersonValue;
    public final CustomCardView hudImposterGameRole;
    public final AppCompatImageView hudImposterGameRoleImage;
    public final TextView hudImposterGameRoleText;
    public final CustomCardView hudImposterGameTasks;
    public final CustomCardView hudImposterGameTrash;
    public final ConstraintLayout hudImpostergameContainer;
    public final ConstraintLayout hudInfoContainer;
    public final FrameLayout imposterGame;
    private final FrameLayout rootView;
    public final ImageView zoneType;

    private HudElementImposterGameBinding(FrameLayout rootView, LinearLayout hudButtonsContainer, TextView hudImposterGameImposterValue, AppCompatImageView hudImposterGameImposters, CustomCardView hudImposterGameItem1, ImageView hudImposterGameItem1Image, ImageView hudImposterGameItem1Used, CustomCardView hudImposterGameItem2, ImageView hudImposterGameItem2Image, ImageView hudImposterGameItem2Used, AppCompatImageView hudImposterGamePersonIcon, TextView hudImposterGamePersonValue, CustomCardView hudImposterGameRole, AppCompatImageView hudImposterGameRoleImage, TextView hudImposterGameRoleText, CustomCardView hudImposterGameTasks, CustomCardView hudImposterGameTrash, ConstraintLayout hudImpostergameContainer, ConstraintLayout hudInfoContainer, FrameLayout imposterGame, ImageView zoneType) {
        this.rootView = rootView;
        this.hudButtonsContainer = hudButtonsContainer;
        this.hudImposterGameImposterValue = hudImposterGameImposterValue;
        this.hudImposterGameImposters = hudImposterGameImposters;
        this.hudImposterGameItem1 = hudImposterGameItem1;
        this.hudImposterGameItem1Image = hudImposterGameItem1Image;
        this.hudImposterGameItem1Used = hudImposterGameItem1Used;
        this.hudImposterGameItem2 = hudImposterGameItem2;
        this.hudImposterGameItem2Image = hudImposterGameItem2Image;
        this.hudImposterGameItem2Used = hudImposterGameItem2Used;
        this.hudImposterGamePersonIcon = hudImposterGamePersonIcon;
        this.hudImposterGamePersonValue = hudImposterGamePersonValue;
        this.hudImposterGameRole = hudImposterGameRole;
        this.hudImposterGameRoleImage = hudImposterGameRoleImage;
        this.hudImposterGameRoleText = hudImposterGameRoleText;
        this.hudImposterGameTasks = hudImposterGameTasks;
        this.hudImposterGameTrash = hudImposterGameTrash;
        this.hudImpostergameContainer = hudImpostergameContainer;
        this.hudInfoContainer = hudInfoContainer;
        this.imposterGame = imposterGame;
        this.zoneType = zoneType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementImposterGameBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementImposterGameBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_imposter_game, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementImposterGameBinding bind(View rootView) {
        int i = R.id.hud_buttons_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.hud_imposter_game_imposter_value;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.hud_imposter_game_imposters;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    i = R.id.hud_imposter_game_item1;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView != null) {
                        i = R.id.hud_imposter_game_item1_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.hud_imposter_game_item1_used;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.hud_imposter_game_item2;
                                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView2 != null) {
                                    i = R.id.hud_imposter_game_item2_image;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView3 != null) {
                                        i = R.id.hud_imposter_game_item2_used;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView4 != null) {
                                            i = R.id.hud_imposter_game_person_icon;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (appCompatImageView2 != null) {
                                                i = R.id.hud_imposter_game_person_value;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView2 != null) {
                                                    i = R.id.hud_imposter_game_role;
                                                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                    if (customCardView3 != null) {
                                                        i = R.id.hud_imposter_game_role_image;
                                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatImageView3 != null) {
                                                            i = R.id.hud_imposter_game_role_text;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView3 != null) {
                                                                i = R.id.hud_imposter_game_tasks;
                                                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                if (customCardView4 != null) {
                                                                    i = R.id.hud_imposter_game_trash;
                                                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (customCardView5 != null) {
                                                                        i = R.id.hud_impostergame_container;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (constraintLayout != null) {
                                                                            i = R.id.hud_info_container;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (constraintLayout2 != null) {
                                                                                FrameLayout frameLayout = (FrameLayout) rootView;
                                                                                i = R.id.zone_type;
                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (imageView5 != null) {
                                                                                    return new HudElementImposterGameBinding(frameLayout, linearLayout, textView, appCompatImageView, customCardView, imageView, imageView2, customCardView2, imageView3, imageView4, appCompatImageView2, textView2, customCardView3, appCompatImageView3, textView3, customCardView4, customCardView5, constraintLayout, constraintLayout2, frameLayout, imageView5);
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
