package ru.mrlargha.feature.workshop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.feature.workshop.R;
/* loaded from: classes6.dex */
public final class WorkshopScreenBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final WorkshopButtonsContainerBinding buttonsContainer;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineHor3;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final Guideline guidelineVer4;
    public final WorkshopInfoContainerBinding infoContainers;
    public final ImageView ivBgSharpResult;
    public final ItemInventoryBinding leftItemField;
    public final ItemWorkshopBinding mainItemField;
    public final ConstraintLayout parentLayout;
    public final ItemInventoryBinding rightItemField;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMainInventory;
    public final RecyclerView rvMenu;
    public final TextView tvLeftItemDescription;
    public final TextView tvMainItemDescription;
    public final TextView tvRightItemDescription;
    public final TextView tvScreenTitle;
    public final TextView tvTitle;
    public final TextView tvTitleDescription;
    public final ImageView viewLine;

    private WorkshopScreenBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, WorkshopButtonsContainerBinding workshopButtonsContainerBinding, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, WorkshopInfoContainerBinding workshopInfoContainerBinding, ImageView imageView, ItemInventoryBinding itemInventoryBinding, ItemWorkshopBinding itemWorkshopBinding, ConstraintLayout constraintLayout2, ItemInventoryBinding itemInventoryBinding2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.btnBack = appCompatImageView;
        this.buttonsContainer = workshopButtonsContainerBinding;
        this.guidelineHor1 = guideline;
        this.guidelineHor2 = guideline2;
        this.guidelineHor3 = guideline3;
        this.guidelineVer1 = guideline4;
        this.guidelineVer2 = guideline5;
        this.guidelineVer4 = guideline6;
        this.infoContainers = workshopInfoContainerBinding;
        this.ivBgSharpResult = imageView;
        this.leftItemField = itemInventoryBinding;
        this.mainItemField = itemWorkshopBinding;
        this.parentLayout = constraintLayout2;
        this.rightItemField = itemInventoryBinding2;
        this.rvMainInventory = recyclerView;
        this.rvMenu = recyclerView2;
        this.tvLeftItemDescription = textView;
        this.tvMainItemDescription = textView2;
        this.tvRightItemDescription = textView3;
        this.tvScreenTitle = textView4;
        this.tvTitle = textView5;
        this.tvTitleDescription = textView6;
        this.viewLine = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WorkshopScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WorkshopScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.workshop_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WorkshopScreenBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btnBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.buttons_container))) != null) {
            WorkshopButtonsContainerBinding bind = WorkshopButtonsContainerBinding.bind(findChildViewById);
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
                                if (guideline6 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.info_containers))) != null) {
                                    WorkshopInfoContainerBinding bind2 = WorkshopInfoContainerBinding.bind(findChildViewById2);
                                    i = R.id.ivBgSharpResult;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.leftItemField))) != null) {
                                        ItemInventoryBinding bind3 = ItemInventoryBinding.bind(findChildViewById3);
                                        i = R.id.mainItemField;
                                        View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById4 != null) {
                                            ItemWorkshopBinding bind4 = ItemWorkshopBinding.bind(findChildViewById4);
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = R.id.rightItemField;
                                            View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById5 != null) {
                                                ItemInventoryBinding bind5 = ItemInventoryBinding.bind(findChildViewById5);
                                                i = R.id.rvMainInventory;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    i = R.id.rvMenu;
                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                    if (recyclerView2 != null) {
                                                        i = R.id.tvLeftItemDescription;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.tvMainItemDescription;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tvRightItemDescription;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tvScreenTitle;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tvTitle;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tvTitleDescription;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.viewLine;
                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView2 != null) {
                                                                                    return new WorkshopScreenBinding(constraintLayout, appCompatImageView, bind, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, bind2, imageView, bind3, bind4, constraintLayout, bind5, recyclerView, recyclerView2, textView, textView2, textView3, textView4, textView5, textView6, imageView2);
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
