package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaKaptScreenBinding implements ViewBinding {
    public final Guideline guideline26;
    public final Guideline guideline27;
    public final Guideline guideline28;
    public final AppCompatImageView imageView25;
    public final AppCompatImageView rodinaKaptLeftGangFlag;
    public final AppCompatImageView rodinaKaptLeftGangFragCountBg;
    public final AppCompatImageView rodinaKaptLeftGangFragCountIcon;
    public final TextView rodinaKaptLeftGangFragCountValue;
    public final TextView rodinaKaptLeftGangName;
    public final AppCompatImageView rodinaKaptRightGangFlag;
    public final AppCompatImageView rodinaKaptRightGangFragCountBg;
    public final AppCompatImageView rodinaKaptRightGangFragCountIc;
    public final TextView rodinaKaptRightGangFragCountValue;
    public final TextView rodinaKaptRightGangName;
    public final ConstraintLayout rodinaKaptRoot;
    public final TextView rodinaKaptTimeRemaining;
    public final TextView rodinaKaptTimeRemainingTop;
    private final ConstraintLayout rootView;
    public final TextView textView42;
    public final TextView textView42Top;

    private RodinaKaptScreenBinding(ConstraintLayout rootView, Guideline guideline26, Guideline guideline27, Guideline guideline28, AppCompatImageView imageView25, AppCompatImageView rodinaKaptLeftGangFlag, AppCompatImageView rodinaKaptLeftGangFragCountBg, AppCompatImageView rodinaKaptLeftGangFragCountIcon, TextView rodinaKaptLeftGangFragCountValue, TextView rodinaKaptLeftGangName, AppCompatImageView rodinaKaptRightGangFlag, AppCompatImageView rodinaKaptRightGangFragCountBg, AppCompatImageView rodinaKaptRightGangFragCountIc, TextView rodinaKaptRightGangFragCountValue, TextView rodinaKaptRightGangName, ConstraintLayout rodinaKaptRoot, TextView rodinaKaptTimeRemaining, TextView rodinaKaptTimeRemainingTop, TextView textView42, TextView textView42Top) {
        this.rootView = rootView;
        this.guideline26 = guideline26;
        this.guideline27 = guideline27;
        this.guideline28 = guideline28;
        this.imageView25 = imageView25;
        this.rodinaKaptLeftGangFlag = rodinaKaptLeftGangFlag;
        this.rodinaKaptLeftGangFragCountBg = rodinaKaptLeftGangFragCountBg;
        this.rodinaKaptLeftGangFragCountIcon = rodinaKaptLeftGangFragCountIcon;
        this.rodinaKaptLeftGangFragCountValue = rodinaKaptLeftGangFragCountValue;
        this.rodinaKaptLeftGangName = rodinaKaptLeftGangName;
        this.rodinaKaptRightGangFlag = rodinaKaptRightGangFlag;
        this.rodinaKaptRightGangFragCountBg = rodinaKaptRightGangFragCountBg;
        this.rodinaKaptRightGangFragCountIc = rodinaKaptRightGangFragCountIc;
        this.rodinaKaptRightGangFragCountValue = rodinaKaptRightGangFragCountValue;
        this.rodinaKaptRightGangName = rodinaKaptRightGangName;
        this.rodinaKaptRoot = rodinaKaptRoot;
        this.rodinaKaptTimeRemaining = rodinaKaptTimeRemaining;
        this.rodinaKaptTimeRemainingTop = rodinaKaptTimeRemainingTop;
        this.textView42 = textView42;
        this.textView42Top = textView42Top;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RodinaKaptScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaKaptScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_kapt_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaKaptScreenBinding bind(View rootView) {
        int i = R.id.guideline26;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline27;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline28;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.imageView25;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.rodina_kapt_left_gang_flag;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.rodina_kapt_left_gang_frag_count_bg;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageView3 != null) {
                                i = R.id.rodina_kapt_left_gang_frag_count_icon;
                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatImageView4 != null) {
                                    i = R.id.rodina_kapt_left_gang_frag_count_value;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.rodina_kapt_left_gang_name;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.rodina_kapt_right_gang_flag;
                                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (appCompatImageView5 != null) {
                                                i = R.id.rodina_kapt_right_gang_frag_count_bg;
                                                AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatImageView6 != null) {
                                                    i = R.id.rodina_kapt_right_gang_frag_count_ic;
                                                    AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (appCompatImageView7 != null) {
                                                        i = R.id.rodina_kapt_right_gang_frag_count_value;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView3 != null) {
                                                            i = R.id.rodina_kapt_right_gang_name;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView4 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                i = R.id.rodina_kapt_time_remaining;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.rodina_kapt_time_remaining_top;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.textView42;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.textView42_top;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView8 != null) {
                                                                                return new RodinaKaptScreenBinding(constraintLayout, guideline, guideline2, guideline3, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, textView, textView2, appCompatImageView5, appCompatImageView6, appCompatImageView7, textView3, textView4, constraintLayout, textView5, textView6, textView7, textView8);
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
