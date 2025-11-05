package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ConstrainLayoutTemplateBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ConstrainLayoutTemplateBinding(ConstraintLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ConstrainLayoutTemplateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ConstrainLayoutTemplateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.constrain_layout_template, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConstrainLayoutTemplateBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ConstrainLayoutTemplateBinding((ConstraintLayout) rootView);
    }
}
