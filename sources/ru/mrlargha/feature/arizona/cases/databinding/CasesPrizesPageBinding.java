package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class CasesPrizesPageBinding implements ViewBinding {
    public final ImageView btnShowPrizes;
    private final LinearLayout rootView;
    public final RecyclerView rvPrizes;

    private CasesPrizesPageBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.btnShowPrizes = imageView;
        this.rvPrizes = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CasesPrizesPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CasesPrizesPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cases_prizes_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CasesPrizesPageBinding bind(View view) {
        int i = R.id.btn_show_prizes;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.rv_prizes;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                return new CasesPrizesPageBinding((LinearLayout) view, imageView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
