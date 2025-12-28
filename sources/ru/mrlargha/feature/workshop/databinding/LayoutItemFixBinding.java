package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.databinding.ItemInfoCostBinding;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class LayoutItemFixBinding implements ViewBinding {
    public final Button btnFixItem;
    public final ItemInfoCostBinding costFieldPainting;
    public final LinearLayout infoLayout;
    public final ItemInventoryBinding leftItemField;
    public final ItemWorkshopBinding mainItemField;
    public final ProgressBar progressBar;
    public final ItemInventoryBinding rightItemField;
    private final ConstraintLayout rootView;
    public final TextView tvMainItemDescription;
    public final TextView tvTitle;
    public final TextView tvTitleDescription;

    private LayoutItemFixBinding(ConstraintLayout constraintLayout, Button button, ItemInfoCostBinding itemInfoCostBinding, LinearLayout linearLayout, ItemInventoryBinding itemInventoryBinding, ItemWorkshopBinding itemWorkshopBinding, ProgressBar progressBar, ItemInventoryBinding itemInventoryBinding2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnFixItem = button;
        this.costFieldPainting = itemInfoCostBinding;
        this.infoLayout = linearLayout;
        this.leftItemField = itemInventoryBinding;
        this.mainItemField = itemWorkshopBinding;
        this.progressBar = progressBar;
        this.rightItemField = itemInventoryBinding2;
        this.tvMainItemDescription = textView;
        this.tvTitle = textView2;
        this.tvTitleDescription = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemFixBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutItemFixBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_item_fix, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemFixBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btnFixItem;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.costFieldPainting))) != null) {
            ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
            i = R.id.infoLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.leftItemField))) != null) {
                ItemInventoryBinding bind2 = ItemInventoryBinding.bind(findChildViewById2);
                i = R.id.mainItemField;
                View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById4 != null) {
                    ItemWorkshopBinding bind3 = ItemWorkshopBinding.bind(findChildViewById4);
                    i = R.id.progressBar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.rightItemField))) != null) {
                        ItemInventoryBinding bind4 = ItemInventoryBinding.bind(findChildViewById3);
                        i = R.id.tvMainItemDescription;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tvTitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tvTitleDescription;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new LayoutItemFixBinding((ConstraintLayout) view, button, bind, linearLayout, bind2, bind3, progressBar, bind4, textView, textView2, textView3);
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
