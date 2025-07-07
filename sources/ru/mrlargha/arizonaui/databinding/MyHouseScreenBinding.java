package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyHouseScreenBinding implements ViewBinding {
    public final ImageView backButton;
    public final TextView bizId;
    public final LinearLayout bizStatus;
    public final TextView controlPanelTitle;
    public final ImageView exitButton;
    public final ConstraintLayout houseIcContainer;
    public final RecyclerView houseMainStatRc;
    public final TextView houseName;
    public final ImageView houseTypeIc;
    public final ImageView housesNoTenantsIc;
    public final RecyclerView housesRc;
    public final TextView idTitle;
    public final ConstraintLayout infoPage;
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
    public final ConstraintLayout myHouse;
    public final RecyclerView parentStatRc;
    private final ConstraintLayout rootView;
    public final Switch switchBiz;
    public final ConstraintLayout tenantsContainer;
    public final TextView tenantsCount;
    public final RecyclerView tenantsRc;
    public final TextView tenantsTitle;
    public final TextView tvBiz;
    public final ConstraintLayout upgradesContainer;
    public final RecyclerView upgradesRc;
    public final TextView upgradesTitle;

    private MyHouseScreenBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView3, ImageView imageView3, ImageView imageView4, RecyclerView recyclerView2, TextView textView4, ConstraintLayout constraintLayout3, Guideline guideline, ConstraintLayout constraintLayout4, Guideline guideline2, ImageView imageView5, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, ImageView imageView6, RecyclerView recyclerView3, Guideline guideline8, ConstraintLayout constraintLayout5, RecyclerView recyclerView4, Switch r29, ConstraintLayout constraintLayout6, TextView textView5, RecyclerView recyclerView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout7, RecyclerView recyclerView6, TextView textView8) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.bizId = textView;
        this.bizStatus = linearLayout;
        this.controlPanelTitle = textView2;
        this.exitButton = imageView2;
        this.houseIcContainer = constraintLayout2;
        this.houseMainStatRc = recyclerView;
        this.houseName = textView3;
        this.houseTypeIc = imageView3;
        this.housesNoTenantsIc = imageView4;
        this.housesRc = recyclerView2;
        this.idTitle = textView4;
        this.infoPage = constraintLayout3;
        this.mainInfoLeftLine = guideline;
        this.mainPage = constraintLayout4;
        this.mainPageLeftLineRc = guideline2;
        this.mainPageLogo = imageView5;
        this.mainPageLogoTopLine = guideline3;
        this.mainPageRightLineRc = guideline4;
        this.mainPageTopLineRc = guideline5;
        this.menuLeftLine = guideline6;
        this.menuLine = guideline7;
        this.menuLogo = imageView6;
        this.menuRc = recyclerView3;
        this.menuRightLine = guideline8;
        this.myHouse = constraintLayout5;
        this.parentStatRc = recyclerView4;
        this.switchBiz = r29;
        this.tenantsContainer = constraintLayout6;
        this.tenantsCount = textView5;
        this.tenantsRc = recyclerView5;
        this.tenantsTitle = textView6;
        this.tvBiz = textView7;
        this.upgradesContainer = constraintLayout7;
        this.upgradesRc = recyclerView6;
        this.upgradesTitle = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyHouseScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyHouseScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_house_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyHouseScreenBinding bind(View view) {
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.biz_id;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.biz_status;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.control_panel_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.exit_button;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.house_ic_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.house_main_stat_rc;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.house_name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.house_type_ic;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.houses_no_tenants_ic;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.houses_rc;
                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView2 != null) {
                                                    i = R.id.id_title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.info_page;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout2 != null) {
                                                            i = R.id.main_info_left_line;
                                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline != null) {
                                                                i = R.id.main_page;
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout3 != null) {
                                                                    i = R.id.main_page_left_line_rc;
                                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline2 != null) {
                                                                        i = R.id.main_page_logo;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.main_page_logo_top_line;
                                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline3 != null) {
                                                                                i = R.id.main_page_right_line_rc;
                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                if (guideline4 != null) {
                                                                                    i = R.id.main_page_top_line_rc;
                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                    if (guideline5 != null) {
                                                                                        i = R.id.menu_left_line;
                                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                        if (guideline6 != null) {
                                                                                            i = R.id.menu_line;
                                                                                            Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                            if (guideline7 != null) {
                                                                                                i = R.id.menu_logo;
                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView6 != null) {
                                                                                                    i = R.id.menu_rc;
                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (recyclerView3 != null) {
                                                                                                        i = R.id.menu_right_line;
                                                                                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline8 != null) {
                                                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                                                                            i = R.id.parent_stat_rc;
                                                                                                            RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (recyclerView4 != null) {
                                                                                                                i = R.id.switch_biz;
                                                                                                                Switch r32 = (Switch) ViewBindings.findChildViewById(view, i);
                                                                                                                if (r32 != null) {
                                                                                                                    i = R.id.tenants_container;
                                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout5 != null) {
                                                                                                                        i = R.id.tenants_count;
                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView5 != null) {
                                                                                                                            i = R.id.tenants_rc;
                                                                                                                            RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (recyclerView5 != null) {
                                                                                                                                i = R.id.tenants_title;
                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView6 != null) {
                                                                                                                                    i = R.id.tv_biz;
                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView7 != null) {
                                                                                                                                        i = R.id.upgrades_container;
                                                                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout6 != null) {
                                                                                                                                            i = R.id.upgrades_rc;
                                                                                                                                            RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (recyclerView6 != null) {
                                                                                                                                                i = R.id.upgrades_title;
                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView8 != null) {
                                                                                                                                                    return new MyHouseScreenBinding(constraintLayout4, imageView, textView, linearLayout, textView2, imageView2, constraintLayout, recyclerView, textView3, imageView3, imageView4, recyclerView2, textView4, constraintLayout2, guideline, constraintLayout3, guideline2, imageView5, guideline3, guideline4, guideline5, guideline6, guideline7, imageView6, recyclerView3, guideline8, constraintLayout4, recyclerView4, r32, constraintLayout5, textView5, recyclerView5, textView6, textView7, constraintLayout6, recyclerView6, textView8);
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
