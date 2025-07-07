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
public final class ItemWorkbenchColorBinding implements ViewBinding {
    public final ImageView ivSelectedColor;
    public final CardView parentCardView;
    private final CardView rootView;
    public final View viewBgLocked;

    private ItemWorkbenchColorBinding(CardView rootView, ImageView ivSelectedColor, CardView parentCardView, View viewBgLocked) {
        this.rootView = rootView;
        this.ivSelectedColor = ivSelectedColor;
        this.parentCardView = parentCardView;
        this.viewBgLocked = viewBgLocked;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemWorkbenchColorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemWorkbenchColorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_workbench_color, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemWorkbenchColorBinding bind(View rootView) {
        int i = R.id.ivSelectedColor;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            CardView cardView = (CardView) rootView;
            int i2 = R.id.viewBgLocked;
            View findChildViewById = ViewBindings.findChildViewById(rootView, i2);
            if (findChildViewById != null) {
                return new ItemWorkbenchColorBinding(cardView, imageView, cardView, findChildViewById);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
