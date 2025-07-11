package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.WinterBattlepassCommonTaskItemBinding;
/* compiled from: CommonTasksAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/RodinaBattlePassCommonTaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/WinterBattlepassCommonTaskItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/WinterBattlepassCommonTaskItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RodinaBattlePassCommonTaskViewHolder extends RecyclerView.ViewHolder {
    private final WinterBattlepassCommonTaskItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RodinaBattlePassCommonTaskViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        WinterBattlepassCommonTaskItemBinding bind = WinterBattlepassCommonTaskItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final WinterBattlepassCommonTaskItemBinding getBinding() {
        return this.binding;
    }
}
