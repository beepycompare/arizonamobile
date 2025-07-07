package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class InputDialogBinding implements ViewBinding {
    public final DialogBackgroundBinding bg;
    public final Button button1;
    public final Button button2;
    public final TextView caption;
    public final ConstraintLayout infoDialogLayout;
    public final TextView infoText;
    private final ConstraintLayout rootView;
    public final TextInputLayout textInputLayout;
    public final TextInputEditText userInput;

    private InputDialogBinding(ConstraintLayout rootView, DialogBackgroundBinding bg, Button button1, Button button2, TextView caption, ConstraintLayout infoDialogLayout, TextView infoText, TextInputLayout textInputLayout, TextInputEditText userInput) {
        this.rootView = rootView;
        this.bg = bg;
        this.button1 = button1;
        this.button2 = button2;
        this.caption = caption;
        this.infoDialogLayout = infoDialogLayout;
        this.infoText = infoText;
        this.textInputLayout = textInputLayout;
        this.userInput = userInput;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InputDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InputDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.input_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InputDialogBinding bind(View rootView) {
        int i = R.id.bg;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            DialogBackgroundBinding bind = DialogBackgroundBinding.bind(findChildViewById);
            i = R.id.button1;
            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button != null) {
                i = R.id.button2;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button2 != null) {
                    i = R.id.caption;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        i = R.id.infoText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.textInputLayout;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                            if (textInputLayout != null) {
                                i = R.id.user_input;
                                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
                                if (textInputEditText != null) {
                                    return new InputDialogBinding(constraintLayout, bind, button, button2, textView, constraintLayout, textView2, textInputLayout, textInputEditText);
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
