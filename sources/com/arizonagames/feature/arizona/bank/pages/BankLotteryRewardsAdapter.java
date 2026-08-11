package com.arizonagames.feature.arizona.bank.pages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankLotteryRewardInfo;
import com.arizonagames.feature.arizona.bank.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u001c\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryRewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "items", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "showWinners", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "submitList", "rewards", "getSpanSize", "isWinnerRow", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryRewardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int FEATURED_WINNERS_COUNT = 3;
    @Deprecated
    public static final int VIEW_TYPE_REWARD_CARD = 0;
    @Deprecated
    public static final int VIEW_TYPE_WINNER_ROW = 1;
    @Deprecated
    public static final int WINNER_ROW_SPAN_COUNT = 3;
    private List<BankLotteryRewardInfo> items = CollectionsKt.emptyList();
    private boolean showWinners;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return isWinnerRow(i) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == 1) {
            i2 = R.layout.bank_lottery_winner_row_item;
        } else {
            i2 = R.layout.bank_lottery_reward_item;
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
        if (i == 1) {
            Intrinsics.checkNotNull(inflate);
            return new BankLotteryWinnerRowViewHolder(inflate);
        }
        Intrinsics.checkNotNull(inflate);
        return new BankLotteryRewardViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof BankLotteryWinnerRowViewHolder) {
            ((BankLotteryWinnerRowViewHolder) holder).bind(this.items.get(i), i);
        } else if (holder instanceof BankLotteryRewardViewHolder) {
            ((BankLotteryRewardViewHolder) holder).bind(this.items.get(i), i, this.showWinners);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void submitList(List<BankLotteryRewardInfo> rewards, boolean z) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        if (Intrinsics.areEqual(this.items, rewards) && this.showWinners == z) {
            return;
        }
        this.items = rewards;
        this.showWinners = z;
        notifyDataSetChanged();
    }

    public final int getSpanSize(int i) {
        return isWinnerRow(i) ? 3 : 1;
    }

    private final boolean isWinnerRow(int i) {
        return this.showWinners && i >= 3;
    }

    /* compiled from: BankLotteryPageController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryRewardsAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_REWARD_CARD", "", "VIEW_TYPE_WINNER_ROW", "FEATURED_WINNERS_COUNT", "WINNER_ROW_SPAN_COUNT", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
