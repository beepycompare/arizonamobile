package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.CustomTextView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudLeftMenuBinding implements ViewBinding {
    public final CustomCardView btnOpenBattlePass;
    public final ImageView btnOpenBattlePassIcon;
    public final CustomTextView btnOpenBattlePassText;
    public final FrameLayout btnOpenChallenges;
    public final ImageView btnOpenMission;
    public final ImageView btnOpenQuest;
    public final ImageView btnOpenRadialMenu;
    private final LinearLayout rootView;
    public final TextView tvChallenge;

    private HudLeftMenuBinding(LinearLayout rootView, CustomCardView btnOpenBattlePass, ImageView btnOpenBattlePassIcon, CustomTextView btnOpenBattlePassText, FrameLayout btnOpenChallenges, ImageView btnOpenMission, ImageView btnOpenQuest, ImageView btnOpenRadialMenu, TextView tvChallenge) {
        this.rootView = rootView;
        this.btnOpenBattlePass = btnOpenBattlePass;
        this.btnOpenBattlePassIcon = btnOpenBattlePassIcon;
        this.btnOpenBattlePassText = btnOpenBattlePassText;
        this.btnOpenChallenges = btnOpenChallenges;
        this.btnOpenMission = btnOpenMission;
        this.btnOpenQuest = btnOpenQuest;
        this.btnOpenRadialMenu = btnOpenRadialMenu;
        this.tvChallenge = tvChallenge;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudLeftMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudLeftMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_left_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudLeftMenuBinding bind(View rootView) {
        int i = R.id.btn_open_battle_pass;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.btn_open_battle_pass_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.btn_open_battle_pass_text;
                CustomTextView customTextView = (CustomTextView) ViewBindings.findChildViewById(rootView, i);
                if (customTextView != null) {
                    i = R.id.btn_open_challenges;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (frameLayout != null) {
                        i = R.id.btn_open_mission;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            i = R.id.btn_open_quest;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView3 != null) {
                                i = R.id.btn_open_radial_menu;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView4 != null) {
                                    i = R.id.tv_challenge;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        return new HudLeftMenuBinding((LinearLayout) rootView, customCardView, imageView, customTextView, frameLayout, imageView2, imageView3, imageView4, textView);
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
