package ru.mrlargha.feature.battle_pass_view.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battle_pass_view.R;
/* loaded from: classes6.dex */
public final class ItemRewardRodinaBinding implements ViewBinding {
    public final CustomCardView cvReward;
    public final ImageView ivReward;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView tvRewardDesc;

    private ItemRewardRodinaBinding(ConstraintLayout constraintLayout, CustomCardView customCardView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.cvReward = customCardView;
        this.ivReward = imageView;
        this.parentLayout = constraintLayout2;
        this.tvRewardDesc = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemRewardRodinaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRewardRodinaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_reward_rodina, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRewardRodinaBinding bind(View view) {
        int i = R.id.cvReward;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.ivReward;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.tvRewardDesc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ItemRewardRodinaBinding(constraintLayout, customCardView, imageView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
