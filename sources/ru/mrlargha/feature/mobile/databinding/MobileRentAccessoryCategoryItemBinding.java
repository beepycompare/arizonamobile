package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryCategoryItemBinding implements ViewBinding {
    public final CustomCardView container;
    public final ImageView ivIcon;
    public final ImageView ivSelect;
    private final CustomCardView rootView;
    public final TextView tvName;

    private MobileRentAccessoryCategoryItemBinding(CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = customCardView;
        this.container = customCardView2;
        this.ivIcon = imageView;
        this.ivSelect = imageView2;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryCategoryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryCategoryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_category_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryCategoryItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_select;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.tv_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new MobileRentAccessoryCategoryItemBinding(customCardView, customCardView, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
