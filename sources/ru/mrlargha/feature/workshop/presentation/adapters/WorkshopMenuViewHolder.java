package ru.mrlargha.feature.workshop.presentation.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemMenuBtnBinding;
import ru.mrlargha.feature.workshop.presentation.WorkshopMenus;
/* compiled from: WorkshopMenuAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/adapters/WorkshopMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "position", "selectedItemPosition", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopMenuViewHolder extends RecyclerView.ViewHolder {
    private final ItemMenuBtnBinding binding;
    private final Function2<WorkshopMenus, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WorkshopMenuViewHolder(ItemMenuBtnBinding binding, Function2<? super WorkshopMenus, ? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final WorkshopMenus item, final int i, int i2) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMenuBtnBinding itemMenuBtnBinding = this.binding;
        TextView textView = itemMenuBtnBinding.tvCraftMenu;
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText((CharSequence) CollectionsKt.first((List<? extends Object>) StringsKt.split$default((CharSequence) item.menuName(context), new String[]{" "}, false, 0, 6, (Object) null)));
        if (i == i2) {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_white);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(-16777216);
        } else {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_grey);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(-1);
        }
        itemMenuBtnBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.adapters.WorkshopMenuViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopMenuViewHolder.bind$lambda$0$0(WorkshopMenuViewHolder.this, item, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(WorkshopMenuViewHolder workshopMenuViewHolder, WorkshopMenus workshopMenus, int i, View view) {
        workshopMenuViewHolder.onItemClicked.invoke(workshopMenus, Integer.valueOf(i));
    }
}
