package ru.mrlargha.commonui.elements.quest.presentation.viewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemQuestStageBinding;
import ru.mrlargha.commonui.elements.quest.domain.QuestStage;
/* compiled from: QuestStageViewHolder.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/viewHolder/QuestStageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemQuestStageBinding;", "onItemClick", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/quest/domain/QuestStage;", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemQuestStageBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestStageViewHolder extends RecyclerView.ViewHolder {
    private final ItemQuestStageBinding binding;
    private final Function1<QuestStage, Unit> onItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuestStageViewHolder(ItemQuestStageBinding binding, Function1<? super QuestStage, Unit> onItemClick) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.binding = binding;
        this.onItemClick = onItemClick;
    }

    public final void bind(final QuestStage item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemQuestStageBinding itemQuestStageBinding = this.binding;
        itemQuestStageBinding.tvStage.setText(item.getTitle());
        itemQuestStageBinding.tvStageDesc.setText(item.getDescription());
        if (item.getProgress() == item.getMaxProgress()) {
            TextView tvDone = itemQuestStageBinding.tvDone;
            Intrinsics.checkNotNullExpressionValue(tvDone, "tvDone");
            tvDone.setVisibility(0);
            TextView tvProgress = itemQuestStageBinding.tvProgress;
            Intrinsics.checkNotNullExpressionValue(tvProgress, "tvProgress");
            tvProgress.setVisibility(8);
            TextView tvStageCount = itemQuestStageBinding.tvStageCount;
            Intrinsics.checkNotNullExpressionValue(tvStageCount, "tvStageCount");
            tvStageCount.setVisibility(8);
        } else {
            TextView tvDone2 = itemQuestStageBinding.tvDone;
            Intrinsics.checkNotNullExpressionValue(tvDone2, "tvDone");
            tvDone2.setVisibility(8);
            TextView tvProgress2 = itemQuestStageBinding.tvProgress;
            Intrinsics.checkNotNullExpressionValue(tvProgress2, "tvProgress");
            tvProgress2.setVisibility(0);
            TextView textView = itemQuestStageBinding.tvStageDesc;
            int progress = item.getProgress();
            textView.setText(progress + " / " + item.getMaxProgress());
        }
        itemQuestStageBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.presentation.viewHolder.QuestStageViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestStageViewHolder.bind$lambda$1$lambda$0(QuestStageViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(QuestStageViewHolder questStageViewHolder, QuestStage questStage, View view) {
        questStageViewHolder.onItemClick.invoke(questStage);
    }
}
