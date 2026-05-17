package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudCounterDeliveryGiftsBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvFirst;
    public final TextView tvSecond;

    private HudCounterDeliveryGiftsBinding(FrameLayout rootView, TextView tvFirst, TextView tvSecond) {
        this.rootView = rootView;
        this.tvFirst = tvFirst;
        this.tvSecond = tvSecond;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCounterDeliveryGiftsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterDeliveryGiftsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter_delivery_gifts, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterDeliveryGiftsBinding bind(View rootView) {
        int i = R.id.tv_first;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_second;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new HudCounterDeliveryGiftsBinding((FrameLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
