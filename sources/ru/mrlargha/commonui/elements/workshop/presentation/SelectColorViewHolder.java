package ru.mrlargha.commonui.elements.workshop.presentation;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemWorkbenchColorBinding;
import ru.mrlargha.commonui.elements.craft.domain.ItemColor;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: SelectColorViewHolder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/presentation/SelectColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemWorkbenchColorBinding;", "onItemClicked", "Lkotlin/Function2;", "", "Lru/mrlargha/commonui/elements/craft/domain/ItemColor;", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemWorkbenchColorBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "position", "selectedItemPosition", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectColorViewHolder extends RecyclerView.ViewHolder {
    private final ItemWorkbenchColorBinding binding;
    private final Function2<Integer, ItemColor, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectColorViewHolder(ItemWorkbenchColorBinding binding, Function2<? super Integer, ? super ItemColor, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final ItemColor item, int i, int i2) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemWorkbenchColorBinding itemWorkbenchColorBinding = this.binding;
        itemWorkbenchColorBinding.parentCardView.setCardBackgroundColor(UtilsKt.getColorTint(item.getColor()));
        ImageView ivSelectedColor = itemWorkbenchColorBinding.ivSelectedColor;
        Intrinsics.checkNotNullExpressionValue(ivSelectedColor, "ivSelectedColor");
        ivSelectedColor.setVisibility(i == i2 ? 0 : 8);
        itemWorkbenchColorBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.presentation.SelectColorViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectColorViewHolder.bind$lambda$1$lambda$0(SelectColorViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(SelectColorViewHolder selectColorViewHolder, ItemColor itemColor, View view) {
        selectColorViewHolder.onItemClicked.invoke(Integer.valueOf(selectColorViewHolder.getAdapterPosition()), itemColor);
    }
}
