package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class ArizonaCasesOpenItemBinding implements ViewBinding {
    public final FrameLayout bg;
    public final LinearLayout costContainer;
    public final ImageView ivCheck;
    public final ImageView ivPrize;
    public final FrameLayout openContainer;
    private final LinearLayout rootView;
    public final TextView tvClose;
    public final TextView tvCost;
    public final TextView tvGotIt;
    public final TextView tvSchism;
    public final TextView tvTitle;

    private ArizonaCasesOpenItemBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.bg = frameLayout;
        this.costContainer = linearLayout2;
        this.ivCheck = imageView;
        this.ivPrize = imageView2;
        this.openContainer = frameLayout2;
        this.tvClose = textView;
        this.tvCost = textView2;
        this.tvGotIt = textView3;
        this.tvSchism = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaCasesOpenItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ArizonaCasesOpenItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.arizona_cases_open_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaCasesOpenItemBinding bind(View view) {
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.cost_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.iv_check;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_prize;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.open_container;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = R.id.tv_close;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_cost;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_got_it;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_schism;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tv_title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new ArizonaCasesOpenItemBinding((LinearLayout) view, frameLayout, linearLayout, imageView, imageView2, frameLayout2, textView, textView2, textView3, textView4, textView5);
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
