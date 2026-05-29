package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class ViewUniversalMoneyInputBinding implements ViewBinding {
    public final ViewMoneyPartInputBinding etSingle;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private ViewUniversalMoneyInputBinding(FrameLayout rootView, ViewMoneyPartInputBinding etSingle, FrameLayout root) {
        this.rootView = rootView;
        this.etSingle = etSingle;
        this.root = root;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewUniversalMoneyInputBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewUniversalMoneyInputBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.view_universal_money_input, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewUniversalMoneyInputBinding bind(View rootView) {
        int i = R.id.etSingle;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            FrameLayout frameLayout = (FrameLayout) rootView;
            return new ViewUniversalMoneyInputBinding(frameLayout, ViewMoneyPartInputBinding.bind(findChildViewById), frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
