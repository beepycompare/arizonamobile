package ru.mrlargha.commonui.elements.inventory.presentation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: MainInventoryAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder;", "params", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;)V", "isWalletVisible", "", "()Z", "setWalletVisible", "(Z)V", "maxItems", "", "getMaxItems", "()I", "setMaxItems", "(I)V", "submit", "", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "Params", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MainInventoryAdapter extends ListAdapter<InventoryItem, MainInventoryViewHolder> {
    private boolean isWalletVisible;
    private int maxItems;
    private final Params params;
    public static final Companion Companion = new Companion(null);
    private static final MainInventoryAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<InventoryItem>() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(InventoryItem oldItem, InventoryItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getSlot() == newItem.getSlot() && oldItem.getInventoryType() == newItem.getInventoryType();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(InventoryItem oldItem, InventoryItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainInventoryAdapter(Params params) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        this.maxItems = -1;
    }

    public final boolean isWalletVisible() {
        return this.isWalletVisible;
    }

    public final void setWalletVisible(boolean z) {
        this.isWalletVisible = z;
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    public final void setMaxItems(int i) {
        this.maxItems = i;
    }

    public final void submit(List<InventoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = this.maxItems;
        if (size < i) {
            List mutableList = CollectionsKt.toMutableList((Collection) list);
            int size2 = this.maxItems - list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                mutableList.add(ConstantsKt.getEmptyInventoryItem());
            }
            submitList(mutableList);
            int i3 = this.maxItems;
            Log.d("TAG", "no submit: max: " + i3 + " listSize:" + mutableList.size());
            return;
        }
        if (i > 0 && !UtilsKt.isArizonaType()) {
            list = CollectionsKt.take(list, this.maxItems);
        }
        submitList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MainInventoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemInventoryBinding inflate = ItemInventoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MainInventoryViewHolder(inflate, new Params(this.params.getOnItemDropped(), this.params.getRecyclerView(), this.params.getContext(), this.params.getOnLongClicked(), this.params.getOnItemClicked(), this.params.getOnDragPageEdgeChanged()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MainInventoryViewHolder holder, int i) {
        InventoryItem item;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (i < 0 || i >= getItemCount() || (item = getItem(i)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        int roundToInt = MathKt.roundToInt(this.params.getContext().getResources().getDisplayMetrics().widthPixels * 0.09d);
        layoutParams.width = roundToInt;
        layoutParams.height = roundToInt;
        holder.itemView.setLayoutParams(layoutParams);
        holder.bind(item, this.isWalletVisible);
    }

    /* compiled from: MainInventoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Companion$COMPARATOR$1;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: MainInventoryAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003Ju\u0010 \u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;", "", "onItemDropped", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "onLongClicked", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "onItemClicked", "onDragPageEdgeChanged", "", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnItemDropped", "()Lkotlin/jvm/functions/Function1;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getContext", "()Landroid/content/Context;", "getOnLongClicked", "getOnItemClicked", "getOnDragPageEdgeChanged", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Params {
        private final Context context;
        private final Function1<Integer, Unit> onDragPageEdgeChanged;
        private final Function1<InventoryItem, Unit> onItemClicked;
        private final Function1<DraggedItem, Unit> onItemDropped;
        private final Function1<InventoryItem, Unit> onLongClicked;
        private final RecyclerView recyclerView;

        public static /* synthetic */ Params copy$default(Params params, Function1 function1, RecyclerView recyclerView, Context context, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
            Function1<DraggedItem, Unit> function15 = function1;
            if ((i & 1) != 0) {
                function15 = params.onItemDropped;
            }
            if ((i & 2) != 0) {
                recyclerView = params.recyclerView;
            }
            if ((i & 4) != 0) {
                context = params.context;
            }
            Function1<InventoryItem, Unit> function16 = function12;
            if ((i & 8) != 0) {
                function16 = params.onLongClicked;
            }
            Function1<InventoryItem, Unit> function17 = function13;
            if ((i & 16) != 0) {
                function17 = params.onItemClicked;
            }
            Function1<Integer, Unit> function18 = function14;
            if ((i & 32) != 0) {
                function18 = params.onDragPageEdgeChanged;
            }
            Function1 function19 = function17;
            Function1 function110 = function18;
            return params.copy(function15, recyclerView, context, function16, function19, function110);
        }

        public final Function1<DraggedItem, Unit> component1() {
            return this.onItemDropped;
        }

        public final RecyclerView component2() {
            return this.recyclerView;
        }

        public final Context component3() {
            return this.context;
        }

        public final Function1<InventoryItem, Unit> component4() {
            return this.onLongClicked;
        }

        public final Function1<InventoryItem, Unit> component5() {
            return this.onItemClicked;
        }

        public final Function1<Integer, Unit> component6() {
            return this.onDragPageEdgeChanged;
        }

        public final Params copy(Function1<? super DraggedItem, Unit> onItemDropped, RecyclerView recyclerView, Context context, Function1<? super InventoryItem, Unit> onLongClicked, Function1<? super InventoryItem, Unit> onItemClicked, Function1<? super Integer, Unit> onDragPageEdgeChanged) {
            Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onLongClicked, "onLongClicked");
            Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
            Intrinsics.checkNotNullParameter(onDragPageEdgeChanged, "onDragPageEdgeChanged");
            return new Params(onItemDropped, recyclerView, context, onLongClicked, onItemClicked, onDragPageEdgeChanged);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Params) {
                Params params = (Params) obj;
                return Intrinsics.areEqual(this.onItemDropped, params.onItemDropped) && Intrinsics.areEqual(this.recyclerView, params.recyclerView) && Intrinsics.areEqual(this.context, params.context) && Intrinsics.areEqual(this.onLongClicked, params.onLongClicked) && Intrinsics.areEqual(this.onItemClicked, params.onItemClicked) && Intrinsics.areEqual(this.onDragPageEdgeChanged, params.onDragPageEdgeChanged);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.onItemDropped.hashCode() * 31) + this.recyclerView.hashCode()) * 31) + this.context.hashCode()) * 31) + this.onLongClicked.hashCode()) * 31) + this.onItemClicked.hashCode()) * 31) + this.onDragPageEdgeChanged.hashCode();
        }

        public String toString() {
            Function1<DraggedItem, Unit> function1 = this.onItemDropped;
            RecyclerView recyclerView = this.recyclerView;
            Context context = this.context;
            Function1<InventoryItem, Unit> function12 = this.onLongClicked;
            Function1<InventoryItem, Unit> function13 = this.onItemClicked;
            return "Params(onItemDropped=" + function1 + ", recyclerView=" + recyclerView + ", context=" + context + ", onLongClicked=" + function12 + ", onItemClicked=" + function13 + ", onDragPageEdgeChanged=" + this.onDragPageEdgeChanged + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Params(Function1<? super DraggedItem, Unit> onItemDropped, RecyclerView recyclerView, Context context, Function1<? super InventoryItem, Unit> onLongClicked, Function1<? super InventoryItem, Unit> onItemClicked, Function1<? super Integer, Unit> onDragPageEdgeChanged) {
            Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onLongClicked, "onLongClicked");
            Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
            Intrinsics.checkNotNullParameter(onDragPageEdgeChanged, "onDragPageEdgeChanged");
            this.onItemDropped = onItemDropped;
            this.recyclerView = recyclerView;
            this.context = context;
            this.onLongClicked = onLongClicked;
            this.onItemClicked = onItemClicked;
            this.onDragPageEdgeChanged = onDragPageEdgeChanged;
        }

        public final Function1<DraggedItem, Unit> getOnItemDropped() {
            return this.onItemDropped;
        }

        public final RecyclerView getRecyclerView() {
            return this.recyclerView;
        }

        public final Context getContext() {
            return this.context;
        }

        public /* synthetic */ Params(Function1 function1, RecyclerView recyclerView, Context context, Function1 function12, Function1 function13, Function1 function14, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1, recyclerView, context, (i & 8) != 0 ? new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter$Params$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainInventoryAdapter.Params._init_$lambda$0((InventoryItem) obj);
                }
            } : function12, (i & 16) != 0 ? new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter$Params$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainInventoryAdapter.Params._init_$lambda$1((InventoryItem) obj);
                }
            } : function13, (i & 32) != 0 ? new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter$Params$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    ((Integer) obj).intValue();
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : function14);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit _init_$lambda$0(InventoryItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        public final Function1<InventoryItem, Unit> getOnLongClicked() {
            return this.onLongClicked;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit _init_$lambda$1(InventoryItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        public final Function1<InventoryItem, Unit> getOnItemClicked() {
            return this.onItemClicked;
        }

        public final Function1<Integer, Unit> getOnDragPageEdgeChanged() {
            return this.onDragPageEdgeChanged;
        }
    }
}
