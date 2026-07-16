package ru.mrlargha.feature.battlepassWinter2025;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskReward;
/* compiled from: RewardsTasksAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\b\u0001\u0010\u0003\u001a\u00020\u0004:\u0002\b\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0014\u0010\u0016\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0017R\u0015\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0005¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/RewardsTasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/feature/battlepassWinter2025/RodinaBattlePassTaskRewardItemViewHolder;", "itemLayout", "", "Landroidx/annotation/LayoutRes;", "<init>", "(I)V", "rewards", "Ljava/util/ArrayList;", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskReward;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "getItemCount", "setRewards", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardsTasksAdapter extends RecyclerView.Adapter<RodinaBattlePassTaskRewardItemViewHolder> {
    private final int itemLayout;
    private final ArrayList<CommonTaskReward> rewards = new ArrayList<>();

    public RewardsTasksAdapter(int i) {
        this.itemLayout = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RodinaBattlePassTaskRewardItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RodinaBattlePassTaskRewardItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RodinaBattlePassTaskRewardItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CommonTaskReward commonTaskReward = this.rewards.get(i);
        Intrinsics.checkNotNullExpressionValue(commonTaskReward, "get(...)");
        holder.bind(commonTaskReward);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RodinaBattlePassTaskRewardItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.cancelImageLoading();
        super.onViewRecycled((RewardsTasksAdapter) holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rewards.size();
    }

    public final void setRewards(List<CommonTaskReward> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        this.rewards.clear();
        this.rewards.addAll(rewards);
        notifyDataSetChanged();
    }
}
