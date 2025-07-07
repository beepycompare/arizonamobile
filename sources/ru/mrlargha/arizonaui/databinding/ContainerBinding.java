package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ContainerBinding implements ViewBinding {
    public final TextView containerAuctionTittle;
    public final TextView containerDescription;
    public final AppCompatImageView containerExitButton;
    public final AppCompatImageView containerGoButton;
    public final Guideline containerHorizontalActivitiAuction;
    public final Guideline containerHorizontalBottomAuction;
    public final Guideline containerHorizontalBottomLine;
    public final Guideline containerHorizontalDescription;
    public final Guideline containerHorizontalExit;
    public final Guideline containerHorizontalTopAuction;
    public final Guideline containerHorizontalTopHelp;
    public final Guideline containerHorizontalTopLine;
    public final ConstraintLayout containerLayout;
    public final RecyclerView containerRcView;
    public final TextView containerTitle;
    public final Guideline containerVerticalExit;
    public final Guideline containerVerticalLine;
    public final Guideline containerVerticalLineButton;
    public final Guideline containerVerticalLineTittle;
    private final ConstraintLayout rootView;

    private ContainerBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView3, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12) {
        this.rootView = constraintLayout;
        this.containerAuctionTittle = textView;
        this.containerDescription = textView2;
        this.containerExitButton = appCompatImageView;
        this.containerGoButton = appCompatImageView2;
        this.containerHorizontalActivitiAuction = guideline;
        this.containerHorizontalBottomAuction = guideline2;
        this.containerHorizontalBottomLine = guideline3;
        this.containerHorizontalDescription = guideline4;
        this.containerHorizontalExit = guideline5;
        this.containerHorizontalTopAuction = guideline6;
        this.containerHorizontalTopHelp = guideline7;
        this.containerHorizontalTopLine = guideline8;
        this.containerLayout = constraintLayout2;
        this.containerRcView = recyclerView;
        this.containerTitle = textView3;
        this.containerVerticalExit = guideline9;
        this.containerVerticalLine = guideline10;
        this.containerVerticalLineButton = guideline11;
        this.containerVerticalLineTittle = guideline12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ContainerBinding bind(View view) {
        int i = R.id.container_auction_tittle;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.container_description;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.container_exit_button;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.container_go_button;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.container_horizontal_activiti_auction;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null) {
                            i = R.id.container_horizontal_bottom_auction;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline2 != null) {
                                i = R.id.container_horizontal_bottom_line;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.container_horizontal_description;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline4 != null) {
                                        i = R.id.container_horizontal_exit;
                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline5 != null) {
                                            i = R.id.container_horizontal_top_auction;
                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline6 != null) {
                                                i = R.id.container_horizontal_top_help;
                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline7 != null) {
                                                    i = R.id.container_horizontal_top_line;
                                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline8 != null) {
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                        i = R.id.container_rc_view;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                        if (recyclerView != null) {
                                                            i = R.id.container_title;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.container_vertical_exit;
                                                                Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline9 != null) {
                                                                    i = R.id.container_vertical_line;
                                                                    Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                    if (guideline10 != null) {
                                                                        i = R.id.container_vertical_line_button;
                                                                        Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline11 != null) {
                                                                            i = R.id.container_vertical_line_tittle;
                                                                            Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline12 != null) {
                                                                                return new ContainerBinding(constraintLayout, textView, textView2, appCompatImageView, appCompatImageView2, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, constraintLayout, recyclerView, textView3, guideline9, guideline10, guideline11, guideline12);
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
