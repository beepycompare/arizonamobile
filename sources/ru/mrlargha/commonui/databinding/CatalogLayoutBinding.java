package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class CatalogLayoutBinding implements ViewBinding {
    public final AppCompatImageButton catalogBtnClose;
    public final TextView catalogDescText;
    public final RecyclerView catalogListRv;
    public final LinearLayout catalogScreenRootLl;
    public final TextView catalogTitleText;
    public final EditText etSearch;
    private final LinearLayout rootView;
    public final CustomCardView searchContainer;

    private CatalogLayoutBinding(LinearLayout rootView, AppCompatImageButton catalogBtnClose, TextView catalogDescText, RecyclerView catalogListRv, LinearLayout catalogScreenRootLl, TextView catalogTitleText, EditText etSearch, CustomCardView searchContainer) {
        this.rootView = rootView;
        this.catalogBtnClose = catalogBtnClose;
        this.catalogDescText = catalogDescText;
        this.catalogListRv = catalogListRv;
        this.catalogScreenRootLl = catalogScreenRootLl;
        this.catalogTitleText = catalogTitleText;
        this.etSearch = etSearch;
        this.searchContainer = searchContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
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
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i = R.id.catalog_title_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.et_search;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText != null) {
                            i = R.id.search_container;
                            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView != null) {
                                return new CatalogLayoutBinding(linearLayout, appCompatImageButton, textView, recyclerView, linearLayout, textView2, editText, customCardView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
