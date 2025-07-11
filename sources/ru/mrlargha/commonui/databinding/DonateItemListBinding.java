package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateItemListBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final FrameLayout rootView;
    public final RecyclerView rvItemList;

    private DonateItemListBinding(FrameLayout rootView, ProgressBar progressBar, RecyclerView rvItemList) {
        this.rootView = rootView;
        this.progressBar = progressBar;
        this.rvItemList = rvItemList;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateItemListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateItemListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_item_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateItemListBinding bind(View rootView) {
        int i = R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
        if (progressBar != null) {
            i = R.id.rv_item_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                return new DonateItemListBinding((FrameLayout) rootView, progressBar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
