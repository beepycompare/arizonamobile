package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class ItemWorkshopBinding implements ViewBinding {
    public final ImageView ivItemImage;
    public final CardView parentLayout;
    private final CardView rootView;
    public final CardView topRightColor;
    public final TextView tvTitleText;

    private ItemWorkshopBinding(CardView cardView, ImageView imageView, CardView cardView2, CardView cardView3, TextView textView) {
        this.rootView = cardView;
        this.ivItemImage = imageView;
        this.parentLayout = cardView2;
        this.topRightColor = cardView3;
        this.tvTitleText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemWorkshopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemWorkshopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_workshop, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemWorkshopBinding bind(View view) {
        int i = R.id.ivItemImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            CardView cardView = (CardView) view;
            i = R.id.topRightColor;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView2 != null) {
                i = R.id.tvTitleText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ItemWorkshopBinding(cardView, imageView, cardView, cardView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
