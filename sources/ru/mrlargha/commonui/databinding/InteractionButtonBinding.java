package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class InteractionButtonBinding implements ViewBinding {
    public final MaterialButton interaction;
    private final MaterialButton rootView;

    private InteractionButtonBinding(MaterialButton rootView, MaterialButton interaction) {
        this.rootView = rootView;
        this.interaction = interaction;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialButton getRoot() {
        return this.rootView;
    }

    public static InteractionButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InteractionButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.interaction_button, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InteractionButtonBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        MaterialButton materialButton = (MaterialButton) rootView;
        return new InteractionButtonBinding(materialButton, materialButton);
    }
}
