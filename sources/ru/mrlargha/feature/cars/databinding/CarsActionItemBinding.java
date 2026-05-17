package ru.mrlargha.feature.cars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.cars.R;
/* loaded from: classes5.dex */
public final class CarsActionItemBinding implements ViewBinding {
    public final CustomCardView carsActionItem;
    public final ImageView itemIc;
    public final TextView itemValue;
    private final CustomCardView rootView;

    private CarsActionItemBinding(CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, TextView textView) {
        this.rootView = customCardView;
        this.carsActionItem = customCardView2;
        this.itemIc = imageView;
        this.itemValue = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static CarsActionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CarsActionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cars_action_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CarsActionItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.item_ic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.item_value;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new CarsActionItemBinding(customCardView, customCardView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
