package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutWarehouseBinding implements ViewBinding {
    public final TextView etStoreMoney;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvWarehouse;

    private LayoutWarehouseBinding(ConstraintLayout rootView, TextView etStoreMoney, ConstraintLayout parentLayout, RecyclerView rvWarehouse) {
        this.rootView = rootView;
        this.etStoreMoney = etStoreMoney;
        this.parentLayout = parentLayout;
        this.rvWarehouse = rvWarehouse;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWarehouseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutWarehouseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_warehouse, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutWarehouseBinding bind(View rootView) {
        int i = R.id.etStoreMoney;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            int i2 = R.id.rvWarehouse;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i2);
            if (recyclerView != null) {
                return new LayoutWarehouseBinding(constraintLayout, textView, constraintLayout, recyclerView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
