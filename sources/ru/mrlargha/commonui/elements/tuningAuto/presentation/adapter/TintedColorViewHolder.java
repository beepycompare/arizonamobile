package ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemTuningSelectColorBinding;
import ru.mrlargha.commonui.elements.tuningAuto.domain.SelectedColors;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: TintedColorAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TintedColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemTuningSelectColorBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/tuningAuto/domain/SelectedColors;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemTuningSelectColorBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TintedColorViewHolder extends RecyclerView.ViewHolder {
    private final ItemTuningSelectColorBinding binding;
    private final Function2<SelectedColors, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TintedColorViewHolder(ItemTuningSelectColorBinding binding, Function2<? super SelectedColors, ? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final SelectedColors item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTuningSelectColorBinding itemTuningSelectColorBinding = this.binding;
        itemTuningSelectColorBinding.viewColor.setBackgroundColor(UtilsKt.getColorTint(item.getColor()));
        ImageView ivSelectedColor = itemTuningSelectColorBinding.ivSelectedColor;
        Intrinsics.checkNotNullExpressionValue(ivSelectedColor, "ivSelectedColor");
        ivSelectedColor.setVisibility(item.isSelected() ? 0 : 8);
        itemTuningSelectColorBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.TintedColorViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TintedColorViewHolder.bind$lambda$1$lambda$0(TintedColorViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(TintedColorViewHolder tintedColorViewHolder, SelectedColors selectedColors, View view) {
        tintedColorViewHolder.onItemClicked.invoke(selectedColors, Integer.valueOf(tintedColorViewHolder.getAdapterPosition()));
    }
}
