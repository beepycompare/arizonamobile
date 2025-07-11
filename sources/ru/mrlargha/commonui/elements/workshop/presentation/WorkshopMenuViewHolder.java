package ru.mrlargha.commonui.elements.workshop.presentation;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemMenuBtnBinding;
/* compiled from: WorkshopMenuAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/presentation/WorkshopMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;", "onItemClicked", "Lkotlin/Function1;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "", "position", "selectedItemPosition", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkshopMenuViewHolder extends RecyclerView.ViewHolder {
    private final ItemMenuBtnBinding binding;
    private final Function1<Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WorkshopMenuViewHolder(ItemMenuBtnBinding binding, Function1<? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(String item, int i, int i2) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMenuBtnBinding itemMenuBtnBinding = this.binding;
        itemMenuBtnBinding.tvCraftMenu.setText(item);
        if (i == i2) {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_white);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_grey);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(-1);
        }
        itemMenuBtnBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.presentation.WorkshopMenuViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopMenuViewHolder.bind$lambda$1$lambda$0(WorkshopMenuViewHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(WorkshopMenuViewHolder workshopMenuViewHolder, View view) {
        workshopMenuViewHolder.onItemClicked.invoke(Integer.valueOf(workshopMenuViewHolder.getAdapterPosition()));
    }
}
