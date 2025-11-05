package ru.mrlargha.feature.employment.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.employment.center.R;
/* loaded from: classes6.dex */
public final class EmploymentCenterMainBinding implements ViewBinding {
    public final TextView bonus;
    public final CustomCardView button1;
    public final CustomCardView button2;
    public final CustomCardView buttonAction1;
    public final TextView buttonAction1text;
    public final CustomCardView buttonAction2;
    public final TextView buttonAction2text;
    public final CustomCardView buttonAction3;
    public final TextView buttonAction3text;
    public final CustomCardView buttonAction4;
    public final TextView buttonAction4text;
    public final CustomCardView buttonAction5;
    public final TextView buttonAction5text;
    public final CustomCardView buttonBonus;
    public final CustomCardView buttonInfo;
    public final LinearLayout content;
    public final View divider;
    public final ImageView image;
    public final LinearLayout label;
    public final TextView labelBonus;
    public final LinearLayout labelTimer;
    public final ProgressBar loaderBar;
    public final TextView noBonus;
    private final LinearLayout rootView;
    public final RecyclerView rvInfo;
    public final TextView salary;
    public final TextView text1;
    public final TextView text2;
    public final TextView timer;
    public final TextView title;

    private EmploymentCenterMainBinding(LinearLayout linearLayout, TextView textView, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, TextView textView2, CustomCardView customCardView4, TextView textView3, CustomCardView customCardView5, TextView textView4, CustomCardView customCardView6, TextView textView5, CustomCardView customCardView7, TextView textView6, CustomCardView customCardView8, CustomCardView customCardView9, LinearLayout linearLayout2, View view, ImageView imageView, LinearLayout linearLayout3, TextView textView7, LinearLayout linearLayout4, ProgressBar progressBar, TextView textView8, RecyclerView recyclerView, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = linearLayout;
        this.bonus = textView;
        this.button1 = customCardView;
        this.button2 = customCardView2;
        this.buttonAction1 = customCardView3;
        this.buttonAction1text = textView2;
        this.buttonAction2 = customCardView4;
        this.buttonAction2text = textView3;
        this.buttonAction3 = customCardView5;
        this.buttonAction3text = textView4;
        this.buttonAction4 = customCardView6;
        this.buttonAction4text = textView5;
        this.buttonAction5 = customCardView7;
        this.buttonAction5text = textView6;
        this.buttonBonus = customCardView8;
        this.buttonInfo = customCardView9;
        this.content = linearLayout2;
        this.divider = view;
        this.image = imageView;
        this.label = linearLayout3;
        this.labelBonus = textView7;
        this.labelTimer = linearLayout4;
        this.loaderBar = progressBar;
        this.noBonus = textView8;
        this.rvInfo = recyclerView;
        this.salary = textView9;
        this.text1 = textView10;
        this.text2 = textView11;
        this.timer = textView12;
        this.title = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterMainBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bonus;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.button1;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.button2;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.button_action1;
                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView3 != null) {
                        i = R.id.button_action1text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.button_action2;
                            CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView4 != null) {
                                i = R.id.button_action2text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.button_action3;
                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView5 != null) {
                                        i = R.id.button_action3text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.button_action4;
                                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView6 != null) {
                                                i = R.id.button_action4text;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.button_action5;
                                                    CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView7 != null) {
                                                        i = R.id.button_action5text;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.button_bonus;
                                                            CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                            if (customCardView8 != null) {
                                                                i = R.id.button_info;
                                                                CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                if (customCardView9 != null) {
                                                                    i = R.id.content;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                                                                        i = R.id.image;
                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView != null) {
                                                                            i = R.id.label;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.label_bonus;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.label_timer;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.loader_bar;
                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                        if (progressBar != null) {
                                                                                            i = R.id.no_bonus;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.rv_info;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                if (recyclerView != null) {
                                                                                                    i = R.id.salary;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.text1;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.text2;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.timer;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.title;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView13 != null) {
                                                                                                                        return new EmploymentCenterMainBinding((LinearLayout) view, textView, customCardView, customCardView2, customCardView3, textView2, customCardView4, textView3, customCardView5, textView4, customCardView6, textView5, customCardView7, textView6, customCardView8, customCardView9, linearLayout, findChildViewById, imageView, linearLayout2, textView7, linearLayout3, progressBar, textView8, recyclerView, textView9, textView10, textView11, textView12, textView13);
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
