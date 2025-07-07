package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemLavkaTypeBinding implements ViewBinding {
    public final CardView item;
    public final AppCompatImageView ivActiveItem;
    public final ImageView ivDefaultItem;
    public final ImageView ivDollar;
    public final ImageView ivItemImage;
    private final CardView rootView;
    public final TextView tvTitleText;
    public final View viewCenter;

    private ItemLavkaTypeBinding(CardView rootView, CardView item, AppCompatImageView ivActiveItem, ImageView ivDefaultItem, ImageView ivDollar, ImageView ivItemImage, TextView tvTitleText, View viewCenter) {
        this.rootView = rootView;
        this.item = item;
        this.ivActiveItem = ivActiveItem;
        this.ivDefaultItem = ivDefaultItem;
        this.ivDollar = ivDollar;
        this.ivItemImage = ivItemImage;
        this.tvTitleText = tvTitleText;
        this.viewCenter = viewCenter;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemLavkaTypeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemLavkaTypeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_lavka_type, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemLavkaTypeBinding bind(View rootView) {
        View findChildViewById;
        CardView cardView = (CardView) rootView;
        int i = R.id.ivActiveItem;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.ivDefaultItem;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.ivDollar;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.ivItemImage;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.tvTitleText;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewCenter))) != null) {
                            return new ItemLavkaTypeBinding(cardView, cardView, appCompatImageView, imageView, imageView2, imageView3, textView, findChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
