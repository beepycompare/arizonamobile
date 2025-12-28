package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class WorkshopInfoContainerBinding implements ViewBinding {
    public final WorkshopInfoBinding info;
    private final FrameLayout rootView;
    public final RecyclerView rvColors;
    public final WorkshopChanceCostInfoBinding sharpingInfoContainer;

    private WorkshopInfoContainerBinding(FrameLayout frameLayout, WorkshopInfoBinding workshopInfoBinding, RecyclerView recyclerView, WorkshopChanceCostInfoBinding workshopChanceCostInfoBinding) {
        this.rootView = frameLayout;
        this.info = workshopInfoBinding;
        this.rvColors = recyclerView;
        this.sharpingInfoContainer = workshopChanceCostInfoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WorkshopInfoContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WorkshopInfoContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.workshop_info_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WorkshopInfoContainerBinding bind(View view) {
        View findChildViewById;
        int i = R.id.info;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            WorkshopInfoBinding bind = WorkshopInfoBinding.bind(findChildViewById2);
            int i2 = R.id.rvColors;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i2);
            if (recyclerView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i2 = R.id.sharping_info_container))) != null) {
                return new WorkshopInfoContainerBinding((FrameLayout) view, bind, recyclerView, WorkshopChanceCostInfoBinding.bind(findChildViewById));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
