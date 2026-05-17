package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class CatalogItemLayoutBinding implements ViewBinding {
    public final View brightness;
    public final ImageView catalogImage;
    public final TextView catalogItemPriceText;
    public final TextView catalogNameText;
    public final ProgressBar catalogProgressBar;
    private final CustomCardView rootView;

    private CatalogItemLayoutBinding(CustomCardView rootView, View brightness, ImageView catalogImage, TextView catalogItemPriceText, TextView catalogNameText, ProgressBar catalogProgressBar) {
        this.rootView = rootView;
        this.brightness = brightness;
        this.catalogImage = catalogImage;
        this.catalogItemPriceText = catalogItemPriceText;
        this.catalogNameText = catalogNameText;
        this.catalogProgressBar = catalogProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
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
        int i = R.id.brightness;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            i = R.id.catalog_image;
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
                            return new CatalogItemLayoutBinding((CustomCardView) rootView, findChildViewById, imageView, textView, textView2, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
