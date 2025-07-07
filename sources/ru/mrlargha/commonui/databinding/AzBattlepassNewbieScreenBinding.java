package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzBattlepassNewbieScreenBinding implements ViewBinding {
    public final ConstraintLayout adviceContainer;
    public final ConstraintLayout adviceMainContainer;
    public final TextView adviceText;
    public final TextView adviceTitle;
    public final TextView arzLogoText;
    public final TextView awardTitle;
    public final RecyclerView awardsRc;
    public final ImageView backButton;
    public final ConstraintLayout battlepassNewbie;
    public final Button claimAwardToInventoryButton;
    public final ConstraintLayout commonTaskPage;
    public final ConstraintLayout commonTasksNavMenuButton;
    public final TextView commonTasksNavMenuButtonText;
    public final RecyclerView commonTasksRc;
    public final TextView completeAll;
    public final ConstraintLayout completeAllContainer;
    public final TextView completeAllText;
    public final ImageView cubeIc;
    public final TextView level;
    public final ConstraintLayout levelContainer;
    public final TextView levelText;
    public final ConstraintLayout limitButton;
    public final ConstraintLayout mainNavMenuButton;
    public final TextView mainNavMenuButtonText;
    public final ConstraintLayout mainNavMenuContainer;
    public final ConstraintLayout mainNavMenuHeadersContainer;
    public final ConstraintLayout mainPage;
    public final ConstraintLayout passIc;
    public final AppCompatImageView receivedAward;
    private final ConstraintLayout rootView;
    public final Button sellAwardButton;
    public final ConstraintLayout showAward;
    public final TextView textView14;
    public final TextView todayComplete;
    public final ConstraintLayout todayCompleteContainer;
    public final TextView todayCompleteText;
    public final ImageView treasureIc;

    private AzBattlepassNewbieScreenBinding(ConstraintLayout rootView, ConstraintLayout adviceContainer, ConstraintLayout adviceMainContainer, TextView adviceText, TextView adviceTitle, TextView arzLogoText, TextView awardTitle, RecyclerView awardsRc, ImageView backButton, ConstraintLayout battlepassNewbie, Button claimAwardToInventoryButton, ConstraintLayout commonTaskPage, ConstraintLayout commonTasksNavMenuButton, TextView commonTasksNavMenuButtonText, RecyclerView commonTasksRc, TextView completeAll, ConstraintLayout completeAllContainer, TextView completeAllText, ImageView cubeIc, TextView level, ConstraintLayout levelContainer, TextView levelText, ConstraintLayout limitButton, ConstraintLayout mainNavMenuButton, TextView mainNavMenuButtonText, ConstraintLayout mainNavMenuContainer, ConstraintLayout mainNavMenuHeadersContainer, ConstraintLayout mainPage, ConstraintLayout passIc, AppCompatImageView receivedAward, Button sellAwardButton, ConstraintLayout showAward, TextView textView14, TextView todayComplete, ConstraintLayout todayCompleteContainer, TextView todayCompleteText, ImageView treasureIc) {
        this.rootView = rootView;
        this.adviceContainer = adviceContainer;
        this.adviceMainContainer = adviceMainContainer;
        this.adviceText = adviceText;
        this.adviceTitle = adviceTitle;
        this.arzLogoText = arzLogoText;
        this.awardTitle = awardTitle;
        this.awardsRc = awardsRc;
        this.backButton = backButton;
        this.battlepassNewbie = battlepassNewbie;
        this.claimAwardToInventoryButton = claimAwardToInventoryButton;
        this.commonTaskPage = commonTaskPage;
        this.commonTasksNavMenuButton = commonTasksNavMenuButton;
        this.commonTasksNavMenuButtonText = commonTasksNavMenuButtonText;
        this.commonTasksRc = commonTasksRc;
        this.completeAll = completeAll;
        this.completeAllContainer = completeAllContainer;
        this.completeAllText = completeAllText;
        this.cubeIc = cubeIc;
        this.level = level;
        this.levelContainer = levelContainer;
        this.levelText = levelText;
        this.limitButton = limitButton;
        this.mainNavMenuButton = mainNavMenuButton;
        this.mainNavMenuButtonText = mainNavMenuButtonText;
        this.mainNavMenuContainer = mainNavMenuContainer;
        this.mainNavMenuHeadersContainer = mainNavMenuHeadersContainer;
        this.mainPage = mainPage;
        this.passIc = passIc;
        this.receivedAward = receivedAward;
        this.sellAwardButton = sellAwardButton;
        this.showAward = showAward;
        this.textView14 = textView14;
        this.todayComplete = todayComplete;
        this.todayCompleteContainer = todayCompleteContainer;
        this.todayCompleteText = todayCompleteText;
        this.treasureIc = treasureIc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzBattlepassNewbieScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzBattlepassNewbieScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_battlepass_newbie_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzBattlepassNewbieScreenBinding bind(View rootView) {
        int i = R.id.advice_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.advice_main_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.advice_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.advice_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.arz_logo_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.award_title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.awards_rc;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.back_button;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView != null) {
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                        i = R.id.claim_award_to_inventory_button;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                                        if (button != null) {
                                            i = R.id.common_task_page;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.common_tasks_nav_menu_button;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.common_tasks_nav_menu_button_text;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.common_tasks_rc;
                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                        if (recyclerView2 != null) {
                                                            i = R.id.complete_all;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.complete_all_container;
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout6 != null) {
                                                                    i = R.id.complete_all_text;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.cube_ic;
                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (imageView2 != null) {
                                                                            i = R.id.level;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.level_container;
                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (constraintLayout7 != null) {
                                                                                    i = R.id.level_text;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.limit_button;
                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (constraintLayout8 != null) {
                                                                                            i = R.id.main_nav_menu_button;
                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (constraintLayout9 != null) {
                                                                                                i = R.id.main_nav_menu_button_text;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.main_nav_menu_container;
                                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (constraintLayout10 != null) {
                                                                                                        i = R.id.main_nav_menu_headers_container;
                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (constraintLayout11 != null) {
                                                                                                            i = R.id.main_page;
                                                                                                            ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (constraintLayout12 != null) {
                                                                                                                i = R.id.pass_ic;
                                                                                                                ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (constraintLayout13 != null) {
                                                                                                                    i = R.id.receivedAward;
                                                                                                                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (appCompatImageView != null) {
                                                                                                                        i = R.id.sell_award_button;
                                                                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (button2 != null) {
                                                                                                                            i = R.id.show_award;
                                                                                                                            ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (constraintLayout14 != null) {
                                                                                                                                i = R.id.textView14;
                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = R.id.today_complete;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = R.id.today_complete_container;
                                                                                                                                        ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (constraintLayout15 != null) {
                                                                                                                                            i = R.id.today_complete_text;
                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i = R.id.treasure_ic;
                                                                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (imageView3 != null) {
                                                                                                                                                    return new AzBattlepassNewbieScreenBinding(constraintLayout3, constraintLayout, constraintLayout2, textView, textView2, textView3, textView4, recyclerView, imageView, constraintLayout3, button, constraintLayout4, constraintLayout5, textView5, recyclerView2, textView6, constraintLayout6, textView7, imageView2, textView8, constraintLayout7, textView9, constraintLayout8, constraintLayout9, textView10, constraintLayout10, constraintLayout11, constraintLayout12, constraintLayout13, appCompatImageView, button2, constraintLayout14, textView11, textView12, constraintLayout15, textView13, imageView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
