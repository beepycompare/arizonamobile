package com.arizonagames.feature.arizona.bank.pages;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankLotteryRewardInfo;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.ui.BankImageLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryWinnerRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "placeCard", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "place", "Landroid/widget/TextView;", "winnerName", "icon", "Landroid/widget/ImageView;", "prize", "enchant", "bind", "", "reward", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "position", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BankLotteryWinnerRowViewHolder extends RecyclerView.ViewHolder {
    private final TextView enchant;
    private final ImageView icon;
    private final TextView place;
    private final CustomCardView placeCard;
    private final TextView prize;
    private final TextView winnerName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankLotteryWinnerRowViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.bank_lottery_winner_row_place_card);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.placeCard = (CustomCardView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.bank_lottery_winner_row_place);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.place = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.bank_lottery_winner_row_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.winnerName = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.bank_lottery_winner_row_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.icon = (ImageView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.bank_lottery_winner_row_prize);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.prize = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.bank_lottery_winner_row_enchant);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.enchant = (TextView) findViewById6;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(BankLotteryRewardInfo reward, int i) {
        int bankLotteryPlaceBadgeColor;
        String str;
        int fallbackRewardIcon;
        Intrinsics.checkNotNullParameter(reward, "reward");
        Integer valueOf = Integer.valueOf(reward.getId());
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : i + 1;
        CustomCardView customCardView = this.placeCard;
        bankLotteryPlaceBadgeColor = BankLotteryPageControllerKt.bankLotteryPlaceBadgeColor(i);
        customCardView.setBackground(bankLotteryPlaceBadgeColor);
        this.placeCard.setBackgroundAlpha(100);
        this.place.setText(String.valueOf(intValue));
        TextView textView = this.winnerName;
        String winner = reward.getWinner();
        if (winner != null) {
            String str2 = StringsKt.isBlank(winner) ? null : winner;
            if (str2 != null) {
                str = str2;
                textView.setText(str);
                this.prize.setText(reward.getName());
                this.enchant.setVisibility(reward.getEnchant() <= 0 ? 0 : 4);
                this.enchant.setText(this.itemView.getContext().getString(R.string.bank_lottery_reward_enchant_format, Integer.valueOf(reward.getEnchant())));
                ImageView imageView = this.icon;
                String imgPath = reward.getImgPath();
                fallbackRewardIcon = BankLotteryPageControllerKt.fallbackRewardIcon(reward.getName());
                BankImageLoaderKt.loadBankImage$default(imageView, imgPath, Integer.valueOf(fallbackRewardIcon), false, 4, null);
            }
        }
        String string = this.itemView.getContext().getString(R.string.bank_lottery_reward_pending);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        str = string;
        textView.setText(str);
        this.prize.setText(reward.getName());
        this.enchant.setVisibility(reward.getEnchant() <= 0 ? 0 : 4);
        this.enchant.setText(this.itemView.getContext().getString(R.string.bank_lottery_reward_enchant_format, Integer.valueOf(reward.getEnchant())));
        ImageView imageView2 = this.icon;
        String imgPath2 = reward.getImgPath();
        fallbackRewardIcon = BankLotteryPageControllerKt.fallbackRewardIcon(reward.getName());
        BankImageLoaderKt.loadBankImage$default(imageView2, imgPath2, Integer.valueOf(fallbackRewardIcon), false, 4, null);
    }
}
