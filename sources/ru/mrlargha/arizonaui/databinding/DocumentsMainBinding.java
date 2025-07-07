package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsMainBinding implements ViewBinding {
    public final ImageView alertNot;
    public final TextView armyWrit;
    public final TextView birth;
    public final TextView charity;
    public final TextView citizenship;
    public final TextView documentsMainDesc;
    public final TextView familyStatus;
    public final LinearLayout gpsButton;
    public final TextView job;
    public final TextView lawAbiding;
    public final TextView name;
    public final LinearLayout notAvailableContainer;
    public final TextView number;
    public final ImageView photo;
    public final TextView rank;
    private final ConstraintLayout rootView;
    public final TextView series;
    public final TextView sex;
    public final TextView signature;
    public final LinearLayout table1;
    public final LinearLayout table2;
    public final LinearLayout table3;
    public final LinearLayout table4;
    public final LinearLayout table5;
    public final TextView yearsCitizen;

    private DocumentsMainBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, TextView textView7, TextView textView8, TextView textView9, LinearLayout linearLayout2, TextView textView10, ImageView imageView2, TextView textView11, TextView textView12, TextView textView13, TextView textView14, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView15) {
        this.rootView = constraintLayout;
        this.alertNot = imageView;
        this.armyWrit = textView;
        this.birth = textView2;
        this.charity = textView3;
        this.citizenship = textView4;
        this.documentsMainDesc = textView5;
        this.familyStatus = textView6;
        this.gpsButton = linearLayout;
        this.job = textView7;
        this.lawAbiding = textView8;
        this.name = textView9;
        this.notAvailableContainer = linearLayout2;
        this.number = textView10;
        this.photo = imageView2;
        this.rank = textView11;
        this.series = textView12;
        this.sex = textView13;
        this.signature = textView14;
        this.table1 = linearLayout3;
        this.table2 = linearLayout4;
        this.table3 = linearLayout5;
        this.table4 = linearLayout6;
        this.table5 = linearLayout7;
        this.yearsCitizen = textView15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsMainBinding bind(View view) {
        int i = R.id.alert_not;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.army_writ;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.birth;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.charity;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.citizenship;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.documents_main_desc;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.family_status;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.gps_button;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.job;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.law_abiding;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                i = R.id.name;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.notAvailableContainer;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.number;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView10 != null) {
                                                            i = R.id.photo;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView2 != null) {
                                                                i = R.id.rank;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView11 != null) {
                                                                    i = R.id.series;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView12 != null) {
                                                                        i = R.id.sex;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView13 != null) {
                                                                            i = R.id.signature;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView14 != null) {
                                                                                i = R.id.table1;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout3 != null) {
                                                                                    i = R.id.table2;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = R.id.table3;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.table4;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout6 != null) {
                                                                                                i = R.id.table5;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i = R.id.years_citizen;
                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView15 != null) {
                                                                                                        return new DocumentsMainBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, linearLayout, textView7, textView8, textView9, linearLayout2, textView10, imageView2, textView11, textView12, textView13, textView14, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, textView15);
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
