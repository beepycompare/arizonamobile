package com.arizonagames.feature.arizona.bank.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankAccountInfo;
import com.arizonagames.feature.arizona.bank.databinding.BankMainAccountTabItemBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankAccountTabsAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0005J\b\u0010\u001b\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankAccountTabsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/bank/adapters/BankAccountTabsAdapter$BankAccountTabViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "onSelectionChanged", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "accounts", "", "Lcom/arizonagames/feature/arizona/bank/BankAccountInfo;", "selectedAccountId", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "submitList", "items", "selectedId", "setSelectedAccountId", "accountId", "selectedPosition", "BankAccountTabViewHolder", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankAccountTabsAdapter extends RecyclerView.Adapter<BankAccountTabViewHolder> {
    private List<BankAccountInfo> accounts;
    private final Function1<Integer, Unit> onClick;
    private final Function1<Integer, Unit> onSelectionChanged;
    private int selectedAccountId;

    /* JADX WARN: Multi-variable type inference failed */
    public BankAccountTabsAdapter(Function1<? super Integer, Unit> onClick, Function1<? super Integer, Unit> onSelectionChanged) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onSelectionChanged, "onSelectionChanged");
        this.onClick = onClick;
        this.onSelectionChanged = onSelectionChanged;
        this.accounts = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BankAccountTabViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BankMainAccountTabItemBinding inflate = BankMainAccountTabItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BankAccountTabViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BankAccountTabViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BankAccountInfo bankAccountInfo = this.accounts.get(i);
        holder.bind(bankAccountInfo, bankAccountInfo.getId() == this.selectedAccountId, this.onClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.accounts.size();
    }

    public final void submitList(List<BankAccountInfo> items, int i) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.accounts = items;
        this.selectedAccountId = i;
        notifyDataSetChanged();
        this.onSelectionChanged.invoke(Integer.valueOf(selectedPosition()));
    }

    public final void setSelectedAccountId(int i) {
        if (this.selectedAccountId == i) {
            return;
        }
        int selectedPosition = selectedPosition();
        this.selectedAccountId = i;
        int selectedPosition2 = selectedPosition();
        if (selectedPosition != -1) {
            notifyItemChanged(selectedPosition);
        }
        if (selectedPosition2 != -1) {
            notifyItemChanged(selectedPosition2);
        }
        this.onSelectionChanged.invoke(Integer.valueOf(selectedPosition2));
    }

    private final int selectedPosition() {
        Iterator<BankAccountInfo> it = this.accounts.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == this.selectedAccountId) {
                break;
            } else {
                i++;
            }
        }
        Integer valueOf = Integer.valueOf(i);
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return -1;
    }

    /* compiled from: BankAccountTabsAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankAccountTabsAdapter$BankAccountTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankMainAccountTabItemBinding;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankMainAccountTabItemBinding;)V", "bind", "", "item", "Lcom/arizonagames/feature/arizona/bank/BankAccountInfo;", "isSelected", "", "onClick", "Lkotlin/Function1;", "", "buildAccountTitle", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BankAccountTabViewHolder extends RecyclerView.ViewHolder {
        private final BankMainAccountTabItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankAccountTabViewHolder(BankMainAccountTabItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(final BankAccountInfo item, boolean z, final Function1<? super Integer, Unit> onClick) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.binding.bankMainAccountTabText.setText(buildAccountTitle(item));
            this.binding.getRoot().setBackground(-1);
            this.binding.getRoot().setBackgroundAlpha(0);
            this.binding.bankMainAccountTabText.setTextColor(z ? Color.parseColor("#1E1F24") : -1);
            this.binding.getRoot().setAlpha(item.isOpened() ? 1.0f : 0.7f);
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankAccountTabsAdapter$BankAccountTabViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1.this.invoke(Integer.valueOf(item.getId()));
                }
            });
        }

        private final String buildAccountTitle(BankAccountInfo bankAccountInfo) {
            if (bankAccountInfo.getId() == 0) {
                return "Основной счет";
            }
            return "Личный счет #" + bankAccountInfo.getId();
        }
    }
}
