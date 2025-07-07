package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ArizonaDonateCategoryItemBinding implements ViewBinding {
    public final CardView card;
    public final TextView description;
    public final AppCompatImageView donateCategoryIcon;
    public final ConstraintLayout donateCategoryItem;
    private final ConstraintLayout rootView;

    private ArizonaDonateCategoryItemBinding(ConstraintLayout constraintLayout, CardView cardView, TextView textView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.card = cardView;
        this.description = textView;
        this.donateCategoryIcon = appCompatImageView;
        this.donateCategoryItem = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaDonateCategoryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ArizonaDonateCategoryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.arizona_donate_category_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaDonateCategoryItemBinding bind(View view) {
        int i = R.id.card;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.donate_category_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new ArizonaDonateCategoryItemBinding(constraintLayout, cardView, textView, appCompatImageView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
