package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.ghetto.GridOverlayView;
/* loaded from: classes5.dex */
public final class GhettoMapBinding implements ViewBinding {
    public final CardView button;
    public final SubsamplingScaleImageView mapView;
    public final ConstraintLayout neighborGameTaskScreen;
    public final GridOverlayView overlayView;
    private final ConstraintLayout rootView;

    private GhettoMapBinding(ConstraintLayout constraintLayout, CardView cardView, SubsamplingScaleImageView subsamplingScaleImageView, ConstraintLayout constraintLayout2, GridOverlayView gridOverlayView) {
        this.rootView = constraintLayout;
        this.button = cardView;
        this.mapView = subsamplingScaleImageView;
        this.neighborGameTaskScreen = constraintLayout2;
        this.overlayView = gridOverlayView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GhettoMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GhettoMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ghetto_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GhettoMapBinding bind(View view) {
        int i = R.id.button;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.mapView;
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) ViewBindings.findChildViewById(view, i);
            if (subsamplingScaleImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.overlayView;
                GridOverlayView gridOverlayView = (GridOverlayView) ViewBindings.findChildViewById(view, i);
                if (gridOverlayView != null) {
                    return new GhettoMapBinding(constraintLayout, cardView, subsamplingScaleImageView, constraintLayout, gridOverlayView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
