package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyHouseParentStatItemBinding implements ViewBinding {
    public final RecyclerView childStatRc;
    public final ConstraintLayout myHouseParentStatItem;
    private final ConstraintLayout rootView;
    public final TextView title;

    private MyHouseParentStatItemBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.childStatRc = recyclerView;
        this.myHouseParentStatItem = constraintLayout2;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyHouseParentStatItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyHouseParentStatItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_house_parent_stat_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyHouseParentStatItemBinding bind(View view) {
        int i = R.id.child_stat_rc;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new MyHouseParentStatItemBinding(constraintLayout, recyclerView, constraintLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
