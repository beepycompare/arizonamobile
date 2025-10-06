package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class CasesSameCasesItemBinding implements ViewBinding {
    public final ImageView ivPrize;
    public final ImageView ivRub;
    private final FrameLayout rootView;
    public final TextView tvBenefit;
    public final TextView tvNew;
    public final TextView tvPrizeCost;
    public final TextView tvPrizeName;
    public final TextView tvTop;

    private CasesSameCasesItemBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.ivPrize = imageView;
        this.ivRub = imageView2;
        this.tvBenefit = textView;
        this.tvNew = textView2;
        this.tvPrizeCost = textView3;
        this.tvPrizeName = textView4;
        this.tvTop = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static CasesSameCasesItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CasesSameCasesItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cases_same_cases_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CasesSameCasesItemBinding bind(View view) {
        int i = R.id.iv_prize;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_rub;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.tv_benefit;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_new;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_prize_cost;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_prize_name;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_top;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    return new CasesSameCasesItemBinding((FrameLayout) view, imageView, imageView2, textView, textView2, textView3, textView4, textView5);
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
