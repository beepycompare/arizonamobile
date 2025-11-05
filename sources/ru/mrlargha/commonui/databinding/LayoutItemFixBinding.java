package ru.mrlargha.commonui.databinding;

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
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
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

    private LayoutItemFixBinding(ConstraintLayout rootView, Button btnFixItem, ItemInfoCostBinding costFieldPainting, LinearLayout infoLayout, ItemInventoryBinding leftItemField, ItemWorkshopBinding mainItemField, ProgressBar progressBar, ItemInventoryBinding rightItemField, TextView tvMainItemDescription, TextView tvTitle, TextView tvTitleDescription) {
        this.rootView = rootView;
        this.btnFixItem = btnFixItem;
        this.costFieldPainting = costFieldPainting;
        this.infoLayout = infoLayout;
        this.leftItemField = leftItemField;
        this.mainItemField = mainItemField;
        this.progressBar = progressBar;
        this.rightItemField = rightItemField;
        this.tvMainItemDescription = tvMainItemDescription;
        this.tvTitle = tvTitle;
        this.tvTitleDescription = tvTitleDescription;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemFixBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutItemFixBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_item_fix, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemFixBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btnFixItem;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.costFieldPainting))) != null) {
            ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
            i = R.id.infoLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.leftItemField))) != null) {
                ItemInventoryBinding bind2 = ItemInventoryBinding.bind(findChildViewById2);
                i = R.id.mainItemField;
                View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById4 != null) {
                    ItemWorkshopBinding bind3 = ItemWorkshopBinding.bind(findChildViewById4);
                    i = R.id.progressBar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                    if (progressBar != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.rightItemField))) != null) {
                        ItemInventoryBinding bind4 = ItemInventoryBinding.bind(findChildViewById3);
                        i = R.id.tvMainItemDescription;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tvTitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tvTitleDescription;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new LayoutItemFixBinding((ConstraintLayout) rootView, button, bind, linearLayout, bind2, bind3, progressBar, bind4, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
