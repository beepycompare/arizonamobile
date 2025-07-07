package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EmptyScreenBinding implements ViewBinding {
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;

    private EmptyScreenBinding(ConstraintLayout rootView, ConstraintLayout parentLayout) {
        this.rootView = rootView;
        this.parentLayout = parentLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EmptyScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EmptyScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.empty_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmptyScreenBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        return new EmptyScreenBinding(constraintLayout, constraintLayout);
    }
}
