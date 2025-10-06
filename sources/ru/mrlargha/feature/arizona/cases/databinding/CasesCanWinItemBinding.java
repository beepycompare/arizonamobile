package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class CasesCanWinItemBinding implements ViewBinding {
    public final ImageView ivPrize;
    public final CustomCardView qualityButton1;
    private final FrameLayout rootView;
    public final TextView tvPrizeName;

    private CasesCanWinItemBinding(FrameLayout frameLayout, ImageView imageView, CustomCardView customCardView, TextView textView) {
        this.rootView = frameLayout;
        this.ivPrize = imageView;
        this.qualityButton1 = customCardView;
        this.tvPrizeName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static CasesCanWinItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CasesCanWinItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cases_can_win_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CasesCanWinItemBinding bind(View view) {
        int i = R.id.iv_prize;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.quality_button1;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.tv_prize_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new CasesCanWinItemBinding((FrameLayout) view, imageView, customCardView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
