package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.family.GridOverlayView;
/* loaded from: classes5.dex */
public final class FamilyMapBinding implements ViewBinding {
    public final SubsamplingScaleImageView mapView;
    public final ConstraintLayout neighborGameTaskScreen;
    public final GridOverlayView overlayView;
    private final ConstraintLayout rootView;

    private FamilyMapBinding(ConstraintLayout constraintLayout, SubsamplingScaleImageView subsamplingScaleImageView, ConstraintLayout constraintLayout2, GridOverlayView gridOverlayView) {
        this.rootView = constraintLayout;
        this.mapView = subsamplingScaleImageView;
        this.neighborGameTaskScreen = constraintLayout2;
        this.overlayView = gridOverlayView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamilyMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyMapBinding bind(View view) {
        int i = R.id.mapView;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) ViewBindings.findChildViewById(view, i);
        if (subsamplingScaleImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.overlayView;
            GridOverlayView gridOverlayView = (GridOverlayView) ViewBindings.findChildViewById(view, i2);
            if (gridOverlayView != null) {
                return new FamilyMapBinding(constraintLayout, subsamplingScaleImageView, constraintLayout, gridOverlayView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
