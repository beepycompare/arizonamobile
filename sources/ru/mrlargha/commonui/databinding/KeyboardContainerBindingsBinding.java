package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.KeyboardButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class KeyboardContainerBindingsBinding implements ViewBinding {
    public final RecyclerView bindersList;
    private final LinearLayout rootView;
    public final KeyboardButton settingsButton;

    private KeyboardContainerBindingsBinding(LinearLayout rootView, RecyclerView bindersList, KeyboardButton settingsButton) {
        this.rootView = rootView;
        this.bindersList = bindersList;
        this.settingsButton = settingsButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardContainerBindingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardContainerBindingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_container_bindings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardContainerBindingsBinding bind(View rootView) {
        int i = R.id.binders_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
        if (recyclerView != null) {
            i = R.id.settingsButton;
            KeyboardButton keyboardButton = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
            if (keyboardButton != null) {
                return new KeyboardContainerBindingsBinding((LinearLayout) rootView, recyclerView, keyboardButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
