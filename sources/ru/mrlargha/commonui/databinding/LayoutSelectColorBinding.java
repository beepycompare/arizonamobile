package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutSelectColorBinding implements ViewBinding {
    public final Button btnFirstColor;
    public final Button btnSecondColor;
    public final LinearLayout linearColors;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFirstColors;
    public final RecyclerView rvSecondColors;
    public final TextView tvTitle;

    private LayoutSelectColorBinding(ConstraintLayout rootView, Button btnFirstColor, Button btnSecondColor, LinearLayout linearColors, ConstraintLayout parentLayout, RecyclerView rvFirstColors, RecyclerView rvSecondColors, TextView tvTitle) {
        this.rootView = rootView;
        this.btnFirstColor = btnFirstColor;
        this.btnSecondColor = btnSecondColor;
        this.linearColors = linearColors;
        this.parentLayout = parentLayout;
        this.rvFirstColors = rvFirstColors;
        this.rvSecondColors = rvSecondColors;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSelectColorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutSelectColorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_select_color, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutSelectColorBinding bind(View rootView) {
        int i = R.id.btnFirstColor;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnSecondColor;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null) {
                i = R.id.linearColors;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.rvFirstColors;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                    if (recyclerView != null) {
                        i = R.id.rvSecondColors;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView2 != null) {
                            i = R.id.tvTitle;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                return new LayoutSelectColorBinding(constraintLayout, button, button2, linearLayout, constraintLayout, recyclerView, recyclerView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
