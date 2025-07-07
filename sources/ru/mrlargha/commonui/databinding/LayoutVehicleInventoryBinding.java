package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutVehicleInventoryBinding implements ViewBinding {
    public final AppCompatImageButton btnVehicleTechnical;
    public final AppCompatImageButton btnVehicleVisual;
    public final ConstraintLayout constraintTechVis;
    public final LinearProgressIndicator ivEngineBar;
    public final AppCompatImageView ivEngineTab;
    public final LinearProgressIndicator ivOilBar;
    public final AppCompatImageView ivOilTab;
    public final AppCompatImageView ivVehicleBg;
    public final LinearLayout layoutVehicleInfo;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvVehicleAccessories;
    public final RecyclerView rvVehicleTech;
    public final RecyclerView rvVehicleVisual;
    public final AppCompatTextView tvEngineCount;
    public final AppCompatTextView tvOilCount;
    public final LinearLayout vehicleInfoButtons;

    private LayoutVehicleInventoryBinding(ConstraintLayout rootView, AppCompatImageButton btnVehicleTechnical, AppCompatImageButton btnVehicleVisual, ConstraintLayout constraintTechVis, LinearProgressIndicator ivEngineBar, AppCompatImageView ivEngineTab, LinearProgressIndicator ivOilBar, AppCompatImageView ivOilTab, AppCompatImageView ivVehicleBg, LinearLayout layoutVehicleInfo, ConstraintLayout parentLayout, RecyclerView rvVehicleAccessories, RecyclerView rvVehicleTech, RecyclerView rvVehicleVisual, AppCompatTextView tvEngineCount, AppCompatTextView tvOilCount, LinearLayout vehicleInfoButtons) {
        this.rootView = rootView;
        this.btnVehicleTechnical = btnVehicleTechnical;
        this.btnVehicleVisual = btnVehicleVisual;
        this.constraintTechVis = constraintTechVis;
        this.ivEngineBar = ivEngineBar;
        this.ivEngineTab = ivEngineTab;
        this.ivOilBar = ivOilBar;
        this.ivOilTab = ivOilTab;
        this.ivVehicleBg = ivVehicleBg;
        this.layoutVehicleInfo = layoutVehicleInfo;
        this.parentLayout = parentLayout;
        this.rvVehicleAccessories = rvVehicleAccessories;
        this.rvVehicleTech = rvVehicleTech;
        this.rvVehicleVisual = rvVehicleVisual;
        this.tvEngineCount = tvEngineCount;
        this.tvOilCount = tvOilCount;
        this.vehicleInfoButtons = vehicleInfoButtons;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutVehicleInventoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutVehicleInventoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_vehicle_inventory, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutVehicleInventoryBinding bind(View rootView) {
        int i = R.id.btnVehicleTechnical;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageButton != null) {
            i = R.id.btnVehicleVisual;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageButton2 != null) {
                i = R.id.constraintTechVis;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    i = R.id.ivEngineBar;
                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                    if (linearProgressIndicator != null) {
                        i = R.id.ivEngineTab;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView != null) {
                            i = R.id.ivOilBar;
                            LinearProgressIndicator linearProgressIndicator2 = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                            if (linearProgressIndicator2 != null) {
                                i = R.id.ivOilTab;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatImageView2 != null) {
                                    i = R.id.ivVehicleBg;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatImageView3 != null) {
                                        i = R.id.layout_vehicle_info;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout != null) {
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                                            i = R.id.rvVehicleAccessories;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView != null) {
                                                i = R.id.rvVehicleTech;
                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                if (recyclerView2 != null) {
                                                    i = R.id.rvVehicleVisual;
                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                    if (recyclerView3 != null) {
                                                        i = R.id.tvEngineCount;
                                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatTextView != null) {
                                                            i = R.id.tvOilCount;
                                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (appCompatTextView2 != null) {
                                                                i = R.id.vehicleInfoButtons;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout2 != null) {
                                                                    return new LayoutVehicleInventoryBinding(constraintLayout2, appCompatImageButton, appCompatImageButton2, constraintLayout, linearProgressIndicator, appCompatImageView, linearProgressIndicator2, appCompatImageView2, appCompatImageView3, linearLayout, constraintLayout2, recyclerView, recyclerView2, recyclerView3, appCompatTextView, appCompatTextView2, linearLayout2);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
