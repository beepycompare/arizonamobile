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
public final class EmploymentCenterSalaryTableBinding implements ViewBinding {
    public final ImageView ivSalaryCurrency;
    public final ImageView ivTotalCurrency;
    public final TextView money;
    private final LinearLayout rootView;
    public final RecyclerView rvInfo;
    public final TextView title;
    public final TextView total;
    public final TextView totalBonus;

    private EmploymentCenterSalaryTableBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.ivSalaryCurrency = imageView;
        this.ivTotalCurrency = imageView2;
        this.money = textView;
        this.rvInfo = recyclerView;
        this.title = textView2;
        this.total = textView3;
        this.totalBonus = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterSalaryTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterSalaryTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_salary_table, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterSalaryTableBinding bind(View view) {
        int i = R.id.iv_salary_currency;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_total_currency;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.money;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.rv_info;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.total;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.total_bonus;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new EmploymentCenterSalaryTableBinding((LinearLayout) view, imageView, imageView2, textView, recyclerView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
