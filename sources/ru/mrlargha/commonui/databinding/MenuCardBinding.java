package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class MenuCardBinding implements ViewBinding {
    public final AppCompatImageView backgorundImage;
    public final CardView card;
    public final TextView elementName;
    public final AppCompatImageView icon;
    public final ConstraintLayout layout;
    private final CardView rootView;

    private MenuCardBinding(CardView rootView, AppCompatImageView backgorundImage, CardView card, TextView elementName, AppCompatImageView icon, ConstraintLayout layout) {
        this.rootView = rootView;
        this.backgorundImage = backgorundImage;
        this.card = card;
        this.elementName = elementName;
        this.icon = icon;
        this.layout = layout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static MenuCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MenuCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.menu_card, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static MenuCardBinding bind(View rootView) {
        int i = R.id.backgorund_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            CardView cardView = (CardView) rootView;
            i = R.id.element_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.icon;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView2 != null) {
                    i = R.id.layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout != null) {
                        return new MenuCardBinding(cardView, appCompatImageView, cardView, textView, appCompatImageView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
