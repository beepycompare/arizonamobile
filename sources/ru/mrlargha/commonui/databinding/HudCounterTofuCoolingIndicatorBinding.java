package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudCounterTofuCoolingIndicatorBinding implements ViewBinding {
    private final CustomCardView rootView;

    private HudCounterTofuCoolingIndicatorBinding(CustomCardView rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static HudCounterTofuCoolingIndicatorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterTofuCoolingIndicatorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter_tofu_cooling_indicator, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterTofuCoolingIndicatorBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new HudCounterTofuCoolingIndicatorBinding((CustomCardView) rootView);
    }
}
