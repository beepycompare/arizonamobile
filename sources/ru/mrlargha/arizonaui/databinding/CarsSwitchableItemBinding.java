package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class CarsSwitchableItemBinding implements ViewBinding {
    public final Switch carSwitch;
    public final ConstraintLayout carsSwitchableItem;
    public final TextView itemName;
    private final ConstraintLayout rootView;

    private CarsSwitchableItemBinding(ConstraintLayout constraintLayout, Switch r2, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.carSwitch = r2;
        this.carsSwitchableItem = constraintLayout2;
        this.itemName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CarsSwitchableItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CarsSwitchableItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cars_switchable_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CarsSwitchableItemBinding bind(View view) {
        int i = R.id.car_switch;
        Switch r1 = (Switch) ViewBindings.findChildViewById(view, i);
        if (r1 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.item_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new CarsSwitchableItemBinding(constraintLayout, r1, constraintLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
