package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemWorkshopBinding implements ViewBinding {
    public final ImageView ivItemImage;
    public final CardView parentLayout;
    private final CardView rootView;
    public final CardView topRightColor;
    public final TextView tvTitleText;

    private ItemWorkshopBinding(CardView rootView, ImageView ivItemImage, CardView parentLayout, CardView topRightColor, TextView tvTitleText) {
        this.rootView = rootView;
        this.ivItemImage = ivItemImage;
        this.parentLayout = parentLayout;
        this.topRightColor = topRightColor;
        this.tvTitleText = tvTitleText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemWorkshopBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemWorkshopBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_workshop, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemWorkshopBinding bind(View rootView) {
        int i = R.id.ivItemImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            CardView cardView = (CardView) rootView;
            i = R.id.topRightColor;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
            if (cardView2 != null) {
                i = R.id.tvTitleText;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new ItemWorkshopBinding(cardView, imageView, cardView, cardView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
