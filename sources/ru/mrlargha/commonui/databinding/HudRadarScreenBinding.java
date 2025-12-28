package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.metaldetector.LocatorView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes5.dex */
public final class HudRadarScreenBinding implements ViewBinding {
    public final CustomCardView btnUnlock;
    public final ImageView ivScanner;
    public final LocatorView locatorView;
    private final FrameLayout rootView;

    private HudRadarScreenBinding(FrameLayout rootView, CustomCardView btnUnlock, ImageView ivScanner, LocatorView locatorView) {
        this.rootView = rootView;
        this.btnUnlock = btnUnlock;
        this.ivScanner = ivScanner;
        this.locatorView = locatorView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudRadarScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudRadarScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_radar_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudRadarScreenBinding bind(View rootView) {
        int i = R.id.btn_unlock;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.iv_scanner;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.locatorView;
                LocatorView locatorView = (LocatorView) ViewBindings.findChildViewById(rootView, i);
                if (locatorView != null) {
                    return new HudRadarScreenBinding((FrameLayout) rootView, customCardView, imageView, locatorView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
