package ru.mrlargha.feature.selector.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.selector.R;
/* loaded from: classes6.dex */
public final class SelectorIndicatorItemBinding implements ViewBinding {
    public final CustomCardView indicator;
    private final CustomCardView rootView;

    private SelectorIndicatorItemBinding(CustomCardView customCardView, CustomCardView customCardView2) {
        this.rootView = customCardView;
        this.indicator = customCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static SelectorIndicatorItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectorIndicatorItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.selector_indicator_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectorIndicatorItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        CustomCardView customCardView = (CustomCardView) view;
        return new SelectorIndicatorItemBinding(customCardView, customCardView);
    }
}
