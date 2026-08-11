package ru.mrlargha.commonui.elements.trade.presentation.viewholder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
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
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.utils.InventoryDragState;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: SendItemsViewHolder.kt */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0019\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/viewholder/SendItemsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "onItemDropped", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;)V", "scrollSpeed", "", "edgeHeight", "scrollDirection", "scrollHandler", "Landroid/os/Handler;", "getScrollHandler", "()Landroid/os/Handler;", "scrollRunnable", "ru/mrlargha/commonui/elements/trade/presentation/viewholder/SendItemsViewHolder$scrollRunnable$1", "Lru/mrlargha/commonui/elements/trade/presentation/viewholder/SendItemsViewHolder$scrollRunnable$1;", "loadImageJob", "Lkotlinx/coroutines/Job;", "effectLoadJob", "bind", "itemVal", "isDragEnabled", "", "recycle", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SendItemsViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private final Context context;
    private final int edgeHeight;
    private Job effectLoadJob;
    private Job loadImageJob;
    private final Function1<InventoryItem, Unit> onItemClicked;
    private final Function1<DraggedItem, Unit> onItemDropped;
    private final RecyclerView recyclerView;
    private int scrollDirection;
    private final Handler scrollHandler;
    private final SendItemsViewHolder$scrollRunnable$1 scrollRunnable;
    private final int scrollSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [ru.mrlargha.commonui.elements.trade.presentation.viewholder.SendItemsViewHolder$scrollRunnable$1] */
    public SendItemsViewHolder(ItemInventoryBinding binding, Function1<? super InventoryItem, Unit> onItemClicked, Function1<? super DraggedItem, Unit> onItemDropped, Context context, RecyclerView recyclerView) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.onItemDropped = onItemDropped;
        this.context = context;
        this.recyclerView = recyclerView;
        this.scrollSpeed = 30;
        this.edgeHeight = 100;
        this.scrollDirection = 1;
        this.scrollHandler = new Handler(Looper.getMainLooper());
        this.scrollRunnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.SendItemsViewHolder$scrollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView2;
                int i;
                int i2;
                recyclerView2 = SendItemsViewHolder.this.recyclerView;
                i = SendItemsViewHolder.this.scrollDirection;
                i2 = SendItemsViewHolder.this.scrollSpeed;
                recyclerView2.scrollBy(0, i * i2);
                SendItemsViewHolder.this.getScrollHandler().postDelayed(this, 10L);
            }
        };
    }

    public final Handler getScrollHandler() {
        return this.scrollHandler;
    }

    public final void bind(final InventoryItem itemVal, final boolean z) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemInventoryBinding itemInventoryBinding = this.binding;
        Job job = this.effectLoadJob;
        boolean z2 = true;
        Object obj = null;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        itemInventoryBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.SendItemsViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean bind$lambda$0$0;
                bind$lambda$0$0 = SendItemsViewHolder.bind$lambda$0$0(InventoryItem.this, z, view);
                return bind$lambda$0$0;
            }
        });
        itemInventoryBinding.getRoot().setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.SendItemsViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean bind$lambda$0$1;
                bind$lambda$0$1 = SendItemsViewHolder.bind$lambda$0$1(SendItemsViewHolder.this, view, dragEvent);
                return bind$lambda$0$1;
            }
        });
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.SendItemsViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendItemsViewHolder.bind$lambda$0$2(InventoryItem.this, this, view);
            }
        });
        Job job2 = this.loadImageJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SendItemsViewHolder$bind$1$4(itemInventoryBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
            itemInventoryBinding.tvTitleText.setText(itemVal.getText());
        } else {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
        AppCompatImageView ivActiveItem = itemInventoryBinding.ivActiveItem;
        Intrinsics.checkNotNullExpressionValue(ivActiveItem, "ivActiveItem");
        AppCompatImageView appCompatImageView = ivActiveItem;
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int id = ((ItemsInfo) next).getId();
            Integer item = itemVal.getItem();
            if (item != null && id == item.intValue()) {
                obj = next;
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        if (itemsInfo == null || itemsInfo.getActive() != 1) {
            z2 = false;
        }
        appCompatImageView.setVisibility(z2 ? 0 : 8);
        this.effectLoadJob = UtilKt.setInventoryItemEffect(itemInventoryBinding, itemVal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$0(InventoryItem inventoryItem, boolean z, View view) {
        if (inventoryItem.getItem() == null || !z) {
            return false;
        }
        Intrinsics.checkNotNull(view);
        UtilsKt.setDragClick(inventoryItem, view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$1(SendItemsViewHolder sendItemsViewHolder, View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        if (action == 1) {
            Intrinsics.checkNotNull(dragEvent);
            return UtilsKt.getInventoryDragState(dragEvent) != null;
        } else if (action == 3) {
            Intrinsics.checkNotNull(dragEvent);
            InventoryDragState inventoryDragState = UtilsKt.getInventoryDragState(dragEvent);
            if (inventoryDragState != null) {
                sendItemsViewHolder.onItemDropped.invoke(new DraggedItem(inventoryDragState.getItem(), sendItemsViewHolder.getLayoutPosition()));
            }
            view.invalidate();
            InventoryDragState inventoryDragState2 = UtilsKt.getInventoryDragState(dragEvent);
            View sourceView = inventoryDragState2 != null ? inventoryDragState2.getSourceView() : null;
            ConstraintLayout constraintLayout = sourceView instanceof ConstraintLayout ? (ConstraintLayout) sourceView : null;
            ViewParent parent = constraintLayout != null ? constraintLayout.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(constraintLayout);
            }
            sendItemsViewHolder.scrollHandler.removeCallbacks(sendItemsViewHolder.scrollRunnable);
            return true;
        } else {
            if (action != 4) {
                if (action == 5) {
                    boolean z = view.getRight() + sendItemsViewHolder.edgeHeight >= sendItemsViewHolder.recyclerView.getRight() - sendItemsViewHolder.recyclerView.getLeft();
                    boolean z2 = view.getLeft() - sendItemsViewHolder.edgeHeight <= 0;
                    if (z) {
                        sendItemsViewHolder.scrollDirection = 1;
                    } else if (z2) {
                        sendItemsViewHolder.scrollDirection = -1;
                    } else {
                        sendItemsViewHolder.scrollDirection = 0;
                        sendItemsViewHolder.scrollHandler.removeCallbacks(sendItemsViewHolder.scrollRunnable);
                    }
                    if (sendItemsViewHolder.scrollDirection != 0) {
                        sendItemsViewHolder.scrollHandler.post(sendItemsViewHolder.scrollRunnable);
                    }
                    view.invalidate();
                    return true;
                } else if (action != 6) {
                    return false;
                }
            }
            sendItemsViewHolder.scrollHandler.removeCallbacks(sendItemsViewHolder.scrollRunnable);
            view.invalidate();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$2(InventoryItem inventoryItem, SendItemsViewHolder sendItemsViewHolder, View view) {
        Integer available = inventoryItem.getAvailable();
        if ((available != null && available.intValue() == 0) || inventoryItem.getItem() == null) {
            return;
        }
        sendItemsViewHolder.onItemClicked.invoke(inventoryItem);
    }

    public final void recycle() {
        ItemInventoryBinding itemInventoryBinding = this.binding;
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
        this.scrollHandler.removeCallbacks(this.scrollRunnable);
        UtilKt.clearInventoryItemEffect(itemInventoryBinding);
    }
}
