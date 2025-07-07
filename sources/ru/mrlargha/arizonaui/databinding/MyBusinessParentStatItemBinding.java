package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyBusinessParentStatItemBinding implements ViewBinding {
    public final RecyclerView childStatRc;
    public final CardView editButton;
    public final ConstraintLayout myBusinessParentStatItem;
    private final ConstraintLayout rootView;
    public final TextView title;

    private MyBusinessParentStatItemBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, CardView cardView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.childStatRc = recyclerView;
        this.editButton = cardView;
        this.myBusinessParentStatItem = constraintLayout2;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyBusinessParentStatItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyBusinessParentStatItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_business_parent_stat_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyBusinessParentStatItemBinding bind(View view) {
        int i = R.id.child_stat_rc;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.edit_button;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new MyBusinessParentStatItemBinding(constraintLayout, recyclerView, cardView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
