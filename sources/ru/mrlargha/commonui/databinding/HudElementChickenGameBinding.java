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
public final class HudElementChickenGameBinding implements ViewBinding {
    public final HudChickenGameToolsItemBinding firstTools;
    public final LinearLayout hudButtonsContainer;
    public final TextView hudImposterGameImposterValue;
    public final AppCompatImageView hudImposterGameImposters;
    public final AppCompatImageView hudImposterGamePersonIcon;
    public final TextView hudImposterGamePersonValue;
    public final CustomCardView hudImposterGameRole;
    public final AppCompatImageView hudImposterGameRoleImage;
    public final TextView hudImposterGameRoleText;
    public final CustomCardView hudImposterGameTasks;
    public final ConstraintLayout hudImpostergameContainer;
    public final ConstraintLayout hudInfoContainer;
    public final FrameLayout imposterGame;
    public final ImageView ivFirstItem;
    public final AppCompatImageView ivMoney;
    private final FrameLayout rootView;
    public final RecyclerView rvGamerList;
    public final HudChickenGameToolsItemBinding secondTools;
    public final HudChickenGameToolsItemBinding thirdTools;
    public final TextView tvMoney;
    public final HudChickenGameItemBinding userRating;
    public final ImageView zoneType;

    private HudElementChickenGameBinding(FrameLayout rootView, HudChickenGameToolsItemBinding firstTools, LinearLayout hudButtonsContainer, TextView hudImposterGameImposterValue, AppCompatImageView hudImposterGameImposters, AppCompatImageView hudImposterGamePersonIcon, TextView hudImposterGamePersonValue, CustomCardView hudImposterGameRole, AppCompatImageView hudImposterGameRoleImage, TextView hudImposterGameRoleText, CustomCardView hudImposterGameTasks, ConstraintLayout hudImpostergameContainer, ConstraintLayout hudInfoContainer, FrameLayout imposterGame, ImageView ivFirstItem, AppCompatImageView ivMoney, RecyclerView rvGamerList, HudChickenGameToolsItemBinding secondTools, HudChickenGameToolsItemBinding thirdTools, TextView tvMoney, HudChickenGameItemBinding userRating, ImageView zoneType) {
        this.rootView = rootView;
        this.firstTools = firstTools;
        this.hudButtonsContainer = hudButtonsContainer;
        this.hudImposterGameImposterValue = hudImposterGameImposterValue;
        this.hudImposterGameImposters = hudImposterGameImposters;
        this.hudImposterGamePersonIcon = hudImposterGamePersonIcon;
        this.hudImposterGamePersonValue = hudImposterGamePersonValue;
        this.hudImposterGameRole = hudImposterGameRole;
        this.hudImposterGameRoleImage = hudImposterGameRoleImage;
        this.hudImposterGameRoleText = hudImposterGameRoleText;
        this.hudImposterGameTasks = hudImposterGameTasks;
        this.hudImpostergameContainer = hudImpostergameContainer;
        this.hudInfoContainer = hudInfoContainer;
        this.imposterGame = imposterGame;
        this.ivFirstItem = ivFirstItem;
        this.ivMoney = ivMoney;
        this.rvGamerList = rvGamerList;
        this.secondTools = secondTools;
        this.thirdTools = thirdTools;
        this.tvMoney = tvMoney;
        this.userRating = userRating;
        this.zoneType = zoneType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementChickenGameBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementChickenGameBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_chicken_game, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementChickenGameBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.first_tools;
        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById3 != null) {
            HudChickenGameToolsItemBinding bind = HudChickenGameToolsItemBinding.bind(findChildViewById3);
            i = R.id.hud_buttons_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.hud_imposter_game_imposter_value;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.hud_imposter_game_imposters;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.hud_imposter_game_person_icon;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.hud_imposter_game_person_value;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.hud_imposter_game_role;
                                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView != null) {
                                    i = R.id.hud_imposter_game_role_image;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatImageView3 != null) {
                                        i = R.id.hud_imposter_game_role_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.hud_imposter_game_tasks;
                                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                            if (customCardView2 != null) {
                                                i = R.id.hud_impostergame_container;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (constraintLayout != null) {
                                                    i = R.id.hud_info_container;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout2 != null) {
                                                        FrameLayout frameLayout = (FrameLayout) rootView;
                                                        i = R.id.iv_first_item;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView != null) {
                                                            i = R.id.iv_money;
                                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (appCompatImageView4 != null) {
                                                                i = R.id.rv_gamer_list;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                if (recyclerView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.second_tools))) != null) {
                                                                    HudChickenGameToolsItemBinding bind2 = HudChickenGameToolsItemBinding.bind(findChildViewById);
                                                                    i = R.id.third_tools;
                                                                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                                                                    if (findChildViewById4 != null) {
                                                                        HudChickenGameToolsItemBinding bind3 = HudChickenGameToolsItemBinding.bind(findChildViewById4);
                                                                        i = R.id.tv_money;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView4 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.user_rating))) != null) {
                                                                            HudChickenGameItemBinding bind4 = HudChickenGameItemBinding.bind(findChildViewById2);
                                                                            i = R.id.zone_type;
                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (imageView2 != null) {
                                                                                return new HudElementChickenGameBinding(frameLayout, bind, linearLayout, textView, appCompatImageView, appCompatImageView2, textView2, customCardView, appCompatImageView3, textView3, customCardView2, constraintLayout, constraintLayout2, frameLayout, imageView, appCompatImageView4, recyclerView, bind2, bind3, textView4, bind4, imageView2);
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
