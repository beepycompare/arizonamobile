package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassShopLayoutBinding implements ViewBinding {
    public final LinearLayout azBattlepassLayoutTasksContainer;
    public final LinearLayout discountInfoContainer;
    public final LinearLayout priceContainer;
    private final LinearLayout rootView;
    public final LinearLayout shopInfoContainer;
    public final TextView shopInfoDiscountNumberText;
    public final RelativeLayout shopInfoItemDiscountContainer;
    public final TextView shopInfoItemDiscountText;
    public final ImageView shopInfoItemImage;
    public final TextView shopInfoItemName;
    public final RelativeLayout shopInfoPriceContainer;
    public final LinearLayout shopInfoPriceNumberContainer;
    public final TextView shopInfoPriceNumberText;
    public final TextView shopInfoPriceText;
    public final RecyclerView shopItemList;

    private WinterBattlepassShopLayoutBinding(LinearLayout rootView, LinearLayout azBattlepassLayoutTasksContainer, LinearLayout discountInfoContainer, LinearLayout priceContainer, LinearLayout shopInfoContainer, TextView shopInfoDiscountNumberText, RelativeLayout shopInfoItemDiscountContainer, TextView shopInfoItemDiscountText, ImageView shopInfoItemImage, TextView shopInfoItemName, RelativeLayout shopInfoPriceContainer, LinearLayout shopInfoPriceNumberContainer, TextView shopInfoPriceNumberText, TextView shopInfoPriceText, RecyclerView shopItemList) {
        this.rootView = rootView;
        this.azBattlepassLayoutTasksContainer = azBattlepassLayoutTasksContainer;
        this.discountInfoContainer = discountInfoContainer;
        this.priceContainer = priceContainer;
        this.shopInfoContainer = shopInfoContainer;
        this.shopInfoDiscountNumberText = shopInfoDiscountNumberText;
        this.shopInfoItemDiscountContainer = shopInfoItemDiscountContainer;
        this.shopInfoItemDiscountText = shopInfoItemDiscountText;
        this.shopInfoItemImage = shopInfoItemImage;
        this.shopInfoItemName = shopInfoItemName;
        this.shopInfoPriceContainer = shopInfoPriceContainer;
        this.shopInfoPriceNumberContainer = shopInfoPriceNumberContainer;
        this.shopInfoPriceNumberText = shopInfoPriceNumberText;
        this.shopInfoPriceText = shopInfoPriceText;
        this.shopItemList = shopItemList;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassShopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassShopLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_shop_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassShopLayoutBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.discount_info_container;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout2 != null) {
            i = R.id.price_container;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout3 != null) {
                i = R.id.shop_info_container;
                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout4 != null) {
                    i = R.id.shop_info_discount_number_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.shop_info_item_discount_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                        if (relativeLayout != null) {
                            i = R.id.shop_info_item_discount_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.shop_info_item_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.shop_info_item_name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.shop_info_price_container;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.shop_info_price_number_container;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout5 != null) {
                                                i = R.id.shop_info_price_number_text;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.shop_info_price_text;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.shop_item_list;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                        if (recyclerView != null) {
                                                            return new WinterBattlepassShopLayoutBinding(linearLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, relativeLayout, textView2, imageView, textView3, relativeLayout2, linearLayout5, textView4, textView5, recyclerView);
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
