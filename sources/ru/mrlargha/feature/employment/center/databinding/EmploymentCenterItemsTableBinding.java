package ru.mrlargha.feature.employment.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.employment.center.R;
/* loaded from: classes6.dex */
public final class EmploymentCenterItemsTableBinding implements ViewBinding {
    public final ImageView close;
    private final LinearLayout rootView;
    public final RecyclerView rvInfo;
    public final TextView title;

    private EmploymentCenterItemsTableBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.close = imageView;
        this.rvInfo = recyclerView;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterItemsTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterItemsTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_items_table, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterItemsTableBinding bind(View view) {
        int i = R.id.close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.rv_info;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new EmploymentCenterItemsTableBinding((LinearLayout) view, imageView, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
