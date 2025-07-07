package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class SituationItemBinding implements ViewBinding {
    public final Guideline buttonTopLine;
    public final ConstraintLayout chooseButton;
    public final TextView freeSlotsTitle;
    public final TextView fullInfo;
    public final Guideline fullInfoTopLine;
    public final ConstraintLayout infoButton;
    public final ConstraintLayout mainInfoContainer;
    public final TextView mainInfoTitle;
    public final CardView mainInfoTitleLine;
    public final TextView rang;
    public final ImageView rangIc;
    public final TextView rangTitle;
    private final ConstraintLayout rootView;
    public final ConstraintLayout situationFullInfoContainer;
    public final ConstraintLayout situationItem;
    public final ConstraintLayout situationMainContainer;

    private SituationItemBinding(ConstraintLayout constraintLayout, Guideline guideline, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, Guideline guideline2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView3, CardView cardView, TextView textView4, ImageView imageView, TextView textView5, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7) {
        this.rootView = constraintLayout;
        this.buttonTopLine = guideline;
        this.chooseButton = constraintLayout2;
        this.freeSlotsTitle = textView;
        this.fullInfo = textView2;
        this.fullInfoTopLine = guideline2;
        this.infoButton = constraintLayout3;
        this.mainInfoContainer = constraintLayout4;
        this.mainInfoTitle = textView3;
        this.mainInfoTitleLine = cardView;
        this.rang = textView4;
        this.rangIc = imageView;
        this.rangTitle = textView5;
        this.situationFullInfoContainer = constraintLayout5;
        this.situationItem = constraintLayout6;
        this.situationMainContainer = constraintLayout7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SituationItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SituationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.situation_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SituationItemBinding bind(View view) {
        int i = R.id.button_top_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.choose_button;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.free_slots_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.full_info;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.full_info_top_line;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            i = R.id.info_button;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.main_info_container;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.main_info_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.main_info_title_line;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                        if (cardView != null) {
                                            i = R.id.rang;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.rang_ic;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.rang_title;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.situation_full_info_container;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                            i = R.id.situation_main_container;
                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout6 != null) {
                                                                return new SituationItemBinding(constraintLayout5, guideline, constraintLayout, textView, textView2, guideline2, constraintLayout2, constraintLayout3, textView3, cardView, textView4, imageView, textView5, constraintLayout4, constraintLayout5, constraintLayout6);
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
