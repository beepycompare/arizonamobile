package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsPropertyBinding implements ViewBinding {
    public final TextView comercialEmpty;
    public final RecyclerView comercialRecycleView;
    public final TextView residentalEmpty;
    public final RecyclerView residentalRecycleView;
    private final ConstraintLayout rootView;
    public final LinearLayout table1;
    public final LinearLayout table2;

    private DocumentsPropertyBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, TextView textView2, RecyclerView recyclerView2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.comercialEmpty = textView;
        this.comercialRecycleView = recyclerView;
        this.residentalEmpty = textView2;
        this.residentalRecycleView = recyclerView2;
        this.table1 = linearLayout;
        this.table2 = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsPropertyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsPropertyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_property, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsPropertyBinding bind(View view) {
        int i = R.id.comercial_empty;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.comercial_recycle_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.residental_empty;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.residental_recycle_view;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView2 != null) {
                        i = R.id.table1;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.table2;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                return new DocumentsPropertyBinding((ConstraintLayout) view, textView, recyclerView, textView2, recyclerView2, linearLayout, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
