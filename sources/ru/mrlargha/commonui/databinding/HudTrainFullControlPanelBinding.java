package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudTrainFullControlPanelBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final FrameLayout trainFullControlPanel;

    private HudTrainFullControlPanelBinding(FrameLayout rootView, FrameLayout trainFullControlPanel) {
        this.rootView = rootView;
        this.trainFullControlPanel = trainFullControlPanel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTrainFullControlPanelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTrainFullControlPanelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_train_full_control_panel, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTrainFullControlPanelBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) rootView;
        return new HudTrainFullControlPanelBinding(frameLayout, frameLayout);
    }
}
