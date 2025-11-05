package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateCategoryItemBinding implements ViewBinding {
    public final ImageView animationThumb;
    public final CardView categoryContainer;
    public final ImageView ivBorder;
    public final ImageView ivCategoryBg;
    public final ImageView ivItem;
    public final ImageView ivNewIc;
    public final ImageView ivSelectBackground;
    private final FrameLayout rootView;
    public final TextView tvCategoryTitle;

    private DonateCategoryItemBinding(FrameLayout rootView, ImageView animationThumb, CardView categoryContainer, ImageView ivBorder, ImageView ivCategoryBg, ImageView ivItem, ImageView ivNewIc, ImageView ivSelectBackground, TextView tvCategoryTitle) {
        this.rootView = rootView;
        this.animationThumb = animationThumb;
        this.categoryContainer = categoryContainer;
        this.ivBorder = ivBorder;
        this.ivCategoryBg = ivCategoryBg;
        this.ivItem = ivItem;
        this.ivNewIc = ivNewIc;
        this.ivSelectBackground = ivSelectBackground;
        this.tvCategoryTitle = tvCategoryTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateCategoryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateCategoryItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_category_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateCategoryItemBinding bind(View rootView) {
        int i = R.id.animation_thumb;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.category_container;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
            if (cardView != null) {
                i = R.id.iv_border;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.iv_category_bg;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.iv_item;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView4 != null) {
                            i = R.id.iv_new_ic;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView5 != null) {
                                i = R.id.iv_select_background;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView6 != null) {
                                    i = R.id.tv_category_title;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        return new DonateCategoryItemBinding((FrameLayout) rootView, imageView, cardView, imageView2, imageView3, imageView4, imageView5, imageView6, textView);
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
