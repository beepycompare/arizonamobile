package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText;
/* loaded from: classes6.dex */
public final class InputPopupBinding implements ViewBinding {
    public final ConstraintLayout layout;
    public final LinearLayout mainInput;
    public final MaterialButton okButton;
    public final AppCompatImageButton passwordToggle;
    private final ConstraintLayout rootView;
    public final KeyboardEditText textInput;

    private InputPopupBinding(ConstraintLayout rootView, ConstraintLayout layout, LinearLayout mainInput, MaterialButton okButton, AppCompatImageButton passwordToggle, KeyboardEditText textInput) {
        this.rootView = rootView;
        this.layout = layout;
        this.mainInput = mainInput;
        this.okButton = okButton;
        this.passwordToggle = passwordToggle;
        this.textInput = textInput;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InputPopupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InputPopupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.input_popup, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InputPopupBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.main_input;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.ok_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
            if (materialButton != null) {
                i = R.id.password_toggle;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageButton != null) {
                    i = R.id.text_input;
                    KeyboardEditText keyboardEditText = (KeyboardEditText) ViewBindings.findChildViewById(rootView, i);
                    if (keyboardEditText != null) {
                        return new InputPopupBinding(constraintLayout, constraintLayout, linearLayout, materialButton, appCompatImageButton, keyboardEditText);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
