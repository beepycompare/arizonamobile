package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateBottomItemsListBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RecyclerView rvBottomItems;
    public final TextView tvId;

    private DonateBottomItemsListBinding(FrameLayout rootView, RecyclerView rvBottomItems, TextView tvId) {
        this.rootView = rootView;
        this.rvBottomItems = rvBottomItems;
        this.tvId = tvId;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateBottomItemsListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateBottomItemsListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_bottom_items_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateBottomItemsListBinding bind(View rootView) {
        int i = R.id.rv_bottom_items;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
        if (recyclerView != null) {
            i = R.id.tv_id;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new DonateBottomItemsListBinding((FrameLayout) rootView, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
