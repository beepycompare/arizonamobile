package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.arizona.common.ui.KeyboardButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class BinderButtoinItemViewBinding implements ViewBinding {
    private final KeyboardButton rootView;

    private BinderButtoinItemViewBinding(KeyboardButton rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public KeyboardButton getRoot() {
        return this.rootView;
    }

    public static BinderButtoinItemViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BinderButtoinItemViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.binder_buttoin_item_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BinderButtoinItemViewBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BinderButtoinItemViewBinding((KeyboardButton) rootView);
    }
}
