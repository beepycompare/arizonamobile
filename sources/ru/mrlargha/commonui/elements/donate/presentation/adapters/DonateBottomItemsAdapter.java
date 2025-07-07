package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonateBottomItemsListBinding;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModel;
/* compiled from: DonateBottomItemsAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter$DonateBottomItemsViewHolder;", "list", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "DonateBottomItemsViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBottomItemsAdapter extends RecyclerView.Adapter<DonateBottomItemsViewHolder> {
    private final List<List<DonateItemModel>> list;

    public final List<List<DonateItemModel>> getList() {
        return this.list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DonateBottomItemsAdapter(List<? extends List<DonateItemModel>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateBottomItemsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonateBottomItemsListBinding inflate = DonateBottomItemsListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DonateBottomItemsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateBottomItemsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(this.list.get(i));
    }

    /* compiled from: DonateBottomItemsAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter$DonateBottomItemsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateBottomItemsListBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/DonateBottomItemsListBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateBottomItemsListBinding;", "itemAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter;", "onBind", "", CommonUrlParts.MODEL, "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DonateBottomItemsViewHolder extends RecyclerView.ViewHolder {
        private final DonateBottomItemsListBinding binding;
        private final DonateBottomItemAdapter itemAdapter;

        public final DonateBottomItemsListBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateBottomItemsViewHolder(DonateBottomItemsListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            DonateBottomItemAdapter donateBottomItemAdapter = new DonateBottomItemAdapter();
            this.itemAdapter = donateBottomItemAdapter;
            binding.rvBottomItems.setAdapter(donateBottomItemAdapter);
        }

        public final void onBind(List<DonateItemModel> model) {
            Intrinsics.checkNotNullParameter(model, "model");
            DonateBottomItemsListBinding donateBottomItemsListBinding = this.binding;
            int size = model.size();
            Log.i("donate", "onBind: size=" + size + " " + getPosition());
            donateBottomItemsListBinding.tvId.setText(String.valueOf(getPosition()));
            this.itemAdapter.submitList(model);
        }
    }
}
