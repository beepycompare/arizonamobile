package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DonatePayPassTierBinding implements ViewBinding {
    public final CustomCardView paypassTierButton;
    public final ImageView paypassTierButtonIcon;
    public final TextView paypassTierButtonText;
    public final CustomCardView paypassTierCard;
    public final TextView paypassTierPrice;
    public final LinearLayout paypassTierPrizes;
    public final NestedScrollView paypassTierPrizesScroll;
    private final CustomCardView rootView;

    private DonatePayPassTierBinding(CustomCardView rootView, CustomCardView paypassTierButton, ImageView paypassTierButtonIcon, TextView paypassTierButtonText, CustomCardView paypassTierCard, TextView paypassTierPrice, LinearLayout paypassTierPrizes, NestedScrollView paypassTierPrizesScroll) {
        this.rootView = rootView;
        this.paypassTierButton = paypassTierButton;
        this.paypassTierButtonIcon = paypassTierButtonIcon;
        this.paypassTierButtonText = paypassTierButtonText;
        this.paypassTierCard = paypassTierCard;
        this.paypassTierPrice = paypassTierPrice;
        this.paypassTierPrizes = paypassTierPrizes;
        this.paypassTierPrizesScroll = paypassTierPrizesScroll;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static DonatePayPassTierBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePayPassTierBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_pay_pass_tier, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePayPassTierBinding bind(View rootView) {
        int i = R.id.paypass_tier_button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.paypass_tier_button_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.paypass_tier_button_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    CustomCardView customCardView2 = (CustomCardView) rootView;
                    i = R.id.paypass_tier_price;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.paypass_tier_prizes;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.paypass_tier_prizes_scroll;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, i);
                            if (nestedScrollView != null) {
                                return new DonatePayPassTierBinding(customCardView2, customCardView, imageView, textView, customCardView2, textView2, linearLayout, nestedScrollView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
