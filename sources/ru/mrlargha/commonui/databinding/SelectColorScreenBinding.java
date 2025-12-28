package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class SelectColorScreenBinding implements ViewBinding {
    public final ImageView btnBack;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMainInventory;
    public final TextView tvTitle;
    public final ImageView viewLine;

    private SelectColorScreenBinding(ConstraintLayout rootView, ImageView btnBack, RecyclerView rvMainInventory, TextView tvTitle, ImageView viewLine) {
        this.rootView = rootView;
        this.btnBack = btnBack;
        this.rvMainInventory = rvMainInventory;
        this.tvTitle = tvTitle;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectColorScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelectColorScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.select_color_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectColorScreenBinding bind(View rootView) {
        int i = R.id.btnBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.rvMainInventory;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                i = R.id.tvTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.viewLine;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        return new SelectColorScreenBinding((ConstraintLayout) rootView, imageView, recyclerView, textView, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
