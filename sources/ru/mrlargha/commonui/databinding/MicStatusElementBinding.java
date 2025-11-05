package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class MicStatusElementBinding implements ViewBinding {
    public final AppCompatImageView micStatusButton;
    public final FrameLayout micStatusLayout;
    private final FrameLayout rootView;

    private MicStatusElementBinding(FrameLayout rootView, AppCompatImageView micStatusButton, FrameLayout micStatusLayout) {
        this.rootView = rootView;
        this.micStatusButton = micStatusButton;
        this.micStatusLayout = micStatusLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MicStatusElementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MicStatusElementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.mic_status_element, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static MicStatusElementBinding bind(View rootView) {
        int i = R.id.mic_status_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            FrameLayout frameLayout = (FrameLayout) rootView;
            return new MicStatusElementBinding(frameLayout, appCompatImageView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
