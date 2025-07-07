package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateOrdinaryPageBinding implements ViewBinding {
    private final RecyclerView rootView;
    public final RecyclerView rvItems;

    private DonateOrdinaryPageBinding(RecyclerView rootView, RecyclerView rvItems) {
        this.rootView = rootView;
        this.rvItems = rvItems;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static DonateOrdinaryPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateOrdinaryPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_ordinary_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateOrdinaryPageBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        RecyclerView recyclerView = (RecyclerView) rootView;
        return new DonateOrdinaryPageBinding(recyclerView, recyclerView);
    }
}
