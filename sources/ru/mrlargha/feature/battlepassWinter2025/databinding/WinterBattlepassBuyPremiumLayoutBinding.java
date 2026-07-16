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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassBuyPremiumLayoutBinding implements ViewBinding {
    public final LinearLayout arizonaBlockOne;
    public final LinearLayout itemLevelBackgroundUsual;
    public final TextView premiumBenefitProgressText;
    public final TextView premiumBenefitRewardsText;
    public final RelativeLayout premiumDiscountPercentBox;
    public final TextView premiumDiscountPercentText;
    public final TextView premiumDiscountText;
    public final ImageView premiumImage1;
    public final ImageView premiumImage2;
    public final ImageView premiumImage3;
    public final ArizonaGradientTextView premiumPlusBenefitAllText;
    public final ArizonaGradientTextView premiumPlusBenefitLevelsText;
    public final RelativeLayout premiumPlusDiscountPercentBox;
    public final TextView premiumPlusDiscountPercentText;
    public final TextView premiumPlusDiscountText;
    public final CustomCardView premiumPlusPriceButton;
    public final TextView premiumPlusPriceButtonText;
    public final TextView premiumPlusPriceText;
    public final CustomCardView premiumPriceButton;
    public final TextView premiumPriceButtonText;
    public final TextView premiumPriceText;
    public final LinearLayout premuimInfoContainer;
    public final LinearLayout rodinaPremiumPlusExtraBenefits;
    private final LinearLayout rootView;
    public final ArizonaGradientTextView vipText;

    private WinterBattlepassBuyPremiumLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, RelativeLayout relativeLayout, TextView textView3, TextView textView4, ImageView imageView, ImageView imageView2, ImageView imageView3, ArizonaGradientTextView arizonaGradientTextView, ArizonaGradientTextView arizonaGradientTextView2, RelativeLayout relativeLayout2, TextView textView5, TextView textView6, CustomCardView customCardView, TextView textView7, TextView textView8, CustomCardView customCardView2, TextView textView9, TextView textView10, LinearLayout linearLayout4, LinearLayout linearLayout5, ArizonaGradientTextView arizonaGradientTextView3) {
        this.rootView = linearLayout;
        this.arizonaBlockOne = linearLayout2;
        this.itemLevelBackgroundUsual = linearLayout3;
        this.premiumBenefitProgressText = textView;
        this.premiumBenefitRewardsText = textView2;
        this.premiumDiscountPercentBox = relativeLayout;
        this.premiumDiscountPercentText = textView3;
        this.premiumDiscountText = textView4;
        this.premiumImage1 = imageView;
        this.premiumImage2 = imageView2;
        this.premiumImage3 = imageView3;
        this.premiumPlusBenefitAllText = arizonaGradientTextView;
        this.premiumPlusBenefitLevelsText = arizonaGradientTextView2;
        this.premiumPlusDiscountPercentBox = relativeLayout2;
        this.premiumPlusDiscountPercentText = textView5;
        this.premiumPlusDiscountText = textView6;
        this.premiumPlusPriceButton = customCardView;
        this.premiumPlusPriceButtonText = textView7;
        this.premiumPlusPriceText = textView8;
        this.premiumPriceButton = customCardView2;
        this.premiumPriceButtonText = textView9;
        this.premiumPriceText = textView10;
        this.premuimInfoContainer = linearLayout4;
        this.rodinaPremiumPlusExtraBenefits = linearLayout5;
        this.vipText = arizonaGradientTextView3;
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
                i = R.id.premium_benefit_progress_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.premium_benefit_rewards_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.premium_discount_percent_box;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.premium_discount_percent_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.premium_discount_text;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.premium_image1;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.premium_image2;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            i = R.id.premium_image3;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.premium_plus_benefit_all_text;
                                                ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                                                if (arizonaGradientTextView != null) {
                                                    i = R.id.premium_plus_benefit_levels_text;
                                                    ArizonaGradientTextView arizonaGradientTextView2 = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                                                    if (arizonaGradientTextView2 != null) {
                                                        i = R.id.premium_plus_discount_percent_box;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout2 != null) {
                                                            i = R.id.premium_plus_discount_percent_text;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.premium_plus_discount_text;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.premium_plus_price_button;
                                                                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView != null) {
                                                                        i = R.id.premium_plus_price_button_text;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.premium_plus_price_text;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.premium_price_button;
                                                                                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                if (customCardView2 != null) {
                                                                                    i = R.id.premium_price_button_text;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.premium_price_text;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.premuim_info_container;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = R.id.rodina_premium_plus_extra_benefits;
                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout4 != null) {
                                                                                                    i = R.id.vip_text;
                                                                                                    ArizonaGradientTextView arizonaGradientTextView3 = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (arizonaGradientTextView3 != null) {
                                                                                                        return new WinterBattlepassBuyPremiumLayoutBinding((LinearLayout) view, linearLayout, linearLayout2, textView, textView2, relativeLayout, textView3, textView4, imageView, imageView2, imageView3, arizonaGradientTextView, arizonaGradientTextView2, relativeLayout2, textView5, textView6, customCardView, textView7, textView8, customCardView2, textView9, textView10, linearLayout3, linearLayout4, arizonaGradientTextView3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
