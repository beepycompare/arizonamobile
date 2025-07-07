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
public final class WinterBattlepassBuyPremiumLayoutBinding implements ViewBinding {
    public final ImageView itemLevelBackgroundUsual;
    public final RelativeLayout premiumDiscountPercentBox;
    public final TextView premiumDiscountPercentText;
    public final TextView premiumDiscountText;
    public final ImageView premiumImage1;
    public final ImageView premiumImage2;
    public final ImageView premiumImage3;
    public final RelativeLayout premiumPlusDiscountPercentBox;
    public final TextView premiumPlusDiscountPercentText;
    public final TextView premiumPlusDiscountText;
    public final RelativeLayout premiumPlusPriceButton;
    public final TextView premiumPlusPriceText;
    public final RelativeLayout premiumPriceButton;
    public final TextView premiumPriceText;
    public final LinearLayout premuimInfoContainer;
    private final LinearLayout rootView;
    public final TextView vipText;

    private WinterBattlepassBuyPremiumLayoutBinding(LinearLayout rootView, ImageView itemLevelBackgroundUsual, RelativeLayout premiumDiscountPercentBox, TextView premiumDiscountPercentText, TextView premiumDiscountText, ImageView premiumImage1, ImageView premiumImage2, ImageView premiumImage3, RelativeLayout premiumPlusDiscountPercentBox, TextView premiumPlusDiscountPercentText, TextView premiumPlusDiscountText, RelativeLayout premiumPlusPriceButton, TextView premiumPlusPriceText, RelativeLayout premiumPriceButton, TextView premiumPriceText, LinearLayout premuimInfoContainer, TextView vipText) {
        this.rootView = rootView;
        this.itemLevelBackgroundUsual = itemLevelBackgroundUsual;
        this.premiumDiscountPercentBox = premiumDiscountPercentBox;
        this.premiumDiscountPercentText = premiumDiscountPercentText;
        this.premiumDiscountText = premiumDiscountText;
        this.premiumImage1 = premiumImage1;
        this.premiumImage2 = premiumImage2;
        this.premiumImage3 = premiumImage3;
        this.premiumPlusDiscountPercentBox = premiumPlusDiscountPercentBox;
        this.premiumPlusDiscountPercentText = premiumPlusDiscountPercentText;
        this.premiumPlusDiscountText = premiumPlusDiscountText;
        this.premiumPlusPriceButton = premiumPlusPriceButton;
        this.premiumPlusPriceText = premiumPlusPriceText;
        this.premiumPriceButton = premiumPriceButton;
        this.premiumPriceText = premiumPriceText;
        this.premuimInfoContainer = premuimInfoContainer;
        this.vipText = vipText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassBuyPremiumLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassBuyPremiumLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_buy_premium_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassBuyPremiumLayoutBinding bind(View rootView) {
        int i = R.id.item_level_background_usual;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.premium_discount_percent_box;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
            if (relativeLayout != null) {
                i = R.id.premium_discount_percent_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.premium_discount_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.premium_image1;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            i = R.id.premium_image2;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView3 != null) {
                                i = R.id.premium_image3;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView4 != null) {
                                    i = R.id.premium_plus_discount_percent_box;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (relativeLayout2 != null) {
                                        i = R.id.premium_plus_discount_percent_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.premium_plus_discount_text;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                i = R.id.premium_plus_price_button;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.premium_plus_price_text;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        i = R.id.premium_price_button;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.premium_price_text;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.premuim_info_container;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout != null) {
                                                                    i = R.id.vip_text;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView7 != null) {
                                                                        return new WinterBattlepassBuyPremiumLayoutBinding((LinearLayout) rootView, imageView, relativeLayout, textView, textView2, imageView2, imageView3, imageView4, relativeLayout2, textView3, textView4, relativeLayout3, textView5, relativeLayout4, textView6, linearLayout, textView7);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
