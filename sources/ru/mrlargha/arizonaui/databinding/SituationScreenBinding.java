package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class SituationScreenBinding implements ViewBinding {
    public final TextView actionButtonMoney;
    public final TextView actionButtonTitle;
    public final ImageView alertIc;
    public final ConstraintLayout alertPage;
    public final ConstraintLayout bonusContainer;
    public final TextView bonusPart;
    public final ConstraintLayout chooseRolePage;
    public final ImageView chooseRolePageBackButton;
    public final ImageView chooseRolePageExitButton;
    public final Guideline chooseRolePageLeftLine;
    public final Guideline chooseRolePageRightLine;
    public final TextView chooseRolePageTitle;
    public final Guideline chooseRolePageTopLine;
    public final ImageView dollarIc;
    public final TextView firstPart;
    public final ConstraintLayout lastPage;
    public final ImageView lastPageExitButton;
    public final Guideline lastPageRightLine;
    public final ConstraintLayout lastPageSuccessContainer;
    public final ImageView lastPageSuccessIc;
    public final ConstraintLayout lastPageTitleContainer;
    public final Guideline lastPageTopLine;
    public final RecyclerView listAwardsPremium;
    public final ConstraintLayout mainPageActionButton;
    public final Guideline mainPageCenterLine;
    public final ConstraintLayout mainPageCloseButton;
    public final TextView mainPageDescription;
    public final ConstraintLayout mainPageDescriptionContainer;
    public final TextView mainPageTitle;
    public final Guideline mainPageTopLine;
    public final ConstraintLayout moreInfoButton;
    public final ImageView moreInfoButtonIc;
    public final TextView moreInfoButtonText;
    private final ConstraintLayout rootView;
    public final TextView secondPart;
    public final ConstraintLayout situation;
    public final RecyclerView situationRc;
    public final ConstraintLayout statContainer;
    public final RecyclerView statsRc;
    public final ConstraintLayout successRolePage;
    public final TextView successRolePageDescription;
    public final ConstraintLayout successRolePageDescriptionContainer;
    public final ImageView successRolePageExitButton;
    public final Guideline successRolePageLeftLine;
    public final Guideline successRolePageRightLine;
    public final TextView successRolePageRole;
    public final TextView successRolePageTitle;
    public final ConstraintLayout successRolePageTitleContainer;
    public final Guideline successRolePageTopLine;
    public final ImageView upIc;

    private SituationScreenBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView3, ConstraintLayout constraintLayout4, ImageView imageView2, ImageView imageView3, Guideline guideline, Guideline guideline2, TextView textView4, Guideline guideline3, ImageView imageView4, TextView textView5, ConstraintLayout constraintLayout5, ImageView imageView5, Guideline guideline4, ConstraintLayout constraintLayout6, ImageView imageView6, ConstraintLayout constraintLayout7, Guideline guideline5, RecyclerView recyclerView, ConstraintLayout constraintLayout8, Guideline guideline6, ConstraintLayout constraintLayout9, TextView textView6, ConstraintLayout constraintLayout10, TextView textView7, Guideline guideline7, ConstraintLayout constraintLayout11, ImageView imageView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout12, RecyclerView recyclerView2, ConstraintLayout constraintLayout13, RecyclerView recyclerView3, ConstraintLayout constraintLayout14, TextView textView10, ConstraintLayout constraintLayout15, ImageView imageView8, Guideline guideline8, Guideline guideline9, TextView textView11, TextView textView12, ConstraintLayout constraintLayout16, Guideline guideline10, ImageView imageView9) {
        this.rootView = constraintLayout;
        this.actionButtonMoney = textView;
        this.actionButtonTitle = textView2;
        this.alertIc = imageView;
        this.alertPage = constraintLayout2;
        this.bonusContainer = constraintLayout3;
        this.bonusPart = textView3;
        this.chooseRolePage = constraintLayout4;
        this.chooseRolePageBackButton = imageView2;
        this.chooseRolePageExitButton = imageView3;
        this.chooseRolePageLeftLine = guideline;
        this.chooseRolePageRightLine = guideline2;
        this.chooseRolePageTitle = textView4;
        this.chooseRolePageTopLine = guideline3;
        this.dollarIc = imageView4;
        this.firstPart = textView5;
        this.lastPage = constraintLayout5;
        this.lastPageExitButton = imageView5;
        this.lastPageRightLine = guideline4;
        this.lastPageSuccessContainer = constraintLayout6;
        this.lastPageSuccessIc = imageView6;
        this.lastPageTitleContainer = constraintLayout7;
        this.lastPageTopLine = guideline5;
        this.listAwardsPremium = recyclerView;
        this.mainPageActionButton = constraintLayout8;
        this.mainPageCenterLine = guideline6;
        this.mainPageCloseButton = constraintLayout9;
        this.mainPageDescription = textView6;
        this.mainPageDescriptionContainer = constraintLayout10;
        this.mainPageTitle = textView7;
        this.mainPageTopLine = guideline7;
        this.moreInfoButton = constraintLayout11;
        this.moreInfoButtonIc = imageView7;
        this.moreInfoButtonText = textView8;
        this.secondPart = textView9;
        this.situation = constraintLayout12;
        this.situationRc = recyclerView2;
        this.statContainer = constraintLayout13;
        this.statsRc = recyclerView3;
        this.successRolePage = constraintLayout14;
        this.successRolePageDescription = textView10;
        this.successRolePageDescriptionContainer = constraintLayout15;
        this.successRolePageExitButton = imageView8;
        this.successRolePageLeftLine = guideline8;
        this.successRolePageRightLine = guideline9;
        this.successRolePageRole = textView11;
        this.successRolePageTitle = textView12;
        this.successRolePageTitleContainer = constraintLayout16;
        this.successRolePageTopLine = guideline10;
        this.upIc = imageView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SituationScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SituationScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.situation_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SituationScreenBinding bind(View view) {
        int i = R.id.action_button_money;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.action_button_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.alert_ic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.alert_page;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.bonus_container;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.bonus_part;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.choose_role_page;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.choose_role_page_back_button;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.choose_role_page_exit_button;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.choose_role_page_left_line;
                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline != null) {
                                                i = R.id.choose_role_page_right_line;
                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline2 != null) {
                                                    i = R.id.choose_role_page_title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.choose_role_page_top_line;
                                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline3 != null) {
                                                            i = R.id.dollar_ic;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView4 != null) {
                                                                i = R.id.first_part;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.last_page;
                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout4 != null) {
                                                                        i = R.id.last_page_exit_button;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.last_page_right_line;
                                                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline4 != null) {
                                                                                i = R.id.last_page_success_container;
                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout5 != null) {
                                                                                    i = R.id.last_page_success_ic;
                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView6 != null) {
                                                                                        i = R.id.last_page_title_container;
                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout6 != null) {
                                                                                            i = R.id.last_page_top_line;
                                                                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                            if (guideline5 != null) {
                                                                                                i = R.id.list_awards_premium;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                if (recyclerView != null) {
                                                                                                    i = R.id.main_page_action_button;
                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout7 != null) {
                                                                                                        i = R.id.main_page_center_line;
                                                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline6 != null) {
                                                                                                            i = R.id.main_page_close_button;
                                                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout8 != null) {
                                                                                                                i = R.id.main_page_description;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.main_page_description_container;
                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout9 != null) {
                                                                                                                        i = R.id.main_page_title;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i = R.id.main_page_top_line;
                                                                                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (guideline7 != null) {
                                                                                                                                i = R.id.more_info_button;
                                                                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (constraintLayout10 != null) {
                                                                                                                                    i = R.id.more_info_button_ic;
                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (imageView7 != null) {
                                                                                                                                        i = R.id.more_info_button_text;
                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView8 != null) {
                                                                                                                                            i = R.id.second_part;
                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView9 != null) {
                                                                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) view;
                                                                                                                                                i = R.id.situation_rc;
                                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                    i = R.id.stat_container;
                                                                                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (constraintLayout12 != null) {
                                                                                                                                                        i = R.id.stats_rc;
                                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                                            i = R.id.success_role_page;
                                                                                                                                                            ConstraintLayout constraintLayout13 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (constraintLayout13 != null) {
                                                                                                                                                                i = R.id.success_role_page_description;
                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                    i = R.id.success_role_page_description_container;
                                                                                                                                                                    ConstraintLayout constraintLayout14 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (constraintLayout14 != null) {
                                                                                                                                                                        i = R.id.success_role_page_exit_button;
                                                                                                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (imageView8 != null) {
                                                                                                                                                                            i = R.id.success_role_page_left_line;
                                                                                                                                                                            Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (guideline8 != null) {
                                                                                                                                                                                i = R.id.success_role_page_right_line;
                                                                                                                                                                                Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (guideline9 != null) {
                                                                                                                                                                                    i = R.id.success_role_page_role;
                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                        i = R.id.success_role_page_title;
                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                            i = R.id.success_role_page_title_container;
                                                                                                                                                                                            ConstraintLayout constraintLayout15 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (constraintLayout15 != null) {
                                                                                                                                                                                                i = R.id.success_role_page_top_line;
                                                                                                                                                                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (guideline10 != null) {
                                                                                                                                                                                                    i = R.id.up_ic;
                                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                                        return new SituationScreenBinding(constraintLayout11, textView, textView2, imageView, constraintLayout, constraintLayout2, textView3, constraintLayout3, imageView2, imageView3, guideline, guideline2, textView4, guideline3, imageView4, textView5, constraintLayout4, imageView5, guideline4, constraintLayout5, imageView6, constraintLayout6, guideline5, recyclerView, constraintLayout7, guideline6, constraintLayout8, textView6, constraintLayout9, textView7, guideline7, constraintLayout10, imageView7, textView8, textView9, constraintLayout11, recyclerView2, constraintLayout12, recyclerView3, constraintLayout13, textView10, constraintLayout14, imageView8, guideline8, guideline9, textView11, textView12, constraintLayout15, guideline10, imageView9);
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
