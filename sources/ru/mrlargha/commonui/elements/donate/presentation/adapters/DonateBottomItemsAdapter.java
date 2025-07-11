package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonateBottomItemsListBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemsAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
/* compiled from: DonateBottomItemsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB>\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001c\u0010\u0018\u001a\u00020\f2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter$DonateBottomItemsViewHolder;", "list", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getList", "()Ljava/util/List;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "DonateBottomItemsViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBottomItemsAdapter extends RecyclerView.Adapter<DonateBottomItemsViewHolder> {
    private final List<List<DonateItemModelUi>> list;
    private final Function1<Integer, Unit> onClick;

    public final List<List<DonateItemModelUi>> getList() {
        return this.list;
    }

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DonateBottomItemsAdapter(List<? extends List<DonateItemModelUi>> list, Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.list = list;
        this.onClick = onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateBottomItemsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonateBottomItemsListBinding inflate = DonateBottomItemsListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DonateBottomItemsViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateBottomItemsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(this.list.get(i), i);
    }

    /* compiled from: DonateBottomItemsAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter$DonateBottomItemsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateBottomItemsListBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemsAdapter;Lru/mrlargha/commonui/databinding/DonateBottomItemsListBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateBottomItemsListBinding;", "itemAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter;", "onBind", "", CommonUrlParts.MODEL, "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "position", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonateBottomItemsViewHolder extends RecyclerView.ViewHolder {
        private final DonateBottomItemsListBinding binding;
        private final DonateBottomItemAdapter itemAdapter;
        final /* synthetic */ DonateBottomItemsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateBottomItemsViewHolder(final DonateBottomItemsAdapter donateBottomItemsAdapter, DonateBottomItemsListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateBottomItemsAdapter;
            this.binding = binding;
            DonateBottomItemAdapter donateBottomItemAdapter = new DonateBottomItemAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemsAdapter$DonateBottomItemsViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit itemAdapter$lambda$0;
                    itemAdapter$lambda$0 = DonateBottomItemsAdapter.DonateBottomItemsViewHolder.itemAdapter$lambda$0(DonateBottomItemsAdapter.this, ((Integer) obj).intValue());
                    return itemAdapter$lambda$0;
                }
            });
            this.itemAdapter = donateBottomItemAdapter;
            binding.rvBottomItems.setAdapter(donateBottomItemAdapter);
        }

        public final DonateBottomItemsListBinding getBinding() {
            return this.binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit itemAdapter$lambda$0(DonateBottomItemsAdapter donateBottomItemsAdapter, int i) {
            donateBottomItemsAdapter.getOnClick().invoke(Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        public final void onBind(List<DonateItemModelUi> model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            this.itemAdapter.submitList(model);
        }
    }
}
