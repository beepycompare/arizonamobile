package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
/* loaded from: classes3.dex */
public final class BooleanSettingViewBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final SwitchMaterial settingSwitch;

    private BooleanSettingViewBinding(FrameLayout rootView, SwitchMaterial settingSwitch) {
        this.rootView = rootView;
        this.settingSwitch = settingSwitch;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BooleanSettingViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BooleanSettingViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.boolean_setting_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BooleanSettingViewBinding bind(View rootView) {
        int i = R.id.setting_switch;
        SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.findChildViewById(rootView, i);
        if (switchMaterial != null) {
            return new BooleanSettingViewBinding((FrameLayout) rootView, switchMaterial);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
