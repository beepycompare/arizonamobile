package ru.mrlargha.commonui.elements.craft.presentation.viewHolder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.databinding.ItemBulletBinding;
import ru.mrlargha.commonui.elements.craft.domain.CraftItem;
/* compiled from: CraftItemsViewHolder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/viewHolder/CraftItemsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemBulletBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/craft/domain/CraftItem;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemBulletBinding;Lkotlin/jvm/functions/Function2;)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "item", "position", "selectedItemPosition", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftItemsViewHolder extends RecyclerView.ViewHolder {
    private final ItemBulletBinding binding;
    private Job loadImageJob;
    private final Function2<CraftItem, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CraftItemsViewHolder(ItemBulletBinding binding, Function2<? super CraftItem, ? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final CraftItem item, int i, int i2) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(item, "item");
        ItemBulletBinding itemBulletBinding = this.binding;
        itemBulletBinding.tvItemName.setText(item.getName());
        View selectedView = itemBulletBinding.selectedView;
        Intrinsics.checkNotNullExpressionValue(selectedView, "selectedView");
        selectedView.setVisibility(i == i2 ? 0 : 8);
        itemBulletBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.viewHolder.CraftItemsViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftItemsViewHolder.bind$lambda$1$lambda$0(CraftItemsViewHolder.this, item, view);
            }
        });
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CraftItemsViewHolder$bind$1$2(itemBulletBinding, this, item, null), 3, null);
        this.loadImageJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(CraftItemsViewHolder craftItemsViewHolder, CraftItem craftItem, View view) {
        craftItemsViewHolder.onItemClicked.invoke(craftItem, Integer.valueOf(craftItemsViewHolder.getAdapterPosition()));
    }
}
