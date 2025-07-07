package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CatalogLayoutBinding implements ViewBinding {
    public final AppCompatImageButton catalogBtnClose;
    public final TextView catalogDescText;
    public final RecyclerView catalogListRv;
    public final ConstraintLayout catalogScreenRootCl;
    public final LinearLayout catalogScreenRootLl;
    public final TextView catalogTitleText;
    private final ConstraintLayout rootView;

    private CatalogLayoutBinding(ConstraintLayout rootView, AppCompatImageButton catalogBtnClose, TextView catalogDescText, RecyclerView catalogListRv, ConstraintLayout catalogScreenRootCl, LinearLayout catalogScreenRootLl, TextView catalogTitleText) {
        this.rootView = rootView;
        this.catalogBtnClose = catalogBtnClose;
        this.catalogDescText = catalogDescText;
        this.catalogListRv = catalogListRv;
        this.catalogScreenRootCl = catalogScreenRootCl;
        this.catalogScreenRootLl = catalogScreenRootLl;
        this.catalogTitleText = catalogTitleText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CatalogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CatalogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.catalog_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogLayoutBinding bind(View rootView) {
        int i = R.id.catalog_btn_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageButton != null) {
            i = R.id.catalog_desc_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.catalog_list_rv;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.catalog_screen_root_ll;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.catalog_title_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            return new CatalogLayoutBinding(constraintLayout, appCompatImageButton, textView, recyclerView, constraintLayout, linearLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
