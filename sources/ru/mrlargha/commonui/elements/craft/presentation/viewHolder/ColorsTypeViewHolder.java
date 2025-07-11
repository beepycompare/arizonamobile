package ru.mrlargha.commonui.elements.craft.presentation.viewHolder;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemColorBinding;
import ru.mrlargha.commonui.elements.craft.domain.ItemColor;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: ColorsTypeViewHolder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/viewHolder/ColorsTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemColorBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/craft/domain/ItemColor;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemColorBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ColorsTypeViewHolder extends RecyclerView.ViewHolder {
    private final ItemColorBinding binding;
    private final Function2<ItemColor, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ColorsTypeViewHolder(ItemColorBinding binding, Function2<? super ItemColor, ? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final ItemColor item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemColorBinding itemColorBinding = this.binding;
        itemColorBinding.viewBgLocked.setBackgroundResource(R.drawable.shining_craft_color_test2);
        itemColorBinding.parentCardView.setCardBackgroundColor(UtilsKt.getColorTint(item.getColor()));
        itemColorBinding.tvColorName.setText(item.getName());
        if (item.isLocked()) {
            TextView tvColorName = itemColorBinding.tvColorName;
            Intrinsics.checkNotNullExpressionValue(tvColorName, "tvColorName");
            tvColorName.setVisibility(8);
            itemColorBinding.viewBgLocked.setBackgroundResource(R.drawable.bg_locked_color_item);
            itemColorBinding.parentCardView.setCardBackgroundColor(UtilsKt.getColorTint(R.color.transparent100));
        }
        if (item.getColor() == -858993409) {
            itemColorBinding.tvColorName.setText("Без цвета");
            itemColorBinding.tvColorName.setTextColor(Color.parseColor("#FFFFFF"));
            itemColorBinding.viewBgLocked.setBackgroundResource(R.drawable.bg_item_without_color);
            itemColorBinding.parentCardView.setCardBackgroundColor(UtilsKt.getColorTint(R.color.transparent100));
        }
        itemColorBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.viewHolder.ColorsTypeViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColorsTypeViewHolder.bind$lambda$1$lambda$0(ColorsTypeViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(ColorsTypeViewHolder colorsTypeViewHolder, ItemColor itemColor, View view) {
        colorsTypeViewHolder.onItemClicked.invoke(itemColor, Integer.valueOf(colorsTypeViewHolder.getPosition()));
    }
}
