package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
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

    private WinterBattlepassShopItemLayoutBinding(LinearLayout rootView, LinearLayout azBattlepassLayoutTasksContainer, LinearLayout discountContainer, LinearLayout priceContainer, RelativeLayout shopButton, TextView shopItemDiscountText, ImageView shopItemImage, TextView shopItemNameText, TextView shopItemPriceText) {
        this.rootView = rootView;
        this.azBattlepassLayoutTasksContainer = azBattlepassLayoutTasksContainer;
        this.discountContainer = discountContainer;
        this.priceContainer = priceContainer;
        this.shopButton = shopButton;
        this.shopItemDiscountText = shopItemDiscountText;
        this.shopItemImage = shopItemImage;
        this.shopItemNameText = shopItemNameText;
        this.shopItemPriceText = shopItemPriceText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassShopItemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassShopItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_shop_item_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassShopItemLayoutBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.discount_container;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout2 != null) {
            i = R.id.price_container;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout3 != null) {
                i = R.id.shop_button;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                if (relativeLayout != null) {
                    i = R.id.shop_item_discount_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.shop_item_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.shop_item_name_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.shop_item_price_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new WinterBattlepassShopItemLayoutBinding(linearLayout, linearLayout, linearLayout2, linearLayout3, relativeLayout, textView, imageView, textView2, textView3);
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
