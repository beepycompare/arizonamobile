package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class WorkshopButtonsContainerBinding implements ViewBinding {
    public final Button btnSharpenItem;
    public final WorkshopCostButtonsBinding paintButtons;
    private final FrameLayout rootView;

    private WorkshopButtonsContainerBinding(FrameLayout frameLayout, Button button, WorkshopCostButtonsBinding workshopCostButtonsBinding) {
        this.rootView = frameLayout;
        this.btnSharpenItem = button;
        this.paintButtons = workshopCostButtonsBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WorkshopButtonsContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WorkshopButtonsContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.workshop_buttons_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WorkshopButtonsContainerBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btnSharpenItem;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.paint_buttons))) != null) {
            return new WorkshopButtonsContainerBinding((FrameLayout) view, button, WorkshopCostButtonsBinding.bind(findChildViewById));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
