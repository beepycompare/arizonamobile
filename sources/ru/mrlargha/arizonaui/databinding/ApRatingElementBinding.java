package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ApRatingElementBinding implements ViewBinding {
    public final TextView apElementExp;
    public final AppCompatImageView apRatingElementBg;
    public final AppCompatImageView apRatingElementCrown;
    public final TextView apRatingElementPosition;
    public final TextView apRatingNick;
    private final ConstraintLayout rootView;
    public final AppCompatTextView textView6;

    private ApRatingElementBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.apElementExp = textView;
        this.apRatingElementBg = appCompatImageView;
        this.apRatingElementCrown = appCompatImageView2;
        this.apRatingElementPosition = textView2;
        this.apRatingNick = textView3;
        this.textView6 = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ApRatingElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ApRatingElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ap_rating_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ApRatingElementBinding bind(View view) {
        int i = R.id.ap_element_exp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.ap_rating_element_bg;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.ap_rating_element_crown;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.ap_rating_element_position;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.ap_rating_nick;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.textView6;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView != null) {
                                return new ApRatingElementBinding((ConstraintLayout) view, textView, appCompatImageView, appCompatImageView2, textView2, textView3, appCompatTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
