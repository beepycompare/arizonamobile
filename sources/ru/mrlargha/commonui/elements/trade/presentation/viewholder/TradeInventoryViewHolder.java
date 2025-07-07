package ru.mrlargha.commonui.elements.trade.presentation.viewholder;

import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
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
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: TradeInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0017\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/viewholder/TradeInventoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "onItemDropped", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/recyclerview/widget/RecyclerView;)V", "scrollSpeed", "", "edgeHeight", "scrollDirection", "scrollHandler", "Landroid/os/Handler;", "getScrollHandler", "()Landroid/os/Handler;", "scrollRunnable", "ru/mrlargha/commonui/elements/trade/presentation/viewholder/TradeInventoryViewHolder$scrollRunnable$1", "Lru/mrlargha/commonui/elements/trade/presentation/viewholder/TradeInventoryViewHolder$scrollRunnable$1;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "itemVal", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TradeInventoryViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private final int edgeHeight;
    private Job loadImageJob;
    private final Function1<InventoryItem, Unit> onItemClicked;
    private final Function1<DraggedItem, Unit> onItemDropped;
    private final RecyclerView recyclerView;
    private int scrollDirection;
    private final Handler scrollHandler;
    private final TradeInventoryViewHolder$scrollRunnable$1 scrollRunnable;
    private final int scrollSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [ru.mrlargha.commonui.elements.trade.presentation.viewholder.TradeInventoryViewHolder$scrollRunnable$1] */
    public TradeInventoryViewHolder(ItemInventoryBinding binding, Function1<? super InventoryItem, Unit> onItemClicked, Function1<? super DraggedItem, Unit> onItemDropped, RecyclerView recyclerView) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.onItemDropped = onItemDropped;
        this.recyclerView = recyclerView;
        this.scrollSpeed = 30;
        this.edgeHeight = 100;
        this.scrollDirection = 1;
        this.scrollHandler = new Handler(Looper.getMainLooper());
        this.scrollRunnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.TradeInventoryViewHolder$scrollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView2;
                int i;
                int i2;
                recyclerView2 = TradeInventoryViewHolder.this.recyclerView;
                i = TradeInventoryViewHolder.this.scrollDirection;
                i2 = TradeInventoryViewHolder.this.scrollSpeed;
                recyclerView2.scrollBy(0, i * i2);
                TradeInventoryViewHolder.this.getScrollHandler().postDelayed(this, 10L);
            }
        };
    }

    public final Handler getScrollHandler() {
        return this.scrollHandler;
    }

    public final void bind(final InventoryItem itemVal) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemInventoryBinding itemInventoryBinding = this.binding;
        itemInventoryBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.TradeInventoryViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean bind$lambda$4$lambda$0;
                bind$lambda$4$lambda$0 = TradeInventoryViewHolder.bind$lambda$4$lambda$0(InventoryItem.this, view);
                return bind$lambda$4$lambda$0;
            }
        });
        itemInventoryBinding.getRoot().setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.TradeInventoryViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean bind$lambda$4$lambda$1;
                bind$lambda$4$lambda$1 = TradeInventoryViewHolder.bind$lambda$4$lambda$1(TradeInventoryViewHolder.this, view, dragEvent);
                return bind$lambda$4$lambda$1;
            }
        });
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.viewholder.TradeInventoryViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradeInventoryViewHolder.bind$lambda$4$lambda$2(InventoryItem.this, this, view);
            }
        });
        Job job = this.loadImageJob;
        Object obj = null;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TradeInventoryViewHolder$bind$1$4(itemInventoryBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
            itemInventoryBinding.tvTitleText.setText(itemVal.getText());
        } else {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
            itemInventoryBinding.tvTitleText.setText("");
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
            itemInventoryBinding.item.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getBackground().intValue()));
            itemInventoryBinding.ivItemImage.setBackgroundResource(R.drawable.shining_workshop_color);
        }
        View viewCenter = itemInventoryBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
        Integer blackout = itemVal.getBlackout();
        viewCenter.setVisibility(blackout != null && blackout.intValue() == 1 ? 0 : 8);
        Integer available = itemVal.getAvailable();
        if (available != null && available.intValue() == 0) {
            itemInventoryBinding.getRoot().setClickable(false);
            View viewCenter2 = itemInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
            viewCenter2.setVisibility(0);
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
            z = false;
        }
        appCompatImageView.setVisibility(z ? 0 : 8);
        Integer available2 = itemVal.getAvailable();
        if (available2 != null && available2.intValue() == 0) {
            itemInventoryBinding.getRoot().setClickable(false);
            View viewCenter3 = itemInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter3, "viewCenter");
            viewCenter3.setVisibility(0);
        }
        if (itemVal.isLocked()) {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_locked_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$4$lambda$0(InventoryItem inventoryItem, View view) {
        if (inventoryItem.getItem() != null) {
            Intrinsics.checkNotNull(view);
            UtilsKt.setDragClick(inventoryItem, view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$4$lambda$1(TradeInventoryViewHolder tradeInventoryViewHolder, View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        if (action != 1) {
            if (action == 3) {
                if (dragEvent.getClipData() != null) {
                    Object fromJson = GsonStore.INSTANCE.getGson().fromJson(UtilsKt.updateJsonString(dragEvent.getClipData().getItemAt(0).getText().toString()), (Class<Object>) InventoryItem.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    tradeInventoryViewHolder.onItemDropped.invoke(new DraggedItem((InventoryItem) fromJson, tradeInventoryViewHolder.getLayoutPosition()));
                }
                view.invalidate();
                Object localState = dragEvent.getLocalState();
                ConstraintLayout constraintLayout = localState instanceof ConstraintLayout ? (ConstraintLayout) localState : null;
                ViewParent parent = constraintLayout != null ? constraintLayout.getParent() : null;
                ViewGroup viewGroup = parent instanceof ViewGroup ? parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(constraintLayout);
                }
                tradeInventoryViewHolder.scrollHandler.removeCallbacks(tradeInventoryViewHolder.scrollRunnable);
                return true;
            }
            if (action != 4) {
                if (action == 5) {
                    boolean z = view.getRight() + tradeInventoryViewHolder.edgeHeight >= tradeInventoryViewHolder.recyclerView.getRight() - tradeInventoryViewHolder.recyclerView.getLeft();
                    boolean z2 = view.getLeft() - tradeInventoryViewHolder.edgeHeight <= 0;
                    if (z) {
                        tradeInventoryViewHolder.scrollDirection = 1;
                    } else if (z2) {
                        tradeInventoryViewHolder.scrollDirection = -1;
                    } else {
                        tradeInventoryViewHolder.scrollDirection = 0;
                        tradeInventoryViewHolder.scrollHandler.removeCallbacks(tradeInventoryViewHolder.scrollRunnable);
                    }
                    if (tradeInventoryViewHolder.scrollDirection != 0) {
                        tradeInventoryViewHolder.scrollHandler.post(tradeInventoryViewHolder.scrollRunnable);
                    }
                    view.invalidate();
                    return true;
                } else if (action != 6) {
                    return false;
                }
            }
            tradeInventoryViewHolder.scrollHandler.removeCallbacks(tradeInventoryViewHolder.scrollRunnable);
            view.invalidate();
            return true;
        }
        return dragEvent.getClipDescription().hasMimeType("text/plain");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$4$lambda$2(InventoryItem inventoryItem, TradeInventoryViewHolder tradeInventoryViewHolder, View view) {
        Integer available = inventoryItem.getAvailable();
        if ((available != null && available.intValue() == 0) || inventoryItem.getItem() == null) {
            return;
        }
        tradeInventoryViewHolder.onItemClicked.invoke(inventoryItem);
    }
}
