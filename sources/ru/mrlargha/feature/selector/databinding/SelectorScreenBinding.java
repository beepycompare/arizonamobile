package ru.mrlargha.feature.selector.databinding;

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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.selector.R;
/* loaded from: classes6.dex */
public final class SelectorScreenBinding implements ViewBinding {
    public final CustomCardView btnConfirm;
    public final CustomCardView btnDecline;
    public final ImageView btnSlideLeft;
    public final ImageView btnSlideRight;
    public final LinearLayout moneyContainer;
    private final FrameLayout rootView;
    public final RecyclerView rvIndicators;
    public final RecyclerView rvInfo;
    public final FrameLayout selector;
    public final TextView tvConfirm;
    public final TextView tvDecline;
    public final TextView tvMoney;
    public final TextView tvTitle;

    private SelectorScreenBinding(FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.btnConfirm = customCardView;
        this.btnDecline = customCardView2;
        this.btnSlideLeft = imageView;
        this.btnSlideRight = imageView2;
        this.moneyContainer = linearLayout;
        this.rvIndicators = recyclerView;
        this.rvInfo = recyclerView2;
        this.selector = frameLayout2;
        this.tvConfirm = textView;
        this.tvDecline = textView2;
        this.tvMoney = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SelectorScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectorScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.selector_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectorScreenBinding bind(View view) {
        int i = R.id.btn_confirm;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_decline;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.btn_slide_left;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.btn_slide_right;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.money_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.rv_indicators;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.rv_info;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView2 != null) {
                                    FrameLayout frameLayout = (FrameLayout) view;
                                    i = R.id.tv_confirm;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_decline;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_money;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_title;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new SelectorScreenBinding(frameLayout, customCardView, customCardView2, imageView, imageView2, linearLayout, recyclerView, recyclerView2, frameLayout, textView, textView2, textView3, textView4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
