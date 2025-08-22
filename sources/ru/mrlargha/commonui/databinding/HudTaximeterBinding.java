package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudTaximeterBinding implements ViewBinding {
    public final HudCounterBinding counter;
    public final HudTaximeterStopwatchBinding hudTaximeterArmySecond;
    public final HudTaximeterContainerBinding hudTaximeterLayoutContainer;
    private final FrameLayout rootView;

    private HudTaximeterBinding(FrameLayout rootView, HudCounterBinding counter, HudTaximeterStopwatchBinding hudTaximeterArmySecond, HudTaximeterContainerBinding hudTaximeterLayoutContainer) {
        this.rootView = rootView;
        this.counter = counter;
        this.hudTaximeterArmySecond = hudTaximeterArmySecond;
        this.hudTaximeterLayoutContainer = hudTaximeterLayoutContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTaximeterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTaximeterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_taximeter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTaximeterBinding bind(View rootView) {
        int i = R.id.counter;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            HudCounterBinding bind = HudCounterBinding.bind(findChildViewById);
            int i2 = R.id.hud_taximeter_army_second;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i2);
            if (findChildViewById2 != null) {
                HudTaximeterStopwatchBinding bind2 = HudTaximeterStopwatchBinding.bind(findChildViewById2);
                int i3 = R.id.hud_taximeter_layout_container;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i3);
                if (findChildViewById3 != null) {
                    return new HudTaximeterBinding((FrameLayout) rootView, bind, bind2, HudTaximeterContainerBinding.bind(findChildViewById3));
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
