package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class DonateMiddleItemBinding implements ViewBinding {
    public final LinearLayout btnBuy;
    public final LinearLayout exChangeContainer;
    public final ImageView ivAzIc;
    public final ImageView ivMoneyIc;
    private final CardView rootView;
    public final RecyclerView rvBadges;
    public final TextView tvAz;
    public final TextView tvFirstTitle;
    public final TextView tvMoney;
    public final TextView tvPrice;
    public final GradientTextView tvSecondTitle;

    private DonateMiddleItemBinding(CardView rootView, LinearLayout btnBuy, LinearLayout exChangeContainer, ImageView ivAzIc, ImageView ivMoneyIc, RecyclerView rvBadges, TextView tvAz, TextView tvFirstTitle, TextView tvMoney, TextView tvPrice, GradientTextView tvSecondTitle) {
        this.rootView = rootView;
        this.btnBuy = btnBuy;
        this.exChangeContainer = exChangeContainer;
        this.ivAzIc = ivAzIc;
        this.ivMoneyIc = ivMoneyIc;
        this.rvBadges = rvBadges;
        this.tvAz = tvAz;
        this.tvFirstTitle = tvFirstTitle;
        this.tvMoney = tvMoney;
        this.tvPrice = tvPrice;
        this.tvSecondTitle = tvSecondTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static DonateMiddleItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateMiddleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_middle_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateMiddleItemBinding bind(View rootView) {
        int i = R.id.btn_buy;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.ex_change_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.iv_az_ic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.iv_money_ic;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.rv_badges;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.tv_az;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tv_first_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tv_money;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_price;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.tv_second_title;
                                            GradientTextView gradientTextView = (GradientTextView) ViewBindings.findChildViewById(rootView, i);
                                            if (gradientTextView != null) {
                                                return new DonateMiddleItemBinding((CardView) rootView, linearLayout, linearLayout2, imageView, imageView2, recyclerView, textView, textView2, textView3, textView4, gradientTextView);
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
