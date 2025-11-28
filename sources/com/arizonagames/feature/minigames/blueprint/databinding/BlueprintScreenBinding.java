package com.arizonagames.feature.minigames.blueprint.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.blueprint.R;
/* loaded from: classes3.dex */
public final class BlueprintScreenBinding implements ViewBinding {
    public final BlueprintLayoutAkBinding akContainer;
    public final TextView blueprintsText;
    public final AppCompatButton btnClose;
    public final LinearLayout containerDrawing;
    public final LinearLayout containerExperience;
    public final TextView experienceText;
    public final BlueprintHalloweenBinding halloween;
    public final ImageView imgMoney;
    public final TextView infoDesc;
    public final TextView infoTitle;
    public final LinearLayout moneyContainer;
    public final TextView moneyText;
    public final BlueprintPipeFiveBinding pipeFive;
    public final BlueprintPipeFourBinding pipeFour;
    public final BlueprintPipeOneBinding pipeOne;
    public final BlueprintPipeThreeBinding pipeThree;
    public final BlueprintPipeTwoBinding pipeTwo;
    public final BlueprintLayoutPmBinding pmContainer;
    public final LinearLayout rewardsPanelContainer;
    public final BlueprintLayoutRifleBinding rifleContainer;
    public final ConstraintLayout rodinaProposalScreen;
    private final ConstraintLayout rootView;
    public final BlueprintLayoutRpgBinding rpgContainer;
    public final BlueprintLayoutSnipeBinding snipeContainer;
    public final TextView weaponTitle;

    private BlueprintScreenBinding(ConstraintLayout constraintLayout, BlueprintLayoutAkBinding blueprintLayoutAkBinding, TextView textView, AppCompatButton appCompatButton, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, BlueprintHalloweenBinding blueprintHalloweenBinding, ImageView imageView, TextView textView3, TextView textView4, LinearLayout linearLayout3, TextView textView5, BlueprintPipeFiveBinding blueprintPipeFiveBinding, BlueprintPipeFourBinding blueprintPipeFourBinding, BlueprintPipeOneBinding blueprintPipeOneBinding, BlueprintPipeThreeBinding blueprintPipeThreeBinding, BlueprintPipeTwoBinding blueprintPipeTwoBinding, BlueprintLayoutPmBinding blueprintLayoutPmBinding, LinearLayout linearLayout4, BlueprintLayoutRifleBinding blueprintLayoutRifleBinding, ConstraintLayout constraintLayout2, BlueprintLayoutRpgBinding blueprintLayoutRpgBinding, BlueprintLayoutSnipeBinding blueprintLayoutSnipeBinding, TextView textView6) {
        this.rootView = constraintLayout;
        this.akContainer = blueprintLayoutAkBinding;
        this.blueprintsText = textView;
        this.btnClose = appCompatButton;
        this.containerDrawing = linearLayout;
        this.containerExperience = linearLayout2;
        this.experienceText = textView2;
        this.halloween = blueprintHalloweenBinding;
        this.imgMoney = imageView;
        this.infoDesc = textView3;
        this.infoTitle = textView4;
        this.moneyContainer = linearLayout3;
        this.moneyText = textView5;
        this.pipeFive = blueprintPipeFiveBinding;
        this.pipeFour = blueprintPipeFourBinding;
        this.pipeOne = blueprintPipeOneBinding;
        this.pipeThree = blueprintPipeThreeBinding;
        this.pipeTwo = blueprintPipeTwoBinding;
        this.pmContainer = blueprintLayoutPmBinding;
        this.rewardsPanelContainer = linearLayout4;
        this.rifleContainer = blueprintLayoutRifleBinding;
        this.rodinaProposalScreen = constraintLayout2;
        this.rpgContainer = blueprintLayoutRpgBinding;
        this.snipeContainer = blueprintLayoutSnipeBinding;
        this.weaponTitle = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BlueprintScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.blueprint_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintScreenBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.ak_container;
        View findChildViewById4 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null) {
            BlueprintLayoutAkBinding bind = BlueprintLayoutAkBinding.bind(findChildViewById4);
            i = R.id.blueprints_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.btn_close;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                if (appCompatButton != null) {
                    i = R.id.container_drawing;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.container_experience;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.experience_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.halloween))) != null) {
                                BlueprintHalloweenBinding bind2 = BlueprintHalloweenBinding.bind(findChildViewById);
                                i = R.id.img_money;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.info_desc;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.info_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.money_container;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.money_text;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.pipe_five))) != null) {
                                                    BlueprintPipeFiveBinding bind3 = BlueprintPipeFiveBinding.bind(findChildViewById2);
                                                    i = R.id.pipe_four;
                                                    View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                                    if (findChildViewById5 != null) {
                                                        BlueprintPipeFourBinding bind4 = BlueprintPipeFourBinding.bind(findChildViewById5);
                                                        i = R.id.pipe_one;
                                                        View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                                        if (findChildViewById6 != null) {
                                                            BlueprintPipeOneBinding bind5 = BlueprintPipeOneBinding.bind(findChildViewById6);
                                                            i = R.id.pipe_three;
                                                            View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                                                            if (findChildViewById7 != null) {
                                                                BlueprintPipeThreeBinding bind6 = BlueprintPipeThreeBinding.bind(findChildViewById7);
                                                                i = R.id.pipe_two;
                                                                View findChildViewById8 = ViewBindings.findChildViewById(view, i);
                                                                if (findChildViewById8 != null) {
                                                                    BlueprintPipeTwoBinding bind7 = BlueprintPipeTwoBinding.bind(findChildViewById8);
                                                                    i = R.id.pm_container;
                                                                    View findChildViewById9 = ViewBindings.findChildViewById(view, i);
                                                                    if (findChildViewById9 != null) {
                                                                        BlueprintLayoutPmBinding bind8 = BlueprintLayoutPmBinding.bind(findChildViewById9);
                                                                        i = R.id.rewards_panel_container;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.rifle_container))) != null) {
                                                                            BlueprintLayoutRifleBinding bind9 = BlueprintLayoutRifleBinding.bind(findChildViewById3);
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                            i = R.id.rpg_container;
                                                                            View findChildViewById10 = ViewBindings.findChildViewById(view, i);
                                                                            if (findChildViewById10 != null) {
                                                                                BlueprintLayoutRpgBinding bind10 = BlueprintLayoutRpgBinding.bind(findChildViewById10);
                                                                                i = R.id.snipe_container;
                                                                                View findChildViewById11 = ViewBindings.findChildViewById(view, i);
                                                                                if (findChildViewById11 != null) {
                                                                                    BlueprintLayoutSnipeBinding bind11 = BlueprintLayoutSnipeBinding.bind(findChildViewById11);
                                                                                    i = R.id.weapon_title;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        return new BlueprintScreenBinding(constraintLayout, bind, textView, appCompatButton, linearLayout, linearLayout2, textView2, bind2, imageView, textView3, textView4, linearLayout3, textView5, bind3, bind4, bind5, bind6, bind7, bind8, linearLayout4, bind9, constraintLayout, bind10, bind11, textView6);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
