package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ContainerGetPrizeBinding implements ViewBinding {
    public final RecyclerView ccRcView;
    public final ConstraintLayout cgp;
    public final TextView cgpBoldDescription;
    public final TextView cgpDescription;
    public final LinearLayout cgpDescriptionContainer;
    public final AppCompatImageView cgpExitButton;
    public final TextView cgpTitle;
    private final ConstraintLayout rootView;

    private ContainerGetPrizeBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView3) {
        this.rootView = constraintLayout;
        this.ccRcView = recyclerView;
        this.cgp = constraintLayout2;
        this.cgpBoldDescription = textView;
        this.cgpDescription = textView2;
        this.cgpDescriptionContainer = linearLayout;
        this.cgpExitButton = appCompatImageView;
        this.cgpTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ContainerGetPrizeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContainerGetPrizeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.container_get_prize, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ContainerGetPrizeBinding bind(View view) {
        int i = R.id.cc_rc_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cgp_bold_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cgp_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.cgp_description_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.cgp_exit_button;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView != null) {
                            i = R.id.cgp_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new ContainerGetPrizeBinding(constraintLayout, recyclerView, constraintLayout, textView, textView2, linearLayout, appCompatImageView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
