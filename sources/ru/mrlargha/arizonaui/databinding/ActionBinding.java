package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ActionBinding implements ViewBinding {
    public final RelativeLayout action;
    public final AppCompatImageView actionBackground;
    public final ConstraintLayout actionContainer;
    public final TextView actionDescription;
    public final TextView actionPercent;
    public final ProgressBar actionPgb;
    private final RelativeLayout rootView;

    private ActionBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.action = relativeLayout2;
        this.actionBackground = appCompatImageView;
        this.actionContainer = constraintLayout;
        this.actionDescription = textView;
        this.actionPercent = textView2;
        this.actionPgb = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.action, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActionBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.action_background;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.action_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.action_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.action_percent;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.action_pgb;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            return new ActionBinding(relativeLayout, relativeLayout, appCompatImageView, constraintLayout, textView, textView2, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
