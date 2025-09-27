package ru.mrlargha.feature.item.rating.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.item.rating.R;
/* loaded from: classes6.dex */
public final class RatingTopbarBinding implements ViewBinding {
    public final CustomCardView card1;
    public final CustomCardView card2;
    public final CustomCardView card3;
    public final AppCompatEditText editText;
    public final CustomCardView filter;
    private final LinearLayout rootView;
    public final CustomCardView search;

    private RatingTopbarBinding(LinearLayout linearLayout, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, AppCompatEditText appCompatEditText, CustomCardView customCardView4, CustomCardView customCardView5) {
        this.rootView = linearLayout;
        this.card1 = customCardView;
        this.card2 = customCardView2;
        this.card3 = customCardView3;
        this.editText = appCompatEditText;
        this.filter = customCardView4;
        this.search = customCardView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RatingTopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RatingTopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rating_topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RatingTopbarBinding bind(View view) {
        int i = R.id.card1;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.card2;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.card3;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.edit_text;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                    if (appCompatEditText != null) {
                        i = R.id.filter;
                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView4 != null) {
                            i = R.id.search;
                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView5 != null) {
                                return new RatingTopbarBinding((LinearLayout) view, customCardView, customCardView2, customCardView3, appCompatEditText, customCardView4, customCardView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
