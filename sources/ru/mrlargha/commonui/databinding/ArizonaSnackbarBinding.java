package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ArizonaSnackbarBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView snackText;
    public final TextView snackTitle;
    public final AppCompatImageView snackbarBg;
    public final ConstraintLayout snackbarRootLayout;

    private ArizonaSnackbarBinding(ConstraintLayout rootView, TextView snackText, TextView snackTitle, AppCompatImageView snackbarBg, ConstraintLayout snackbarRootLayout) {
        this.rootView = rootView;
        this.snackText = snackText;
        this.snackTitle = snackTitle;
        this.snackbarBg = snackbarBg;
        this.snackbarRootLayout = snackbarRootLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaSnackbarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ArizonaSnackbarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.arizona_snackbar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaSnackbarBinding bind(View rootView) {
        int i = R.id.snack_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.snack_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.snackbar_bg;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    return new ArizonaSnackbarBinding(constraintLayout, textView, textView2, appCompatImageView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
