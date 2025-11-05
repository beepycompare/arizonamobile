package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemTuningSelectColorBinding implements ViewBinding {
    public final ImageView ivSelectedColor;
    public final CardView parentCardView;
    private final CardView rootView;
    public final View viewBgLocked;
    public final View viewColor;

    private ItemTuningSelectColorBinding(CardView rootView, ImageView ivSelectedColor, CardView parentCardView, View viewBgLocked, View viewColor) {
        this.rootView = rootView;
        this.ivSelectedColor = ivSelectedColor;
        this.parentCardView = parentCardView;
        this.viewBgLocked = viewBgLocked;
        this.viewColor = viewColor;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemTuningSelectColorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTuningSelectColorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_tuning_select_color, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTuningSelectColorBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.ivSelectedColor;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            CardView cardView = (CardView) rootView;
            i = R.id.viewBgLocked;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewColor))) != null) {
                return new ItemTuningSelectColorBinding(cardView, imageView, cardView, findChildViewById2, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
