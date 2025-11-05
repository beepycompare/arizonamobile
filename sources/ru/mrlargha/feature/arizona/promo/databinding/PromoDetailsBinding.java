package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class PromoDetailsBinding implements ViewBinding {
    public final LinearLayout backToActivate;
    private final LinearLayout rootView;
    public final RecyclerView rv;
    public final ArizonaGradientTextView title;
    public final View viewAfterLevel;
    public final View viewBeforeLevel;

    private PromoDetailsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, ArizonaGradientTextView arizonaGradientTextView, View view, View view2) {
        this.rootView = linearLayout;
        this.backToActivate = linearLayout2;
        this.rv = recyclerView;
        this.title = arizonaGradientTextView;
        this.viewAfterLevel = view;
        this.viewBeforeLevel = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PromoDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PromoDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.promo_details, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PromoDetailsBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.back_to_activate;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.rv;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.title;
                ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                if (arizonaGradientTextView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_after_level))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_before_level))) != null) {
                    return new PromoDetailsBinding((LinearLayout) view, linearLayout, recyclerView, arizonaGradientTextView, findChildViewById, findChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
