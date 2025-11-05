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
public final class WinterBattlepassBuyPremiumLayoutBinding implements ViewBinding {
    public final LinearLayout arizonaBlockOne;
    public final LinearLayout itemLevelBackgroundUsual;
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
    public final TextView premiumPlusPriceButtonText;
    public final TextView premiumPlusPriceText;
    public final RelativeLayout premiumPriceButton;
    public final TextView premiumPriceButtonText;
    public final TextView premiumPriceText;
    public final LinearLayout premuimInfoContainer;
    private final LinearLayout rootView;
    public final TextView vipText;

    private WinterBattlepassBuyPremiumLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, TextView textView3, TextView textView4, RelativeLayout relativeLayout3, TextView textView5, TextView textView6, RelativeLayout relativeLayout4, TextView textView7, TextView textView8, LinearLayout linearLayout4, TextView textView9) {
        this.rootView = linearLayout;
        this.arizonaBlockOne = linearLayout2;
        this.itemLevelBackgroundUsual = linearLayout3;
        this.premiumDiscountPercentBox = relativeLayout;
        this.premiumDiscountPercentText = textView;
        this.premiumDiscountText = textView2;
        this.premiumImage1 = imageView;
        this.premiumImage2 = imageView2;
        this.premiumImage3 = imageView3;
        this.premiumPlusDiscountPercentBox = relativeLayout2;
        this.premiumPlusDiscountPercentText = textView3;
        this.premiumPlusDiscountText = textView4;
        this.premiumPlusPriceButton = relativeLayout3;
        this.premiumPlusPriceButtonText = textView5;
        this.premiumPlusPriceText = textView6;
        this.premiumPriceButton = relativeLayout4;
        this.premiumPriceButtonText = textView7;
        this.premiumPriceText = textView8;
        this.premuimInfoContainer = linearLayout4;
        this.vipText = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassBuyPremiumLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassBuyPremiumLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_buy_premium_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassBuyPremiumLayoutBinding bind(View view) {
        int i = R.id.arizona_block_one;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.item_level_background_usual;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.premium_discount_percent_box;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.premium_discount_percent_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.premium_discount_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.premium_image1;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.premium_image2;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.premium_image3;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.premium_plus_discount_percent_box;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.premium_plus_discount_percent_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.premium_plus_discount_text;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.premium_plus_price_button;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.premium_plus_price_button_text;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.premium_plus_price_text;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.premium_price_button;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.premium_price_button_text;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.premium_price_text;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.premuim_info_container;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.vip_text;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView9 != null) {
                                                                                    return new WinterBattlepassBuyPremiumLayoutBinding((LinearLayout) view, linearLayout, linearLayout2, relativeLayout, textView, textView2, imageView, imageView2, imageView3, relativeLayout2, textView3, textView4, relativeLayout3, textView5, textView6, relativeLayout4, textView7, textView8, linearLayout3, textView9);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
