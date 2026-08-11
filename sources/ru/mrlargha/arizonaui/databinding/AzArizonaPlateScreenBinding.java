package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class AzArizonaPlateScreenBinding implements ViewBinding {
    public final CustomCardView closeButton;
    public final CustomCardView getNumberButton;
    public final TextView plateNumber;
    public final TextView plateRegion;
    private final FrameLayout rootView;

    private AzArizonaPlateScreenBinding(FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.closeButton = customCardView;
        this.getNumberButton = customCardView2;
        this.plateNumber = textView;
        this.plateRegion = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AzArizonaPlateScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AzArizonaPlateScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.az_arizona_plate_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzArizonaPlateScreenBinding bind(View view) {
        int i = R.id.close_button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.get_number_button;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.plate_number;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.plate_region;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new AzArizonaPlateScreenBinding((FrameLayout) view, customCardView, customCardView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
