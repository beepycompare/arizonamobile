package com.arizonagames.feature.minigames.atm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.arizonagames.feature.minigames.atm.R;
/* loaded from: classes3.dex */
public final class AtmScreenBaseLayoutBinding implements ViewBinding {
    public final FrameLayout atmGameBaseScreen;
    private final FrameLayout rootView;

    private AtmScreenBaseLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.atmGameBaseScreen = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AtmScreenBaseLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AtmScreenBaseLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.atm_screen_base_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AtmScreenBaseLayoutBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new AtmScreenBaseLayoutBinding(frameLayout, frameLayout);
    }
}
