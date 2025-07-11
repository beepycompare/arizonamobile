package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class GhettoTopbarBinding implements ViewBinding {
    public final CardView backButton;
    public final CardView closeButton;
    public final LinearLayout nameContainer;
    private final LinearLayout rootView;

    private GhettoTopbarBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.backButton = cardView;
        this.closeButton = cardView2;
        this.nameContainer = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GhettoTopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GhettoTopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ghetto_topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GhettoTopbarBinding bind(View view) {
        int i = R.id.back_button;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.close_button;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView2 != null) {
                i = R.id.name_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    return new GhettoTopbarBinding((LinearLayout) view, cardView, cardView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
