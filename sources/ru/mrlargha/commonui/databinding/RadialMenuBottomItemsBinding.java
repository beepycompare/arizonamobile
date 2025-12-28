package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RadialMenuBottomItemsBinding implements ViewBinding {
    public final LinearLayout btnBackPage;
    public final LinearLayout btnNextPage;
    public final TextView itemTitle;
    private final LinearLayout rootView;

    private RadialMenuBottomItemsBinding(LinearLayout rootView, LinearLayout btnBackPage, LinearLayout btnNextPage, TextView itemTitle) {
        this.rootView = rootView;
        this.btnBackPage = btnBackPage;
        this.btnNextPage = btnNextPage;
        this.itemTitle = itemTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RadialMenuBottomItemsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RadialMenuBottomItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.radial_menu_bottom_items, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RadialMenuBottomItemsBinding bind(View rootView) {
        int i = R.id.btn_back_page;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.btn_next_page;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.item_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new RadialMenuBottomItemsBinding((LinearLayout) rootView, linearLayout, linearLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
