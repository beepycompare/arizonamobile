package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DonatePayPassMarkerBinding implements ViewBinding {
    public final CustomCardView paypassMarkerChip;
    public final ImageView paypassMarkerIcon;
    private final FrameLayout rootView;

    private DonatePayPassMarkerBinding(FrameLayout rootView, CustomCardView paypassMarkerChip, ImageView paypassMarkerIcon) {
        this.rootView = rootView;
        this.paypassMarkerChip = paypassMarkerChip;
        this.paypassMarkerIcon = paypassMarkerIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonatePayPassMarkerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePayPassMarkerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_pay_pass_marker, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePayPassMarkerBinding bind(View rootView) {
        int i = R.id.paypass_marker_chip;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.paypass_marker_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                return new DonatePayPassMarkerBinding((FrameLayout) rootView, customCardView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
