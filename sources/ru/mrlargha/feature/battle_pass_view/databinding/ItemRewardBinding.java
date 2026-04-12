package ru.mrlargha.feature.battle_pass_view.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battle_pass_view.R;
/* loaded from: classes6.dex */
public final class ItemRewardBinding implements ViewBinding {
    public final CardView cvReward;
    public final ImageView ivReward;
    public final LinearLayout parentLayout;
    private final LinearLayout rootView;
    public final TextView tvDopInfo;
    public final TextView tvRewardDesc;

    private ItemRewardBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.cvReward = cardView;
        this.ivReward = imageView;
        this.parentLayout = linearLayout2;
        this.tvDopInfo = textView;
        this.tvRewardDesc = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemRewardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_reward, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRewardBinding bind(View view) {
        int i = R.id.cvReward;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.ivReward;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.tv_dop_info;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvRewardDesc;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ItemRewardBinding(linearLayout, cardView, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
