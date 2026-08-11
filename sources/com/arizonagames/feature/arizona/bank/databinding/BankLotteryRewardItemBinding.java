package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankLotteryRewardItemBinding implements ViewBinding {
    public final CustomCardView bankLotteryRewardCard;
    public final TextView bankLotteryRewardEnchant;
    public final CustomCardView bankLotteryRewardGlow;
    public final ImageView bankLotteryRewardIcon;
    public final TextView bankLotteryRewardPlace;
    public final CustomCardView bankLotteryRewardPlaceCard;
    public final TextView bankLotteryRewardSubtitle;
    public final TextView bankLotteryRewardTitle;
    private final CustomCardView rootView;

    private BankLotteryRewardItemBinding(CustomCardView customCardView, CustomCardView customCardView2, TextView textView, CustomCardView customCardView3, ImageView imageView, TextView textView2, CustomCardView customCardView4, TextView textView3, TextView textView4) {
        this.rootView = customCardView;
        this.bankLotteryRewardCard = customCardView2;
        this.bankLotteryRewardEnchant = textView;
        this.bankLotteryRewardGlow = customCardView3;
        this.bankLotteryRewardIcon = imageView;
        this.bankLotteryRewardPlace = textView2;
        this.bankLotteryRewardPlaceCard = customCardView4;
        this.bankLotteryRewardSubtitle = textView3;
        this.bankLotteryRewardTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankLotteryRewardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankLotteryRewardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_lottery_reward_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankLotteryRewardItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.bank_lottery_reward_enchant;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_lottery_reward_glow;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.bank_lottery_reward_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.bank_lottery_reward_place;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.bank_lottery_reward_place_card;
                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView3 != null) {
                            i = R.id.bank_lottery_reward_subtitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.bank_lottery_reward_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new BankLotteryRewardItemBinding(customCardView, customCardView, textView, customCardView2, imageView, textView2, customCardView3, textView3, textView4);
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
