package ru.mrlargha.commonui.databinding;

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
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
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

    private LayoutItemPaintBinding(ConstraintLayout rootView, Button btnPaintItem, ItemInfoCostBinding costFieldPainting, LinearLayout infoLayout, ItemInventoryBinding leftItemField, ItemWorkshopBinding mainItemField, ItemInventoryBinding rightItemField, RecyclerView rvColors, TextView tvLeftItemDescription, TextView tvMainItemDescription, TextView tvRightItemDescription, TextView tvTitle, TextView tvTitleDescription) {
        this.rootView = rootView;
        this.btnPaintItem = btnPaintItem;
        this.costFieldPainting = costFieldPainting;
        this.infoLayout = infoLayout;
        this.leftItemField = leftItemField;
        this.mainItemField = mainItemField;
        this.rightItemField = rightItemField;
        this.rvColors = rvColors;
        this.tvLeftItemDescription = tvLeftItemDescription;
        this.tvMainItemDescription = tvMainItemDescription;
        this.tvRightItemDescription = tvRightItemDescription;
        this.tvTitle = tvTitle;
        this.tvTitleDescription = tvTitleDescription;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemPaintBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutItemPaintBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_item_paint, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemPaintBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.btnPaintItem;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.costFieldPainting))) != null) {
            ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
            i = R.id.infoLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.leftItemField))) != null) {
                ItemInventoryBinding bind2 = ItemInventoryBinding.bind(findChildViewById2);
                i = R.id.mainItemField;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    ItemWorkshopBinding bind3 = ItemWorkshopBinding.bind(findChildViewById3);
                    i = R.id.rightItemField;
                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById4 != null) {
                        ItemInventoryBinding bind4 = ItemInventoryBinding.bind(findChildViewById4);
                        i = R.id.rvColors;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.tvLeftItemDescription;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvMainItemDescription;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvRightItemDescription;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tvTitle;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.tvTitleDescription;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                return new LayoutItemPaintBinding((ConstraintLayout) rootView, button, bind, linearLayout, bind2, bind3, bind4, recyclerView, textView, textView2, textView3, textView4, textView5);
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
