package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyBusinessItemBinding implements ViewBinding {
    public final ConstraintLayout bizIcContainer;
    public final ConstraintLayout bizIcNStatusContainer;
    public final Guideline bizInfoLeftLine;
    public final TextView bizName;
    public final TextView bizNumber;
    public final TextView bizStatus;
    public final ConstraintLayout bizStatusContainer;
    public final ImageView bizTypeIc;
    public final Guideline centerHorizontalLine;
    public final ImageView firstIc;
    public final TextView firstTitle;
    public final TextView firstValue;
    public final Guideline mainLeftLine;
    public final ConstraintLayout myBusinessItem;
    private final ConstraintLayout rootView;
    public final ImageView secondIc;
    public final TextView secondTitle;
    public final TextView secondValue;
    public final Guideline secondValueLeftLine;
    public final ImageView thirdIc;
    public final TextView thirdTitle;
    public final TextView thirdValue;
    public final Guideline thirdValueLeftLine;

    private MyBusinessItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Guideline guideline, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout4, ImageView imageView, Guideline guideline2, ImageView imageView2, TextView textView4, TextView textView5, Guideline guideline3, ConstraintLayout constraintLayout5, ImageView imageView3, TextView textView6, TextView textView7, Guideline guideline4, ImageView imageView4, TextView textView8, TextView textView9, Guideline guideline5) {
        this.rootView = constraintLayout;
        this.bizIcContainer = constraintLayout2;
        this.bizIcNStatusContainer = constraintLayout3;
        this.bizInfoLeftLine = guideline;
        this.bizName = textView;
        this.bizNumber = textView2;
        this.bizStatus = textView3;
        this.bizStatusContainer = constraintLayout4;
        this.bizTypeIc = imageView;
        this.centerHorizontalLine = guideline2;
        this.firstIc = imageView2;
        this.firstTitle = textView4;
        this.firstValue = textView5;
        this.mainLeftLine = guideline3;
        this.myBusinessItem = constraintLayout5;
        this.secondIc = imageView3;
        this.secondTitle = textView6;
        this.secondValue = textView7;
        this.secondValueLeftLine = guideline4;
        this.thirdIc = imageView4;
        this.thirdTitle = textView8;
        this.thirdValue = textView9;
        this.thirdValueLeftLine = guideline5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyBusinessItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyBusinessItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_business_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyBusinessItemBinding bind(View view) {
        int i = R.id.biz_ic_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.biz_ic_n_status_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.biz_info_left_line;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.biz_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.biz_number;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.biz_status;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.biz_status_container;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.biz_type_ic;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.center_horizontal_line;
                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline2 != null) {
                                            i = R.id.first_ic;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.first_title;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.first_value;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.main_left_line;
                                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline3 != null) {
                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                            i = R.id.second_ic;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView3 != null) {
                                                                i = R.id.second_title;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.second_value;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.second_value_left_line;
                                                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline4 != null) {
                                                                            i = R.id.third_ic;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView4 != null) {
                                                                                i = R.id.third_title;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.third_value;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.third_value_left_line;
                                                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                        if (guideline5 != null) {
                                                                                            return new MyBusinessItemBinding(constraintLayout4, constraintLayout, constraintLayout2, guideline, textView, textView2, textView3, constraintLayout3, imageView, guideline2, imageView2, textView4, textView5, guideline3, constraintLayout4, imageView3, textView6, textView7, guideline4, imageView4, textView8, textView9, guideline5);
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
