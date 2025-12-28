package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.databinding.ItemInfoCostBinding;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class LayoutItemPaintBinding implements ViewBinding {
    public final Button btnPaintItem;
    public final ItemInfoCostBinding costFieldPainting;
    public final LinearLayout infoLayout;
    public final ItemInventoryBinding leftItemField;
    public final ItemWorkshopBinding mainItemField;
    public final ItemInventoryBinding rightItemField;
    private final ConstraintLayout rootView;
    public final RecyclerView rvColors;
    public final TextView tvLeftItemDescription;
    public final TextView tvMainItemDescription;
    public final TextView tvRightItemDescription;
    public final TextView tvTitle;
    public final TextView tvTitleDescription;

    private LayoutItemPaintBinding(ConstraintLayout constraintLayout, Button button, ItemInfoCostBinding itemInfoCostBinding, LinearLayout linearLayout, ItemInventoryBinding itemInventoryBinding, ItemWorkshopBinding itemWorkshopBinding, ItemInventoryBinding itemInventoryBinding2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnPaintItem = button;
        this.costFieldPainting = itemInfoCostBinding;
        this.infoLayout = linearLayout;
        this.leftItemField = itemInventoryBinding;
        this.mainItemField = itemWorkshopBinding;
        this.rightItemField = itemInventoryBinding2;
        this.rvColors = recyclerView;
        this.tvLeftItemDescription = textView;
        this.tvMainItemDescription = textView2;
        this.tvRightItemDescription = textView3;
        this.tvTitle = textView4;
        this.tvTitleDescription = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemPaintBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutItemPaintBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_item_paint, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemPaintBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.btnPaintItem;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.costFieldPainting))) != null) {
            ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
            i = R.id.infoLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.leftItemField))) != null) {
                ItemInventoryBinding bind2 = ItemInventoryBinding.bind(findChildViewById2);
                i = R.id.mainItemField;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById3 != null) {
                    ItemWorkshopBinding bind3 = ItemWorkshopBinding.bind(findChildViewById3);
                    i = R.id.rightItemField;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById4 != null) {
                        ItemInventoryBinding bind4 = ItemInventoryBinding.bind(findChildViewById4);
                        i = R.id.rvColors;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.tvLeftItemDescription;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tvMainItemDescription;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tvRightItemDescription;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tvTitle;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tvTitleDescription;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new LayoutItemPaintBinding((ConstraintLayout) view, button, bind, linearLayout, bind2, bind3, bind4, recyclerView, textView, textView2, textView3, textView4, textView5);
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
