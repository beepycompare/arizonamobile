package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryNothingFoundBinding implements ViewBinding {
    private final LinearLayout rootView;

    private MobileRentAccessoryNothingFoundBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryNothingFoundBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryNothingFoundBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_nothing_found, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryNothingFoundBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new MobileRentAccessoryNothingFoundBinding((LinearLayout) view);
    }
}
