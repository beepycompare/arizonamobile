package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryElementItemBinding implements ViewBinding {
    public final CustomCardView btnDelete;
    public final CustomCardView container;
    public final ImageView ivEffectBackground;
    public final ImageView ivEffectBackgroundTop;
    public final ImageView ivEffectForeground;
    public final ImageView ivIcon;
    public final ImageView ivItem;
    private final FrameLayout rootView;
    public final TextView tvCount;

    private MobileRentAccessoryElementItemBinding(FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView) {
        this.rootView = frameLayout;
        this.btnDelete = customCardView;
        this.container = customCardView2;
        this.ivEffectBackground = imageView;
        this.ivEffectBackgroundTop = imageView2;
        this.ivEffectForeground = imageView3;
        this.ivIcon = imageView4;
        this.ivItem = imageView5;
        this.tvCount = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryElementItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryElementItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_element_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryElementItemBinding bind(View view) {
        int i = R.id.btn_delete;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.container;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.iv_effect_background;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_effect_background_top;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.iv_effect_foreground;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.iv_icon;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.iv_item;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.tv_count;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        return new MobileRentAccessoryElementItemBinding((FrameLayout) view, customCardView, customCardView2, imageView, imageView2, imageView3, imageView4, imageView5, textView);
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
