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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryRewardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "placeCard", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "place", "Landroid/widget/TextView;", "glow", "icon", "Landroid/widget/ImageView;", "title", "subtitle", "enchant", "bind", "", "reward", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "position", "", "showWinners", "", "bindWinnerText", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BankLotteryRewardViewHolder extends RecyclerView.ViewHolder {
    private final TextView enchant;
    private final CustomCardView glow;
    private final ImageView icon;
    private final TextView place;
    private final CustomCardView placeCard;
    private final TextView subtitle;
    private final TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankLotteryRewardViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.bank_lottery_reward_place_card);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.placeCard = (CustomCardView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.bank_lottery_reward_place);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.place = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.bank_lottery_reward_glow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.glow = (CustomCardView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.bank_lottery_reward_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.icon = (ImageView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.bank_lottery_reward_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.title = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.bank_lottery_reward_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.subtitle = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.bank_lottery_reward_enchant);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.enchant = (TextView) findViewById7;
    }

    public final void bind(BankLotteryRewardInfo reward, int i, boolean z) {
        int bankLotteryPlaceBadgeColor;
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
        this.place.setText(this.itemView.getContext().getString(R.string.bank_lottery_reward_place_format, Integer.valueOf(intValue)));
        this.enchant.setVisibility(reward.getEnchant() > 0 ? 0 : 8);
        this.enchant.setText(this.itemView.getContext().getString(R.string.bank_lottery_reward_enchant_format, Integer.valueOf(reward.getEnchant())));
        ImageView imageView = this.icon;
        String imgPath = reward.getImgPath();
        fallbackRewardIcon = BankLotteryPageControllerKt.fallbackRewardIcon(reward.getName());
        BankImageLoaderKt.loadBankImage$default(imageView, imgPath, Integer.valueOf(fallbackRewardIcon), false, 4, null);
        BankLotteryPageControllerKt.bindBankLotteryRewardGlow(this.glow, reward.getBgColor());
        if (z) {
            bindWinnerText(reward);
            return;
        }
        this.title.setText(reward.getName());
        this.subtitle.setVisibility(8);
    }

    private final void bindWinnerText(BankLotteryRewardInfo bankLotteryRewardInfo) {
        this.subtitle.setVisibility(8);
        String winner = bankLotteryRewardInfo.getWinner();
        if (winner == null || StringsKt.isBlank(winner)) {
            this.title.setText(R.string.bank_lottery_reward_pending);
        } else {
            this.title.setText(bankLotteryRewardInfo.getWinner());
        }
    }
}
