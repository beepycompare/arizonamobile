package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MicStatusElementBinding implements ViewBinding {
    public final AppCompatImageView micStatusButton;
    public final FrameLayout micStatusLayout;
    private final FrameLayout rootView;

    private MicStatusElementBinding(FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.micStatusButton = appCompatImageView;
        this.micStatusLayout = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MicStatusElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MicStatusElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mic_status_element, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MicStatusElementBinding bind(View view) {
        int i = R.id.mic_status_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new MicStatusElementBinding(frameLayout, appCompatImageView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
