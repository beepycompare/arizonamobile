package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CatalogItemLayoutBinding implements ViewBinding {
    public final ImageView catalogImage;
    public final TextView catalogItemPriceText;
    public final TextView catalogNameText;
    public final ProgressBar catalogProgressBar;
    private final LinearLayout rootView;

    private CatalogItemLayoutBinding(LinearLayout rootView, ImageView catalogImage, TextView catalogItemPriceText, TextView catalogNameText, ProgressBar catalogProgressBar) {
        this.rootView = rootView;
        this.catalogImage = catalogImage;
        this.catalogItemPriceText = catalogItemPriceText;
        this.catalogNameText = catalogNameText;
        this.catalogProgressBar = catalogProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CatalogItemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CatalogItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.catalog_item_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CatalogItemLayoutBinding bind(View rootView) {
        int i = R.id.catalog_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.catalog_item_price_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.catalog_name_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.catalog_progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                    if (progressBar != null) {
                        return new CatalogItemLayoutBinding((LinearLayout) rootView, imageView, textView, textView2, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
