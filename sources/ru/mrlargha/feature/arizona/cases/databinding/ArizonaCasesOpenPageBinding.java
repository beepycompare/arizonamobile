package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class ArizonaCasesOpenPageBinding implements ViewBinding {
    public final ImageView caseImg;
    public final LinearLayout getContainer;
    public final LinearLayout openContainer;
    private final LinearLayout rootView;
    public final RecyclerView rvWinnerPrizes;
    public final LinearLayout schismContainer;
    public final TextView tvCost;
    public final TextView tvGet;
    public final TextView tvOpenAll;
    public final TextView tvSchism;

    private ArizonaCasesOpenPageBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.caseImg = imageView;
        this.getContainer = linearLayout2;
        this.openContainer = linearLayout3;
        this.rvWinnerPrizes = recyclerView;
        this.schismContainer = linearLayout4;
        this.tvCost = textView;
        this.tvGet = textView2;
        this.tvOpenAll = textView3;
        this.tvSchism = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaCasesOpenPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ArizonaCasesOpenPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.arizona_cases_open_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaCasesOpenPageBinding bind(View view) {
        int i = R.id.case_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.get_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.open_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.rv_winner_prizes;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.schism_container;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.tv_cost;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_get;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_open_all;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_schism;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new ArizonaCasesOpenPageBinding((LinearLayout) view, imageView, linearLayout, linearLayout2, recyclerView, linearLayout3, textView, textView2, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
