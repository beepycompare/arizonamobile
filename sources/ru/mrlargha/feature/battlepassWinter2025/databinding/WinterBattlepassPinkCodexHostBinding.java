package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassPinkCodexHostBinding implements ViewBinding {
    public final WinterBattlepassLayoutBinding battlepass;
    public final FrameLayout pinkCodexBattlepassHost;
    public final ImageView rodinaBackButton;
    public final CustomCardView rodinaBuyPremiumButton;
    public final TextView rodinaBuyPremiumText;
    public final CustomCardView rodinaCasesNavButton;
    public final ImageView rodinaCasesNavIcon;
    public final TextView rodinaCasesNavText;
    public final FrameLayout rodinaChrome;
    public final ImageView rodinaCurrencyAddButton;
    public final CustomCardView rodinaCurrencyContainer;
    public final TextView rodinaCurrencyText;
    public final CustomCardView rodinaCurrentPassLevelContainer;
    public final TextView rodinaCurrentPassLevelText;
    public final WinterBattlepassPinkLevelSummaryBinding rodinaMainLevelSummary;
    public final CustomCardView rodinaMainNavButton;
    public final ImageView rodinaMainNavIcon;
    public final TextView rodinaMainNavText;
    public final FrameLayout rodinaMainPageControls;
    public final LinearLayout rodinaMainSummaryContainer;
    public final LinearLayout rodinaNavigation;
    public final CustomCardView rodinaRemainingTimeContainer;
    public final TextView rodinaRemainingTimeText;
    public final CustomCardView rodinaTasksNavButton;
    public final ImageView rodinaTasksNavIcon;
    public final TextView rodinaTasksNavText;
    public final WinterBattlepassPinkTasksLayoutBinding rodinaTasksPage;
    private final FrameLayout rootView;

    private WinterBattlepassPinkCodexHostBinding(FrameLayout frameLayout, WinterBattlepassLayoutBinding winterBattlepassLayoutBinding, FrameLayout frameLayout2, ImageView imageView, CustomCardView customCardView, TextView textView, CustomCardView customCardView2, ImageView imageView2, TextView textView2, FrameLayout frameLayout3, ImageView imageView3, CustomCardView customCardView3, TextView textView3, CustomCardView customCardView4, TextView textView4, WinterBattlepassPinkLevelSummaryBinding winterBattlepassPinkLevelSummaryBinding, CustomCardView customCardView5, ImageView imageView4, TextView textView5, FrameLayout frameLayout4, LinearLayout linearLayout, LinearLayout linearLayout2, CustomCardView customCardView6, TextView textView6, CustomCardView customCardView7, ImageView imageView5, TextView textView7, WinterBattlepassPinkTasksLayoutBinding winterBattlepassPinkTasksLayoutBinding) {
        this.rootView = frameLayout;
        this.battlepass = winterBattlepassLayoutBinding;
        this.pinkCodexBattlepassHost = frameLayout2;
        this.rodinaBackButton = imageView;
        this.rodinaBuyPremiumButton = customCardView;
        this.rodinaBuyPremiumText = textView;
        this.rodinaCasesNavButton = customCardView2;
        this.rodinaCasesNavIcon = imageView2;
        this.rodinaCasesNavText = textView2;
        this.rodinaChrome = frameLayout3;
        this.rodinaCurrencyAddButton = imageView3;
        this.rodinaCurrencyContainer = customCardView3;
        this.rodinaCurrencyText = textView3;
        this.rodinaCurrentPassLevelContainer = customCardView4;
        this.rodinaCurrentPassLevelText = textView4;
        this.rodinaMainLevelSummary = winterBattlepassPinkLevelSummaryBinding;
        this.rodinaMainNavButton = customCardView5;
        this.rodinaMainNavIcon = imageView4;
        this.rodinaMainNavText = textView5;
        this.rodinaMainPageControls = frameLayout4;
        this.rodinaMainSummaryContainer = linearLayout;
        this.rodinaNavigation = linearLayout2;
        this.rodinaRemainingTimeContainer = customCardView6;
        this.rodinaRemainingTimeText = textView6;
        this.rodinaTasksNavButton = customCardView7;
        this.rodinaTasksNavIcon = imageView5;
        this.rodinaTasksNavText = textView7;
        this.rodinaTasksPage = winterBattlepassPinkTasksLayoutBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassPinkCodexHostBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassPinkCodexHostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_pink_codex_host, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassPinkCodexHostBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.battlepass;
        View findChildViewById3 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            WinterBattlepassLayoutBinding bind = WinterBattlepassLayoutBinding.bind(findChildViewById3);
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.rodina_back_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.rodina_buy_premium_button;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.rodina_buy_premium_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.rodina_cases_nav_button;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView2 != null) {
                            i = R.id.rodina_cases_nav_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.rodina_cases_nav_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.rodina_chrome;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout2 != null) {
                                        i = R.id.rodina_currency_add_button;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.rodina_currency_container;
                                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView3 != null) {
                                                i = R.id.rodina_currency_text;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.rodina_current_pass_level_container;
                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView4 != null) {
                                                        i = R.id.rodina_current_pass_level_text;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.rodina_main_level_summary))) != null) {
                                                            WinterBattlepassPinkLevelSummaryBinding bind2 = WinterBattlepassPinkLevelSummaryBinding.bind(findChildViewById);
                                                            i = R.id.rodina_main_nav_button;
                                                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                            if (customCardView5 != null) {
                                                                i = R.id.rodina_main_nav_icon;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView4 != null) {
                                                                    i = R.id.rodina_main_nav_text;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.rodina_main_page_controls;
                                                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (frameLayout3 != null) {
                                                                            i = R.id.rodina_main_summary_container;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout != null) {
                                                                                i = R.id.rodina_navigation;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout2 != null) {
                                                                                    i = R.id.rodina_remaining_time_container;
                                                                                    CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView6 != null) {
                                                                                        i = R.id.rodina_remaining_time_text;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.rodina_tasks_nav_button;
                                                                                            CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                            if (customCardView7 != null) {
                                                                                                i = R.id.rodina_tasks_nav_icon;
                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView5 != null) {
                                                                                                    i = R.id.rodina_tasks_nav_text;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.rodina_tasks_page))) != null) {
                                                                                                        return new WinterBattlepassPinkCodexHostBinding(frameLayout, bind, frameLayout, imageView, customCardView, textView, customCardView2, imageView2, textView2, frameLayout2, imageView3, customCardView3, textView3, customCardView4, textView4, bind2, customCardView5, imageView4, textView5, frameLayout3, linearLayout, linearLayout2, customCardView6, textView6, customCardView7, imageView5, textView7, WinterBattlepassPinkTasksLayoutBinding.bind(findChildViewById2));
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
