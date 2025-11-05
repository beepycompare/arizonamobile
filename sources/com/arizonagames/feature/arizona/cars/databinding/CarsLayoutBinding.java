package com.arizonagames.feature.arizona.cars.databinding;

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
import com.arizonagames.feature.arizona.cars.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class CarsLayoutBinding implements ViewBinding {
    public final TextView bonusTitle;
    public final TextView carName;
    public final CustomCardView cardInfo;
    public final ConstraintLayout carsLayout;
    public final ImageView editBtn;
    public final ConstraintLayout mainPage;
    public final ImageView mainPageCarIc;
    public final RecyclerView mainPageCarsRc;
    public final ImageView mainPageExitButton;
    public final Guideline mainPageLeftLine;
    public final Guideline mainPageRightLine;
    public final Guideline mainPageTopLine;
    public final View overlay;
    public final CustomCardView ratingBnt;
    public final CustomCardView ratingBnt1;
    private final ConstraintLayout rootView;
    public final ConstraintLayout secondPage;
    public final ImageView secondPageBackButton;
    public final RecyclerView secondPageCarActionsRc;
    public final RecyclerView secondPageCarCircleInfoRc;
    public final ImageView secondPageCarIc;
    public final RecyclerView secondPageCarParamsRc;
    public final RecyclerView secondPageCarSwitchRc;
    public final RecyclerView secondPageCarTextInfoRc;
    public final ImageView secondPageExitButton;
    public final Guideline secondPageLeftLine;
    public final Guideline secondPageRightLine;
    public final Guideline secondPageTopLine;
    public final TextView slotsOccupied;
    public final TextView slotsOccupied1;
    public final TextView slotsOccupiedTitle;
    public final TextView textBonus;

    private CarsLayoutBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, CustomCardView customCardView, ConstraintLayout constraintLayout2, ImageView imageView, ConstraintLayout constraintLayout3, ImageView imageView2, RecyclerView recyclerView, ImageView imageView3, Guideline guideline, Guideline guideline2, Guideline guideline3, View view, CustomCardView customCardView2, CustomCardView customCardView3, ConstraintLayout constraintLayout4, ImageView imageView4, RecyclerView recyclerView2, RecyclerView recyclerView3, ImageView imageView5, RecyclerView recyclerView4, RecyclerView recyclerView5, RecyclerView recyclerView6, ImageView imageView6, Guideline guideline4, Guideline guideline5, Guideline guideline6, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.bonusTitle = textView;
        this.carName = textView2;
        this.cardInfo = customCardView;
        this.carsLayout = constraintLayout2;
        this.editBtn = imageView;
        this.mainPage = constraintLayout3;
        this.mainPageCarIc = imageView2;
        this.mainPageCarsRc = recyclerView;
        this.mainPageExitButton = imageView3;
        this.mainPageLeftLine = guideline;
        this.mainPageRightLine = guideline2;
        this.mainPageTopLine = guideline3;
        this.overlay = view;
        this.ratingBnt = customCardView2;
        this.ratingBnt1 = customCardView3;
        this.secondPage = constraintLayout4;
        this.secondPageBackButton = imageView4;
        this.secondPageCarActionsRc = recyclerView2;
        this.secondPageCarCircleInfoRc = recyclerView3;
        this.secondPageCarIc = imageView5;
        this.secondPageCarParamsRc = recyclerView4;
        this.secondPageCarSwitchRc = recyclerView5;
        this.secondPageCarTextInfoRc = recyclerView6;
        this.secondPageExitButton = imageView6;
        this.secondPageLeftLine = guideline4;
        this.secondPageRightLine = guideline5;
        this.secondPageTopLine = guideline6;
        this.slotsOccupied = textView3;
        this.slotsOccupied1 = textView4;
        this.slotsOccupiedTitle = textView5;
        this.textBonus = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CarsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CarsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cars_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CarsLayoutBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bonus_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.car_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.card_info;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.edit_btn;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.main_page;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.main_page_car_ic;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.main_page_cars_rc;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.main_page_exit_button;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.main_page_left_line;
                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline != null) {
                                            i = R.id.main_page_right_line;
                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline2 != null) {
                                                i = R.id.main_page_top_line;
                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                                    i = R.id.rating_bnt;
                                                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView2 != null) {
                                                        i = R.id.rating_bnt1;
                                                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView3 != null) {
                                                            i = R.id.second_page;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.second_page_back_button;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView4 != null) {
                                                                    i = R.id.second_page_car_actions_rc;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView2 != null) {
                                                                        i = R.id.second_page_car_circle_info_rc;
                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                        if (recyclerView3 != null) {
                                                                            i = R.id.second_page_car_ic;
                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView5 != null) {
                                                                                i = R.id.second_page_car_params_rc;
                                                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                if (recyclerView4 != null) {
                                                                                    i = R.id.second_page_car_switch_rc;
                                                                                    RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                    if (recyclerView5 != null) {
                                                                                        i = R.id.second_page_car_text_info_rc;
                                                                                        RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                        if (recyclerView6 != null) {
                                                                                            i = R.id.second_page_exit_button;
                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView6 != null) {
                                                                                                i = R.id.second_page_left_line;
                                                                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                if (guideline4 != null) {
                                                                                                    i = R.id.second_page_right_line;
                                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                    if (guideline5 != null) {
                                                                                                        i = R.id.second_page_top_line;
                                                                                                        Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline6 != null) {
                                                                                                            i = R.id.slots_occupied;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView3 != null) {
                                                                                                                i = R.id.slots_occupied1;
                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView4 != null) {
                                                                                                                    i = R.id.slots_occupied_title;
                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i = R.id.text_bonus;
                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView6 != null) {
                                                                                                                            return new CarsLayoutBinding(constraintLayout, textView, textView2, customCardView, constraintLayout, imageView, constraintLayout2, imageView2, recyclerView, imageView3, guideline, guideline2, guideline3, findChildViewById, customCardView2, customCardView3, constraintLayout3, imageView4, recyclerView2, recyclerView3, imageView5, recyclerView4, recyclerView5, recyclerView6, imageView6, guideline4, guideline5, guideline6, textView3, textView4, textView5, textView6);
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
