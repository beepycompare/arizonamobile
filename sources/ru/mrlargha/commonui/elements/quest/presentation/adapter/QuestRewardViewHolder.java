package ru.mrlargha.commonui.elements.quest.presentation.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.databinding.ItemQuestRewardBinding;
import ru.mrlargha.commonui.elements.quest.domain.QuestReward;
/* compiled from: QuestRewardAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestRewardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemQuestRewardBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemQuestRewardBinding;)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "", "item", "Lru/mrlargha/commonui/elements/quest/domain/QuestReward;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestRewardViewHolder extends RecyclerView.ViewHolder {
    private final ItemQuestRewardBinding binding;
    private Job loadImageJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestRewardViewHolder(ItemQuestRewardBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(QuestReward item) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(item, "item");
        ItemQuestRewardBinding itemQuestRewardBinding = this.binding;
        itemQuestRewardBinding.tvRewardDesc.setText(item.getTitle());
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new QuestRewardViewHolder$bind$1$1(itemQuestRewardBinding, this, item, null), 3, null);
        this.loadImageJob = launch$default;
    }
}
