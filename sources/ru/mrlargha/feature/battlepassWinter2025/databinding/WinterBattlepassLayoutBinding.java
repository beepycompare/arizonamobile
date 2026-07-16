package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassLayoutBinding implements ViewBinding {
    public final ImageView backButton;
    public final ConstraintLayout battlePassMainPageContainer;
    public final ConstraintLayout battlepass;
    public final ConstraintLayout battlepass2023Container;
    public final ImageView battlepassContainerBg;
    public final WinterBattlepassConvertBattlecoinsLayoutBinding battlepassConvertBattlecoinsPage;
    public final WinterBattlepassBuyPremiumLayoutBinding battlepassLevelPremiumPage;
    public final WinterBattlepassLevelSetsLayoutBinding battlepassLevelSetsPage;
    public final WinterBattlepassLevelSetsLayoutMaximumBinding battlepassLevelSetsPageMaximum;
    public final WinterBattlepassRouletteLayoutBinding battlepassRoulettePage;
    public final WinterBattlepassRouletteMainScreenBinding battlepassRouletteView;
    public final WinterBattlepassTasksLayoutBinding battlepassTasksPage;
    public final LinearLayout bpLevel;
    public final CustomCardView btnPremium;
    public final CustomCardView btnUsually;
    public final LinearLayout buttonBuyAzCoins;
    public final LinearLayout buttonBuyBattlePoints;
    public final LinearLayout buyContainer;
    public final ImageView buyLevelsBtn;
    public final CustomCardView buyPremiumBtn;
    public final TextView buyPremiumText;
    public final CustomCardView cardInfo;
    public final LinearLayout casesNavMenuButton;
    public final ImageView casesNavMenuButtonIcon;
    public final TextView casesNavMenuButtonText;
    public final View clickBlocker;
    public final LinearLayout donateNavMenuButton;
    public final ImageView donateNavMenuButtonIcon;
    public final TextView donateNavMenuButtonText;
    public final LinearLayout infoNavMenuButton;
    public final ImageView infoNavMenuButtonIcon;
    public final TextView infoNavMenuButtonText;
    public final LinearLayout levelContainer;
    public final RecyclerView levelItemsRc;
    public final TextView levelPassText;
    public final ImageView logo;
    public final TextView mainExperienceText;
    public final LinearLayout mainNavMenuButton;
    public final ImageView mainNavMenuButtonIcon;
    public final TextView mainNavMenuButtonText;
    public final LinearLayout mainNavMenuContainer;
    public final LinearLayout mainNavMenuHeadersContainer;
    public final TextView mainPageTitle;
    public final View overlay;
    public final LinearProgressIndicator progressExperience;
    public final LinearLayout remainingTime;
    public final TextView remainingTimeTextMain;
    private final ConstraintLayout rootView;
    public final LinearLayout rouletteNavMenuButton;
    public final ImageView rouletteNavMenuButtonIcon;
    public final TextView rouletteNavMenuButtonText;
    public final BpSeasonEndedBinding seasonEnded;
    public final LinearLayout shopNavMenuButton;
    public final ImageView shopNavMenuButtonIcon;
    public final TextView shopNavMenuButtonText;
    public final LinearLayout tasksNavMenuButton;
    public final ImageView tasksNavMenuButtonIcon;
    public final TextView tasksNavMenuButtonText;
    public final TextView textBonus;
    public final TextView textBuyAzCoins;
    public final TextView textBuyBattlePoints;
    public final TextView tvBpLevel;
    public final WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcome;

    private WinterBattlepassLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView2, WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding, WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding, WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding, WinterBattlepassLevelSetsLayoutMaximumBinding winterBattlepassLevelSetsLayoutMaximumBinding, WinterBattlepassRouletteLayoutBinding winterBattlepassRouletteLayoutBinding, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding, LinearLayout linearLayout, CustomCardView customCardView, CustomCardView customCardView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView3, CustomCardView customCardView3, TextView textView, CustomCardView customCardView4, LinearLayout linearLayout5, ImageView imageView4, TextView textView2, View view, LinearLayout linearLayout6, ImageView imageView5, TextView textView3, LinearLayout linearLayout7, ImageView imageView6, TextView textView4, LinearLayout linearLayout8, RecyclerView recyclerView, TextView textView5, ImageView imageView7, TextView textView6, LinearLayout linearLayout9, ImageView imageView8, TextView textView7, LinearLayout linearLayout10, LinearLayout linearLayout11, TextView textView8, View view2, LinearProgressIndicator linearProgressIndicator, LinearLayout linearLayout12, TextView textView9, LinearLayout linearLayout13, ImageView imageView9, TextView textView10, BpSeasonEndedBinding bpSeasonEndedBinding, LinearLayout linearLayout14, ImageView imageView10, TextView textView11, LinearLayout linearLayout15, ImageView imageView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.battlePassMainPageContainer = constraintLayout2;
        this.battlepass = constraintLayout3;
        this.battlepass2023Container = constraintLayout4;
        this.battlepassContainerBg = imageView2;
        this.battlepassConvertBattlecoinsPage = winterBattlepassConvertBattlecoinsLayoutBinding;
        this.battlepassLevelPremiumPage = winterBattlepassBuyPremiumLayoutBinding;
        this.battlepassLevelSetsPage = winterBattlepassLevelSetsLayoutBinding;
        this.battlepassLevelSetsPageMaximum = winterBattlepassLevelSetsLayoutMaximumBinding;
        this.battlepassRoulettePage = winterBattlepassRouletteLayoutBinding;
        this.battlepassRouletteView = winterBattlepassRouletteMainScreenBinding;
        this.battlepassTasksPage = winterBattlepassTasksLayoutBinding;
        this.bpLevel = linearLayout;
        this.btnPremium = customCardView;
        this.btnUsually = customCardView2;
        this.buttonBuyAzCoins = linearLayout2;
        this.buttonBuyBattlePoints = linearLayout3;
        this.buyContainer = linearLayout4;
        this.buyLevelsBtn = imageView3;
        this.buyPremiumBtn = customCardView3;
        this.buyPremiumText = textView;
        this.cardInfo = customCardView4;
        this.casesNavMenuButton = linearLayout5;
        this.casesNavMenuButtonIcon = imageView4;
        this.casesNavMenuButtonText = textView2;
        this.clickBlocker = view;
        this.donateNavMenuButton = linearLayout6;
        this.donateNavMenuButtonIcon = imageView5;
        this.donateNavMenuButtonText = textView3;
        this.infoNavMenuButton = linearLayout7;
        this.infoNavMenuButtonIcon = imageView6;
        this.infoNavMenuButtonText = textView4;
        this.levelContainer = linearLayout8;
        this.levelItemsRc = recyclerView;
        this.levelPassText = textView5;
        this.logo = imageView7;
        this.mainExperienceText = textView6;
        this.mainNavMenuButton = linearLayout9;
        this.mainNavMenuButtonIcon = imageView8;
        this.mainNavMenuButtonText = textView7;
        this.mainNavMenuContainer = linearLayout10;
        this.mainNavMenuHeadersContainer = linearLayout11;
        this.mainPageTitle = textView8;
        this.overlay = view2;
        this.progressExperience = linearProgressIndicator;
        this.remainingTime = linearLayout12;
        this.remainingTimeTextMain = textView9;
        this.rouletteNavMenuButton = linearLayout13;
        this.rouletteNavMenuButtonIcon = imageView9;
        this.rouletteNavMenuButtonText = textView10;
        this.seasonEnded = bpSeasonEndedBinding;
        this.shopNavMenuButton = linearLayout14;
        this.shopNavMenuButtonIcon = imageView10;
        this.shopNavMenuButtonText = textView11;
        this.tasksNavMenuButton = linearLayout15;
        this.tasksNavMenuButtonIcon = imageView11;
        this.tasksNavMenuButtonText = textView12;
        this.textBonus = textView13;
        this.textBuyAzCoins = textView14;
        this.textBuyBattlePoints = textView15;
        this.tvBpLevel = textView16;
        this.winterBattlepassWelcome = winterBattlepassWelcomeLayoutBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLayoutBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.battle_pass_main_page_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.battlepass_2023_container;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout3 != null) {
                    i = R.id.battlepass_container_bg;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.battlepass_convert_battlecoins_page))) != null) {
                        WinterBattlepassConvertBattlecoinsLayoutBinding bind = WinterBattlepassConvertBattlecoinsLayoutBinding.bind(findChildViewById);
                        i = R.id.battlepass_level_premium_page;
                        View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById6 != null) {
                            WinterBattlepassBuyPremiumLayoutBinding bind2 = WinterBattlepassBuyPremiumLayoutBinding.bind(findChildViewById6);
                            i = R.id.battlepass_level_sets_page;
                            View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById7 != null) {
                                WinterBattlepassLevelSetsLayoutBinding bind3 = WinterBattlepassLevelSetsLayoutBinding.bind(findChildViewById7);
                                i = R.id.battlepass_level_sets_page_maximum;
                                View findChildViewById8 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById8 != null) {
                                    WinterBattlepassLevelSetsLayoutMaximumBinding bind4 = WinterBattlepassLevelSetsLayoutMaximumBinding.bind(findChildViewById8);
                                    i = R.id.battlepass_roulette_page;
                                    View findChildViewById9 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById9 != null) {
                                        WinterBattlepassRouletteLayoutBinding bind5 = WinterBattlepassRouletteLayoutBinding.bind(findChildViewById9);
                                        i = R.id.battlepass_roulette_view;
                                        View findChildViewById10 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById10 != null) {
                                            WinterBattlepassRouletteMainScreenBinding bind6 = WinterBattlepassRouletteMainScreenBinding.bind(findChildViewById10);
                                            i = R.id.battlepass_tasks_page;
                                            View findChildViewById11 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById11 != null) {
                                                WinterBattlepassTasksLayoutBinding bind7 = WinterBattlepassTasksLayoutBinding.bind(findChildViewById11);
                                                i = R.id.bp_level;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.btn_premium;
                                                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView != null) {
                                                        i = R.id.btn_usually;
                                                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView2 != null) {
                                                            i = R.id.button_buy_az_coins;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.button_buy_battle_points;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.buy_container;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.buy_levels_btn;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.buy_premium_btn;
                                                                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView3 != null) {
                                                                                i = R.id.buy_premium_text;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.card_info;
                                                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView4 != null) {
                                                                                        i = R.id.cases_nav_menu_button;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.cases_nav_menu_button_icon;
                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView4 != null) {
                                                                                                i = R.id.cases_nav_menu_button_text;
                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.clickBlocker))) != null) {
                                                                                                    i = R.id.donate_nav_menu_button;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.donate_nav_menu_button_icon;
                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView5 != null) {
                                                                                                            i = R.id.donate_nav_menu_button_text;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView3 != null) {
                                                                                                                i = R.id.info_nav_menu_button;
                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout7 != null) {
                                                                                                                    i = R.id.info_nav_menu_button_icon;
                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (imageView6 != null) {
                                                                                                                        i = R.id.info_nav_menu_button_text;
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView4 != null) {
                                                                                                                            i = R.id.level_container;
                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                i = R.id.level_items_rc;
                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (recyclerView != null) {
                                                                                                                                    i = R.id.level_pass_text;
                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        i = R.id.logo;
                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (imageView7 != null) {
                                                                                                                                            i = R.id.main_experience_text;
                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                i = R.id.main_nav_menu_button;
                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                    i = R.id.main_nav_menu_button_icon;
                                                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (imageView8 != null) {
                                                                                                                                                        i = R.id.main_nav_menu_button_text;
                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                            i = R.id.main_nav_menu_container;
                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                i = R.id.main_nav_menu_headers_container;
                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                    i = R.id.main_page_title;
                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView8 != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                                                                                                                                                        i = R.id.progress_experience;
                                                                                                                                                                        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (linearProgressIndicator != null) {
                                                                                                                                                                            i = R.id.remaining_time;
                                                                                                                                                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (linearLayout12 != null) {
                                                                                                                                                                                i = R.id.remaining_time_text_main;
                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                    i = R.id.roulette_nav_menu_button;
                                                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (linearLayout13 != null) {
                                                                                                                                                                                        i = R.id.roulette_nav_menu_button_icon;
                                                                                                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (imageView9 != null) {
                                                                                                                                                                                            i = R.id.roulette_nav_menu_button_text;
                                                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView10 != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.season_ended))) != null) {
                                                                                                                                                                                                BpSeasonEndedBinding bind8 = BpSeasonEndedBinding.bind(findChildViewById4);
                                                                                                                                                                                                i = R.id.shop_nav_menu_button;
                                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                                    i = R.id.shop_nav_menu_button_icon;
                                                                                                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (imageView10 != null) {
                                                                                                                                                                                                        i = R.id.shop_nav_menu_button_text;
                                                                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                                                            i = R.id.tasks_nav_menu_button;
                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                i = R.id.tasks_nav_menu_button_icon;
                                                                                                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (imageView11 != null) {
                                                                                                                                                                                                                    i = R.id.tasks_nav_menu_button_text;
                                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                                        i = R.id.text_bonus;
                                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                            i = R.id.text_buy_az_coins;
                                                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                                                i = R.id.text_buy_battle_points;
                                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                                    i = R.id.tv_bp_level;
                                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView16 != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.winter_battlepass_welcome))) != null) {
                                                                                                                                                                                                                                        return new WinterBattlepassLayoutBinding(constraintLayout2, imageView, constraintLayout, constraintLayout2, constraintLayout3, imageView2, bind, bind2, bind3, bind4, bind5, bind6, bind7, linearLayout, customCardView, customCardView2, linearLayout2, linearLayout3, linearLayout4, imageView3, customCardView3, textView, customCardView4, linearLayout5, imageView4, textView2, findChildViewById2, linearLayout6, imageView5, textView3, linearLayout7, imageView6, textView4, linearLayout8, recyclerView, textView5, imageView7, textView6, linearLayout9, imageView8, textView7, linearLayout10, linearLayout11, textView8, findChildViewById3, linearProgressIndicator, linearLayout12, textView9, linearLayout13, imageView9, textView10, bind8, linearLayout14, imageView10, textView11, linearLayout15, imageView11, textView12, textView13, textView14, textView15, textView16, WinterBattlepassWelcomeLayoutBinding.bind(findChildViewById5));
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
