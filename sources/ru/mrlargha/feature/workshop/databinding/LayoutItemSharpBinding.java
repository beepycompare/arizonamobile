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
public final class LayoutItemSharpBinding implements ViewBinding {
    public final Button btnSharpenItem;
    public final ItemInfoCostBinding costField;
    public final LinearLayout infoLayout;
    public final ItemInventoryBinding leftItemField;
    public final ItemWorkshopBinding mainItemField;
    public final ProgressBar progressBar;
    public final ItemInventoryBinding rightItemField;
    private final ConstraintLayout rootView;
    public final ItemInfoCostBinding successChanceField;
    public final TextView tvEndCount;
    public final TextView tvLeftItemDescription;
    public final TextView tvMainItemDescription;
    public final TextView tvRightItemDescription;
    public final TextView tvStartCount;
    public final TextView tvTitle;
    public final TextView tvTitleDescription;

    private LayoutItemSharpBinding(ConstraintLayout constraintLayout, Button button, ItemInfoCostBinding itemInfoCostBinding, LinearLayout linearLayout, ItemInventoryBinding itemInventoryBinding, ItemWorkshopBinding itemWorkshopBinding, ProgressBar progressBar, ItemInventoryBinding itemInventoryBinding2, ItemInfoCostBinding itemInfoCostBinding2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btnSharpenItem = button;
        this.costField = itemInfoCostBinding;
        this.infoLayout = linearLayout;
        this.leftItemField = itemInventoryBinding;
        this.mainItemField = itemWorkshopBinding;
        this.progressBar = progressBar;
        this.rightItemField = itemInventoryBinding2;
        this.successChanceField = itemInfoCostBinding2;
        this.tvEndCount = textView;
        this.tvLeftItemDescription = textView2;
        this.tvMainItemDescription = textView3;
        this.tvRightItemDescription = textView4;
        this.tvStartCount = textView5;
        this.tvTitle = textView6;
        this.tvTitleDescription = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemSharpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutItemSharpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_item_sharp, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemSharpBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btnSharpenItem;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.costField))) != null) {
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
                        i = R.id.successChanceField;
                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById5 != null) {
                            ItemInfoCostBinding bind5 = ItemInfoCostBinding.bind(findChildViewById5);
                            i = R.id.tvEndCount;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tvLeftItemDescription;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tvMainItemDescription;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tvRightItemDescription;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tvStartCount;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.tvTitle;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.tvTitleDescription;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        return new LayoutItemSharpBinding((ConstraintLayout) view, button, bind, linearLayout, bind2, bind3, progressBar, bind4, bind5, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
