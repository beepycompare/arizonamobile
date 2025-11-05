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

    private LayoutItemSharpBinding(ConstraintLayout rootView, Button btnSharpenItem, ItemInfoCostBinding costField, LinearLayout infoLayout, ItemInventoryBinding leftItemField, ItemWorkshopBinding mainItemField, ProgressBar progressBar, ItemInventoryBinding rightItemField, ItemInfoCostBinding successChanceField, TextView tvEndCount, TextView tvLeftItemDescription, TextView tvMainItemDescription, TextView tvRightItemDescription, TextView tvStartCount, TextView tvTitle, TextView tvTitleDescription) {
        this.rootView = rootView;
        this.btnSharpenItem = btnSharpenItem;
        this.costField = costField;
        this.infoLayout = infoLayout;
        this.leftItemField = leftItemField;
        this.mainItemField = mainItemField;
        this.progressBar = progressBar;
        this.rightItemField = rightItemField;
        this.successChanceField = successChanceField;
        this.tvEndCount = tvEndCount;
        this.tvLeftItemDescription = tvLeftItemDescription;
        this.tvMainItemDescription = tvMainItemDescription;
        this.tvRightItemDescription = tvRightItemDescription;
        this.tvStartCount = tvStartCount;
        this.tvTitle = tvTitle;
        this.tvTitleDescription = tvTitleDescription;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemSharpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutItemSharpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_item_sharp, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemSharpBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btnSharpenItem;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.costField))) != null) {
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
                        i = R.id.successChanceField;
                        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById5 != null) {
                            ItemInfoCostBinding bind5 = ItemInfoCostBinding.bind(findChildViewById5);
                            i = R.id.tvEndCount;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvLeftItemDescription;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvMainItemDescription;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tvRightItemDescription;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.tvStartCount;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.tvTitle;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView6 != null) {
                                                    i = R.id.tvTitleDescription;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView7 != null) {
                                                        return new LayoutItemSharpBinding((ConstraintLayout) rootView, button, bind, linearLayout, bind2, bind3, progressBar, bind4, bind5, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
