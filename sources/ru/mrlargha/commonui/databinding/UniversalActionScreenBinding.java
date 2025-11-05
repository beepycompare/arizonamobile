package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class UniversalActionScreenBinding implements ViewBinding {
    public final ProgressBar rodinaProgressBar;
    public final ConstraintLayout rodinaProgressContainer;
    public final ConstraintLayout rodinaProgressTouchContainer;
    public final AppCompatImageView rodinaProgressTouchIcon;
    public final TextView rodinaUniversalActionText;
    private final ConstraintLayout rootView;
    public final ConstraintLayout universalAction;

    private UniversalActionScreenBinding(ConstraintLayout rootView, ProgressBar rodinaProgressBar, ConstraintLayout rodinaProgressContainer, ConstraintLayout rodinaProgressTouchContainer, AppCompatImageView rodinaProgressTouchIcon, TextView rodinaUniversalActionText, ConstraintLayout universalAction) {
        this.rootView = rootView;
        this.rodinaProgressBar = rodinaProgressBar;
        this.rodinaProgressContainer = rodinaProgressContainer;
        this.rodinaProgressTouchContainer = rodinaProgressTouchContainer;
        this.rodinaProgressTouchIcon = rodinaProgressTouchIcon;
        this.rodinaUniversalActionText = rodinaUniversalActionText;
        this.universalAction = universalAction;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UniversalActionScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UniversalActionScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.universal_action_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static UniversalActionScreenBinding bind(View rootView) {
        int i = R.id.rodina_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
        if (progressBar != null) {
            i = R.id.rodina_progress_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout != null) {
                i = R.id.rodina_progress_touch_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.rodina_progress_touch_icon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.rodina_universal_action_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                            return new UniversalActionScreenBinding(constraintLayout3, progressBar, constraintLayout, constraintLayout2, appCompatImageView, textView, constraintLayout3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
