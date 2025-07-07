package ru.mrlargha.commonui.elements.quest.presentation.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemQuestInfoBinding;
import ru.mrlargha.commonui.elements.quest.domain.ActivityDoneInfo;
/* compiled from: QuestActivityAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestActivityViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemQuestInfoBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemQuestInfoBinding;)V", "bind", "", "item", "Lru/mrlargha/commonui/elements/quest/domain/ActivityDoneInfo;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestActivityViewHolder extends RecyclerView.ViewHolder {
    private final ItemQuestInfoBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestActivityViewHolder(ItemQuestInfoBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(ActivityDoneInfo item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemQuestInfoBinding itemQuestInfoBinding = this.binding;
        itemQuestInfoBinding.tvQuestCount.setText(String.valueOf(item.getCount()));
        itemQuestInfoBinding.tvQuestInfo.setText(item.getName());
    }
}
