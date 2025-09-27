package ru.mrlargha.feature.starter_pack.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.starter_pack.R;
/* loaded from: classes6.dex */
public final class StarterpackItemBinding implements ViewBinding {
    public final CardView bg;
    public final ImageView imagePrise;
    public final View rarity;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private StarterpackItemBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, View view, TextView textView) {
        this.rootView = linearLayout;
        this.bg = cardView;
        this.imagePrise = imageView;
        this.rarity = view;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StarterpackItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StarterpackItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.starterpack_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StarterpackItemBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bg;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.rarity))) != null) {
                i = R.id.tv_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new StarterpackItemBinding((LinearLayout) view, cardView, imageView, findChildViewById, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
