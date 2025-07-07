package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateExchangeItemBinding implements ViewBinding {
    private final FrameLayout rootView;

    private DonateExchangeItemBinding(FrameLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateExchangeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateExchangeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_exchange_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateExchangeItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new DonateExchangeItemBinding((FrameLayout) rootView);
    }
}
