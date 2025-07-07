package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.donate.utils.GradientTextView;
/* loaded from: classes5.dex */
public final class DonatePosterItemBinding implements ViewBinding {
    public final LinearLayout btnBuy;
    public final ImageView ivMoneyIc;
    private final FrameLayout rootView;
    public final RecyclerView rvTags;
    public final TextView tvAvailable;
    public final TextView tvFirstTitle;
    public final TextView tvOldPrice;
    public final TextView tvPrice;
    public final GradientTextView tvSecondTitle;

    private DonatePosterItemBinding(FrameLayout rootView, LinearLayout btnBuy, ImageView ivMoneyIc, RecyclerView rvTags, TextView tvAvailable, TextView tvFirstTitle, TextView tvOldPrice, TextView tvPrice, GradientTextView tvSecondTitle) {
        this.rootView = rootView;
        this.btnBuy = btnBuy;
        this.ivMoneyIc = ivMoneyIc;
        this.rvTags = rvTags;
        this.tvAvailable = tvAvailable;
        this.tvFirstTitle = tvFirstTitle;
        this.tvOldPrice = tvOldPrice;
        this.tvPrice = tvPrice;
        this.tvSecondTitle = tvSecondTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonatePosterItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePosterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_poster_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePosterItemBinding bind(View rootView) {
        int i = R.id.btn_buy;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_money_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.rv_tags;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    i = R.id.tv_available;
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
                                        return new DonatePosterItemBinding((FrameLayout) rootView, linearLayout, imageView, recyclerView, textView, textView2, textView3, textView4, gradientTextView);
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
