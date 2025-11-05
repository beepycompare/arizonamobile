package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class InfoDialogBinding implements ViewBinding {
    public final DialogBackgroundBinding bg;
    public final Button button1;
    public final Button button2;
    public final TextView caption;
    public final ConstraintLayout infoDialogLayout;
    public final TextView infoText;
    private final ConstraintLayout rootView;

    private InfoDialogBinding(ConstraintLayout rootView, DialogBackgroundBinding bg, Button button1, Button button2, TextView caption, ConstraintLayout infoDialogLayout, TextView infoText) {
        this.rootView = rootView;
        this.bg = bg;
        this.button1 = button1;
        this.button2 = button2;
        this.caption = caption;
        this.infoDialogLayout = infoDialogLayout;
        this.infoText = infoText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
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
                            return new InfoDialogBinding(constraintLayout, bind, button, button2, textView, constraintLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
