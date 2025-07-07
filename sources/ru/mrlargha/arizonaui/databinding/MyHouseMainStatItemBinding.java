package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MyHouseMainStatItemBinding implements ViewBinding {
    public final TextView label;
    public final ConstraintLayout labelContainer;
    public final TextView maxValue;
    public final ConstraintLayout myHouseMainStatItem;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TextView value;

    private MyHouseMainStatItemBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.label = textView;
        this.labelContainer = constraintLayout2;
        this.maxValue = textView2;
        this.myHouseMainStatItem = constraintLayout3;
        this.title = textView3;
        this.value = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MyHouseMainStatItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyHouseMainStatItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.my_house_main_stat_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MyHouseMainStatItemBinding bind(View view) {
        int i = R.id.label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.label_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.max_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.value;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            return new MyHouseMainStatItemBinding(constraintLayout2, textView, constraintLayout, textView2, constraintLayout2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
