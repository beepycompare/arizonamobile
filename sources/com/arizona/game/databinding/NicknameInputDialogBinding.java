package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes3.dex */
public final class NicknameInputDialogBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final ImageView imageView45;
    public final ImageView imageView46;
    public final TextInputEditText inputEditText;
    public final TextInputLayout inputLayout;
    private final ConstraintLayout rootView;
    public final MaterialButton startGameButton;
    public final TextView textView55;

    private NicknameInputDialogBinding(ConstraintLayout rootView, MaterialButton cancelButton, ImageView imageView45, ImageView imageView46, TextInputEditText inputEditText, TextInputLayout inputLayout, MaterialButton startGameButton, TextView textView55) {
        this.rootView = rootView;
        this.cancelButton = cancelButton;
        this.imageView45 = imageView45;
        this.imageView46 = imageView46;
        this.inputEditText = inputEditText;
        this.inputLayout = inputLayout;
        this.startGameButton = startGameButton;
        this.textView55 = textView55;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NicknameInputDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NicknameInputDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.nickname_input_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static NicknameInputDialogBinding bind(View rootView) {
        int i = R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.imageView45;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.imageView46;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.input_edit_text;
                    TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
                    if (textInputEditText != null) {
                        i = R.id.input_layout;
                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                        if (textInputLayout != null) {
                            i = R.id.start_game_button;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                            if (materialButton2 != null) {
                                i = R.id.textView55;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    return new NicknameInputDialogBinding((ConstraintLayout) rootView, materialButton, imageView, imageView2, textInputEditText, textInputLayout, materialButton2, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
