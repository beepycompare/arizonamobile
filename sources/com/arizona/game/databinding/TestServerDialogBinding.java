package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes3.dex */
public final class TestServerDialogBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextInputEditText serverAddressInput;
    public final TextInputEditText serverPasswordInput;
    public final TextInputEditText serverPortInput;
    public final Button testServerDialogCancelButton;
    public final Button testServerDialogConnectButton;
    public final TextInputLayout textInputLayout2;
    public final TextInputLayout textInputLayout3;
    public final TextInputLayout textInputLayout4;
    public final TextView textView12;

    private TestServerDialogBinding(ConstraintLayout rootView, TextInputEditText serverAddressInput, TextInputEditText serverPasswordInput, TextInputEditText serverPortInput, Button testServerDialogCancelButton, Button testServerDialogConnectButton, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4, TextView textView12) {
        this.rootView = rootView;
        this.serverAddressInput = serverAddressInput;
        this.serverPasswordInput = serverPasswordInput;
        this.serverPortInput = serverPortInput;
        this.testServerDialogCancelButton = testServerDialogCancelButton;
        this.testServerDialogConnectButton = testServerDialogConnectButton;
        this.textInputLayout2 = textInputLayout2;
        this.textInputLayout3 = textInputLayout3;
        this.textInputLayout4 = textInputLayout4;
        this.textView12 = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TestServerDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TestServerDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.test_server_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TestServerDialogBinding bind(View rootView) {
        int i = R.id.server_address_input;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
        if (textInputEditText != null) {
            i = R.id.server_password_input;
            TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
            if (textInputEditText2 != null) {
                i = R.id.server_port_input;
                TextInputEditText textInputEditText3 = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
                if (textInputEditText3 != null) {
                    i = R.id.test_server_dialog_cancel_button;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                    if (button != null) {
                        i = R.id.test_server_dialog_connect_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                        if (button2 != null) {
                            i = R.id.textInputLayout2;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                            if (textInputLayout != null) {
                                i = R.id.textInputLayout3;
                                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                                if (textInputLayout2 != null) {
                                    i = R.id.textInputLayout4;
                                    TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (textInputLayout3 != null) {
                                        i = R.id.textView12;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            return new TestServerDialogBinding((ConstraintLayout) rootView, textInputEditText, textInputEditText2, textInputEditText3, button, button2, textInputLayout, textInputLayout2, textInputLayout3, textView);
                                        }
                                    }
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
