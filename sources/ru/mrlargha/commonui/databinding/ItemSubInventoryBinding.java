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
public final class ItemSubInventoryBinding implements ViewBinding {
    public final CardView cvColoredItem;
    public final AppCompatImageView ivActiveItem;
    public final ImageView ivDefaultItem;
    public final ImageView ivItemDefaultImage;
    public final ImageView ivItemImage;
    public final CardView parentItem;
    private final CardView rootView;
    public final TextView tvDescriptionText;
    public final TextView tvItemNum;
    public final TextView tvTitleText;
    public final View viewCenter;
    public final View viewColored;

    private ItemSubInventoryBinding(CardView rootView, CardView cvColoredItem, AppCompatImageView ivActiveItem, ImageView ivDefaultItem, ImageView ivItemDefaultImage, ImageView ivItemImage, CardView parentItem, TextView tvDescriptionText, TextView tvItemNum, TextView tvTitleText, View viewCenter, View viewColored) {
        this.rootView = rootView;
        this.cvColoredItem = cvColoredItem;
        this.ivActiveItem = ivActiveItem;
        this.ivDefaultItem = ivDefaultItem;
        this.ivItemDefaultImage = ivItemDefaultImage;
        this.ivItemImage = ivItemImage;
        this.parentItem = parentItem;
        this.tvDescriptionText = tvDescriptionText;
        this.tvItemNum = tvItemNum;
        this.tvTitleText = tvTitleText;
        this.viewCenter = viewCenter;
        this.viewColored = viewColored;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemSubInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemSubInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_sub_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSubInventoryBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.cvColoredItem;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            i = R.id.ivActiveItem;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.ivDefaultItem;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.ivItemDefaultImage;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.ivItemImage;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            CardView cardView2 = (CardView) rootView;
                            i = R.id.tvDescriptionText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvItemNum;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvTitleText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewCenter))) != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.viewColored))) != null) {
                                        return new ItemSubInventoryBinding(cardView2, cardView, appCompatImageView, imageView, imageView2, imageView3, cardView2, textView, textView2, textView3, findChildViewById, findChildViewById2);
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
