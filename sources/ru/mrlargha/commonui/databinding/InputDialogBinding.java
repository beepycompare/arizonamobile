package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
/* loaded from: classes3.dex */
public final class InputDialogBinding implements ViewBinding {
    public final CustomCardView btnEmoji;
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final FrameLayout infoDialogLayout;
    public final TextView infoText;
    public final CustomCardView inputContainer;
    private final FrameLayout rootView;
    public final TextInputLayout textInputLayout;
    public final CustomEditText userInput;

    private InputDialogBinding(FrameLayout rootView, CustomCardView btnEmoji, DialogButtonsBinding buttons, TextView caption, FrameLayout infoDialogLayout, TextView infoText, CustomCardView inputContainer, TextInputLayout textInputLayout, CustomEditText userInput) {
        this.rootView = rootView;
        this.btnEmoji = btnEmoji;
        this.buttons = buttons;
        this.caption = caption;
        this.infoDialogLayout = infoDialogLayout;
        this.infoText = infoText;
        this.inputContainer = inputContainer;
        this.textInputLayout = textInputLayout;
        this.userInput = userInput;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
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
        View findChildViewById;
        int i = R.id.btn_emoji;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.buttons))) != null) {
            DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
            i = R.id.caption;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.infoText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.input_container;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.textInputLayout;
                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                        if (textInputLayout != null) {
                            i = R.id.user_input;
                            CustomEditText customEditText = (CustomEditText) ViewBindings.findChildViewById(rootView, i);
                            if (customEditText != null) {
                                return new InputDialogBinding(frameLayout, customCardView, bind, textView, frameLayout, textView2, customCardView2, textInputLayout, customEditText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
