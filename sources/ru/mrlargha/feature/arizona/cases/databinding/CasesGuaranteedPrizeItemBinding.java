package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class CasesGuaranteedPrizeItemBinding implements ViewBinding {
    public final ImageView ivPrize;
    public final CustomCardView progressBar;
    public final CustomCardView progressBarBg;
    private final LinearLayout rootView;
    public final TextView tvItemCount;
    public final TextView tvPrizeName;

    private CasesGuaranteedPrizeItemBinding(LinearLayout linearLayout, ImageView imageView, CustomCardView customCardView, CustomCardView customCardView2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivPrize = imageView;
        this.progressBar = customCardView;
        this.progressBarBg = customCardView2;
        this.tvItemCount = textView;
        this.tvPrizeName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CasesGuaranteedPrizeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CasesGuaranteedPrizeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cases_guaranteed_prize_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CasesGuaranteedPrizeItemBinding bind(View view) {
        int i = R.id.iv_prize;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.progress_bar;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.progress_bar_bg;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.tv_item_count;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_prize_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new CasesGuaranteedPrizeItemBinding((LinearLayout) view, imageView, customCardView, customCardView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
