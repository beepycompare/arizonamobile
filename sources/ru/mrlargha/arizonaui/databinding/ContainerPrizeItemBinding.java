package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ContainerPrizeItemBinding implements ViewBinding {
    public final CardView acItemCard;
    public final AppCompatImageView acItemImage;
    public final TextView acItemTittle;
    public final ConstraintLayout cpiBg;
    private final ConstraintLayout rootView;

    private ContainerPrizeItemBinding(ConstraintLayout constraintLayout, CardView cardView, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.acItemCard = cardView;
        this.acItemImage = appCompatImageView;
        this.acItemTittle = textView;
        this.cpiBg = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ContainerPrizeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContainerPrizeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.container_prize_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ContainerPrizeItemBinding bind(View view) {
        int i = R.id.ac_item_card;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.ac_item_image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.ac_item_tittle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new ContainerPrizeItemBinding(constraintLayout, cardView, appCompatImageView, textView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
