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
/* loaded from: classes3.dex */
public final class ItemInventoryBinding implements ViewBinding {
    public final CardView cvColoredItem;
    public final CardView item;
    public final AppCompatImageView ivActiveItem;
    public final ImageView ivDefaultItem;
    public final ImageView ivEffectBackground;
    public final ImageView ivEffectForeground;
    public final ImageView ivItemImage;
    private final CardView rootView;
    public final TextView tvNeedRes;
    public final TextView tvTitleText;
    public final View viewCenter;

    private ItemInventoryBinding(CardView rootView, CardView cvColoredItem, CardView item, AppCompatImageView ivActiveItem, ImageView ivDefaultItem, ImageView ivEffectBackground, ImageView ivEffectForeground, ImageView ivItemImage, TextView tvNeedRes, TextView tvTitleText, View viewCenter) {
        this.rootView = rootView;
        this.cvColoredItem = cvColoredItem;
        this.item = item;
        this.ivActiveItem = ivActiveItem;
        this.ivDefaultItem = ivDefaultItem;
        this.ivEffectBackground = ivEffectBackground;
        this.ivEffectForeground = ivEffectForeground;
        this.ivItemImage = ivItemImage;
        this.tvNeedRes = tvNeedRes;
        this.tvTitleText = tvTitleText;
        this.viewCenter = viewCenter;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemInventoryBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.cvColoredItem;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            CardView cardView2 = (CardView) rootView;
            i = R.id.ivActiveItem;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.ivDefaultItem;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.iv_effect_background;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.iv_effect_foreground;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            i = R.id.ivItemImage;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView4 != null) {
                                i = R.id.tvNeedRes;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.tvTitleText;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewCenter))) != null) {
                                        return new ItemInventoryBinding(cardView2, cardView, cardView2, appCompatImageView, imageView, imageView2, imageView3, imageView4, textView, textView2, findChildViewById);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
