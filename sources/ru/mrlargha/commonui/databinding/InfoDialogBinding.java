package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class InfoDialogBinding implements ViewBinding {
    public final ImageView btnCancel;
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final FrameLayout infoDialogLayout;
    public final TextView infoText;
    private final FrameLayout rootView;

    private InfoDialogBinding(FrameLayout rootView, ImageView btnCancel, DialogButtonsBinding buttons, TextView caption, FrameLayout infoDialogLayout, TextView infoText) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.buttons = buttons;
        this.caption = caption;
        this.infoDialogLayout = infoDialogLayout;
        this.infoText = infoText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static InfoDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InfoDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.info_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InfoDialogBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btn_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.buttons))) != null) {
            DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
            i = R.id.caption;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.infoText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new InfoDialogBinding(frameLayout, imageView, bind, textView, frameLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
