package ru.mrlargha.commonui.databinding;

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
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BlueprintScreenBinding implements ViewBinding {
    public final BlueprintLayoutAkBinding akContainer;
    public final TextView blueprintsText;
    public final AppCompatButton btnClose;
    public final LinearLayout containerDrawing;
    public final LinearLayout containerExperience;
    public final TextView experienceText;
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

    private BlueprintScreenBinding(ConstraintLayout rootView, BlueprintLayoutAkBinding akContainer, TextView blueprintsText, AppCompatButton btnClose, LinearLayout containerDrawing, LinearLayout containerExperience, TextView experienceText, ImageView imgMoney, TextView infoDesc, TextView infoTitle, LinearLayout moneyContainer, TextView moneyText, BlueprintPipeFiveBinding pipeFive, BlueprintPipeFourBinding pipeFour, BlueprintPipeOneBinding pipeOne, BlueprintPipeThreeBinding pipeThree, BlueprintPipeTwoBinding pipeTwo, BlueprintLayoutPmBinding pmContainer, LinearLayout rewardsPanelContainer, BlueprintLayoutRifleBinding rifleContainer, ConstraintLayout rodinaProposalScreen, BlueprintLayoutRpgBinding rpgContainer, BlueprintLayoutSnipeBinding snipeContainer, TextView weaponTitle) {
        this.rootView = rootView;
        this.akContainer = akContainer;
        this.blueprintsText = blueprintsText;
        this.btnClose = btnClose;
        this.containerDrawing = containerDrawing;
        this.containerExperience = containerExperience;
        this.experienceText = experienceText;
        this.imgMoney = imgMoney;
        this.infoDesc = infoDesc;
        this.infoTitle = infoTitle;
        this.moneyContainer = moneyContainer;
        this.moneyText = moneyText;
        this.pipeFive = pipeFive;
        this.pipeFour = pipeFour;
        this.pipeOne = pipeOne;
        this.pipeThree = pipeThree;
        this.pipeTwo = pipeTwo;
        this.pmContainer = pmContainer;
        this.rewardsPanelContainer = rewardsPanelContainer;
        this.rifleContainer = rifleContainer;
        this.rodinaProposalScreen = rodinaProposalScreen;
        this.rpgContainer = rpgContainer;
        this.snipeContainer = snipeContainer;
        this.weaponTitle = weaponTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BlueprintScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BlueprintScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.blueprint_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BlueprintScreenBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.ak_container;
        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById3 != null) {
            BlueprintLayoutAkBinding bind = BlueprintLayoutAkBinding.bind(findChildViewById3);
            i = R.id.blueprints_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.btn_close;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatButton != null) {
                    i = R.id.container_drawing;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.container_experience;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.experience_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.img_money;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.info_desc;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.info_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.money_container;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.money_text;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.pipe_five))) != null) {
                                                    BlueprintPipeFiveBinding bind2 = BlueprintPipeFiveBinding.bind(findChildViewById);
                                                    i = R.id.pipe_four;
                                                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                                                    if (findChildViewById4 != null) {
                                                        BlueprintPipeFourBinding bind3 = BlueprintPipeFourBinding.bind(findChildViewById4);
                                                        i = R.id.pipe_one;
                                                        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById5 != null) {
                                                            BlueprintPipeOneBinding bind4 = BlueprintPipeOneBinding.bind(findChildViewById5);
                                                            i = R.id.pipe_three;
                                                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById6 != null) {
                                                                BlueprintPipeThreeBinding bind5 = BlueprintPipeThreeBinding.bind(findChildViewById6);
                                                                i = R.id.pipe_two;
                                                                View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                                                                if (findChildViewById7 != null) {
                                                                    BlueprintPipeTwoBinding bind6 = BlueprintPipeTwoBinding.bind(findChildViewById7);
                                                                    i = R.id.pm_container;
                                                                    View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                                                    if (findChildViewById8 != null) {
                                                                        BlueprintLayoutPmBinding bind7 = BlueprintLayoutPmBinding.bind(findChildViewById8);
                                                                        i = R.id.rewards_panel_container;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout4 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.rifle_container))) != null) {
                                                                            BlueprintLayoutRifleBinding bind8 = BlueprintLayoutRifleBinding.bind(findChildViewById2);
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                            i = R.id.rpg_container;
                                                                            View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById9 != null) {
                                                                                BlueprintLayoutRpgBinding bind9 = BlueprintLayoutRpgBinding.bind(findChildViewById9);
                                                                                i = R.id.snipe_container;
                                                                                View findChildViewById10 = ViewBindings.findChildViewById(rootView, i);
                                                                                if (findChildViewById10 != null) {
                                                                                    BlueprintLayoutSnipeBinding bind10 = BlueprintLayoutSnipeBinding.bind(findChildViewById10);
                                                                                    i = R.id.weapon_title;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView6 != null) {
                                                                                        return new BlueprintScreenBinding(constraintLayout, bind, textView, appCompatButton, linearLayout, linearLayout2, textView2, imageView, textView3, textView4, linearLayout3, textView5, bind2, bind3, bind4, bind5, bind6, bind7, linearLayout4, bind8, constraintLayout, bind9, bind10, textView6);
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
