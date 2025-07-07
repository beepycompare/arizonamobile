package ru.mrlargha.commonui.elements.inventory.presentation.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemCategoryMenuBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryMenuData;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.InventoryMenuAdapter;
/* compiled from: InventoryMenuAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryMenuData;", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter$InventoryMenuViewHolder;", "onItemClicked", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "selectItemPosition", "", "resetSelectItemPosition", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "InventoryMenuViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryMenuAdapter extends ListAdapter<InventoryMenuData, InventoryMenuViewHolder> {
    private static final int DEFAULT_POSITION = 0;
    private final Function1<InventoryMenuData, Unit> onItemClicked;
    private int selectItemPosition;
    public static final Companion Companion = new Companion(null);
    private static final InventoryMenuAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<InventoryMenuData>() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.InventoryMenuAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(InventoryMenuData oldItem, InventoryMenuData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getMenuId() == newItem.getMenuId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(InventoryMenuData oldItem, InventoryMenuData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InventoryMenuAdapter(Function1<? super InventoryMenuData, Unit> onItemClicked) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
    }

    public final void resetSelectItemPosition() {
        Log.e("inventory", "resetSelectItemPosition: ");
        this.selectItemPosition = 0;
    }

    /* compiled from: InventoryMenuAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter$InventoryMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemCategoryMenuBinding;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter;Lru/mrlargha/commonui/databinding/ItemCategoryMenuBinding;)V", "bind", "", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryMenuData;", "position", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class InventoryMenuViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryMenuBinding binding;
        final /* synthetic */ InventoryMenuAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InventoryMenuViewHolder(InventoryMenuAdapter inventoryMenuAdapter, ItemCategoryMenuBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = inventoryMenuAdapter;
            this.binding = binding;
        }

        public final void bind(final InventoryMenuData item, final int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            ItemCategoryMenuBinding itemCategoryMenuBinding = this.binding;
            final InventoryMenuAdapter inventoryMenuAdapter = this.this$0;
            itemCategoryMenuBinding.btnText.setText(item.getName());
            itemCategoryMenuBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.InventoryMenuAdapter$InventoryMenuViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InventoryMenuAdapter.InventoryMenuViewHolder.bind$lambda$1$lambda$0(InventoryMenuAdapter.this, i, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1$lambda$0(InventoryMenuAdapter inventoryMenuAdapter, int i, InventoryMenuData inventoryMenuData, View view) {
            if (inventoryMenuAdapter.selectItemPosition != i) {
                Log.e("inventory", "click on category " + inventoryMenuAdapter.selectItemPosition + " " + i);
                inventoryMenuAdapter.onItemClicked.invoke(inventoryMenuData);
                inventoryMenuAdapter.selectItemPosition = i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public InventoryMenuViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemCategoryMenuBinding inflate = ItemCategoryMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new InventoryMenuViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(InventoryMenuViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        InventoryMenuData item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, i);
    }

    /* compiled from: InventoryMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter$Companion$COMPARATOR$1;", "DEFAULT_POSITION", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
