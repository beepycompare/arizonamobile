package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class GasStationShopItemBinding implements ViewBinding {
    public final ConstraintLayout gsShopItem;
    public final ConstraintLayout gsShopItemBg;
    public final AppCompatImageView gsShopItemImg;
    public final TextView gsShopItemPrice;
    public final TextView gsShopItemSuffix;
    public final TextView gsShopItemTitle;
    private final ConstraintLayout rootView;

    private GasStationShopItemBinding(ConstraintLayout rootView, ConstraintLayout gsShopItem, ConstraintLayout gsShopItemBg, AppCompatImageView gsShopItemImg, TextView gsShopItemPrice, TextView gsShopItemSuffix, TextView gsShopItemTitle) {
        this.rootView = rootView;
        this.gsShopItem = gsShopItem;
        this.gsShopItemBg = gsShopItemBg;
        this.gsShopItemImg = gsShopItemImg;
        this.gsShopItemPrice = gsShopItemPrice;
        this.gsShopItemSuffix = gsShopItemSuffix;
        this.gsShopItemTitle = gsShopItemTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GasStationShopItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static GasStationShopItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.gas_station_shop_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static GasStationShopItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.gs_shop_item_bg;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout2 != null) {
            i = R.id.gs_shop_item_img;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.gs_shop_item_price;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.gs_shop_item_suffix;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.gs_shop_item_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new GasStationShopItemBinding(constraintLayout, constraintLayout, constraintLayout2, appCompatImageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
