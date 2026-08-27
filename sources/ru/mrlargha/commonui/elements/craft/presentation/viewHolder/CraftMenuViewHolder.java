package ru.mrlargha.commonui.elements.craft.presentation.viewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemMenuBtnBinding;
import ru.mrlargha.commonui.elements.craft.domain.CategoryItem;
import ru.mrlargha.commonui.elements.craft.domain.CraftResponseKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: CraftMenuViewHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/viewHolder/CraftMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;", "onItemClicked", "Lkotlin/Function2;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "Lru/mrlargha/commonui/elements/craft/domain/CategoryItem;", "position", "selectedItemPosition", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CraftMenuViewHolder extends RecyclerView.ViewHolder {
    private final ItemMenuBtnBinding binding;
    private final Function2<Integer, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CraftMenuViewHolder(ItemMenuBtnBinding binding, Function2<? super Integer, ? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r3 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(final CategoryItem item, int i, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMenuBtnBinding itemMenuBtnBinding = this.binding;
        TextView textView = itemMenuBtnBinding.tvCraftMenu;
        if (UtilsKt.isArizonaType()) {
            String name = item.getName();
            if (name != null) {
                r3 = Boolean.valueOf(StringsKt.isBlank(name) ^ true).booleanValue() ? name : null;
            }
            r3 = (String) CollectionsKt.getOrNull(CraftResponseKt.getArizonaCraftCategories(), item.getCategory());
            if (r3 == null) {
                r3 = String.valueOf(item.getCategory());
            }
            str = r3;
        } else {
            String str2 = (String) CollectionsKt.getOrNull(CraftResponseKt.getRodinaCraftCategories(), item.getCategory());
            if (str2 == null) {
                String name2 = item.getName();
                if (name2 != null && Boolean.valueOf(!StringsKt.isBlank(name2)).booleanValue()) {
                    r3 = name2;
                }
                str2 = r3 == null ? String.valueOf(item.getCategory()) : r3;
            }
            str = str2;
        }
        textView.setText(str);
        if (i == i2) {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_white);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(-16777216);
        } else {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_grey);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(-1);
        }
        itemMenuBtnBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.viewHolder.CraftMenuViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftMenuViewHolder.bind$lambda$0$2(CraftMenuViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$2(CraftMenuViewHolder craftMenuViewHolder, CategoryItem categoryItem, View view) {
        int bindingAdapterPosition = craftMenuViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            craftMenuViewHolder.onItemClicked.invoke(Integer.valueOf(categoryItem.getCategory()), Integer.valueOf(bindingAdapterPosition));
        }
    }
}
