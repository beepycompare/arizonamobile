package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class PausableProgressBinding implements ViewBinding {
    public final View backProgress;
    public final View frontProgress;
    public final View maxProgress;
    private final FrameLayout rootView;

    private PausableProgressBinding(FrameLayout rootView, View backProgress, View frontProgress, View maxProgress) {
        this.rootView = rootView;
        this.backProgress = backProgress;
        this.frontProgress = frontProgress;
        this.maxProgress = maxProgress;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PausableProgressBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PausableProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.pausable_progress, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static PausableProgressBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.back_progress;
        View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.front_progress))) != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.max_progress))) != null) {
            return new PausableProgressBinding((FrameLayout) rootView, findChildViewById3, findChildViewById, findChildViewById2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
