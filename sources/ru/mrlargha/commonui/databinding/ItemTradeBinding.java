package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemTradeBinding implements ViewBinding {
    public final CardView cvColoredItem;
    public final CardView item;
    public final AppCompatImageView ivActiveItem;
    public final AppCompatImageView ivItemImage;
    private final CardView rootView;
    public final TextView tvTitleText;
    public final View viewCenter;

    private ItemTradeBinding(CardView rootView, CardView cvColoredItem, CardView item, AppCompatImageView ivActiveItem, AppCompatImageView ivItemImage, TextView tvTitleText, View viewCenter) {
        this.rootView = rootView;
        this.cvColoredItem = cvColoredItem;
        this.item = item;
        this.ivActiveItem = ivActiveItem;
        this.ivItemImage = ivItemImage;
        this.tvTitleText = tvTitleText;
        this.viewCenter = viewCenter;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemTradeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTradeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_trade, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTradeBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.cvColoredItem;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            CardView cardView2 = (CardView) rootView;
            i = R.id.ivActiveItem;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.ivItemImage;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView2 != null) {
                    i = R.id.tvTitleText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewCenter))) != null) {
                        return new ItemTradeBinding(cardView2, cardView, cardView2, appCompatImageView, appCompatImageView2, textView, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
