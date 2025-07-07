package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyHousesItemBinding implements ViewBinding {
    public final Guideline bizInfoLeftLine;
    public final Guideline centerHorizontalLine;
    public final TextView distance;
    public final LinearLayout distanceContainer;
    public final TextView firstTitle;
    public final TextView firstValue;
    public final TextView fourthTitle;
    public final TextView fourthValue;
    public final Guideline fourthValueLeftLine;
    public final ConstraintLayout houseIcContainer;
    public final ConstraintLayout houseIcNStatusContainer;
    public final TextView houseName;
    public final TextView houseNumber;
    public final TextView houseStatus;
    public final ConstraintLayout houseStatusContainer;
    public final ImageView houseTypeIc;
    public final Guideline mainLeftLine;
    public final ConstraintLayout myHousesItem;
    private final ConstraintLayout rootView;
    public final TextView secondTitle;
    public final TextView secondValue;
    public final Guideline secondValueLeftLine;
    public final TextView thirdTitle;
    public final TextView thirdValue;
    public final Guideline thirdValueLeftLine;

    private MyHousesItemBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Guideline guideline3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout4, ImageView imageView, Guideline guideline4, ConstraintLayout constraintLayout5, TextView textView9, TextView textView10, Guideline guideline5, TextView textView11, TextView textView12, Guideline guideline6) {
        this.rootView = constraintLayout;
        this.bizInfoLeftLine = guideline;
        this.centerHorizontalLine = guideline2;
        this.distance = textView;
        this.distanceContainer = linearLayout;
        this.firstTitle = textView2;
        this.firstValue = textView3;
        this.fourthTitle = textView4;
        this.fourthValue = textView5;
        this.fourthValueLeftLine = guideline3;
        this.houseIcContainer = constraintLayout2;
        this.houseIcNStatusContainer = constraintLayout3;
        this.houseName = textView6;
        this.houseNumber = textView7;
        this.houseStatus = textView8;
        this.houseStatusContainer = constraintLayout4;
        this.houseTypeIc = imageView;
        this.mainLeftLine = guideline4;
        this.myHousesItem = constraintLayout5;
        this.secondTitle = textView9;
        this.secondValue = textView10;
        this.secondValueLeftLine = guideline5;
        this.thirdTitle = textView11;
        this.thirdValue = textView12;
        this.thirdValueLeftLine = guideline6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyHousesItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyHousesItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_houses_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyHousesItemBinding bind(View view) {
        int i = R.id.biz_info_left_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.center_horizontal_line;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.distance;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.distance_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.first_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.first_value;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.fourth_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.fourth_value;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.fourth_value_left_line;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline3 != null) {
                                            i = R.id.house_ic_container;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout != null) {
                                                i = R.id.house_ic_n_status_container;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.house_name;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.house_number;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.house_status;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.house_status_container;
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout3 != null) {
                                                                    i = R.id.house_type_ic;
                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView != null) {
                                                                        i = R.id.main_left_line;
                                                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline4 != null) {
                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                                            i = R.id.second_title;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.second_value;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.second_value_left_line;
                                                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                    if (guideline5 != null) {
                                                                                        i = R.id.third_title;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView11 != null) {
                                                                                            i = R.id.third_value;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.third_value_left_line;
                                                                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                if (guideline6 != null) {
                                                                                                    return new MyHousesItemBinding(constraintLayout4, guideline, guideline2, textView, linearLayout, textView2, textView3, textView4, textView5, guideline3, constraintLayout, constraintLayout2, textView6, textView7, textView8, constraintLayout3, imageView, guideline4, constraintLayout4, textView9, textView10, guideline5, textView11, textView12, guideline6);
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
