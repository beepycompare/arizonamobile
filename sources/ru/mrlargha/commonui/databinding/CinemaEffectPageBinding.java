package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CinemaEffectPageBinding implements ViewBinding {
    public final ConstraintLayout cinemaEffectBottomShield;
    public final ConstraintLayout cinemaEffectPage;
    public final TextView cinemaEffectText;
    public final ConstraintLayout cinemaEffectTextContainer;
    public final ConstraintLayout cinemaEffectTopShield;
    private final ConstraintLayout rootView;

    private CinemaEffectPageBinding(ConstraintLayout rootView, ConstraintLayout cinemaEffectBottomShield, ConstraintLayout cinemaEffectPage, TextView cinemaEffectText, ConstraintLayout cinemaEffectTextContainer, ConstraintLayout cinemaEffectTopShield) {
        this.rootView = rootView;
        this.cinemaEffectBottomShield = cinemaEffectBottomShield;
        this.cinemaEffectPage = cinemaEffectPage;
        this.cinemaEffectText = cinemaEffectText;
        this.cinemaEffectTextContainer = cinemaEffectTextContainer;
        this.cinemaEffectTopShield = cinemaEffectTopShield;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CinemaEffectPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CinemaEffectPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.cinema_effect_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CinemaEffectPageBinding bind(View rootView) {
        int i = R.id.cinema_effect_bottom_shield;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
            i = R.id.cinema_effect_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.cinema_effect_text_container;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout3 != null) {
                    i = R.id.cinema_effect_top_shield;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout4 != null) {
                        return new CinemaEffectPageBinding(constraintLayout2, constraintLayout, constraintLayout2, textView, constraintLayout3, constraintLayout4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
