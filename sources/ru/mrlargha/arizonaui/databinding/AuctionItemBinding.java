package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class AuctionItemBinding implements ViewBinding {
    public final AppCompatImageView acHot;
    public final LinearLayout acMultiplayer;
    public final TextView acMultiplayerTittle;
    public final CardView auctionItemCard;
    public final ConstraintLayout auctionItemLayout;
    public final AppCompatImageView containerItemImage;
    public final TextView containerItemTittle;
    private final ConstraintLayout rootView;

    private AuctionItemBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, CardView cardView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView2, TextView textView2) {
        this.rootView = constraintLayout;
        this.acHot = appCompatImageView;
        this.acMultiplayer = linearLayout;
        this.acMultiplayerTittle = textView;
        this.auctionItemCard = cardView;
        this.auctionItemLayout = constraintLayout2;
        this.containerItemImage = appCompatImageView2;
        this.containerItemTittle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuctionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuctionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.auction_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuctionItemBinding bind(View view) {
        int i = R.id.ac_hot;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.ac_multiplayer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.ac_multiplayer_tittle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.auction_item_card;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.container_item_image;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.container_item_tittle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new AuctionItemBinding(constraintLayout, appCompatImageView, linearLayout, textView, cardView, constraintLayout, appCompatImageView2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
