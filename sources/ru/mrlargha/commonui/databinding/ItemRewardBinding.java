package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemRewardBinding implements ViewBinding {
    public final CardView cvReward;
    public final ImageView ivReward;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView tvRewardDesc;

    private ItemRewardBinding(ConstraintLayout rootView, CardView cvReward, ImageView ivReward, ConstraintLayout parentLayout, TextView tvRewardDesc) {
        this.rootView = rootView;
        this.cvReward = cvReward;
        this.ivReward = ivReward;
        this.parentLayout = parentLayout;
        this.tvRewardDesc = tvRewardDesc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemRewardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemRewardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_reward, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemRewardBinding bind(View rootView) {
        int i = R.id.cvReward;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            i = R.id.ivReward;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.tvRewardDesc;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new ItemRewardBinding(constraintLayout, cardView, imageView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
