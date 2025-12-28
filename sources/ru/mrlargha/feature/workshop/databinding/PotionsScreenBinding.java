package ru.mrlargha.feature.workshop.databinding;

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
import ru.mrlargha.commonui.databinding.ItemInfoCostBinding;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
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

    private PotionsScreenBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, Button button, Button button2, ItemInfoCostBinding itemInfoCostBinding, ItemInfoCostBinding itemInfoCostBinding2, Group group, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, ImageView imageView, LinearLayout linearLayout, ItemInventoryBinding itemInventoryBinding, ItemWorkshopBinding itemWorkshopBinding, ConstraintLayout constraintLayout2, ProgressBar progressBar, ItemInventoryBinding itemInventoryBinding2, RecyclerView recyclerView, RecyclerView recyclerView2, ItemInfoCostBinding itemInfoCostBinding3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.btnBack = appCompatImageView;
        this.btnPaintItem = button;
        this.btnSharpenItem = button2;
        this.costField = itemInfoCostBinding;
        this.costFieldPainting = itemInfoCostBinding2;
        this.groupWorkbench = group;
        this.guidelineHor1 = guideline;
        this.guidelineHor2 = guideline2;
        this.guidelineHor3 = guideline3;
        this.guidelineVer1 = guideline4;
        this.guidelineVer2 = guideline5;
        this.guidelineVer4 = guideline6;
        this.ivBgSharpResult = imageView;
        this.layoutFields = linearLayout;
        this.leftItemField = itemInventoryBinding;
        this.mainItemField = itemWorkshopBinding;
        this.parentLayout = constraintLayout2;
        this.progressBar = progressBar;
        this.rightItemField = itemInventoryBinding2;
        this.rvColors = recyclerView;
        this.rvMainInventory = recyclerView2;
        this.successChanceField = itemInfoCostBinding3;
        this.tvEndCount = textView;
        this.tvLeftItemDescription = textView2;
        this.tvMainItemDescription = textView3;
        this.tvRightItemDescription = textView4;
        this.tvScreenTitle = textView5;
        this.tvStartCount = textView6;
        this.tvTitle = textView7;
        this.tvTitleDescription = textView8;
        this.viewLine = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PotionsScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PotionsScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.potions_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PotionsScreenBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        int i = R.id.btnBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.btnPaintItem;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.btnSharpenItem;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.costField))) != null) {
                    ItemInfoCostBinding bind = ItemInfoCostBinding.bind(findChildViewById);
                    i = R.id.costFieldPainting;
                    View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById5 != null) {
                        ItemInfoCostBinding bind2 = ItemInfoCostBinding.bind(findChildViewById5);
                        i = R.id.groupWorkbench;
                        Group group = (Group) ViewBindings.findChildViewById(view, i);
                        if (group != null) {
                            i = R.id.guidelineHor1;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                i = R.id.guidelineHor2;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    i = R.id.guidelineHor3;
                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline3 != null) {
                                        i = R.id.guidelineVer1;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline4 != null) {
                                            i = R.id.guidelineVer2;
                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline5 != null) {
                                                i = R.id.guidelineVer4;
                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline6 != null) {
                                                    i = R.id.ivBgSharpResult;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = R.id.layoutFields;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.leftItemField))) != null) {
                                                            ItemInventoryBinding bind3 = ItemInventoryBinding.bind(findChildViewById2);
                                                            i = R.id.mainItemField;
                                                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                                            if (findChildViewById6 != null) {
                                                                ItemWorkshopBinding bind4 = ItemWorkshopBinding.bind(findChildViewById6);
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                i = R.id.progressBar;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.rightItemField))) != null) {
                                                                    ItemInventoryBinding bind5 = ItemInventoryBinding.bind(findChildViewById3);
                                                                    i = R.id.rvColors;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.rvMainInventory;
                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                        if (recyclerView2 != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.successChanceField))) != null) {
                                                                            ItemInfoCostBinding bind6 = ItemInfoCostBinding.bind(findChildViewById4);
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
                                                                                            i = R.id.tvScreenTitle;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.tvStartCount;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.tvTitle;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.tvTitleDescription;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.viewLine;
                                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
