package ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter;

import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemCharacteristicBinding;
import ru.mrlargha.commonui.elements.tuningAuto.domain.DashboardProperties;
/* compiled from: AutoCharsAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/AutoCharsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemCharacteristicBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemCharacteristicBinding;)V", "bind", "", "item", "Lru/mrlargha/commonui/elements/tuningAuto/domain/DashboardProperties;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutoCharsViewHolder extends RecyclerView.ViewHolder {
    private final ItemCharacteristicBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCharsViewHolder(ItemCharacteristicBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(DashboardProperties item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemCharacteristicBinding itemCharacteristicBinding = this.binding;
        itemCharacteristicBinding.tvTitle.setText(item.getName());
        itemCharacteristicBinding.tvProgressCount.setText(String.valueOf((int) item.getValue()));
        itemCharacteristicBinding.progressView.setProgressBarsFinish((int) ((item.getValue() / item.getValueMax()) * 10));
        if (item.getValueOffset() > 0.0f) {
            TextView tvProgressCountPlus = itemCharacteristicBinding.tvProgressCountPlus;
            Intrinsics.checkNotNullExpressionValue(tvProgressCountPlus, "tvProgressCountPlus");
            tvProgressCountPlus.setVisibility(0);
            itemCharacteristicBinding.tvProgressCountPlus.setText("(+" + item.getValueOffset() + ")");
            itemCharacteristicBinding.tvProgressCountPlus.setTextColor(-16711936);
        } else if (item.getValueOffset() < 0.0f) {
            TextView tvProgressCountPlus2 = itemCharacteristicBinding.tvProgressCountPlus;
            Intrinsics.checkNotNullExpressionValue(tvProgressCountPlus2, "tvProgressCountPlus");
            tvProgressCountPlus2.setVisibility(0);
            itemCharacteristicBinding.tvProgressCountPlus.setText("(" + item.getValueOffset() + ")");
            itemCharacteristicBinding.tvProgressCountPlus.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            TextView tvProgressCountPlus3 = itemCharacteristicBinding.tvProgressCountPlus;
            Intrinsics.checkNotNullExpressionValue(tvProgressCountPlus3, "tvProgressCountPlus");
            tvProgressCountPlus3.setVisibility(8);
        }
    }
}
