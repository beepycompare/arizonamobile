package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DialogButtonsBinding implements ViewBinding {
    public final CustomCardView button1;
    public final CustomCardView button2;
    private final LinearLayout rootView;
    public final TextView tvAccept;
    public final TextView tvCancel;

    private DialogButtonsBinding(LinearLayout rootView, CustomCardView button1, CustomCardView button2, TextView tvAccept, TextView tvCancel) {
        this.rootView = rootView;
        this.button1 = button1;
        this.button2 = button2;
        this.tvAccept = tvAccept;
        this.tvCancel = tvCancel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogButtonsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogButtonsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_buttons, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogButtonsBinding bind(View rootView) {
        int i = R.id.button1;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.button2;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView2 != null) {
                i = R.id.tv_accept;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_cancel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new DialogButtonsBinding((LinearLayout) rootView, customCardView, customCardView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
