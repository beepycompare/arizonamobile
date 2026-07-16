package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class InventoryPaginationBinding implements ViewBinding {
    public final CustomCardView buttonNextPage;
    public final CustomCardView buttonPreviousPage;
    private final LinearLayout rootView;
    public final LinearLayout tabMainInventoryPages;

    private InventoryPaginationBinding(LinearLayout rootView, CustomCardView buttonNextPage, CustomCardView buttonPreviousPage, LinearLayout tabMainInventoryPages) {
        this.rootView = rootView;
        this.buttonNextPage = buttonNextPage;
        this.buttonPreviousPage = buttonPreviousPage;
        this.tabMainInventoryPages = tabMainInventoryPages;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static InventoryPaginationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryPaginationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_pagination, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryPaginationBinding bind(View rootView) {
        int i = R.id.buttonNextPage;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.buttonPreviousPage;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView2 != null) {
                i = R.id.tabMainInventoryPages;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    return new InventoryPaginationBinding((LinearLayout) rootView, customCardView, customCardView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
