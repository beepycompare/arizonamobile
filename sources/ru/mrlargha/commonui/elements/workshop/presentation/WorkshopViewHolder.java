package ru.mrlargha.commonui.elements.workshop.presentation;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: WorkshopViewHolder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/workshop/presentation/WorkshopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "isArizona", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lkotlin/jvm/functions/Function1;Z)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "itemVal", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkshopViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private final boolean isArizona;
    private Job loadImageJob;
    private final Function1<InventoryItem, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WorkshopViewHolder(ItemInventoryBinding binding, Function1<? super InventoryItem, Unit> onItemClicked, boolean z) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.isArizona = z;
    }

    public final void bind(final InventoryItem itemVal) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemInventoryBinding itemInventoryBinding = this.binding;
        Log.e("item", "bind: " + itemVal);
        Integer itemStrength = itemVal.getItemStrength();
        final int intValue = itemStrength != null ? itemStrength.intValue() : 100;
        if (itemVal.getItem() != null) {
            itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.presentation.WorkshopViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WorkshopViewHolder.bind$lambda$2$lambda$0(InventoryItem.this, intValue, this, view);
                }
            });
        }
        if (itemVal.getBackground() == null) {
            ImageView ivDefaultItem = itemInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem, "ivDefaultItem");
            ivDefaultItem.setVisibility(0);
            itemInventoryBinding.ivItemImage.setBackgroundResource(0);
        } else {
            ImageView ivDefaultItem2 = itemInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem2, "ivDefaultItem");
            ivDefaultItem2.setVisibility(8);
            Log.e("item", "bind: " + itemVal);
            itemInventoryBinding.item.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getBackground().intValue()));
            itemInventoryBinding.ivItemImage.setBackgroundResource(R.drawable.shining_workshop_color);
        }
        boolean z = true;
        if (this.isArizona) {
            View viewCenter = itemInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
            Integer blackout = itemVal.getBlackout();
            viewCenter.setVisibility(blackout != null && blackout.intValue() == 0 ? 0 : 8);
            Integer blackout2 = itemVal.getBlackout();
            if (blackout2 != null && blackout2.intValue() == 1) {
                itemInventoryBinding.getRoot().setClickable(false);
                itemInventoryBinding.getRoot().setEnabled(false);
                View viewCenter2 = itemInventoryBinding.viewCenter;
                Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
                viewCenter2.setVisibility(0);
            } else {
                View viewCenter3 = itemInventoryBinding.viewCenter;
                Intrinsics.checkNotNullExpressionValue(viewCenter3, "viewCenter");
                viewCenter3.setVisibility(8);
                itemInventoryBinding.getRoot().setClickable(true);
                itemInventoryBinding.getRoot().setEnabled(true);
            }
        } else {
            View viewCenter4 = itemInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter4, "viewCenter");
            Integer available = itemVal.getAvailable();
            viewCenter4.setVisibility(available != null && available.intValue() == 1 ? 0 : 8);
            Integer available2 = itemVal.getAvailable();
            if (available2 != null && available2.intValue() == 0) {
                itemInventoryBinding.getRoot().setClickable(false);
                itemInventoryBinding.getRoot().setEnabled(false);
                View viewCenter5 = itemInventoryBinding.viewCenter;
                Intrinsics.checkNotNullExpressionValue(viewCenter5, "viewCenter");
                viewCenter5.setVisibility(0);
            } else {
                View viewCenter6 = itemInventoryBinding.viewCenter;
                Intrinsics.checkNotNullExpressionValue(viewCenter6, "viewCenter");
                viewCenter6.setVisibility(8);
                itemInventoryBinding.getRoot().setClickable(true);
                itemInventoryBinding.getRoot().setEnabled(true);
            }
        }
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.workshop.presentation.WorkshopViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkshopViewHolder.bind$lambda$2$lambda$1(WorkshopViewHolder.this, itemVal, view);
            }
        });
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WorkshopViewHolder$bind$1$3(itemInventoryBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
            itemInventoryBinding.tvTitleText.setText(itemVal.getText());
        } else {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
        AppCompatImageView ivActiveItem = itemInventoryBinding.ivActiveItem;
        Intrinsics.checkNotNullExpressionValue(ivActiveItem, "ivActiveItem");
        AppCompatImageView appCompatImageView = ivActiveItem;
        Integer isActive = itemVal.isActive();
        if (isActive == null || isActive.intValue() != 1) {
            z = false;
        }
        appCompatImageView.setVisibility(z ? 0 : 8);
        if (itemVal.isLocked()) {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_locked_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$0(InventoryItem inventoryItem, int i, WorkshopViewHolder workshopViewHolder, View view) {
        Integer available = inventoryItem.getAvailable();
        if (available != null && available.intValue() == 0 && i >= 100) {
            return;
        }
        workshopViewHolder.onItemClicked.invoke(inventoryItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$1(WorkshopViewHolder workshopViewHolder, InventoryItem inventoryItem, View view) {
        workshopViewHolder.onItemClicked.invoke(inventoryItem);
    }
}
