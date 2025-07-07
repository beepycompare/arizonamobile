package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyCreateColorItemBinding implements ViewBinding {
    public final CardView colorItem;
    public final ImageView doneArrow;
    private final CardView rootView;

    private FamilyCreateColorItemBinding(CardView cardView, CardView cardView2, ImageView imageView) {
        this.rootView = cardView;
        this.colorItem = cardView2;
        this.doneArrow = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static FamilyCreateColorItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyCreateColorItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_create_color_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyCreateColorItemBinding bind(View view) {
        CardView cardView = (CardView) view;
        int i = R.id.done_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new FamilyCreateColorItemBinding(cardView, cardView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
