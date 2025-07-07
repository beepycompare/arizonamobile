package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.WinterBattlepassTaskRewardItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CommonTaskReward;
/* compiled from: RewardsTasksAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0014\u0010\u0018\u001a\u00020\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/RewardsTasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/RodinaBattlePassTaskRewardItemViewHolder;", "isArizona", "", "<init>", "(Z)V", "()Z", "rewards", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CommonTaskReward;", "Lkotlin/collections/ArrayList;", "loadImageJob", "Lkotlinx/coroutines/Job;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "setRewards", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardsTasksAdapter extends RecyclerView.Adapter<RodinaBattlePassTaskRewardItemViewHolder> {
    private final boolean isArizona;
    private Job loadImageJob;
    private final ArrayList<CommonTaskReward> rewards = new ArrayList<>();

    public RewardsTasksAdapter(boolean z) {
        this.isArizona = z;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RodinaBattlePassTaskRewardItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_task_reward_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RodinaBattlePassTaskRewardItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RodinaBattlePassTaskRewardItemViewHolder holder, int i) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CommonTaskReward commonTaskReward = this.rewards.get(i);
        Intrinsics.checkNotNullExpressionValue(commonTaskReward, "get(...)");
        CommonTaskReward commonTaskReward2 = commonTaskReward;
        WinterBattlepassTaskRewardItemBinding binding = holder.getBinding();
        binding.taskInfoRewardItemName.setText(commonTaskReward2.getName());
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RewardsTasksAdapter$onBindViewHolder$1$1(binding, holder, commonTaskReward2, null), 3, null);
        this.loadImageJob = launch$default;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rewards.size();
    }

    public final void setRewards(List<CommonTaskReward> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.rewards.clear();
        this.rewards.addAll(rewards);
        notifyDataSetChanged();
    }
}
