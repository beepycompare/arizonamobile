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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudElementChickenChargeBinding implements ViewBinding {
    public final CustomCardView action;
    public final ImageView actionIc;
    public final TextView actionText;
    public final TextView chance1;
    public final TextView chance2;
    public final ImageView chickenGif;
    public final ImageView chickenGif2;
    public final CustomCardView close;
    public final TextView desc1;
    public final TextView desc2;
    public final LinearLayout finalContainer;
    public final CustomCardView greenZone;
    public final CustomCardView greenZone2;
    public final FrameLayout hided;
    public final ImageView ivBg;
    public final ImageView ivBgFinal;
    public final LinearLayout main;
    public final TextView name1;
    public final TextView name2;
    public final FrameLayout pirates;
    public final CustomCardView player1progressbar;
    public final FrameLayout player1target;
    public final LinearLayout player1tooltip;
    public final CustomCardView player2progressbar;
    public final FrameLayout player2target;
    public final LinearLayout player2tooltip;
    public final CustomCardView redZone;
    public final CustomCardView redZone2;
    private final FrameLayout rootView;
    public final TextView stage;
    public final TextView tvPercentSuccess;
    public final TextView tvResult;
    public final TextView tvWaitingYou;
    public final TextView tvYouWaiting;
    public final FrameLayout zone;
    public final FrameLayout zone2;

    private HudElementChickenChargeBinding(FrameLayout rootView, CustomCardView action, ImageView actionIc, TextView actionText, TextView chance1, TextView chance2, ImageView chickenGif, ImageView chickenGif2, CustomCardView close, TextView desc1, TextView desc2, LinearLayout finalContainer, CustomCardView greenZone, CustomCardView greenZone2, FrameLayout hided, ImageView ivBg, ImageView ivBgFinal, LinearLayout main, TextView name1, TextView name2, FrameLayout pirates, CustomCardView player1progressbar, FrameLayout player1target, LinearLayout player1tooltip, CustomCardView player2progressbar, FrameLayout player2target, LinearLayout player2tooltip, CustomCardView redZone, CustomCardView redZone2, TextView stage, TextView tvPercentSuccess, TextView tvResult, TextView tvWaitingYou, TextView tvYouWaiting, FrameLayout zone, FrameLayout zone2) {
        this.rootView = rootView;
        this.action = action;
        this.actionIc = actionIc;
        this.actionText = actionText;
        this.chance1 = chance1;
        this.chance2 = chance2;
        this.chickenGif = chickenGif;
        this.chickenGif2 = chickenGif2;
        this.close = close;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.finalContainer = finalContainer;
        this.greenZone = greenZone;
        this.greenZone2 = greenZone2;
        this.hided = hided;
        this.ivBg = ivBg;
        this.ivBgFinal = ivBgFinal;
        this.main = main;
        this.name1 = name1;
        this.name2 = name2;
        this.pirates = pirates;
        this.player1progressbar = player1progressbar;
        this.player1target = player1target;
        this.player1tooltip = player1tooltip;
        this.player2progressbar = player2progressbar;
        this.player2target = player2target;
        this.player2tooltip = player2tooltip;
        this.redZone = redZone;
        this.redZone2 = redZone2;
        this.stage = stage;
        this.tvPercentSuccess = tvPercentSuccess;
        this.tvResult = tvResult;
        this.tvWaitingYou = tvWaitingYou;
        this.tvYouWaiting = tvYouWaiting;
        this.zone = zone;
        this.zone2 = zone2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementChickenChargeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementChickenChargeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_chicken_charge, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementChickenChargeBinding bind(View rootView) {
        int i = R.id.action;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.action_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.action_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.chance1;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.chance2;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.chicken_gif;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.chicken_gif2;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView3 != null) {
                                    i = R.id.close;
                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (customCardView2 != null) {
                                        i = R.id.desc1;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.desc2;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.final_container;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout != null) {
                                                    i = R.id.green_zone;
                                                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                    if (customCardView3 != null) {
                                                        i = R.id.green_zone2;
                                                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                        if (customCardView4 != null) {
                                                            i = R.id.hided;
                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (frameLayout != null) {
                                                                i = R.id.iv_bg;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView4 != null) {
                                                                    i = R.id.iv_bg_final;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (imageView5 != null) {
                                                                        i = R.id.main;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.name1;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.name2;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView7 != null) {
                                                                                    FrameLayout frameLayout2 = (FrameLayout) rootView;
                                                                                    i = R.id.player1progressbar;
                                                                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (customCardView5 != null) {
                                                                                        i = R.id.player1target;
                                                                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (frameLayout3 != null) {
                                                                                            i = R.id.player1tooltip;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = R.id.player2progressbar;
                                                                                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (customCardView6 != null) {
                                                                                                    i = R.id.player2target;
                                                                                                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (frameLayout4 != null) {
                                                                                                        i = R.id.player2tooltip;
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i = R.id.red_zone;
                                                                                                            CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (customCardView7 != null) {
                                                                                                                i = R.id.red_zone2;
                                                                                                                CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (customCardView8 != null) {
                                                                                                                    i = R.id.stage;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.tv_percent_success;
                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i = R.id.tv_result;
                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = R.id.tv_waiting_you;
                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = R.id.tv_you_waiting;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = R.id.zone;
                                                                                                                                        FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (frameLayout5 != null) {
                                                                                                                                            i = R.id.zone2;
                                                                                                                                            FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (frameLayout6 != null) {
                                                                                                                                                return new HudElementChickenChargeBinding(frameLayout2, customCardView, imageView, textView, textView2, textView3, imageView2, imageView3, customCardView2, textView4, textView5, linearLayout, customCardView3, customCardView4, frameLayout, imageView4, imageView5, linearLayout2, textView6, textView7, frameLayout2, customCardView5, frameLayout3, linearLayout3, customCardView6, frameLayout4, linearLayout4, customCardView7, customCardView8, textView8, textView9, textView10, textView11, textView12, frameLayout5, frameLayout6);
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
