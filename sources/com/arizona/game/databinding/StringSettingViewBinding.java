package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes3.dex */
public final class StringSettingViewBinding implements ViewBinding {
    public final TextInputEditText inputEditText;
    public final TextInputLayout inputLayout;
    private final TextInputLayout rootView;

    private StringSettingViewBinding(TextInputLayout rootView, TextInputEditText inputEditText, TextInputLayout inputLayout) {
        this.rootView = rootView;
        this.inputEditText = inputEditText;
        this.inputLayout = inputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextInputLayout getRoot() {
        return this.rootView;
    }

    public static StringSettingViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static StringSettingViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.string_setting_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static StringSettingViewBinding bind(View rootView) {
        int i = R.id.input_edit_text;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
        if (textInputEditText != null) {
            TextInputLayout textInputLayout = (TextInputLayout) rootView;
            return new StringSettingViewBinding(textInputLayout, textInputEditText, textInputLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
