package ru.mrlargha.feature.item.rating.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.item.rating.R;
/* loaded from: classes6.dex */
public final class RatingListBinding implements ViewBinding {
    public final RecyclerView itemsRv;
    private final LinearLayout rootView;
    public final RatingTopbarBinding topbar;
    public final LinearLayout transportScreen;

    private RatingListBinding(LinearLayout linearLayout, RecyclerView recyclerView, RatingTopbarBinding ratingTopbarBinding, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.itemsRv = recyclerView;
        this.topbar = ratingTopbarBinding;
        this.transportScreen = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RatingListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RatingListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rating_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RatingListBinding bind(View view) {
        View findChildViewById;
        int i = R.id.items_rv;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.topbar))) != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new RatingListBinding(linearLayout, recyclerView, RatingTopbarBinding.bind(findChildViewById), linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
