package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.radial_menu.PieSelector;
/* loaded from: classes5.dex */
public final class SelectorElementBinding implements ViewBinding {
    public final ConstraintLayout layout;
    public final PieSelector pie;
    private final ConstraintLayout rootView;

    private SelectorElementBinding(ConstraintLayout rootView, ConstraintLayout layout, PieSelector pie) {
        this.rootView = rootView;
        this.layout = layout;
        this.pie = pie;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectorElementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelectorElementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.selector_element, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectorElementBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.pie;
        PieSelector pieSelector = (PieSelector) ViewBindings.findChildViewById(rootView, i);
        if (pieSelector != null) {
            return new SelectorElementBinding(constraintLayout, constraintLayout, pieSelector);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
