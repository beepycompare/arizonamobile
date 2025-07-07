package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DonateItemBinding implements ViewBinding {
    public final CardView cardView;
    public final AppCompatImageView donateAzIcon;
    public final Button donateBuyButton;
    public final TextView donateDiscountNotify;
    public final LinearLayout donateItemBackground;
    public final TextView itemTittle;
    public final AppCompatImageView marketItem;
    public final TextView marketPrice;
    private final ConstraintLayout rootView;
    public final ConstraintLayout statusContainer;
    public final ImageView statusIc;
    public final TextView statusText;

    private DonateItemBinding(ConstraintLayout constraintLayout, CardView cardView, AppCompatImageView appCompatImageView, Button button, TextView textView, LinearLayout linearLayout, TextView textView2, AppCompatImageView appCompatImageView2, TextView textView3, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView4) {
        this.rootView = constraintLayout;
        this.cardView = cardView;
        this.donateAzIcon = appCompatImageView;
        this.donateBuyButton = button;
        this.donateDiscountNotify = textView;
        this.donateItemBackground = linearLayout;
        this.itemTittle = textView2;
        this.marketItem = appCompatImageView2;
        this.marketPrice = textView3;
        this.statusContainer = constraintLayout2;
        this.statusIc = imageView;
        this.statusText = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DonateItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DonateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.donate_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateItemBinding bind(View view) {
        int i = R.id.card_view;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.donate_az_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.donate_buy_button;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.donate_discount_notify;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.donate_item_background;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.itemTittle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.market_item;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView2 != null) {
                                    i = R.id.market_price;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.status_container;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout != null) {
                                            i = R.id.status_ic;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.status_text;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new DonateItemBinding((ConstraintLayout) view, cardView, appCompatImageView, button, textView, linearLayout, textView2, appCompatImageView2, textView3, constraintLayout, imageView, textView4);
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
