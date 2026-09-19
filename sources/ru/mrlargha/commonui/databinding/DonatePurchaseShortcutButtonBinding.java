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
public final class DonatePurchaseShortcutButtonBinding implements ViewBinding {
    public final ImageView ivShortcutArt;
    private final FrameLayout rootView;
    public final TextView tvShortcutLabel;

    private DonatePurchaseShortcutButtonBinding(FrameLayout rootView, ImageView ivShortcutArt, TextView tvShortcutLabel) {
        this.rootView = rootView;
        this.ivShortcutArt = ivShortcutArt;
        this.tvShortcutLabel = tvShortcutLabel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonatePurchaseShortcutButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePurchaseShortcutButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_purchase_shortcut_button, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePurchaseShortcutButtonBinding bind(View rootView) {
        int i = R.id.iv_shortcut_art;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_shortcut_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new DonatePurchaseShortcutButtonBinding((FrameLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
