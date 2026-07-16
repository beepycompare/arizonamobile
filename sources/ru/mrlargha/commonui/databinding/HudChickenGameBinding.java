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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudChickenGameBinding implements ViewBinding {
    public final CustomCardView btnMicro;
    public final HudChickenGameToolsItemBinding firstTools;
    public final LinearLayout hudButtonsContainer;
    public final TextView hudImposterGameImposterValue;
    public final AppCompatImageView hudImposterGameImposters;
    public final ImageView hudImposterGameItem1Used;
    public final AppCompatImageView hudImposterGamePersonIcon;
    public final TextView hudImposterGamePersonValue;
    public final CustomCardView hudImposterGameRole;
    public final AppCompatImageView hudImposterGameRoleImage;
    public final TextView hudImposterGameRoleText;
    public final CustomCardView hudImposterGameTasks;
    public final ConstraintLayout hudImpostergameContainer;
    public final ConstraintLayout hudInfoContainer;
    public final ImageView icMicro;
    public final FrameLayout imposterGame;
    public final ImageView ivFirstItem;
    private final FrameLayout rootView;
    public final RecyclerView rvGamerList;
    public final HudChickenGameToolsItemBinding secondTools;
    public final HudChickenGameToolsItemBinding thirdTools;
    public final HudChickenGameItemBinding userRating;

    private HudChickenGameBinding(FrameLayout rootView, CustomCardView btnMicro, HudChickenGameToolsItemBinding firstTools, LinearLayout hudButtonsContainer, TextView hudImposterGameImposterValue, AppCompatImageView hudImposterGameImposters, ImageView hudImposterGameItem1Used, AppCompatImageView hudImposterGamePersonIcon, TextView hudImposterGamePersonValue, CustomCardView hudImposterGameRole, AppCompatImageView hudImposterGameRoleImage, TextView hudImposterGameRoleText, CustomCardView hudImposterGameTasks, ConstraintLayout hudImpostergameContainer, ConstraintLayout hudInfoContainer, ImageView icMicro, FrameLayout imposterGame, ImageView ivFirstItem, RecyclerView rvGamerList, HudChickenGameToolsItemBinding secondTools, HudChickenGameToolsItemBinding thirdTools, HudChickenGameItemBinding userRating) {
        this.rootView = rootView;
        this.btnMicro = btnMicro;
        this.firstTools = firstTools;
        this.hudButtonsContainer = hudButtonsContainer;
        this.hudImposterGameImposterValue = hudImposterGameImposterValue;
        this.hudImposterGameImposters = hudImposterGameImposters;
        this.hudImposterGameItem1Used = hudImposterGameItem1Used;
        this.hudImposterGamePersonIcon = hudImposterGamePersonIcon;
        this.hudImposterGamePersonValue = hudImposterGamePersonValue;
        this.hudImposterGameRole = hudImposterGameRole;
        this.hudImposterGameRoleImage = hudImposterGameRoleImage;
        this.hudImposterGameRoleText = hudImposterGameRoleText;
        this.hudImposterGameTasks = hudImposterGameTasks;
        this.hudImpostergameContainer = hudImpostergameContainer;
        this.hudInfoContainer = hudInfoContainer;
        this.icMicro = icMicro;
        this.imposterGame = imposterGame;
        this.ivFirstItem = ivFirstItem;
        this.rvGamerList = rvGamerList;
        this.secondTools = secondTools;
        this.thirdTools = thirdTools;
        this.userRating = userRating;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudChickenGameBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudChickenGameBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_chicken_game, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudChickenGameBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.btn_micro;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.first_tools))) != null) {
            HudChickenGameToolsItemBinding bind = HudChickenGameToolsItemBinding.bind(findChildViewById);
            i = R.id.hud_buttons_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.hud_imposter_game_imposter_value;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.hud_imposter_game_imposters;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.hud_imposter_game_item1_used;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.hud_imposter_game_person_icon;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.hud_imposter_game_person_value;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.hud_imposter_game_role;
                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (customCardView2 != null) {
                                        i = R.id.hud_imposter_game_role_image;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (appCompatImageView3 != null) {
                                            i = R.id.hud_imposter_game_role_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.hud_imposter_game_tasks;
                                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                if (customCardView3 != null) {
                                                    i = R.id.hud_impostergame_container;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.hud_info_container;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (constraintLayout2 != null) {
                                                            i = R.id.ic_micro;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView2 != null) {
                                                                FrameLayout frameLayout = (FrameLayout) rootView;
                                                                i = R.id.iv_first_item;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.rv_gamer_list;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (recyclerView != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.second_tools))) != null) {
                                                                        HudChickenGameToolsItemBinding bind2 = HudChickenGameToolsItemBinding.bind(findChildViewById2);
                                                                        i = R.id.third_tools;
                                                                        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                                                                        if (findChildViewById3 != null) {
                                                                            HudChickenGameToolsItemBinding bind3 = HudChickenGameToolsItemBinding.bind(findChildViewById3);
                                                                            i = R.id.user_rating;
                                                                            View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById4 != null) {
                                                                                return new HudChickenGameBinding(frameLayout, customCardView, bind, linearLayout, textView, appCompatImageView, imageView, appCompatImageView2, textView2, customCardView2, appCompatImageView3, textView3, customCardView3, constraintLayout, constraintLayout2, imageView2, frameLayout, imageView3, recyclerView, bind2, bind3, HudChickenGameItemBinding.bind(findChildViewById4));
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
