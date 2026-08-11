package ru.mrlargha.feature.workshop.presentation.adapters;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
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
import ru.mrlargha.commonui.elements.inventory.presentation.UtilKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: WorkshopViewHolder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00062\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005J\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/adapters/WorkshopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "isArizona", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lkotlin/jvm/functions/Function1;Z)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "effectLoadJob", "bind", "itemVal", "itemEligibilityPredicate", "recycle", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private Job effectLoadJob;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bind$default(WorkshopViewHolder workshopViewHolder, InventoryItem inventoryItem, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        workshopViewHolder.bind(inventoryItem, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(final InventoryItem itemVal, Function1<? super InventoryItem, Boolean> function1) {
        Integer available;
        boolean z;
        Job job;
        Job job2;
        Job launch$default;
        Integer blackout;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemInventoryBinding itemInventoryBinding = this.binding;
        Log.e("item", "bind: " + itemVal);
        boolean booleanValue = function1 != null ? function1.invoke(itemVal).booleanValue() : true;
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
            CardView cardView = itemInventoryBinding.item;
            Integer background = itemVal.getBackground();
            Intrinsics.checkNotNull(background);
            cardView.setCardBackgroundColor(UtilsKt.getColorTint(background.intValue()));
            itemInventoryBinding.ivItemImage.setBackgroundResource(R.drawable.shining_workshop_color);
        }
        if (!this.isArizona ? !((available = itemVal.getAvailable()) != null && available.intValue() == 0) : !((blackout = itemVal.getBlackout()) != null && blackout.intValue() == 1)) {
            if (booleanValue) {
                z = false;
                View viewCenter = itemInventoryBinding.viewCenter;
                Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
                viewCenter.setVisibility(!z ? 0 : 8);
                itemInventoryBinding.getRoot().setClickable(!z);
                itemInventoryBinding.getRoot().setEnabled(!z);
                if (!z) {
                    itemInventoryBinding.getRoot().setOnClickListener(null);
                } else {
                    itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.workshop.presentation.adapters.WorkshopViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WorkshopViewHolder.bind$lambda$0$0(WorkshopViewHolder.this, itemVal, view);
                        }
                    });
                }
                job = this.loadImageJob;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                if (itemVal.getItem() == null) {
                    launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WorkshopViewHolder$bind$1$2(itemInventoryBinding, this, itemVal, null), 3, null);
                    this.loadImageJob = launch$default;
                    itemInventoryBinding.tvTitleText.setText(UtilKt.inventoryItemDisplayText(itemVal.getText(), itemVal.getItem_type(), itemVal.getEnchant()));
                } else {
                    itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
                    itemInventoryBinding.tvTitleText.setText("");
                }
                AppCompatImageView ivActiveItem = itemInventoryBinding.ivActiveItem;
                Intrinsics.checkNotNullExpressionValue(ivActiveItem, "ivActiveItem");
                AppCompatImageView appCompatImageView = ivActiveItem;
                Integer isActive = itemVal.isActive();
                appCompatImageView.setVisibility(isActive != null && isActive.intValue() == 1 ? 0 : 8);
                if (itemVal.isLocked()) {
                    itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_locked_item);
                    itemInventoryBinding.tvTitleText.setText("");
                }
                job2 = this.effectLoadJob;
                if (job2 != null) {
                    Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.effectLoadJob = UtilKt.setInventoryItemEffect(itemInventoryBinding, itemVal);
            }
        }
        z = true;
        View viewCenter2 = itemInventoryBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
        viewCenter2.setVisibility(!z ? 0 : 8);
        itemInventoryBinding.getRoot().setClickable(!z);
        itemInventoryBinding.getRoot().setEnabled(!z);
        if (!z) {
        }
        job = this.loadImageJob;
        if (job != null) {
        }
        if (itemVal.getItem() == null) {
        }
        AppCompatImageView ivActiveItem2 = itemInventoryBinding.ivActiveItem;
        Intrinsics.checkNotNullExpressionValue(ivActiveItem2, "ivActiveItem");
        AppCompatImageView appCompatImageView2 = ivActiveItem2;
        Integer isActive2 = itemVal.isActive();
        if (isActive2 != null) {
            appCompatImageView2.setVisibility(isActive2 != null && isActive2.intValue() == 1 ? 0 : 8);
            if (itemVal.isLocked()) {
            }
            job2 = this.effectLoadJob;
            if (job2 != null) {
            }
            this.effectLoadJob = UtilKt.setInventoryItemEffect(itemInventoryBinding, itemVal);
        }
        appCompatImageView2.setVisibility(isActive2 != null && isActive2.intValue() == 1 ? 0 : 8);
        if (itemVal.isLocked()) {
        }
        job2 = this.effectLoadJob;
        if (job2 != null) {
        }
        this.effectLoadJob = UtilKt.setInventoryItemEffect(itemInventoryBinding, itemVal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(WorkshopViewHolder workshopViewHolder, InventoryItem inventoryItem, View view) {
        workshopViewHolder.onItemClicked.invoke(inventoryItem);
    }

    public final void recycle() {
        Job job = this.loadImageJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadImageJob = null;
        Job job2 = this.effectLoadJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.effectLoadJob = null;
        UtilKt.clearInventoryItemEffect(this.binding);
    }
}
