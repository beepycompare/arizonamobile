package ru.mrlargha.commonui.elements.trade.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.databinding.ItemTradeBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.trade.presentation.viewholder.SendItemsViewHolder;
/* compiled from: SendItemsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB?\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/adapter/SendItemsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "Lru/mrlargha/commonui/elements/trade/presentation/viewholder/SendItemsViewHolder;", "onItemDropped", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "onItemClicked", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "isDragDropEnabled", "", "()Z", "setDragDropEnabled", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendItemsAdapter extends ListAdapter<InventoryItem, SendItemsViewHolder> {
    private final Context context;
    private boolean isDragDropEnabled;
    private final Function1<InventoryItem, Unit> onItemClicked;
    private final Function1<DraggedItem, Unit> onItemDropped;
    private final RecyclerView recyclerView;
    public static final Companion Companion = new Companion(null);
    private static final SendItemsAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<InventoryItem>() { // from class: ru.mrlargha.commonui.elements.trade.presentation.adapter.SendItemsAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(InventoryItem oldItem, InventoryItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getSlot() == newItem.getSlot();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(InventoryItem oldItem, InventoryItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SendItemsAdapter(Function1<? super DraggedItem, Unit> onItemDropped, RecyclerView recyclerView, Context context, Function1<? super InventoryItem, Unit> onItemClicked) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemDropped = onItemDropped;
        this.recyclerView = recyclerView;
        this.context = context;
        this.onItemClicked = onItemClicked;
    }

    public final boolean isDragDropEnabled() {
        return this.isDragDropEnabled;
    }

    public final void setDragDropEnabled(boolean z) {
        this.isDragDropEnabled = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SendItemsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTradeBinding inflate = ItemTradeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SendItemsViewHolder(inflate, this.onItemClicked, this.onItemDropped, this.context, this.recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SendItemsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        int roundToInt = MathKt.roundToInt(this.context.getResources().getDisplayMetrics().widthPixels * 0.09d);
        layoutParams.width = roundToInt;
        layoutParams.height = roundToInt;
        holder.itemView.setLayoutParams(layoutParams);
        InventoryItem item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, this.isDragDropEnabled);
    }

    /* compiled from: SendItemsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/adapter/SendItemsAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/trade/presentation/adapter/SendItemsAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/trade/presentation/adapter/SendItemsAdapter$Companion$COMPARATOR$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
