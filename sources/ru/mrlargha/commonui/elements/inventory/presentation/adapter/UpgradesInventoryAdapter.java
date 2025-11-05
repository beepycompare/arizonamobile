package ru.mrlargha.commonui.elements.inventory.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder;
/* compiled from: UpgradesInventoryAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 BU\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001cH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/UpgradesInventoryViewHolder;", "type", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion$Type;", "onItemDropped", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "", "context", "Landroid/content/Context;", "onLongClicked", "onItemClicked", "<init>", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion$Type;Lkotlin/jvm/functions/Function1;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getType", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion$Type;", "getOnItemDropped", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "getOnLongClicked", "getOnItemClicked", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UpgradesInventoryAdapter extends ListAdapter<InventoryItem, UpgradesInventoryViewHolder> {
    private final Context context;
    private final Function1<InventoryItem, Unit> onItemClicked;
    private final Function1<DraggedItem, Unit> onItemDropped;
    private final Function1<InventoryItem, Unit> onLongClicked;
    private final Companion.Type type;
    public static final Companion Companion = new Companion(null);
    private static final UpgradesInventoryAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<InventoryItem>() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.UpgradesInventoryAdapter$Companion$COMPARATOR$1
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

    public /* synthetic */ UpgradesInventoryAdapter(Companion.Type type, Function1 function1, Context context, Function1 function12, Function1 function13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.Type.NONE : type, function1, context, function12, function13);
    }

    public final Companion.Type getType() {
        return this.type;
    }

    public final Function1<DraggedItem, Unit> getOnItemDropped() {
        return this.onItemDropped;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<InventoryItem, Unit> getOnLongClicked() {
        return this.onLongClicked;
    }

    public final Function1<InventoryItem, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UpgradesInventoryAdapter(Companion.Type type, Function1<? super DraggedItem, Unit> onItemDropped, Context context, Function1<? super InventoryItem, Unit> onLongClicked, Function1<? super InventoryItem, Unit> onItemClicked) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onLongClicked, "onLongClicked");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.type = type;
        this.onItemDropped = onItemDropped;
        this.context = context;
        this.onLongClicked = onLongClicked;
        this.onItemClicked = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UpgradesInventoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Companion.Type type = this.type;
        ItemSubInventoryBinding inflate = ItemSubInventoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new UpgradesInventoryViewHolder(type, inflate, this.onItemDropped, this.onLongClicked, this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(UpgradesInventoryViewHolder holder, int i) {
        InventoryItem item;
        Intrinsics.checkNotNullParameter(holder, "holder");
        synchronized (this) {
            try {
                ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
                int roundToInt = MathKt.roundToInt(this.context.getResources().getDisplayMetrics().widthPixels * 0.09d);
                layoutParams.width = roundToInt;
                layoutParams.height = roundToInt;
                holder.itemView.setLayoutParams(layoutParams);
                if (i < getItemCount()) {
                    InventoryItem item2 = getItem(i);
                    if (item2 != null) {
                        holder.bind(item2);
                    }
                } else if (getItemCount() != 0 && (item = getItem(0)) != null) {
                    holder.bind(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* compiled from: UpgradesInventoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion$COMPARATOR$1;", "Type", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: UpgradesInventoryAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter$Companion$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ACCESS", "NONE", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Type {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;
            public static final Type ACCESS = new Type("ACCESS", 0);
            public static final Type NONE = new Type("NONE", 1);

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{ACCESS, NONE};
            }

            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            private Type(String str, int i) {
            }

            static {
                Type[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }
    }
}
