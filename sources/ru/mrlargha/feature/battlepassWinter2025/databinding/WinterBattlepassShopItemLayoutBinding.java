package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassShopItemLayoutBinding implements ViewBinding {
    public final LinearLayout azBattlepassLayoutTasksContainer;
    public final LinearLayout discountContainer;
    public final LinearLayout priceContainer;
    private final LinearLayout rootView;
    public final RelativeLayout shopButton;
    public final TextView shopItemDiscountText;
    public final ImageView shopItemImage;
    public final TextView shopItemNameText;
    public final TextView shopItemPriceText;

    private WinterBattlepassShopItemLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RelativeLayout relativeLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.azBattlepassLayoutTasksContainer = linearLayout2;
        this.discountContainer = linearLayout3;
        this.priceContainer = linearLayout4;
        this.shopButton = relativeLayout;
        this.shopItemDiscountText = textView;
        this.shopItemImage = imageView;
        this.shopItemNameText = textView2;
        this.shopItemPriceText = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassShopItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassShopItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_shop_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassShopItemLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.discount_container;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout2 != null) {
            i = R.id.price_container;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout3 != null) {
                i = R.id.shop_button;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.shop_item_discount_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.shop_item_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.shop_item_name_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.shop_item_price_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new WinterBattlepassShopItemLayoutBinding(linearLayout, linearLayout, linearLayout2, linearLayout3, relativeLayout, textView, imageView, textView2, textView3);
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
