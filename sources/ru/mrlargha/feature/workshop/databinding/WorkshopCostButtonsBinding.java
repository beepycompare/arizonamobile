package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.databinding.ItemInfoCostBinding;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class WorkshopCostButtonsBinding implements ViewBinding {
    public final Button btnPaintItem;
    public final ItemInfoCostBinding costFieldPainting;
    private final LinearLayout rootView;

    private WorkshopCostButtonsBinding(LinearLayout linearLayout, Button button, ItemInfoCostBinding itemInfoCostBinding) {
        this.rootView = linearLayout;
        this.btnPaintItem = button;
        this.costFieldPainting = itemInfoCostBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WorkshopCostButtonsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WorkshopCostButtonsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.workshop_cost_buttons, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WorkshopCostButtonsBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btnPaintItem;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.costFieldPainting))) != null) {
            return new WorkshopCostButtonsBinding((LinearLayout) view, button, ItemInfoCostBinding.bind(findChildViewById));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
