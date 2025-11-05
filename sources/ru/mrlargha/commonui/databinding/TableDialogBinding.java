package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class TableDialogBinding implements ViewBinding {
    public final DialogBackgroundBinding bg;
    public final Button button1;
    public final Button button2;
    public final TextView caption;
    public final Guideline guideline3;
    public final Guideline guideline4;
    public final ConstraintLayout infoDialogLayout;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private TableDialogBinding(ConstraintLayout rootView, DialogBackgroundBinding bg, Button button1, Button button2, TextView caption, Guideline guideline3, Guideline guideline4, ConstraintLayout infoDialogLayout, RecyclerView recyclerView) {
        this.rootView = rootView;
        this.bg = bg;
        this.button1 = button1;
        this.button2 = button2;
        this.caption = caption;
        this.guideline3 = guideline3;
        this.guideline4 = guideline4;
        this.infoDialogLayout = infoDialogLayout;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TableDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TableDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.table_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TableDialogBinding bind(View rootView) {
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
                        i = R.id.guideline3;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline != null) {
                            i = R.id.guideline4;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.recyclerView;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    return new TableDialogBinding(constraintLayout, bind, button, button2, textView, guideline, guideline2, constraintLayout, recyclerView);
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
