package ru.mrlargha.feature.workshop.presentation.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemMenuBtnBinding;
import ru.mrlargha.feature.workshop.presentation.WorkshopMenus;
/* compiled from: WorkshopMenuAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ&\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/adapters/WorkshopMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/feature/workshop/presentation/WorkshopMenus;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "position", "selectedItemPosition", "showFullMenuName", "", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    public final void bind(final WorkshopMenus item, final int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemMenuBtnBinding itemMenuBtnBinding = this.binding;
        Context context = itemMenuBtnBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String menuName = item.menuName(context);
        TextView textView = itemMenuBtnBinding.tvCraftMenu;
        if (!z) {
            menuName = StringsKt.substringBefore$default(menuName, ' ', (String) null, 2, (Object) null);
        }
        textView.setText(menuName);
        ConstraintLayout constraintLayout = itemMenuBtnBinding.parentLayout;
        ViewGroup.LayoutParams layoutParams = itemMenuBtnBinding.parentLayout.getLayoutParams();
        layoutParams.width = itemMenuBtnBinding.parentLayout.getResources().getDimensionPixelSize(z ? R.dimen._120sdp : R.dimen._90sdp);
        constraintLayout.setLayoutParams(layoutParams);
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
                WorkshopMenuViewHolder.bind$lambda$0$1(WorkshopMenuViewHolder.this, item, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$1(WorkshopMenuViewHolder workshopMenuViewHolder, WorkshopMenus workshopMenus, int i, View view) {
        workshopMenuViewHolder.onItemClicked.invoke(workshopMenus, Integer.valueOf(i));
    }
}
