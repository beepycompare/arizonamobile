package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BindViewBinding implements ViewBinding {
    private final MaterialButton rootView;

    private BindViewBinding(MaterialButton rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialButton getRoot() {
        return this.rootView;
    }

    public static BindViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BindViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bind_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BindViewBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BindViewBinding((MaterialButton) rootView);
    }
}
