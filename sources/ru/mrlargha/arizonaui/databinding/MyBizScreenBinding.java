package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyBizScreenBinding implements ViewBinding {
    public final ImageView backButton;
    public final TextView balance;
    public final ConstraintLayout balanceContainer;
    public final TextView balanceCurrency;
    public final TextView balanceTitle;
    public final ConstraintLayout bizIcContainer;
    public final TextView bizId;
    public final TextView bizName;
    public final TextView bizStatus;
    public final ImageView bizTypeIc;
    public final RecyclerView businessMainStatRc;
    public final RecyclerView businessRc;
    public final TextView controlPanelTitle;
    public final ImageView exitButton;
    public final TextView idTitle;
    public final ConstraintLayout infoPage;
    public final Guideline leftLine;
    public final Guideline mainInfoLeftLine;
    public final ConstraintLayout mainPage;
    public final Guideline mainPageLeftLineRc;
    public final ImageView mainPageLogo;
    public final Guideline mainPageLogoTopLine;
    public final Guideline mainPageRightLineRc;
    public final Guideline mainPageTopLineRc;
    public final Guideline menuLeftLine;
    public final Guideline menuLine;
    public final ImageView menuLogo;
    public final RecyclerView menuRc;
    public final Guideline menuRightLine;
    public final ConstraintLayout myBiz;
    public final Switch openBizSwitch;
    public final RecyclerView parentStatRc;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topUpButton;
    public final ConstraintLayout topUpNWithdrawContainer;
    public final ConstraintLayout withdrawButton;

    private MyBizScreenBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView7, ImageView imageView3, TextView textView8, ConstraintLayout constraintLayout4, Guideline guideline, Guideline guideline2, ConstraintLayout constraintLayout5, Guideline guideline3, ImageView imageView4, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, ImageView imageView5, RecyclerView recyclerView3, Guideline guideline9, ConstraintLayout constraintLayout6, Switch r32, RecyclerView recyclerView4, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.balance = textView;
        this.balanceContainer = constraintLayout2;
        this.balanceCurrency = textView2;
        this.balanceTitle = textView3;
        this.bizIcContainer = constraintLayout3;
        this.bizId = textView4;
        this.bizName = textView5;
        this.bizStatus = textView6;
        this.bizTypeIc = imageView2;
        this.businessMainStatRc = recyclerView;
        this.businessRc = recyclerView2;
        this.controlPanelTitle = textView7;
        this.exitButton = imageView3;
        this.idTitle = textView8;
        this.infoPage = constraintLayout4;
        this.leftLine = guideline;
        this.mainInfoLeftLine = guideline2;
        this.mainPage = constraintLayout5;
        this.mainPageLeftLineRc = guideline3;
        this.mainPageLogo = imageView4;
        this.mainPageLogoTopLine = guideline4;
        this.mainPageRightLineRc = guideline5;
        this.mainPageTopLineRc = guideline6;
        this.menuLeftLine = guideline7;
        this.menuLine = guideline8;
        this.menuLogo = imageView5;
        this.menuRc = recyclerView3;
        this.menuRightLine = guideline9;
        this.myBiz = constraintLayout6;
        this.openBizSwitch = r32;
        this.parentStatRc = recyclerView4;
        this.topUpButton = constraintLayout7;
        this.topUpNWithdrawContainer = constraintLayout8;
        this.withdrawButton = constraintLayout9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyBizScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyBizScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_biz_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyBizScreenBinding bind(View view) {
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.balance;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.balance_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.balance_currency;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.balance_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.biz_ic_container;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.biz_id;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.biz_name;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.biz_status;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.biz_type_ic;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.business_main_stat_rc;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    i = R.id.business_rc;
                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                    if (recyclerView2 != null) {
                                                        i = R.id.control_panel_title;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.exit_button;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView3 != null) {
                                                                i = R.id.id_title;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.info_page;
                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout3 != null) {
                                                                        i = R.id.left_line;
                                                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline != null) {
                                                                            i = R.id.main_info_left_line;
                                                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline2 != null) {
                                                                                i = R.id.main_page;
                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout4 != null) {
                                                                                    i = R.id.main_page_left_line_rc;
                                                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                    if (guideline3 != null) {
                                                                                        i = R.id.main_page_logo;
                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView4 != null) {
                                                                                            i = R.id.main_page_logo_top_line;
                                                                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                            if (guideline4 != null) {
                                                                                                i = R.id.main_page_right_line_rc;
                                                                                                Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                if (guideline5 != null) {
                                                                                                    i = R.id.main_page_top_line_rc;
                                                                                                    Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                    if (guideline6 != null) {
                                                                                                        i = R.id.menu_left_line;
                                                                                                        Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline7 != null) {
                                                                                                            i = R.id.menu_line;
                                                                                                            Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                            if (guideline8 != null) {
                                                                                                                i = R.id.menu_logo;
                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (imageView5 != null) {
                                                                                                                    i = R.id.menu_rc;
                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (recyclerView3 != null) {
                                                                                                                        i = R.id.menu_right_line;
                                                                                                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (guideline9 != null) {
                                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                                                                                            i = R.id.open_biz_switch;
                                                                                                                            Switch r35 = (Switch) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (r35 != null) {
                                                                                                                                i = R.id.parent_stat_rc;
                                                                                                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (recyclerView4 != null) {
                                                                                                                                    i = R.id.top_up_button;
                                                                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout6 != null) {
                                                                                                                                        i = R.id.top_up_n_withdraw_container;
                                                                                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout7 != null) {
                                                                                                                                            i = R.id.withdraw_button;
                                                                                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (constraintLayout8 != null) {
                                                                                                                                                return new MyBizScreenBinding(constraintLayout5, imageView, textView, constraintLayout, textView2, textView3, constraintLayout2, textView4, textView5, textView6, imageView2, recyclerView, recyclerView2, textView7, imageView3, textView8, constraintLayout3, guideline, guideline2, constraintLayout4, guideline3, imageView4, guideline4, guideline5, guideline6, guideline7, guideline8, imageView5, recyclerView3, guideline9, constraintLayout5, r35, recyclerView4, constraintLayout6, constraintLayout7, constraintLayout8);
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
