package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskReward;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassTaskRewardItemBinding;
/* compiled from: RewardsTasksAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/RodinaBattlePassTaskRewardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassTaskRewardItemBinding;", "getBinding", "()Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassTaskRewardItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "", "reward", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskReward;", "cancelImageLoading", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RodinaBattlePassTaskRewardItemViewHolder extends RecyclerView.ViewHolder {
    private final WinterBattlepassTaskRewardItemBinding binding;
    private Job loadImageJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RodinaBattlePassTaskRewardItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        WinterBattlepassTaskRewardItemBinding bind = WinterBattlepassTaskRewardItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final WinterBattlepassTaskRewardItemBinding getBinding() {
        return this.binding;
    }

    public final void bind(CommonTaskReward reward) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(reward, "reward");
        WinterBattlepassTaskRewardItemBinding winterBattlepassTaskRewardItemBinding = this.binding;
        winterBattlepassTaskRewardItemBinding.taskInfoRewardItemName.setText(reward.getName());
        cancelImageLoading();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RodinaBattlePassTaskRewardItemViewHolder$bind$1$1(winterBattlepassTaskRewardItemBinding, reward, null), 3, null);
        this.loadImageJob = launch$default;
    }

    public final void cancelImageLoading() {
        Job job = this.loadImageJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadImageJob = null;
    }
}
