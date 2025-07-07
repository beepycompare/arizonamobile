package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class BpEventChoiceLayoutBinding implements ViewBinding {
    public final ConstraintLayout documents;
    private final ConstraintLayout rootView;

    private BpEventChoiceLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.documents = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BpEventChoiceLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BpEventChoiceLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bp_event_choice_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BpEventChoiceLayoutBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new BpEventChoiceLayoutBinding(constraintLayout, constraintLayout);
    }
}
