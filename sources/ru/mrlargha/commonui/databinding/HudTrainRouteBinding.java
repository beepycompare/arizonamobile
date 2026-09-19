package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.hud.presentation.view.TrainRouteProgressView;
/* loaded from: classes6.dex */
public final class HudTrainRouteBinding implements ViewBinding {
    public final TextView maxKm;
    private final FrameLayout rootView;
    public final TrainRouteProgressView routeProgress;
    public final FrameLayout routeProgressTrack;
    public final TextView trainEndStation;
    public final TextView trainRouteWarnings;
    public final TextView trainStartStation;

    private HudTrainRouteBinding(FrameLayout rootView, TextView maxKm, TrainRouteProgressView routeProgress, FrameLayout routeProgressTrack, TextView trainEndStation, TextView trainRouteWarnings, TextView trainStartStation) {
        this.rootView = rootView;
        this.maxKm = maxKm;
        this.routeProgress = routeProgress;
        this.routeProgressTrack = routeProgressTrack;
        this.trainEndStation = trainEndStation;
        this.trainRouteWarnings = trainRouteWarnings;
        this.trainStartStation = trainStartStation;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTrainRouteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTrainRouteBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_train_route, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTrainRouteBinding bind(View rootView) {
        int i = R.id.max_km;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.route_progress;
            TrainRouteProgressView trainRouteProgressView = (TrainRouteProgressView) ViewBindings.findChildViewById(rootView, i);
            if (trainRouteProgressView != null) {
                i = R.id.route_progress_track;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                if (frameLayout != null) {
                    i = R.id.train_end_station;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.train_route_warnings;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.train_start_station;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                return new HudTrainRouteBinding((FrameLayout) rootView, textView, trainRouteProgressView, frameLayout, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
