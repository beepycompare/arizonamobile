package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilySettingsItemBinding implements ViewBinding {
    public final CardView card;
    public final TextView itemDesc;
    public final TextView itemTitle;
    public final ImageView levelImage;
    private final LinearLayout rootView;
    public final View stroke;

    private FamilySettingsItemBinding(LinearLayout linearLayout, CardView cardView, TextView textView, TextView textView2, ImageView imageView, View view) {
        this.rootView = linearLayout;
        this.card = cardView;
        this.itemDesc = textView;
        this.itemTitle = textView2;
        this.levelImage = imageView;
        this.stroke = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilySettingsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilySettingsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_settings_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilySettingsItemBinding bind(View view) {
        View findChildViewById;
        int i = R.id.card;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.item_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.level_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.stroke))) != null) {
                        return new FamilySettingsItemBinding((LinearLayout) view, cardView, textView, textView2, imageView, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
