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
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassCommonTaskItemBinding;
/* compiled from: CommonTasksAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/RodinaBattlePassCommonTaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassCommonTaskItemBinding;", "getBinding", "()Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassCommonTaskItemBinding;", "defaultItemCountColor", "", "getDefaultItemCountColor", "()I", "defaultRewardDescriptionColor", "getDefaultRewardDescriptionColor", "loadImageJob", "Lkotlinx/coroutines/Job;", "loadRewardImage", "", "isArizona", "", "task", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskInfo;", "cancelImageLoading", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RodinaBattlePassCommonTaskViewHolder extends RecyclerView.ViewHolder {
    private final WinterBattlepassCommonTaskItemBinding binding;
    private final int defaultItemCountColor;
    private final int defaultRewardDescriptionColor;
    private Job loadImageJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RodinaBattlePassCommonTaskViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        WinterBattlepassCommonTaskItemBinding bind = WinterBattlepassCommonTaskItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.defaultItemCountColor = bind.itemCount.getCurrentTextColor();
        this.defaultRewardDescriptionColor = bind.itemRewardDescription.getCurrentTextColor();
    }

    public final WinterBattlepassCommonTaskItemBinding getBinding() {
        return this.binding;
    }

    public final int getDefaultItemCountColor() {
        return this.defaultItemCountColor;
    }

    public final int getDefaultRewardDescriptionColor() {
        return this.defaultRewardDescriptionColor;
    }

    public final void loadRewardImage(boolean z, CommonTaskInfo task) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(task, "task");
        cancelImageLoading();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RodinaBattlePassCommonTaskViewHolder$loadRewardImage$1(z, task, this, null), 3, null);
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
