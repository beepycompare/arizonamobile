package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class DialogListBinding implements ViewBinding {
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final LinearLayout captionContainer;
    private final FrameLayout rootView;

    private DialogListBinding(FrameLayout rootView, DialogButtonsBinding buttons, TextView caption, LinearLayout captionContainer) {
        this.rootView = rootView;
        this.buttons = buttons;
        this.caption = caption;
        this.captionContainer = captionContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogListBinding bind(View rootView) {
        int i = R.id.buttons;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
            int i2 = R.id.caption;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i2);
            if (textView != null) {
                i2 = R.id.caption_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i2);
                if (linearLayout != null) {
                    return new DialogListBinding((FrameLayout) rootView, bind, textView, linearLayout);
                }
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
