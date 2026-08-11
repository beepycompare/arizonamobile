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
public final class BankLotteryWinnerRowItemBinding implements ViewBinding {
    public final CustomCardView bankLotteryWinnerRowCard;
    public final TextView bankLotteryWinnerRowEnchant;
    public final ImageView bankLotteryWinnerRowIcon;
    public final TextView bankLotteryWinnerRowName;
    public final TextView bankLotteryWinnerRowPlace;
    public final CustomCardView bankLotteryWinnerRowPlaceCard;
    public final TextView bankLotteryWinnerRowPrize;
    private final CustomCardView rootView;

    private BankLotteryWinnerRowItemBinding(CustomCardView customCardView, CustomCardView customCardView2, TextView textView, ImageView imageView, TextView textView2, TextView textView3, CustomCardView customCardView3, TextView textView4) {
        this.rootView = customCardView;
        this.bankLotteryWinnerRowCard = customCardView2;
        this.bankLotteryWinnerRowEnchant = textView;
        this.bankLotteryWinnerRowIcon = imageView;
        this.bankLotteryWinnerRowName = textView2;
        this.bankLotteryWinnerRowPlace = textView3;
        this.bankLotteryWinnerRowPlaceCard = customCardView3;
        this.bankLotteryWinnerRowPrize = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankLotteryWinnerRowItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankLotteryWinnerRowItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_lottery_winner_row_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankLotteryWinnerRowItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.bank_lottery_winner_row_enchant;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_lottery_winner_row_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.bank_lottery_winner_row_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.bank_lottery_winner_row_place;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.bank_lottery_winner_row_place_card;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView2 != null) {
                            i = R.id.bank_lottery_winner_row_prize;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new BankLotteryWinnerRowItemBinding(customCardView, customCardView, textView, imageView, textView2, textView3, customCardView2, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
