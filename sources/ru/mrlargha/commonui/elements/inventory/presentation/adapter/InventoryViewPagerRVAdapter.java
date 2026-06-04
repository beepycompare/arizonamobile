package ru.mrlargha.commonui.elements.inventory.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.InventorySectionRvItemBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: InventoryViewPagerRVAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001dH\u0016J\n\u0010#\u001a\u00020\u0006*\u00020\u0006J\n\u0010#\u001a\u00020\f*\u00020\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R<\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00122\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryViewPagerRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "upgradesAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "getUpgradesAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "setUpgradesAdapter", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;)V", "subAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "getSubAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "setSubAdapter", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;)V", "value", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "clone", "ViewPagerRVViewHolder", "ViewPagerSubRVViewHolder", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryViewPagerRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<? extends List<InventoryItem>> list = CollectionsKt.emptyList();
    private SubInventoryAdapter subAdapter;
    private UpgradesInventoryAdapter upgradesAdapter;

    public final UpgradesInventoryAdapter getUpgradesAdapter() {
        return this.upgradesAdapter;
    }

    public final void setUpgradesAdapter(UpgradesInventoryAdapter upgradesInventoryAdapter) {
        this.upgradesAdapter = upgradesInventoryAdapter;
    }

    public final SubInventoryAdapter getSubAdapter() {
        return this.subAdapter;
    }

    public final void setSubAdapter(SubInventoryAdapter subInventoryAdapter) {
        this.subAdapter = subInventoryAdapter;
    }

    public final List<List<InventoryItem>> getList() {
        return this.list;
    }

    public final void setList(final List<? extends List<InventoryItem>> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        final List<? extends List<InventoryItem>> list = this.list;
        this.list = value;
        if (list.isEmpty()) {
            notifyDataSetChanged();
            return;
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.adapter.InventoryViewPagerRVAdapter$list$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                return i == i2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return list.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return value.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                return Intrinsics.areEqual(list.get(i), value.get(i2));
            }
        });
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(...)");
        calculateDiff.dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventorySectionRvItemBinding inflate = InventorySectionRvItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        UpgradesInventoryAdapter upgradesInventoryAdapter = this.upgradesAdapter;
        if (upgradesInventoryAdapter != null) {
            return new ViewPagerRVViewHolder(this, inflate, upgradesInventoryAdapter != null ? clone(upgradesInventoryAdapter) : null);
        }
        SubInventoryAdapter subInventoryAdapter = this.subAdapter;
        return new ViewPagerSubRVViewHolder(this, inflate, subInventoryAdapter != null ? clone(subInventoryAdapter) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ViewPagerRVViewHolder) {
            ((ViewPagerRVViewHolder) holder).onBind(this.list.get(i), i);
        } else if (holder instanceof ViewPagerSubRVViewHolder) {
            ((ViewPagerSubRVViewHolder) holder).onBind(this.list.get(i), i);
        }
    }

    /* compiled from: InventoryViewPagerRVAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryViewPagerRVAdapter$ViewPagerRVViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/InventorySectionRvItemBinding;", "itemAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryViewPagerRVAdapter;Lru/mrlargha/commonui/databinding/InventorySectionRvItemBinding;Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/InventorySectionRvItemBinding;", "onBind", "", CommonUrlParts.MODEL, "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "position", "", "(Ljava/util/List;I)Lkotlin/Unit;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ViewPagerRVViewHolder extends RecyclerView.ViewHolder {
        private final InventorySectionRvItemBinding binding;
        private final UpgradesInventoryAdapter itemAdapter;
        final /* synthetic */ InventoryViewPagerRVAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewPagerRVViewHolder(InventoryViewPagerRVAdapter inventoryViewPagerRVAdapter, InventorySectionRvItemBinding binding, UpgradesInventoryAdapter upgradesInventoryAdapter) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = inventoryViewPagerRVAdapter;
            this.binding = binding;
            this.itemAdapter = upgradesInventoryAdapter;
            binding.rv.setAdapter(upgradesInventoryAdapter);
        }

        public final InventorySectionRvItemBinding getBinding() {
            return this.binding;
        }

        public final Unit onBind(List<InventoryItem> model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            UpgradesInventoryAdapter upgradesInventoryAdapter = this.itemAdapter;
            if (upgradesInventoryAdapter != null) {
                upgradesInventoryAdapter.submitList(model);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: InventoryViewPagerRVAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryViewPagerRVAdapter$ViewPagerSubRVViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/InventorySectionRvItemBinding;", "itemAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryViewPagerRVAdapter;Lru/mrlargha/commonui/databinding/InventorySectionRvItemBinding;Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/InventorySectionRvItemBinding;", "onBind", "", CommonUrlParts.MODEL, "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "position", "", "(Ljava/util/List;I)Lkotlin/Unit;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ViewPagerSubRVViewHolder extends RecyclerView.ViewHolder {
        private final InventorySectionRvItemBinding binding;
        private final SubInventoryAdapter itemAdapter;
        final /* synthetic */ InventoryViewPagerRVAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewPagerSubRVViewHolder(InventoryViewPagerRVAdapter inventoryViewPagerRVAdapter, InventorySectionRvItemBinding binding, SubInventoryAdapter subInventoryAdapter) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = inventoryViewPagerRVAdapter;
            this.binding = binding;
            this.itemAdapter = subInventoryAdapter;
            binding.rv.setAdapter(subInventoryAdapter);
        }

        public final InventorySectionRvItemBinding getBinding() {
            return this.binding;
        }

        public final Unit onBind(List<InventoryItem> model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            SubInventoryAdapter subInventoryAdapter = this.itemAdapter;
            if (subInventoryAdapter != null) {
                subInventoryAdapter.submitList(model);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    public final UpgradesInventoryAdapter clone(UpgradesInventoryAdapter upgradesInventoryAdapter) {
        Intrinsics.checkNotNullParameter(upgradesInventoryAdapter, "<this>");
        return new UpgradesInventoryAdapter(upgradesInventoryAdapter.getType(), upgradesInventoryAdapter.getOnItemDropped(), upgradesInventoryAdapter.getContext(), upgradesInventoryAdapter.getOnLongClicked(), upgradesInventoryAdapter.getOnItemClicked());
    }

    public final SubInventoryAdapter clone(SubInventoryAdapter subInventoryAdapter) {
        Intrinsics.checkNotNullParameter(subInventoryAdapter, "<this>");
        return new SubInventoryAdapter(subInventoryAdapter.getOnItemDropped(), subInventoryAdapter.getContext(), subInventoryAdapter.getOnLongClicked(), subInventoryAdapter.getOnItemClicked());
    }
}
