package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ProductsScreenBinding implements ViewBinding {
    public final Guideline leftTitleLine;
    public final TextView mainTitle;
    public final AppCompatImageButton rodinaAuthBtnClose2;
    public final RecyclerView rodinaProductsListRecycler;
    public final ConstraintLayout rodinaProductsRoot;
    private final ConstraintLayout rootView;
    public final View view;

    private ProductsScreenBinding(ConstraintLayout rootView, Guideline leftTitleLine, TextView mainTitle, AppCompatImageButton rodinaAuthBtnClose2, RecyclerView rodinaProductsListRecycler, ConstraintLayout rodinaProductsRoot, View view) {
        this.rootView = rootView;
        this.leftTitleLine = leftTitleLine;
        this.mainTitle = mainTitle;
        this.rodinaAuthBtnClose2 = rodinaAuthBtnClose2;
        this.rodinaProductsListRecycler = rodinaProductsListRecycler;
        this.rodinaProductsRoot = rodinaProductsRoot;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ProductsScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ProductsScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.products_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProductsScreenBinding bind(View rootView) {
        int i = R.id.left_title_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.main_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.rodina_auth_btn_close2;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageButton != null) {
                    i = R.id.rodina_products_list_recycler;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                    if (recyclerView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        i = R.id.view;
                        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById != null) {
                            return new ProductsScreenBinding(constraintLayout, guideline, textView, appCompatImageButton, recyclerView, constraintLayout, findChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
