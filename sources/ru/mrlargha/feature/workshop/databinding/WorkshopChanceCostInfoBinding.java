package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.databinding.ItemInfoCostBinding;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class WorkshopChanceCostInfoBinding implements ViewBinding {
    public final ItemInfoCostBinding costField;
    public final LinearLayout layoutFields;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final ItemInfoCostBinding successChanceField;
    public final TextView tvEndCount;
    public final TextView tvStartCount;

    private WorkshopChanceCostInfoBinding(LinearLayout linearLayout, ItemInfoCostBinding itemInfoCostBinding, LinearLayout linearLayout2, ProgressBar progressBar, ItemInfoCostBinding itemInfoCostBinding2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.costField = itemInfoCostBinding;
        this.layoutFields = linearLayout2;
        this.progressBar = progressBar;
        this.successChanceField = itemInfoCostBinding2;
        this.tvEndCount = textView;
        this.tvStartCount = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WorkshopChanceCostInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WorkshopChanceCostInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.workshop_chance_cost_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WorkshopChanceCostInfoBinding bind(View view) {
        View findChildViewById;
        int i = R.id.costField;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById2);
            i = R.id.layoutFields;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.progressBar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.successChanceField))) != null) {
                    ItemInfoCostBinding bind2 = ItemInfoCostBinding.bind(findChildViewById);
                    i = R.id.tvEndCount;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tvStartCount;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new WorkshopChanceCostInfoBinding((LinearLayout) view, bind, linearLayout, progressBar, bind2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
