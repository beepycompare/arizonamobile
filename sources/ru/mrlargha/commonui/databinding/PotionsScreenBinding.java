package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class PotionsScreenBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final Button btnPaintItem;
    public final Button btnSharpenItem;
    public final ItemInfoCostBinding costField;
    public final ItemInfoCostBinding costFieldPainting;
    public final Group groupWorkbench;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineHor3;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer4;
    public final ImageView ivBgSharpResult;
    public final LinearLayout layoutFields;
    public final ItemInventoryBinding leftItemField;
    public final ItemWorkshopBinding mainItemField;
    public final ConstraintLayout parentLayout;
    public final ProgressBar progressBar;
    public final ItemInventoryBinding rightItemField;
    private final ConstraintLayout rootView;
    public final RecyclerView rvColors;
    public final RecyclerView rvMainInventory;
    public final ItemInfoCostBinding successChanceField;
    public final TextView tvEndCount;
    public final TextView tvLeftItemDescription;
    public final TextView tvMainItemDescription;
    public final TextView tvRightItemDescription;
    public final TextView tvScreenTitle;
    public final TextView tvStartCount;
    public final TextView tvTitle;
    public final TextView tvTitleDescription;
    public final ImageView viewLine;

    private PotionsScreenBinding(ConstraintLayout rootView, AppCompatImageView btnBack, Button btnPaintItem, Button btnSharpenItem, ItemInfoCostBinding costField, ItemInfoCostBinding costFieldPainting, Group groupWorkbench, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineHor3, Guideline guidelineVer1, Guideline guidelineVer2, Guideline guidelineVer4, ImageView ivBgSharpResult, LinearLayout layoutFields, ItemInventoryBinding leftItemField, ItemWorkshopBinding mainItemField, ConstraintLayout parentLayout, ProgressBar progressBar, ItemInventoryBinding rightItemField, RecyclerView rvColors, RecyclerView rvMainInventory, ItemInfoCostBinding successChanceField, TextView tvEndCount, TextView tvLeftItemDescription, TextView tvMainItemDescription, TextView tvRightItemDescription, TextView tvScreenTitle, TextView tvStartCount, TextView tvTitle, TextView tvTitleDescription, ImageView viewLine) {
        this.rootView = rootView;
        this.btnBack = btnBack;
        this.btnPaintItem = btnPaintItem;
        this.btnSharpenItem = btnSharpenItem;
        this.costField = costField;
        this.costFieldPainting = costFieldPainting;
        this.groupWorkbench = groupWorkbench;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineHor3 = guidelineHor3;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.guidelineVer4 = guidelineVer4;
        this.ivBgSharpResult = ivBgSharpResult;
        this.layoutFields = layoutFields;
        this.leftItemField = leftItemField;
        this.mainItemField = mainItemField;
        this.parentLayout = parentLayout;
        this.progressBar = progressBar;
        this.rightItemField = rightItemField;
        this.rvColors = rvColors;
        this.rvMainInventory = rvMainInventory;
        this.successChanceField = successChanceField;
        this.tvEndCount = tvEndCount;
        this.tvLeftItemDescription = tvLeftItemDescription;
        this.tvMainItemDescription = tvMainItemDescription;
        this.tvRightItemDescription = tvRightItemDescription;
        this.tvScreenTitle = tvScreenTitle;
        this.tvStartCount = tvStartCount;
        this.tvTitle = tvTitle;
        this.tvTitleDescription = tvTitleDescription;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PotionsScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PotionsScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.potions_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static PotionsScreenBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        int i = R.id.btnBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.btnPaintItem;
            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button != null) {
                i = R.id.btnSharpenItem;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.costField))) != null) {
                    ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
                    i = R.id.costFieldPainting;
                    View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById5 != null) {
                        ItemInfoCostBinding bind2 = ItemInfoCostBinding.bind(findChildViewById5);
                        i = R.id.groupWorkbench;
                        Group group = (Group) ViewBindings.findChildViewById(rootView, i);
                        if (group != null) {
                            i = R.id.guidelineHor1;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline != null) {
                                i = R.id.guidelineHor2;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline2 != null) {
                                    i = R.id.guidelineHor3;
                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline3 != null) {
                                        i = R.id.guidelineVer1;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline4 != null) {
                                            i = R.id.guidelineVer2;
                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline5 != null) {
                                                i = R.id.guidelineVer4;
                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline6 != null) {
                                                    i = R.id.ivBgSharpResult;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView != null) {
                                                        i = R.id.layoutFields;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.leftItemField))) != null) {
                                                            ItemInventoryBinding bind3 = ItemInventoryBinding.bind(findChildViewById2);
                                                            i = R.id.mainItemField;
                                                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById6 != null) {
                                                                ItemWorkshopBinding bind4 = ItemWorkshopBinding.bind(findChildViewById6);
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                                i = R.id.progressBar;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                                if (progressBar != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.rightItemField))) != null) {
                                                                    ItemInventoryBinding bind5 = ItemInventoryBinding.bind(findChildViewById3);
                                                                    i = R.id.rvColors;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.rvMainInventory;
                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (recyclerView2 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.successChanceField))) != null) {
                                                                            ItemInfoCostBinding bind6 = ItemInfoCostBinding.bind(findChildViewById4);
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
                                                                                            i = R.id.tvScreenTitle;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.tvStartCount;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.tvTitle;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.tvTitleDescription;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.viewLine;
                                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (imageView2 != null) {
                                                                                                                return new PotionsScreenBinding(constraintLayout, appCompatImageView, button, button2, bind, bind2, group, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, imageView, linearLayout, bind3, bind4, constraintLayout, progressBar, bind5, recyclerView, recyclerView2, bind6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, imageView2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
