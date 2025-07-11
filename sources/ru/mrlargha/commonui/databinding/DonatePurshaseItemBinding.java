package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.donate.utils.GradientTextView;
/* loaded from: classes5.dex */
public final class DonatePurshaseItemBinding implements ViewBinding {
    public final ImageView animationThumb;
    public final LinearLayout blockContainer;
    public final LinearLayout btnBuy;
    public final CardView cardContainer;
    public final LinearLayout gradientTextContainer;
    public final ImageView ivItem;
    public final ImageView ivItemBg;
    public final ImageView ivMoneyIc;
    private final FrameLayout rootView;
    public final RecyclerView rvTags;
    public final TextView tvBlockReason;
    public final TextView tvFirstTitle;
    public final TextView tvOldPrice;
    public final TextView tvPrice;
    public final GradientTextView tvSecondTitle;

    private DonatePurshaseItemBinding(FrameLayout rootView, ImageView animationThumb, LinearLayout blockContainer, LinearLayout btnBuy, CardView cardContainer, LinearLayout gradientTextContainer, ImageView ivItem, ImageView ivItemBg, ImageView ivMoneyIc, RecyclerView rvTags, TextView tvBlockReason, TextView tvFirstTitle, TextView tvOldPrice, TextView tvPrice, GradientTextView tvSecondTitle) {
        this.rootView = rootView;
        this.animationThumb = animationThumb;
        this.blockContainer = blockContainer;
        this.btnBuy = btnBuy;
        this.cardContainer = cardContainer;
        this.gradientTextContainer = gradientTextContainer;
        this.ivItem = ivItem;
        this.ivItemBg = ivItemBg;
        this.ivMoneyIc = ivMoneyIc;
        this.rvTags = rvTags;
        this.tvBlockReason = tvBlockReason;
        this.tvFirstTitle = tvFirstTitle;
        this.tvOldPrice = tvOldPrice;
        this.tvPrice = tvPrice;
        this.tvSecondTitle = tvSecondTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonatePurshaseItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePurshaseItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_purshase_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePurshaseItemBinding bind(View rootView) {
        int i = R.id.animation_thumb;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.block_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.btn_buy;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.card_container;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                    if (cardView != null) {
                        i = R.id.gradient_text_container;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout3 != null) {
                            i = R.id.iv_item;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.iv_item_bg;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView3 != null) {
                                    i = R.id.iv_money_ic;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView4 != null) {
                                        i = R.id.rv_tags;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.tv_block_reason;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView != null) {
                                                i = R.id.tv_first_title;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_old_price;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_price;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_second_title;
                                                            GradientTextView gradientTextView = (GradientTextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (gradientTextView != null) {
                                                                return new DonatePurshaseItemBinding((FrameLayout) rootView, imageView, linearLayout, linearLayout2, cardView, linearLayout3, imageView2, imageView3, imageView4, recyclerView, textView, textView2, textView3, textView4, gradientTextView);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
