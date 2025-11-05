package ru.mrlargha.feature.battlepassWinter2025.databinding;

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
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
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

    private WinterBattlepassShopLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, RelativeLayout relativeLayout, TextView textView2, ImageView imageView, TextView textView3, RelativeLayout relativeLayout2, LinearLayout linearLayout6, TextView textView4, TextView textView5, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.azBattlepassLayoutTasksContainer = linearLayout2;
        this.discountInfoContainer = linearLayout3;
        this.priceContainer = linearLayout4;
        this.shopInfoContainer = linearLayout5;
        this.shopInfoDiscountNumberText = textView;
        this.shopInfoItemDiscountContainer = relativeLayout;
        this.shopInfoItemDiscountText = textView2;
        this.shopInfoItemImage = imageView;
        this.shopInfoItemName = textView3;
        this.shopInfoPriceContainer = relativeLayout2;
        this.shopInfoPriceNumberContainer = linearLayout6;
        this.shopInfoPriceNumberText = textView4;
        this.shopInfoPriceText = textView5;
        this.shopItemList = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassShopLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassShopLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_shop_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassShopLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.discount_info_container;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout2 != null) {
            i = R.id.price_container;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout3 != null) {
                i = R.id.shop_info_container;
                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout4 != null) {
                    i = R.id.shop_info_discount_number_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.shop_info_item_discount_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.shop_info_item_discount_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.shop_info_item_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.shop_info_item_name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.shop_info_price_container;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.shop_info_price_number_container;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout5 != null) {
                                                i = R.id.shop_info_price_number_text;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.shop_info_price_text;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.shop_item_list;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
